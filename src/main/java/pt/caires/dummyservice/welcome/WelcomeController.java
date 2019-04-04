package pt.caires.dummyservice.welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.caires.dummyservice.AsyncRestController;


@RestController
@RequestMapping(value = "/welcome")
public class WelcomeController extends AsyncRestController
{
    private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);

    @Value("${welcome.message}")
    private String welcomeMessage;

//    @GetMapping
//    public DeferredResult<String> getWelcomeMessage()
//    {
//        LOG.info(">> Request welcome message");
//        return executeAsync(() -> welcomeMessage);
//    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public WelcomeResponse getWelcomeMessage()
    {
        LOG.info(">> Request welcome message");
        return new WelcomeResponse(welcomeMessage);
    }
}
