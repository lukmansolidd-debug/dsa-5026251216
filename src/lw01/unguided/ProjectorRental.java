package lw01.unguided;

public class ProjectorRental extends Rental {

    public ProjectorRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        if (getDays() <= 3) {
            return (getDays() * 60000) + 20000;
        } else {
            return (3 * 60000) + ((getDays() - 3) * 45000) + 20000;
        }
    }

    @Override
    public String label() {
        return "Projector";
    }
}