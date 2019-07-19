package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzdnh extends zzdmp
{
  private static final Logger logger = Logger.getLogger(zzdnh.class.getName());
  private static final boolean zzhdn = zzdqy.zzbac();
  zzdnj zzhdo;

  public static int zza(int paramInt, zzdoq paramzzdoq)
  {
    int i = zzgd(paramInt);
    int j = paramzzdoq.zzaxj();
    return i + (j + zzgf(j));
  }

  public static int zza(zzdoq paramzzdoq)
  {
    int i = paramzzdoq.zzaxj();
    return i + zzgf(i);
  }

  public static int zzab(int paramInt1, int paramInt2)
  {
    return zzgd(paramInt1) + zzge(paramInt2);
  }

  public static zzdnh zzab(byte[] paramArrayOfByte)
  {
    return new zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static int zzac(int paramInt1, int paramInt2)
  {
    return zzgd(paramInt1) + zzgf(paramInt2);
  }

  public static int zzac(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return i + zzgf(i);
  }

  public static int zzad(int paramInt1, int paramInt2)
  {
    return zzgd(paramInt1) + zzgf(zzgk(paramInt2));
  }

  public static int zzae(int paramInt1, int paramInt2)
  {
    return 4 + zzgd(paramInt1);
  }

  public static int zzaf(int paramInt1, int paramInt2)
  {
    return 4 + zzgd(paramInt1);
  }

  public static int zzag(int paramInt1, int paramInt2)
  {
    return zzgd(paramInt1) + zzge(paramInt2);
  }

  public static int zzb(int paramInt, float paramFloat)
  {
    return 4 + zzgd(paramInt);
  }

  public static int zzb(int paramInt, zzdoq paramzzdoq)
  {
    return (zzgd(1) << 1) + zzac(2, paramInt) + zza(3, paramzzdoq);
  }

  static int zzb(int paramInt, zzdpj paramzzdpj, zzdqa paramzzdqa)
  {
    return zzgd(paramInt) + zzb(paramzzdpj, paramzzdqa);
  }

  static int zzb(zzdpj paramzzdpj, zzdqa paramzzdqa)
  {
    zzdmh localzzdmh = (zzdmh)paramzzdpj;
    int i = localzzdmh.zzavg();
    if (i == -1)
    {
      i = paramzzdqa.zzak(localzzdmh);
      localzzdmh.zzfi(i);
    }
    return i + zzgf(i);
  }

  public static int zzbg(boolean paramBoolean)
  {
    return 1;
  }

  public static int zzc(double paramDouble)
  {
    return 8;
  }

  public static int zzc(int paramInt, double paramDouble)
  {
    return 8 + zzgd(paramInt);
  }

  public static int zzc(int paramInt, zzdmq paramzzdmq)
  {
    int i = zzgd(paramInt);
    int j = paramzzdmq.size();
    return i + (j + zzgf(j));
  }

  public static int zzc(int paramInt, zzdpj paramzzdpj)
  {
    return zzgd(paramInt) + zzk(paramzzdpj);
  }

  @Deprecated
  static int zzc(int paramInt, zzdpj paramzzdpj, zzdqa paramzzdqa)
  {
    int i = zzgd(paramInt) << 1;
    zzdmh localzzdmh = (zzdmh)paramzzdpj;
    int j = localzzdmh.zzavg();
    if (j == -1)
    {
      j = paramzzdqa.zzak(localzzdmh);
      localzzdmh.zzfi(j);
    }
    return j + i;
  }

  public static int zzd(int paramInt, zzdmq paramzzdmq)
  {
    return (zzgd(1) << 1) + zzac(2, paramInt) + zzc(3, paramzzdmq);
  }

  public static int zzd(int paramInt, zzdpj paramzzdpj)
  {
    return (zzgd(1) << 1) + zzac(2, paramInt) + zzc(3, paramzzdpj);
  }

  public static int zzda(zzdmq paramzzdmq)
  {
    int i = paramzzdmq.size();
    return i + zzgf(i);
  }

  public static int zzfm(long paramLong)
  {
    return zzfn(paramLong);
  }

  public static int zzfn(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
    {
      i = 1;
      return i;
    }
    if (paramLong < 0L)
      return 10;
    int i = 2;
    if ((0x0 & paramLong) != 0L)
      i = 6;
    for (long l = paramLong >>> 28; ; l = paramLong)
    {
      if ((0xFFE00000 & l) != 0L)
      {
        i += 2;
        l >>>= 14;
      }
      if ((l & 0xFFFFC000) == 0L)
        break;
      return i + 1;
    }
  }

  public static int zzfo(long paramLong)
  {
    return zzfn(zzfr(paramLong));
  }

  public static int zzfp(long paramLong)
  {
    return 8;
  }

  public static int zzfq(long paramLong)
  {
    return 8;
  }

  private static long zzfr(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }

  public static int zzg(int paramInt, String paramString)
  {
    return zzgd(paramInt) + zzgx(paramString);
  }

  public static int zzgd(int paramInt)
  {
    return zzgf(paramInt << 3);
  }

  public static int zzge(int paramInt)
  {
    if (paramInt >= 0)
      return zzgf(paramInt);
    return 10;
  }

  public static int zzgf(int paramInt)
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

  public static int zzgg(int paramInt)
  {
    return zzgf(zzgk(paramInt));
  }

  public static int zzgh(int paramInt)
  {
    return 4;
  }

  public static int zzgi(int paramInt)
  {
    return 4;
  }

  public static int zzgj(int paramInt)
  {
    return zzge(paramInt);
  }

  private static int zzgk(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  @Deprecated
  public static int zzgl(int paramInt)
  {
    return zzgf(paramInt);
  }

  public static int zzgx(String paramString)
  {
    try
    {
      int j = zzdra.zza(paramString);
      i = j;
      return i + zzgf(i);
    }
    catch (zzdre localzzdre)
    {
      while (true)
        int i = paramString.getBytes(zzdoc.UTF_8).length;
    }
  }

  public static int zzh(float paramFloat)
  {
    return 4;
  }

  public static int zzj(int paramInt, boolean paramBoolean)
  {
    return 1 + zzgd(paramInt);
  }

  public static int zzk(int paramInt, long paramLong)
  {
    return zzgd(paramInt) + zzfn(paramLong);
  }

  public static int zzk(zzdpj paramzzdpj)
  {
    int i = paramzzdpj.zzaxj();
    return i + zzgf(i);
  }

  public static int zzl(int paramInt, long paramLong)
  {
    return zzgd(paramInt) + zzfn(paramLong);
  }

  @Deprecated
  public static int zzl(zzdpj paramzzdpj)
  {
    return paramzzdpj.zzaxj();
  }

  public static int zzm(int paramInt, long paramLong)
  {
    return zzgd(paramInt) + zzfn(zzfr(paramLong));
  }

  public static zzdnh zzm(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
      return new zzb(paramByteBuffer);
    if ((paramByteBuffer.isDirect()) && (!paramByteBuffer.isReadOnly()))
    {
      if (zzdqy.zzbad())
        return new zze(paramByteBuffer);
      return new zzd(paramByteBuffer);
    }
    throw new IllegalArgumentException("ByteBuffer is read-only");
  }

  public static int zzn(int paramInt, long paramLong)
  {
    return 8 + zzgd(paramInt);
  }

  public static int zzo(int paramInt, long paramLong)
  {
    return 8 + zzgd(paramInt);
  }

  public abstract void flush()
    throws IOException;

  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;

  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    zzaa(paramInt, Float.floatToRawIntBits(paramFloat));
  }

  public abstract void zza(int paramInt, zzdmq paramzzdmq)
    throws IOException;

  public abstract void zza(int paramInt, zzdpj paramzzdpj)
    throws IOException;

  abstract void zza(int paramInt, zzdpj paramzzdpj, zzdqa paramzzdqa)
    throws IOException;

  abstract void zza(zzdpj paramzzdpj, zzdqa paramzzdqa)
    throws IOException;

  final void zza(String paramString, zzdre paramzzdre)
    throws IOException
  {
    logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramzzdre);
    byte[] arrayOfByte = paramString.getBytes(zzdoc.UTF_8);
    try
    {
      zzga(arrayOfByte.length);
      zzh(arrayOfByte, 0, arrayOfByte.length);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new zzc(localIndexOutOfBoundsException);
    }
    catch (zzc localzzc)
    {
      throw localzzc;
    }
  }

  public abstract void zzaa(int paramInt1, int paramInt2)
    throws IOException;

  public abstract int zzawu();

  public final void zzawv()
  {
    if (zzawu() != 0)
      throw new IllegalStateException("Did not write as much data as expected.");
  }

  public final void zzb(double paramDouble)
    throws IOException
  {
    zzfl(Double.doubleToRawLongBits(paramDouble));
  }

  public final void zzb(int paramInt, double paramDouble)
    throws IOException
  {
    zzj(paramInt, Double.doubleToRawLongBits(paramDouble));
  }

  public abstract void zzb(int paramInt, zzdmq paramzzdmq)
    throws IOException;

  public abstract void zzb(int paramInt, zzdpj paramzzdpj)
    throws IOException;

  public final void zzbf(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      zzd((byte)i);
      return;
    }
  }

  public abstract void zzcz(zzdmq paramzzdmq)
    throws IOException;

  public abstract void zzd(byte paramByte)
    throws IOException;

  public abstract void zzf(int paramInt, String paramString)
    throws IOException;

  public abstract void zzfj(long paramLong)
    throws IOException;

  public final void zzfk(long paramLong)
    throws IOException
  {
    zzfj(zzfr(paramLong));
  }

  public abstract void zzfl(long paramLong)
    throws IOException;

  public abstract void zzfz(int paramInt)
    throws IOException;

  public final void zzg(float paramFloat)
    throws IOException
  {
    zzgc(Float.floatToRawIntBits(paramFloat));
  }

  public abstract void zzga(int paramInt)
    throws IOException;

  public final void zzgb(int paramInt)
    throws IOException
  {
    zzga(zzgk(paramInt));
  }

  public abstract void zzgc(int paramInt)
    throws IOException;

  public abstract void zzgw(String paramString)
    throws IOException;

  public abstract void zzh(int paramInt, long paramLong)
    throws IOException;

  public final void zzi(int paramInt, long paramLong)
    throws IOException
  {
    zzh(paramInt, zzfr(paramLong));
  }

  public abstract void zzi(int paramInt, boolean paramBoolean)
    throws IOException;

  public abstract void zzj(int paramInt, long paramLong)
    throws IOException;

  public abstract void zzj(zzdpj paramzzdpj)
    throws IOException;

  abstract void zzk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;

  public abstract void zzw(int paramInt1, int paramInt2)
    throws IOException;

  public abstract void zzx(int paramInt1, int paramInt2)
    throws IOException;

  public abstract void zzy(int paramInt1, int paramInt2)
    throws IOException;

  public final void zzz(int paramInt1, int paramInt2)
    throws IOException
  {
    zzy(paramInt1, zzgk(paramInt2));
  }

  static class zza extends zzdnh
  {
    private final byte[] buffer;
    private final int limit;
    private final int offset;
    private int position;

    zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      if (paramArrayOfByte == null)
        throw new NullPointerException("buffer");
      if ((paramInt1 | paramInt2 | paramArrayOfByte.length - (paramInt1 + paramInt2)) < 0)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(paramArrayOfByte.length);
        arrayOfObject[1] = Integer.valueOf(paramInt1);
        arrayOfObject[2] = Integer.valueOf(paramInt2);
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", arrayOfObject));
      }
      this.buffer = paramArrayOfByte;
      this.offset = paramInt1;
      this.position = paramInt1;
      this.limit = (paramInt1 + paramInt2);
    }

    public void flush()
    {
    }

    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.position, paramInt2);
        this.position = (paramInt2 + this.position);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(this.position);
        arrayOfObject[1] = Integer.valueOf(this.limit);
        arrayOfObject[2] = Integer.valueOf(paramInt2);
        throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zza(int paramInt, zzdmq paramzzdmq)
      throws IOException
    {
      zzw(paramInt, 2);
      zzcz(paramzzdmq);
    }

    public final void zza(int paramInt, zzdpj paramzzdpj)
      throws IOException
    {
      zzw(paramInt, 2);
      zzj(paramzzdpj);
    }

    final void zza(int paramInt, zzdpj paramzzdpj, zzdqa paramzzdqa)
      throws IOException
    {
      zzw(paramInt, 2);
      zzdmh localzzdmh = (zzdmh)paramzzdpj;
      int i = localzzdmh.zzavg();
      if (i == -1)
      {
        i = paramzzdqa.zzak(localzzdmh);
        localzzdmh.zzfi(i);
      }
      zzga(i);
      paramzzdqa.zza(paramzzdpj, this.zzhdo);
    }

    final void zza(zzdpj paramzzdpj, zzdqa paramzzdqa)
      throws IOException
    {
      zzdmh localzzdmh = (zzdmh)paramzzdpj;
      int i = localzzdmh.zzavg();
      if (i == -1)
      {
        i = paramzzdqa.zzak(localzzdmh);
        localzzdmh.zzfi(i);
      }
      zzga(i);
      paramzzdqa.zza(paramzzdpj, this.zzhdo);
    }

    public final void zzaa(int paramInt1, int paramInt2)
      throws IOException
    {
      zzw(paramInt1, 5);
      zzgc(paramInt2);
    }

    public final int zzawu()
    {
      return this.limit - this.position;
    }

    public final int zzawx()
    {
      return this.position - this.offset;
    }

    public final void zzb(int paramInt, zzdmq paramzzdmq)
      throws IOException
    {
      zzw(1, 3);
      zzy(2, paramInt);
      zza(3, paramzzdmq);
      zzw(1, 4);
    }

    public final void zzb(int paramInt, zzdpj paramzzdpj)
      throws IOException
    {
      zzw(1, 3);
      zzy(2, paramInt);
      zza(3, paramzzdpj);
      zzw(1, 4);
    }

    public final void zzcz(zzdmq paramzzdmq)
      throws IOException
    {
      zzga(paramzzdmq.size());
      paramzzdmq.zza(this);
    }

    public final void zzd(byte paramByte)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = paramByte;
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(this.position);
        arrayOfObject[1] = Integer.valueOf(this.limit);
        arrayOfObject[2] = Integer.valueOf(1);
        throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzf(int paramInt, String paramString)
      throws IOException
    {
      zzw(paramInt, 2);
      zzgw(paramString);
    }

    public final void zzfj(long paramLong)
      throws IOException
    {
      if ((zzdnh.zzaww()) && (zzawu() >= 10))
        while (true)
        {
          if ((paramLong & 0xFFFFFF80) == 0L)
          {
            byte[] arrayOfByte4 = this.buffer;
            int m = this.position;
            this.position = (m + 1);
            zzdqy.zza(arrayOfByte4, m, (byte)(int)paramLong);
            return;
          }
          byte[] arrayOfByte3 = this.buffer;
          int k = this.position;
          this.position = (k + 1);
          zzdqy.zza(arrayOfByte3, k, (byte)(0x80 | 0x7F & (int)paramLong));
          paramLong >>>= 7;
        }
      try
      {
        do
        {
          byte[] arrayOfByte2 = this.buffer;
          int j = this.position;
          this.position = (j + 1);
          arrayOfByte2[j] = ((byte)(0x80 | 0x7F & (int)paramLong));
          paramLong >>>= 7;
        }
        while ((paramLong & 0xFFFFFF80) != 0L);
        byte[] arrayOfByte1 = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte1[i] = ((byte)(int)paramLong);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(this.position);
        arrayOfObject[1] = Integer.valueOf(this.limit);
        arrayOfObject[2] = Integer.valueOf(1);
        throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzfl(long paramLong)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte1 = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte1[i] = ((byte)(int)paramLong);
        byte[] arrayOfByte2 = this.buffer;
        int j = this.position;
        this.position = (j + 1);
        arrayOfByte2[j] = ((byte)(int)(paramLong >> 8));
        byte[] arrayOfByte3 = this.buffer;
        int k = this.position;
        this.position = (k + 1);
        arrayOfByte3[k] = ((byte)(int)(paramLong >> 16));
        byte[] arrayOfByte4 = this.buffer;
        int m = this.position;
        this.position = (m + 1);
        arrayOfByte4[m] = ((byte)(int)(paramLong >> 24));
        byte[] arrayOfByte5 = this.buffer;
        int n = this.position;
        this.position = (n + 1);
        arrayOfByte5[n] = ((byte)(int)(paramLong >> 32));
        byte[] arrayOfByte6 = this.buffer;
        int i1 = this.position;
        this.position = (i1 + 1);
        arrayOfByte6[i1] = ((byte)(int)(paramLong >> 40));
        byte[] arrayOfByte7 = this.buffer;
        int i2 = this.position;
        this.position = (i2 + 1);
        arrayOfByte7[i2] = ((byte)(int)(paramLong >> 48));
        byte[] arrayOfByte8 = this.buffer;
        int i3 = this.position;
        this.position = (i3 + 1);
        arrayOfByte8[i3] = ((byte)(int)(paramLong >> 56));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(this.position);
        arrayOfObject[1] = Integer.valueOf(this.limit);
        arrayOfObject[2] = Integer.valueOf(1);
        throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzfz(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzga(paramInt);
        return;
      }
      zzfj(paramInt);
    }

    public final void zzga(int paramInt)
      throws IOException
    {
      if ((zzdnh.zzaww()) && (zzawu() >= 10))
        while (true)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            byte[] arrayOfByte4 = this.buffer;
            int m = this.position;
            this.position = (m + 1);
            zzdqy.zza(arrayOfByte4, m, (byte)paramInt);
            return;
          }
          byte[] arrayOfByte3 = this.buffer;
          int k = this.position;
          this.position = (k + 1);
          zzdqy.zza(arrayOfByte3, k, (byte)(0x80 | paramInt & 0x7F));
          paramInt >>>= 7;
        }
      try
      {
        do
        {
          byte[] arrayOfByte2 = this.buffer;
          int j = this.position;
          this.position = (j + 1);
          arrayOfByte2[j] = ((byte)(0x80 | paramInt & 0x7F));
          paramInt >>>= 7;
        }
        while ((paramInt & 0xFFFFFF80) != 0);
        byte[] arrayOfByte1 = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte1[i] = ((byte)paramInt);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(this.position);
        arrayOfObject[1] = Integer.valueOf(this.limit);
        arrayOfObject[2] = Integer.valueOf(1);
        throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzgc(int paramInt)
      throws IOException
    {
      try
      {
        byte[] arrayOfByte1 = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte1[i] = ((byte)paramInt);
        byte[] arrayOfByte2 = this.buffer;
        int j = this.position;
        this.position = (j + 1);
        arrayOfByte2[j] = ((byte)(paramInt >> 8));
        byte[] arrayOfByte3 = this.buffer;
        int k = this.position;
        this.position = (k + 1);
        arrayOfByte3[k] = ((byte)(paramInt >> 16));
        byte[] arrayOfByte4 = this.buffer;
        int m = this.position;
        this.position = (m + 1);
        arrayOfByte4[m] = ((byte)(paramInt >>> 24));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(this.position);
        arrayOfObject[1] = Integer.valueOf(this.limit);
        arrayOfObject[2] = Integer.valueOf(1);
        throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzgw(String paramString)
      throws IOException
    {
      int i = this.position;
      try
      {
        int j = zzgf(3 * paramString.length());
        int k = zzgf(paramString.length());
        if (k == j)
        {
          this.position = (i + k);
          int m = zzdra.zza(paramString, this.buffer, this.position, zzawu());
          this.position = i;
          zzga(m - i - k);
          this.position = m;
          return;
        }
        zzga(zzdra.zza(paramString));
        this.position = zzdra.zza(paramString, this.buffer, this.position, zzawu());
        return;
      }
      catch (zzdre localzzdre)
      {
        this.position = i;
        zza(paramString, localzzdre);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzdnh.zzc(localIndexOutOfBoundsException);
      }
    }

    public final void zzh(int paramInt, long paramLong)
      throws IOException
    {
      zzw(paramInt, 0);
      zzfj(paramLong);
    }

    public final void zzh(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }

    public final void zzi(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzw(paramInt, 0);
      int i = 0;
      if (paramBoolean)
        i = 1;
      zzd((byte)i);
    }

    public final void zzj(int paramInt, long paramLong)
      throws IOException
    {
      zzw(paramInt, 1);
      zzfl(paramLong);
    }

    public final void zzj(zzdpj paramzzdpj)
      throws IOException
    {
      zzga(paramzzdpj.zzaxj());
      paramzzdpj.zzb(this);
    }

    public final void zzk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzga(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }

    public final void zzw(int paramInt1, int paramInt2)
      throws IOException
    {
      zzga(paramInt2 | paramInt1 << 3);
    }

    public final void zzx(int paramInt1, int paramInt2)
      throws IOException
    {
      zzw(paramInt1, 0);
      zzfz(paramInt2);
    }

    public final void zzy(int paramInt1, int paramInt2)
      throws IOException
    {
      zzw(paramInt1, 0);
      zzga(paramInt2);
    }
  }

  static final class zzb extends zzdnh.zza
  {
    private final ByteBuffer zzhdp;
    private int zzhdq;

    zzb(ByteBuffer paramByteBuffer)
    {
      super(paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
      this.zzhdp = paramByteBuffer;
      this.zzhdq = paramByteBuffer.position();
    }

    public final void flush()
    {
      this.zzhdp.position(this.zzhdq + zzawx());
    }
  }

  public static final class zzc extends IOException
  {
    zzc()
    {
      super();
    }

    zzc(String paramString)
    {
    }

    zzc(String paramString, Throwable paramThrowable)
    {
    }

    zzc(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }

  static final class zzd extends zzdnh
  {
    private final ByteBuffer zzaxl;
    private final int zzhdq;
    private final ByteBuffer zzhdr;

    zzd(ByteBuffer paramByteBuffer)
    {
      super();
      this.zzhdr = paramByteBuffer;
      this.zzaxl = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.zzhdq = paramByteBuffer.position();
    }

    private final void zzgy(String paramString)
      throws IOException
    {
      try
      {
        zzdra.zza(paramString, this.zzaxl);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzdnh.zzc(localIndexOutOfBoundsException);
      }
    }

    public final void flush()
    {
      this.zzhdr.position(this.zzaxl.position());
    }

    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        this.zzaxl.put(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzdnh.zzc(localIndexOutOfBoundsException);
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zzdnh.zzc(localBufferOverflowException);
      }
    }

    public final void zza(int paramInt, zzdmq paramzzdmq)
      throws IOException
    {
      zzw(paramInt, 2);
      zzcz(paramzzdmq);
    }

    public final void zza(int paramInt, zzdpj paramzzdpj)
      throws IOException
    {
      zzw(paramInt, 2);
      zzj(paramzzdpj);
    }

    final void zza(int paramInt, zzdpj paramzzdpj, zzdqa paramzzdqa)
      throws IOException
    {
      zzw(paramInt, 2);
      zza(paramzzdpj, paramzzdqa);
    }

    final void zza(zzdpj paramzzdpj, zzdqa paramzzdqa)
      throws IOException
    {
      zzdmh localzzdmh = (zzdmh)paramzzdpj;
      int i = localzzdmh.zzavg();
      if (i == -1)
      {
        i = paramzzdqa.zzak(localzzdmh);
        localzzdmh.zzfi(i);
      }
      zzga(i);
      paramzzdqa.zza(paramzzdpj, this.zzhdo);
    }

    public final void zzaa(int paramInt1, int paramInt2)
      throws IOException
    {
      zzw(paramInt1, 5);
      zzgc(paramInt2);
    }

    public final int zzawu()
    {
      return this.zzaxl.remaining();
    }

    public final void zzb(int paramInt, zzdmq paramzzdmq)
      throws IOException
    {
      zzw(1, 3);
      zzy(2, paramInt);
      zza(3, paramzzdmq);
      zzw(1, 4);
    }

    public final void zzb(int paramInt, zzdpj paramzzdpj)
      throws IOException
    {
      zzw(1, 3);
      zzy(2, paramInt);
      zza(3, paramzzdpj);
      zzw(1, 4);
    }

    public final void zzcz(zzdmq paramzzdmq)
      throws IOException
    {
      zzga(paramzzdmq.size());
      paramzzdmq.zza(this);
    }

    public final void zzd(byte paramByte)
      throws IOException
    {
      try
      {
        this.zzaxl.put(paramByte);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zzdnh.zzc(localBufferOverflowException);
      }
    }

    public final void zzf(int paramInt, String paramString)
      throws IOException
    {
      zzw(paramInt, 2);
      zzgw(paramString);
    }

    public final void zzfj(long paramLong)
      throws IOException
    {
      while (true)
      {
        if ((0xFFFFFF80 & paramLong) == 0L);
        try
        {
          this.zzaxl.put((byte)(int)paramLong);
          return;
          this.zzaxl.put((byte)(0x80 | 0x7F & (int)paramLong));
          paramLong >>>= 7;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new zzdnh.zzc(localBufferOverflowException);
        }
      }
    }

    public final void zzfl(long paramLong)
      throws IOException
    {
      try
      {
        this.zzaxl.putLong(paramLong);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zzdnh.zzc(localBufferOverflowException);
      }
    }

    public final void zzfz(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzga(paramInt);
        return;
      }
      zzfj(paramInt);
    }

    public final void zzga(int paramInt)
      throws IOException
    {
      while (true)
      {
        if ((paramInt & 0xFFFFFF80) == 0);
        try
        {
          this.zzaxl.put((byte)paramInt);
          return;
          this.zzaxl.put((byte)(0x80 | paramInt & 0x7F));
          paramInt >>>= 7;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new zzdnh.zzc(localBufferOverflowException);
        }
      }
    }

    public final void zzgc(int paramInt)
      throws IOException
    {
      try
      {
        this.zzaxl.putInt(paramInt);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zzdnh.zzc(localBufferOverflowException);
      }
    }

    public final void zzgw(String paramString)
      throws IOException
    {
      int i = this.zzaxl.position();
      try
      {
        int j = zzgf(3 * paramString.length());
        int k = zzgf(paramString.length());
        if (k == j)
        {
          int m = k + this.zzaxl.position();
          this.zzaxl.position(m);
          zzgy(paramString);
          int n = this.zzaxl.position();
          this.zzaxl.position(i);
          zzga(n - m);
          this.zzaxl.position(n);
          return;
        }
        zzga(zzdra.zza(paramString));
        zzgy(paramString);
        return;
      }
      catch (zzdre localzzdre)
      {
        this.zzaxl.position(i);
        zza(paramString, localzzdre);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new zzdnh.zzc(localIllegalArgumentException);
      }
    }

    public final void zzh(int paramInt, long paramLong)
      throws IOException
    {
      zzw(paramInt, 0);
      zzfj(paramLong);
    }

    public final void zzh(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }

    public final void zzi(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzw(paramInt, 0);
      int i = 0;
      if (paramBoolean)
        i = 1;
      zzd((byte)i);
    }

    public final void zzj(int paramInt, long paramLong)
      throws IOException
    {
      zzw(paramInt, 1);
      zzfl(paramLong);
    }

    public final void zzj(zzdpj paramzzdpj)
      throws IOException
    {
      zzga(paramzzdpj.zzaxj());
      paramzzdpj.zzb(this);
    }

    public final void zzk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzga(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }

    public final void zzw(int paramInt1, int paramInt2)
      throws IOException
    {
      zzga(paramInt2 | paramInt1 << 3);
    }

    public final void zzx(int paramInt1, int paramInt2)
      throws IOException
    {
      zzw(paramInt1, 0);
      zzfz(paramInt2);
    }

    public final void zzy(int paramInt1, int paramInt2)
      throws IOException
    {
      zzw(paramInt1, 0);
      zzga(paramInt2);
    }
  }

  static final class zze extends zzdnh
  {
    private long zzahv;
    private final ByteBuffer zzaxl;
    private final ByteBuffer zzhdr;
    private final long zzhds;
    private final long zzhdt;
    private final long zzhdu;
    private final long zzhdv;

    zze(ByteBuffer paramByteBuffer)
    {
      super();
      this.zzhdr = paramByteBuffer;
      this.zzaxl = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.zzhds = zzdqy.zzn(paramByteBuffer);
      this.zzhdt = (this.zzhds + paramByteBuffer.position());
      this.zzhdu = (this.zzhds + paramByteBuffer.limit());
      this.zzhdv = (this.zzhdu - 10L);
      this.zzahv = this.zzhdt;
    }

    private final void zzfs(long paramLong)
    {
      this.zzaxl.position((int)(paramLong - this.zzhds));
    }

    public final void flush()
    {
      this.zzhdr.position((int)(this.zzahv - this.zzhds));
    }

    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if ((paramArrayOfByte == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramArrayOfByte.length - paramInt2 < paramInt1) || (this.zzhdu - paramInt2 < this.zzahv))
      {
        if (paramArrayOfByte == null)
          throw new NullPointerException("value");
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Long.valueOf(this.zzahv);
        arrayOfObject[1] = Long.valueOf(this.zzhdu);
        arrayOfObject[2] = Integer.valueOf(paramInt2);
        throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject));
      }
      zzdqy.zza(paramArrayOfByte, paramInt1, this.zzahv, paramInt2);
      this.zzahv += paramInt2;
    }

    public final void zza(int paramInt, zzdmq paramzzdmq)
      throws IOException
    {
      zzw(paramInt, 2);
      zzcz(paramzzdmq);
    }

    public final void zza(int paramInt, zzdpj paramzzdpj)
      throws IOException
    {
      zzw(paramInt, 2);
      zzj(paramzzdpj);
    }

    final void zza(int paramInt, zzdpj paramzzdpj, zzdqa paramzzdqa)
      throws IOException
    {
      zzw(paramInt, 2);
      zza(paramzzdpj, paramzzdqa);
    }

    final void zza(zzdpj paramzzdpj, zzdqa paramzzdqa)
      throws IOException
    {
      zzdmh localzzdmh = (zzdmh)paramzzdpj;
      int i = localzzdmh.zzavg();
      if (i == -1)
      {
        i = paramzzdqa.zzak(localzzdmh);
        localzzdmh.zzfi(i);
      }
      zzga(i);
      paramzzdqa.zza(paramzzdpj, this.zzhdo);
    }

    public final void zzaa(int paramInt1, int paramInt2)
      throws IOException
    {
      zzw(paramInt1, 5);
      zzgc(paramInt2);
    }

    public final int zzawu()
    {
      return (int)(this.zzhdu - this.zzahv);
    }

    public final void zzb(int paramInt, zzdmq paramzzdmq)
      throws IOException
    {
      zzw(1, 3);
      zzy(2, paramInt);
      zza(3, paramzzdmq);
      zzw(1, 4);
    }

    public final void zzb(int paramInt, zzdpj paramzzdpj)
      throws IOException
    {
      zzw(1, 3);
      zzy(2, paramInt);
      zza(3, paramzzdpj);
      zzw(1, 4);
    }

    public final void zzcz(zzdmq paramzzdmq)
      throws IOException
    {
      zzga(paramzzdmq.size());
      paramzzdmq.zza(this);
    }

    public final void zzd(byte paramByte)
      throws IOException
    {
      if (this.zzahv >= this.zzhdu)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Long.valueOf(this.zzahv);
        arrayOfObject[1] = Long.valueOf(this.zzhdu);
        arrayOfObject[2] = Integer.valueOf(1);
        throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject));
      }
      long l = this.zzahv;
      this.zzahv = (1L + l);
      zzdqy.zza(l, paramByte);
    }

    public final void zzf(int paramInt, String paramString)
      throws IOException
    {
      zzw(paramInt, 2);
      zzgw(paramString);
    }

    public final void zzfj(long paramLong)
      throws IOException
    {
      if (this.zzahv <= this.zzhdv)
        while (true)
        {
          if ((paramLong & 0xFFFFFF80) == 0L)
          {
            long l4 = this.zzahv;
            this.zzahv = (l4 + 1L);
            zzdqy.zza(l4, (byte)(int)paramLong);
            return;
          }
          long l3 = this.zzahv;
          this.zzahv = (l3 + 1L);
          zzdqy.zza(l3, (byte)(0x80 | 0x7F & (int)paramLong));
          paramLong >>>= 7;
        }
      do
      {
        long l2 = this.zzahv;
        this.zzahv = (l2 + 1L);
        zzdqy.zza(l2, (byte)(0x80 | 0x7F & (int)paramLong));
        paramLong >>>= 7;
        if (this.zzahv >= this.zzhdu)
          break;
      }
      while ((paramLong & 0xFFFFFF80) != 0L);
      long l1 = this.zzahv;
      this.zzahv = (l1 + 1L);
      zzdqy.zza(l1, (byte)(int)paramLong);
      return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(this.zzahv);
      arrayOfObject[1] = Long.valueOf(this.zzhdu);
      arrayOfObject[2] = Integer.valueOf(1);
      throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject));
    }

    public final void zzfl(long paramLong)
      throws IOException
    {
      this.zzaxl.putLong((int)(this.zzahv - this.zzhds), paramLong);
      this.zzahv = (8L + this.zzahv);
    }

    public final void zzfz(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzga(paramInt);
        return;
      }
      zzfj(paramInt);
    }

    public final void zzga(int paramInt)
      throws IOException
    {
      if (this.zzahv <= this.zzhdv)
        while (true)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            long l4 = this.zzahv;
            this.zzahv = (l4 + 1L);
            zzdqy.zza(l4, (byte)paramInt);
            return;
          }
          long l3 = this.zzahv;
          this.zzahv = (l3 + 1L);
          zzdqy.zza(l3, (byte)(0x80 | paramInt & 0x7F));
          paramInt >>>= 7;
        }
      do
      {
        long l2 = this.zzahv;
        this.zzahv = (l2 + 1L);
        zzdqy.zza(l2, (byte)(0x80 | paramInt & 0x7F));
        paramInt >>>= 7;
        if (this.zzahv >= this.zzhdu)
          break;
      }
      while ((paramInt & 0xFFFFFF80) != 0);
      long l1 = this.zzahv;
      this.zzahv = (l1 + 1L);
      zzdqy.zza(l1, (byte)paramInt);
      return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(this.zzahv);
      arrayOfObject[1] = Long.valueOf(this.zzhdu);
      arrayOfObject[2] = Integer.valueOf(1);
      throw new zzdnh.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject));
    }

    public final void zzgc(int paramInt)
      throws IOException
    {
      this.zzaxl.putInt((int)(this.zzahv - this.zzhds), paramInt);
      this.zzahv = (4L + this.zzahv);
    }

    public final void zzgw(String paramString)
      throws IOException
    {
      long l = this.zzahv;
      try
      {
        int i = zzgf(3 * paramString.length());
        int j = zzgf(paramString.length());
        if (j == i)
        {
          int k = j + (int)(this.zzahv - this.zzhds);
          this.zzaxl.position(k);
          zzdra.zza(paramString, this.zzaxl);
          int m = this.zzaxl.position() - k;
          zzga(m);
          this.zzahv += m;
          return;
        }
        int n = zzdra.zza(paramString);
        zzga(n);
        zzfs(this.zzahv);
        zzdra.zza(paramString, this.zzaxl);
        this.zzahv += n;
        return;
      }
      catch (zzdre localzzdre)
      {
        this.zzahv = l;
        zzfs(this.zzahv);
        zza(paramString, localzzdre);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new zzdnh.zzc(localIllegalArgumentException);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zzdnh.zzc(localIndexOutOfBoundsException);
      }
    }

    public final void zzh(int paramInt, long paramLong)
      throws IOException
    {
      zzw(paramInt, 0);
      zzfj(paramLong);
    }

    public final void zzh(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }

    public final void zzi(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzw(paramInt, 0);
      int i = 0;
      if (paramBoolean)
        i = 1;
      zzd((byte)i);
    }

    public final void zzj(int paramInt, long paramLong)
      throws IOException
    {
      zzw(paramInt, 1);
      zzfl(paramLong);
    }

    public final void zzj(zzdpj paramzzdpj)
      throws IOException
    {
      zzga(paramzzdpj.zzaxj());
      paramzzdpj.zzb(this);
    }

    public final void zzk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzga(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }

    public final void zzw(int paramInt1, int paramInt2)
      throws IOException
    {
      zzga(paramInt2 | paramInt1 << 3);
    }

    public final void zzx(int paramInt1, int paramInt2)
      throws IOException
    {
      zzw(paramInt1, 0);
      zzfz(paramInt2);
    }

    public final void zzy(int paramInt1, int paramInt2)
      throws IOException
    {
      zzw(paramInt1, 0);
      zzga(paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnh
 * JD-Core Version:    0.6.2
 */