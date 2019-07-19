package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

public final class zzcyh
  implements zzawt, zzbrn
{
  private final zzawv zzdsy;

  @GuardedBy("this")
  private final HashSet<zzawk> zzglq = new HashSet();
  private final Context zzlj;

  public zzcyh(Context paramContext, zzawv paramzzawv)
  {
    this.zzlj = paramContext;
    this.zzdsy = paramzzawv;
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    if (paramInt != 3);
    try
    {
      this.zzdsy.zzb(this.zzglq);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(HashSet<zzawk> paramHashSet)
  {
    try
    {
      this.zzglq.clear();
      this.zzglq.addAll(paramHashSet);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final Bundle zzams()
  {
    return this.zzdsy.zza(this.zzlj, this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcyh
 * JD-Core Version:    0.6.2
 */