package com.viber.voip.user.more;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MoreScreenProductsOrder
{
  public static final String ORDER1 = "Original";
  public static final String ORDER2 = "Variant2";
  public static final String ORDER3 = "Variant3";

  public static class Helper
  {
    static String fromBucket(String paramString)
    {
      if ("Variant2".equals(paramString))
        return "Variant2";
      if ("Variant3".equals(paramString))
        return "Variant3";
      return "Original";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreScreenProductsOrder
 * JD-Core Version:    0.6.2
 */