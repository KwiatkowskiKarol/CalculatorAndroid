package com.s15752.CalculatorBMI

class DishRecommendation {
    fun dishRecommendation(bmi: Float): String {
        return if (bmi < NORMAL_DOWN_VALUE) {
            "You can eat cheeseburger"
        } else if (NORMAL_DOWN_VALUE < bmi && bmi < NORMAL_TOP_VALUE) {
            "You can eat cheeseburger, but with carrot and salat!"
        } else {
            "You can eat only vegetables.."
        }
    }

    companion object {
        private const val NORMAL_DOWN_VALUE = 17.2f
        private const val NORMAL_TOP_VALUE = 30.0f
    }
}