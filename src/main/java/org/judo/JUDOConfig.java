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

  /**
   * If found in the judo.programdir string, this is replaced with
   * the user.home Java System property.
   */
  private static final String CONFIG_HOME_SYMBOL = "$HOME";

  /**
   * If found in the judo.programdir string, this is replaced with
   * the root directory of the JUDO distribution.
   */
  private static final String CONFIG_DISTDIR_SYMBOL = "$DISTDIR";
  
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

    // Expand the config variables found in the judo.programdir String and save them back into the Properties instance.
    properties.setProperty("judo.programdir", expandConfigVariables(properties.getProperty("judo.programdir")));
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

  /**
   * Find instances of configuration variables ("$HOME" and "$DISTDIR") and replace them with their corresponding system value.
   * $DISTDIR is determined as two directory levels upward from the location of the JUDO jar containing the JUDO classes.
   * /Users/<user>/dev/judo/build/install/judo/lib/judo.jar/../../ , or simply /Users/<user>/dev/judo/build/install/judo/ .
   * @param  rawJudoProgramDir The judoProgramDir String with variables embedded.
   * @return                   The same judoProgramDir, but with system-provided values for the config variables.
   */
  private static String expandConfigVariables(String rawJudoProgramDir) {

    if (rawJudoProgramDir == null) {
      return null;
    }

    String expandedJudoProgramDir = rawJudoProgramDir;

    if (expandedJudoProgramDir.contains(CONFIG_HOME_SYMBOL)) {
      expandedJudoProgramDir = expandedJudoProgramDir.replace(CONFIG_HOME_SYMBOL, System.getProperty("user.home"));
    }

    if (expandedJudoProgramDir.contains(CONFIG_DISTDIR_SYMBOL)) {

      // codeSourceLocation is something like /Users/<user>/dev/judo/build/install/judo/lib/judo.jar
      // judoDistributionDir needs to be just /Users/<user>/dev/judo/build/install/judo/
      String codeSourceLocation = System.getProperty("java.class.path");
      String judoDistributionDir = Paths.get(codeSourceLocation, "../..").normalize().toString();

      expandedJudoProgramDir = expandedJudoProgramDir.replace(CONFIG_DISTDIR_SYMBOL, judoDistributionDir);
    }

    return expandedJudoProgramDir;
  }

  public static String getJUDOProgramDir() {
    return properties.getProperty("judo.programdir");
  }

  public static String getJUDOLanguage() {
    return properties.getProperty("judo.language");
  }

}