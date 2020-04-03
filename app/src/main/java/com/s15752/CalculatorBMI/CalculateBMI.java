package com.s15752.CalculatorBMI;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.TextView;

        import com.learn2crack.activities.R;

        import java.text.DecimalFormat;

public class
CalculateBMI extends Activity implements View.OnClickListener
{
    EditText ht, wt, age, manwoman, kcal;
    TextView result, bmival;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceSate)
    {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.activity_main);

        wt=(EditText)findViewById(R.id.weight);
        ht=(EditText)findViewById(R.id.height);

        age=(EditText)findViewById(R.id.age);

        result=(TextView)findViewById(R.id.result);
        bmival=(TextView)findViewById(R.id.bmival);

        calculate=(Button)findViewById((R.id.button1));
        calculate.setOnClickListener(this);
    }


    @Override
    public void onClick(View arg0) {
        final DecimalFormat df2 = new DecimalFormat("##.##");
        Double weight, height, bmi, finalht;
        String message = "You have ";
        weight = tryParse(wt.getText().toString(), 0);
        height = tryParse(ht.getText().toString(), 0);
        finalht = (height / 100) * (height / 100);
        bmi = weight / finalht;
        bmival.setText("Your BMI: " + df2.format(bmi));

        if (bmi == 0) {
            result.setText("Your BMI = 0.. Something went wrong :(");
        } else if (bmi > 0 && bmi < 18.5) {
            if (bmi < 10) {
                result.setText("Are you sure you enter properly weight and height? System says you must eat 10 cheeseburgers..");
            } else {
                result.setText(message + "underweight! Let's eat something");
            }
        } else if (bmi > 18.5 && bmi < 24.9) {
            result.setText(message + "normal weight. You can eat cheeseburger");
        } else if (bmi > 25 && bmi < 29.9) {
            result.setText(message + "overweight. Be careful with food!");
        } else if (bmi > 30 && bmi < 39.9) {
            result.setText(message + "obesity! It's time to move!");
        } else if (bmi > 40) {
            result.setText(message + "severe obesity !!!");
        }
    }


    public double tryParse(String value, double defaultVal) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
