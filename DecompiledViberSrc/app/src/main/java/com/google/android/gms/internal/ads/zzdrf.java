package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzdrf extends zzdrc
{
  private static int zza(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    switch (paramInt2)
    {
    default:
      throw new AssertionError();
    case 0:
      return zzdra.zzhc(paramInt1);
    case 1:
      return zzdra.zzan(paramInt1, zzdqy.zza(paramArrayOfByte, paramLong));
    case 2:
    }
    return zzdra.zzi(paramInt1, zzdqy.zza(paramArrayOfByte, paramLong), zzdqy.zza(paramArrayOfByte, 1L + paramLong));
  }

  final int zzb(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt2 | paramInt3 | paramArrayOfByte.length - paramInt3) < 0)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramArrayOfByte.length);
      arrayOfObject[1] = Integer.valueOf(paramInt2);
      arrayOfObject[2] = Integer.valueOf(paramInt3);
      throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", arrayOfObject));
    }
    long l1 = paramInt2;
    int i = (int)(paramInt3 - l1);
    int j;
    long l3;
    int m;
    if (i < 16)
    {
      j = 0;
      int k = i - j;
      l3 = l1 + j;
      m = k;
    }
    label182: label251: label253: long l6;
    label349: label351: 
    do
    {
      int n;
      long l4;
      int i1;
      long l7;
      do
      {
        do
        {
          n = 0;
          l4 = l3;
          while (true)
            if (m > 0)
            {
              long l8 = 1L + l4;
              n = zzdqy.zza(paramArrayOfByte, l4);
              if (n >= 0)
              {
                m--;
                l4 = l8;
                continue;
                j = 0;
                long l9;
                for (long l2 = l1; ; l2 = l9)
                {
                  if (j >= i)
                    break label182;
                  l9 = 1L + l2;
                  if (zzdqy.zza(paramArrayOfByte, l2) < 0)
                    break;
                  j++;
                }
                j = i;
                break;
              }
              l4 = l8;
            }
          if (m == 0)
            return 0;
          i1 = m - 1;
          if (n >= -32)
            break label253;
          if (i1 == 0)
            return n;
          m = i1 - 1;
          if (n < -62)
            break label251;
          l3 = 1L + l4;
        }
        while (zzdqy.zza(paramArrayOfByte, l4) <= -65);
        return -1;
        if (n >= -16)
          break label351;
        if (i1 < 2)
          return zza(paramArrayOfByte, n, l4, i1);
        m = i1 - 2;
        l7 = l4 + 1L;
        int i3 = zzdqy.zza(paramArrayOfByte, l4);
        if ((i3 > -65) || ((n == -32) && (i3 < -96)) || ((n == -19) && (i3 >= -96)))
          break label349;
        l3 = 1L + l7;
      }
      while (zzdqy.zza(paramArrayOfByte, l7) <= -65);
      return -1;
      if (i1 < 3)
        return zza(paramArrayOfByte, n, l4, i1);
      m = i1 - 3;
      long l5 = 1L + l4;
      int i2 = zzdqy.zza(paramArrayOfByte, l4);
      if ((i2 > -65) || ((n << 28) + (i2 + 112) >> 30 != 0))
        break label446;
      l6 = 1L + l5;
      if (zzdqy.zza(paramArrayOfByte, l5) > -65)
        break label446;
      l3 = 1L + l6;
    }
    while (zzdqy.zza(paramArrayOfByte, l6) <= -65);
    label446: return -1;
  }

  final int zzb(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = paramInt1;
    long l2 = l1 + paramInt2;
    int i = paramCharSequence.length();
    if ((i > paramInt2) || (paramArrayOfByte.length - paramInt2 < paramInt1))
    {
      char c1 = paramCharSequence.charAt(i - 1);
      int j = paramInt1 + paramInt2;
      throw new ArrayIndexOutOfBoundsException(37 + "Failed writing " + c1 + " at index " + j);
    }
    int k = 0;
    while (k < i)
    {
      int i1 = paramCharSequence.charAt(k);
      if (i1 >= 128)
        break;
      long l11 = 1L + l1;
      zzdqy.zza(paramArrayOfByte, l1, (byte)i1);
      k++;
      l1 = l11;
    }
    if (k == i)
      return (int)l1;
    while (true)
    {
      if (k < i)
      {
        int m = paramCharSequence.charAt(k);
        Object localObject;
        long l7;
        if ((m < 128) && (localObject < l2))
        {
          l7 = 1L + localObject;
          zzdqy.zza(paramArrayOfByte, localObject, (byte)m);
        }
        while (true)
        {
          k++;
          l3 = l7;
          break;
          if ((m < 2048) && (l3 <= l2 - 2L))
          {
            long l10 = l3 + 1L;
            zzdqy.zza(paramArrayOfByte, l3, (byte)(0x3C0 | m >>> 6));
            l7 = 1L + l10;
            zzdqy.zza(paramArrayOfByte, l10, (byte)(0x80 | m & 0x3F));
          }
          else if (((m < 55296) || (57343 < m)) && (l3 <= l2 - 3L))
          {
            long l8 = 1L + l3;
            zzdqy.zza(paramArrayOfByte, l3, (byte)(0x1E0 | m >>> 12));
            long l9 = 1L + l8;
            zzdqy.zza(paramArrayOfByte, l8, (byte)(0x80 | 0x3F & m >>> 6));
            l7 = 1L + l9;
            zzdqy.zza(paramArrayOfByte, l9, (byte)(0x80 | m & 0x3F));
          }
          else
          {
            if (l3 > l2 - 4L)
              break label545;
            char c2;
            if (k + 1 != i)
            {
              k++;
              c2 = paramCharSequence.charAt(k);
              if (Character.isSurrogatePair(m, c2));
            }
            else
            {
              throw new zzdre(k - 1, i);
            }
            int n = Character.toCodePoint(m, c2);
            long l4 = 1L + l3;
            zzdqy.zza(paramArrayOfByte, l3, (byte)(0xF0 | n >>> 18));
            long l5 = 1L + l4;
            zzdqy.zza(paramArrayOfByte, l4, (byte)(0x80 | 0x3F & n >>> 12));
            long l6 = l5 + 1L;
            zzdqy.zza(paramArrayOfByte, l5, (byte)(0x80 | 0x3F & n >>> 6));
            l7 = 1L + l6;
            zzdqy.zza(paramArrayOfByte, l6, (byte)(0x80 | n & 0x3F));
          }
        }
        label545: if ((55296 <= m) && (m <= 57343) && ((k + 1 == i) || (!Character.isSurrogatePair(m, paramCharSequence.charAt(k + 1)))))
          throw new zzdre(k, i);
        throw new ArrayIndexOutOfBoundsException(46 + "Failed writing " + m + " at index " + l3);
      }
      return (int)l3;
      long l3 = l1;
    }
  }

  final void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    long l1 = zzdqy.zzn(paramByteBuffer);
    long l2 = l1 + paramByteBuffer.position();
    long l3 = l1 + paramByteBuffer.limit();
    int i = paramCharSequence.length();
    if (i > l3 - l2)
    {
      char c2 = paramCharSequence.charAt(i - 1);
      int i1 = paramByteBuffer.limit();
      throw new ArrayIndexOutOfBoundsException(37 + "Failed writing " + c2 + " at index " + i1);
    }
    int j = 0;
    while (j < i)
    {
      int n = paramCharSequence.charAt(j);
      if (n >= 128)
        break;
      long l12 = 1L + l2;
      zzdqy.zza(l2, (byte)n);
      j++;
      l2 = l12;
    }
    if (j == i)
    {
      paramByteBuffer.position((int)(l2 - l1));
      return;
    }
    while (true)
    {
      if (j < i)
      {
        int k = paramCharSequence.charAt(j);
        Object localObject;
        long l8;
        if ((k < 128) && (localObject < l3))
        {
          l8 = 1L + localObject;
          zzdqy.zza(localObject, (byte)k);
        }
        while (true)
        {
          j++;
          l4 = l8;
          break;
          if ((k < 2048) && (l4 <= l3 - 2L))
          {
            long l11 = l4 + 1L;
            zzdqy.zza(l4, (byte)(0x3C0 | k >>> 6));
            l8 = 1L + l11;
            zzdqy.zza(l11, (byte)(0x80 | k & 0x3F));
          }
          else if (((k < 55296) || (57343 < k)) && (l4 <= l3 - 3L))
          {
            long l9 = 1L + l4;
            zzdqy.zza(l4, (byte)(0x1E0 | k >>> 12));
            long l10 = 1L + l9;
            zzdqy.zza(l9, (byte)(0x80 | 0x3F & k >>> 6));
            l8 = 1L + l10;
            zzdqy.zza(l10, (byte)(0x80 | k & 0x3F));
          }
          else
          {
            if (l4 > l3 - 4L)
              break label548;
            char c1;
            if (j + 1 != i)
            {
              j++;
              c1 = paramCharSequence.charAt(j);
              if (Character.isSurrogatePair(k, c1));
            }
            else
            {
              throw new zzdre(j - 1, i);
            }
            int m = Character.toCodePoint(k, c1);
            long l5 = 1L + l4;
            zzdqy.zza(l4, (byte)(0xF0 | m >>> 18));
            long l6 = 1L + l5;
            zzdqy.zza(l5, (byte)(0x80 | 0x3F & m >>> 12));
            long l7 = l6 + 1L;
            zzdqy.zza(l6, (byte)(0x80 | 0x3F & m >>> 6));
            l8 = 1L + l7;
            zzdqy.zza(l7, (byte)(0x80 | m & 0x3F));
          }
        }
        label548: if ((55296 <= k) && (k <= 57343) && ((j + 1 == i) || (!Character.isSurrogatePair(k, paramCharSequence.charAt(j + 1)))))
          throw new zzdre(j, i);
        throw new ArrayIndexOutOfBoundsException(46 + "Failed writing " + k + " at index " + l4);
      }
      paramByteBuffer.position((int)(l4 - l1));
      return;
      long l4 = l2;
    }
  }

  final String zzn(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzdoj
  {
    if ((paramInt1 | paramInt2 | paramArrayOfByte.length - paramInt1 - paramInt2) < 0)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(paramArrayOfByte.length);
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = Integer.valueOf(paramInt2);
      throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", arrayOfObject));
    }
    int i = paramInt1 + paramInt2;
    char[] arrayOfChar = new char[paramInt2];
    int j = 0;
    int k = paramInt1;
    int m;
    byte b1;
    while (k < i)
    {
      byte b9 = zzdqy.zza(paramArrayOfByte, k);
      if (zzdrb.zzi(b9))
      {
        k++;
        int i13 = j + 1;
        zzdrb.zzb(b9, arrayOfChar, j);
        j = i13;
        continue;
        int i8 = m + 1;
        byte b7 = zzdqy.zza(paramArrayOfByte, m);
        int i9 = j + 1;
        zzdrb.zzb(b1, b7, arrayOfChar, j);
        j = i9;
        k = i8;
      }
    }
    while (true)
    {
      if (k >= i)
        break label469;
      m = k + 1;
      b1 = zzdqy.zza(paramArrayOfByte, k);
      int i4;
      if (zzdrb.zzi(b1))
      {
        int i10 = j + 1;
        zzdrb.zzb(b1, arrayOfChar, j);
        i4 = i10;
        int i11;
        for (k = m; k < i; k = i11)
        {
          byte b8 = zzdqy.zza(paramArrayOfByte, k);
          if (!zzdrb.zzi(b8))
            break;
          i11 = k + 1;
          int i12 = i4 + 1;
          zzdrb.zzb(b8, arrayOfChar, i4);
          i4 = i12;
        }
      }
      if (zzdrb.zzj(b1))
      {
        if (m < i)
          break;
        throw zzdoj.zzayk();
      }
      if (zzdrb.zzk(b1))
      {
        if (m >= i - 1)
          throw zzdoj.zzayk();
        int i5 = m + 1;
        byte b5 = zzdqy.zza(paramArrayOfByte, m);
        int i6 = i5 + 1;
        byte b6 = zzdqy.zza(paramArrayOfByte, i5);
        int i7 = j + 1;
        zzdrb.zzb(b1, b5, b6, arrayOfChar, j);
        j = i7;
        k = i6;
      }
      else
      {
        if (m >= i - 2)
          throw zzdoj.zzayk();
        int n = m + 1;
        byte b2 = zzdqy.zza(paramArrayOfByte, m);
        int i1 = n + 1;
        byte b3 = zzdqy.zza(paramArrayOfByte, n);
        int i2 = i1 + 1;
        byte b4 = zzdqy.zza(paramArrayOfByte, i1);
        int i3 = j + 1;
        zzdrb.zzb(b1, b2, b3, b4, arrayOfChar, j);
        i4 = i3 + 1;
        k = i2;
        j = i4;
      }
    }
    label469: return new String(arrayOfChar, 0, j);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdrf
 * JD-Core Version:    0.6.2
 */