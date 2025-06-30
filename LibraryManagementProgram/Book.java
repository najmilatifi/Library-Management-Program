public class Book
{
    private String title;
    private String author;
    private int pages;
    private int copies;
    private boolean availability;
    
    public Book()
    {
        
    }
    
    public Book(String t, String a, int p, int c)
    {
        title = t;
        author = a;
        pages = p;
        copies = c;
        boolean availability;
    }
    
    public void setCopies(int c)
    {
        copies = c;
    }
    
    public void setAvailability(boolean av)
    {
        availability = av;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public int getPages()
    {
        return pages;
    }
    
    public int getCopies()
    {
        return copies;
    }
    
    public boolean getAvailability()
    {
        return availability;
    }
    
    public String toString()
    {
        return "Title: "+title+"\nAuthor: "+author+"\nPages: "+pages;
    }
}