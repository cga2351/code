package com.google.android.gms.internal.ads;

final class zzor
  implements zzoo
{
  private int zzamy;
  private final int zzand;
  private final zzst zzbea;
  private final int zzber;
  private int zzbes;

  public zzor(zzol paramzzol)
  {
    this.zzbea = paramzzol.zzbea;
    this.zzbea.setPosition(12);
    this.zzber = (0xFF & this.zzbea.zzgg());
    this.zzand = this.zzbea.zzgg();
  }

  public final int zzim()
  {
    return this.zzand;
  }

  public final int zzin()
  {
    if (this.zzber == 8)
      return this.zzbea.readUnsignedByte();
    if (this.zzber == 16)
      return this.zzbea.readUnsignedShort();
    int i = this.zzamy;
    this.zzamy = (i + 1);
    if (i % 2 == 0)
    {
      this.zzbes = this.zzbea.readUnsignedByte();
      return (0xF0 & this.zzbes) >> 4;
    }
    return 0xF & this.zzbes;
  }

  public final boolean zzio()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzor
 * JD-Core Version:    0.6.2
 */