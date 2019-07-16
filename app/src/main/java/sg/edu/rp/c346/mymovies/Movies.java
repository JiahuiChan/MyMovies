package sg.edu.rp.c346.mymovies;

import java.util.Calendar;

public class Movies {private String title;
    private String year;
    private String rated;
    private String genre;
    private Calendar watched_on;
    private String in_theatre;
    private String description;
    private int ratings;


    public Movies(String title, String year, String rated, String genre, Calendar watched_on, String in_theatre, String description, int ratings) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.genre = genre;
        this.watched_on = watched_on;
        this.in_theatre = in_theatre;
        this.description = description;
        this.ratings = ratings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Calendar getWatched_on() {
        return watched_on;
    }

    public void setWatched_on(Calendar watched_on) {
        this.watched_on = watched_on;
    }

    public String getIn_theatre() {
        return in_theatre;
    }

    public void setIn_theatre(String in_theatre) {
        this.in_theatre = in_theatre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String calendarToString(){
        Calendar cal = watched_on;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);

        return dayOfMonth+"/"+month+"/"+year;
    }
}
