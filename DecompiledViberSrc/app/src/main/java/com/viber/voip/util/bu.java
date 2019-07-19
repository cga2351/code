package com.viber.voip.util;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.b.a;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bu
{
  private static final Logger a = ViberEnv.getLogger();

  public static String a(String paramString)
  {
    return a(paramString.getBytes());
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      return z.b(localMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return null;
  }

  public static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    MessageDigest localMessageDigest;
    byte[] arrayOfByte1;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      arrayOfByte1 = a.a(8192);
      try
      {
        while (true)
        {
          int i = paramInputStream.read(arrayOfByte1);
          if (i <= 0)
            break;
          localMessageDigest.update(arrayOfByte1, 0, i);
        }
      }
      finally
      {
        a.a(arrayOfByte1);
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new IOException(localNoSuchAlgorithmException);
    }
    byte[] arrayOfByte2 = localMessageDigest.digest();
    a.a(arrayOfByte1);
    return arrayOfByte2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bu
 * JD-Core Version:    0.6.2
 */