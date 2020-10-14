package com.example.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button openGoogleMapsButton;
    EditText teamAddressField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the necessary buttons and text fields from the screen
        openGoogleMapsButton = (Button)findViewById(R.id.openGoogleMapsButton);
        teamAddressField = (EditText)findViewById(R.id.teamAddressField);

        //Set the Open in Google Maps button's on click listener to open google map with the
        //postal code specified in the Address field as the address
        openGoogleMapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddressField.getText());

                //Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                //Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                //Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });
    }
}