# Question 1 – Answers

## Part 1: Shared Resources and Risk

**Shared Resource #1:** `nextId` — an instance variable read and incremented by multiple threads calling `getNextId()`.

**Shared Resource #2:** `requests` — an `ArrayList` that multiple threads may add entries to simultaneously via `addRequest()`.

**Concurrency Problem:**
A race condition. Two threads can read the same value of `nextId` before either increments it, resulting in duplicate request IDs. Similarly, two threads can call `requests.add()` concurrently on the non-thread-safe `ArrayList`, corrupting its internal state.

**Why `addRequest()` is unsafe:**
`addRequest()` is a compound action: it calls `getNextId()` (read + increment of `nextId`) and then calls `requests.add()`. Neither the shared counter nor the list is protected. Without synchronization, two threads can interleave these steps — both getting the same ID and/or both writing to the list at the same time — producing duplicate IDs and potential `ArrayList` corruption.

---

## Part 2: Evaluate Fixes

**Fix A: `public synchronized int getNextId() { ... }`**
**Incorrect.** Synchronizing only `getNextId()` protects the counter in isolation, but `addRequest()` itself is not synchronized. Two threads can still interleave inside `addRequest()`: thread 1 gets an ID, then thread 2 gets the next ID, then both call `requests.add()` concurrently on the unsynchronized `ArrayList`, which is not thread-safe. The list corruption problem remains.

**Fix B: `public synchronized void addRequest(String studentName) { ... }`**
**Correct.** Synchronizing `addRequest()` ensures that only one thread at a time can execute the entire compound action — getting the next ID and adding to the list. Since `getNextId()` is only called from within `addRequest()`, the lock held on `addRequest()` prevents any other thread from entering and interleaving. Both shared resources (`nextId` and `requests`) are protected as a single atomic unit.

**Fix C: `public synchronized List<String> getRequests() { ... }`**
**Incorrect.** Synchronizing only the getter protects reads of the list reference, but does nothing to protect `nextId` or the `requests.add()` calls inside `addRequest()`. The race condition on the counter and the concurrent list writes are completely unaddressed.

---

## Part 3: Object-Oriented Design

**Should `getNextId()` be public?**
No.

**Explanation:**
According to Arthur Riel's heuristics, a class should hide its implementation details — only behavior that is part of the public interface should be exposed. `getNextId()` is an internal bookkeeping method that exists solely to support `addRequest()`. Exposing it publicly breaks encapsulation: external callers could call it arbitrarily, skipping IDs, disturbing the counter's state, and making the class harder to reason about. It should be `private` so that ID generation is entirely controlled by `addRequest()`.

---

## Part 4: Alternative Synchronization Approach

**Description:**
The alternative approach discussed in lecture is using `java.util.concurrent` atomic classes and thread-safe collections — specifically `AtomicInteger` for the counter and `CopyOnWriteArrayList` for the list. `AtomicInteger` provides lock-free, thread-safe increment-and-get operations using hardware-level compare-and-swap instructions, eliminating race conditions on `nextId` without the `synchronized` keyword. A thread-safe list wrapper ensures that `add()` calls are also safe under concurrent access.

**Code Snippet:**

```java
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestManager {
    private AtomicInteger nextId = new AtomicInteger(1);
    private List<String> requests = new CopyOnWriteArrayList<>();

    public void addRequest(String studentName) {
        int id = nextId.getAndIncrement();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    }

    public List<String> getRequests() {
        return requests;
    }
}
```
