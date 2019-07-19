package com.google.android.gms.measurement.internal;

abstract class zzf extends zze
{
  private boolean zzvz;

  zzf(zzbw paramzzbw)
  {
    super(paramzzbw);
    this.zzada.zzb(this);
  }

  final boolean isInitialized()
  {
    return this.zzvz;
  }

  protected final void zzcl()
  {
    if (!isInitialized())
      throw new IllegalStateException("Not initialized");
  }

  public final void zzgx()
  {
    if (this.zzvz)
      throw new IllegalStateException("Can't initialize twice");
    zzgz();
    this.zzada.zzku();
    this.zzvz = true;
  }

  protected abstract boolean zzgy();

  protected void zzgz()
  {
  }

  public final void zzq()
  {
    if (this.zzvz)
      throw new IllegalStateException("Can't initialize twice");
    if (!zzgy())
    {
      this.zzada.zzku();
      this.zzvz = true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzf
 * JD-Core Version:    0.6.2
 */