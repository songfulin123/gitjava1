package Model;

public class Users {
    
    private String FirstName;
    private String LastName;
    private int age;
    private String password;
    private String Role;
    private String Email;
    private String Office;

    public Users() {

    }

    public Users(String firstName, String lastName, int age, String password, String role, String email, String office) {
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
        this.password = password;
        Role = role;
        Email = email;
        Office = office;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String office) {
        Office = office;
    }
}
