package org.howard.edu.lsp.midterm.crccards;

public class Driver {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task t1 = new Task("1", "Finish midterm");
        Task t2 = new Task("2", "Study for exam");

        manager.addTask(t1);
        manager.addTask(t2);

        t1.setStatus("IN_PROGRESS");
        t2.setStatus("COMPLETE");

        System.out.println(manager.findTask("1"));
        System.out.println(manager.findTask("2"));
    }
}