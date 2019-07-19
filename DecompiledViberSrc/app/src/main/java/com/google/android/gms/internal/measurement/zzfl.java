package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfl extends zzyc<zzfl>
{
  public Integer zzavw = null;
  public Boolean zzavx = null;
  public String zzavy = null;
  public String zzavz = null;
  public String zzawa = null;

  public zzfl()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  private final zzfl zzc(zzxz paramzzxz)
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
        int j = paramzzxz.getPosition();
        int k;
        try
        {
          k = paramzzxz.zzvb();
          if ((k < 0) || (k > 4))
            break label126;
          this.zzavw = Integer.valueOf(k);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          paramzzxz.zzcb(j);
          zza(paramzzxz, i);
        }
        continue;
        throw new IllegalArgumentException(46 + k + " is not a valid enum ComparisonType");
      case 16:
        this.zzavx = Boolean.valueOf(paramzzxz.zzup());
        break;
      case 26:
        this.zzavy = paramzzxz.readString();
        break;
      case 34:
        label126: this.zzavz = paramzzxz.readString();
        break;
      case 42:
      }
      this.zzawa = paramzzxz.readString();
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfl localzzfl;
    do
    {
      return true;
      if (!(paramObject instanceof zzfl))
        return false;
      localzzfl = (zzfl)paramObject;
      if (this.zzavw == null)
      {
        if (localzzfl.zzavw != null)
          return false;
      }
      else if (!this.zzavw.equals(localzzfl.zzavw))
        return false;
      if (this.zzavx == null)
      {
        if (localzzfl.zzavx != null)
          return false;
      }
      else if (!this.zzavx.equals(localzzfl.zzavx))
        return false;
      if (this.zzavy == null)
      {
        if (localzzfl.zzavy != null)
          return false;
      }
      else if (!this.zzavy.equals(localzzfl.zzavy))
        return false;
      if (this.zzavz == null)
      {
        if (localzzfl.zzavz != null)
          return false;
      }
      else if (!this.zzavz.equals(localzzfl.zzavz))
        return false;
      if (this.zzawa == null)
      {
        if (localzzfl.zzawa != null)
          return false;
      }
      else if (!this.zzawa.equals(localzzfl.zzawa))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfl.zzcev == null) || (localzzfl.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfl.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int i1;
    label63: int i3;
    label83: int i5;
    label103: int i6;
    int i7;
    if (this.zzavw == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.zzavx != null)
        break label161;
      m = 0;
      int n = 31 * (m + k);
      if (this.zzavy != null)
        break label173;
      i1 = 0;
      int i2 = 31 * (i1 + n);
      if (this.zzavz != null)
        break label185;
      i3 = 0;
      int i4 = 31 * (i3 + i2);
      if (this.zzawa != null)
        break label197;
      i5 = 0;
      i6 = 31 * (i5 + i4);
      zzye localzzye = this.zzcev;
      i7 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i7 = 0;
        if (!bool)
          break label209;
      }
    }
    while (true)
    {
      return i6 + i7;
      j = this.zzavw.intValue();
      break;
      label161: m = this.zzavx.hashCode();
      break label44;
      label173: i1 = this.zzavy.hashCode();
      break label63;
      label185: i3 = this.zzavz.hashCode();
      break label83;
      label197: i5 = this.zzawa.hashCode();
      break label103;
      label209: i7 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzavw != null)
      paramzzya.zzd(1, this.zzavw.intValue());
    if (this.zzavx != null)
      paramzzya.zzb(2, this.zzavx.booleanValue());
    if (this.zzavy != null)
      paramzzya.zzb(3, this.zzavy);
    if (this.zzavz != null)
      paramzzya.zzb(4, this.zzavz);
    if (this.zzawa != null)
      paramzzya.zzb(5, this.zzawa);
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzavw != null)
      i += zzya.zzh(1, this.zzavw.intValue());
    if (this.zzavx != null)
    {
      this.zzavx.booleanValue();
      i += 1 + zzya.zzbd(2);
    }
    if (this.zzavy != null)
      i += zzya.zzc(3, this.zzavy);
    if (this.zzavz != null)
      i += zzya.zzc(4, this.zzavz);
    if (this.zzawa != null)
      i += zzya.zzc(5, this.zzawa);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfl
 * JD-Core Version:    0.6.2
 */