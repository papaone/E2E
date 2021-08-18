package utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface TestsConfig extends Config {

    @DefaultValue("https://events.epam.com/")
    @Key("baseFrontendUrl")
    String baseFrontendUrl();

    @DefaultValue("http://localhost:4444/wd/hub")
    @Key("selenoidUrl")
    String selenoidUrl();
}
