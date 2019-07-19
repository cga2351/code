package com.mopub.common.util;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings
{
  private static Pattern a = Pattern.compile("((\\d{1,2})|(100))%");
  private static Pattern b = Pattern.compile("\\d{2}:\\d{2}:\\d{2}(.\\d{3})?");

  public static String fromStream(InputStream paramInputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    byte[] arrayOfByte = new byte[4096];
    for (int i = 0; i != -1; i = paramInputStream.read(arrayOfByte))
      localStringBuilder.append(new String(arrayOfByte, 0, i));
    paramInputStream.close();
    return localStringBuilder.toString();
  }

  public static String getDelimitedString(Object paramObject, String paramString)
  {
    if (!(paramObject instanceof List))
      return "";
    List localList = (List)paramObject;
    if (localList.isEmpty())
      return "";
    if (paramString != null);
    while (true)
    {
      return TextUtils.join(paramString, localList);
      paramString = ", ";
    }
  }

  public static boolean isAbsoluteTracker(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (b.matcher(paramString).matches());
  }

  public static boolean isPercentageTracker(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (a.matcher(paramString).matches());
  }

  public static Integer parseAbsoluteOffset(String paramString)
  {
    if (paramString == null);
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = paramString.split(":");
    }
    while (arrayOfString.length != 3);
    return Integer.valueOf(1000 * (60 * (60 * Integer.parseInt(arrayOfString[0]))) + 1000 * (60 * Integer.parseInt(arrayOfString[1])) + (int)(1000.0F * Float.parseFloat(arrayOfString[2])));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Strings
 * JD-Core Version:    0.6.2
 */