package bean;

public class Owner {
    private int oId;
    private String oName;
    private String oCnic;
    private String oFatherName;
    private String oRemarks;

    public Owner(int oId, String oName, String oCnic, String oFatherName, String oRemarks) {
        this.oId = oId;
        this.oName = oName;
        this.oCnic = oCnic;
        this.oFatherName = oFatherName;
        this.oRemarks = oRemarks;
    }

    public Owner() {
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public String getoCnic() {
        return oCnic;
    }

    public void setoCnic(String oCnic) {
        this.oCnic = oCnic;
    }

    public String getoFatherName() {
        return oFatherName;
    }

    public void setoFatherName(String oFatherName) {
        this.oFatherName = oFatherName;
    }

    public String getoRemarks() {
        return oRemarks;
    }

    public void setoRemarks(String oRemarks) {
        this.oRemarks = oRemarks;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "oId=" + oId +
                ", oName='" + oName + '\'' +
                ", oCnic='" + oCnic + '\'' +
                ", oFatherName='" + oFatherName + '\'' +
                ", oRemarks='" + oRemarks + '\'' +
                '}';
    }
}
