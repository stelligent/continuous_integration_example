package com.beer.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Utility class for dealing with property files.  Finds files on the
 * classpath with a <code>.properties</code> suffix.  Provides convenience
 * methods to get integer and boolean properties.
 */
public class PropertyReader {

    private Properties properties = new Properties();

    public PropertyReader(final String name) {
        this(name, PropertyReader.class.getClassLoader());
    }

    public PropertyReader(final String name, final ClassLoader loader) {
        try {
            InputStream is = loader.getResourceAsStream(convertName(name));
            if (is != null) {
                properties.load(is);
                is.close();
            } else {
                throw new IOException("Couldn't find property file: "
                        + convertName(name));
            }
        } catch (IOException problem) {
            System.out.println("Property Reader: problem initializing");
        }

    }

    protected static String convertName(String propertiesName) {
        return propertiesName.replace('.', '/') + ".properties";
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

    public String getProperty(String name, String defaultValue) {
        return properties.getProperty(name, defaultValue);
    }

    public String getStringProperty(String string) {
        return getProperty(string);
    }

    /**
     * Returns an int value for a key but will return a default value if unable
     * to find or convert found value to an int.
     */
    public int getIntProperty(String key, int defaultValue) {
        try {
            String valueRead = getProperty(key);
            return Integer.parseInt(valueRead.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Returns a long value for a key but will return a default value if unable
     * to find or convert found value to a long.
     */
    public long getLongProperty(String key, long defaultValue) {
        try {
            String valueRead = getProperty(key);
            return Long.parseLong(valueRead.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Returns a float value for a key but will return a default value if unable
     * to find or convert found value to a float.
     */
    public float getFloatProperty(String key, float defaultValue) {
        try {
            String valueRead = getProperty(key);
            return Float.parseFloat(valueRead.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Returns a double value for a key but will return a default
     * value if unable to find or convert found value to a double.
     */
    public double getDoubleProperty(String key, double defaultValue) {
        try {
            String valueRead = getProperty(key);
            return Double.parseDouble(valueRead.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Returns a boolean value for a key but will return a default
     * value if unable to find or convert found value to a boolean.
     */
    public boolean getBooleanProperty(String key, boolean defaultValue) {
        try {
            String valueRead = getProperty(key);
            return Boolean.valueOf(valueRead.trim()).booleanValue();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public Enumeration getPropertyNames() {
        return properties.propertyNames();
    }

    public Properties getProperties() {
        return (Properties) properties.clone();
    }

}
