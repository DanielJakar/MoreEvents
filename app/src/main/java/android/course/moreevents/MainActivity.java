package android.course.moreevents;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, TextWatcher {
    //properties:
    private TextView tvResult;
    private SeekBar sbRed;
    private SeekBar sbGreen;
    private SeekBar sbBlue;

    private TextView tvRed;
    private TextView tvGreen;
    private TextView tvBlue;
    private boolean byUser = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        initEvents();


    }

    private void initEvents() {
        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);

        tvRed.addTextChangedListener(this);
        tvGreen.addTextChangedListener(this);
        tvBlue.addTextChangedListener(this);

    }

    private void initLayout() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvRed = (TextView) findViewById(R.id.tvRed);
        tvGreen = (TextView) findViewById(R.id.tvGreen);
        tvBlue = (TextView) findViewById(R.id.tvBlue);

        sbRed = (SeekBar) findViewById(R.id.sbRed);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) findViewById(R.id.sbBlue);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int rgb = Color.rgb(sbRed.getProgress(),sbGreen.getProgress(),sbBlue.getProgress());
        int rgbRed = Color.rgb(sbRed.getProgress(),127,127);
        int rgbGreen = Color.rgb(255,sbGreen.getProgress(),255);
        int rgbBlue = Color.rgb(255,255,sbBlue.getProgress());
        int rgbText = Color.rgb(256 - sbRed.getProgress(),256 - sbGreen.getProgress(),256 - sbBlue.getProgress());
        tvResult.setBackgroundColor(rgb);
        tvResult.setTextColor(rgbText);
        //tvResult.setTextSize(sbTextSize.getProgress());

        if (byUser) {
            String blue = Integer.toString(sbBlue.getProgress());

            tvBlue.setText(blue);
//        tvBlue.setBackgroundColor(rgbBlue);
            String red = Integer.toString(sbRed.getProgress());
            tvRed.setText(red);
//        tvRed.setText(String.valueOf(sbRed.getProgress()));
//        tvRed.setBackgroundColor(rgbRed);
            String green = Integer.toString(sbGreen.getProgress());
            tvGreen.setText(green);
//        tvGreen.setBackgroundColor(rgbGreen);
        }
        String s = "#" + Integer.toHexString(rgb).toUpperCase();
        tvResult.setText(s);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


    }

    @Override
    public void afterTextChanged(Editable s) {
        try {
            int redValue = Integer.valueOf(tvRed.getText().toString());
            int greenValue = Integer.valueOf(tvRed.getText().toString());
            int blueValue = Integer.valueOf(tvRed.getText().toString());

            byUser = false;
            sbRed.setProgress(redValue);
            sbGreen.setProgress(greenValue);
            sbBlue. setProgress(blueValue);

            byUser = true;


        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}


