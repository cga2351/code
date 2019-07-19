package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(18)
public class zzaxt extends zzaxs
{
  public boolean isAttachedToWindow(View paramView)
  {
    return (super.isAttachedToWindow(paramView)) || (paramView.getWindowId() != null);
  }

  public final int zzwf()
  {
    return 14;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxt
 * JD-Core Version:    0.6.2
 */