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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView) findViewById(R.id.tvResult);
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
        int rgbText = Color.rgb(256 - sbRed.getProgress(),256 - sbGreen.getProgress(),256 - sbBlue.getProgress());
        tvResult.setBackgroundColor(rgb);
        tvResult.setTextColor(rgbText);
        //tvResult.setTextSize(sbTextSize.getProgress());
        String s = Integer.toHexString(rgb).toUpperCase();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}


