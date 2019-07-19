package com.google.android.gms.internal.ads;

public abstract class zzhp
  implements zzgf
{
  private int state;

  final void disable()
    throws zzgd
  {
    if (this.state == 2);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      this.state = 1;
      zzdz();
      return;
    }
  }

  protected abstract long getDurationUs();

  protected final int getState()
  {
    return this.state;
  }

  protected abstract boolean isReady();

  protected void onStarted()
    throws zzgd
  {
  }

  protected void onStopped()
    throws zzgd
  {
  }

  final void release()
    throws zzgd
  {
    if ((this.state != 2) && (this.state != 3) && (this.state != -2));
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      this.state = -2;
      zzee();
      return;
    }
  }

  protected abstract void seekTo(long paramLong)
    throws zzgd;

  final void start()
    throws zzgd
  {
    if (this.state == 2);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      this.state = 3;
      onStarted();
      return;
    }
  }

  final void stop()
    throws zzgd
  {
    if (this.state == 3);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      this.state = 2;
      onStopped();
      return;
    }
  }

  public void zza(int paramInt, Object paramObject)
    throws zzgd
  {
  }

  protected abstract void zza(long paramLong1, long paramLong2)
    throws zzgd;

  protected void zzb(long paramLong, boolean paramBoolean)
    throws zzgd
  {
  }

  final void zzc(long paramLong, boolean paramBoolean)
    throws zzgd
  {
    int i = 1;
    if (this.state == i);
    while (true)
    {
      zzkh.checkState(i);
      this.state = 2;
      zzb(paramLong, paramBoolean);
      return;
      int j = 0;
    }
  }

  protected abstract int zzdl(long paramLong)
    throws zzgd;

  final int zzdm(long paramLong)
    throws zzgd
  {
    if (this.state == 0);
    for (boolean bool1 = true; ; bool1 = false)
    {
      zzkh.checkState(bool1);
      this.state = zzdl(paramLong);
      boolean bool2;
      if ((this.state != 0) && (this.state != 1))
      {
        int i = this.state;
        bool2 = false;
        if (i != -1);
      }
      else
      {
        bool2 = true;
      }
      zzkh.checkState(bool2);
      return this.state;
    }
  }

  protected abstract long zzdu();

  protected boolean zzdw()
  {
    return false;
  }

  protected abstract boolean zzdx();

  protected abstract long zzdy();

  protected void zzdz()
    throws zzgd
  {
  }

  protected void zzee()
    throws zzgd
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzhp
 * JD-Core Version:    0.6.2
 */