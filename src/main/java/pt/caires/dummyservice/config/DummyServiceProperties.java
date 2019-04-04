package pt.caires.dummyservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 *
 */
@Configuration
@ConfigurationProperties(prefix = "dummyservice")
@EnableConfigurationProperties
public class DummyServiceProperties
{
    private int version;
    private String description;

    public int getVersion()
    {
        return version;
    }

    public String getDescription()
    {
        return description;
    }

    public void setVersion(final int version)
    {
        this.version = version;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }
}
