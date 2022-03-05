package com.github.hotire.springactuator.tomcat;

import java.lang.management.ManagementFactory;
import java.util.List;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;

import io.micrometer.core.instrument.binder.tomcat.TomcatMetrics;

/**
 * @see io.micrometer.core.instrument.binder.tomcat.TomcatMetrics
 */
public class TomcatMetricsCore {

    /**
     * @see TomcatMetrics#getMBeanServer()
     */
    public static MBeanServer getMBeanServer() {
        List<MBeanServer> mBeanServers = MBeanServerFactory.findMBeanServer(null);
        if (!mBeanServers.isEmpty()) return mBeanServers.get(0);
        return ManagementFactory.getPlatformMBeanServer();
    }

}
