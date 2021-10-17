# **Project structure:**

**1.pom.xml to manage project and dependencies**

```<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>org.example</groupId>
  <artifactId>Youtube</artifactId>
  <version>1.0-SNAPSHOT</version>

  <name>Youtube</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-api</artifactId>
      <version>2.11.2</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>info.cukes</groupId>
      <artifactId>cucumber-java</artifactId>
      <version>1.2.5</version>
    </dependency>

    <dependency>
      <groupId>info.cukes</groupId>
      <artifactId>cucumber-core</artifactId>
      <version>1.2.5</version>
    </dependency>
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>3.141.59</version>
    </dependency>

    <dependency>
      <groupId>info.cukes</groupId>
      <artifactId>cucumber-junit</artifactId>
      <version>1.2.5</version>
    </dependency>
  </dependencies>

  <build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
```


**2.resources package for configurations and logger**

 Configurations:

 browser=chrome

 url=https://www.youtube.com/

Logger:
```<?xml version="1.0" encoding="UTF-8" ?>
<Configuration status="INFO">
    <Appenders>
        <Console name="FLOW" target="SYSTEM_OUT">
            <PatternLayout pattern="[%level] %d{HH:mm:ss:SSS} - %msg - %l%n"/>
        </Console>

        <File name="Youtube" fileName="logs/youtube_${date:yyyy-MM-dd}.log" append = "true">
            <PatternLayout pattern="[%level] %d{HH:mm:ss:SSS} - %msg - {%c}%n"/>
        </File>
    </Appenders>

    <Loggers>
        <Root level="INFO">
            <AppenderRef ref="FLOW"/>
            <AppenderRef ref="YoutubeTest"/>
        </Root>
    </Loggers>
</Configuration>
```
**3. utilities package with utility classes:**

public class Base {
public WebDriver driver;
public Properties properties;

    public WebDriver initializeDriver() throws IOException {

        properties = new Properties();
        FileInputStream a = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configuration.properties");

        properties.load(a);

        String browserName =  System.getProperty("browser"); //this command for maven that i can start my test from terminal
       

        if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "/Users/sergey/Desktop/SDET/chromedriver");

            driver = new ChromeDriver();
          
       
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
**4. runner package with Junit ApiRunner and UiRunner classes:**

@RunWith(Suite.class)
@Suite.SuiteClasses({UiTests.class})

public class Runner {
}

# 5.To run Youtube project 

**1. Clone project from Github**

git clone https://github.com/CJ-N-a/Youtube.git

**2. Run project from IDE Test runner class;**
