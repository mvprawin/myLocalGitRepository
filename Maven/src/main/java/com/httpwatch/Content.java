package com.httpwatch  ;

import com4j.*;

/**
 * Provides access to the content was read from the cache or downloaded from the server
 */
@IID("{E6086F4F-66DB-40DB-A8BC-11555566A6DA}")
public interface Content extends Com4jObject {
  // Methods:
  /**
   * <p>
   * The type of the content, e.g. text/html or image/gif
   * </p>
   * <p>
   * Getter method for the COM property "MimeType"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(7)
  java.lang.String mimeType();


  /**
   * <p>
   * The size of the content in bytes
   * </p>
   * <p>
   * Getter method for the COM property "Size"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743809) //= 0x60020001. The runtime will prefer the VTID if present
  @VTID(8)
  int size();


  /**
   * <p>
   * Indicates if the content was read from the cache or downloaded from the server
   * </p>
   * <p>
   * Getter method for the COM property "IsFromCache"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(1610743810) //= 0x60020002. The runtime will prefer the VTID if present
  @VTID(9)
  boolean isFromCache();


  /**
   * <p>
   * Indicates if the content was compressed in the HTTP response message from the server
   * </p>
   * <p>
   * Getter method for the COM property "IsCompressed"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(1610743811) //= 0x60020003. The runtime will prefer the VTID if present
  @VTID(10)
  boolean isCompressed();


  /**
   * <p>
   * The compressed size of the content in bytes
   * </p>
   * <p>
   * Getter method for the COM property "CompressedSize"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743812) //= 0x60020004. The runtime will prefer the VTID if present
  @VTID(11)
  int compressedSize();


  /**
   * <p>
   * The type of compression used, e.g. gzip or deflate
   * </p>
   * <p>
   * Getter method for the COM property "CompressionType"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743813) //= 0x60020005. The runtime will prefer the VTID if present
  @VTID(12)
  java.lang.String compressionType();


  /**
   * <p>
   * The actual content data
   * </p>
   * <p>
   * Getter method for the COM property "Data"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743814) //= 0x60020006. The runtime will prefer the VTID if present
  @VTID(13)
  java.lang.String data();


  /**
   * <p>
   * Exports the content to the specified file
   * </p>
   * @param fileName Mandatory java.lang.String parameter.
   */

  @DISPID(1610743815) //= 0x60020007. The runtime will prefer the VTID if present
  @VTID(14)
  void export(
    java.lang.String fileName);


  /**
   * <p>
   * Indicates if the content is an image
   * </p>
   * <p>
   * Getter method for the COM property "IsImage"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(1610743816) //= 0x60020008. The runtime will prefer the VTID if present
  @VTID(15)
  boolean isImage();


  /**
   * <p>
   * Indicates if the content is an image
   * </p>
   * <p>
   * Getter method for the COM property "ImageWidth"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743817) //= 0x60020009. The runtime will prefer the VTID if present
  @VTID(16)
  int imageWidth();


  /**
   * <p>
   * Indicates if the content is an image
   * </p>
   * <p>
   * Getter method for the COM property "ImageHeight"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743818) //= 0x6002000a. The runtime will prefer the VTID if present
  @VTID(17)
  int imageHeight();


  // Properties:
}
