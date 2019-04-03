package com.pegasustest.automation.pegasus_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class AppTest {
	
  public static URL url;
  public static DesiredCapabilities capabilities;
  public static AndroidDriver<MobileElement> driver;
  
  public String prefix="537";		//Membership Informations for Log-In
  public String pNumber="8189494";
  public String pwd="123456";
  
  public String start_destination="İstanbul"; 	//Destination Names for Search
  public String arr_destination="Adana";
  
  public String name = "Umut Çağrı";		// Passenger Informations
  public String surname = "Aydın";
  public String birth_day = "26";			
  public String birth_month = "Eki";
  public String birth_year = "1992";
  
  
  @BeforeSuite
  public void setupAppium() throws MalformedURLException {

    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
    url = new URL(URL_STRING);
    
    
    capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android"); 
    capabilities.setCapability("automationName", "UiAutomator2");
    capabilities.setCapability("deviceName", "CB5A28E9DD");		//This Test Operated on Real Device
    capabilities.setCapability("appPackage", "com.pozitron.pegasus"); // .apk file was pre-installed from Google Play
    capabilities.setCapability("appActivity", "com.monitise.mea.pegasus.ui.splash.SplashActivity");
    capabilities.setCapability("noReset", true);
    
    
    
    driver = new AndroidDriver<MobileElement>(url, capabilities);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.resetApp();
  }
  
  
  @AfterSuite
  public void teardown() {
      driver.quit();
  }
  
  
  @Test (description="Case #1 - Skipping Introduction")
  public void Case01() throws InterruptedException {
     
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.pegasus:id/activity_onboarding_text_view_next")));
	  
	  driver.findElementById("com.pozitron.pegasus:id/activity_onboarding_text_view_next").click();
	  System.out.println("Next button on Gift Card slide is clicked!");
	  Thread.sleep(1000);
	  
	  driver.findElementById("com.pozitron.pegasus:id/activity_onboarding_text_view_next").click();
	  System.out.println("Next button on Fingerprint slide is clicked!");
	  Thread.sleep(1000);
	  
	  driver.findElementById("com.pozitron.pegasus:id/activity_onboarding_text_view_next").click();
	  System.out.println("Next button on Flight Status slide is clicked!");
	  Thread.sleep(1000);
	  
	  driver.findElementById("com.pozitron.pegasus:id/activity_onboarding_text_view_next").click();
	  System.out.println("OK button on ID Scan slide is clicked!");
	  Thread.sleep(2000);
	  
	  System.out.println("Case #1 is Successful!");
	  System.out.println("-------------------------------------------------------");
  }
    
  @Test (description="Case #2 - Skipping Tutorial")
  public void Case02() throws InterruptedException {
	  
	  WebDriverWait wait = new WebDriverWait(driver, 1);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue")));
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue").click();
	  System.out.println("Next button on Introduction splash is clicked!");
	  Thread.sleep(2000);
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue").click();
	  System.out.println("Next button on BolBol Account splash is clicked!");
	  Thread.sleep(2000);
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue").click();
	  System.out.println("Next button on Special Offers splash is clicked!");
	  Thread.sleep(2000);
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue").click();
	  System.out.println("Next button on Campaigns splash is clicked!");
	  Thread.sleep(2000);
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue").click();
	  System.out.println("Next button on Additional Services splash is clicked!");
	  Thread.sleep(2000);
	  
	  System.out.println("Case #2 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
  }

  @Test (description="Case #3 - Go to Login Page")
  public void Case03() throws InterruptedException {
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.pegasus:id/activity_home_linear_layout_login_area")));
	  System.out.println("Accessed to Homescreen.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/activity_home_linear_layout_login_area").click();
	  System.out.println("Login Button is Clicked!");
	  Thread.sleep(3000);
	  
	  System.out.println("Case #3 is Successful!");
	  System.out.println("-------------------------------------------------------");
  }

  @Test (description="Case #4 - Log-In Execution")
  public void Case04() throws InterruptedException {
	  
	  driver.hideKeyboard();
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText").sendKeys(prefix);
	  System.out.println("Prefix Entered.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.EditText").sendKeys(pNumber);
	  System.out.println("Phone Number Entered.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText").sendKeys(pwd);
	  System.out.println("Password Entered.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_login_expandable_button_login").click();
	  System.out.println("Login Button is Clicked!");
	  Thread.sleep(5000);
	  
	  System.out.println("Case #4 is Successful!");
	  System.out.println("-------------------------------------------------------");
  }
 
  @Test (description="Case #5 - Fingerprint Feature")
  public void Case05() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.pozitron.pegasus:id/fragment_dialog_validation_image_view_main")));
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]").click();
	  System.out.println("Remind Me Later Button is Clicked!");
	  
	  System.out.println("Case #5 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
  }

  @Test (description="Case #6 - Search Ticket")
  public void Case06() throws InterruptedException {
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.pegasus:id/activity_home_button_search_flight")));
	  System.out.println("Returned to Homescreen as Logged-in.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/activity_home_button_search_flight").click();
	  System.out.println("Search Ticket Button is Clicked!");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText").click();
	  System.out.println("Searching For Departure Destination.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/fragment_port_selection_edit_text_from_port").sendKeys(start_destination);
	  System.out.println("Searched for İstanbul.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]").click();
	  System.out.println("İstanbul has Selected as Departure Destination!");
	  
	  Thread.sleep(3000);
	  System.out.println("Searching For the Arrival Destination.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/fragment_port_selection_edit_text_to_port").sendKeys(arr_destination);
	  System.out.println("Searched for Adana.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]").click();
	  System.out.println("Adana has Selected as Arrival Destination!");
	  Thread.sleep(3000);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.pegasus:id/right")));
	  System.out.println("Returned to Ticked Search Screen as Destinations Selected.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/right").click();
	  System.out.println("One Way Travel Option Selected.");
	  Thread.sleep(2000);
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText").click();
	  System.out.println("Date of Departure Button is Clicked!");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.pozitron.pegasus:id/layout_toolbar_text_view_title")));
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.FrameLayout[7]").click();
	  System.out.println("21st of April Selected as Date of Departure!");
	  Thread.sleep(3000);
	  
	  driver.findElementById("com.pozitron.pegasus:id/fragment_date_selection_button_approve").click();
	  System.out.println("Date Selection Button is Clicked!");
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.pegasus:id/fragment_search_flight_button_search")));
	  System.out.println("Returned to Ticked Search Screen as Destination Date Selected.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/fragment_search_flight_button_search").click();
	  System.out.println("Search for Flights Button is Clicked!");
	  
	  System.out.println("Case #6 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
	  
  }
  
  @Test (description="Case #7 - Search Flight")
  public void Case07() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.pozitron.pegasus:id/layout_toolbar_toolbar")));
	  
	  double swipe_start = 0.7;
	  double swipe_end = 0.1;
	  verticalScroll(swipe_start,swipe_end);
	  System.out.println("Scrolled Down to the Last Flight.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView[2]/android.widget.LinearLayout[4]").click();
	  System.out.println("Last Flight of the Day is Selected!");
	  
	  System.out.println("Case #7 is Successful!");
	  System.out.println("-------------------------------------------------------");
  }

  @Test (description = "Case #8 - Departure Flight Package Selection")
  public void Case08() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout")));
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]").click();
	  System.out.println("Businnes Flex Pack Selected!");
	  
	  System.out.println("Case #8 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
	  
  }

  @Test (description = "Case #9 - Selected Flights Splash Pages")
  public void Case09() throws InterruptedException {
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue")));
	  System.out.println("Uçuş Seçenekleri Tanıtım Ekranı Açıldı");
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue").click();
	  System.out.println("Clicked on First Next!");
	  Thread.sleep(2000);
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_tutorial_background_text_view_continue").click();
	  System.out.println("Clicked on Second Next!");	  
	  Thread.sleep(2000);
	  
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_booking_total_amount_button_action").click();
	  System.out.println("Selected Flights Approved!");
	  Thread.sleep(3000);
	  
	  System.out.println("Case #9 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
	  
  }

  @Test (description ="Case #10 - Passenger Information Screen")
  public void Case10() throws InterruptedException {
	  
	  System.out.println("Passenger Information Screen Opened.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText").sendKeys(name);
	  System.out.println("Passenger Name Entered.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText").sendKeys(surname);
	  System.out.println("Passenger Surname Entered.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText").click();
	  
	  WebDriverWait wait2 = new WebDriverWait(driver, 10);
	  wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/pickers"))); 
	  System.out.println("Date of Birth DatePicker Widged Opened.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText").click();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText").sendKeys(birth_day);
	  System.out.println("Day of Birth Entered.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText").click();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText").sendKeys(birth_month);
	  System.out.println("Month of Birth Entered.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText").click();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText").sendKeys(birth_year);
	  System.out.println("Year of Birth Entered.");
	  
	  driver.findElementById("android:id/button1").click();
	  System.out.println("Date of Birth has confirmed.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/fragment_passenger_info_form_radio_button_male").click();
	  System.out.println("Gender Info Selected.");
	  
	  double swipe_start = 0.7;
	  double swipe_end = 0.2;
	  verticalScroll(swipe_start,swipe_end);
	  
	  driver.findElementById("com.pozitron.pegasus:id/fragment_passenger_info_form_radio_button_other_nationality").click();
	  System.out.println("Nationality Info Selected.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText").click();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText").sendKeys(prefix);
	  System.out.println("Prefix Entered.");
	  
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.EditText").click();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.EditText").clear();
	  driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.EditText").sendKeys(pNumber);
	  System.out.println("Passenger Phone Number Entered.");
	  
	  driver.hideKeyboard();
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_booking_total_amount_button_action").click();
	  System.out.println("Confirm Button is Clicked!");
	  Thread.sleep(3000);
  
	  System.out.println("Case #10 is Successful!");
	  System.out.println("-------------------------------------------------------");
  
  }
  
  @Test (description = "Case #11 - Contact Information Page")
  public void Case11() throws InterruptedException {
	  
	  double swipe_start = 0.75;
	  double swipe_end = 0.05;
	  verticalScroll(swipe_start,swipe_end);
	  
	  // There Was Exist Until First Test and After First Test They Gone Eternally :)
	  /*
	  driver.findElementById("com.pozitron.pegasus:id/fragment_contact_form_checkbox_marketing_sms").click();
	  System.out.println("SMS Option Selected");
	  
	  driver.findElementById("com.pozitron.pegasus:id/fragment_contact_form_checkbox_marketing_email").click();
	  System.out.println("E-Mail Option Selected");
	  
	  Thread.sleep(1000);
	  verticalScroll(swipe_start,swipe_end);
	  */
	  
	  driver.findElementById("com.pozitron.pegasus:id/fragment_contact_form_check_box_send_sms").click();
	  System.out.println("Priced SMS Info Selected.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_booking_total_amount_button_action").click();
	  System.out.println("Passenger Contact Informations Confirmed!");
	  Thread.sleep(3000);
	  
	  System.out.println("Case #11 is Successful!");
	  System.out.println("-------------------------------------------------------");
  }
  
  @Test (description="Case #12 - Seat Selection Page")
  public void Case12() throws InterruptedException {
	 
	  System.out.println("Seat Selection Page Opened.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/list_item_seat_row_seat_c").click();
	  System.out.println("Seat Selected!");
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_booking_total_amount_button_action").click();
	  System.out.println("Seat Selection Has Completed!");
	  Thread.sleep(3000);
	  
	  System.out.println("Case #12 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
  }
  
  @Test (description="Case #13 - Meal Selection Page")
  public void Case13() throws InterruptedException {
	  
	  System.out.println("Meal Selection Page Opened.");
	  
	  driver.findElementByXPath("//ri[@content-desc=\"Kahvaltılar Ve Salatalar\"]").click();
	  System.out.println("Breakfast and Salads Section Checked.");
	  
	  driver.findElementByXPath("//ri[@content-desc=\"Özel Yemekler\"]").click();
	  System.out.println("Special Meals Section Checked.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_booking_total_amount_button_action").click();
	  System.out.println("Meal Selection Has Completed!");
	  Thread.sleep(3000);
	  
	  System.out.println("Case #13 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
  }
  
  @Test (description="Case #14 - Luggage Selection Page")
  public void Case14() throws InterruptedException {
	  
	  System.out.println("Luggage Selection Page Opened.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_booking_total_amount_button_action").click();
	  Thread.sleep(3000);
	  
	  System.out.println("Case #14 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
  }
  
  @Test (description="Case #15 - Payment Summary Page")
  public void Case15() {
	  
	  System.out.println("Payment Summary Page Opened.");
	  
	  double swipe_start = 0.75;
	  double swipe_end = 0.05;
	  verticalScroll(swipe_start,swipe_end);
	  
	  driver.findElementById("com.pozitron.pegasus:id/fragment_payment_summary_checkbox_termsAndConditions").click();
	  System.out.println("Terms & Conditions checked.");
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_booking_total_amount_button_action").click();
	  System.out.println("Payment Summary Check Has Completed!");
	  
	  System.out.println("Case #15 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
  }
  
  @Test (description="Case #16 - Payment Page")
  public void Case16() {
	  
	  driver.findElementById("com.pozitron.pegasus:id/layout_toolbar_text_view_title").click();
	  System.out.println("Payment Page Opened");
	  
	  
	  
	  System.out.println("Case #16 is Successful!");
	  System.out.println("-------------------------------------------------------");
	  
	  System.out.println("YTM-CHALLENGE TEST COMPLETED SUCCESSFULLY!");
  }
  
  
  
  
private void verticalScroll(double starty, double endy ) {
		
	Dimension dimension = driver.manage().window().getSize();
	
	int height = dimension.getHeight();
	int width = dimension.getWidth();
	
	int start_x = (int) (width * 0.01); 
	int end_x = (int) (width * 0.01);
	int start_y = (int) (height * starty);
	int end_y = (int) (height * endy);
	
	TouchAction action = new TouchAction(driver);
	action.press(PointOption.point(start_x, start_y))
	.moveTo(PointOption.point(end_x, end_y))
	.release()
	.perform();
	
}









}