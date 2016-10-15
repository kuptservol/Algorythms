package ru.skuptsov.puzzlers.job.interview.programcreek.stringarray;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Sergey Kuptsov
 * @since 11/10/2016
 */
public class ProblemSolveAndTestStub {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {}
        };
    }

    @Test(dataProvider = "testData")
    public void test(Object a, Object b) {
        assertEquals(testMethod(a), b);
    }

    private Object testMethod(Object a) {
        return null;
    }
}