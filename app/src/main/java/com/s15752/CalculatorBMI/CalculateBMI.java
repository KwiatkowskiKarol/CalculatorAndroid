package com.s15752.CalculatorBMI;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.s15752.R;

public class CalculateBMI extends AppCompatActivity
{
    DishRecommendation dishRecommendation;
    EditText ht, wt, age;
    TextView result, Dish;
    RadioGroup sexGroup;
    RadioButton sexButton;

    @Override
    protected void onCreate(Bundle savedInstanceSate)
    {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.bmi_calculator);

        wt=(EditText)findViewById(R.id.weight);
        ht=(EditText)findViewById(R.id.height);

        age=(EditText)findViewById(R.id.age);
        Dish = findViewById(R.id.resultBmi);

        result=(TextView)findViewById(R.id.resultBmi);
    }

    public void calculateBMI(View v)
    {
        String htStr = ht.getText().toString();
        String wtStr = wt.getText().toString();
        String ageStr = age.getText().toString();

        if (htStr != null && !"".equals(htStr)
                && wtStr != null && !"".equals(wtStr)) {

            float heightValue = Float.parseFloat(htStr) / 100;
            float weightValue = Float.parseFloat(wtStr);
            float bmi = weightValue / (heightValue * heightValue);

            String sex = addListenerOnButton();
            float bhc = TryParse(htStr, wtStr, ageStr, sex);

            displayBMI(bmi, bhc);
        }
    }

    private float TryParse(String htStr, String wtStr, String ageStr, String sex)
    {
        float htValue = Float.parseFloat(htStr);
        float wtValue = Float.parseFloat(wtStr);
        float ageValue = Float.parseFloat(ageStr);
        float result = 0;

        if(sex.equals(getString(R.string.female)))
        {
            result = 655.1f + (9.563f * wtValue) + (1.85f * htValue) - (4.676f * ageValue);
        }
        else if(sex.equals(getString(R.string.male)))
        {
            result = 66.5f + (13.75f * wtValue) + (5.003f * htValue) - (6.775f * ageValue);
        }

        return result;
    }

    private void displayBMI(float bmi, float bhc)
    {
    String bmiLabel = "";
    dishRecommendation = new DishRecommendation();

    if (Float.compare(bmi, 15f) <= 0) {
        bmiLabel = getString(R.string.wyglodzenie);
    } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
        bmiLabel = getString(R.string.wychudzenie);
    } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
        bmiLabel = getString(R.string.niedowaga);
    } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
        bmiLabel = getString(R.string.wartosc_prawidlowa);
    } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
        bmiLabel = getString(R.string.nadwaga);
    } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
        bmiLabel = getString(R.string.I_stopien_otylosci);
    } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
        bmiLabel = getString(R.string.II_stopien_otylosci);
    } else {
        bmiLabel = getString(R.string.otyłosc_skrajna);
    }

    bmiLabel ="BMI = " + bmi + ": " + bmiLabel + "\n\n" + "Calories per day " + bhc;

    result.setText(bmiLabel);
    Dish.setText(dishRecommendation.dishRecommendation(bmi));
    }

    public String addListenerOnButton()
    {
        sexGroup = (RadioGroup) findViewById(R.id.radioSex);
        int selectedId = sexGroup.getCheckedRadioButtonId();
        sexButton = (RadioButton) findViewById(selectedId);

        return sexButton.getText().toString();
    }
}
