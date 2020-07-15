package com.httpwatch  ;

import com4j.*;

/**
 * Version compatibility interface
 */
@IID("{599C06FF-EECA-409D-AC55-B6927E6D6886}")
public interface z_v11_1_15_Chrome extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Create a new tab within Chrome and access it via HttpWatch
   * </p>
   * @param chromeChannel Optional parameter. Default value is ""
   * @return  Returns a value of type com.httpwatch.Plugin
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(7)
  com.httpwatch.Plugin _new(
    @Optional @DefaultValue("") java.lang.String chromeChannel);


  // Properties:
}
