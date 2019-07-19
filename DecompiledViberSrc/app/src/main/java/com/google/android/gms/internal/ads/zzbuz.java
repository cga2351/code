package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

public final class zzbuz extends zzbtr<zzuc>
  implements zzuc
{
  private final zzcxl zzfif;

  @GuardedBy("this")
  private Map<View, zzty> zzfld = new WeakHashMap(1);
  private final Context zzlj;

  public zzbuz(Context paramContext, Set<zzbuy<zzuc>> paramSet, zzcxl paramzzcxl)
  {
    super(paramSet);
    this.zzlj = paramContext;
    this.zzfif = paramzzcxl;
  }

  public final void zza(zzub paramzzub)
  {
    try
    {
      zza(new zzbva(paramzzub));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzq(View paramView)
  {
    while (true)
    {
      zzty localzzty1;
      try
      {
        localzzty1 = (zzty)this.zzfld.get(paramView);
        if (localzzty1 == null)
        {
          zzty localzzty2 = new zzty(this.zzlj, paramView);
          localzzty2.zza(this);
          this.zzfld.put(paramView, localzzty2);
          localzzty3 = localzzty2;
          if ((this.zzfif != null) && (this.zzfif.zzdon))
          {
            zzaci localzzaci1 = zzact.zzcql;
            if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
            {
              zzaci localzzaci2 = zzact.zzcqk;
              localzzty3.zzes(((Long)zzyr.zzpe().zzd(localzzaci2)).longValue());
              return;
            }
          }
          localzzty3.zzmk();
          continue;
        }
      }
      finally
      {
      }
      zzty localzzty3 = localzzty1;
    }
  }

  public final void zzr(View paramView)
  {
    try
    {
      if (this.zzfld.containsKey(paramView))
      {
        ((zzty)this.zzfld.get(paramView)).zzb(this);
        this.zzfld.remove(paramView);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbuz
 * JD-Core Version:    0.6.2
 */