package com.vk.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.vk.sdk.api.VKParameters;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VKUtil
{
  static
  {
    if (!VKUtil.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public static Map<String, String> explodeQueryString(String paramString)
  {
    Object localObject;
    if (paramString == null)
      localObject = null;
    while (true)
    {
      return localObject;
      String[] arrayOfString1 = paramString.split("&");
      localObject = new HashMap(arrayOfString1.length);
      int i = arrayOfString1.length;
      for (int j = 0; j < i; j++)
      {
        String[] arrayOfString2 = arrayOfString1[j].split("=");
        ((HashMap)localObject).put(arrayOfString2[0], arrayOfString2[1]);
      }
    }
  }

  public static String fileToString(String paramString)
    throws IOException
  {
    BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
    StringBuilder localStringBuilder = new StringBuilder();
    while (true)
    {
      String str = localBufferedReader.readLine();
      if (str == null)
        break;
      localStringBuilder.append(str);
    }
    localBufferedReader.close();
    return localStringBuilder.toString();
  }

  public static String getApplicationName(Context paramContext)
  {
    try
    {
      Context localContext = paramContext.getApplicationContext();
      assert (localContext != null);
      PackageManager localPackageManager = localContext.getPackageManager();
      assert (localPackageManager != null);
      ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      if (localApplicationInfo != null);
      for (Object localObject = localPackageManager.getApplicationLabel(localApplicationInfo); ; localObject = "(unknown)")
        return (String)localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String[] getCertificateFingerprint(Context paramContext, String paramString)
  {
    int i = 0;
    if (paramContext != null);
    try
    {
      if (paramContext.getPackageManager() != null)
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
        assert (localPackageInfo.signatures != null);
        arrayOfString = new String[localPackageInfo.signatures.length];
        Signature[] arrayOfSignature = localPackageInfo.signatures;
        int j = arrayOfSignature.length;
        int m;
        for (int k = 0; i < j; k = m)
        {
          Signature localSignature = arrayOfSignature[i];
          MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
          localMessageDigest.update(localSignature.toByteArray());
          m = k + 1;
          arrayOfString[k] = toHex(localMessageDigest.digest());
          i++;
        }
      }
      String[] arrayOfString = null;
      return arrayOfString;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String getHost(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    int i = paramString.indexOf("//");
    int j;
    int k;
    if (i == -1)
    {
      j = 0;
      k = paramString.indexOf('/', j);
      if (k < 0)
        break label77;
    }
    while (true)
    {
      int m = paramString.indexOf(':', j);
      if ((m > 0) && (m < k))
        k = m;
      return paramString.substring(j, k);
      j = i + 2;
      break;
      label77: k = paramString.length();
    }
  }

  public static boolean isAppInstalled(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      assert (localPackageManager != null);
      localPackageManager.getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static boolean isIntentAvailable(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent(paramString);
    assert (localPackageManager != null);
    return localPackageManager.queryIntentActivities(localIntent, 65536).size() > 0;
  }

  public static Map<String, Object> mapFrom(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length % 2 != 0);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(paramArrayOfObject.length / 2);
    int i = 0;
    if (i + 1 < paramArrayOfObject.length)
    {
      if ((paramArrayOfObject[i] == null) || (paramArrayOfObject[(i + 1)] == null) || (!(paramArrayOfObject[i] instanceof String)));
      while (true)
      {
        i += 2;
        break;
        localLinkedHashMap.put((String)paramArrayOfObject[i], paramArrayOfObject[(i + 1)]);
      }
    }
    return localLinkedHashMap;
  }

  public static String md5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = arrayOfByte.length;
      for (int j = 0; j < i; j++)
      {
        for (String str1 = Integer.toHexString(0xFF & arrayOfByte[j]); str1.length() < 2; str1 = "0" + str1);
        localStringBuilder.append(str1);
      }
      String str2 = localStringBuilder.toString();
      return str2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return "";
  }

  public static VKParameters paramsFrom(Object[] paramArrayOfObject)
  {
    return new VKParameters(mapFrom(paramArrayOfObject));
  }

  public static void stringToFile(String paramString1, String paramString2)
  {
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(paramString1));
      localBufferedWriter.write(paramString2);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private static String toHex(byte[] paramArrayOfByte)
  {
    BigInteger localBigInteger = new BigInteger(1, paramArrayOfByte);
    return String.format("%0" + (paramArrayOfByte.length << 1) + "X", new Object[] { localBigInteger });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.util.VKUtil
 * JD-Core Version:    0.6.2
 */