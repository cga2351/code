package com.google.android.gms.internal.measurement;

final class zztm
{
  private final byte[] buffer;
  private final zztv zzbty;

  private zztm(int paramInt)
  {
    this.buffer = new byte[paramInt];
    this.zzbty = zztv.zzj(this.buffer);
  }

  public final zzte zzuh()
  {
    if (this.zzbty.zzvj() != 0)
      throw new IllegalStateException("Did not write as much data as expected.");
    return new zzto(this.buffer);
  }

  public final zztv zzui()
  {
    return this.zzbty;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zztm
 * JD-Core Version:    0.6.2
 */