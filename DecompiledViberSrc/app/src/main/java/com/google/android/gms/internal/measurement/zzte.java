package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;

public abstract class zzte
  implements Serializable, Iterable<Byte>
{
  public static final zzte zzbts = new zzto(zzuq.zzbzc);
  private static final zztk zzbtt;
  private static final Comparator<zzte> zzbtu;
  private int zzbsk = 0;

  static
  {
    if (zztb.zzub());
    for (Object localObject = new zztp(null); ; localObject = new zzti(null))
    {
      zzbtt = (zztk)localObject;
      zzbtu = new zztg();
      return;
    }
  }

  private static int zza(byte paramByte)
  {
    return paramByte & 0xFF;
  }

  static zztm zzao(int paramInt)
  {
    return new zztm(paramInt, null);
  }

  static int zzb(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((i | (paramInt1 | paramInt2) | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 < 0)
        throw new IndexOutOfBoundsException(32 + "Beginning index: " + paramInt1 + " < 0");
      if (paramInt2 < paramInt1)
        throw new IndexOutOfBoundsException(66 + "Beginning index larger than ending index: " + paramInt1 + ", " + paramInt2);
      throw new IndexOutOfBoundsException(37 + "End index: " + paramInt2 + " >= " + paramInt3);
    }
    return i;
  }

  public static zzte zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    zzb(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    return new zzto(zzbtt.zzc(paramArrayOfByte, paramInt1, paramInt2));
  }

  public static zzte zzga(String paramString)
  {
    return new zzto(paramString.getBytes(zzuq.UTF_8));
  }

  static zzte zzi(byte[] paramArrayOfByte)
  {
    return new zzto(paramArrayOfByte);
  }

  public abstract boolean equals(Object paramObject);

  public final int hashCode()
  {
    int i = this.zzbsk;
    if (i == 0)
    {
      int j = size();
      i = zza(j, 0, j);
      if (i == 0)
        i = 1;
      this.zzbsk = i;
    }
    return i;
  }

  public abstract int size();

  public final String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.toHexString(System.identityHashCode(this));
    arrayOfObject[1] = Integer.valueOf(size());
    return String.format("<ByteString@%s size=%d>", arrayOfObject);
  }

  protected abstract int zza(int paramInt1, int paramInt2, int paramInt3);

  protected abstract String zza(Charset paramCharset);

  abstract void zza(zztd paramzztd)
    throws IOException;

  public abstract byte zzam(int paramInt);

  abstract byte zzan(int paramInt);

  public abstract zzte zzb(int paramInt1, int paramInt2);

  public final String zzud()
  {
    Charset localCharset = zzuq.UTF_8;
    if (size() == 0)
      return "";
    return zza(localCharset);
  }

  public abstract boolean zzue();

  protected final int zzuf()
  {
    return this.zzbsk;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzte
 * JD-Core Version:    0.6.2
 */