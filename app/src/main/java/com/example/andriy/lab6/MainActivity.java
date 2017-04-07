package com.example.andriy.lab6;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setId(R.id.myRel1LayoutId);
        myLayout.setBackgroundColor(Color.BLUE);

        TextView myTextView = new TextView(this);
        myTextView.setText("......");
        myTextView.setId(R.id.mytextView);
        myTextView.setTextColor(Color.rgb(255, 255, 255));

        myTextView.setTextSize(20);
        myTextView.setHeight(100);
        // myTextView.setWidth(350);
        myTextView.setBackgroundColor(Color.rgb(0, 0, 0));
        RelativeLayout.LayoutParams txtViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        txtViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        txtViewParams.setMargins(0, 300, 0, 0);

        Button myButton = new Button(this);
        myButton.setId(R.id.myButtonId);
        myButton.setText("Press Me");
        myButton.setBackgroundColor(Color.YELLOW);

        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, (RelativeLayout.LayoutParams.WRAP_CONTENT));
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

        final EditText myEditText = new EditText(this);

        myEditText.setId(R.id.myEditTextId);
        myEditText.setTextColor(Color.rgb(255, 255, 255));
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, r.getDisplayMetrics());
        myEditText.setWidth(px);

        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, (RelativeLayout.LayoutParams.WRAP_CONTENT));
        textParams.addRule(RelativeLayout.ABOVE, myButton.getId());
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        txtViewParams.setMargins(0, 0, 0, 80);

        myLayout.addView(myButton, buttonParams);
        myLayout.addView(myEditText, textParams);
        myLayout.addView(myTextView, txtViewParams);

        setContentView(myLayout);
        myButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView myTempTextView = (TextView) findViewById(R.id.mytextView);
                        myTempTextView.setText(myEditText.getText().toString());
                    }
                }
        );
    }
}
