package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

class zzdna extends zzdmz
{
  protected final byte[] zzhcy;

  zzdna(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException();
    this.zzhcy = paramArrayOfByte;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof zzdmq))
      return false;
    if (size() != ((zzdmq)paramObject).size())
      return false;
    if (size() == 0)
      return true;
    if ((paramObject instanceof zzdna))
    {
      zzdna localzzdna = (zzdna)paramObject;
      int i = zzavq();
      int j = localzzdna.zzavq();
      if ((i != 0) && (j != 0) && (i != j))
        return false;
      return zza((zzdna)paramObject, 0, size());
    }
    return paramObject.equals(this);
  }

  public int size()
  {
    return this.zzhcy.length;
  }

  protected final String zza(Charset paramCharset)
  {
    return new String(this.zzhcy, zzavr(), size(), paramCharset);
  }

  final void zza(zzdmp paramzzdmp)
    throws IOException
  {
    paramzzdmp.zzh(this.zzhcy, zzavr(), size());
  }

  protected void zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.zzhcy, 0, paramArrayOfByte, 0, paramInt3);
  }

  final boolean zza(zzdmq paramzzdmq, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramzzdmq.size())
    {
      int n = size();
      throw new IllegalArgumentException(40 + "Length too large: " + paramInt2 + n);
    }
    if (paramInt2 > paramzzdmq.size())
    {
      int m = paramzzdmq.size();
      throw new IllegalArgumentException(59 + "Ran off end of other: 0, " + paramInt2 + ", " + m);
    }
    if ((paramzzdmq instanceof zzdna))
    {
      zzdna localzzdna = (zzdna)paramzzdmq;
      byte[] arrayOfByte1 = this.zzhcy;
      byte[] arrayOfByte2 = localzzdna.zzhcy;
      int i = paramInt2 + zzavr();
      int j = zzavr();
      for (int k = localzzdna.zzavr(); j < i; k++)
      {
        if (arrayOfByte1[j] != arrayOfByte2[k])
          return false;
        j++;
      }
      return true;
    }
    return paramzzdmq.zzv(0, paramInt2).equals(zzv(0, paramInt2));
  }

  public final boolean zzavo()
  {
    int i = zzavr();
    return zzdra.zzl(this.zzhcy, i, i + size());
  }

  public final zzdnc zzavp()
  {
    return zzdnc.zzc(this.zzhcy, zzavr(), size(), true);
  }

  protected int zzavr()
  {
    return 0;
  }

  protected final int zzf(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzdoc.zza(paramInt1, this.zzhcy, zzavr(), paramInt3);
  }

  public byte zzfm(int paramInt)
  {
    return this.zzhcy[paramInt];
  }

  byte zzfn(int paramInt)
  {
    return this.zzhcy[paramInt];
  }

  public final zzdmq zzv(int paramInt1, int paramInt2)
  {
    int i = zzg(0, paramInt2, size());
    if (i == 0)
      return zzdmq.zzhcr;
    return new zzdmv(this.zzhcy, zzavr(), i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdna
 * JD-Core Version:    0.6.2
 */