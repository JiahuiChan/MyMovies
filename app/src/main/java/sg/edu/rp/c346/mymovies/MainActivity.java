package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movies> alMovies;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.lvMovies);
        alMovies = new ArrayList<Movies>();

        Movies movie1 = new Movies("The Avengers", "2012", "pg13", "Action | Sci-Fi", stringToCalendar("15/11/2014"), "Golden Village - Bishan", "Nick Fury of SHIELD assembles a team of superheroes to save the planet from Loki and his army.", 4);
        Movies movie2 = new Movies("Planes", "2013", "pg", "Animation | Comedy", stringToCalendar("15/5/2015"), "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights live his dream of competing in a famous around-the-world aerial race.", 2);
        alMovies.add(movie1);
        alMovies.add(movie2);

        caMovie = new CustomAdapter(this, R.layout.row, alMovies);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position = i;
                Intent intent = new Intent(MainActivity.this, DisplayMovies.class);
                intent.putExtra("title", alMovies.get(i).getTitle());
                intent.putExtra("year", alMovies.get(i).getYear());
                intent.putExtra("rated", alMovies.get(i).getRated());
                intent.putExtra("genre", alMovies.get(i).getGenre());
                intent.putExtra("watched_on", alMovies.get(i).calendarToString());
                intent.putExtra("in_theatre", alMovies.get(i).getIn_theatre());
                intent.putExtra("description", alMovies.get(i).getDescription());
                intent.putExtra("ratings", alMovies.get(i).getRatings());
                startActivity(intent);
            }
        });


        Intent intent = getIntent();

        if (intent.getStringExtra("source").equals("AddMovies")) {
            String title = intent.getStringExtra("title");
            String year = intent.getStringExtra("year");
            String rated = intent.getStringExtra("rated");
            String genre = intent.getStringExtra("genre");
            String in_theatre = intent.getStringExtra("in_theatre");
            String description = intent.getStringExtra("description");
            int ratings = intent.getIntExtra("ratings", -1);


            Movies newMovie = new Movies(title, year, rated, genre, stringToCalendar("16/7/2019"), in_theatre, description, ratings);
            alMovies.add(newMovie);
            caMovie.notifyDataSetChanged();
        } else if (intent.getStringExtra("source").equals("DisplayMovies")) {
            String title = intent.getStringExtra("title");
            for (Movies movie : alMovies) {
                if (movie.getTitle().equals(title)) {
                    alMovies.remove(movie);
                }
            }
            caMovie.notifyDataSetChanged();

        } else {
            // nothing //
        }
    }

    //Outside on create

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuAdd) {
            Intent intent = new Intent(MainActivity.this, AddMovies.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Calendar stringToCalendar(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;

        try {
            date = formatter.parse(strDate);
        } catch (Exception e) {

        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal;
    }


}
