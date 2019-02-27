
import int102final_lab_exam2.Movie;
import int102final_lab_exam2.MovieList;
import int102final_lab_exam2.NewMovieException;
import int102final_lab_exam2.NewMovieListException;

public class MovieDriver {

    public static void main(String[] args) {
        try {
            Movie a = new Movie("Ant-Man", 1.99, 3);
            Movie b = new Movie("Black Panther", 2.25, 2);
            System.out.println(a);
            System.out.println(a.equals(b));
            System.out.println(a.compareTo(b));

            MovieList ml = new MovieList(2);
            ml.addMovie("Doctor Strange", 1.92, 3);
            ml.addMovie("Iron Man", 2.1, 1);
            ml.resize(5);
            ml.addMovie("The Avengers", 2.33, 1);
            for (int i = 0; i < ml.getNumberOfStories(); i++) {
                System.out.println("No:" + i + " :: " + ml.getMovieAt(i));
            }
            Movie m = ml.searchForMovieTitle("Doctor Strange");
            if (m != null) {
                System.out.println(m);
            }
            while(ml.mlIterator.hasNext()){
                System.out.println(ml.mlIterator.next());
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Out of bound");
        }
        catch (IllegalArgumentException e1){
            System.out.println("Illegal Argument");
        }
        catch (NewMovieException e2){
            System.out.println("New movie");
        }
        catch (NewMovieListException e3){
            System.out.println("New movieList");
        }
        catch (Exception e4){
            System.out.println("Exception");
        }
    }
}
