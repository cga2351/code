package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzl
{
  private final ByteBuffer zzhb;

  private zzl(ByteBuffer paramByteBuffer)
  {
    this.zzhb = paramByteBuffer;
    this.zzhb.order(ByteOrder.LITTLE_ENDIAN);
  }

  private zzl(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }

  private static int zza(CharSequence paramCharSequence)
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
                  throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + k);
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

  private final void zza(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        zzj((int)paramLong);
        return;
      }
      zzj(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int i = 0;
    if (paramByteBuffer.isReadOnly())
      throw new ReadOnlyBufferException();
    if (paramByteBuffer.hasArray());
    while (true)
    {
      byte[] arrayOfByte;
      int i1;
      int i3;
      int i4;
      int i17;
      int i6;
      int i12;
      try
      {
        arrayOfByte = paramByteBuffer.array();
        i1 = paramByteBuffer.arrayOffset() + paramByteBuffer.position();
        int i2 = paramByteBuffer.remaining();
        i3 = paramCharSequence.length();
        i4 = i1 + i2;
        if ((i >= i3) || (i + i1 >= i4))
          break label873;
        int i18 = paramCharSequence.charAt(i);
        if (i18 >= 128)
          break label873;
        arrayOfByte[(i1 + i)] = ((byte)i18);
        i++;
        continue;
        paramByteBuffer.position(i17 - paramByteBuffer.arrayOffset());
        return;
        if (i >= i3)
          break label570;
        i6 = paramCharSequence.charAt(i);
        if ((i6 < 128) && (i5 < i4))
        {
          i12 = i5 + 1;
          arrayOfByte[i5] = ((byte)i6);
        }
        else if ((i6 < 2048) && (i5 <= i4 - 2))
        {
          int i16 = i5 + 1;
          arrayOfByte[i5] = ((byte)(0x3C0 | i6 >>> 6));
          i12 = i16 + 1;
          arrayOfByte[i16] = ((byte)(0x80 | i6 & 0x3F));
        }
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        BufferOverflowException localBufferOverflowException = new BufferOverflowException();
        localBufferOverflowException.initCause(localArrayIndexOutOfBoundsException);
        throw localBufferOverflowException;
      }
      if (((i6 < 55296) || (57343 < i6)) && (i5 <= i4 - 3))
      {
        int i13 = i5 + 1;
        int i14 = (byte)(0x1E0 | i6 >>> 12);
        arrayOfByte[i5] = i14;
        int i15 = i13 + 1;
        arrayOfByte[i13] = ((byte)(0x80 | 0x3F & i6 >>> 6));
        i12 = i15 + 1;
        arrayOfByte[i15] = ((byte)(0x80 | i6 & 0x3F));
      }
      else if (i5 <= i4 - 4)
      {
        char c2;
        if (i + 1 != paramCharSequence.length())
        {
          i++;
          c2 = paramCharSequence.charAt(i);
          if (Character.isSurrogatePair(i6, c2));
        }
        else
        {
          int i7 = i - 1;
          throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + i7);
        }
        int i8 = Character.toCodePoint(i6, c2);
        int i9 = i5 + 1;
        arrayOfByte[i5] = ((byte)(0xF0 | i8 >>> 18));
        int i10 = i9 + 1;
        arrayOfByte[i9] = ((byte)(0x80 | 0x3F & i8 >>> 12));
        int i11 = i10 + 1;
        arrayOfByte[i10] = ((byte)(0x80 | 0x3F & i8 >>> 6));
        i12 = i11 + 1;
        arrayOfByte[i11] = ((byte)(0x80 | i8 & 0x3F));
      }
      else
      {
        throw new ArrayIndexOutOfBoundsException(37 + "Failed writing " + i6 + " at index " + i5);
        label570: i17 = i5;
        continue;
        int j = paramCharSequence.length();
        if (i < j)
        {
          int k = paramCharSequence.charAt(i);
          if (k < 128)
            paramByteBuffer.put((byte)k);
          while (true)
          {
            i++;
            break;
            if (k < 2048)
            {
              paramByteBuffer.put((byte)(0x3C0 | k >>> 6));
              paramByteBuffer.put((byte)(0x80 | k & 0x3F));
            }
            else if ((k < 55296) || (57343 < k))
            {
              paramByteBuffer.put((byte)(0x1E0 | k >>> 12));
              paramByteBuffer.put((byte)(0x80 | 0x3F & k >>> 6));
              paramByteBuffer.put((byte)(0x80 | k & 0x3F));
            }
            else
            {
              char c1;
              if (i + 1 != paramCharSequence.length())
              {
                i++;
                c1 = paramCharSequence.charAt(i);
                if (Character.isSurrogatePair(k, c1));
              }
              else
              {
                int m = i - 1;
                throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + m);
              }
              int n = Character.toCodePoint(k, c1);
              paramByteBuffer.put((byte)(0xF0 | n >>> 18));
              paramByteBuffer.put((byte)(0x80 | 0x3F & n >>> 12));
              paramByteBuffer.put((byte)(0x80 | 0x3F & n >>> 6));
              paramByteBuffer.put((byte)(0x80 | n & 0x3F));
            }
          }
          label873: if (i != i3)
            break label890;
          i17 = i1 + i3;
          continue;
        }
        return;
        label890: i5 = i1 + i;
        continue;
      }
      i++;
      int i5 = i12;
    }
  }

  public static int zzb(int paramInt, long paramLong)
  {
    int i = zzk(paramInt);
    int j;
    if ((0xFFFFFF80 & paramLong) == 0L)
      j = 1;
    while (true)
    {
      return j + i;
      if ((0xFFFFC000 & paramLong) == 0L)
        j = 2;
      else if ((0xFFE00000 & paramLong) == 0L)
        j = 3;
      else if ((0xF0000000 & paramLong) == 0L)
        j = 4;
      else if ((0x0 & paramLong) == 0L)
        j = 5;
      else if ((0x0 & paramLong) == 0L)
        j = 6;
      else if ((0x0 & paramLong) == 0L)
        j = 7;
      else if ((0x0 & paramLong) == 0L)
        j = 8;
      else if ((0x0 & paramLong) == 0L)
        j = 9;
      else
        j = 10;
    }
  }

  public static int zzb(int paramInt, zzt paramzzt)
  {
    int i = zzk(paramInt);
    int j = paramzzt.zzx();
    return i + (j + zzm(j));
  }

  public static int zzb(int paramInt, String paramString)
  {
    return zzk(paramInt) + zzg(paramString);
  }

  public static zzl zzb(byte[] paramArrayOfByte)
  {
    return zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static zzl zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzl(paramArrayOfByte, 0, paramInt2);
  }

  public static int zze(int paramInt1, int paramInt2)
  {
    return zzk(paramInt1) + zzi(paramInt2);
  }

  public static int zzg(String paramString)
  {
    int i = zza(paramString);
    return i + zzm(i);
  }

  public static int zzi(int paramInt)
  {
    if (paramInt >= 0)
      return zzm(paramInt);
    return 10;
  }

  private final void zzj(int paramInt)
    throws IOException
  {
    byte b = (byte)paramInt;
    if (!this.zzhb.hasRemaining())
      throw new zzm(this.zzhb.position(), this.zzhb.limit());
    this.zzhb.put(b);
  }

  public static int zzk(int paramInt)
  {
    return zzm(paramInt << 3);
  }

  public static int zzm(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0)
      return 1;
    if ((paramInt & 0xFFFFC000) == 0)
      return 2;
    if ((0xFFE00000 & paramInt) == 0)
      return 3;
    if ((0xF0000000 & paramInt) == 0)
      return 4;
    return 5;
  }

  public static int zzn(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  public final void zza(byte paramByte)
    throws IOException
  {
    if (!this.zzhb.hasRemaining())
      throw new zzm(this.zzhb.position(), this.zzhb.limit());
    this.zzhb.put(paramByte);
  }

  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    zzf(paramInt, 5);
    int i = Float.floatToIntBits(paramFloat);
    if (this.zzhb.remaining() < 4)
      throw new zzm(this.zzhb.position(), this.zzhb.limit());
    this.zzhb.putInt(i);
  }

  public final void zza(int paramInt, long paramLong)
    throws IOException
  {
    zzf(paramInt, 0);
    zza(paramLong);
  }

  public final void zza(int paramInt, zzt paramzzt)
    throws IOException
  {
    zzf(paramInt, 2);
    if (paramzzt.zzhl < 0)
      paramzzt.zzx();
    zzl(paramzzt.zzhl);
    paramzzt.zza(this);
  }

  public final void zza(int paramInt, String paramString)
    throws IOException
  {
    zzf(paramInt, 2);
    int i;
    int j;
    try
    {
      i = zzm(paramString.length());
      if (i != zzm(3 * paramString.length()))
        break label167;
      j = this.zzhb.position();
      if (this.zzhb.remaining() < i)
        throw new zzm(i + j, this.zzhb.limit());
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      zzm localzzm = new zzm(this.zzhb.position(), this.zzhb.limit());
      localzzm.initCause(localBufferOverflowException);
      throw localzzm;
    }
    this.zzhb.position(j + i);
    zza(paramString, this.zzhb);
    int k = this.zzhb.position();
    this.zzhb.position(j);
    zzl(k - j - i);
    this.zzhb.position(k);
    return;
    label167: zzl(zza(paramString));
    zza(paramString, this.zzhb);
  }

  public final void zzb(long paramLong)
    throws IOException
  {
    if (this.zzhb.remaining() < 8)
      throw new zzm(this.zzhb.position(), this.zzhb.limit());
    this.zzhb.putLong(paramLong);
  }

  public final void zzc(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramArrayOfByte.length;
    if (this.zzhb.remaining() >= i)
    {
      this.zzhb.put(paramArrayOfByte, 0, i);
      return;
    }
    throw new zzm(this.zzhb.position(), this.zzhb.limit());
  }

  public final void zzd(int paramInt1, int paramInt2)
    throws IOException
  {
    zzf(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      zzl(paramInt2);
      return;
    }
    zza(paramInt2);
  }

  public final void zzf(int paramInt1, int paramInt2)
    throws IOException
  {
    zzl(paramInt2 | paramInt1 << 3);
  }

  public final void zzl(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzj(paramInt);
        return;
      }
      zzj(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }

  public final void zzr()
  {
    if (this.zzhb.remaining() != 0)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.zzhb.remaining());
      throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", arrayOfObject));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzl
 * JD-Core Version:    0.6.2
 */