package com.viber.voip.util.f;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public static boolean a()
  {
    String str = System.getProperty("java.vm.version");
    boolean bool1 = false;
    Matcher localMatcher;
    if (str != null)
    {
      localMatcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
      boolean bool2 = localMatcher.matches();
      bool1 = false;
      if (!bool2);
    }
    try
    {
      int i = Integer.parseInt(localMatcher.group(1));
      int j = Integer.parseInt(localMatcher.group(2));
      if (i <= 2)
      {
        bool1 = false;
        if (i == 2)
        {
          bool1 = false;
          if (j < 1);
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.f.a
 * JD-Core Version:    0.6.2
 */