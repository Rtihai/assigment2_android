package com.roman.tihai.assaiment2andr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner mSpinner;
    private ImageView mPosterIV;
    private TextView mSummaryTV;

    private static String[] filenames = {
            "catch_me_if_you_can", "fight_club", "forrest_gump",
            "god_father", "good_will_hunting", "pulp_fiction",
            "the_hangover", "the_shaw_shank_redemption", "titanic"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = findViewById(R.id.spinner);
        mSpinner.setOnItemSelectedListener(this);

        mPosterIV = findViewById(R.id.posterIV);
        mSummaryTV = findViewById(R.id.summaryTV);
    }

    private int getResId(String filename, String resType) {
        int resId = getResources().getIdentifier(filename, resType, getPackageName());
        return resId;
    }

    private void displaySummary(String name) {
        int resId = getResId(name, "raw");
        String summary = "";
        Scanner in = new Scanner(getResources().openRawResource(resId));
        while (in.hasNext()) {
            summary += in.nextLine();
        }
        mSummaryTV.setText(summary);
    }

    private void displayImage(String name) {
        int resId = getResId(name, "drawable");
        mPosterIV.setImageResource(resId);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String filename = filenames[position];
        displayImage(filename);
        displaySummary(filename);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
