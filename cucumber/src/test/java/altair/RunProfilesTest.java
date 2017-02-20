package altair;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
                "com.github.kirlionik.cucumberallure.AllureReporter",
                "pretty", "json:build/cucumber-json/cucumber.json",
                "html:build/cucumber-html-report"})
public class RunProfilesTest {

    @BeforeClass
    public static void create_Allure_properties() {
        List<String> properties = new ArrayList<String>();
        properties.add("Enviroment=Development");
        properties.add("Application=Devops Test");

        Path allureResults = null;
        try {
            allureResults = Paths.get(ClassLoader.getSystemResource("").toURI()).getParent();
            allureResults = Paths.get(allureResults.toAbsolutePath().toString(), "../allure-results", "environment.properties");
            if (!Files.exists(allureResults.getParent())) {
                Files.createDirectories(allureResults.getParent());
            }
            Files.write(allureResults, properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
}

}
