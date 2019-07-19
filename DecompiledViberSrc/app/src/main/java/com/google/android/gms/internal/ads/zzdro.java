package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzdro
{
  private final ByteBuffer zzaxl;
  private zzdnh zzhnm;
  private int zzhnn;

  private zzdro(ByteBuffer paramByteBuffer)
  {
    this.zzaxl = paramByteBuffer;
    this.zzaxl.order(ByteOrder.LITTLE_ENDIAN);
  }

  private zzdro(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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

  public static int zzab(int paramInt1, int paramInt2)
  {
    return zzgd(paramInt1) + zzge(paramInt2);
  }

  public static zzdro zzaf(byte[] paramArrayOfByte)
  {
    return zzp(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static int zzb(int paramInt, zzdrv paramzzdrv)
  {
    int i = zzgd(paramInt);
    int j = paramzzdrv.zzaxj();
    return i + (j + zzgl(j));
  }

  public static int zzb(int paramInt, byte[] paramArrayOfByte)
  {
    return zzgd(paramInt) + (zzgl(paramArrayOfByte.length) + paramArrayOfByte.length);
  }

  private static void zzd(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
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

  public static int zzfw(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
      return 1;
    if ((0xFFFFC000 & paramLong) == 0L)
      return 2;
    if ((0xFFE00000 & paramLong) == 0L)
      return 3;
    if ((0xF0000000 & paramLong) == 0L)
      return 4;
    if ((0x0 & paramLong) == 0L)
      return 5;
    if ((0x0 & paramLong) == 0L)
      return 6;
    if ((0x0 & paramLong) == 0L)
      return 7;
    if ((0x0 & paramLong) == 0L)
      return 8;
    if ((0x0 & paramLong) == 0L)
      return 9;
    return 10;
  }

  public static int zzg(int paramInt, String paramString)
  {
    return zzgd(paramInt) + zzgx(paramString);
  }

  public static int zzgd(int paramInt)
  {
    return zzgl(paramInt << 3);
  }

  public static int zzge(int paramInt)
  {
    if (paramInt >= 0)
      return zzgl(paramInt);
    return 10;
  }

  private static int zzgl(int paramInt)
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

  public static int zzgx(String paramString)
  {
    int i = zza(paramString);
    return i + zzgl(i);
  }

  private final void zzhd(int paramInt)
    throws IOException
  {
    byte b = (byte)paramInt;
    if (!this.zzaxl.hasRemaining())
      throw new zzdrp(this.zzaxl.position(), this.zzaxl.limit());
    this.zzaxl.put(b);
  }

  private final void zzhe(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzhd(paramInt);
        return;
      }
      zzhd(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }

  public static zzdro zzp(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzdro(paramArrayOfByte, 0, paramInt2);
  }

  public final void zza(int paramInt, zzdrv paramzzdrv)
    throws IOException
  {
    zzw(paramInt, 2);
    if (paramzzdrv.zzhnx < 0)
      paramzzdrv.zzaxj();
    zzhe(paramzzdrv.zzhnx);
    paramzzdrv.zza(this);
  }

  public final void zza(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    zzw(paramInt, 2);
    zzhe(paramArrayOfByte.length);
    int i = paramArrayOfByte.length;
    if (this.zzaxl.remaining() >= i)
    {
      this.zzaxl.put(paramArrayOfByte, 0, i);
      return;
    }
    throw new zzdrp(this.zzaxl.position(), this.zzaxl.limit());
  }

  public final void zzawv()
  {
    if (this.zzaxl.remaining() != 0)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.zzaxl.remaining());
      throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", arrayOfObject));
    }
  }

  public final void zze(int paramInt, zzdpj paramzzdpj)
    throws IOException
  {
    if (this.zzhnm == null)
    {
      this.zzhnm = zzdnh.zzm(this.zzaxl);
      this.zzhnn = this.zzaxl.position();
    }
    while (true)
    {
      zzdnh localzzdnh = this.zzhnm;
      localzzdnh.zza(paramInt, paramzzdpj);
      localzzdnh.flush();
      this.zzhnn = this.zzaxl.position();
      return;
      if (this.zzhnn != this.zzaxl.position())
      {
        this.zzhnm.write(this.zzaxl.array(), this.zzhnn, this.zzaxl.position() - this.zzhnn);
        this.zzhnn = this.zzaxl.position();
      }
    }
  }

  public final void zzf(int paramInt, String paramString)
    throws IOException
  {
    zzw(paramInt, 2);
    int i;
    int j;
    try
    {
      i = zzgl(paramString.length());
      if (i != zzgl(3 * paramString.length()))
        break label167;
      j = this.zzaxl.position();
      if (this.zzaxl.remaining() < i)
        throw new zzdrp(i + j, this.zzaxl.limit());
    }
    catch (BufferOverflowException localBufferOverflowException)
    {
      zzdrp localzzdrp = new zzdrp(this.zzaxl.position(), this.zzaxl.limit());
      localzzdrp.initCause(localBufferOverflowException);
      throw localzzdrp;
    }
    this.zzaxl.position(j + i);
    zzd(paramString, this.zzaxl);
    int k = this.zzaxl.position();
    this.zzaxl.position(j);
    zzhe(k - j - i);
    this.zzaxl.position(k);
    return;
    label167: zzhe(zza(paramString));
    zzd(paramString, this.zzaxl);
  }

  public final void zzfv(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        zzhd((int)paramLong);
        return;
      }
      zzhd(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  public final void zzi(int paramInt, boolean paramBoolean)
    throws IOException
  {
    zzw(3, 0);
    int i = 0;
    if (paramBoolean)
      i = 1;
    byte b = (byte)i;
    if (!this.zzaxl.hasRemaining())
      throw new zzdrp(this.zzaxl.position(), this.zzaxl.limit());
    this.zzaxl.put(b);
  }

  public final void zzw(int paramInt1, int paramInt2)
    throws IOException
  {
    zzhe(paramInt2 | paramInt1 << 3);
  }

  public final void zzx(int paramInt1, int paramInt2)
    throws IOException
  {
    zzw(paramInt1, 0);
    if (paramInt2 >= 0)
    {
      zzhe(paramInt2);
      return;
    }
    zzfv(paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdro
 * JD-Core Version:    0.6.2
 */