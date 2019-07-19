package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.Nullable;

@TargetApi(19)
public final class zzcec
{

  @Nullable
  private PopupWindow zzftr;

  @Nullable
  private Context zzlj;

  private static PopupWindow zzb(Context paramContext, View paramView)
  {
    if ((paramContext instanceof Activity));
    for (Window localWindow = ((Activity)paramContext).getWindow(); ; localWindow = null)
    {
      if ((localWindow == null) || (localWindow.getDecorView() == null))
        return null;
      if (((Activity)paramContext).isDestroyed())
        return null;
      FrameLayout localFrameLayout = new FrameLayout(paramContext);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localFrameLayout.addView(paramView, -1, -1);
      PopupWindow localPopupWindow = new PopupWindow(localFrameLayout, 1, 1, false);
      localPopupWindow.setOutsideTouchable(true);
      localPopupWindow.setClippingEnabled(false);
      zzaxa.zzdp("Displaying the 1x1 popup off the screen.");
      try
      {
        localPopupWindow.showAtLocation(localWindow.getDecorView(), 0, -1, -1);
        return localPopupWindow;
      }
      catch (Exception localException)
      {
        return null;
      }
    }
  }

  public final void zza(Context paramContext, View paramView)
  {
    if ((!PlatformVersion.isAtLeastKitKat()) || (PlatformVersion.isAtLeastLollipop()))
      return;
    this.zzftr = zzb(paramContext, paramView);
    if (this.zzftr != null);
    while (true)
    {
      this.zzlj = paramContext;
      return;
      paramContext = null;
    }
  }

  public final void zzajo()
  {
    if ((this.zzlj == null) || (this.zzftr == null))
      return;
    if (((this.zzlj instanceof Activity)) && (((Activity)this.zzlj).isDestroyed()))
    {
      this.zzlj = null;
      this.zzftr = null;
      return;
    }
    if (this.zzftr.isShowing())
      this.zzftr.dismiss();
    this.zzlj = null;
    this.zzftr = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcec
 * JD-Core Version:    0.6.2
 */