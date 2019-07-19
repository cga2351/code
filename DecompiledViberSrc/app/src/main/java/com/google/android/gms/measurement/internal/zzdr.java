package com.google.android.gms.measurement.internal;

final class zzdr
  implements Runnable
{
  zzdr(zzda paramzzda, boolean paramBoolean)
  {
  }

  public final void run()
  {
    boolean bool1 = this.zzarh.zzada.isEnabled();
    boolean bool2 = this.zzarh.zzada.zzks();
    this.zzarh.zzada.zzd(this.zzaed);
    if (bool2 == this.zzaed)
      this.zzarh.zzada.zzgt().zzjo().zzg("Default data collection state already set to", Boolean.valueOf(this.zzaed));
    if ((this.zzarh.zzada.isEnabled() == bool1) || (this.zzarh.zzada.isEnabled() != this.zzarh.zzada.zzks()))
      this.zzarh.zzada.zzgt().zzjl().zze("Default data collection is different than actual status", Boolean.valueOf(this.zzaed), Boolean.valueOf(bool1));
    zzda.zza(this.zzarh);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzdr
 * JD-Core Version:    0.6.2
 */