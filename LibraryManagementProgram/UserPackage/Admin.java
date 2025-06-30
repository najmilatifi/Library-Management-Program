package UserPackage;

public class Admin extends User
{
    public Admin(String n, String p, String id, int a)
    {
        super(n, p, id, a);
    }
    
    public static void menu()
    {
        System.out.println("1. Book List");
        System.out.println("2. Add Book");
        System.out.println("3. Check Book Availability");
        System.out.println("4. Logout");
    }
}
