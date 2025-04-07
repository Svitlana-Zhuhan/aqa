package lection18_testNGCalculator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testCalculator {

    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Calculator initialized.");
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
        System.out.println("Calculator resources released.");
    }

    @Test(priority = 1, description = "Test addition operation.")
    public void testAddition() {
        double result = calculator.add(7, 5);
        System.out.println("Addition result: " + result);
        assert result == 12 : "Addition test failed!";
    }

    @Test(priority = 2, description = "Test subtraction operation.")
    public void testSubtraction() {
        double result = calculator.subtract(9, 3);
        System.out.println("Subtraction result: " + result);
        assert result == 6 : "Subtraction test failed!";
    }

    @Test(priority = 3, description = "Test multiplication operation.")
    public void testMultiplication() {
        double result = calculator.multiply(7, 7);
        System.out.println("Multiplication result: " + result);
        assert result == 49 : "Multiplication test failed!";
    }

    @Test(priority = 4, description = "Test division operation.")
    public void testDivision() {
        double result = calculator.divide(35, 5);
        System.out.println("Division result: " + result);
        assert result == 7 : "Division test failed!";
    }

    @Test(priority = 5, description = "Test division by zero operation.")
    public void testDivisionByZero() {
        System.out.println("Division by zero result: ");
        calculator.divide(15, 0);
    }
}
