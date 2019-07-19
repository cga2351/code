package com.google.android.gms.internal.ads;

import android.util.Base64;

public final class zzcg
{
  public static String zza(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 11; ; i = 2)
      return Base64.encodeToString(paramArrayOfByte, i);
  }

  public static byte[] zza(String paramString, boolean paramBoolean)
    throws IllegalArgumentException
  {
    int i;
    byte[] arrayOfByte;
    String str1;
    if (paramBoolean)
    {
      i = 11;
      arrayOfByte = Base64.decode(paramString, i);
      if ((arrayOfByte.length != 0) || (paramString.length() <= 0))
        break label77;
      str1 = String.valueOf(paramString);
      if (str1.length() == 0)
        break label63;
    }
    label63: for (String str2 = "Unable to decode ".concat(str1); ; str2 = new String("Unable to decode "))
    {
      throw new IllegalArgumentException(str2);
      i = 2;
      break;
    }
    label77: return arrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcg
 * JD-Core Version:    0.6.2
 */