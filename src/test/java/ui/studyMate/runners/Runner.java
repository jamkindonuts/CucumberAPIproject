package ui.studyMate.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/studyMate/login.feature",
                "src/test/resources/studyMate/group.feature",
                "src/test/resources/studyMate/courses.feature",
                "src/test/resources/studyMate/teachers.feature",
                "src/test/resources/studyMate/students.feature"

        },
        glue = "ui/studyMate/stepDefinitions",
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)

public class Runner {
}
