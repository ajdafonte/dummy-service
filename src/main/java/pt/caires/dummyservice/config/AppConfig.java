package pt.caires.dummyservice.config;

import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
 *
 */
@Configuration
public class AppConfig
{
    private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public ThreadPoolTaskExecutor executor()
    {

        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(8);
//        executor.setMaxPoolSize(16);
//        executor.setThreadNamePrefix("bizz-executor-");
//        executor.setTaskDecorator(mdcTaskDecorator);
        LOG.info("Created bizz thread pool with {} core and {} max threads...", executor.getCorePoolSize(), executor.getMaxPoolSize());
        return executor;
    }

    @Bean
    public ExecutorService executorService(final ThreadPoolTaskExecutor executor)
    {
        return executor.getThreadPoolExecutor();
    }
}
