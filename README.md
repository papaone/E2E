# E2E
**For local run** 

To run tests use `mvn clean test`
   
To get report use `mvn allure:serve`

Browser can be change in `BaseTest` class  
` Configuration.browser = "chrome";`
`Configuration.browserSize = "1920x1080";`
`Configuration.browserVersion = "91";`
----------------------------------------------
**For remote run** 

1. setup docker
2. setup selenide 
3. start selenide env
4. provide `selenoidUrl` in `TestsConfig` interface
5. uncomment `Configuration.remote = config.selenoidUrl();` in `BaseTest` class  
6. To run tests use `mvn clean test`
