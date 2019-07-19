package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfn extends zzyc<zzfn>
{
  public Integer zzawe = null;
  public String zzawf = null;
  public Boolean zzawg = null;
  public String[] zzawh = zzyl.zzcfo;

  public zzfn()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  private final zzfn zzd(zzxz paramzzxz)
    throws IOException
  {
    while (true)
    {
      int i = paramzzxz.zzuj();
      switch (i)
      {
      default:
        if (super.zza(paramzzxz, i))
          continue;
      case 0:
        return this;
      case 8:
        int m = paramzzxz.getPosition();
        int n;
        try
        {
          n = paramzzxz.zzvb();
          if ((n < 0) || (n > 6))
            break label121;
          this.zzawe = Integer.valueOf(n);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          paramzzxz.zzcb(m);
          zza(paramzzxz, i);
        }
        continue;
        throw new IllegalArgumentException(41 + n + " is not a valid enum MatchType");
      case 18:
        this.zzawf = paramzzxz.readString();
        break;
      case 24:
        label121: this.zzawg = Boolean.valueOf(paramzzxz.zzup());
        break;
      case 34:
      }
      int j = zzyl.zzb(paramzzxz, 34);
      if (this.zzawh == null);
      String[] arrayOfString;
      for (int k = 0; ; k = this.zzawh.length)
      {
        arrayOfString = new String[j + k];
        if (k != 0)
          System.arraycopy(this.zzawh, 0, arrayOfString, 0, k);
        while (k < -1 + arrayOfString.length)
        {
          arrayOfString[k] = paramzzxz.readString();
          paramzzxz.zzuj();
          k++;
        }
      }
      arrayOfString[k] = paramzzxz.readString();
      this.zzawh = arrayOfString;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfn localzzfn;
    do
    {
      return true;
      if (!(paramObject instanceof zzfn))
        return false;
      localzzfn = (zzfn)paramObject;
      if (this.zzawe == null)
      {
        if (localzzfn.zzawe != null)
          return false;
      }
      else if (!this.zzawe.equals(localzzfn.zzawe))
        return false;
      if (this.zzawf == null)
      {
        if (localzzfn.zzawf != null)
          return false;
      }
      else if (!this.zzawf.equals(localzzfn.zzawf))
        return false;
      if (this.zzawg == null)
      {
        if (localzzfn.zzawg != null)
          return false;
      }
      else if (!this.zzawg.equals(localzzfn.zzawg))
        return false;
      if (!zzyg.equals(this.zzawh, localzzfn.zzawh))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfn.zzcev == null) || (localzzfn.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfn.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int i1;
    label63: int i2;
    int i3;
    if (this.zzawe == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.zzawf != null)
        break label132;
      m = 0;
      int n = 31 * (m + k);
      if (this.zzawg != null)
        break label144;
      i1 = 0;
      i2 = 31 * (31 * (i1 + n) + zzyg.hashCode(this.zzawh));
      zzye localzzye = this.zzcev;
      i3 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i3 = 0;
        if (!bool)
          break label156;
      }
    }
    while (true)
    {
      return i2 + i3;
      j = this.zzawe.intValue();
      break;
      label132: m = this.zzawf.hashCode();
      break label44;
      label144: i1 = this.zzawg.hashCode();
      break label63;
      label156: i3 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzawe != null)
      paramzzya.zzd(1, this.zzawe.intValue());
    if (this.zzawf != null)
      paramzzya.zzb(2, this.zzawf);
    if (this.zzawg != null)
      paramzzya.zzb(3, this.zzawg.booleanValue());
    if ((this.zzawh != null) && (this.zzawh.length > 0))
      for (int i = 0; i < this.zzawh.length; i++)
      {
        String str = this.zzawh[i];
        if (str != null)
          paramzzya.zzb(4, str);
      }
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = 0;
    int j = super.zzf();
    if (this.zzawe != null)
      j += zzya.zzh(1, this.zzawe.intValue());
    if (this.zzawf != null)
      j += zzya.zzc(2, this.zzawf);
    if (this.zzawg != null)
    {
      this.zzawg.booleanValue();
      j += 1 + zzya.zzbd(3);
    }
    if ((this.zzawh != null) && (this.zzawh.length > 0))
    {
      int k = 0;
      int m = 0;
      while (i < this.zzawh.length)
      {
        String str = this.zzawh[i];
        if (str != null)
        {
          m++;
          k += zzya.zzgc(str);
        }
        i++;
      }
      j = j + k + m * 1;
    }
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfn
 * JD-Core Version:    0.6.2
 */