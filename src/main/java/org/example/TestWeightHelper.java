package org.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestWeightHelper {

    private WeightHelper weightHelper;

    @Before
    public void setUp() {
        weightHelper = new WeightHelper();
    }

    /**
     * Boundary Value Analysis for BMI Categories specified below:
     * “Underweight”: BMI < 18.5
     * “Normal weight”: 18.5 <= BMI < 25
     * “Overweight”: 25 <= BMI < 30
     * “Obese”: BMI > 30
     */

    @Test
    public void testBVAUnderweightUpperLimit() {
        // BMI just below 18.5
        assertEquals("Underweight", weightHelper.getBMICategory(170, 53.3));
    }

    @Test
    public void testBVANormalWeightLowerLimit() {
        // BMI exactly 18.5
        assertEquals("Normal weight", weightHelper.getBMICategory(170, 53.5));
    }

    @Test
    public void testBVANormalWeightJustOverLimit() {
        // BMI just over 18.5
        assertEquals("Normal weight", weightHelper.getBMICategory(170, 54.5));
    }

    @Test
    public void testBVANormalWeightUpperLimit() {
        // BMI just below 25
        assertEquals("Normal weight", weightHelper.getBMICategory(170, 72.1));
    }

    @Test
    public void testBVAOverweightLowerLimit() {
        // BMI exactly 25
        assertEquals("Overweight", weightHelper.getBMICategory(170, 72.3));
    }

    @Test
    public void testBVAOverweightJustOverLimit() {
        // BMI just over 25
        assertEquals("Overweight", weightHelper.getBMICategory(170, 72.9));
    }

    @Test
    public void testBVAOverweightUpperLimit() {
        // BMI just below 30
        assertEquals("Overweight", weightHelper.getBMICategory(170, 86.5));
    }

    @Test
    public void testBVAObeseLowerLimit() {
        // BMI exactly 30
        assertEquals("Obese", weightHelper.getBMICategory(170, 86.7));
    }

    @Test
    public void testBVAObeseJustOverLimit() {
        // BMI just over 30
        assertEquals("Obese", weightHelper.getBMICategory(170, 87.2));
    }

    /**
     * Equivalence Partitioning, with values used are randomly selected samples from each category.
     */
    @Test
    public void testEquivalenceUnderweight() {
        assertEquals("Underweight", weightHelper.getBMICategory(180, 55));
    }

    @Test
    public void testEquivalenceNormalWeight() {
        assertEquals("Normal weight", weightHelper.getBMICategory(180, 70));
    }

    @Test
    public void testEquivalenceOverweight() {
        assertEquals("Overweight", weightHelper.getBMICategory(165, 75));
    }

    @Test
    public void testEquivalenceObese() {
        assertEquals("Obese", weightHelper.getBMICategory(160, 90));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHeightZeroCase() {
        weightHelper.getBMICategory(0, 70);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWeightCase() {
        weightHelper.getBMICategory(170, -5);
    }
}

