package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages a collection of Task objects.
 * @author Caleb Orr
 */
public class TaskManager {

    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a task to the manager.
     * Throws exception if duplicate ID.
     * @param task the task to add
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by ID.
     * @param taskId the ID to search
     * @return Task or null
     */
    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    /**
     * Returns tasks matching a status.
     * @param status the status to filter
     * @return list of matching tasks
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }
        return result;
    }
}