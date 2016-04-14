/***************************************************************************
 * JUDO - A Java IDE for Children and Beginning Programmers
 * Copyright (C) 2001  Thomas J. Dunn
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 ***************************************************************************/

package org.judo;

import java.awt.event.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.URL;
import javax.swing.undo.*;
import javax.swing.text.Document;

/**
 * The main class of the IDE.  Everything is controlled via the action of the controls in this window.
 *
 * @author Thomas Dunn
 * @version 1.3
 */
public class JUDOIDE extends JFrame implements ActionListener, WindowListener, DocumentListener {

  /////////////////////////////////////////////////////////////////////////
  // CLASS AND MEMBER DATA

  // a newline
  static String newline = System.getProperty("line.separator");
  static String pathSeparator = System.getProperty("file.separator");

  // for interpolating vars in String for localization
  public static JUDOUtils ju = new JUDOUtils();

  static String judoProgramDir;

  static String programDirectory = "MyJUDOPrograms";
  String helpSamplesDir = "docs" + pathSeparator + "helpsamples";
  
  public static JUDO_localization lz;
  static {
    JUDOConfig.loadConfig();
    judoProgramDir = JUDOConfig.getJUDOProgramDir();

    initiateLocalization();
  }

  final static String JUDO_VERSION = "1.3.1";
  final static String JUDO_MAIN_STRING = "//<judomain>";

  final static int HELP_WINDOW_WIDTH = 600;
  final static int HELP_WINDOW_HEIGHT = 420;
  final static int JUDO_IDE_WIDTH = 600;
  final static int JUDO_IDE_HEIGHT = 400;

  int appHeight = JUDOBase.jud0_APP_HEIGHT_TEXT;
  int appWidth = JUDOBase.jud0_APP_WIDTH;
  int appRows = JUDOBase.jud0_APP_TEXT_ROWS;

  // instead of reading dealing with properties dialog, this var is used
  String appType = JUDOBase.jud0_TYPE_TEXT;

  // to help determine program type
  boolean hasText = false;
  boolean hasGraphics = false;

  // dialogs
  JUDOSaveDialog saveDialog;
  JUDOOpenDialog openDialog;
  JUDODeleteDialog deleteDialog;

  String saveIconFilename = "Save24.gif";
  String openIconFilename = "Open24.gif";
  String deleteIconFilename = "Delete24.gif";
  String judoIconFilename = "judo16.gif";
  String judoAppTemplateFilename = "JUDOApp.template";
  String judoAppJavaFilename = "JUDOApp.java";
  String extension = "judo";
  String titlePrefix = " JUDO - ";

  // the name of a program after it has been saved.
  protected String defaultProgramName = lz.IDE_DEFAULT_PROG_NAME;
  String programName = defaultProgramName;
  String lastProgramName = "";

  // This (by examination) is equivalent to !isDirty
  boolean lastSaveDefault = true;

  // TODO Should be private
  public JUDOCompiler judoCompiler;
  private JUDOProgram userProgram;
  private JUDOProgramManager judoProgramManager;

  // key/value pairs for interpolating in template
  HashMap templateMap;
  String templateKeyPrefix = "[[";
  String templateKeySuffix = "]]";

  // the program name, lowercased, with spaces removed
  String programFilename;

  // if program text has been changed since a save
  boolean isDirty = false;

  boolean isWindows = false;
  boolean isMacOSX = false;

  // location of source code
  String codeBase;
  String packagePath;

  // binary locations
  String jdkBase;
  String jdkBin;
  String javacString;
  String javaString;

  String classpath;

  ///////////////////
  // GUI COMPONENTS

  JMenuBar menuBar;

  JMenu fileMenu;
  JMenuItem newMenuItem;
  JMenuItem saveMenuItem;
  JMenuItem saveAsMenuItem;
  JMenuItem openMenuItem;
  JMenuItem openSampleMenuItem;
  JMenuItem deleteMenuItem;
  JMenuItem exitMenuItem;

  JMenu editMenu;
  JMenuItem copyMenuItem;
  JMenuItem cutMenuItem;
  JMenuItem pasteMenuItem;
  JMenuItem undoMenuItem;
  JMenuItem gotoLineMenuItem;
  JMenuItem redoMenuItem;
  JMenuItem selectAllMenuItem;

  JMenu helpMenu;
  JMenuItem tutorialsMenuItem;
  JMenuItem functionReferenceMenuItem;
  JMenuItem colorReferenceMenuItem;
  JMenuItem aboutMenuItem;
  JMenuItem judoWebsiteMenuItem;

  JButton runButton;
  JTextArea codeTextArea;

  static JTextArea outputTextArea;

  JSplitPane splitPane;

  /**
   * For copy/cut/paste
   */
  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

  /**
   * For undo/redo
   */
  final UndoManager undoManager = new UndoManager();

  // end - CLASS AND MEMBER DATA
  /////////////////////////////////////////////////////////////////////////


  ///////////////////////////////////////////////////////////////////////
  // THE FOLLOWING METHODS ARE FOR JUDO INITIALIZATION
  public JUDOIDE() {
    super("JUDO");
    setTitle(titlePrefix + defaultProgramName);
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    templateMap = new HashMap();

    if (((String) System.getProperty("os.name")).startsWith("Windows")) {
      isWindows = true;
    }
    else if (((String) System.getProperty("os.name")).startsWith("Mac OS X")) {
      isMacOSX = true;
    }

    buildGUI();

    if (! initJava()) {
      displayErrorPane();
    }
    // initialize the save dialog
    saveDialog = new JUDOSaveDialog(this, this, codeBase + pathSeparator + "images" + pathSeparator + saveIconFilename, lz.IDE_SAVE_PROG);
    saveDialog.pack();

    // where the help sample programs are located
    helpSamplesDir = codeBase + pathSeparator + helpSamplesDir;

    this.setIconImage(new ImageIcon(codeBase + pathSeparator + "images" + pathSeparator + judoIconFilename).getImage());

    // install undo manager instance as listener for undoable edits
    codeTextArea.getDocument().addUndoableEditListener(undoManager);

    judoCompiler = new JUDOCompiler(this);
    judoProgramManager = new JUDOProgramManager();
  }

  void displayErrorPane() {
    JPanel errorPane = new JPanel();
    JLabel errorLabel = new JLabel();
    errorLabel.setText(lz.IDE_ERR_INIT_JAVA);
    errorPane.add(errorLabel);
    getContentPane().add(BorderLayout.CENTER, errorPane);
  }

  /**
   * Initialized java system
   *
   * There are two main configurations for JUDO/Java installations.
   *
   * If it is a Windows system with the full installer, JUDO would
   * have come both with copies of a JRE1.3 for running JUDO, and a copy
   * of jdk1.3 under the codebase.  If this is the configuration, then
   * use the supplied jdk1.3
   *
   * If it is a Linux, Solaris, MacOS, other, or Windows without the full
   * installer system, then the user must have previously installed a
   * Java 2 JDK.  There would be no JRE or JDK with JUDO.
   * If this is the configuration, then use the jdk found from the java.home path
   */
  private boolean initJava() {
    String javaHomeString = System.getProperty("java.home");
    String javaVersionString = System.getProperty("java.version");
    String javaVendorString = System.getProperty("java.vendor");
    codeBase = System.getProperty("user.dir");
    int javaIndex;

    classpath = System.getProperty("java.class.path");

    // a jdk1.3 bundled with JUDO was found
    String jdk13 = codeBase + pathSeparator + "jdk1.3";
    if ((new File(jdk13)).exists()) {
      jdkBase = jdk13;
    }
    // no jdk1.3 bundled with JUDO was found, use the one that should be
    // running JUDO right now.
    else {
      if (isMacOSX) {
        jdkBase = javaHomeString;
      }
      else {
        javaIndex = javaHomeString.toUpperCase().lastIndexOf((pathSeparator + "jre").toUpperCase());
        if (javaIndex == -1) {
            jdkBase = javaHomeString;
//            return false;
        }
        else {
          jdkBase = javaHomeString.substring(0, javaIndex);
        }
      }
    }
    jdkBin = jdkBase + pathSeparator + "bin";
    javacString = jdkBin + pathSeparator + "javac";

    // use javaw on windows since it does not pop up an extra annoying box
    if (isWindows) {
      javaString = jdkBin + pathSeparator + "javaw";
    }
    else {
      javaString = jdkBin + pathSeparator + "java";
    }
    packagePath = "org" + pathSeparator + "judo";

    return true;
  }

  /**
   * This creates the static variable responsible for providing translations of JUDO.
   * 
   * TODO I believe this creates a security hole. If a malicious user inserted a class into a JAR
   * with the name of org.judo.JUDO_MY_LANG and specified in the .properties file that the language
   * was "MY_LANG", the JUDO_MY_LANG class would be treated in JUDO as trusted code, but could contain
   * whatever the attacker wants.
   *
   * This hole is not insignificant because a malicious user could then distribute the corrupted JUDO
   * JAR, performing malicious payloads under the trust that people have in JUDO.
   *
   * The solution would be to whitelist the interpretation of the .properties file.
   */
  private static void initiateLocalization() {
    
    try {
      Class lzClass = Class.forName("org.judo.JUDO_" + JUDOConfig.getJUDOLanguage());
      lz = (JUDO_localization) lzClass.newInstance();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.out.println("Reflection error in JUDOIDE when creating localization object: " + e.toString());
    }

  }

  private void buildGUI() {

    getContentPane().setLayout(new BorderLayout());

    menuBar = new JMenuBar();
    fileMenu = new JMenu(lz.IDE_FILE);
    fileMenu.setMnemonic('f');
    newMenuItem = new JMenuItem(lz.IDE_FILE_NEW, KeyEvent.VK_N);
    newMenuItem.setMnemonic('n');
    newMenuItem.addActionListener(this);
    saveMenuItem = new JMenuItem(lz.IDE_FILE_SAVE, KeyEvent.VK_S);
    saveMenuItem.setMnemonic('s');
    saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    saveMenuItem.addActionListener(this);
    saveAsMenuItem = new JMenuItem(lz.IDE_FILE_SAVE_NEW_NAME);
    saveAsMenuItem.setMnemonic('a');
    saveAsMenuItem.addActionListener(this);
    openMenuItem = new JMenuItem(lz.IDE_FILE_OPEN, KeyEvent.VK_O);
    openMenuItem.setMnemonic('o');
    openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    openMenuItem.addActionListener(this);
    openSampleMenuItem = new JMenuItem(lz.IDE_FILE_OPEN_SAMPLE);
    openSampleMenuItem.addActionListener(this);
    deleteMenuItem = new JMenuItem(lz.IDE_FILE_DELETE);
    deleteMenuItem.addActionListener(this);
    exitMenuItem = new JMenuItem(lz.IDE_FILE_EXIT);
    exitMenuItem.setMnemonic('x');
    exitMenuItem.addActionListener(this);

    editMenu = new JMenu(lz.IDE_EDIT);
    editMenu.setMnemonic('e');
    copyMenuItem = new JMenuItem(lz.IDE_EDIT_COPY, KeyEvent.VK_C);
    copyMenuItem.setMnemonic('c');
    copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    copyMenuItem.addActionListener(this);
    cutMenuItem = new JMenuItem(lz.IDE_EDIT_CUT, KeyEvent.VK_X);
    cutMenuItem.setMnemonic('t');
    cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    cutMenuItem.addActionListener(this);
    pasteMenuItem = new JMenuItem(lz.IDE_EDIT_PASTE, KeyEvent.VK_V);
    pasteMenuItem.setMnemonic('p');
    pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    pasteMenuItem.addActionListener(this);
    undoMenuItem = new JMenuItem(lz.IDE_EDIT_UNDO, KeyEvent.VK_Z);
    undoMenuItem.setMnemonic('u');
    undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    undoMenuItem.addActionListener(this);
    redoMenuItem = new JMenuItem(lz.IDE_EDIT_REDO, KeyEvent.VK_Y);
    redoMenuItem.setMnemonic('r');
    redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
    redoMenuItem.addActionListener(this);
    gotoLineMenuItem = new JMenuItem(lz.IDE_EDIT_GOTO_LINE, KeyEvent.VK_G);
    gotoLineMenuItem.setMnemonic('g');
    gotoLineMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
    gotoLineMenuItem.addActionListener(this);
    selectAllMenuItem = new JMenuItem(lz.IDE_EDIT_SELECT_ALL, KeyEvent.VK_A);
    selectAllMenuItem.setMnemonic('a');
    selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    selectAllMenuItem.addActionListener(this);

    helpMenu = new JMenu(lz.IDE_HELP);
    helpMenu.setMnemonic('h');
    tutorialsMenuItem = new JMenuItem(lz.IDE_HELP_TUTORIALS, KeyEvent.VK_T);
    tutorialsMenuItem.setMnemonic('t');
    tutorialsMenuItem.addActionListener(this);

    functionReferenceMenuItem = new JMenuItem(lz.IDE_HELP_FUNC_REF, KeyEvent.VK_F);
    functionReferenceMenuItem.setMnemonic('f');
    functionReferenceMenuItem.addActionListener(this);
    colorReferenceMenuItem = new JMenuItem(lz.IDE_HELP_COLOR_REF, KeyEvent.VK_C);
    colorReferenceMenuItem.setMnemonic('c');
    colorReferenceMenuItem.addActionListener(this);
    aboutMenuItem = new JMenuItem(lz.IDE_HELP_ABOUT_JUDO, KeyEvent.VK_A);
    aboutMenuItem.setMnemonic('a');
    aboutMenuItem.addActionListener(this);
    judoWebsiteMenuItem = new JMenuItem(lz.IDE_HELP_JUDO_WEBSITE, KeyEvent.VK_W);
    judoWebsiteMenuItem.setMnemonic('w');
    judoWebsiteMenuItem.addActionListener(this);

    setJMenuBar(menuBar);

    menuBar.add(fileMenu);
    fileMenu.add(newMenuItem);
    fileMenu.addSeparator();
    fileMenu.add(openMenuItem);
    fileMenu.add(openSampleMenuItem);
    fileMenu.addSeparator();

    fileMenu.add(saveMenuItem);
    fileMenu.add(saveAsMenuItem);
    fileMenu.addSeparator();
    fileMenu.add(deleteMenuItem);
    fileMenu.addSeparator();
    fileMenu.add(exitMenuItem);

    menuBar.add(editMenu);
    editMenu.add(undoMenuItem);
    editMenu.add(redoMenuItem);
    editMenu.addSeparator();
    editMenu.add(cutMenuItem);
    editMenu.add(copyMenuItem);
    editMenu.add(pasteMenuItem);
    editMenu.addSeparator();
    editMenu.add(selectAllMenuItem);
    editMenu.add(gotoLineMenuItem);

    menuBar.add(helpMenu);
    helpMenu.add(tutorialsMenuItem);
    helpMenu.add(functionReferenceMenuItem);
    helpMenu.add(colorReferenceMenuItem);
    helpMenu.addSeparator();
    helpMenu.add(judoWebsiteMenuItem);
    helpMenu.add(aboutMenuItem);

    runButton = new JButton(lz.IDE_BUTTON_RUN);
    runButton.addActionListener(this);
    runButton.setMnemonic('r');

    JPanel controlPanel = new JPanel();
    controlPanel.add(runButton);
    getContentPane().add(BorderLayout.NORTH, controlPanel);

    outputTextArea = new JTextArea(4, 1);
    outputTextArea.setEditable(false);
    outputTextArea.setFont(new Font("courier", Font.PLAIN, 12));
    //outputTextArea.setTabSize(3); // don't use, carets won't point at errors
    ErrorMessageListener errorMessageListener = new ErrorMessageListener();
    outputTextArea.addMouseListener(errorMessageListener);

    JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

    codeTextArea = new JTextArea();
    codeTextArea.setFont(new Font("courier", Font.PLAIN, 12));
    codeTextArea.setTabSize(3);
    codeTextArea.getDocument().addDocumentListener(this);
    JScrollPane codeScrollPane = new JScrollPane(codeTextArea);

    splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                               codeScrollPane, outputScrollPane);

    splitPane.setOneTouchExpandable(true);
    splitPane.setDividerLocation(230);
    splitPane.setResizeWeight(.75);

    //Provide minimum sizes for the two components in the split pane
    Dimension minimumSize = new Dimension(100, 50);
    codeScrollPane.setMinimumSize(minimumSize);
    outputScrollPane.setMinimumSize(minimumSize);

    getContentPane().add(BorderLayout.CENTER, splitPane);
  }

  public class ErrorMessageListener extends MouseAdapter {
    public void mouseClicked(MouseEvent me) {
      if (me.getClickCount() == 2) {
        String errorText = outputTextArea.getText();
        String errorLineText = "Error on line ";
        if (errorText.indexOf("rror") != -1) {
          int caretIndex = outputTextArea.getCaretPosition();
          int errorIndex = errorText.lastIndexOf(errorLineText, caretIndex);
          if (errorIndex != -1) {
            int colonIndex = errorText.indexOf(":", errorIndex);
            int lineNum = new Integer(errorText.substring(errorIndex + errorLineText.length(), colonIndex)).intValue();
            setLineNumber(lineNum);
          }
        }
      }
    }
  }

  /**
   * This is where it all starts
   */
  public static void main(String args[]) {
    JUDOIDE ide = new JUDOIDE();

    ide.addWindowListener(ide);

    // put it in the top left in case we are on a small screen
    // should fit fine in 640x480
    ide.setLocation(10, 15);
    ide.setSize(JUDO_IDE_WIDTH, JUDO_IDE_HEIGHT);

    ide.setVisible(true);
    ide.codeTextArea.requestFocus();
    ide.codeTextArea.setCaretPosition(0);
  }
  // end - JUDO INITIALIZATION
  ///////////////////////////////////////////////////////////////////////

  ///////////////////////////////////////////////////////////////////////
  // THE FOLLOWING METHODS DEAL WITH COMPILING THE USERS SOURCE
  // AND RUNNING IT
  // end - COMPILING USERS SOURCE AND RUNNING METHODS
  ///////////////////////////////////////////////////////////////////////


  ///////////////////////////////////////////////////////////////////////
  // THE FOLLOWING METHODS MOSTLY DEAL WITH UPDATING THE GUI
  /**
   * Called when error occur
   * TODO Is this used? If not we can remove it.
   * @param errorMsg the message of this error to display
   */
  void alert(String errorMsg) {
    codeTextArea.setText(errorMsg);
  }

  void displayOutput(String output) {
    outputTextArea.setEditable(true);
    outputTextArea.setText(output);
    outputTextArea.setEditable(false);
  }

  public void setLineNumber(int num) {
    int lineNum = 1;
    int lastNewline = 0;
    char text[] = codeTextArea.getText().toCharArray();

    if (num < 1)
      return;

    if (num == 1) {
      codeTextArea.setCaretPosition(0);
      return;
    }

    int i;
    for (i = 0; i < text.length; i++) {
      if (text[i] == '\n') {
        lastNewline = i;
        lineNum++;
      }
      if (num == lineNum) {
        codeTextArea.requestFocus();
        codeTextArea.setCaretPosition(lastNewline + 1);
        return;
      }
    }
  }

  private void enableRun(boolean enabled) {
    runButton.setEnabled(enabled);
  }

  void setJUDOAppDimensions(String appType) {
    if (appType.equals(JUDOBase.jud0_TYPE_GRAPHICS)) {
      appHeight = JUDOBase.jud0_APP_HEIGHT_GRAPHICS;
      appRows = JUDOBase.jud0_APP_GRAPHICS_ROWS;
    }
    else if (appType.equals(JUDOBase.jud0_TYPE_BOTH)) {
      appHeight = JUDOBase.jud0_APP_HEIGHT_BOTH;
      appRows = JUDOBase.jud0_APP_BOTH_ROWS;
    }
    else {
      appHeight = JUDOBase.jud0_APP_HEIGHT_TEXT;
      appRows = JUDOBase.jud0_APP_TEXT_ROWS;
    }
  }

  void exitJUDO(AWTEvent e) {
    if (isDirty) {
      int save;
      save = JOptionPane.showConfirmDialog(this, lz.IDE_EXIT_JUDO_NO_SAVE_MSG,
                                           lz.IDE_EXIT_NO_SAVE_TIT, JOptionPane.YES_NO_OPTION);
      if (save == JOptionPane.YES_OPTION) {
        setVisible(false);
        dispose();
        System.exit(0);
      }
    }
    else {
      setVisible(false);
      dispose();
      System.exit(0);
    }
  }

  public void windowClosing(WindowEvent we) {
    exitJUDO(we);
  }
  public void windowActivated(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowOpened(WindowEvent e) {}

  public void changedUpdate(DocumentEvent e) {
    setDirty();
    judoCompiler.setError(true);
  }
  public void insertUpdate(DocumentEvent e) {
    setDirty();
    judoCompiler.setError(true);
  }
  public void removeUpdate(DocumentEvent e) {
    setDirty();
    judoCompiler.setError(true);
  }
  void setDirty() {
    isDirty = true;
    updateTitle();
  }
  void updateTitle() {
    setTitle(titlePrefix + programName + "*");
  }
  // end - UPDATING THE GUI methods
  ///////////////////////////////////////////////////////////////////////

  /////////////////////////////////////////////////////////////////////////
  // THE FOLLOWING METHODS DEAL MOSTLY WITH JUDO SOURCE FILE OPERATIONS
  boolean save(boolean defaultLocation, boolean saveAs) {
    
    /*
    String filePath = "";

    // if it is the first save, or our last save was to a different save location
    // then make it a save as
    if (programName.equals(defaultProgramName) || defaultLocation != lastSaveDefault) {
      saveAs = true;
    }

    if (saveAs) {
      saveDialog.setTitle(lz.IDE_SAVE_NEW_NAME_TIT);
    }
    else {
      saveDialog.setTitle(lz.IDE_SAVE_TIT);
    }

    // only show save dialog if doing a save as
    if (saveAs) {
      saveDialog.setLocationRelativeTo(this);
      saveDialog.setVisible(true);
      // user hit cancel instead of save
      if (saveDialog.canceled()) {
        return false;
      }
      lastProgramName = programName;
      programName = saveDialog.getProgramName();
      programFilename = saveDialog.getProgramFilename();
    }

    filePath = judoProgramDir + pathSeparator + programFilename + "." + extension;

    // if we are doing a save as and the file exists, we need to ask what to
    // do, otherwise, just save the file.
    if (saveAs && fileExists(filePath)) {
      // display exists option pane
      int decision;
      decision = JOptionPane.showConfirmDialog(this, ju.getString(lz.IDE_PROG_EXISTS_MSG, programName),
                                               lz.IDE_PROG_EXISTS_TIT,
                                               JOptionPane.YES_NO_OPTION,
                                               JOptionPane.QUESTION_MESSAGE);
      // if they say yes, then save it, if not, we're done, return
      if (decision == JOptionPane.YES_OPTION) {
        return writeJUDOFile(defaultLocation);
      }
      else {
        programName = lastProgramName;
        return false;
      }
    }
    else {
      return writeJUDOFile(defaultLocation);
    }

    */
   return false;
  }

  // end JUDO SOURCE FILE OPERATIONS METHODS
  /////////////////////////////////////////////////////////////////////////

  void runCode() {

    // they just hit run, don't let them do it again till running is done.
    enableRun(false);

    // only (re)compile if necessary
    // We could change this so that this check is done in compileCode.
    if (judoCompiler.hasError()) {
      judoCompiler.compileCode();
    }

    // only run java if there were no errors (output in output text area)
    if (!judoCompiler.hasError()) {
      Command java = null;

      if (isWindows) {
        java = new Command(javaString +
                           " -classpath \"" + judoProgramDir + ";" + classpath + "\" " +
                           "JUDOApp",
                           this, false);
      }
      else {
        java = new Command(javaString +
                           " -classpath " + judoProgramDir + ":" + classpath + " " +
                           "JUDOApp",
                            this, false);
      }
      Thread javaThread = new Thread(java);
      javaThread.start();
    }

    enableRun(true);
  }

  /**
   * Save the current JUDO program to disk.
   * This also updates the GUI, letting the user know that the program was saved (or not).
   * @return True if successful, false if unsuccessful.
   */
  private void saveAction() {
    /*
    boolean saveSuccess = false;

    if (saveSuccess) {
      setTitle(titlePrefix + programName);
      isDirty = false;
      lastSaveDefault = true;
    }
    */
  }

  /**
   * Save the current JUDO program to disk, prompting first for the filename.
   * This also updates the GUI, letting the user know that the program was saved (or not).
   * @return True if successful, false if unsuccessful.
   */
  private void saveAsAction() {
    /*
    boolean saveSuccess = false;

    if (saveSuccess) {
      setTitle(titlePrefix + programName);
      isDirty = false;
      lastSaveDefault = true;
    }*/
  }

  private void openAction() {

    if (!shouldDeleteDirtyProgram()) {
      return;
    }

    ArrayList<String> userProgramNames = judoProgramManager.getUserProgramNames();

    if (userProgramNames == null || userProgramNames.size() == 0) {
      JOptionPane.showMessageDialog(this, lz.IDE_NO_PROG_MSG,
                                    lz.IDE_NO_PROG_TIT,
                                    JOptionPane.ERROR_MESSAGE);
      return;
    }

    openDialog = new JUDOOpenDialog(
      this,
      this,
      codeBase + pathSeparator + "images" + pathSeparator + openIconFilename,
      lz.IDE_OPEN_TIT,
      userProgramNames.toArray(new String[userProgramNames.size()])
    );
    openDialog.pack();
    openDialog.setLocationRelativeTo(this);
    openDialog.setVisible(true);

    if (openDialog.canceled()) {
      return;
    }

    String programName = openDialog.getProgramName();
    JUDOProgram openedProgram = null;
    
    try {
      openedProgram = judoProgramManager.openProgram(programName);
    } catch (FileNotFoundException fileNotFoundException) {
      displayOutput(ju.getString(lz.IDE_404_ERR, fileNotFoundException.getMessage()));
    } catch (IOException ioException) {
      displayOutput(ju.getString(lz.IDE_READ_FILE_ERR, ioException.getMessage()));
    }

    if (openedProgram == null || openedProgram.getUserCode() == null) {
      JOptionPane.showMessageDialog(this, ju.getString(lz.IDE_OPEN_PROG_MSG, programName),
                                    lz.IDE_OPEN_PROG_ERR_TIT,
                                    JOptionPane.ERROR_MESSAGE);
      return;
    }

    // Set error because we are opening a new program, and if user hits run
    // we want it to recompile
    judoCompiler.setError(true);

    outputTextArea.setText("");
    codeTextArea.setText(openedProgram.getUserCode());
    isDirty = false;
    setTitle(titlePrefix + openedProgram.getUserTitle());
    codeTextArea.requestFocus();
    codeTextArea.setCaretPosition(0);
  }

  private void openSampleAction() {
    //openHelpItem(lz.IDE_FILE_OPEN_SAMPLE, "SamplePrograms.html", true);
  }

  private void deleteAction() {
    //deleteProgram(true);
  }

  private void newAction() {
    
    if (!shouldDeleteDirtyProgram()) {
      return;
    }

    // Set error because we are opening new program, and if user hits run
    // we want it to recompile
    judoCompiler.setError(true);

    userProgram = judoProgramManager.createNewProgram();

    outputTextArea.setText("");
    codeTextArea.setText(userProgram.getUserCode());
    codeTextArea.requestFocus();
    codeTextArea.setCaretPosition(0);

    // TODO Need to revisit the isDirty design. Can it be merged with judoCompiler.hasError? 
    isDirty = false;
    setTitle(titlePrefix + userProgram.getUserTitle());
  }

  /**
   * If the current program is dirty, we need to confirm that the user wants to delete it without
   * saving changes.
   * @return False if the code should be kept, true if it can be deleted (or if the code isn't dirty).
   */
  private boolean shouldDeleteDirtyProgram() {
    
    // The code has been saved, we don't need to ask.
    if (!isDirty) {
      return true;
    }

    int response = JOptionPane.showConfirmDialog(this, lz.IDE_OPEN_NO_SAVE_MSG,
                                         lz.IDE_OPEN_NO_SAVE_TIT, JOptionPane.YES_NO_OPTION);
    
    return response != JOptionPane.NO_OPTION;
  }

  /////////////////////////////////////////////////////////////////////////
  //  ACTIONPERFORMED
  /**
   * Act on all of JUDO's GUI Events
   * This is a huge method because there are many events that can happen
   * from many different sources.  Mostly menus
   *
   * TODO Need to refactor this function using ideas found at
   * http://alvinalexander.com/java/java-command-design-pattern-in-java-examples
   */
  public void actionPerformed(ActionEvent ae) {

    if (ae.getSource() == runButton) {
      runCode();
    }
    else if (ae.getSource() == exitMenuItem) {
      exitJUDO(ae);
    }
    else if (ae.getSource() == saveMenuItem) {
      saveAction();
    }
    else if (ae.getSource() == saveAsMenuItem) {
      saveAsAction();
    }
    else if (ae.getSource() == openMenuItem) {
      openAction();
    }
    else if (ae.getSource() == openSampleMenuItem) {
      openSampleAction();
    }
    else if (ae.getSource() == deleteMenuItem) {
      deleteAction();
    }
    else if (ae.getSource() == newMenuItem) {
      newAction();
    }
    else if (ae.getSource() == gotoLineMenuItem) {
      String lineNumberString = JOptionPane.showInputDialog(this, lz.IDE_GOTO_LINE_NUM_MSG,
                                                      lz.IDE_GOTO_LINE_NUM_TIT,
                                                      JOptionPane.QUESTION_MESSAGE);
      if (lineNumberString == null) {
        return;
      }

      try {
        int lineNumber = (new Integer(lineNumberString)).intValue();
        int lineCount = codeTextArea.getLineCount();
        if (lineNumber < 1) {
          JOptionPane.showMessageDialog(this, lz.IDE_LINE_NUM_GREATER_MSG,
                                              lz.IDE_INV_LINE_NUM_TIT,
                                              JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        else if (lineNumber > lineCount) {
          JOptionPane.showMessageDialog(this, ju.getString(lz.IDE_LINE_COUNT_MSG, ""+lineCount),
                                              lz.IDE_INV_LINE_NUM_TIT,
                                              JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        setLineNumber(lineNumber);
      } catch (NumberFormatException nfe) {
        if (lineNumberString.equals("")) {
          JOptionPane.showMessageDialog(this, lz.IDE_NO_LINE_NUM_MSG,
                                              lz.IDE_INV_LINE_NUM_TIT,
                                              JOptionPane.ERROR_MESSAGE);
        }
        else {
          JOptionPane.showMessageDialog(this, ju.getString(lz.IDE_LINE_NUM_INV_MSG, lineNumberString),
                                              lz.IDE_INV_LINE_NUM_TIT,
                                              JOptionPane.ERROR_MESSAGE);
        }
      }
    }
    else if (ae.getSource() == undoMenuItem) {
      try {
        undoManager.undo();
      }
      catch (CannotUndoException ex) {
      }
    }
    else if (ae.getSource() == redoMenuItem) {
      try {
        undoManager.redo (); }
      catch (CannotRedoException ex) {
      }
    }
    else if (ae.getSource() == selectAllMenuItem) {
      codeTextArea.requestFocus();
      codeTextArea.selectAll();
    }
    else if (ae.getSource() == copyMenuItem) {
      String selectedText = codeTextArea.getSelectedText();
      if (selectedText == null || selectedText.equals("")) {
        return;
      }
      StringSelection contents = new StringSelection(selectedText);
      clipboard.setContents(contents, null);
    }
    else if (ae.getSource() == cutMenuItem) {
      String selectedText = codeTextArea.getSelectedText();
      if (selectedText == null || selectedText.equals("")) {
        return;
      }
      StringSelection contents = new StringSelection(selectedText);
      clipboard.setContents(contents, null);
      codeTextArea.replaceRange("", codeTextArea.getSelectionStart(), codeTextArea.getSelectionEnd());
    }
    else if (ae.getSource() == pasteMenuItem) {
      Transferable contents = clipboard.getContents(this);
      String val = "";
      try {
        val = (String) contents.getTransferData(DataFlavor.stringFlavor);
      }
      catch(Exception e) {
        System.out.println("Caught Exception in JUDOIDE.actionPerformed() in pasteMenu section.");
        System.out.println("Error reading clipboard?");
        System.out.println(e);
        e.printStackTrace();
      }

      // delete whatever was selected and insert in its place
      codeTextArea.replaceRange("", codeTextArea.getSelectionStart(), codeTextArea.getSelectionEnd());
      codeTextArea.insert(val, codeTextArea.getCaretPosition());
    }

    ///////////////////////////////////////////////
    // THE HELP MENUS
    ///////////////////////////////////////////////
    else if (ae.getSource() == tutorialsMenuItem) {
      openHelpItem(lz.IDE_HELP_JUDO_HELP, "index.html", true);
    }
    else if (ae.getSource() == functionReferenceMenuItem) {
      openHelpItem(lz.IDE_HELP_FUNC_REF, "JUDOAppAPI.html", false);
    }
    else if (ae.getSource() == colorReferenceMenuItem) {
      openHelpItem(lz.IDE_HELP_COLOR_REF, "JUDOColorValues.html", false);
    }
    else if (ae.getSource() == aboutMenuItem) {
      JOptionPane.showMessageDialog(this, ju.getString(lz.IDE_JUDO_ABOUT_MSG, JUDO_VERSION),
                                    " " + lz.IDE_HELP_ABOUT_JUDO,
                                    JOptionPane.INFORMATION_MESSAGE);
    }
    else if (ae.getSource() == judoWebsiteMenuItem) {
      JUDOHelpWindow helpWindow = new JUDOHelpWindow(this, " " + lz.IDE_HELP_JUDO_WEBSITE,
                                      HELP_WINDOW_WIDTH,
                                      HELP_WINDOW_HEIGHT,
                                      true);
      helpWindow.setLocation(40, 60);

      try {
        helpWindow.displayURL(new URL("http://judo.sourceforge.net"));
      }
      catch (Exception e) {}
    }
  }
  //  ACTIONPERFORMED - end
  /////////////////////////////////////////////////////////////////////////

  // open a help file
  private void openHelpItem(String title, String helpFile, boolean allowLinks) {
    JUDOHelpWindow helpWindow = new JUDOHelpWindow(this, " " + title,
                                    HELP_WINDOW_WIDTH,
                                    HELP_WINDOW_HEIGHT,
                                    allowLinks);
    helpWindow.setLocation(40, 60);
    if (isWindows) {
      helpWindow.displayURL("file:/" + codeBase + "/docs/judo/" + helpFile);
    }
    else {
      helpWindow.displayURL("file://" + codeBase + "/docs/judo/" + helpFile);
    }
  }

  public JUDOProgram getUserProgram() {
    return userProgram;
  }

  // TODO Need to fill out stub.
  public int getHeaderLines() {
    return -1;
  }

  // TODO Need to fill out stub.
  public void openSampleProgram(String what) {

  }
}
