package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;

@TargetApi(24)
public class zzaxx extends zzaxw
{
  private static boolean zze(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.abs(paramInt1 - paramInt2) <= paramInt3;
  }

  public final boolean zza(Activity paramActivity, Configuration paramConfiguration)
  {
    zzaci localzzaci1 = zzact.zzcui;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
      return false;
    zzaci localzzaci2 = zzact.zzcuk;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
      return paramActivity.isInMultiWindowMode();
    zzyr.zzpa();
    int i = zzazu.zza(paramActivity, paramConfiguration.screenHeightDp);
    int j = zzazu.zza(paramActivity, paramConfiguration.screenWidthDp);
    WindowManager localWindowManager = (WindowManager)paramActivity.getApplicationContext().getSystemService("window");
    zzk.zzlg();
    DisplayMetrics localDisplayMetrics = zzaxj.zza(localWindowManager);
    int k = localDisplayMetrics.heightPixels;
    int m = localDisplayMetrics.widthPixels;
    int n = paramActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (n > 0);
    for (int i1 = paramActivity.getResources().getDimensionPixelSize(n); ; i1 = 0)
    {
      int i2 = (int)Math.round(0.5D + paramActivity.getResources().getDisplayMetrics().density);
      zzaci localzzaci3 = zzact.zzcuh;
      int i3 = i2 * ((Integer)zzyr.zzpe().zzd(localzzaci3)).intValue();
      if ((zze(k, i1 + i, i3)) && (zze(m, j, i3)));
      for (int i4 = 1; i4 == 0; i4 = 0)
        return true;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxx
 * JD-Core Version:    0.6.2
 */