package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class that defines the Template Method pattern for report generation.
 * The fixed workflow is: loadData -> formatHeader -> formatBody -> formatFooter -> generateReport.
 * Subclasses must implement the variable steps.
 */
public abstract class Report {

    /**
     * Template method — defines the fixed report-generation workflow.
     * This method is final so subclasses cannot alter the sequence.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println();
        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println();
        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
        System.out.println();
    }

    /** Loads the data needed by this report. Subclasses set their specific fields here. */
    protected abstract void loadData();

    /** Returns the formatted header string for this report. */
    protected abstract String formatHeader();

    /** Returns the formatted body string for this report. */
    protected abstract String formatBody();

    /** Returns the formatted footer string for this report. */
    protected abstract String formatFooter();
}
