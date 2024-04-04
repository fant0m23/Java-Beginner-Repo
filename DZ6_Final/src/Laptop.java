import java.util.Objects;

public class Laptop {
    private String brand;
    private int sizeRAM;
    private int sizeROM;
    private double displayDiagonal;
    private String os;
    private String caseColor;

    public Laptop(String brand, double displayDiagonal, int sizeRAM, int sizeROM,
                  String os, String caseColor) {
        this.brand = brand;
        this.displayDiagonal = displayDiagonal;
        this.sizeRAM = sizeRAM;
        this.sizeROM = sizeROM;
        this.os = os;
        this.caseColor = caseColor;
    }

    public String getBrand() {
        return brand;
    }

    public double getDisplayDiagonal() {
        return displayDiagonal;
    }

    public int getSizeRAM() {
        return sizeRAM;
    }

    public int getSizeROM() {
        return sizeROM;
    }

    public String getOS() {
        return os;
    }

    public String getCaseColor() {
        return caseColor;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDisplayDiagonal(double displayDiagonal) {
        this.displayDiagonal = displayDiagonal;
    }

    public void setSizeRAM(int sizeRAM) {
        this.sizeRAM = sizeRAM;
    }

    public void setSizeROM(int sizeROM) {
        this.sizeROM = sizeROM;
    }

    public void setOS(String os) {
        this.os = os;
    }

    public void setCaseColor(String caseColor) {
        this.caseColor = caseColor;
    }

    @Override
    public String toString() {
        return String.format("Ноутбук %s %3.1f\", RAM %dGb, SDD %dGb, %s, цвет %s",
                brand, displayDiagonal, sizeRAM, sizeROM, os, caseColor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return brand.equals(laptop.brand) && displayDiagonal == laptop.displayDiagonal
                && sizeRAM == laptop.sizeRAM && sizeROM == laptop.sizeROM &&
                os.equals(laptop.os) && caseColor.equals(laptop.caseColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, displayDiagonal, sizeRAM, sizeROM, os, caseColor);
    }
}
