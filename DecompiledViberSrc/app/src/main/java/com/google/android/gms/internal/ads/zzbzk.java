package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class zzbzk
{
  private final zzadx zzdgu;
  private final zzaxc zzdum;
  private final Executor zzffu;
  private final Executor zzfiv;
  private final zzcxu zzfjp;
  private final zzbys zzfmq;
  private final zzbyw zzfnq;

  @Nullable
  private final zzbzs zzfps;
  private final Context zzlj;

  public zzbzk(Context paramContext, zzaxc paramzzaxc, zzcxu paramzzcxu, zzbyw paramzzbyw, zzbys paramzzbys, @Nullable zzbzs paramzzbzs, Executor paramExecutor1, Executor paramExecutor2)
  {
    this.zzlj = paramContext;
    this.zzdum = paramzzaxc;
    this.zzfjp = paramzzcxu;
    this.zzdgu = paramzzcxu.zzdgu;
    this.zzfnq = paramzzbyw;
    this.zzfmq = paramzzbys;
    this.zzfps = paramzzbzs;
    this.zzffu = paramExecutor1;
    this.zzfiv = paramExecutor2;
  }

  private static void zza(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    default:
      paramLayoutParams.addRule(10);
      paramLayoutParams.addRule(11);
      return;
    case 0:
      paramLayoutParams.addRule(10);
      paramLayoutParams.addRule(9);
      return;
    case 3:
      paramLayoutParams.addRule(12);
      paramLayoutParams.addRule(9);
      return;
    case 2:
    }
    paramLayoutParams.addRule(12);
    paramLayoutParams.addRule(11);
  }

  private static boolean zza(zzcaa paramzzcaa, String[] paramArrayOfString)
  {
    Map localMap = paramzzcaa.zzaiu();
    if (localMap == null);
    while (true)
    {
      return false;
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
        if (localMap.get(paramArrayOfString[j]) != null)
          return true;
    }
  }

  public final boolean zza(@Nonnull ViewGroup paramViewGroup)
  {
    View localView = this.zzfmq.zzahy();
    if (localView == null)
      return false;
    paramViewGroup.removeAllViews();
    if ((localView.getParent() instanceof ViewGroup))
      ((ViewGroup)localView.getParent()).removeView(localView);
    zzaci localzzaci = zzact.zzcsl;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 17); ; localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17))
    {
      paramViewGroup.addView(localView, localLayoutParams);
      return true;
    }
  }

  public final void zzc(zzcaa paramzzcaa)
  {
    this.zzffu.execute(new zzbzl(this, paramzzcaa));
  }

  public final void zzd(@Nullable zzcaa paramzzcaa)
  {
    if ((paramzzcaa == null) || (this.zzfps == null) || (paramzzcaa.zzair() == null))
      return;
    try
    {
      paramzzcaa.zzair().addView(this.zzfps.zzajb());
      return;
    }
    catch (zzbhk localzzbhk)
    {
      zzaxa.zza("web view can not be obtained", localzzbhk);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbzk
 * JD-Core Version:    0.6.2
 */