package org.onepf.oms.appstore.nokiaUtils;

import org.onepf.oms.SkuMappingException;

public class NokiaSkuFormatException extends SkuMappingException
{
  public NokiaSkuFormatException()
  {
    super("Nokia Store SKU can contain only digits.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.onepf.oms.appstore.nokiaUtils.NokiaSkuFormatException
 * JD-Core Version:    0.6.2
 */