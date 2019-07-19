package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfx extends zzyc<zzfx>
{
  public long[] zzayp = zzyl.zzcfk;
  public long[] zzayq = zzyl.zzcfk;
  public zzfs[] zzayr = zzfs.zzmy();
  public zzfy[] zzays = zzfy.zznc();

  public zzfx()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfx localzzfx;
    do
    {
      return true;
      if (!(paramObject instanceof zzfx))
        return false;
      localzzfx = (zzfx)paramObject;
      if (!zzyg.equals(this.zzayp, localzzfx.zzayp))
        return false;
      if (!zzyg.equals(this.zzayq, localzzfx.zzayq))
        return false;
      if (!zzyg.equals(this.zzayr, localzzfx.zzayr))
        return false;
      if (!zzyg.equals(this.zzays, localzzfx.zzays))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfx.zzcev == null) || (localzzfx.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfx.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (31 * (31 * (31 * (527 + getClass().getName().hashCode()) + zzyg.hashCode(this.zzayp)) + zzyg.hashCode(this.zzayq)) + zzyg.hashCode(this.zzayr)) + zzyg.hashCode(this.zzays));
    if ((this.zzcev == null) || (this.zzcev.isEmpty()));
    for (int j = 0; ; j = this.zzcev.hashCode())
      return j + i;
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if ((this.zzayp != null) && (this.zzayp.length > 0))
      for (int n = 0; n < this.zzayp.length; n++)
        paramzzya.zza(1, this.zzayp[n]);
    if ((this.zzayq != null) && (this.zzayq.length > 0))
      for (int m = 0; m < this.zzayq.length; m++)
        paramzzya.zza(2, this.zzayq[m]);
    if ((this.zzayr != null) && (this.zzayr.length > 0))
      for (int k = 0; k < this.zzayr.length; k++)
      {
        zzfs localzzfs = this.zzayr[k];
        if (localzzfs != null)
          paramzzya.zza(3, localzzfs);
      }
    if (this.zzays != null)
    {
      int i = this.zzays.length;
      int j = 0;
      if (i > 0)
        while (j < this.zzays.length)
        {
          zzfy localzzfy = this.zzays[j];
          if (localzzfy != null)
            paramzzya.zza(4, localzzfy);
          j++;
        }
    }
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    int i5;
    if ((this.zzayp != null) && (this.zzayp.length > 0))
    {
      int i4 = 0;
      i5 = 0;
      while (i4 < this.zzayp.length)
      {
        i5 += zzya.zzbg(this.zzayp[i4]);
        i4++;
      }
    }
    for (int j = i + i5 + 1 * this.zzayp.length; ; j = i)
    {
      if ((this.zzayq != null) && (this.zzayq.length > 0))
      {
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.zzayq.length)
        {
          i3 += zzya.zzbg(this.zzayq[i2]);
          i2++;
        }
        j = j + i3 + 1 * this.zzayq.length;
      }
      if ((this.zzayr != null) && (this.zzayr.length > 0))
      {
        int n = j;
        for (int i1 = 0; i1 < this.zzayr.length; i1++)
        {
          zzfs localzzfs = this.zzayr[i1];
          if (localzzfs != null)
            n += zzya.zzb(3, localzzfs);
        }
        j = n;
      }
      if (this.zzays != null)
      {
        int k = this.zzays.length;
        int m = 0;
        if (k > 0)
          while (m < this.zzays.length)
          {
            zzfy localzzfy = this.zzays[m];
            if (localzzfy != null)
              j += zzya.zzb(4, localzzfy);
            m++;
          }
      }
      return j;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfx
 * JD-Core Version:    0.6.2
 */