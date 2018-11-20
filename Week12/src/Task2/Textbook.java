package Task2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Textbook implements Serializable {
    private String isbn;
    private  String title;
    private String author;

    Textbook(String isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getIsbn(){
        return isbn;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }

    @Override
    public boolean equals(Object obj){
        if (this.getClass() != obj.getClass() || obj == null)
            return false;

        Textbook t = (Textbook) obj;
        if (!t.isbn.equals(isbn))
            return false;
            return true;
    }

    @Override
    public String toString(){
        return title;
    }

    public void serialize(Vector<Textbook> v) {
        try {
            FileOutputStream foi = new FileOutputStream("textbooks.out");
            ObjectOutputStream oos = new ObjectOutputStream(foi);
            oos.writeObject(v);
            oos.close();;
            foi.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
