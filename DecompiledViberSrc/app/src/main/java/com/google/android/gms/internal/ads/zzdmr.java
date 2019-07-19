package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzdmr extends zzdmt
{
  private final int limit = this.zzhcu.size();
  private int position = 0;

  zzdmr(zzdmq paramzzdmq)
  {
  }

  public final boolean hasNext()
  {
    return this.position < this.limit;
  }

  public final byte nextByte()
  {
    int i = this.position;
    if (i >= this.limit)
      throw new NoSuchElementException();
    this.position = (i + 1);
    return this.zzhcu.zzfn(i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmr
 * JD-Core Version:    0.6.2
 */