package com.s15752.CalculatorBMI;

public class DishRecommendation {
    private static float NORMAL_DOWN_VALUE = 17.2f;
    private static float NORMAL_TOP_VALUE = 30.0f;

    public DishRecommendation() {}


    public String dishRecommendation(float bmi)
    {
        if (bmi < NORMAL_DOWN_VALUE) {
        return "You can eat cheeseburger";
        } else if (NORMAL_DOWN_VALUE < bmi && bmi < NORMAL_TOP_VALUE) {
            return "You can eat cheeseburger, but with carrot and salat!";
        } else {
            return "You can eat only vegetables..";
        }
    }
}
