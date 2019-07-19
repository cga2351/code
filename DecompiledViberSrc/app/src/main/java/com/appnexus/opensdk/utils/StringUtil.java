package com.appnexus.opensdk.utils;

import android.content.res.Resources;
import java.util.Scanner;

public class StringUtil
{
  public static boolean appendRes(StringBuilder paramStringBuilder, Resources paramResources, int paramInt)
  {
    Scanner localScanner = new Scanner(paramResources.openRawResource(paramInt), "UTF-8").useDelimiter("\\A");
    if (localScanner.hasNext())
    {
      paramStringBuilder.append(localScanner.next());
      localScanner.close();
      return true;
    }
    localScanner.close();
    return false;
  }

  public static int getIntegerValue(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return 0;
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Clog.e(Clog.baseLogTag, "Exception while parsing integer value from string: " + paramString + " - " + localNumberFormatException.getMessage(), localNumberFormatException);
    }
    return 0;
  }

  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.StringUtil
 * JD-Core Version:    0.6.2
 */