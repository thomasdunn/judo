package org.judo;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Contains a headermap
 * Has getter and setters for the three properties in headermap
 *   type (graphics, text, or both)
 *   name
 *   JUDO version
 * Has getter and setter for JUDO code.
 */
public class JUDOProgram {
  
  private static final String JUDO_VERSION = "JUDO_VERSION";
  private static final String JUDOAPP_USER_TITLE = "JUDOAPP_USER_TITLE";
  private static final String JUDOAPP_TYPE = "JUDOAPP_TYPE";

  private final String defaultUserTitle = "";

  private String userCode;

  // Headers to put at the top of users' program
  private HashMap<String, String> metadata;

  public JUDOProgram() {
    metadata = new HashMap();
    setUserTitle(JUDOIDE.lz.IDE_DEFAULT_PROG_NAME);
    setAppType(JUDOBase.jud0_TYPE_BOTH);
  }

  /**
   * Given the contents of a .judo file, this parses the file and stores in memory metadata found in the
   * header of the file.
   * To insure data accuracy, this corrects errors in the metadata if found (i.e. a program marked
   * as a GRAPHICS program will be updated to one marked as BOTH if text functions are also used.)
   * @param  userCode A String containing the code that is presentable to the user.
   * @param  metadata A Map containing metadata key-value pairs.
   */
  public JUDOProgram(String userCode, Map<String, String> metadata) {
    this.metadata = new HashMap<String, String>();
    this.metadata.putAll(metadata);
    setUserCode(userCode);
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
    determineProgramType();
  }

  public String getUserCode() {
    return userCode;
  }

  // TODO Change to enum?
  public String getProgramType() {
    return (String) metadata.get(JUDOAPP_TYPE);
  }

  public String getJUDOVersion() {
    return (String) metadata.get(JUDO_VERSION);
  }

  // TODO remove/replace with name.
  public String getUserTitle() {
    return (String) metadata.get(JUDOAPP_USER_TITLE);
  }

  public void setUserTitle(String userTitle) {
    metadata.put(JUDOAPP_USER_TITLE, userTitle);
  }

  private void setAppType(String appType) {
    metadata.put(JUDOAPP_TYPE, appType);
  }

  /**
   * Determines the program type by reading the program code and seeing
   * what functions are called.
   */
  private void determineProgramType() {

    String[] textFunctionNames = "printLine,print,readString,readInt,readDouble,readBoolean,readColor"
      .split(",", -1);
    String[] graphicFunctionNames = "drawLine,drawRectangle,fillRectangle,clearRectange,clearDrawing,drawOval,fillOval,drawCircle,fillCircle,drawString,setBackgroundColor,setColor,getDrawingWidth,getDrawingHeight,drawPolygon,fillPolygon,getMouseEvent,getMouseX,getMouseY,getDragStartX,getDragStartY,getDragEndX,getDragEndY,getMouseButton"
      .split(",", -1);


    boolean hasText = doesCodeContainFunctionSet(userCode, textFunctionNames);
    boolean hasGraphics = doesCodeContainFunctionSet(userCode, graphicFunctionNames);

    if (hasText && !hasGraphics) {
      setAppType(JUDOBase.jud0_TYPE_TEXT);
    } else if (!hasText && hasGraphics) {
      setAppType(JUDOBase.jud0_TYPE_GRAPHICS);
    } else {
      setAppType(JUDOBase.jud0_TYPE_BOTH);
    }

  }

  /**
   * See if the code contains any member of the functionSet array, as defined by {@String.contains}.
   * @param  code        Program code to check against.
   * @param  functionSet List of functions to check for.
   * @return             True if code contains any member of functionSet, false if code contains no member of functionSet.
   */
  private boolean doesCodeContainFunctionSet(String code, String[] functionSet) {
    
    for (String functionName : functionSet) {
      if (code.contains(functionName)) {
        return true;
      }
    }
    return false;
  }
  
}
