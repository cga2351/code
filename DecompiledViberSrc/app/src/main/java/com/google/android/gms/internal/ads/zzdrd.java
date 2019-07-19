package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzdrd extends zzdrc
{
  final int zzb(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    for (int i = paramInt2; (i < paramInt3) && (paramArrayOfByte[i] >= 0); i++);
    int k;
    label36: int j;
    if (i >= paramInt3)
    {
      k = 0;
      return k;
      i = j;
    }
    label102: label104: int i1;
    label191: label193: 
    do
    {
      int i2;
      do
      {
        do
        {
          if (i >= paramInt3)
            return 0;
          j = i + 1;
          k = paramArrayOfByte[i];
          if (k >= 0)
            break label36;
          if (k >= -32)
            break label104;
          if (j >= paramInt3)
            break;
          if (k < -62)
            break label102;
          i = j + 1;
        }
        while (paramArrayOfByte[j] <= -65);
        return -1;
        if (k >= -16)
          break label193;
        if (j >= paramInt3 - 1)
          return zzdra.zzo(paramArrayOfByte, j, paramInt3);
        i2 = j + 1;
        int i3 = paramArrayOfByte[j];
        if ((i3 > -65) || ((k == -32) && (i3 < -96)) || ((k == -19) && (i3 >= -96)))
          break label191;
        i = i2 + 1;
      }
      while (paramArrayOfByte[i2] <= -65);
      return -1;
      if (j >= paramInt3 - 2)
        return zzdra.zzo(paramArrayOfByte, j, paramInt3);
      int m = j + 1;
      int n = paramArrayOfByte[j];
      if ((n > -65) || ((k << 28) + (n + 112) >> 30 != 0))
        break label277;
      i1 = m + 1;
      if (paramArrayOfByte[m] > -65)
        break label277;
      i = i1 + 1;
    }
    while (paramArrayOfByte[i1] <= -65);
    label277: return -1;
  }

  final int zzb(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramCharSequence.length();
    int j = 0;
    int k = paramInt1 + paramInt2;
    while ((j < i) && (j + paramInt1 < k))
    {
      int i9 = paramCharSequence.charAt(j);
      if (i9 >= 128)
        break;
      paramArrayOfByte[(paramInt1 + j)] = ((byte)i9);
      j++;
    }
    if (j == i)
      return paramInt1 + i;
    int m = paramInt1 + j;
    if (j < i)
    {
      int n = paramCharSequence.charAt(j);
      int i5;
      if ((n < 128) && (m < k))
      {
        i5 = m + 1;
        paramArrayOfByte[m] = ((byte)n);
      }
      while (true)
      {
        j++;
        m = i5;
        break;
        if ((n < 2048) && (m <= k - 2))
        {
          int i8 = m + 1;
          paramArrayOfByte[m] = ((byte)(0x3C0 | n >>> 6));
          i5 = i8 + 1;
          paramArrayOfByte[i8] = ((byte)(0x80 | n & 0x3F));
        }
        else if (((n < 55296) || (57343 < n)) && (m <= k - 3))
        {
          int i6 = m + 1;
          paramArrayOfByte[m] = ((byte)(0x1E0 | n >>> 12));
          int i7 = i6 + 1;
          paramArrayOfByte[i6] = ((byte)(0x80 | 0x3F & n >>> 6));
          i5 = i7 + 1;
          paramArrayOfByte[i7] = ((byte)(0x80 | n & 0x3F));
        }
        else
        {
          if (m > k - 4)
            break label445;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j++;
            c = paramCharSequence.charAt(j);
            if (Character.isSurrogatePair(n, c));
          }
          else
          {
            throw new zzdre(j - 1, i);
          }
          int i1 = Character.toCodePoint(n, c);
          int i2 = m + 1;
          paramArrayOfByte[m] = ((byte)(0xF0 | i1 >>> 18));
          int i3 = i2 + 1;
          paramArrayOfByte[i2] = ((byte)(0x80 | 0x3F & i1 >>> 12));
          int i4 = i3 + 1;
          paramArrayOfByte[i3] = ((byte)(0x80 | 0x3F & i1 >>> 6));
          i5 = i4 + 1;
          paramArrayOfByte[i4] = ((byte)(0x80 | i1 & 0x3F));
        }
      }
      label445: if ((55296 <= n) && (n <= 57343) && ((j + 1 == paramCharSequence.length()) || (!Character.isSurrogatePair(n, paramCharSequence.charAt(j + 1)))))
        throw new zzdre(j, i);
      throw new ArrayIndexOutOfBoundsException(37 + "Failed writing " + n + " at index " + m);
    }
    return m;
  }

  final void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    zzc(paramCharSequence, paramByteBuffer);
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
      byte b9 = paramArrayOfByte[k];
      if (zzdrb.zzi(b9))
      {
        k++;
        int i13 = j + 1;
        zzdrb.zzb(b9, arrayOfChar, j);
        j = i13;
        continue;
        int i8 = m + 1;
        byte b7 = paramArrayOfByte[m];
        int i9 = j + 1;
        zzdrb.zzb(b1, b7, arrayOfChar, j);
        j = i9;
        k = i8;
      }
    }
    while (true)
    {
      if (k >= i)
        break label442;
      m = k + 1;
      b1 = paramArrayOfByte[k];
      int i4;
      if (zzdrb.zzi(b1))
      {
        int i10 = j + 1;
        zzdrb.zzb(b1, arrayOfChar, j);
        i4 = i10;
        int i11;
        for (k = m; k < i; k = i11)
        {
          byte b8 = paramArrayOfByte[k];
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
        byte b5 = paramArrayOfByte[m];
        int i6 = i5 + 1;
        byte b6 = paramArrayOfByte[i5];
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
        byte b2 = paramArrayOfByte[m];
        int i1 = n + 1;
        byte b3 = paramArrayOfByte[n];
        int i2 = i1 + 1;
        byte b4 = paramArrayOfByte[i1];
        int i3 = j + 1;
        zzdrb.zzb(b1, b2, b3, b4, arrayOfChar, j);
        i4 = i3 + 1;
        k = i2;
        j = i4;
      }
    }
    label442: return new String(arrayOfChar, 0, j);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdrd
 * JD-Core Version:    0.6.2
 */