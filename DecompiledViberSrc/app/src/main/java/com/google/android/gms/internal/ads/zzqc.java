package com.google.android.gms.internal.ads;

import android.util.SparseArray;

final class zzqc
  implements Runnable
{
  zzqc(zzpz paramzzpz, zzqf paramzzqf)
  {
  }

  public final void run()
  {
    this.zzbit.release();
    int i = zzpz.zzd(this.zzbis).size();
    for (int j = 0; j < i; j++)
      ((zzqt)zzpz.zzd(this.zzbis).valueAt(j)).disable();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzqc
 * JD-Core Version:    0.6.2
 */