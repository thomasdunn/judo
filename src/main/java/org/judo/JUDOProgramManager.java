/**
 * @author  Cade Daniel
 */

package org.judo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

/**
 * Goals of API:
 *   Get list of user JUDO files (getuserProgramNamesStringArray)
 *   Get a program, which has its body, type (text or graphics), and its name.
 *   Write a program
 *   Read a program
 *   Create an empty program
 *   Delete a program
 *
 *   Outside of write/read preferences, members of the API should be stateless.
 *
 * TODO This class has major stubs - need to fill them out.
 */
public class JUDOProgramManager {

  private static final String JUDO_KEY_PREFIX = "$";
  private static final String JUDO_KEY_ASSIGNMENT = "=";
  private static final String JUDO_PROP_COMMENT = "//~JUDOPROP~//";

  public JUDOProgramManager() {

  }

  /**
   * sets up output directory (exits? writable?)
   * calls to write the file, or displays error messages where necessary
   * @param defaultLocation if we are saving in the main programs directory
   * @return true if wrote out the JUDO program successfully, false otherwise.
   */
  boolean writeJUDOProgram(JUDOProgram judoProgram) {
    /*
    File defaultProgramDirectory = new File(judoProgramDir);

    if (! defaultProgramDirectory.exists()) {
      // judo program dir doesnt exist, try and create it
      if (! defaultProgramDirectory.mkdir()) {
        JOptionPane.showMessageDialog(this, lz.IDE_NO_PROG_DIR_MSG,
                                      lz.IDE_ERR_SAVING_TIT,
                                      JOptionPane.ERROR_MESSAGE);
        return false;
      }
      if (! defaultProgramDirectory.canWrite()) {
        JOptionPane.showMessageDialog(this, lz.IDE_PROG_DIR_NOT_WRIT,
                                      lz.IDE_ERR_SAVING_TIT,
                                      JOptionPane.ERROR_MESSAGE);
        return false;
      }
    }
    
    return writeProgramToDisk(judoProgramDir + pathSeparator + programFilename + "." + extension);
    */
   return false;
  }


  boolean writeProgramToDisk(String filePath) {
    /*
    // if filePath ends in .judo.judo, remove one
    // this happens when saving a file that you opened
    if (filePath.indexOf("." + extension + "." + extension) != -1) {
      filePath = filePath.substring(0, filePath.length() - extension.length());
    }

    String headers = generateHeaderComments();
    String code = codeTextArea.getText();
    return putFileText(filePath, headers + code);
    */
    return false;
  }

  private boolean fileExists(String filePath) {
    /*
    File codeFile = new File(filePath);
    return codeFile.exists();
    */
    return false;
  }

  // Note when adding commit: I removed functionality to have a program name that isn't a file name.
  // TODO Should we re-add this?
  ArrayList<String> getUserProgramNames() {
    ArrayList<String> userProgramNames = new ArrayList<String>();

    // TODO Add support for sample programs    
    String basePath = JUDOConfig.getJUDOProgramDir();

    File userProgramsDirectory = new File(basePath);
    File[] userProgramFiles = userProgramsDirectory.listFiles(JUDOUtils.getJUDOProgramFilenameFilter());

    if (userProgramFiles == null) {
      return userProgramNames;
    }

    for (File userProgram : userProgramFiles) {
      userProgramNames.add(userProgram.getName());
    }

    return userProgramNames;
  }

  String[] getuserProgramNamesStringArray(HashMap programsMap) {
    /*
    String[] names;
    int count = 0;
    names = new String[programsMap.size()];
    String key = "";
    Set keys = programsMap.keySet();
    Iterator keyIterator = keys.iterator();
    while (keyIterator.hasNext()) {
      key = (String) keyIterator.next();
      names[count] = key;
      count++;
    }
    return names;
    */
   return null;
  }

  // This reads a given JUDO file and returns the user title value.
  private String getUserProgramName(File f) {
    /*
    BufferedReader programReader = null;
    String name = "";

    // open the file
    try {
      programReader = new BufferedReader(new FileReader(f));
    }
    catch (FileNotFoundException fnfe) {
      displayOutput(ju.getString(lz.IDE_404_ERR, f.getName()));
    }

    // get the code
    try {
      String line = "";
      int index = -1;
      String searchString = JUDO_KEY_PREFIX + JUDOAPP_TITLE + "=";
      while ((line = programReader.readLine()) != null) {
        if ((index = line.indexOf(searchString)) != -1) {
          name = line.substring(index + searchString.length());
          break;
        }
      }

      programReader.close();
      return name;
    } catch (IOException ioe) {
      displayOutput(ju.getString(lz.IDE_READ_FILE_ERR, f.getName()));
    }
    return null;

    */
   
    return null;
  }

  /**
   * Reads in a .judo file and returns the code
   * Also initializes the headerMap based on the JUDOPROP comments
   * @param filePath the path to the file to read in
   * @return the code of the .judo file
   */
  String getProgramText(String filePath) {
    /*
    BufferedReader programReader = null;
    String programText = "";
    int index = -1;

    // open the file
    try {
      programReader = new BufferedReader(new FileReader(filePath));
    }
    catch (FileNotFoundException fnfe) {
      displayOutput(ju.getString(lz.IDE_404_ERR, filePath));
    }

    // get the code
    try {
      String line = "";
      String key = "";
      String val = "";
      String searchString = JUDO_PROP_COMMENT;

      while ((line = programReader.readLine()) != null) {
        if ((index = line.indexOf(searchString)) != -1) {
          // read the comment and store in headerMap
          key = line.substring(line.indexOf(JUDO_KEY_PREFIX, index) + 1, line.indexOf("=", index));
          val = line.substring(line.indexOf("=", index) + 1);
          headerMap.put(key, val);
          continue;
        }
        programText += line + "\n";
      }

      programReader.close();
      return programText;
    } catch (IOException ioe) {
      displayOutput(ju.getString(lz.IDE_READ_FILE_ERR, filePath));
    }
    return null;
    */
   return null;

  }

  /**
   * Given a program name, this reads a file found in the users' JUDO program directory, parses the file,
   * and returns a JUDOProgram representation of the program.
   * @param  programName           Filename of JUDO program found in {@JUDOConfig#getJUDOProgramDir}.
   * @return                       {@JUDOProgram} representing the program.
   * @throws FileNotFoundException 
   * @throws IOException           
   */
  JUDOProgram openProgram(String programName) throws FileNotFoundException, IOException {

    // Throw an error for a null programName, as it can't exist.
    if (programName == null || programName.length() == 0) {
      throw new FileNotFoundException("null");
    }

    // Open a BufferedReader to the file.
    String path = Paths.get(JUDOConfig.getJUDOProgramDir(), programName).toString();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
    
    // Used for storing header metadata lines for later parsing.
    List<String> headerLines = new LinkedList<String>();
    // Used for storing user code lines for later generation of user code.
    List<String> userLines = new LinkedList<String>();

    // This loop parses data from the bufferedReader one line at a time.
    // If a line contains JUDO_PROP_COMMENT, it is added to the headerLines List.
    // Else, it is added to the userLines List.

    String line;
    while ((line = bufferedReader.readLine()) != null) {
      
      // If the line contains JUDO_PROP_COMMENT, add it to the metadata.
      if (line.contains(JUDO_PROP_COMMENT)) {
        headerLines.add(line);
        continue;
      }

      userLines.add(line);
    }

    // All file reading has been done, now we need to generate a String representation for the userCode
    // and a Map for the header metadata.

    // Join each user code line with a line separator (usually "\n").
    String userCode = String.join(System.getProperty("line.separator"), userLines);
    
    Map<String, String> metadata = buildHeaderMetadata(headerLines);

    return new JUDOProgram(userCode, metadata);
  }

  /**
   * Given a List of Strings representing individual lines containing key-value pairs,
   * this builds a Map representation by extracting substrings out of each line. 
   * This ignores each line where a parsing error occurs.
   * @param  headerLines 
   * @return             The in-memory representation of the key-value pairings defined in the header lines.
   */
  private Map<String, String> buildHeaderMetadata(List<String> headerLines) {

    Map<String, String> metadata = new HashMap<>();

    for (String line : headerLines) {

      int keyPrefixIndex = line.indexOf(JUDO_KEY_PREFIX);
      int keyAssignmentIndex = line.indexOf(JUDO_KEY_ASSIGNMENT);

      // Malformed header line.
      if (keyAssignmentIndex <= keyPrefixIndex) {
        System.out.println("JUDO encountered a malformed header line while reading a program.");
        System.out.println("header line: " + line);
        continue;
      }

      String key = line.substring(keyPrefixIndex + 1, keyAssignmentIndex);
      String value = line.substring(keyAssignmentIndex + 1);

      metadata.put(key, value);
    }

    return metadata;
  }

  void openSampleProgram(String filename) {
    /*
    if (isDirty) {
      if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(this,
                                              lz.IDE_OPEN_SAMPLE_CONFIRM_MSG,
                                              lz.IDE_OPEN_SAMPLE_CONFIRM_TIT,
                                              JOptionPane.YES_NO_OPTION,
                                              JOptionPane.QUESTION_MESSAGE)) {
        return;
      }
    }

    String filePath = helpSamplesDir + pathSeparator + filename;
    String programText = getProgramText(filePath);
    programName = (String) headerMap.get(JUDOAPP_TITLE);
    HashMap programsMap = getuserProgramNames(false, true);
    programFilename = (String) programsMap.get(programName);
    if (programText == null || programText.equals("")) {
      JOptionPane.showMessageDialog(this, ju.getString(lz.IDE_OPEN_PROG_MSG, programName),
                                    lz.IDE_OPEN_PROG_ERR_TIT,
                                    JOptionPane.ERROR_MESSAGE);
      return;
    }
    outputTextArea.setText("");
    codeTextArea.setText(programText);
    judoCompiler.setError(true);
    setTitle(titlePrefix + programName);
    setDirty();
    appType = (String) headerMap.get(JUDO_TYPE);
    codeTextArea.requestFocus();
    codeTextArea.setCaretPosition(0);
    */
  }

  boolean deleteProgram() {
    /*
    String filePath = "";
    String programText = "";

    HashMap programsMap = getuserProgramNames(true, defaultLocation);
    if (programsMap == null || programsMap.size() == 0) {
      JOptionPane.showMessageDialog(this, lz.IDE_NO_PROG_DEL_MSG,
                                    lz.IDE_NO_PROG_DEL_TIT,
                                    JOptionPane.ERROR_MESSAGE);
      return false;
    }

    deleteDialog = new JUDODeleteDialog(this, this, codeBase + pathSeparator + "images" + pathSeparator + deleteIconFilename, lz.IDE_DEL_TIT, getuserProgramNamesStringArray(programsMap));
    deleteDialog.pack();
    deleteDialog.setLocationRelativeTo(this);
    deleteDialog.setVisible(true);

    if (deleteDialog.canceled()) {
      return false;
    }

    programName = deleteDialog.getProgramName();
    programFilename = (String) programsMap.get(programName);

    filePath = judoProgramDir + pathSeparator + programFilename;

    // delete the file
    File fileToDelete = new File(filePath);
    if (! fileToDelete.delete()) {
      JOptionPane.showMessageDialog(this, ju.getString(lz.IDE_DELETE_PROG_MSG, programName),
                                    lz.IDE_DELETE_PROG_ERR_TIT,
                                    JOptionPane.ERROR_MESSAGE);
      return false;
    }

    codeTextArea.requestFocus();
    return true;
    */
    return false;
  }

  /**
   * Creates an initial JUDOProgram.
   * @return A new JUDOProgram.
   */
  public JUDOProgram createNewProgram() {
    return new JUDOProgram();
  }

  String getFilenameFromProgramName(String programNameText) {
    /*
    String filenameText = "";
    for (int i = 0; i < programNameText.length(); i++) {
      if (programNameText.charAt(i) != ' ') {
        filenameText += programNameText.charAt(i);
      }
    }
    filenameText = filenameText.toLowerCase();
    return filenameText;
    */
    return null;
  }

  private String generateHeaderComments() {
    /*
    String key = "";
    String val = "";
    String headerText = "";
    Set keys = headerMap.keySet();
    Iterator keyIterator = keys.iterator();
    while (keyIterator.hasNext()) {
      key = (String) keyIterator.next();
      val = (String) headerMap.get(key);
      headerText += JUDO_PROP_COMMENT + JUDO_KEY_PREFIX + key + "=" + val + newline;
    }

    return headerText;
    */
   return null;
  }

}