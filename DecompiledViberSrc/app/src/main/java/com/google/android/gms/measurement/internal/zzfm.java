package com.google.android.gms.measurement.internal;

abstract class zzfm extends zzfl
{
  private boolean zzvz;

  zzfm(zzfn paramzzfn)
  {
    super(paramzzfn);
    this.zzamx.zzb(this);
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

  protected abstract boolean zzgy();

  public final void zzq()
  {
    if (this.zzvz)
      throw new IllegalStateException("Can't initialize twice");
    zzgy();
    this.zzamx.zzmg();
    this.zzvz = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzfm
 * JD-Core Version:    0.6.2
 */