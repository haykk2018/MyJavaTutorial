package collections.iteration;

public class Book {

    public String author;
    public Integer price;

    public Book(String author, int price) {
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
