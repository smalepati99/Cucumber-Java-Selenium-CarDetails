package stepdefinitions;

import static org.junit.Assert.assertThat;

import com.qa.util.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import com.pages.CarValuationPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ReadInputFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarValuationPageSteps {

    ArrayList<String> registrationNumbersToCheck;
    Map<String, HashMap<String, String>> outputCarDetails;

    private final CarValuationPage carValuationPage = new CarValuationPage(DriverFactory.getDriver());
    ConfigReader configReader = new ConfigReader();
    String baseurl = configReader.getApplicationUrl();

    @Given("I navigate to carzoo value my car page")
    public void i_navigate_to_carzoo_value_my_car_page() {
        DriverFactory.getDriver().get(baseurl);
        DriverFactory.getDriver().manage().window().maximize();
    }

    @When("I see header of the page is {string}")
    public void i_see_header_of_the_page_is(String header) {
        String actualValue = carValuationPage.getCarValuationPageHeader();
        Assert.assertEquals(header, actualValue);
    }

    @When("I see title of the page is {string}")
    public void i_see_title_of_the_page_is(String expectedTitle) {
        String actualTitle = DriverFactory.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @And("I input the registration numbers in the {string} and check the displayed car details are correct as follow")
    public void iInputTheResgistrationNumbersInTheAndCheckTheDisplayedCarDetailsAreCorrectAsFollow(String inputFilePath, DataTable table) {
        registrationNumbersToCheck = new ArrayList(ReadInputFile.read(inputFilePath));
        System.out.println(registrationNumbersToCheck);

        List<String> detailsOnWeb = new ArrayList<String>();
        registrationNumbersToCheck.forEach(
                reg -> {
                    carValuationPage.getCarValuation(reg, detailsOnWeb);
                    List<List<String>> data = table.asLists();

                    for (int i = 1; i < data.size(); i++) {
                        String actualCarDetails = carValuationPage.getCarDetailsText();
                        String expectedCarRegistrationNumber = data.get(i).get(0);
                        String expectedCarMake = data.get(i).get(1);
                        String expectedCarModel = data.get(i).get(2);

                        String expectedCarDetails = "Reg: " + expectedCarRegistrationNumber + "\nMake/model: " + expectedCarMake + " " + expectedCarModel;
                        System.out.println("\n\n\n");
                        System.out.println("actualCarDetails = \n" + actualCarDetails);
                        System.out.println("expectedCarDetails = \n" + expectedCarDetails);
                        System.out.println("\n\n\n");

                        Assert.assertEquals(actualCarDetails, expectedCarDetails);
                        Assert.assertThat(actualCarDetails, StringContains.containsString(expectedCarRegistrationNumber)); //assert car reg number
                        Assert.assertThat(actualCarDetails, StringContains.containsString(expectedCarMake)); //assert car reg make
                        Assert.assertThat(actualCarDetails, StringContains.containsString(expectedCarModel));//assert car reg model
                    }
                });
    }

    ;


}