package testSuite;

import dto.LoadCsvDataToDB;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"pretty"}, features = "classpath:features/status_match_report/SBTPXP_91_validation_of_group_the_cases_for_status_match.feature")
public class CucumberTestSuite {


    @BeforeClass
    public static void setUpTestData(){
        System.out.println("loading data");
        LoadCsvDataToDB.load();
    }
}