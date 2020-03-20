package com.s15752.CalculatorBMI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learn2crack.activities.R;

public class MainActivity extends Activity {

    private Button mBtLaunchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceSate)
    {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.start_screen);

        mBtLaunchActivity = (Button) findViewById(R.id.bt_launch_activity);

        mBtLaunchActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                launchActivity();
            }
        });
    }

    private void launchActivity()
    {
        Intent intent = new Intent(this, CalculateBMI.class);
        startActivity(intent);
    }
}