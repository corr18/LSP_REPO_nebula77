package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a Task in the Task Management System.
 * @author Caleb Orr
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with default status OPEN.
     * @param taskId the task ID
     * @param description the task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     * @return taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the task status.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status.
     * If invalid, sets status to UNKNOWN.
     * @param status new status
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns formatted task string.
     * @return formatted string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}