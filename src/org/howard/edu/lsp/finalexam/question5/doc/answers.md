# Question 5 – Arthur Riel's OO Design Heuristics

---

## Heuristic 1

**Name:**
H2.1 – All data should be hidden within its class.

**Explanation:**
This heuristic means all instance variables should be declared `private` and accessed only through well-defined methods. In lecture, the professor noted that this heuristic is the basis of many coding standards documents — specifically the rule "make all data attributes private." When data is publicly exposed, external classes can read and write it freely, making it impossible to enforce invariants and breaking encapsulation. Hiding data inside the class means only that class controls how its state changes, which makes bugs easier to isolate and allows the internal representation to change without breaking callers.

---

## Heuristic 2

**Name:**
H3.2 – Do not create god classes/objects in your system.

**Explanation:**
A god class is one that controls too much of the system — either holding too much of the system's logic (a behavioral god class, often named with "System" or "Manager") or too much of the system's data (a data god class with many access/search methods). In lecture, the professor i
git add src/org/howard/edu/lsp/finalexam/
git commit -m "Final exam: Q1-Q5 complete"
git push




cd path/to/LSP_REPO_nebula77

