package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${run}.properties"
})
public interface ProjectConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("100")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("remoteDriverUrl")
    @DefaultValue("")
    String remoteDriverUrl();

    @Key("timeout")
    @DefaultValue("4000")
    Integer timeout();

}