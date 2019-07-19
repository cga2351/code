package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

@zzare
public final class zzazj extends zzaww
{
  private final String url;
  private final zzbai zzdxy;

  public zzazj(Context paramContext, String paramString1, String paramString2)
  {
    this(paramString2, zzk.zzlg().zzq(paramContext, paramString1));
  }

  private zzazj(String paramString1, String paramString2)
  {
    this.zzdxy = new zzbai(paramString2);
    this.url = paramString1;
  }

  public final void zzto()
  {
    this.zzdxy.zzed(this.url);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazj
 * JD-Core Version:    0.6.2
 */