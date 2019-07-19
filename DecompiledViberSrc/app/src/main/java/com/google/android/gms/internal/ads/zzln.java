package com.google.android.gms.internal.ads;

public final class zzln
{
  public static final zzln zzaug = new zzln(1.0F, 1.0F);
  public final float zzauh;
  public final float zzaui;
  private final int zzauj;

  public zzln(float paramFloat1, float paramFloat2)
  {
    this.zzauh = paramFloat1;
    this.zzaui = paramFloat2;
    this.zzauj = Math.round(1000.0F * paramFloat1);
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzln localzzln;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzln = (zzln)paramObject;
    }
    while ((this.zzauh == localzzln.zzauh) && (this.zzaui == localzzln.zzaui));
    return false;
  }

  public final int hashCode()
  {
    return 31 * (527 + Float.floatToRawIntBits(this.zzauh)) + Float.floatToRawIntBits(this.zzaui);
  }

  public final long zzef(long paramLong)
  {
    return paramLong * this.zzauj;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzln
 * JD-Core Version:    0.6.2
 */