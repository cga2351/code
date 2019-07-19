package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzde extends zzdf
{
  private static final String TAG = zzde.class.getSimpleName();
  private AdvertisingIdClient.Info zzwc;

  private zzde(Context paramContext)
  {
    super(paramContext, "");
  }

  public static String zza(String paramString1, String paramString2)
  {
    return zzci.zza(paramString1, paramString2, true);
  }

  public static zzde zzb(Context paramContext)
  {
    zza(paramContext, true);
    return new zzde(paramContext);
  }

  protected final zzbp.zza.zza zza(Context paramContext, View paramView, Activity paramActivity)
  {
    return null;
  }

  public final void zza(AdvertisingIdClient.Info paramInfo)
  {
    this.zzwc = paramInfo;
  }

  protected final void zza(zzdy paramzzdy, Context paramContext, zzbp.zza.zza paramzza, zzbk.zza paramzza1)
  {
    if (paramzzdy.zzxp)
    {
      if (this.zzwc != null)
      {
        String str = this.zzwc.getId();
        if (!TextUtils.isEmpty(str))
        {
          paramzza.zzaf(zzef.zzap(str));
          paramzza.zzb(zzbp.zza.zzc.zzhu);
          paramzza.zzb(this.zzwc.isLimitAdTrackingEnabled());
        }
        this.zzwc = null;
      }
      return;
    }
    zza(zzb(paramzzdy, paramContext, paramzza, paramzza1));
  }

  protected final List<Callable<Void>> zzb(zzdy paramzzdy, Context paramContext, zzbp.zza.zza paramzza, zzbk.zza paramzza1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramzzdy.zzch() == null)
      return localArrayList;
    localArrayList.add(new zzes(paramzzdy, "3pegtvj7nkb7e3rwh5b+3dnQATJj6aqtaosJ3DkOYPzNGN2w+CoarbJEsY1UQgeA", "/kRTFQbKQx44ublaFMNQ8yNL6QxOrgEofiWDpZSH6zA=", paramzza, paramzzdy.zzcd(), 24));
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzde
 * JD-Core Version:    0.6.2
 */