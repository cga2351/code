package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class zzbc
{
  public static int zza(byte paramByte)
  {
    if (paramByte < 0)
      paramByte += 256;
    return paramByte;
  }

  public static long zza(ByteBuffer paramByteBuffer)
  {
    long l = paramByteBuffer.getInt();
    if (l < 0L)
      l += 4294967296L;
    return l;
  }

  public static int zzb(ByteBuffer paramByteBuffer)
  {
    return 0 + (zza(paramByteBuffer.get()) << 8) + zza(paramByteBuffer.get());
  }

  public static long zzc(ByteBuffer paramByteBuffer)
  {
    long l = 0L + (zza(paramByteBuffer) << 32);
    if (l < 0L)
      throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    return l + zza(paramByteBuffer);
  }

  public static double zzd(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    return (0x0 | 0xFF000000 & arrayOfByte[0] << 24 | 0xFF0000 & arrayOfByte[1] << 16 | 0xFF00 & arrayOfByte[2] << 8 | 0xFF & arrayOfByte[3]) / 65536.0D;
  }

  public static double zze(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    return (0x0 | 0xFF000000 & arrayOfByte[0] << 24 | 0xFF0000 & arrayOfByte[1] << 16 | 0xFF00 & arrayOfByte[2] << 8 | 0xFF & arrayOfByte[3]) / 1073741824.0D;
  }

  public static String zzf(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[4];
    paramByteBuffer.get(arrayOfByte);
    try
    {
      String str = new String(arrayOfByte, "ISO-8859-1");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbc
 * JD-Core Version:    0.6.2
 */