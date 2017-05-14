package utils;

public class TestUtils {

    public static void outputIfMatchPassOrFail(String expectedValue, String actualValue){
        String result;
        if (expectedValue.trim().contains(actualValue.trim())){
            result = "(PASS)";
        } else {
            result = "(FAIL)";
        }

        System.out.println("Verifying Expected Value Matches Actual Value:");
        System.out.println("\t* Expected Value: " + expectedValue);
        System.out.println("\t* Actual Value: " + actualValue);
        System.out.println("===> " + result);
    }
}
