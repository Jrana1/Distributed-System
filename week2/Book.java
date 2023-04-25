class Book  extends   Publication{

    private  String author;
    private  String ISBN;

    public Book(String title, String language, double price, String author, String ISBN) {
        super(title, language, price);
        this.author = author;
        this.ISBN = ISBN;
    }

    public  void print(){
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                "} " + super.toString();
    }
}