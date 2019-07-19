package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;

public abstract class zzdmq
  implements Serializable, Iterable<Byte>
{
  public static final zzdmq zzhcr = new zzdna(zzdoc.zzhia);
  private static final zzdmw zzhcs;
  private static final Comparator<zzdmq> zzhct;
  private int zzhca = 0;

  static
  {
    if (zzdml.zzavl());
    for (Object localObject = new zzdnb(null); ; localObject = new zzdmu(null))
    {
      zzhcs = (zzdmw)localObject;
      zzhct = new zzdms();
      return;
    }
  }

  static zzdmq zzaa(byte[] paramArrayOfByte)
  {
    return new zzdna(paramArrayOfByte);
  }

  private static int zzb(byte paramByte)
  {
    return paramByte & 0xFF;
  }

  static zzdmy zzfo(int paramInt)
  {
    return new zzdmy(paramInt, null);
  }

  static int zzg(int paramInt1, int paramInt2, int paramInt3)
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

  public static zzdmq zzgv(String paramString)
  {
    return new zzdna(paramString.getBytes(zzdoc.UTF_8));
  }

  public static zzdmq zzi(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    zzg(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    return new zzdna(zzhcs.zzj(paramArrayOfByte, paramInt1, paramInt2));
  }

  public static zzdmq zzz(byte[] paramArrayOfByte)
  {
    return zzi(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public abstract boolean equals(Object paramObject);

  public final int hashCode()
  {
    int i = this.zzhca;
    if (i == 0)
    {
      int j = size();
      i = zzf(j, 0, j);
      if (i == 0)
        i = 1;
      this.zzhca = i;
    }
    return i;
  }

  public abstract int size();

  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0)
      return zzdoc.zzhia;
    byte[] arrayOfByte = new byte[i];
    zza(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }

  public final String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.toHexString(System.identityHashCode(this));
    arrayOfObject[1] = Integer.valueOf(size());
    return String.format("<ByteString@%s size=%d>", arrayOfObject);
  }

  protected abstract String zza(Charset paramCharset);

  abstract void zza(zzdmp paramzzdmp)
    throws IOException;

  protected abstract void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);

  public final String zzavn()
  {
    Charset localCharset = zzdoc.UTF_8;
    if (size() == 0)
      return "";
    return zza(localCharset);
  }

  public abstract boolean zzavo();

  public abstract zzdnc zzavp();

  protected final int zzavq()
  {
    return this.zzhca;
  }

  protected abstract int zzf(int paramInt1, int paramInt2, int paramInt3);

  public abstract byte zzfm(int paramInt);

  abstract byte zzfn(int paramInt);

  public abstract zzdmq zzv(int paramInt1, int paramInt2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmq
 * JD-Core Version:    0.6.2
 */