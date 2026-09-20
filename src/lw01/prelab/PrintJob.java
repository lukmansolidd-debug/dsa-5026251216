package lw01.prelab;

public abstract class PrintJob implements Chargeable {

    protected String id;
    protected int pages;
    protected String label;

    public PrintJob(String id, int pages, String label) {

        // Validasi ID
        if (id == null || id.isEmpty() || !id.matches("P\\d+")) {
            throw new IllegalArgumentException("Invalid ID");
        }

        // Validasi jumlah halaman
        if (pages <= 0) {
            throw new IllegalArgumentException("Pages must be positive");
        }

        this.id = id;
        this.pages = pages;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }

    public String getLabel() {
        return label;
    }

    // Overloading
    public int calculateCharge(int copies) {
        return copies * calculateCharge();
    }

    public String summary() {
        return id + " | " + label + " | " + calculateCharge();
    }
}