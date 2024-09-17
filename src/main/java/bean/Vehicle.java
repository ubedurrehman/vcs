package bean;

public class Vehicle {


        private int vId;
        private String vRegister;
        private String vMake;
        private String vEngineType;
        private String vFuelType;
        private String vColor;

     private   int ownerId;

    public int getvId() {
        return vId;
    }

    public void setvId(int vId) {
        this.vId = vId;
    }

    public String getvRegister() {
        return vRegister;
    }

    public void setvRegister(String vRegister) {
        this.vRegister = vRegister;
    }

    public String getvMake() {
        return vMake;
    }

    public void setvMake(String vMake) {
        this.vMake = vMake;
    }

    public String getvEngineType() {
        return vEngineType;
    }

    public void setvEngineType(String vEngineType) {
        this.vEngineType = vEngineType;
    }

    public String getvFuelType() {
        return vFuelType;
    }

    public void setvFuelType(String vFuelType) {
        this.vFuelType = vFuelType;
    }

    public String getvColor() {
        return vColor;
    }

    public void setvColor(String vColor) {
        this.vColor = vColor;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Vehicle(int vId, String vRegister, String vMake, String vEngineType, String vFuelType, String vColor) {
            this.vId = vId;
            this.vRegister = vRegister;
            this.vMake = vMake;
            this.vEngineType = vEngineType;
            this.vFuelType = vFuelType;
            this.vColor = vColor;
        }


        public Vehicle() {
        }


        public int getVId() {
            return vId;
        }

        public void setVId(int vId) {
            this.vId = vId;
        }


        public String getVRegister() {
            return vRegister;
        }

        public void setVRegister(String vRegister) {
            this.vRegister = vRegister;
        }


        public String getVMake() {
            return vMake;
        }

        public void setVMake(String vMake) {
            this.vMake = vMake;
        }


        public String getVEngineType() {
            return vEngineType;
        }

        public void setVEngineType(String vEngineType) {
            this.vEngineType = vEngineType;
        }


        public String getVFuelType() {
            return vFuelType;
        }

        public void setVFuelType(String vFuelType) {
            this.vFuelType = vFuelType;
        }


        public String getVColor() {
            return vColor;
        }

        public void setVColor(String vColor) {
            this.vColor = vColor;
        }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vId=" + vId +
                ", vRegister='" + vRegister + '\'' +
                ", vMake='" + vMake + '\'' +
                ", vEngineType='" + vEngineType + '\'' +
                ", vFuelType='" + vFuelType + '\'' +
                ", vColor='" + vColor + '\'' +
                '}';
    }


}
