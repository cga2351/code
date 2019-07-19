package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

@zzare
public class zzyf
{
  private final zzxv zzchm;
  private final zzxu zzchn;
  private final zzabj zzcho;
  private final zzagj zzchp;
  private final zzatg zzchq;
  private final zzauk zzchr;
  private final zzaqg zzchs;
  private final zzagk zzcht;

  public zzyf(zzxv paramzzxv, zzxu paramzzxu, zzabj paramzzabj, zzagj paramzzagj, zzatg paramzzatg, zzauk paramzzauk, zzaqg paramzzaqg, zzagk paramzzagk)
  {
    this.zzchm = paramzzxv;
    this.zzchn = paramzzxu;
    this.zzcho = paramzzabj;
    this.zzchp = paramzzagj;
    this.zzchq = paramzzatg;
    this.zzchr = paramzzauk;
    this.zzchs = paramzzaqg;
    this.zzcht = paramzzagk;
  }

  private static void zza(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "no_ads_fallback");
    localBundle.putString("flow", paramString);
    zzyr.zzpa().zza(paramContext, zzyr.zzpg().zzbsy, "gmob-apps", localBundle, true);
  }

  public final zzael zza(Context paramContext, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    return (zzael)new zzym(this, paramFrameLayout1, paramFrameLayout2, paramContext).zzd(paramContext, false);
  }

  public final zzaeq zza(View paramView, HashMap<String, View> paramHashMap1, HashMap<String, View> paramHashMap2)
  {
    return (zzaeq)new zzyn(this, paramView, paramHashMap1, paramHashMap2).zzd(paramView.getContext(), false);
  }

  public final zzaqh zzb(Activity paramActivity)
  {
    boolean bool = false;
    zzyh localzzyh = new zzyh(this, paramActivity);
    Intent localIntent = paramActivity.getIntent();
    if (!localIntent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar"))
      zzbae.zzen("useClientJar flag not found in activity intent extras.");
    while (true)
    {
      return (zzaqh)localzzyh.zzd(paramActivity, bool);
      bool = localIntent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
    }
  }

  public final zzzd zzb(Context paramContext, String paramString, zzamq paramzzamq)
  {
    return (zzzd)new zzyk(this, paramContext, paramString, paramzzamq).zzd(paramContext, false);
  }

  public final zzatu zzc(Context paramContext, String paramString, zzamq paramzzamq)
  {
    return (zzatu)new zzyp(this, paramContext, paramString, paramzzamq).zzd(paramContext, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzyf
 * JD-Core Version:    0.6.2
 */