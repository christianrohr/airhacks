package ff;

import javax.inject.Inject;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.MetricRegistry.Type;
import org.eclipse.microprofile.metrics.annotation.RegistryType;
import org.eclipse.microprofile.metrics.annotation.Timed;

public class HelloMessage {

    @Inject
    @RegistryType(type = Type.APPLICATION)
    MetricRegistry registry;

    @Timed
    @Fallback(fallbackMethod="niceMessage")
    @Retry(maxRetries=2)
    public String heyJoe() {
        System.out.println("trying...............");
        throw new IllegalStateException("no hello");
        //registry.counter("delivered_messages").inc();
        //return "hello !!";
    }

    public String niceMessage() {
        return "hello default message";
    }
    
}