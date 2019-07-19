package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzuq
{
  private static final Charset ISO_8859_1;
  static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final byte[] zzbzc;
  private static final ByteBuffer zzbzd;
  private static final zztq zzbze = zztq.zza(arrayOfByte2, 0, arrayOfByte2.length, false);

  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] arrayOfByte1 = new byte[0];
    zzbzc = arrayOfByte1;
    zzbzd = ByteBuffer.wrap(arrayOfByte1);
    byte[] arrayOfByte2 = zzbzc;
  }

  static <T> T checkNotNull(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    return paramT;
  }

  public static int hashCode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = zza(i, paramArrayOfByte, 0, i);
    if (j == 0)
      j = 1;
    return j;
  }

  static int zza(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    for (int i = paramInt2; i < paramInt2 + paramInt3; i++)
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
    return paramInt1;
  }

  static <T> T zza(T paramT, String paramString)
  {
    if (paramT == null)
      throw new NullPointerException(paramString);
    return paramT;
  }

  static Object zzb(Object paramObject1, Object paramObject2)
  {
    return ((zzvv)paramObject1).zzwh().zza((zzvv)paramObject2).zzwn();
  }

  public static int zzbd(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }

  static boolean zzf(zzvv paramzzvv)
  {
    return false;
  }

  public static boolean zzl(byte[] paramArrayOfByte)
  {
    return zzxl.zzl(paramArrayOfByte);
  }

  public static String zzm(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, UTF_8);
  }

  public static int zzu(boolean paramBoolean)
  {
    if (paramBoolean)
      return 1231;
    return 1237;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzuq
 * JD-Core Version:    0.6.2
 */