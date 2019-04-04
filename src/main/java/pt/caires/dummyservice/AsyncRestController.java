package pt.caires.dummyservice;

import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.async.DeferredResult;


/**
 *
 */
public abstract class AsyncRestController
{
    private static final Logger LOG = LoggerFactory.getLogger(AsyncRestController.class);

    @Autowired
    private ExecutorService executor;

    protected <T> DeferredResult<T> executeAsync(final Supplier<T> task)
    {
        final DeferredResult<T> deferredResult = new DeferredResult<>();

        executor.execute(() ->
        {
            try
            {
                LOG.debug("Starting execution in bizz... ");
                final T result = task.get();
                LOG.debug("Finished execution in bizz. ");
                deferredResult.setResult(result);
            }
            catch (final Exception e)
            {
                if (LOG.isInfoEnabled())
                {
                    LOG.error("Error occurred during execution in bizz.", e);
                }
                else
                {
                    LOG.error("Error occurred during execution in bizz, msg = '{}'", e.getMessage());
                }

                deferredResult.setErrorResult(e);
            }
        });

        return deferredResult;
    }

    protected DeferredResult<Void> executeAsync(final Runnable task)
    {
        return executeAsync(() ->
        {
            task.run();
            return null;
        });
    }

}