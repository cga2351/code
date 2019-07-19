package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzbha;

@zzare
@VisibleForTesting
public final class zzj
{
  public final int index;
  public final ViewGroup parent;
  public final ViewGroup.LayoutParams zzdkj;
  public final Context zzlj;

  public zzj(zzbha paramzzbha)
    throws zzh
  {
    this.zzdkj = paramzzbha.getLayoutParams();
    ViewParent localViewParent = paramzzbha.getParent();
    this.zzlj = paramzzbha.zzaad();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      this.parent = ((ViewGroup)localViewParent);
      this.index = this.parent.indexOfChild(paramzzbha.getView());
      this.parent.removeView(paramzzbha.getView());
      paramzzbha.zzaq(true);
      return;
    }
    throw new zzh("Could not get the parent of the WebView for an overlay.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzj
 * JD-Core Version:    0.6.2
 */