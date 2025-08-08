package org.example;

public class WeightHelper {
    /**
     * Calculates the Body Mass Index (BMI).
     * @param heightOfPerson Person's height in centimeters
     * @param weightOfPerson Person's weight in kilograms
     * @return the BMI value
     */
    public double calculateBMI(double heightOfPerson, double weightOfPerson) {
        if (heightOfPerson <= 0 || weightOfPerson < 0) {
            throw new IllegalArgumentException("Height must be > 0 and weight must be >= 0");
        }
        double heightInMeters = heightOfPerson / 100.0;
        return weightOfPerson / (heightInMeters * heightInMeters);
    }

    /**
     * Gets the BMI category based on the weight and height.
     * @param heightOfPerson Person's height in centimeters (>= 0)
     * @param weightOfPerson Person's weight in kilograms (>= 0)
     * @return String category ("Underweight", "Normal weight", "Overweight", "Obese")
     */
    public String getBMICategory(double heightOfPerson, double weightOfPerson) {
        double bmi = calculateBMI(heightOfPerson, weightOfPerson);

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
