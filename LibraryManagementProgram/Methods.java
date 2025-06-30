import java.io.*;
import java.util.Scanner;
import UserPackage.*;

public class Methods
{
    Scanner s = new Scanner(System.in);
    Book[] b = new Book[100];
    int n = 0;
    
    public void bookList()
    {
        try
        {
            FileReader fr = new FileReader("BookList.txt");
            BufferedReader br = new BufferedReader(fr);
            String data = "";
            System.out.println("(Title, Author, Pages)");
            while((data = br.readLine()) != null)
            {
                System.out.println(data);
            }
            br.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found : "+e.getMessage());
        }
        catch(IOException io)
        {
            System.out.println(io.getMessage());
        }
    }
    
    public void addBook()
    {
        System.out.println("Title: ");
        String t = s.nextLine();
        System.out.println("Author: ");
        String a = s.nextLine();
        System.out.println("Page: ");
        int p = Integer.parseInt(s.nextLine());
        System.out.println("Copies: ");
        int c = Integer.parseInt(s.nextLine());
        
        b[n] = new Book(t, a, p, c);
        n++;
        
        try
        {
            FileWriter fw = new FileWriter("BookList.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i=0; i<n; i++)
            {
                bw.write(b[i].getTitle()+", "+b[i].getAuthor()+", "+b[i].getPages()+"\n");
            }
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
    
    public void checkAV()
    {
        boolean error = true;
        System.out.println("Book Title: ");
        String t = s.nextLine();
        
        for(int i=0; i<n; i++)
        {
            if(b[i].getTitle().equalsIgnoreCase(t))
            {
                error = false;
                int c = b[i].getCopies();
                if(c>0)
                {
                    System.out.println("Book is available for borrow.");
                }
                else
                {
                    System.out.println("Book is currently unavailable");
                }
            }
        }
        if(error)
        {
            System.out.println("No book found.");
        }
    }
    
    public void borrowBook(User U)
    {
        if(U.getNotBorrowed())
        {
            System.out.println("Enter Book Title");
            String t = s.nextLine();
            
            for(int i=0; i<n; i++)
            {
                if(b[i].getTitle().equalsIgnoreCase(t))
                {
                    if(b[i].getCopies() <=0)
                    {
                        System.out.println("Book is currently unavailable");
                    }
                    else
                    {
                        int c = b[i].getCopies();
                        c = c - 1;
                        b[i].setCopies(c);
                        U.setNotBorrowed(false);
                        System.out.println("Book borrowed successfully");
                        System.out.println("Book details: ");
                        System.out.println(b[i].toString());
                        System.out.println("Please return the book in 7 days.");
                    }
                }
            }
            if(U.getNotBorrowed() == true)
                {
                    System.out.println("No book found");
                }
        }
        else
        {
            System.out.println("Please return your borrowed book first before borrowing another book.");
        }
    }
    
    public void returnBook(User U)
    {
        if(U.getNotBorrowed() == false)
        {
            System.out.println("Enter Book Title");
            String t = s.nextLine();
            
            for(int i=0; i<n; i++)
            {
                if(b[i].getTitle().equalsIgnoreCase(t))
                {
                    int c = b[i].getCopies();
                    c = c + 1;
                    b[i].setCopies(c);
                    U.setNotBorrowed(true);
                    System.out.println("Book returned successfully");
                }
            }
            if(U.getNotBorrowed() == false)
                {
                    System.out.println("No book found");
                }
        }
        else
        {
            System.out.println("You do not have any book to return.");
        }
    }
    
    public void calcFine(User U)
    {
        double discount = 1.0;
        double total = 0.0;
        
        if(U.getNotBorrowed() == false)
        {
            System.out.println("Enter how many days you borrowed");
            int days = Integer.parseInt(s.nextLine());
            if(U.getAge() < 20)
            {
                discount = 0.9;
            }
            
            if(days <= 7)
            {
                total = 0;
            }
            
            if(days > 7)
            {
                total = (days-7)*2*discount;
            }
            
            System.out.println("The fine you have to pay is: RM"+total);
        }
        else
        {
            System.out.println("You have no fine to pay.");
        }
    }
}