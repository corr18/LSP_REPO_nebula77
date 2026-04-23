package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a course, providing course-specific implementations
 * of the abstract steps defined in Report.
 */
public class CourseReport extends Report {

    /** The course name, set in loadData(). */
    private String courseName;

    /** The course enrollment count, set in loadData(). */
    private int enrollment;

    /**
     * Loads hardcoded course data.
     */
    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    /**
     * Returns the header for the course report.
     * @return "Course Report"
     */
    @Override
    protected String formatHeader() {
        return "Course Report";
    }

    /**
     * Returns the body showing course name and enrollment.
     * @return formatted body text
     */
    @Override
    protected String formatBody() {
        return "Course: " + courseName + "\nEnrollment: " + enrollment;
    }

    /**
     * Returns the footer for the course report.
     * @return "End of Course Report"
     */
    @Override
    protected String formatFooter() {
        return "End of Course Report";
    }
}
