package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class AddMovies extends AppCompatActivity {

    EditText etTitle, etYear, etGenre, etRated, etTheatre, etDescription;
    RatingBar rtBar;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movies);

        etTitle = findViewById(R.id.etTitle);
        etYear = findViewById(R.id.etYear);
        etGenre = findViewById(R.id.etGenre);
        etRated = findViewById(R.id.etRated);
        etTheatre = findViewById(R.id.etTheatre);
        etDescription = findViewById(R.id.etDescription);
        rtBar = findViewById(R.id.ratingBar);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNullCheck()){
                    Intent intent = new Intent(AddMovies.this, MainActivity.class);
                    intent.putExtra("source", "AddMovies");
                    intent.putExtra("title", etTitle.getText().toString().trim());
                    intent.putExtra("year", etYear.getText().toString().trim());
                    intent.putExtra("rated", etRated.getText().toString().trim());
                    intent.putExtra("genre", etGenre.getText().toString().trim());
                    intent.putExtra("in_theatre", etTheatre.getText().toString().trim());
                    intent.putExtra("description", etDescription.getText().toString().trim());
                    intent.putExtra("ratings", rtBar.getNumStars());
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    public boolean etNullCheck(){
        if(etTitle.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Title is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(etYear.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Year is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(etGenre.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Genre is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(etRated.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Rated is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(etTheatre.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Theatre is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(etDescription.getText().toString().isEmpty()){
            Toast.makeText(this, "Description is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}