import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class employeeInfoManagerTest {
  private employeeInfoManager employeeInfo;

  @BeforeAll
  public void setupAll() {
    System.out.println("Should Print Before All Tests");
  }

  @BeforeEach
  public void setup(){
    employeeInfo =new employeeInfoManager();
  }

  @Test
    public void ShouldCreateEmployeeInfo(){
        employeeInfo.addEmployee("Max", "Maxi","4072723123","max@starsxream.com",4000);
      Assertions.assertFalse(employeeInfo.getEmployeeList().isEmpty());
      Assertions.assertEquals(1, employeeInfo.getEmployeeList().size());
      Assertions.assertTrue(employeeInfo.getEmployeeList().stream()
              .anyMatch(employeeInfo -> employeeInfo.getFirstName().equals("Max") &&
                      employeeInfo.getLastName().equals("Maxi") &&
                      employeeInfo.getPhoneNumber().equals("4072723123") &&
                      employeeInfo.getEmail().equals("max@starsxream.com") &&
                      employeeInfo.getMonthlySalary()==(4000))
                      );
  }

  @Test
  @DisplayName("Should not create Employee entry when Last Name is null")
  public void shouldThrowRunTimeExceptionWhenLastNameIsNull() {
    employeeInfoManager employeeInfo = new employeeInfoManager();
    Assertions.assertThrows(RuntimeException.class, () -> employeeInfo.addEmployee("Max", null,"4072723123","max@starsxream.com",4000));
  }

  @Test
  @DisplayName("Should not create Employee entry when First Name is null")
  public void shouldThrowRunTimeExceptionWhenFirstNameIsNull() {
    Assertions.assertThrows(RuntimeException.class, () -> employeeInfo.addEmployee(null, "Maxi","4072723123","max@starsxream.com",4000));
  }

  @Test
  @DisplayName("Should not create Employee entry when Phone Number is null")
  public void shouldThrowRunTimeExceptionWhenPhoneNumberIsNull() {
    Assertions.assertThrows(RuntimeException.class, () -> employeeInfo.addEmployee("Max", "Maxi",null,"max@starsxream.com",4000));
  }

  @Test
  @DisplayName("Should not create Employee entry when Phone Number Starts With 0")
  public void shouldThrowRunTimeExceptionWhenPhoneNumberStartsWithZero() {
    Assertions.assertThrows(RuntimeException.class, () -> employeeInfo.addEmployee("Max", "Maxi","0072723123","max@starsxream.com",4000));
  }

  @Test
  @DisplayName("Should not create Employee entry when Phone Number contains non digit ")
  public void shouldThrowRunTimeExceptionWhenPhoneNumberContainsNonDigit() {
    Assertions.assertThrows(RuntimeException.class, () -> employeeInfo.addEmployee("Max", "Maxi","d072723123","max@starsxream.com",4000));
  }

  @Test
  @DisplayName("Should not create Employee entry when Phone Number length is less than 10")
  public void shouldThrowRunTimeExceptionWhenPhoneNumberLengthLessThanTen() {
    Assertions.assertThrows(RuntimeException.class, () -> employeeInfo.addEmployee("Max", "Maxi","407272312","max@starsxream.com",4000));
  }

  @Test
  @DisplayName("Should not create Employee entry when Email is null")
  public void shouldThrowRunTimeExceptionWhenEmailIsEmpty() {
    Assertions.assertThrows(RuntimeException.class, () -> employeeInfo.addEmployee("Max", "Maxi","4072723123",null,4000));
  }

  @Test
  @DisplayName("Should not create Employee entry when Email format incorrect")
  public void shouldThrowRunTimeExceptionWhenEmailFormatIncorrect() {
    Assertions.assertThrows(RuntimeException.class, () -> employeeInfo.addEmployee("Max", "Maxi","4072723123","@starsxream.com",4000));
  }

  @Test
  @DisplayName("Should not create Employee entry when Email format incorrect")
  public void shouldThrowRunTimeExceptionWhenSalaryLessThan2000() {
    Assertions.assertThrows(RuntimeException.class, () -> employeeInfo.addEmployee("Max", "Maxi","4072723123","max@starsxream.com",1000));
  }

  @Nested
  class ParameterizedTests {
    @DisplayName("Phone Number may or may not match the required Format")
    @ParameterizedTest
    @ValueSource(strings = {"4072723123", "2072723123", "407272312", "", " 072723123"})
    public void shouldTestPhoneNumberFormatUsingValueSource(String phoneNumber) {
      employeeInfo.addEmployee("Max", "Maxi",phoneNumber,"max@starsxream.com",4000);
      Assertions.assertFalse(employeeInfo.getEmployeeList().isEmpty());
      Assertions.assertEquals(1, employeeInfo.getEmployeeList().size());
    }

    @DisplayName("Email may or may not match the required Format")
    @ParameterizedTest
    @ValueSource(strings = {"max@starsxream.com", "max.maxi@starsxream.com", "!.@starsxream.com", "@starsxream.com", "starsxream.com"})
    public void shouldTestEmailFormatUsingValueSource(String email) {
      employeeInfo.addEmployee("Max", "Maxi","4072723123",email,4000);
      Assertions.assertFalse(employeeInfo.getEmployeeList().isEmpty());
      Assertions.assertEquals(1, employeeInfo.getEmployeeList().size());
    }
  }

  @AfterEach
  public void tearDown() {
    System.out.println("Should Execute After Each Test");
  }

  @AfterAll
  public static void tearDownAll() {
    System.out.println("Should be executed at the end of the Test");
  }



}