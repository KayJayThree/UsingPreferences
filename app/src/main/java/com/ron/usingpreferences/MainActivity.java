package com.ron.usingpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLoad(View view) {
        Intent i = new Intent("com.ron.AppPreferenceActivity");
        startActivity(i);
    }

    // In the onClickDisplay() method, you first used the getSharedPreferences()
    // method to obtain an instance of the SharedPreferences class.
    // You do so by specifying the name of the XML file
    // (in this case it is “<PackageName>.usingpreferences_preferences,”
    // using the format: <PackageName>_preferences).
    public void onClickDisplay(View view) {
        //  MODE_PRIVATE constant indicates that the preference file can be opened only by the application that created it.
        SharedPreferences appPrefs = getSharedPreferences("com.ron.usingpreferences_preferences", MODE_PRIVATE);
        // Display text in Toast
        // To retrieve a string preference, you used the getString() method, passing it the key to the preference that you want to retrieve:
        DisplayText(appPrefs.getString("editTextPref", ""));
    }

    // Changes text line to current value displayed when pressing 'DISPLAY PREFERENCES VALUES'
    // In the onClickModify() method, create a SharedPreferences.
    // Editor object through the edit() method of the SharedPreferences object.
    public void onClickModify(View view) {
        SharedPreferences appPrefs = getSharedPreferences("com.ron.usingpreferences_preferences", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = appPrefs.edit();
        // To change the value of a string preference, use the putString() method.
        // To save the changes to the preferences file, use the commit() method:
        prefsEditor.putString("editTextPref", ((EditText) findViewById(R.id.editText)).getText().toString());
        prefsEditor.apply();
        // Display text in Toast
        DisplayText(appPrefs.getString("editTextPref", ""));
    }

    // This is method to display text in Toast
    private void DisplayText(String str) {
        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
    }
}


