package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfv extends zzyc<zzfv>
{
  public zzfw[] zzaxh = zzfw.zznb();

  public zzfv()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfv localzzfv;
    do
    {
      return true;
      if (!(paramObject instanceof zzfv))
        return false;
      localzzfv = (zzfv)paramObject;
      if (!zzyg.equals(this.zzaxh, localzzfv.zzaxh))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfv.zzcev == null) || (localzzfv.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfv.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (527 + getClass().getName().hashCode()) + zzyg.hashCode(this.zzaxh));
    if ((this.zzcev == null) || (this.zzcev.isEmpty()));
    for (int j = 0; ; j = this.zzcev.hashCode())
      return j + i;
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if ((this.zzaxh != null) && (this.zzaxh.length > 0))
      for (int i = 0; i < this.zzaxh.length; i++)
      {
        zzfw localzzfw = this.zzaxh[i];
        if (localzzfw != null)
          paramzzya.zza(1, localzzfw);
      }
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if ((this.zzaxh != null) && (this.zzaxh.length > 0))
      for (int j = 0; j < this.zzaxh.length; j++)
      {
        zzfw localzzfw = this.zzaxh[j];
        if (localzzfw != null)
          i += zzya.zzb(1, localzzfw);
      }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfv
 * JD-Core Version:    0.6.2
 */