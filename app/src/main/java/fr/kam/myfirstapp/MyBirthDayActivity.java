package fr.kam.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MyBirthDayActivity extends AppCompatActivity {

    private int dayPickerId;
    private int monthPickerId;
    private int yearPickerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_birth_day);

        dayPickerId = findViewById(R.id.numberPickerDay).getId();
        monthPickerId = findViewById(R.id.numberPickerMonth).getId();
        yearPickerId = findViewById(R.id.numberPickerYear).getId();

        NumberPicker dayPicker = (NumberPicker) findViewById(dayPickerId);
        NumberPicker monthPicker = (NumberPicker) findViewById(monthPickerId);
        NumberPicker yearPicker = (NumberPicker) findViewById(yearPickerId);

        // set correct values
        dayPicker.setMinValue(1);
        dayPicker.setMaxValue(31);

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);

        yearPicker.setMinValue(1960);
        yearPicker.setMaxValue(2020);

        // set listener
        dayPicker.setOnValueChangedListener(onValueChangeListener);
        monthPicker.setOnValueChangedListener(onValueChangeListener);
        yearPicker.setOnValueChangedListener(onValueChangeListener);
    }

    private NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {

        SparseIntArray myBirthDayArray = new SparseIntArray(3);

        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            Log.i("MyBirthDayActivity", "value changed for picker(" + picker.getId() + "): oldVal = " + oldVal + " newVal = " + newVal);
            // Build the new birth date:
            // Because we have one listener for three NumberPicker, we have to
            // make some trick to build the new birth date

            // We construct a HashMap that contain NumberPicker ID as key and
            // the NumberPicker value as value.

            if (picker.getId() == dayPickerId) {
                myBirthDayArray.put(dayPickerId, newVal);
            }

            if (picker.getId() == monthPickerId) {
                myBirthDayArray.put(monthPickerId, newVal);
            }

            if (picker.getId() == yearPickerId) {
                myBirthDayArray.put(yearPickerId, newVal);
            }

            TextView myBirthDay = (TextView) findViewById(R.id.textView2);

            // Construct birth day date
            String date = myBirthDayArray.get(dayPickerId) + "/" + myBirthDayArray.get(monthPickerId) + "/" + myBirthDayArray.get(yearPickerId);

            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);
            Calendar calendar = Calendar.getInstance();
            calendar.set(myBirthDayArray.get(dayPickerId), myBirthDayArray.get(monthPickerId) - 1, myBirthDayArray.get(yearPickerId));
            String weekDay = dayFormat.format(calendar.getTime());

            // set text
            myBirthDay.setText("The " + date + " was a " + weekDay);
        }
    };
}
