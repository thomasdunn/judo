package org.judo;

import java.io.InputStream;
import java.io.ByteArrayOutputStream;

class JUDOCompiler {

  // Located in the JAR file.
  private final String JUDOAPP_TEMPLATE_LOCATION = "JUDOApp.template";

  // Load once upon instance initializiation
  private final String templateCode;

  private JUDOIDE judoIde;
  private boolean hasError = true;

  // TODO Need to integrate this.
  // number of lines in the header code - for offset in error messages
  int headerLines;

  public JUDOCompiler(JUDOIDE judoIde) {
    this.judoIde = judoIde;
    templateCode = getTemplateCode();
  }

  /**
   * Current implementation plan:
   *   Set console display ""
   *   Get JUDOApp source
   *   Get JUDO program type
   *   Populate template info
   *   Build .java code from template info
   *   write .java file
   *   make javac command
   *   execute javac command
   *
   *   Need to get hash of last used program to keep track of error correctness
   */
  public void compileCode() {

    // Let user know that we are compiling.
    judoIde.displayOutput("");

    JUDOProgram userProgram = judoIde.getUserProgram();

    /*
    // let user know we are compiling
    displayOutput("");

    // Location of JUDOApp.java
    String filename = codeBase + pathSeparator + packagePath + pathSeparator + judoAppTemplateFilename;

    String programCode = getFileText(filename, true);
    String bodyCode = codeTextArea.getText();

    determineProgramType(bodyCode);

    String type = (String) headerMap.get(JUDO_TYPE);
    if (type == null) {
      type = JUDOBase.jud0_TYPE_TEXT;
    }
    setJUDOAppDimensions(type);
    setTemplateKey("appRows", "" + appRows);
    setTemplateKey("appHeight", "" + appHeight);
    setTemplateKey("appWidth", "" + appWidth);
    setTemplateKey("appType", type);
    setTemplateKey("headerLines", "" + this.getHeaderLines());
    if (! type.equals(JUDOBase.jud0_TYPE_TEXT)) {
      setTemplateKey("initGraphics", "true");
    }
    else {
      setTemplateKey("initGraphics", "false");
    }
    setTemplateKey("programName", programName);
    setTemplateKey("bodyCode", bodyCode);
    programCode = buildCodeFromTemplate(programCode);

    filename = judoProgramDir + pathSeparator + judoAppJavaFilename;

    putFileText(filename, programCode);

    // compile the code with javac
    Command javac = null;

    // if we are on windows, we need double quotes around filenames
    if (isWindows) {
      javac = new Command(javacString +
                                  " -classpath \"" + classpath + "\" \"" +
                                  filename + "\"",
                                  this, true);
    }
    // not windows
    else {
      javac = new Command(javacString +
                                  " -classpath " + classpath + " " +
                                  filename,
                                  this, true);
    }

    Thread javacThread = new Thread(javac);
    javacThread.start();

    try {
      javacThread.join();
    } catch (InterruptedException ie) {
      displayOutput(lz.IDE_COMPILE_ERR);
    }*/
  }


  /**
   * TODO Need to refactor this to work inside of JUDOCompiler
   * Gets the text of a file (NOTE: max length of file is hardcoded)
   * @param filename the absolute path to the file to read in
   * @param isHeader whether the file is the code header or not
   * @return a string with the contents of the file, or null on error
   */
  String getFileText(String filename, boolean isHeader) {
    /*
    BufferedReader codeReader = null;

    // open the file
    try {
      codeReader = new BufferedReader(new FileReader(filename));
    }
    catch (FileNotFoundException fnfe) {
      displayOutput(ju.getString(lz.IDE_404_ERR, filename));
    }

    // get the code
    try {
      String line = "";
      String code = "";

      if (isHeader)
        headerLines = 0;

      while ((line = codeReader.readLine()) != null) {
        if (line.indexOf(JUDO_MAIN_STRING) != -1) {
          isHeader = false;
          headerLines++;
        }
        code += "\n" + line;
        if (isHeader)
          headerLines++;
      }

      if (isHeader)
        setHeaderLines(headerLines);

      codeReader.close();
      return code;
    } catch (IOException ioe) {
      displayOutput(ju.getString(lz.IDE_READ_FILE_ERR, filename));
    }
    return null;
    */
   return null;
  }


  /**
   * Writes the given text to a file
   * @param filename the absolute path to the file to write out
   * @param text the text to write to the file
   * @return true on success, false on error
   */
  boolean putFileText(String filename, String text) {
    /*
    PrintWriter codeWriter = null;

    // open the file
    try {
      codeWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(filename))));
    }
    catch (IOException ioe) {
      displayOutput(ju.getString(lz.IDE_CREATE_FILE_ERR, filename));
    }

    // write out the code
    codeWriter.print(text);
    codeWriter.close();
    return true;
    */
   return false;
  }

  String buildCodeFromTemplate(String templateCode) {
    /*
    String key = "";
    String val = "";
    Set keys = templateMap.keySet();
    Iterator keyIterator = keys.iterator();
    while (keyIterator.hasNext()) {
      key = (String) keyIterator.next();
      val = (String) templateMap.get(key);
      templateCode = replaceTemplateKey(templateCode, key, val);
    }
    return templateCode;
    */
   return null;
  }

  void setTemplateKey(String key, String value) {
    //templateMap.put(key, value);
  }

  String replaceTemplateKey(String templateCode, String key, String value) {
    /*
    
    key = templateKeyPrefix + key + templateKeySuffix;
    int index;
    while ((index = templateCode.indexOf(key)) != -1) {
      String newCode = templateCode.substring(0, index) + value;
      if (templateCode.length() - 1 >= index + key.length()) {
        newCode += templateCode.substring(index + key.length());
      }
      templateCode = newCode;
    }
    return templateCode;
    */
   return null;
  }

  private void setHeaderLines(int lines) {
    headerLines = lines;
  }

  public int getHeaderLines() {
    return headerLines;
  }


  /**
   * @return The JUDOApp.template code as a String, or null if read was unsuccessful.
   */
  private String getTemplateCode() {

    InputStream inputStream = JUDOConfig.class.getClassLoader().getResourceAsStream(JUDOAPP_TEMPLATE_LOCATION);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int length;
    String output = null;

    try {
      
      while ((length = inputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, length);
      }

      output = outputStream.toString("UTF-8");

    } catch (Exception e) {
      System.out.println("Error reading JUDOApp.template.");
      e.printStackTrace();
    }

    return output;
  }


  public boolean hasError() {
    return hasError;
  }

  public void setError(boolean errorValue) {
    hasError = errorValue;
  }



}