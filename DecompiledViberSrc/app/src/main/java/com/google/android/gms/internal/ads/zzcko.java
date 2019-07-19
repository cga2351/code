package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzcko extends zzaol
{
  private zzcjx<zzaow, zzckz> zzfzw;

  private zzcko(zzckl paramzzckl, zzcjx paramzzcjx)
  {
    this.zzfzw = paramzzcjx;
  }

  public final void zzdb(String paramString)
    throws RemoteException
  {
    ((zzckz)this.zzfzw.zzfzn).onAdFailedToLoad(0);
  }

  public final void zzw(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    zzckl.zza(this.zzfzx, (View)ObjectWrapper.unwrap(paramIObjectWrapper));
    ((zzckz)this.zzfzw.zzfzn).onAdLoaded();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcko
 * JD-Core Version:    0.6.2
 */