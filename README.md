# basic_appium_framework
## Summary
* A basic Appium framework for an Android app using Appium, Java, Gradle, the PageObject pattern, PageFactory, TestNG, Hamcrest

## App Under Test
* We are using the **ApiDemos-debug.apk** sample app included on Appium's GitHub repository. 

## ApiDemos-debug Home Page
![alt text](http://appium.io/slate/images/uiautomatorviewer.png "ApiDemos-debug.apk")



## The Test Outline
* Appium, using the Desired Capabilities will install and launch the app @BeforeSuite.
* We will wait for the header to appear on the **HomeScreen** page.
* Select the “Text” button then Wait for the header on the **InnerApiDemos** page to appear.
* Select “LogTextBox”. Wait for the header on the **LogTextBox** page to appear.
* Select the ADD button. In the panel below the ADD button, the text "This is a test" should display in the panel.
* Assert that the words “This is a test” appears in the panel.
* After the test is run, we will tear down the driver. 

## Pre-requisites 
* Appium must be running on your local computer, such as with Appium Desktop
* An emulator must be connected via adb, the Android Debug Bridge, called _emulator-5554_ 

## Directory Structure:
<pre>
src 
-> test
   -> java
      --> pages
         HomeScreenPage.java
	 InnerApiDemosPage.java
	 LogTextBoxPage.java
      --> utils
         TestUtils.java
	 
	SmokeTest.java 
ApiDemos-debug.apk
build.gradle
</pre>

## The Smoketest
<pre>
    @Test
    public void test_login() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        homeScreen.verifyHeader();
        homeScreen.selectTextButton();

        innerApiDemoScreen.verifyHeader();
        innerApiDemoScreen.selectLogTextBoxButton();

        logTextBoxPage.verifyHeader();
        logTextBoxPage.selectAddButton();

        String expectedPanelText = "This is a test";
        String actualPanelText = logTextBoxPage.getPanelText();

        System.out.println("Checking panel text...");

        TestUtils.outputIfMatchPassOrFail(expectedPanelText, actualPanelText);
        assertThat(actualPanelText,containsString(expectedPanelText));
    }
</pre>

## Output Rendered After Running Automated Test
<pre>
HOME_SCREEN_PAGE: Verifying Header appears.
HOME_SCREEN_PAGE: Selecting [TEXT] button.

INNER_API_DEMOS_PAGE: Verifying Header appears.
INNER_API_DEMOS_PAGE: Selecting [LogTextBox] button.

LOG_TEXT_BOX_PAGE: Verifying Header appears.
LOG_TEXT_BOX_PAGE: Selecting [ADD] button.

Checking panel text...
Verifying Expected Value Matches Actual Value:
	* Expected Value: This is a test
	* Actual Value: This is a test

===> (PASS)

Tearing Down Driver.
</pre>

## Future plans
Other Appium frameworks, modeled on this code, will include:
* Appium will be started and stopped programatically.
* We will use abstract classes BaseTest and BasePage, refactoring common elements out. Tests and Pages will be extensions of these BaseTests and BasePages.
* iPads, iPhones, both physical devices and emulators
* Multiple mobile devices running tests simulatneously and in parrallel
* Better logs
* A step-by-step code walkthrough will be posted on tjmaher.com.
