package pt.caires.dummyservice.welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.caires.dummyservice.config.DummyServiceProperties;


/**
 *
 */
@RestController
@RequestMapping(value = "/dummy")
public class DummyServiceController
{
    private static final Logger LOG = LoggerFactory.getLogger(DummyServiceController.class);

    private final DummyServiceProperties dummyServiceProperties;

    @Autowired
    public DummyServiceController(final DummyServiceProperties dummyServiceProperties)
    {
        this.dummyServiceProperties = dummyServiceProperties;
    }

    @GetMapping
    public String getDummyService()
    {
        LOG.info(">> Request dummy message");
//        for (int i = 0; i < 100; i++)
//        {
//            LOG.info("ping");
//        }
        return dummyServiceProperties.getDescription();
    }
}
