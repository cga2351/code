package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzbzp
  implements View.OnClickListener
{
  private final Clock zzbsb;
  private final zzcci zzfpz;
  private zzagc zzfqa;
  private zzahn zzfqb;
  String zzfqc;
  Long zzfqd;
  WeakReference<View> zzfqe;

  public zzbzp(zzcci paramzzcci, Clock paramClock)
  {
    this.zzfpz = paramzzcci;
    this.zzbsb = paramClock;
  }

  private final void zzaja()
  {
    this.zzfqc = null;
    this.zzfqd = null;
    if (this.zzfqe == null);
    View localView;
    do
    {
      return;
      localView = (View)this.zzfqe.get();
    }
    while (localView == null);
    localView.setClickable(false);
    localView.setOnClickListener(null);
    this.zzfqe = null;
  }

  public final void cancelUnconfirmedClick()
  {
    if (this.zzfqa == null);
    while (this.zzfqd == null)
      return;
    zzaja();
    try
    {
      this.zzfqa.onUnconfirmedClickCancelled();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void onClick(View paramView)
  {
    if ((this.zzfqe == null) || (this.zzfqe.get() != paramView))
      return;
    if ((this.zzfqc == null) || (this.zzfqd == null));
    while (true)
    {
      zzaja();
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("id", this.zzfqc);
      localHashMap.put("time_interval", String.valueOf(this.zzbsb.currentTimeMillis() - this.zzfqd.longValue()));
      localHashMap.put("messageType", "onePointFiveClick");
      this.zzfpz.zza("sendMessageToNativeJs", localHashMap);
    }
  }

  public final void zza(zzagc paramzzagc)
  {
    this.zzfqa = paramzzagc;
    if (this.zzfqb != null)
      this.zzfpz.zzb("/unconfirmedClick", this.zzfqb);
    this.zzfqb = new zzbzq(this, paramzzagc);
    this.zzfpz.zza("/unconfirmedClick", this.zzfqb);
  }

  public final zzagc zzaiz()
  {
    return this.zzfqa;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbzp
 * JD-Core Version:    0.6.2
 */