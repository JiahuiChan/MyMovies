package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class DisplayMovies extends AppCompatActivity {

    ImageView ivRatings;
    TextView tvTitle, tvDescription, tvMovieDescription, tvWatchedOn;
    RatingBar ratingBar;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movies);

        ivRatings = findViewById(R.id.ivRating);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        tvMovieDescription = findViewById(R.id.tvMovieDescription);
        tvWatchedOn = findViewById(R.id.tvWatchedOn);
        ratingBar = findViewById(R.id.ratingBar);
        btnDelete = findViewById(R.id.btnDelete);

        Intent intent = getIntent();
        final String title = intent.getStringExtra("title");
        String year = intent.getStringExtra("year");
        String rated = intent.getStringExtra("rated");
        String genre = intent.getStringExtra("genre");
        String watched_on = intent.getStringExtra("watched_on");
        String in_theatre = intent.getStringExtra("in_theatre");
        String description = intent.getStringExtra("description");
        int ratings = intent.getIntExtra("ratings", -1);

        if (rated.equalsIgnoreCase("g")) {
            ivRatings.setImageResource(R.drawable.rating_g);
        } else if (rated.equalsIgnoreCase("pg")) {
            ivRatings.setImageResource(R.drawable.rating_pg);
        } else if (rated.equalsIgnoreCase("pg13")) {
            ivRatings.setImageResource(R.drawable.rating_pg13);
        } else if (rated.equalsIgnoreCase("nc16")) {
            ivRatings.setImageResource(R.drawable.rating_nc16);
        } else if (rated.equalsIgnoreCase("m18")) {
            ivRatings.setImageResource(R.drawable.rating_m18);
        } else {
            // R21 //
            ivRatings.setImageResource(R.drawable.rating_r21);
        }

        tvTitle.setText(title);
        tvDescription.setText(year + "-" + genre);
        tvMovieDescription.setText(description);
        tvWatchedOn.setText("Watch on: "+watched_on+"\nIn Theatre: "+in_theatre);
        ratingBar.setRating(ratings);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayMovies.this, MainActivity.class);
                intent.putExtra("source", "DisplayMovies");
                intent.putExtra("title", title);
                startActivity(intent);
                finish();
            }
        });

    }
}