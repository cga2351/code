package com.adjust.sdk;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class MacAddressUtil
{
  public static String getMacAddress(Context paramContext)
  {
    String str = getRawMacAddress(paramContext);
    if (str == null)
      return null;
    return removeSpaceString(str.toUpperCase(Locale.US));
  }

  private static String getRawMacAddress(Context paramContext)
  {
    Object localObject = loadAddress("wlan0");
    if (localObject != null);
    while (true)
    {
      return localObject;
      localObject = loadAddress("eth0");
      if (localObject != null)
        continue;
      try
      {
        String str = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        localObject = str;
        if (localObject != null)
          continue;
        label44: return null;
      }
      catch (Exception localException)
      {
        break label44;
      }
    }
  }

  private static String loadAddress(String paramString)
  {
    try
    {
      String str1 = "/sys/class/net/" + paramString + "/address";
      StringBuilder localStringBuilder = new StringBuilder(1000);
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(str1), 1024);
      char[] arrayOfChar = new char[1024];
      while (true)
      {
        int i = localBufferedReader.read(arrayOfChar);
        if (i == -1)
          break;
        localStringBuilder.append(String.valueOf(arrayOfChar, 0, i));
      }
      localBufferedReader.close();
      String str2 = localStringBuilder.toString();
      return str2;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  private static String removeSpaceString(String paramString)
  {
    if (paramString == null);
    String str;
    do
    {
      return null;
      str = paramString.replaceAll("\\s", "");
    }
    while (TextUtils.isEmpty(str));
    return str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.MacAddressUtil
 * JD-Core Version:    0.6.2
 */