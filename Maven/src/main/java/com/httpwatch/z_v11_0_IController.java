package com.httpwatch  ;

import com4j.*;

/**
 * Version 10.0 - 11.0 compatibility interface
 */
@IID("{9EF1CD3C-EFBD-402A-98BF-D9FB9AF510FA}")
public interface z_v11_0_IController extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Used to access Internet Explorer plugin
   * </p>
   * <p>
   * Getter method for the COM property "IE"
   * </p>
   * @return  Returns a value of type com.httpwatch.IE
   */

  @DISPID(100) //= 0x64. The runtime will prefer the VTID if present
  @VTID(7)
  com.httpwatch.IE ie();


  /**
   * <p>
   * No longer available in HttpWatch 11+
   * </p>
   * <p>
   * Getter method for the COM property "Firefox"
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(101) //= 0x65. The runtime will prefer the VTID if present
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject firefox();


  /**
   * <p>
   * Opens an HttpWatch log file (.hwl)
   * </p>
   * @param fileName Mandatory java.lang.String parameter.
   * @return  Returns a value of type com.httpwatch.Log
   */

  @DISPID(102) //= 0x66. The runtime will prefer the VTID if present
  @VTID(9)
  com.httpwatch.Log openLog(
    java.lang.String fileName);


  /**
   * <p>
   * Waits for the current page to be downloaded
   * </p>
   * @param plugin Mandatory com.httpwatch.Plugin parameter.
   * @param timeOutSecs Mandatory int parameter.
   * @return  Returns a value of type boolean
   */

  @DISPID(103) //= 0x67. The runtime will prefer the VTID if present
  @VTID(10)
  boolean wait_(
    com.httpwatch.Plugin plugin,
    int timeOutSecs);


  /**
   * <p>
   * Set to true if HttpWatch Basic Edition is installed
   * </p>
   * <p>
   * Getter method for the COM property "IsBasicEdition"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(104) //= 0x68. The runtime will prefer the VTID if present
  @VTID(11)
  boolean isBasicEdition();


  /**
   * <p>
   * The version of HttpWatch being used.
   * </p>
   * <p>
   * Getter method for the COM property "Version"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(105) //= 0x69. The runtime will prefer the VTID if present
  @VTID(12)
  java.lang.String version();


  /**
   * <p>
   * Waits for the current page to be downloaded
   * </p>
   * @param plugin Mandatory com.httpwatch.Plugin parameter.
   * @param timeOutSecs Mandatory int parameter.
   * @param waitForPageLoadEvent Mandatory boolean parameter.
   * @param waitForRenderStartEvent Mandatory boolean parameter.
   * @param httpIdleSecs Mandatory int parameter.
   * @return  Returns a value of type boolean
   */

  @DISPID(106) //= 0x6a. The runtime will prefer the VTID if present
  @VTID(13)
  boolean waitEx(
    com.httpwatch.Plugin plugin,
    int timeOutSecs,
    boolean waitForPageLoadEvent,
    boolean waitForRenderStartEvent,
    int httpIdleSecs);


  /**
   * <p>
   * Attach HttpWatch to an existing instance of Internet Explorer that has a page with the specified title
   * </p>
   * @param pageTitle Mandatory java.lang.String parameter.
   * @return  Returns a value of type com.httpwatch.Plugin
   */

  @DISPID(107) //= 0x6b. The runtime will prefer the VTID if present
  @VTID(14)
  com.httpwatch.Plugin attachByTitle(
    java.lang.String pageTitle);


  // Properties:
}
