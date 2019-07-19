package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

class zzto extends zztn
{
  protected final byte[] zzbtz;

  zzto(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException();
    this.zzbtz = paramArrayOfByte;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof zzte))
      return false;
    if (size() != ((zzte)paramObject).size())
      return false;
    if (size() == 0)
      return true;
    if ((paramObject instanceof zzto))
    {
      zzto localzzto = (zzto)paramObject;
      int i = zzuf();
      int j = localzzto.zzuf();
      if ((i != 0) && (j != 0) && (i != j))
        return false;
      return zza((zzto)paramObject, 0, size());
    }
    return paramObject.equals(this);
  }

  public int size()
  {
    return this.zzbtz.length;
  }

  protected final int zza(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzuq.zza(paramInt1, this.zzbtz, zzug(), paramInt3);
  }

  protected final String zza(Charset paramCharset)
  {
    return new String(this.zzbtz, zzug(), size(), paramCharset);
  }

  final void zza(zztd paramzztd)
    throws IOException
  {
    paramzztd.zza(this.zzbtz, zzug(), size());
  }

  final boolean zza(zzte paramzzte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramzzte.size())
    {
      int n = size();
      throw new IllegalArgumentException(40 + "Length too large: " + paramInt2 + n);
    }
    if (paramInt2 > paramzzte.size())
    {
      int m = paramzzte.size();
      throw new IllegalArgumentException(59 + "Ran off end of other: 0, " + paramInt2 + ", " + m);
    }
    if ((paramzzte instanceof zzto))
    {
      zzto localzzto = (zzto)paramzzte;
      byte[] arrayOfByte1 = this.zzbtz;
      byte[] arrayOfByte2 = localzzto.zzbtz;
      int i = paramInt2 + zzug();
      int j = zzug();
      for (int k = localzzto.zzug(); j < i; k++)
      {
        if (arrayOfByte1[j] != arrayOfByte2[k])
          return false;
        j++;
      }
      return true;
    }
    return paramzzte.zzb(0, paramInt2).equals(zzb(0, paramInt2));
  }

  public byte zzam(int paramInt)
  {
    return this.zzbtz[paramInt];
  }

  byte zzan(int paramInt)
  {
    return this.zzbtz[paramInt];
  }

  public final zzte zzb(int paramInt1, int paramInt2)
  {
    int i = zzb(0, paramInt2, size());
    if (i == 0)
      return zzte.zzbts;
    return new zztj(this.zzbtz, zzug(), i);
  }

  public final boolean zzue()
  {
    int i = zzug();
    return zzxl.zzf(this.zzbtz, i, i + size());
  }

  protected int zzug()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzto
 * JD-Core Version:    0.6.2
 */