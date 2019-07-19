package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.util.Base64;
import com.yandex.metrica.impl.w;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class oj
{
  public static String a(Context paramContext, String paramString)
    throws UnsupportedEncodingException
  {
    return Base64.encodeToString(b(paramContext, w.b(paramString).getBytes("UTF-8")), 0);
  }

  public static String a(Context paramContext, byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    byte[] arrayOfByte = b(paramContext, Base64.decode(paramArrayOfByte, 0));
    String str = null;
    if (arrayOfByte != null)
      str = w.c(new String(arrayOfByte, "UTF-8"));
    return str;
  }

  public static byte[] a(String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    localMessageDigest.reset();
    localMessageDigest.update(paramString.getBytes("UTF-8"));
    return localMessageDigest.digest();
  }

  private static byte[] b(Context paramContext, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1;
    try
    {
      byte[] arrayOfByte2 = a(paramContext.getPackageName());
      arrayOfByte1 = new byte[paramArrayOfByte.length];
      for (int i = 0; i < paramArrayOfByte.length; i++)
        arrayOfByte1[i] = ((byte)(paramArrayOfByte[i] ^ arrayOfByte2[(i % arrayOfByte2.length)]));
    }
    catch (Exception localException)
    {
      arrayOfByte1 = null;
    }
    return arrayOfByte1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.oj
 * JD-Core Version:    0.6.2
 */