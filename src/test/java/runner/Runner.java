package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testCases.UiTests;

@RunWith(Suite.class)
    @Suite.SuiteClasses({UiTests.class})

public class Runner {
}
