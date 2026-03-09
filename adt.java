import java.util.Scanner;

// Abstract class Media
abstract class Media
{
    String title;
    String publication;

    // Abstract methods to be implemented by child classes
    abstract void read();
    abstract void show();
}

// Book class inherited from Media
class Book extends Media
{
    int pages;
    static int countBooks = 0;   // Static variable to count books with > 400 pages

    // Read book details
    void read()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book title: ");
        title = sc.nextLine();

        System.out.print("Enter publication: ");
        publication = sc.nextLine();

        System.out.print("Enter number of pages: ");
        pages = sc.nextInt();

        // Count books having more than 400 pages
        if(pages > 400)
        {
            countBooks++;
        }
    }

    // Display book details
    void show()
    {
        System.out.println("Book Title: " + title);
        System.out.println("Publication: " + publication);
        System.out.println("Pages: " + pages);
    }

    // Static method to return count
    static int count()
    {
        return countBooks;
    }
}

// Tape class inherited from Media
class Tape extends Media
{
    int playingTime;

    // Read tape details
    void read()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter tape title: ");
        title = sc.nextLine();

        System.out.print("Enter publication: ");
        publication = sc.nextLine();

        System.out.print("Enter playing time (minutes): ");
        playingTime = sc.nextInt();
    }

    // Display tape details
    void show()
    {
        System.out.println("Tape Title: " + title);
        System.out.println("Publication: " + publication);
        System.out.println("Playing Time: " + playingTime + " minutes");
    }
}

// Client code
public class adt
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Read number of books
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();   // Clear buffer

        Book[] books = new Book[n];

        // Read book details
        for(int i = 0; i < n; i++)
        {
            System.out.println("\nEnter details of Book " + (i + 1));
            books[i] = new Book();
            books[i].read();
        }
        // Read number of tapes
        System.out.print("\nEnter number of tapes: ");
        int m = sc.nextInt();
        sc.nextLine();   // Clear buffer

        Tape[] tapes = new Tape[m];
        // Read tape details
        for(int i = 0; i < m; i++)
        {
            System.out.println("\nEnter details of Tape " + (i + 1));
            tapes[i] = new Tape();
            tapes[i].read();
        }
        // Display all books
        System.out.println("\n--- Book Details ---");
        for(int i = 0; i < n; i++)
        {
            books[i].show();
            System.out.println();
        }
        // Display all tapes
        System.out.println("\n--- Tape Details ---");
        for(int i = 0; i < m; i++)
        {
            tapes[i].show();
            System.out.println();
        }
        // Print count of books having more than 400 pages
        System.out.println("Number of books having more than 400 pages: " + Book.count());

        // Print tapes with playing time more than 60 minutes
        System.out.println("\nTapes with playing time more than 60 minutes:");
        for(int i = 0; i < m; i++)
        {
            if(tapes[i].playingTime > 60)
            {
                System.out.println(tapes[i].title);
            }
        }
        sc.close();
    }
}
