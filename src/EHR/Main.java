package EHR;


enum PatientStatus {
    ADMITTED,
    DISCHARGED,
    UNDER_OBSERVATION,
    DECEASED
};
class Patient extends Person{

    private int recordNo;
    private String role;
    private PatientStatus status;


    public Patient(String name, String gender, int age, int recordNo, String role, PatientStatus status) {
        super(name, age, gender);
        this.recordNo = recordNo;
        this.role = role;
        this.status = status;
    }

    @Override
    public int getIdentifier() {
        return this.recordNo;
    }

    @Override
    public boolean validate() {
        return true;
    }

    public int getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(int recordNo) {
        this.recordNo = recordNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public void printStatus() {

        switch(this.status) {
            case ADMITTED:
                System.out.println(this.getName() + " is " + this.status);
                break;
                
            case DISCHARGED:
                System.out.println(this.getName() + " is " + this.status);
                break;

            case UNDER_OBSERVATION:
                System.out.println(this.getName() + " is " + this.status);
                break;

            case DECEASED:
                System.out.println(this.getName() + " is " + this.status);
                break;

            default:
                System.out.println("No status");
                break;
        }
    }



}

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("elango", "male", 21, 12312, "Patient", PatientStatus.ADMITTED);

        patient.printStatus();
    }
}



