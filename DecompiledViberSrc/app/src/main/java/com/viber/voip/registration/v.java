package com.viber.voip.registration;

import com.viber.voip.util.ce;
import java.util.regex.Pattern;

public class v
{
  public boolean a(String paramString1, String paramString2)
  {
    if (("683".equals(paramString1)) && (paramString2.matches(Pattern.compile("\\d{4}").toString())))
      return true;
    return paramString2.matches(ce.m.toString());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.v
 * JD-Core Version:    0.6.2
 */