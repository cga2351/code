package com.vk.sdk.api;

import com.vk.sdk.util.VKUtil;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class VKParameters extends LinkedHashMap<String, Object>
  implements Serializable
{
  private static final long serialVersionUID = -7183150344504033644L;

  public VKParameters()
  {
  }

  public VKParameters(Map<String, Object> paramMap)
  {
    super(paramMap);
  }

  public static VKParameters from(Object[] paramArrayOfObject)
  {
    return VKUtil.paramsFrom(paramArrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.VKParameters
 * JD-Core Version:    0.6.2
 */