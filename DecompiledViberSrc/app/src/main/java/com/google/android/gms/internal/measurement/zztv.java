package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zztv extends zztd
{
  private static final Logger logger = Logger.getLogger(zztv.class.getName());
  private static final boolean zzbuo = zzxj.zzyo();
  zztx zzbup;

  public static int zza(int paramInt, zzvc paramzzvc)
  {
    int i = zzbd(paramInt);
    int j = paramzzvc.zzvx();
    return i + (j + zzbf(j));
  }

  public static int zza(zzvc paramzzvc)
  {
    int i = paramzzvc.zzvx();
    return i + zzbf(i);
  }

  public static zztv zza(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
      return new zzb(paramByteBuffer);
    if ((paramByteBuffer.isDirect()) && (!paramByteBuffer.isReadOnly()))
    {
      if (zzxj.zzyp())
        return new zze(paramByteBuffer);
      return new zzd(paramByteBuffer);
    }
    throw new IllegalArgumentException("ByteBuffer is read-only");
  }

  public static int zzaw(long paramLong)
  {
    return zzax(paramLong);
  }

  public static int zzax(long paramLong)
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

  public static int zzay(long paramLong)
  {
    return zzax(zzbb(paramLong));
  }

  public static int zzaz(long paramLong)
  {
    return 8;
  }

  public static int zzb(float paramFloat)
  {
    return 4;
  }

  public static int zzb(int paramInt, double paramDouble)
  {
    return 8 + zzbd(paramInt);
  }

  public static int zzb(int paramInt, float paramFloat)
  {
    return 4 + zzbd(paramInt);
  }

  public static int zzb(int paramInt, zzvc paramzzvc)
  {
    return (zzbd(1) << 1) + zzi(2, paramInt) + zza(3, paramzzvc);
  }

  static int zzb(int paramInt, zzvv paramzzvv, zzwl paramzzwl)
  {
    return zzbd(paramInt) + zzb(paramzzvv, paramzzwl);
  }

  public static int zzb(zzte paramzzte)
  {
    int i = paramzzte.size();
    return i + zzbf(i);
  }

  static int zzb(zzvv paramzzvv, zzwl paramzzwl)
  {
    zzsx localzzsx = (zzsx)paramzzvv;
    int i = localzzsx.zztx();
    if (i == -1)
    {
      i = paramzzwl.zzai(localzzsx);
      localzzsx.zzai(i);
    }
    return i + zzbf(i);
  }

  public static int zzba(long paramLong)
  {
    return 8;
  }

  private static long zzbb(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }

  public static int zzbd(int paramInt)
  {
    return zzbf(paramInt << 3);
  }

  public static int zzbe(int paramInt)
  {
    if (paramInt >= 0)
      return zzbf(paramInt);
    return 10;
  }

  public static int zzbf(int paramInt)
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

  public static int zzbg(int paramInt)
  {
    return zzbf(zzbk(paramInt));
  }

  public static int zzbh(int paramInt)
  {
    return 4;
  }

  public static int zzbi(int paramInt)
  {
    return 4;
  }

  public static int zzbj(int paramInt)
  {
    return zzbe(paramInt);
  }

  private static int zzbk(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  @Deprecated
  public static int zzbl(int paramInt)
  {
    return zzbf(paramInt);
  }

  public static int zzc(double paramDouble)
  {
    return 8;
  }

  public static int zzc(int paramInt, zzte paramzzte)
  {
    int i = zzbd(paramInt);
    int j = paramzzte.size();
    return i + (j + zzbf(j));
  }

  public static int zzc(int paramInt, zzvv paramzzvv)
  {
    return zzbd(paramInt) + zzc(paramzzvv);
  }

  @Deprecated
  static int zzc(int paramInt, zzvv paramzzvv, zzwl paramzzwl)
  {
    int i = zzbd(paramInt) << 1;
    zzsx localzzsx = (zzsx)paramzzvv;
    int j = localzzsx.zztx();
    if (j == -1)
    {
      j = paramzzwl.zzai(localzzsx);
      localzzsx.zzai(j);
    }
    return j + i;
  }

  public static int zzc(int paramInt, String paramString)
  {
    return zzbd(paramInt) + zzgc(paramString);
  }

  public static int zzc(int paramInt, boolean paramBoolean)
  {
    return 1 + zzbd(paramInt);
  }

  public static int zzc(zzvv paramzzvv)
  {
    int i = paramzzvv.zzvx();
    return i + zzbf(i);
  }

  public static int zzd(int paramInt, long paramLong)
  {
    return zzbd(paramInt) + zzax(paramLong);
  }

  public static int zzd(int paramInt, zzte paramzzte)
  {
    return (zzbd(1) << 1) + zzi(2, paramInt) + zzc(3, paramzzte);
  }

  public static int zzd(int paramInt, zzvv paramzzvv)
  {
    return (zzbd(1) << 1) + zzi(2, paramInt) + zzc(3, paramzzvv);
  }

  @Deprecated
  public static int zzd(zzvv paramzzvv)
  {
    return paramzzvv.zzvx();
  }

  public static int zze(int paramInt, long paramLong)
  {
    return zzbd(paramInt) + zzax(paramLong);
  }

  public static int zzf(int paramInt, long paramLong)
  {
    return zzbd(paramInt) + zzax(zzbb(paramLong));
  }

  public static int zzg(int paramInt, long paramLong)
  {
    return 8 + zzbd(paramInt);
  }

  public static int zzgc(String paramString)
  {
    try
    {
      int j = zzxl.zza(paramString);
      i = j;
      return i + zzbf(i);
    }
    catch (zzxp localzzxp)
    {
      while (true)
        int i = paramString.getBytes(zzuq.UTF_8).length;
    }
  }

  public static int zzh(int paramInt1, int paramInt2)
  {
    return zzbd(paramInt1) + zzbe(paramInt2);
  }

  public static int zzh(int paramInt, long paramLong)
  {
    return 8 + zzbd(paramInt);
  }

  public static int zzi(int paramInt1, int paramInt2)
  {
    return zzbd(paramInt1) + zzbf(paramInt2);
  }

  public static int zzj(int paramInt1, int paramInt2)
  {
    return zzbd(paramInt1) + zzbf(zzbk(paramInt2));
  }

  public static zztv zzj(byte[] paramArrayOfByte)
  {
    return new zza(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static int zzk(int paramInt1, int paramInt2)
  {
    return 4 + zzbd(paramInt1);
  }

  public static int zzk(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return i + zzbf(i);
  }

  public static int zzl(int paramInt1, int paramInt2)
  {
    return 4 + zzbd(paramInt1);
  }

  public static int zzm(int paramInt1, int paramInt2)
  {
    return zzbd(paramInt1) + zzbe(paramInt2);
  }

  public static int zzt(boolean paramBoolean)
  {
    return 1;
  }

  public abstract void flush()
    throws IOException;

  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;

  public final void zza(float paramFloat)
    throws IOException
  {
    zzbc(Float.floatToRawIntBits(paramFloat));
  }

  public final void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzc(paramInt, Double.doubleToRawLongBits(paramDouble));
  }

  public final void zza(int paramInt, float paramFloat)
    throws IOException
  {
    zzg(paramInt, Float.floatToRawIntBits(paramFloat));
  }

  public abstract void zza(int paramInt, long paramLong)
    throws IOException;

  public abstract void zza(int paramInt, zzte paramzzte)
    throws IOException;

  public abstract void zza(int paramInt, zzvv paramzzvv)
    throws IOException;

  abstract void zza(int paramInt, zzvv paramzzvv, zzwl paramzzwl)
    throws IOException;

  public abstract void zza(zzte paramzzte)
    throws IOException;

  abstract void zza(zzvv paramzzvv, zzwl paramzzwl)
    throws IOException;

  final void zza(String paramString, zzxp paramzzxp)
    throws IOException
  {
    logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramzzxp);
    byte[] arrayOfByte = paramString.getBytes(zzuq.UTF_8);
    try
    {
      zzba(arrayOfByte.length);
      zza(arrayOfByte, 0, arrayOfByte.length);
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

  public abstract void zzat(long paramLong)
    throws IOException;

  public final void zzau(long paramLong)
    throws IOException
  {
    zzat(zzbb(paramLong));
  }

  public abstract void zzav(long paramLong)
    throws IOException;

  public abstract void zzaz(int paramInt)
    throws IOException;

  public final void zzb(double paramDouble)
    throws IOException
  {
    zzav(Double.doubleToRawLongBits(paramDouble));
  }

  public final void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zza(paramInt, zzbb(paramLong));
  }

  public abstract void zzb(int paramInt, zzte paramzzte)
    throws IOException;

  public abstract void zzb(int paramInt, zzvv paramzzvv)
    throws IOException;

  public abstract void zzb(int paramInt, String paramString)
    throws IOException;

  public abstract void zzb(int paramInt, boolean paramBoolean)
    throws IOException;

  public abstract void zzb(zzvv paramzzvv)
    throws IOException;

  public abstract void zzba(int paramInt)
    throws IOException;

  public final void zzbb(int paramInt)
    throws IOException
  {
    zzba(zzbk(paramInt));
  }

  public abstract void zzbc(int paramInt)
    throws IOException;

  public abstract void zzc(byte paramByte)
    throws IOException;

  public abstract void zzc(int paramInt1, int paramInt2)
    throws IOException;

  public abstract void zzc(int paramInt, long paramLong)
    throws IOException;

  public abstract void zzd(int paramInt1, int paramInt2)
    throws IOException;

  public abstract void zze(int paramInt1, int paramInt2)
    throws IOException;

  abstract void zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;

  public final void zzf(int paramInt1, int paramInt2)
    throws IOException
  {
    zze(paramInt1, zzbk(paramInt2));
  }

  public abstract void zzg(int paramInt1, int paramInt2)
    throws IOException;

  public abstract void zzgb(String paramString)
    throws IOException;

  public final void zzs(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      zzc((byte)i);
      return;
    }
  }

  public abstract int zzvj();

  static class zza extends zztv
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
        throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zza(int paramInt, long paramLong)
      throws IOException
    {
      zzc(paramInt, 0);
      zzat(paramLong);
    }

    public final void zza(int paramInt, zzte paramzzte)
      throws IOException
    {
      zzc(paramInt, 2);
      zza(paramzzte);
    }

    public final void zza(int paramInt, zzvv paramzzvv)
      throws IOException
    {
      zzc(paramInt, 2);
      zzb(paramzzvv);
    }

    final void zza(int paramInt, zzvv paramzzvv, zzwl paramzzwl)
      throws IOException
    {
      zzc(paramInt, 2);
      zzsx localzzsx = (zzsx)paramzzvv;
      int i = localzzsx.zztx();
      if (i == -1)
      {
        i = paramzzwl.zzai(localzzsx);
        localzzsx.zzai(i);
      }
      zzba(i);
      paramzzwl.zza(paramzzvv, this.zzbup);
    }

    public final void zza(zzte paramzzte)
      throws IOException
    {
      zzba(paramzzte.size());
      paramzzte.zza(this);
    }

    final void zza(zzvv paramzzvv, zzwl paramzzwl)
      throws IOException
    {
      zzsx localzzsx = (zzsx)paramzzvv;
      int i = localzzsx.zztx();
      if (i == -1)
      {
        i = paramzzwl.zzai(localzzsx);
        localzzsx.zzai(i);
      }
      zzba(i);
      paramzzwl.zza(paramzzvv, this.zzbup);
    }

    public final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }

    public final void zzat(long paramLong)
      throws IOException
    {
      if ((zztv.zzvk()) && (zzvj() >= 10))
        while (true)
        {
          if ((paramLong & 0xFFFFFF80) == 0L)
          {
            byte[] arrayOfByte4 = this.buffer;
            int m = this.position;
            this.position = (m + 1);
            zzxj.zza(arrayOfByte4, m, (byte)(int)paramLong);
            return;
          }
          byte[] arrayOfByte3 = this.buffer;
          int k = this.position;
          this.position = (k + 1);
          zzxj.zza(arrayOfByte3, k, (byte)(0x80 | 0x7F & (int)paramLong));
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
        throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzav(long paramLong)
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
        throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzaz(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzba(paramInt);
        return;
      }
      zzat(paramInt);
    }

    public final void zzb(int paramInt, zzte paramzzte)
      throws IOException
    {
      zzc(1, 3);
      zze(2, paramInt);
      zza(3, paramzzte);
      zzc(1, 4);
    }

    public final void zzb(int paramInt, zzvv paramzzvv)
      throws IOException
    {
      zzc(1, 3);
      zze(2, paramInt);
      zza(3, paramzzvv);
      zzc(1, 4);
    }

    public final void zzb(int paramInt, String paramString)
      throws IOException
    {
      zzc(paramInt, 2);
      zzgb(paramString);
    }

    public final void zzb(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzc(paramInt, 0);
      int i = 0;
      if (paramBoolean)
        i = 1;
      zzc((byte)i);
    }

    public final void zzb(zzvv paramzzvv)
      throws IOException
    {
      zzba(paramzzvv.zzvx());
      paramzzvv.zzb(this);
    }

    public final void zzba(int paramInt)
      throws IOException
    {
      if ((zztv.zzvk()) && (zzvj() >= 10))
        while (true)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            byte[] arrayOfByte4 = this.buffer;
            int m = this.position;
            this.position = (m + 1);
            zzxj.zza(arrayOfByte4, m, (byte)paramInt);
            return;
          }
          byte[] arrayOfByte3 = this.buffer;
          int k = this.position;
          this.position = (k + 1);
          zzxj.zza(arrayOfByte3, k, (byte)(0x80 | paramInt & 0x7F));
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
        throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzbc(int paramInt)
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
        throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzc(byte paramByte)
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
        throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject), localIndexOutOfBoundsException);
      }
    }

    public final void zzc(int paramInt1, int paramInt2)
      throws IOException
    {
      zzba(paramInt2 | paramInt1 << 3);
    }

    public final void zzc(int paramInt, long paramLong)
      throws IOException
    {
      zzc(paramInt, 1);
      zzav(paramLong);
    }

    public final void zzd(int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramInt1, 0);
      zzaz(paramInt2);
    }

    public final void zze(int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramInt1, 0);
      zzba(paramInt2);
    }

    public final void zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzba(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }

    public final void zzg(int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramInt1, 5);
      zzbc(paramInt2);
    }

    public final void zzgb(String paramString)
      throws IOException
    {
      int i = this.position;
      try
      {
        int j = zzbf(3 * paramString.length());
        int k = zzbf(paramString.length());
        if (k == j)
        {
          this.position = (i + k);
          int m = zzxl.zza(paramString, this.buffer, this.position, zzvj());
          this.position = i;
          zzba(m - i - k);
          this.position = m;
          return;
        }
        zzba(zzxl.zza(paramString));
        this.position = zzxl.zza(paramString, this.buffer, this.position, zzvj());
        return;
      }
      catch (zzxp localzzxp)
      {
        this.position = i;
        zza(paramString, localzzxp);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zztv.zzc(localIndexOutOfBoundsException);
      }
    }

    public final int zzvj()
    {
      return this.limit - this.position;
    }

    public final int zzvl()
    {
      return this.position - this.offset;
    }
  }

  static final class zzb extends zztv.zza
  {
    private final ByteBuffer zzbuq;
    private int zzbur;

    zzb(ByteBuffer paramByteBuffer)
    {
      super(paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
      this.zzbuq = paramByteBuffer;
      this.zzbur = paramByteBuffer.position();
    }

    public final void flush()
    {
      this.zzbuq.position(this.zzbur + zzvl());
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

  static final class zzd extends zztv
  {
    private final int zzbur;
    private final ByteBuffer zzbus;
    private final ByteBuffer zzbut;

    zzd(ByteBuffer paramByteBuffer)
    {
      super();
      this.zzbus = paramByteBuffer;
      this.zzbut = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.zzbur = paramByteBuffer.position();
    }

    private final void zzgd(String paramString)
      throws IOException
    {
      try
      {
        zzxl.zza(paramString, this.zzbut);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zztv.zzc(localIndexOutOfBoundsException);
      }
    }

    public final void flush()
    {
      this.zzbus.position(this.zzbut.position());
    }

    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        this.zzbut.put(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zztv.zzc(localIndexOutOfBoundsException);
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zztv.zzc(localBufferOverflowException);
      }
    }

    public final void zza(int paramInt, long paramLong)
      throws IOException
    {
      zzc(paramInt, 0);
      zzat(paramLong);
    }

    public final void zza(int paramInt, zzte paramzzte)
      throws IOException
    {
      zzc(paramInt, 2);
      zza(paramzzte);
    }

    public final void zza(int paramInt, zzvv paramzzvv)
      throws IOException
    {
      zzc(paramInt, 2);
      zzb(paramzzvv);
    }

    final void zza(int paramInt, zzvv paramzzvv, zzwl paramzzwl)
      throws IOException
    {
      zzc(paramInt, 2);
      zza(paramzzvv, paramzzwl);
    }

    public final void zza(zzte paramzzte)
      throws IOException
    {
      zzba(paramzzte.size());
      paramzzte.zza(this);
    }

    final void zza(zzvv paramzzvv, zzwl paramzzwl)
      throws IOException
    {
      zzsx localzzsx = (zzsx)paramzzvv;
      int i = localzzsx.zztx();
      if (i == -1)
      {
        i = paramzzwl.zzai(localzzsx);
        localzzsx.zzai(i);
      }
      zzba(i);
      paramzzwl.zza(paramzzvv, this.zzbup);
    }

    public final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }

    public final void zzat(long paramLong)
      throws IOException
    {
      while (true)
      {
        if ((0xFFFFFF80 & paramLong) == 0L);
        try
        {
          this.zzbut.put((byte)(int)paramLong);
          return;
          this.zzbut.put((byte)(0x80 | 0x7F & (int)paramLong));
          paramLong >>>= 7;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new zztv.zzc(localBufferOverflowException);
        }
      }
    }

    public final void zzav(long paramLong)
      throws IOException
    {
      try
      {
        this.zzbut.putLong(paramLong);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zztv.zzc(localBufferOverflowException);
      }
    }

    public final void zzaz(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzba(paramInt);
        return;
      }
      zzat(paramInt);
    }

    public final void zzb(int paramInt, zzte paramzzte)
      throws IOException
    {
      zzc(1, 3);
      zze(2, paramInt);
      zza(3, paramzzte);
      zzc(1, 4);
    }

    public final void zzb(int paramInt, zzvv paramzzvv)
      throws IOException
    {
      zzc(1, 3);
      zze(2, paramInt);
      zza(3, paramzzvv);
      zzc(1, 4);
    }

    public final void zzb(int paramInt, String paramString)
      throws IOException
    {
      zzc(paramInt, 2);
      zzgb(paramString);
    }

    public final void zzb(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzc(paramInt, 0);
      int i = 0;
      if (paramBoolean)
        i = 1;
      zzc((byte)i);
    }

    public final void zzb(zzvv paramzzvv)
      throws IOException
    {
      zzba(paramzzvv.zzvx());
      paramzzvv.zzb(this);
    }

    public final void zzba(int paramInt)
      throws IOException
    {
      while (true)
      {
        if ((paramInt & 0xFFFFFF80) == 0);
        try
        {
          this.zzbut.put((byte)paramInt);
          return;
          this.zzbut.put((byte)(0x80 | paramInt & 0x7F));
          paramInt >>>= 7;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          throw new zztv.zzc(localBufferOverflowException);
        }
      }
    }

    public final void zzbc(int paramInt)
      throws IOException
    {
      try
      {
        this.zzbut.putInt(paramInt);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zztv.zzc(localBufferOverflowException);
      }
    }

    public final void zzc(byte paramByte)
      throws IOException
    {
      try
      {
        this.zzbut.put(paramByte);
        return;
      }
      catch (BufferOverflowException localBufferOverflowException)
      {
        throw new zztv.zzc(localBufferOverflowException);
      }
    }

    public final void zzc(int paramInt1, int paramInt2)
      throws IOException
    {
      zzba(paramInt2 | paramInt1 << 3);
    }

    public final void zzc(int paramInt, long paramLong)
      throws IOException
    {
      zzc(paramInt, 1);
      zzav(paramLong);
    }

    public final void zzd(int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramInt1, 0);
      zzaz(paramInt2);
    }

    public final void zze(int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramInt1, 0);
      zzba(paramInt2);
    }

    public final void zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzba(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }

    public final void zzg(int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramInt1, 5);
      zzbc(paramInt2);
    }

    public final void zzgb(String paramString)
      throws IOException
    {
      int i = this.zzbut.position();
      try
      {
        int j = zzbf(3 * paramString.length());
        int k = zzbf(paramString.length());
        if (k == j)
        {
          int m = k + this.zzbut.position();
          this.zzbut.position(m);
          zzgd(paramString);
          int n = this.zzbut.position();
          this.zzbut.position(i);
          zzba(n - m);
          this.zzbut.position(n);
          return;
        }
        zzba(zzxl.zza(paramString));
        zzgd(paramString);
        return;
      }
      catch (zzxp localzzxp)
      {
        this.zzbut.position(i);
        zza(paramString, localzzxp);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new zztv.zzc(localIllegalArgumentException);
      }
    }

    public final int zzvj()
    {
      return this.zzbut.remaining();
    }
  }

  static final class zze extends zztv
  {
    private final ByteBuffer zzbus;
    private final ByteBuffer zzbut;
    private final long zzbuu;
    private final long zzbuv;
    private final long zzbuw;
    private final long zzbux;
    private long zzbuy;

    zze(ByteBuffer paramByteBuffer)
    {
      super();
      this.zzbus = paramByteBuffer;
      this.zzbut = paramByteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
      this.zzbuu = zzxj.zzb(paramByteBuffer);
      this.zzbuv = (this.zzbuu + paramByteBuffer.position());
      this.zzbuw = (this.zzbuu + paramByteBuffer.limit());
      this.zzbux = (this.zzbuw - 10L);
      this.zzbuy = this.zzbuv;
    }

    private final void zzbc(long paramLong)
    {
      this.zzbut.position((int)(paramLong - this.zzbuu));
    }

    public final void flush()
    {
      this.zzbus.position((int)(this.zzbuy - this.zzbuu));
    }

    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if ((paramArrayOfByte == null) || (paramInt1 < 0) || (paramInt2 < 0) || (paramArrayOfByte.length - paramInt2 < paramInt1) || (this.zzbuw - paramInt2 < this.zzbuy))
      {
        if (paramArrayOfByte == null)
          throw new NullPointerException("value");
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Long.valueOf(this.zzbuy);
        arrayOfObject[1] = Long.valueOf(this.zzbuw);
        arrayOfObject[2] = Integer.valueOf(paramInt2);
        throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject));
      }
      zzxj.zza(paramArrayOfByte, paramInt1, this.zzbuy, paramInt2);
      this.zzbuy += paramInt2;
    }

    public final void zza(int paramInt, long paramLong)
      throws IOException
    {
      zzc(paramInt, 0);
      zzat(paramLong);
    }

    public final void zza(int paramInt, zzte paramzzte)
      throws IOException
    {
      zzc(paramInt, 2);
      zza(paramzzte);
    }

    public final void zza(int paramInt, zzvv paramzzvv)
      throws IOException
    {
      zzc(paramInt, 2);
      zzb(paramzzvv);
    }

    final void zza(int paramInt, zzvv paramzzvv, zzwl paramzzwl)
      throws IOException
    {
      zzc(paramInt, 2);
      zza(paramzzvv, paramzzwl);
    }

    public final void zza(zzte paramzzte)
      throws IOException
    {
      zzba(paramzzte.size());
      paramzzte.zza(this);
    }

    final void zza(zzvv paramzzvv, zzwl paramzzwl)
      throws IOException
    {
      zzsx localzzsx = (zzsx)paramzzvv;
      int i = localzzsx.zztx();
      if (i == -1)
      {
        i = paramzzwl.zzai(localzzsx);
        localzzsx.zzai(i);
      }
      zzba(i);
      paramzzwl.zza(paramzzvv, this.zzbup);
    }

    public final void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }

    public final void zzat(long paramLong)
      throws IOException
    {
      if (this.zzbuy <= this.zzbux)
        while (true)
        {
          if ((paramLong & 0xFFFFFF80) == 0L)
          {
            long l4 = this.zzbuy;
            this.zzbuy = (l4 + 1L);
            zzxj.zza(l4, (byte)(int)paramLong);
            return;
          }
          long l3 = this.zzbuy;
          this.zzbuy = (l3 + 1L);
          zzxj.zza(l3, (byte)(0x80 | 0x7F & (int)paramLong));
          paramLong >>>= 7;
        }
      do
      {
        long l2 = this.zzbuy;
        this.zzbuy = (l2 + 1L);
        zzxj.zza(l2, (byte)(0x80 | 0x7F & (int)paramLong));
        paramLong >>>= 7;
        if (this.zzbuy >= this.zzbuw)
          break;
      }
      while ((paramLong & 0xFFFFFF80) != 0L);
      long l1 = this.zzbuy;
      this.zzbuy = (l1 + 1L);
      zzxj.zza(l1, (byte)(int)paramLong);
      return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(this.zzbuy);
      arrayOfObject[1] = Long.valueOf(this.zzbuw);
      arrayOfObject[2] = Integer.valueOf(1);
      throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject));
    }

    public final void zzav(long paramLong)
      throws IOException
    {
      this.zzbut.putLong((int)(this.zzbuy - this.zzbuu), paramLong);
      this.zzbuy = (8L + this.zzbuy);
    }

    public final void zzaz(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzba(paramInt);
        return;
      }
      zzat(paramInt);
    }

    public final void zzb(int paramInt, zzte paramzzte)
      throws IOException
    {
      zzc(1, 3);
      zze(2, paramInt);
      zza(3, paramzzte);
      zzc(1, 4);
    }

    public final void zzb(int paramInt, zzvv paramzzvv)
      throws IOException
    {
      zzc(1, 3);
      zze(2, paramInt);
      zza(3, paramzzvv);
      zzc(1, 4);
    }

    public final void zzb(int paramInt, String paramString)
      throws IOException
    {
      zzc(paramInt, 2);
      zzgb(paramString);
    }

    public final void zzb(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzc(paramInt, 0);
      int i = 0;
      if (paramBoolean)
        i = 1;
      zzc((byte)i);
    }

    public final void zzb(zzvv paramzzvv)
      throws IOException
    {
      zzba(paramzzvv.zzvx());
      paramzzvv.zzb(this);
    }

    public final void zzba(int paramInt)
      throws IOException
    {
      if (this.zzbuy <= this.zzbux)
        while (true)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            long l4 = this.zzbuy;
            this.zzbuy = (l4 + 1L);
            zzxj.zza(l4, (byte)paramInt);
            return;
          }
          long l3 = this.zzbuy;
          this.zzbuy = (l3 + 1L);
          zzxj.zza(l3, (byte)(0x80 | paramInt & 0x7F));
          paramInt >>>= 7;
        }
      do
      {
        long l2 = this.zzbuy;
        this.zzbuy = (l2 + 1L);
        zzxj.zza(l2, (byte)(0x80 | paramInt & 0x7F));
        paramInt >>>= 7;
        if (this.zzbuy >= this.zzbuw)
          break;
      }
      while ((paramInt & 0xFFFFFF80) != 0);
      long l1 = this.zzbuy;
      this.zzbuy = (l1 + 1L);
      zzxj.zza(l1, (byte)paramInt);
      return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Long.valueOf(this.zzbuy);
      arrayOfObject[1] = Long.valueOf(this.zzbuw);
      arrayOfObject[2] = Integer.valueOf(1);
      throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject));
    }

    public final void zzbc(int paramInt)
      throws IOException
    {
      this.zzbut.putInt((int)(this.zzbuy - this.zzbuu), paramInt);
      this.zzbuy = (4L + this.zzbuy);
    }

    public final void zzc(byte paramByte)
      throws IOException
    {
      if (this.zzbuy >= this.zzbuw)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Long.valueOf(this.zzbuy);
        arrayOfObject[1] = Long.valueOf(this.zzbuw);
        arrayOfObject[2] = Integer.valueOf(1);
        throw new zztv.zzc(String.format("Pos: %d, limit: %d, len: %d", arrayOfObject));
      }
      long l = this.zzbuy;
      this.zzbuy = (1L + l);
      zzxj.zza(l, paramByte);
    }

    public final void zzc(int paramInt1, int paramInt2)
      throws IOException
    {
      zzba(paramInt2 | paramInt1 << 3);
    }

    public final void zzc(int paramInt, long paramLong)
      throws IOException
    {
      zzc(paramInt, 1);
      zzav(paramLong);
    }

    public final void zzd(int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramInt1, 0);
      zzaz(paramInt2);
    }

    public final void zze(int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramInt1, 0);
      zzba(paramInt2);
    }

    public final void zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzba(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }

    public final void zzg(int paramInt1, int paramInt2)
      throws IOException
    {
      zzc(paramInt1, 5);
      zzbc(paramInt2);
    }

    public final void zzgb(String paramString)
      throws IOException
    {
      long l = this.zzbuy;
      try
      {
        int i = zzbf(3 * paramString.length());
        int j = zzbf(paramString.length());
        if (j == i)
        {
          int k = j + (int)(this.zzbuy - this.zzbuu);
          this.zzbut.position(k);
          zzxl.zza(paramString, this.zzbut);
          int m = this.zzbut.position() - k;
          zzba(m);
          this.zzbuy += m;
          return;
        }
        int n = zzxl.zza(paramString);
        zzba(n);
        zzbc(this.zzbuy);
        zzxl.zza(paramString, this.zzbut);
        this.zzbuy += n;
        return;
      }
      catch (zzxp localzzxp)
      {
        this.zzbuy = l;
        zzbc(this.zzbuy);
        zza(paramString, localzzxp);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new zztv.zzc(localIllegalArgumentException);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new zztv.zzc(localIndexOutOfBoundsException);
      }
    }

    public final int zzvj()
    {
      return (int)(this.zzbuw - this.zzbuy);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zztv
 * JD-Core Version:    0.6.2
 */