package lw01.prelab;

public class ColourPrint extends PrintJob {

    public ColourPrint(String id, int pages) {
        super(id, pages, "Colour");
    }

    @Override
    public int calculateCharge() {
        if (pages <= 10) {
            return pages * 1500 + 2000;
        } else {
            return (10 * 1500) + ((pages - 10) * 1000) + 2000;
        }
    }
}