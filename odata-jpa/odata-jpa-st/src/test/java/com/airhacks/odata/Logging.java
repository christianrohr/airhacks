
package com.airhacks.odata;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.jersey.logging.LoggingFeature;

/**
 *
 * @author airhacks.com
 */
public interface Logging {

    static LoggingFeature log(Object loggable) {
        Logger logger = Logger.getLogger(loggable.getClass().getName());
        return new LoggingFeature(logger, Level.INFO, null, null);
    }

}
