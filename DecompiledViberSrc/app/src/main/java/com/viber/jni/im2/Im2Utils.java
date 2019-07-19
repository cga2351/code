package com.viber.jni.im2;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Im2Utils
{
  public static <T> T checkArrayValue(T paramT, Class paramClass)
  {
    if (paramT != null)
      return paramT;
    return Array.newInstance(paramClass.getComponentType(), 0);
  }

  public static <K, V> Map<K, V> checkMapValue(Map<K, V> paramMap)
  {
    if (paramMap != null)
      return paramMap;
    return new HashMap();
  }

  public static <T> Set<T> checkSetValue(Set<T> paramSet)
  {
    if (paramSet != null)
      return paramSet;
    return new HashSet();
  }

  public static String checkStringValue(String paramString)
  {
    if (paramString != null)
      return paramString;
    return "";
  }

  public static <T> T checkStructValue(T paramT)
  {
    return paramT;
  }

  public static boolean isSecondaryDevice(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 20) || (paramInt == 21) || (paramInt == 98);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.Im2Utils
 * JD-Core Version:    0.6.2
 */