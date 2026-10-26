public class EBook extends LibraryItem{
    private double sizeGB;

    public EBook(String id, String title, double sizeGB) {
        super(id, title);
        this.sizeGB = sizeGB;
    }

    public double getSizeGB() {
        return sizeGB;
    }

    @Override
    String getType() {
        return "电子书";
    }
}
