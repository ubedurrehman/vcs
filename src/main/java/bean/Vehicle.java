package bean;

public class Vehicle {


        private int vId;
        private String vRegister;
        private String vMake;
        private String vEngineType;
        private String vFuelType;
        private String vColor;


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
