package com.google.android.gms.internal.ads;

final class zzon
{
  public int index;
  public final int length;
  public long zzajx;
  public int zzbei;
  private final boolean zzbej;
  private final zzst zzbek;
  private final zzst zzbel;
  private int zzbem;
  private int zzben;

  public zzon(zzst paramzzst1, zzst paramzzst2, boolean paramBoolean)
  {
    this.zzbel = paramzzst1;
    this.zzbek = paramzzst2;
    this.zzbej = paramBoolean;
    paramzzst2.setPosition(12);
    this.length = paramzzst2.zzgg();
    paramzzst1.setPosition(12);
    this.zzben = paramzzst1.zzgg();
    if (paramzzst1.readInt() == i);
    while (true)
    {
      zzsk.checkState(i, "first_chunk must be 1");
      this.index = -1;
      return;
      int j = 0;
    }
  }

  public final boolean zzil()
  {
    int i = 1 + this.index;
    this.index = i;
    if (i == this.length)
      return false;
    long l;
    if (this.zzbej)
    {
      l = this.zzbek.zzgh();
      this.zzajx = l;
      if (this.index == this.zzbem)
      {
        this.zzbei = this.zzbel.zzgg();
        this.zzbel.zzac(4);
        int j = -1 + this.zzben;
        this.zzben = j;
        if (j <= 0)
          break label121;
      }
    }
    label121: for (int k = -1 + this.zzbel.zzgg(); ; k = -1)
    {
      this.zzbem = k;
      return true;
      l = this.zzbek.zzge();
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzon
 * JD-Core Version:    0.6.2
 */