package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzdra
{
  private static final zzdrc zzhmg;

  static
  {
    int i;
    if ((zzdqy.zzbac()) && (zzdqy.zzbad()))
    {
      i = 1;
      if ((i == 0) || (zzdml.zzavl()))
        break label42;
    }
    label42: for (Object localObject = new zzdrf(); ; localObject = new zzdrd())
    {
      zzhmg = (zzdrc)localObject;
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
                  throw new zzdre(k, i2);
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
    return zzhmg.zzb(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }

  static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    zzdrc localzzdrc = zzhmg;
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), i + paramByteBuffer.position(), paramByteBuffer.remaining()) - i);
      return;
    }
    if (paramByteBuffer.isDirect())
    {
      localzzdrc.zzb(paramCharSequence, paramByteBuffer);
      return;
    }
    zzdrc.zzc(paramCharSequence, paramByteBuffer);
  }

  public static boolean zzad(byte[] paramArrayOfByte)
  {
    return zzhmg.zzl(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  private static int zzam(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65))
      return -1;
    return paramInt1 ^ paramInt2 << 8;
  }

  private static int zzh(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65))
      return -1;
    return paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16;
  }

  private static int zzhb(int paramInt)
  {
    if (paramInt > -12)
      paramInt = -1;
    return paramInt;
  }

  public static boolean zzl(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return zzhmg.zzl(paramArrayOfByte, paramInt1, paramInt2);
  }

  private static int zzm(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    switch (paramInt2 - paramInt1)
    {
    default:
      throw new AssertionError();
    case 0:
      return zzhb(i);
    case 1:
      return zzam(i, paramArrayOfByte[paramInt1]);
    case 2:
    }
    return zzh(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
  }

  static String zzn(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzdoj
  {
    return zzhmg.zzn(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdra
 * JD-Core Version:    0.6.2
 */