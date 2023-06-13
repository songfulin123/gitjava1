package Service;

import Model.Users;

import java.util.List;

public interface AmonicService {
    public boolean Login(String firstName,String password);
    public List<Users> getAll();
    public List<Users> getByEmail(String User);
    public boolean Exit();
}
