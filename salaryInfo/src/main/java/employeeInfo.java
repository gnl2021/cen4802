import org.apache.commons.validator.EmailValidator;

public class employeeInfo {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int monthlySalary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public employeeInfo(String firstName, String lastName, String phoneNumber, String email, int monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email=email;
        this.monthlySalary = monthlySalary;
    }

    public void validateFirstName(){
        if (this.firstName.isBlank())
            throw new RuntimeException("First Name cannot be null or empty");
    }
    public void validateLastName(){
        if (this.lastName.isBlank())
            throw new RuntimeException("Last Name cannot be null or empty");
    }
    public void validatePhoneNumber(){
        if (this.phoneNumber.isBlank())
            throw new RuntimeException("Phone Number cannot be null or empty");
        if(this.phoneNumber.length()!=10)
            throw new RuntimeException("Phone Number should be 10 digit long");
        if(!this.phoneNumber.matches("\\d+"))
            throw new RuntimeException("Phone Number should contain only digit");
        if (this.phoneNumber.startsWith("0")) {
            throw new RuntimeException("Phone number should not start with 0");
        }
    }

    public void validateEmail(){
        if (this.email.isBlank())
            throw new RuntimeException("E-mail cannot be null or empty");
        if(!EmailValidator.getInstance().isValid(this.email))
            throw new RuntimeException("E-mail is not valid");;
    }

    public void validateMonthlySalary() {
        if (this.monthlySalary<2400)
            throw new RuntimeException("The minimum monthly salary is 2400/month");

    }


}
