import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"
//                , "src/test/resources/features/CreateSmartPlaylist.feature"
                  , "src/test/resources/features/Logout.feature"
        },
        publish = true
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    // This method is executed before the class starts running and initializes the TestNGCucumberRunner.
    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    // This method overrides the scenarios() method from the AbstractTestNGCucumberTests class.
    // It provides the scenarios (feature files) to be executed by the TestNG framework.
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    // This method is executed after the class finishes running and performs cleanup tasks.
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
