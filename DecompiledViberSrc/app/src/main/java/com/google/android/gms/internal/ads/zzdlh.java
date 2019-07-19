package com.google.android.gms.internal.ads;

public final class zzdlh
{
  public static byte[] decode(String paramString)
  {
    if (paramString.length() % 2 != 0)
      throw new IllegalArgumentException("Expected a string of even length");
    int i = paramString.length() / 2;
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j < i; j++)
    {
      int k = Character.digit(paramString.charAt(j * 2), 16);
      int m = Character.digit(paramString.charAt(1 + j * 2), 16);
      if ((k == -1) || (m == -1))
        throw new IllegalArgumentException("input is not hexadecimal");
      arrayOfByte[j] = ((byte)(m + (k << 4)));
    }
    return arrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdlh
 * JD-Core Version:    0.6.2
 */