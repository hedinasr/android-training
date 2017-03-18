package fr.kam.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate est lance");
    }

    public void helloWorldActivity(View view) {
        Log.i("MainActivity", "running hello world activity");
        Intent intent = new Intent(this, HelloWorldActivity.class);
        startActivity(intent);
    }

    public void myBirthDayActivity(View view) {
        Log.i("MainActivity", "running my birth day activity");
        Intent intent = new Intent(this, MyBirthDayActivity.class);
        startActivity(intent);
    }

    public void myDownloadImageActivity(View view) {
        Log.i("MainActivity", "running my download image activity");
        Intent intent = new Intent(this, MyDownloadImageActivity.class);
        startActivity(intent);
    }
}
