package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a student, providing student-specific implementations
 * of the abstract steps defined in Report.
 */
public class StudentReport extends Report {

    /** The student's full name, set in loadData(). */
    private String studentName;

    /** The student's GPA, set in loadData(). */
    private double gpa;

    /**
     * Loads hardcoded student data.
     */
    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    /**
     * Returns the header for the student report.
     * @return "Student Report"
     */
    @Override
    protected String formatHeader() {
        return "Student Report";
    }

    /**
     * Returns the body showing student name and GPA.
     * @return formatted body text
     */
    @Override
    protected String formatBody() {
        return "Student Name: " + studentName + "\nGPA: " + gpa;
    }

    /**
     * Returns the footer for the student report.
     * @return "End of Student Report"
     */
    @Override
    protected String formatFooter() {
        return "End of Student Report";
    }
}
