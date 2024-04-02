import java.util.*;

class Movie {
    private String title;
    private String rating;
    private double ratingValue;

    public Movie(String title, String rating, double ratingValue) {
        this.title = title;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }

    public String getRating() {
        return rating;
    }

    public double getRatingValue() {
        return ratingValue;
    }
}

class MovieAnalyzer {
    private List<Movie> movies;

    public MovieAnalyzer(List<Movie> movies) {
        this.movies = movies;
    }

    public void analyzeRatings() {
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Double> totalRatings = new HashMap<>();

        for (Movie movie : movies) {
            String rating = movie.getRating();
            double ratingValue = movie.getRatingValue();

            counts.put(rating, counts.getOrDefault(rating, 0) + 1);
            totalRatings.put(rating, totalRatings.getOrDefault(rating, 0.0) + ratingValue);
        }

        System.out.println("Movie Ratings Analysis:");
        for (String rating : counts.keySet()) {
            int numMovies = counts.get(rating);
            double totalRating = totalRatings.get(rating);
            double averageRating = totalRating / numMovies;
            System.out.println("Category: " + rating);
            System.out.println("Number of Movies: " + numMovies);
            System.out.println("Average Rating: " + averageRating);
            System.out.println();
        }
    }
}

public class MovieRatingAnalyzer {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie1", "PG-13", 7.8));
        movies.add(new Movie("Movie2", "R", 6.5));
        movies.add(new Movie("Movie3", "PG", 8.2));
        movies.add(new Movie("Movie4", "PG", 7.9));
        movies.add(new Movie("Movie5", "PG-13", 6.9));
        movies.add(new Movie("Movie6", "R", 8.1));

        MovieAnalyzer analyzer = new MovieAnalyzer(movies);
        analyzer.analyzeRatings();
    }
}
