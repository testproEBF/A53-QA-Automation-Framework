import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
//                "src/test/resources/features/Login.feature"
//                , "src/test/resources/features/CreateSmartPlaylist.feature"
//                , "src/test/resources/features/Logout.feature"
//                 ,"src/test/resources/features/CurrentQueue/CurrentQueue.feature"
//                 ,"src/test/resources/features/CurrentQueue/NavigatedToCurrentQueue.feature"
                "src/test/resources/features/ProfileAndPreferences/ProfileAndPreferences.feature"
                ,"src/test/resources/features/ProfileAndPreferences/FailedProfileAndPreferences.feature"
        }
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @DataProvider
    public Object[][] features(){
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        testNGCucumberRunner.finish();
    }
}
