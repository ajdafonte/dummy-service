package pt.caires.dummyservice.welcome;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 */
@XmlRootElement(name = "q")
public class WelcomeResponse
{
    String message;

    public WelcomeResponse()
    {
    }

    public WelcomeResponse(final String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    @XmlElement(name = "m")
    public void setMessage(final String message)
    {
        this.message = message;
    }
}
