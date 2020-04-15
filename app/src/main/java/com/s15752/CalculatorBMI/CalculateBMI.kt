package com.s15752.CalculatorBMI

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.s15752.R

class CalculateBMI : AppCompatActivity() {
    var dishRecommendation: DishRecommendation? = null
    var ht: EditText? = null
    var wt: EditText? = null
    var age: EditText? = null
    var result: TextView? = null
    var Dish: TextView? = null
    var sexGroup: RadioGroup? = null
    var sexButton: RadioButton? = null
    override fun onCreate(savedInstanceSate: Bundle?) {
        super.onCreate(savedInstanceSate)
        setContentView(R.layout.bmi_calculator)
        wt = findViewById<View>(R.id.weight) as EditText
        ht = findViewById<View>(R.id.height) as EditText
        age = findViewById<View>(R.id.age) as EditText
        Dish = findViewById(R.id.resultBmi)
        result = findViewById<View>(R.id.resultBmi) as TextView
    }

    fun calculateBMI(v: View?) {
        val htStr = ht!!.text.toString()
        val wtStr = wt!!.text.toString()
        val ageStr = age!!.text.toString()
        if (htStr != null && "" != htStr
                && wtStr != null && "" != wtStr) {
            val heightValue = htStr.toFloat() / 100
            val weightValue = wtStr.toFloat()
            val bmi = weightValue / (heightValue * heightValue)
            val sex = addListenerOnButton()
            val bhc = TryParse(htStr, wtStr, ageStr, sex)
            displayBMI(bmi, bhc)
        }
    }

    private fun TryParse(htStr: String, wtStr: String, ageStr: String, sex: String): Float {
        val htValue = htStr.toFloat()
        val wtValue = wtStr.toFloat()
        val ageValue = ageStr.toFloat()
        var result = 0f
        if (sex == getString(R.string.female)) {
            result = 655.1f + 9.563f * wtValue + 1.85f * htValue - 4.676f * ageValue
        } else if (sex == getString(R.string.male)) {
            result = 66.5f + 13.75f * wtValue + 5.003f * htValue - 6.775f * ageValue
        }
        return result
    }

    private fun displayBMI(bmi: Float, bhc: Float) {
        var bmiLabel = ""
        dishRecommendation = DishRecommendation()
        bmiLabel = if (java.lang.Float.compare(bmi, 15f) <= 0) {
            getString(R.string.wyglodzenie)
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 16f) <= 0) {
            getString(R.string.wychudzenie)
        } else if (java.lang.Float.compare(bmi, 16f) > 0 && java.lang.Float.compare(bmi, 18.5f) <= 0) {
            getString(R.string.niedowaga)
        } else if (java.lang.Float.compare(bmi, 18.5f) > 0 && java.lang.Float.compare(bmi, 25f) <= 0) {
            getString(R.string.wartosc_prawidlowa)
        } else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(bmi, 30f) <= 0) {
            getString(R.string.nadwaga)
        } else if (java.lang.Float.compare(bmi, 30f) > 0 && java.lang.Float.compare(bmi, 35f) <= 0) {
            getString(R.string.I_stopien_otylosci)
        } else if (java.lang.Float.compare(bmi, 35f) > 0 && java.lang.Float.compare(bmi, 40f) <= 0) {
            getString(R.string.II_stopien_otylosci)
        } else {
            getString(R.string.otyłosc_skrajna)
        }
        bmiLabel = "BMI = $bmi: $bmiLabel\n\nCalories per day $bhc"
        result!!.text = bmiLabel
        Dish!!.text = dishRecommendation!!.dishRecommendation(bmi)
    }

    fun addListenerOnButton(): String {
        sexGroup = findViewById<View>(R.id.radioSex) as RadioGroup
        val selectedId = sexGroup!!.checkedRadioButtonId
        sexButton = findViewById<View>(selectedId) as RadioButton
        return sexButton!!.text.toString()
    }
}