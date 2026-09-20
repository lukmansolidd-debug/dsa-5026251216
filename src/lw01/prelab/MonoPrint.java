package lw01.prelab;

public class MonoPrint extends PrintJob {

    public MonoPrint(String id, int pages) {
        super(id, pages, "Mono");
    }

    @Override
    public int calculateCharge() {
        return pages * 500;
    }
}