package com.moringaschool.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindRestaurantsButton; //declare the variable
    private EditText mLocationEditText; // the location variable


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton); //
        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String location = mLocationEditText.getText().toString();
//                Toast.makeText(MainActivity.this, "Maina The Dev!", Toast.LENGTH_LONG).show();//toasting
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class); // creating an intent to open another activity
                intent.putExtra("location", location);
                startActivity(intent);

//                Toast.makeText(MainActivity.this, location, Toast.LENGTH_LONG).show();

            }
        });

    }
}