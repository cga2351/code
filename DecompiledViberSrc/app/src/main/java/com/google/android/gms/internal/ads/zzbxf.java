package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzbxf
  implements zzbrk, zzbuq
{
  private final View view;
  private final zzavh zzbsr;
  private final zzavg zzfin;
  private final int zzflt;
  private String zzflx;
  private final Context zzlj;

  public zzbxf(zzavg paramzzavg, Context paramContext, zzavh paramzzavh, View paramView, int paramInt)
  {
    this.zzfin = paramzzavg;
    this.zzlj = paramContext;
    this.zzbsr = paramzzavh;
    this.view = paramView;
    this.zzflt = paramInt;
  }

  public final void onAdClosed()
  {
    this.zzfin.zzag(false);
  }

  public final void onAdLeftApplication()
  {
  }

  public final void onAdOpened()
  {
    if ((this.view != null) && (this.zzflx != null))
      this.zzbsr.zzf(this.view.getContext(), this.zzflx);
    this.zzfin.zzag(true);
  }

  public final void onRewardedVideoCompleted()
  {
  }

  public final void onRewardedVideoStarted()
  {
  }

  public final void zzagu()
  {
    this.zzflx = this.zzbsr.zzz(this.zzlj);
    String str1 = String.valueOf(this.zzflx);
    String str2;
    String str3;
    if (this.zzflt == 7)
    {
      str2 = "/Rewarded";
      str3 = String.valueOf(str2);
      if (str3.length() == 0)
        break label67;
    }
    label67: for (String str4 = str1.concat(str3); ; str4 = new String(str1))
    {
      this.zzflx = str4;
      return;
      str2 = "/Interstitial";
      break;
    }
  }

  @ParametersAreNonnullByDefault
  public final void zzb(zzass paramzzass, String paramString1, String paramString2)
  {
    if (this.zzbsr.zzx(this.zzlj));
    try
    {
      this.zzbsr.zza(this.zzlj, this.zzbsr.zzac(this.zzlj), this.zzfin.getAdUnitId(), paramzzass.getType(), paramzzass.getAmount());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Remote Exception to get reward item.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbxf
 * JD-Core Version:    0.6.2
 */