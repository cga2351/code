package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfp extends zzyc<zzfp>
{
  public String zzafi = null;
  public Long zzawm = null;
  private Integer zzawn = null;
  public zzfq[] zzawo = zzfq.zzmw();
  public zzfo[] zzawp = zzfo.zzmv();
  public zzfi[] zzawq = zzfi.zzmr();
  private String zzawr = null;
  private Boolean zzaws = null;

  public zzfp()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfp localzzfp;
    do
    {
      return true;
      if (!(paramObject instanceof zzfp))
        return false;
      localzzfp = (zzfp)paramObject;
      if (this.zzawm == null)
      {
        if (localzzfp.zzawm != null)
          return false;
      }
      else if (!this.zzawm.equals(localzzfp.zzawm))
        return false;
      if (this.zzafi == null)
      {
        if (localzzfp.zzafi != null)
          return false;
      }
      else if (!this.zzafi.equals(localzzfp.zzafi))
        return false;
      if (this.zzawn == null)
      {
        if (localzzfp.zzawn != null)
          return false;
      }
      else if (!this.zzawn.equals(localzzfp.zzawn))
        return false;
      if (!zzyg.equals(this.zzawo, localzzfp.zzawo))
        return false;
      if (!zzyg.equals(this.zzawp, localzzfp.zzawp))
        return false;
      if (!zzyg.equals(this.zzawq, localzzfp.zzawq))
        return false;
      if (this.zzawr == null)
      {
        if (localzzfp.zzawr != null)
          return false;
      }
      else if (!this.zzawr.equals(localzzfp.zzawr))
        return false;
      if (this.zzaws == null)
      {
        if (localzzfp.zzaws != null)
          return false;
      }
      else if (!this.zzaws.equals(localzzfp.zzaws))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfp.zzcev == null) || (localzzfp.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfp.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int i1;
    label63: int i3;
    label116: int i5;
    label136: int i6;
    int i7;
    if (this.zzawm == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.zzafi != null)
        break label194;
      m = 0;
      int n = 31 * (m + k);
      if (this.zzawn != null)
        break label206;
      i1 = 0;
      int i2 = 31 * (31 * (31 * (31 * (i1 + n) + zzyg.hashCode(this.zzawo)) + zzyg.hashCode(this.zzawp)) + zzyg.hashCode(this.zzawq));
      if (this.zzawr != null)
        break label218;
      i3 = 0;
      int i4 = 31 * (i3 + i2);
      if (this.zzaws != null)
        break label230;
      i5 = 0;
      i6 = 31 * (i5 + i4);
      zzye localzzye = this.zzcev;
      i7 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i7 = 0;
        if (!bool)
          break label242;
      }
    }
    while (true)
    {
      return i6 + i7;
      j = this.zzawm.hashCode();
      break;
      label194: m = this.zzafi.hashCode();
      break label44;
      label206: i1 = this.zzawn.hashCode();
      break label63;
      label218: i3 = this.zzawr.hashCode();
      break label116;
      label230: i5 = this.zzaws.hashCode();
      break label136;
      label242: i7 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzawm != null)
      paramzzya.zzi(1, this.zzawm.longValue());
    if (this.zzafi != null)
      paramzzya.zzb(2, this.zzafi);
    if (this.zzawn != null)
      paramzzya.zzd(3, this.zzawn.intValue());
    if ((this.zzawo != null) && (this.zzawo.length > 0))
      for (int m = 0; m < this.zzawo.length; m++)
      {
        zzfq localzzfq = this.zzawo[m];
        if (localzzfq != null)
          paramzzya.zza(4, localzzfq);
      }
    if ((this.zzawp != null) && (this.zzawp.length > 0))
      for (int k = 0; k < this.zzawp.length; k++)
      {
        zzfo localzzfo = this.zzawp[k];
        if (localzzfo != null)
          paramzzya.zza(5, localzzfo);
      }
    if (this.zzawq != null)
    {
      int i = this.zzawq.length;
      int j = 0;
      if (i > 0)
        while (j < this.zzawq.length)
        {
          zzfi localzzfi = this.zzawq[j];
          if (localzzfi != null)
            paramzzya.zza(6, localzzfi);
          j++;
        }
    }
    if (this.zzawr != null)
      paramzzya.zzb(7, this.zzawr);
    if (this.zzaws != null)
      paramzzya.zzb(8, this.zzaws.booleanValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzawm != null)
      i += zzya.zzd(1, this.zzawm.longValue());
    if (this.zzafi != null)
      i += zzya.zzc(2, this.zzafi);
    if (this.zzawn != null)
      i += zzya.zzh(3, this.zzawn.intValue());
    if ((this.zzawo != null) && (this.zzawo.length > 0))
    {
      int i1 = i;
      for (int i2 = 0; i2 < this.zzawo.length; i2++)
      {
        zzfq localzzfq = this.zzawo[i2];
        if (localzzfq != null)
          i1 += zzya.zzb(4, localzzfq);
      }
      i = i1;
    }
    if ((this.zzawp != null) && (this.zzawp.length > 0))
    {
      int m = i;
      for (int n = 0; n < this.zzawp.length; n++)
      {
        zzfo localzzfo = this.zzawp[n];
        if (localzzfo != null)
          m += zzya.zzb(5, localzzfo);
      }
      i = m;
    }
    if (this.zzawq != null)
    {
      int j = this.zzawq.length;
      int k = 0;
      if (j > 0)
        while (k < this.zzawq.length)
        {
          zzfi localzzfi = this.zzawq[k];
          if (localzzfi != null)
            i += zzya.zzb(6, localzzfi);
          k++;
        }
    }
    if (this.zzawr != null)
      i += zzya.zzc(7, this.zzawr);
    if (this.zzaws != null)
    {
      this.zzaws.booleanValue();
      i += 1 + zzya.zzbd(8);
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfp
 * JD-Core Version:    0.6.2
 */