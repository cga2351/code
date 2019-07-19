package com.google.android.gms.internal.ads;

public class zzaf extends Exception
{
  private long zzad;
  private final zzp zzbk;

  public zzaf()
  {
    this.zzbk = null;
  }

  public zzaf(zzp paramzzp)
  {
    this.zzbk = paramzzp;
  }

  public zzaf(String paramString)
  {
    super(paramString);
    this.zzbk = null;
  }

  public zzaf(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.zzbk = null;
  }

  final void zza(long paramLong)
  {
    this.zzad = paramLong;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaf
 * JD-Core Version:    0.6.2
 */