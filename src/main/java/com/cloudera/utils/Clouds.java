package com.cloudera.utils;

import com.cloudera.model.Cloud;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.InputSupplier;
import com.google.common.io.Resources;
import java.util.Collection;
import java.util.Collections;

public class Clouds {
    
    private static final Logger log = LoggerFactory.getLogger(Clouds.class);

    public static List<Cloud> getSupportedClouds() {
        return getSupportedClouds("config.properties");
    }
    
    public static List<Cloud> getSupportedClouds(String configFileName) {
        final List<Cloud> clouds = Lists.newArrayList();
        Properties properties = new Properties();
        URL url = Resources.getResource(configFileName);
        InputSupplier<InputStream> inputSupplier = Resources.newInputStreamSupplier(url);
        try {
            properties.load(inputSupplier.getInput());
            for (Object key : properties.keySet()) {
                    Iterable<String> splittedValue = Splitter.on(",").split(properties.getProperty(key.toString()));
                    if(Iterables.size(splittedValue) < 3) throw new IllegalArgumentException();
                    String displayName = Iterables.get(splittedValue, 0).trim();
                    boolean enabled = Boolean.valueOf(Iterables.get(splittedValue, 1).trim());
                    String provider = Iterables.get(splittedValue, 2).trim();
                    Optional<String> region = Optional.absent();
                    if(Iterables.size(splittedValue) == 4) {
                        region = Optional.of(Iterables.get(splittedValue, 3).trim());
                    }
                    clouds.add(new Cloud(displayName, enabled, provider, region));
            }
        } catch (IOException e) {
            log.error("Cannot find config.properties file inside the classpath", e);
        }
        Collections.sort(clouds);
        return clouds;
    }
    
  public static String[] getAvailableDisplayNames() {
        List<String> availableDisplayNames = Lists.newArrayList();
        for (Cloud cloud : Clouds.getSupportedClouds()) {
            availableDisplayNames.add(cloud.getDisplayName());
        }
        return availableDisplayNames.toArray(new String[availableDisplayNames.size()]);
    }

    public static Cloud getCloud(String cloudName) {
        List<Cloud> clouds = Clouds.getSupportedClouds();
        for (Cloud cloud : clouds) {
            if(cloud.getDisplayName().equals(cloudName)) {
                    return cloud;
            }
        }
        return null;
    }
}
