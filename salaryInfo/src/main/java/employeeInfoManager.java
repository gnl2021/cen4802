import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class employeeInfoManager {
    Map<String, employeeInfo> employeeList = new ConcurrentHashMap<String, employeeInfo>();

    public Collection<employeeInfo> getEmployeeList(){return employeeList.values();}

    public void addEmployee(String firstName, String lastName, String phoneNumber, String email, int salary){
        employeeInfo employee = new employeeInfo(firstName, lastName, phoneNumber, email,  salary);
        validateEmployeeInfo(employee);
        checkIfEmployeeInfoAlreadyExist(employee);
        employeeList.put(empKey(employee), employee);

    }
    private void validateEmployeeInfo(employeeInfo employee){
        employee.validateFirstName();
        employee.validateLastName();
        employee.validatePhoneNumber();
        employee.validateEmail();
        employee.validateMonthlySalary();
    }

    private void checkIfEmployeeInfoAlreadyExist(employeeInfo employee){
        if (employeeList.containsKey(empKey(employee)))
            throw  new RuntimeException("Employee already in database");
    }

    private String empKey (employeeInfo employee){
        return String.format("%s-%s", employee.getFirstName(), employee.getLastName());
    }


}
