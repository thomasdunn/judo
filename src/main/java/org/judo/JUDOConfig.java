/**
 * @author  Cade Daniel
 */

package org.judo;

import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * Contains functions responsible for loading default and user configuration files
 * and providing getters to the config values.
 */
public class JUDOConfig {

  private static final String USER_CONFIG_NAME = ".judo.properties";
  private static final String USER_CONFIG_PATH = Paths.get(System.getProperty("user.home"), USER_CONFIG_NAME).toString();
  private static final String CONFIG_HOME_SYMBOL = "$HOME";
  
  // This refers to a location inside the JAR.
  private static final String DEFAULT_CONFIG_LOCATION = "defaultJudoConfig.properties";

  private static Properties properties;

  /**
   * Load and initiate all configuration values.
   * This first loads application default configuration (a .properties file packed with the JAR).
   * Then, it loads any user configuration and overwrites any overlapping properties.
   * The user configuration file is found at @{USER_CONFIG_PATH}.
   */
  public static void loadConfig() {

    properties = new Properties();

    try {
      // Load the default properties file from the JAR.
      InputStream inputStream = JUDOConfig.class.getClassLoader().getResourceAsStream(DEFAULT_CONFIG_LOCATION);
      properties.load(inputStream);
    } catch (IOException ioException) {
      System.out.println("Error reading default configuration file.");
      ioException.printStackTrace();
    }

    loadUserConfig();

    String judoProgramDir = properties.getProperty("judo.programdir");

    // If judo.programdir contains CONFIG_HOME_SYMBOL (usually "$HOME"), we need to insert it's value
    // into judoProgramDir.
    if (judoProgramDir != null && judoProgramDir.contains(CONFIG_HOME_SYMBOL)) {
      String expandedJudoProgramDir = judoProgramDir.replace(CONFIG_HOME_SYMBOL, System.getProperty("user.home"));
      properties.setProperty("judo.programdir", expandedJudoProgramDir);
    }
  }

  /**
   * Loads user config file (usually ~/.judo.properties) and "merges" them with default properties.
   * Before calling @{loadUserConfig}, you must populate @{properties} with the default properties.
   */
  private static void loadUserConfig() {

    if (properties == null) {
      properties = new Properties();
    }

    // If no file exists at the USER_CONFIG_PATH, return early.
    if (!(new File(USER_CONFIG_PATH)).exists()) {
      return;
    }

    // Properties(Properties properties) "Creates an empty property list with the specified defaults"
    // See https://docs.oracle.com/javase/8/docs/api/java/util/Properties.html#Properties-java.util.Properties- .
    properties = new Properties(properties);

    try {
      properties.load(new FileInputStream(USER_CONFIG_PATH));
    } catch (IOException ioException) {
      System.out.println("Error reading user configuration file.");
      ioException.printStackTrace();
    }
  }

  public static String getJUDOProgramDir() {
    return properties.getProperty("judo.programdir");
  }

  public static String getJUDOLanguage() {
    return properties.getProperty("judo.language");
  }

}