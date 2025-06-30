package UserPackage;

public class NormalUser extends User
{   
    public NormalUser(String n, String p, String id, int a)
    {
        super(n, p, id, a);
    }
    
    public static void menu()
    {
        System.out.println("1. Book List");
        System.out.println("2. Check Book Availability");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Logout");
    }
}
