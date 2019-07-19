package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.google.android.gms.ads.internal.zzk;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@TargetApi(28)
public final class zzaxz extends zzaxy
{
  private static void zza(boolean paramBoolean, Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    int i = localLayoutParams.layoutInDisplayCutoutMode;
    if (paramBoolean);
    for (int j = 1; ; j = 2)
    {
      if (j != i)
      {
        localLayoutParams.layoutInDisplayCutoutMode = j;
        localWindow.setAttributes(localLayoutParams);
      }
      return;
    }
  }

  public final void zzg(Activity paramActivity)
  {
    zzaci localzzaci = zzact.zzcpi;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (zzk.zzlk().zzvc().zzvx() == null) && (!paramActivity.isInMultiWindowMode()))
    {
      zza(true, paramActivity);
      paramActivity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new zzaya(this, paramActivity));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxz
 * JD-Core Version:    0.6.2
 */