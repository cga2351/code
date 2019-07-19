package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

final class zzxl
{
  private static final zzxn zzcdi;

  static
  {
    int i;
    if ((zzxj.zzyo()) && (zzxj.zzyp()))
    {
      i = 1;
      if ((i == 0) || (zztb.zzub()))
        break label42;
    }
    label42: for (Object localObject = new zzxq(); ; localObject = new zzxo())
    {
      zzcdi = (zzxn)localObject;
      return;
      i = 0;
      break;
    }
  }

  static int zza(CharSequence paramCharSequence)
  {
    int i = 0;
    int j = paramCharSequence.length();
    for (int k = 0; (k < j) && (paramCharSequence.charAt(k) < ''); k++);
    while (true)
    {
      int m;
      if (k < j)
      {
        int i1 = paramCharSequence.charAt(k);
        if (i1 < 2048)
        {
          m += (127 - i1 >>> 31);
          k++;
        }
        else
        {
          int i2 = paramCharSequence.length();
          if (k < i2)
          {
            int i3 = paramCharSequence.charAt(k);
            if (i3 < 2048)
              i += (127 - i3 >>> 31);
            while (true)
            {
              k++;
              break;
              i += 2;
              if ((55296 <= i3) && (i3 <= 57343))
              {
                if (Character.codePointAt(paramCharSequence, k) < 65536)
                  throw new zzxp(k, i2);
                k++;
              }
            }
          }
        }
      }
      else
      {
        for (int n = m + i; ; n = m)
        {
          if (n < j)
          {
            long l = 4294967296L + n;
            throw new IllegalArgumentException(54 + "UTF-8 length does not fit in int: " + l);
          }
          return n;
        }
        m = j;
      }
    }
  }

  static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zzcdi.zzb(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }

  static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    zzxn localzzxn = zzcdi;
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), i + paramByteBuffer.position(), paramByteBuffer.remaining()) - i);
      return;
    }
    if (paramByteBuffer.isDirect())
    {
      localzzxn.zzb(paramCharSequence, paramByteBuffer);
      return;
    }
    zzxn.zzc(paramCharSequence, paramByteBuffer);
  }

  private static int zzbz(int paramInt)
  {
    if (paramInt > -12)
      paramInt = -1;
    return paramInt;
  }

  private static int zzc(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65))
      return -1;
    return paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16;
  }

  public static boolean zzf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zzcdi.zzf(paramArrayOfByte, paramInt1, paramInt2);
  }

  private static int zzg(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    switch (paramInt2 - paramInt1)
    {
    default:
      throw new AssertionError();
    case 0:
      return zzbz(i);
    case 1:
      return zzq(i, paramArrayOfByte[paramInt1]);
    case 2:
    }
    return zzc(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
  }

  static String zzh(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzuv
  {
    return zzcdi.zzh(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static boolean zzl(byte[] paramArrayOfByte)
  {
    return zzcdi.zzf(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  private static int zzq(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65))
      return -1;
    return paramInt1 ^ paramInt2 << 8;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzxl
 * JD-Core Version:    0.6.2
 */