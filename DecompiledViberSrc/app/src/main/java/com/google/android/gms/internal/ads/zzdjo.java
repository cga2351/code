package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

public final class zzdjo
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");

  public static byte[] decode(String paramString)
  {
    byte[] arrayOfByte1 = paramString.getBytes(UTF_8);
    int i = arrayOfByte1.length;
    zzdjq localzzdjq = new zzdjq(2, new byte[i * 3 / 4]);
    if (!localzzdjq.zzb(arrayOfByte1, 0, i, true))
      throw new IllegalArgumentException("bad base-64");
    if (localzzdjq.zzgya == localzzdjq.zzgxz.length)
      return localzzdjq.zzgxz;
    byte[] arrayOfByte2 = new byte[localzzdjq.zzgya];
    System.arraycopy(localzzdjq.zzgxz, 0, arrayOfByte2, 0, localzzdjq.zzgya);
    return arrayOfByte2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjo
 * JD-Core Version:    0.6.2
 */