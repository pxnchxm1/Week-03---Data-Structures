class BookNode{
    String title;
    String genre;
    String author;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;
    public BookNode(String title, String genre, String author, int bookId, boolean isAvailable){
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library{
    BookNode head ;
    BookNode tail ;
    public void addBookAtBeginning(BookNode book){
        if(head==null){
            head=book;
            tail=book;
        }else{
            book.next = head;
            head.prev = book;
            head = book;
            head.prev = null;
        }
    }
    public void addBookAtEnd(BookNode book){
        if(head==null){
            addBookAtBeginning(book);
        }else{
            BookNode curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next =book;
            book.prev= curr;
            book.next = null;
        }
    }
    public void insertBookAtPosition(BookNode b, int pos){
        if(pos==1 || head==null){
            addBookAtBeginning(b);
        }else{
            BookNode curr = head;
            int idx = 1;
            while(curr.next!=null && idx<pos-1){
                curr = curr.next;
                idx++;
            }
            if(curr.next!=null){
                b.next = curr.next;
                curr.next.prev = b;
                curr.next=b;
                b.prev = curr;
            }
            
        }
    }
    public void removeBookById(int id){
        BookNode curr = head;
        if(curr==null){
            System.out.println("List is empty");
           
        }
        while(curr!=null){
            if(curr.bookId == id){
                if (curr.prev == null) {
                    head = curr.next;
                    if (head != null) {
                        head.prev = null;
                    }
                }
                
                else {
                    curr.prev.next = curr.next;
                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                }
                System.out.println("Book with id " + id + " removed");
                return;
            }
            curr = curr.next;
        }
    }
    public void searchBookByAuthor(String a){
        if(head==null){
            System.out.println("List is empty");
           
        }else{
            BookNode curr = head;
            while(curr!=null){
                if(curr.author.equals(a)){
                    System.out.println("Book found with title: " + curr.title + " and id: " + curr.bookId);
                    return;
                }
                curr=curr.next;
            }
            System.out.println("Book not found with author: " + a);
        }
    }
    public void updateAvailability(int id){
        if(head==null){
            System.out.println("List is empty");
           
        }else{
            BookNode curr = head;
            while(curr!=null){
               if(curr.bookId == id){
                    curr.isAvailable = !curr.isAvailable;
                    System.out.println("Book with id " + id + " availability updated to: " + curr.isAvailable);
                    return;
                }
                curr=curr.next;
            }
            System.out.println("Book not found ");
        }
    }
    
    public void displayList(){
        BookNode curr = head;
        while(curr!=null){
            System.out.print("Title: " + curr.title + "---> " );
            curr = curr.next;
        }
        System.out.print("null\n");
    }
    public void displayListReverse(){
        BookNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        while(curr!=null){
            System.out.print("Title: " + curr.title + "---> " );
            curr = curr.prev;
        }
        System.out.print("null\n");
    }

    public  int countBooks(){
        BookNode curr = head;
        int count = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        BookNode book1 = new BookNode("The Great Gatsby", "Fiction", "F. Scott Fitzgerald", 1, true);
        BookNode book2 = new BookNode("1984", "Dystopian", "George Orwell", 2, true);
        BookNode book3 = new BookNode("To Kill a Mockingbird", "Fiction", "Harper Lee", 3, true);
        Library lib = new Library();
        System.out.println("adding book1 at beginning");
        lib.addBookAtBeginning(book1);
        System.out.println("adding book2 at beginning");
        lib.addBookAtBeginning(book2);
        lib.displayList();
        System.out.println("adding book3 at end");
        lib.addBookAtEnd(book3);
        lib.displayList();
        System.out.println("removing book with id 2");
        lib.removeBookById(2);
        lib.displayList();
        System.out.println("searching book by author");
        lib.searchBookByAuthor("F. Scott Fitzgerald");
        System.out.println("Updating book1 availability status");
        lib.updateAvailability(1);
        System.out.println("displaying list ");
        lib.displayList();
        System.out.println("displaying list in reverse");
        lib.displayListReverse();
        System.out.println("count of total books");
        System.out.println(lib.countBooks());
        
    }

}
