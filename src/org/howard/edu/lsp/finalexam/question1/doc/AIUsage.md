# AI Usage – Question 1

**AI Tools Used:** Claude (Anthropic)

**Prompts Used:**
1. Explain what shared resources exist in a RequestManager class with a counter and ArrayList.
2. What concurrency problems arise when multiple threads call addRequest() without synchronization?
3. Evaluate whether synchronizing only getNextId(), only addRequest(), or only getRequests() correctly fixes the race condition.
4. Show how AtomicInteger and CopyOnWriteArrayList can replace synchronized to make addRequest() thread-safe.

**How AI Helped:**
AI helped clarify why Fix B is the only correct solution by reasoning through the compound-action nature of `addRequest()`. It also provided a clean code example using `AtomicInteger` and `CopyOnWriteArrayList` that demonstrates the `java.util.concurrent` approach covered in lecture.

**Reflection:**
I learned that synchronizing individual helper methods is insufficient when the real risk is interleaving across a compound operation — the lock must cover the entire unit of work.
