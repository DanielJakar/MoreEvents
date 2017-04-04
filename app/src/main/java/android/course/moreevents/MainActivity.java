package android.course.moreevents;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    //properties:
    private TextView tvResult;
    private SeekBar sbRed;
    private SeekBar sbGreen;
    private SeekBar sbBlue;

    private TextView tvRed;
    private TextView tvGreen;
    private TextView tvBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvRed = (TextView) findViewById(R.id.tvRed);
        tvGreen = (TextView) findViewById(R.id.tvGreen);
        tvBlue = (TextView) findViewById(R.id.tvBlue);

        sbRed = (SeekBar) findViewById(R.id.sbRed);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) findViewById(R.id.sbBlue);


        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);


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

        String blue = Integer.toString(sbBlue.getProgress());

        tvBlue.setText(blue);
//        tvBlue.setBackgroundColor(rgbBlue);
        String red = Integer.toString(sbRed.getProgress());
        tvRed.setText(red);
//        tvRed.setBackgroundColor(rgbRed);
        String green = Integer.toString(sbGreen.getProgress());
        tvGreen.setText(green);
//        tvGreen.setBackgroundColor(rgbGreen);
        String s = "#" + Integer.toHexString(rgb).toUpperCase();
        tvResult.setText(s);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}


