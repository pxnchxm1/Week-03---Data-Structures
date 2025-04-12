// Problem Statement: Implement a movie management system using a doubly linked list. Each node will represent a movie and contain Movie Title, Director, Year of Release, and Rating. Implement the following functionalities:
// Add a movie record at the beginning, end, or at a specific position.
// Remove a movie record by Movie Title.
// Search for a movie record by Director or Rating.
// Display all movie records in both forward and reverse order.
// Update a movie's Rating based on the Movie Title.
// Hint:
// Use a doubly linked list where each node has two pointers: one pointing to the next node and the other to the previous node.
// Maintain pointers to both the head and tail for easier insertion and deletion at both ends.
// For reverse display, start from the tail and traverse backward using the prev pointers.

class MovieNode{
    String movie;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;
    public MovieNode(String movie,String director,int year, double rating){
        this.movie = movie;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList{
    MovieNode head ;
    public void addMovieAtBeginning(MovieNode newMovie){
        newMovie.prev = null ;
        newMovie.next = head ;
        if(head != null){
            head.prev = newMovie;
        }
        head = newMovie;
    }
    public void addMovieAtEnd(MovieNode newMovie){
        if(head == null){
            head = newMovie;
        }
        else{
            MovieNode curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = newMovie;
            newMovie.prev = curr;
            newMovie.next = null;
        }
    }
    public void insertMovieAtPosition(MovieNode newMovie,int pos){
        int idx =  1;
        MovieNode curr = head;
        if(pos == 1){
            addMovieAtBeginning(newMovie);       
        }else{
            while(curr != null && idx<pos-1){
                idx++;
                curr = curr.next;
            }
            if(curr == null){
                System.out.println("Position out of bounds");
            }else{
                newMovie.next = curr.next ;
                curr.next.prev = newMovie ;
                curr.next = newMovie ;
                newMovie.prev = curr ;
            }
        }
    }

    public void searchMovieByDirector(String d){
        MovieNode curr = head;
        while(curr!=null){
            if(curr.director.equals(d)){
                System.out.println("Movie found: " + curr.movie);
                System.out.println("Director: " + curr.director);
                System.out.println("Year: " + curr.year);
                System.out.println("Rating: " + curr.rating);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Movie not found");
    }
    public void updateMovieByTitle(String t, double newRating){
        MovieNode curr = head;
        while(curr!=null){
            if(curr.movie.equals(t)){
               curr.rating = newRating;
                return;
            }
            curr = curr.next;
        }
        System.out.println("Movie not found");
    }
    public void displayList(){
        MovieNode curr = head;
        while(curr!=null){
            System.out.print(curr.movie + "  ----->  ");
            curr = curr.next;
        }
        System.out.print("null\n");
    }
    public void displayListReverse(){
        MovieNode curr = head;
        if(curr == null){
            System.out.println("List is empty");
            return;
        }
        while(curr.next != null){
            curr = curr.next;
        }
        while(curr != null){
            System.out.print(curr.movie + "  ----->  ");
            curr = curr.prev;
        }
        System.out.print("null\n");
    }
   
    
    
    
}
public class MovieManagementSystem{
    public static void main(String[] args) {
        MovieNode movie1 = new MovieNode("Inception", "Christopher Nolan",2010, 8.8);
        MovieNode movie2 = new MovieNode("DDLJ", "Adithya chopra",1995, 8.8);
        MovieNode movie3 = new MovieNode("Amaran", "XXXXX",2025, 9.8);
        MovieNode movie4 = new MovieNode("RRR", "Rajamouli",2022, 9.8);
        MovieList movieList = new MovieList();
        movieList.addMovieAtBeginning(movie1);
        movieList.addMovieAtBeginning(movie2);
        movieList.addMovieAtEnd(movie3);
        movieList.displayList();
        movieList.insertMovieAtPosition(movie4, 2);
        movieList.displayList();
        System.out.println("Searching for movie by director:");
        movieList.searchMovieByDirector("Rajamouli");
        System.out.println("Updating movie rating:");
        movieList.updateMovieByTitle("RRR", 10.0);
        System.out.println("Displaying list in forward order:");
        movieList.displayList();
        System.out.println("Displaying list in reverse order:");
        movieList.displayListReverse();
        

        
    }
}