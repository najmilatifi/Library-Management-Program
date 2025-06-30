import javax.swing.*;
import java.util.*;
import java.io.*;
import UserPackage.*;

public class LibraryApp
{
    static Scanner s = new Scanner(System.in);
    static User u[] = new User[100];
    static Methods m = new Methods();
    static int userCount = 3;
    
    public static void main(String[] args) throws IOException
    {
        u[0] = new Admin("Najmi", "Najmi12345", "2023850234", 19);
        u[1] = new Admin("Raja", "Raja1234", "2023658994", 19);
        u[2] = new Admin("Said", "Said2205", "2023849346", 19);
        
    
    
        boolean while1 = true, while2 = true;
        while(while1)
        {
            try
            {
                System.out.println("Welcome to Public Library of Maracca\n1. Login\n2. Register\n3. Quit");
                int firstChoice = Integer.parseInt(s.nextLine());
                
                
                switch(firstChoice)
                {
                    case 1: login();
                            break;
                    case 2: newUser();
                            break;
                    case 3: while1 = false;
                            break;
                    default: System.out.println("Error");
                            break;
                }
            }
        
            catch(NullPointerException npe)
            {
                return;
            }
            catch(InputMismatchException ime)
            {
                System.out.println("Invalid data type");
            }
            catch(NumberFormatException nfe)
            {
                System.out.println("Invalid data type");
            }
        }
        try
        {
            FileWriter fw = new FileWriter("BookList.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("");
            bw.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found : "+e.getMessage());
        }
        catch(EOFException eof)
        {
            System.out.println(eof.getMessage());
        }
        catch(IOException io)
        {
            System.out.println(io.getMessage());
        }
    }
    
    private static void login()
    {
        boolean correct = true;
        boolean while2 = true;
        System.out.println("Enter name: ");
        String name = s.nextLine();
        System.out.println("Enter password: ");
        String password = s.nextLine();
        for(int i = 0; i < userCount; i++)
        {
            if(u[i].getName().equalsIgnoreCase(name) && u[i].getPass().equalsIgnoreCase(password))
            {
                correct = false;
                System.out.println("Hello " + u[i].getName()+"("+u[i].getID()+")!");
                if(i<3)
                {
                    while(while2)
                    {
                        Admin.menu();
                        int secondChoice = Integer.parseInt(s.nextLine());
                        switch(secondChoice)
                        {
                            case 1: m.bookList();
                                    break;
                            case 2: m.addBook();
                                    break;
                            case 3: m.checkAV();
                                    break;
                            case 4: while2 = false;
                                    break;
                            default: System.out.println("Invalid input");
                        }
                    }
                }
                else
                {
                    while(while2)
                    {
                        NormalUser.menu();
                        int secondChoice = Integer.parseInt(s.nextLine());
                        switch(secondChoice)
                        {
                            case 1: m.bookList();
                                    break;
                            case 2: m.checkAV();
                                    break;
                            case 3: m.borrowBook(u[i]);
                                    break;
                            case 4: m.returnBook(u[i]);
                                    break;
                            case 5: m.calcFine(u[i]);
                                    break;
                            case 6: while2 = false;
                                    break;
                            default: System.out.println("Invalid input");
                        }
                    }
                }
            }
        }
        if(correct)
        {
            System.out.println("Incorrect username or password");
        }
    }
    private static void newUser()
    {
        System.out.println("Enter name: ");
        String name = s.nextLine();
        boolean nameAvailable = true;
        
        for(int i = 0; i < userCount; i++)
        {
            if(u[i].getName().equalsIgnoreCase(name))
            {
                nameAvailable = false;
                System.out.println("Name is already used by another user.");
            }
        }
        if(nameAvailable)
        {
            System.out.println("Enter password: ");
            String password = s.nextLine();
            System.out.println("Enter ID: ");
            String Id = s.nextLine();
            System.out.println("Enter Age: ");
            int a = Integer.parseInt(s.nextLine());
            u[userCount] = new NormalUser(name, password, Id, a);
            userCount = userCount+1;
        }
    }
}