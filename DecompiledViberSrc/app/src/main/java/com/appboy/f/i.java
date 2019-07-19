package com.appboy.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.security.MessageDigest;

public final class i
{
  private static final String a = c.a(i.class);

  public static int a(String paramString1, String paramString2)
  {
    return -1 + paramString1.split(paramString2, -1).length;
  }

  public static String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }

  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null)
      paramString1 = "null";
    if (paramString1.equals("null"))
      return b("37a6259cc0c1dae299a7866489dff0bd", paramString2);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.appboy.support.stringutils.cachefilesuffix", 0);
    String str1 = localSharedPreferences.getString("user_id_key", null);
    if ((str1 != null) && (str1.equals(paramString1)))
    {
      String str3 = localSharedPreferences.getString("user_id_hash_value", null);
      if (!b(str3))
        return b(str3, paramString2);
      c.b(a, "The saved user id hash was null or empty.");
    }
    c.b(a, "Generating MD5 for user id: " + paramString1 + " apiKey: " + paramString2);
    String str2 = e(paramString1);
    if (str2 == null)
      str2 = Integer.toString(paramString1.hashCode());
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putString("user_id_key", paramString1);
    localEditor.putString("user_id_hash_value", str2);
    localEditor.apply();
    return b(str2, paramString2);
  }

  public static String a(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException("Provided String must be non-null.");
    if (paramString.length() == 0)
      throw new IllegalArgumentException("Provided String must be non-empty.");
    return paramString;
  }

  private static String b(String paramString1, String paramString2)
  {
    if (c(paramString2))
      return "." + paramString1;
    return "." + paramString1 + "." + paramString2;
  }

  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }

  public static String d(String paramString)
  {
    if (paramString.trim().equals(""))
      paramString = null;
    return paramString;
  }

  public static String e(String paramString)
  {
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      StringBuilder localStringBuilder = new StringBuilder();
      int i = arrayOfByte.length;
      for (int j = 0; j < i; j++)
        localStringBuilder.append(Integer.toHexString(0x100 | 0xFF & arrayOfByte[j]).substring(1, 3));
      String str = localStringBuilder.toString();
      return str;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to calculate MD5 hash", localException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.i
 * JD-Core Version:    0.6.2
 */