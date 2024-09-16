package bean;

public class Challan {
    private int cid;
    private String cDate;
    private String cRemarks;
    private double cAmount;

    public Challan(int cid, String cDate, String cRemarks, double cAmount) {
        this.cid = cid;
        this.cDate = cDate;
        this.cRemarks = cRemarks;
        this.cAmount = cAmount;
    }

    public Challan() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public String getcRemarks() {
        return cRemarks;
    }

    public void setcRemarks(String cRemarks) {
        this.cRemarks = cRemarks;
    }

    public double getcAmount() {
        return cAmount;
    }

    public void setcAmount(double cAmount) {
        this.cAmount = cAmount;
    }

    @Override
    public String toString() {
        return "Challan{" +
                "cid=" + cid +
                ", cDate='" + cDate + '\'' +
                ", cRemarks='" + cRemarks + '\'' +
                ", cAmount=" + cAmount +
                '}';
    }
}
