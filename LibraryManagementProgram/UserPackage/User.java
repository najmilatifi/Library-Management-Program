package UserPackage;

public class User
{
    private String name;
    private String password;
    private String ID;
    private boolean notBorrowed = true;
    private int age;
    
    public User()
    {
        
    }
    
    public User(String n, String p, String id, int a)
    {
        name = n;
        password = p;
        ID = id;
        age = a;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPass()
    {
        return password;
    }
    
    public String getID()
    {
        return ID;
    }
    
    public boolean getNotBorrowed()
    {
        return notBorrowed;
    }
    
    public void setNotBorrowed(boolean b)
    {
        notBorrowed = b;
    }
    
    public void setAge(int a)
    {
        age = a;
    }
    
    public int getAge()
    {
        return age;
    }
}
