package com.google.android.exoplayer2.source.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.g.ad;

public final class p
{
  private final SparseArray<ad> a = new SparseArray();

  public ad a(int paramInt)
  {
    ad localad = (ad)this.a.get(paramInt);
    if (localad == null)
    {
      localad = new ad(9223372036854775807L);
      this.a.put(paramInt, localad);
    }
    return localad;
  }

  public void a()
  {
    this.a.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.p
 * JD-Core Version:    0.6.2
 */