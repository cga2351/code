package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzcbv extends zzajc
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzadu
{
  private boolean zzela;
  private zzaap zzfoh;
  private View zzfom;
  private zzbym zzfpj;
  private boolean zzfsb;

  public zzcbv(zzbym paramzzbym, zzbys paramzzbys)
  {
    this.zzfom = paramzzbys.zzahy();
    this.zzfoh = paramzzbys.getVideoController();
    this.zzfpj = paramzzbym;
    this.zzela = false;
    this.zzfsb = false;
    if (paramzzbys.zzahz() != null)
      paramzzbys.zzahz().zza(this);
  }

  private static void zza(zzajd paramzzajd, int paramInt)
  {
    try
    {
      paramzzajd.zzcq(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  private final void zzajf()
  {
    if (this.zzfom == null);
    ViewParent localViewParent;
    do
    {
      return;
      localViewParent = this.zzfom.getParent();
    }
    while (!(localViewParent instanceof ViewGroup));
    ((ViewGroup)localViewParent).removeView(this.zzfom);
  }

  private final void zzajg()
  {
    if ((this.zzfpj != null) && (this.zzfom != null))
      this.zzfpj.zzb(this.zzfom, Collections.emptyMap(), Collections.emptyMap(), zzbym.zzx(this.zzfom));
  }

  public final void destroy()
    throws RemoteException
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    zzajf();
    if (this.zzfpj != null)
      this.zzfpj.destroy();
    this.zzfpj = null;
    this.zzfom = null;
    this.zzfoh = null;
    this.zzela = true;
  }

  public final zzaap getVideoController()
    throws RemoteException
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    if (this.zzela)
    {
      zzaxa.zzen("getVideoController: Instream ad should not be used after destroyed");
      return null;
    }
    return this.zzfoh;
  }

  public final void onGlobalLayout()
  {
    zzajg();
  }

  public final void onScrollChanged()
  {
    zzajg();
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzajd paramzzajd)
    throws RemoteException
  {
    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
    if (this.zzela)
    {
      zzaxa.zzen("Instream ad is destroyed already.");
      zza(paramzzajd, 2);
      return;
    }
    if ((this.zzfom == null) || (this.zzfoh == null))
    {
      String str1;
      String str2;
      if (this.zzfom == null)
      {
        str1 = "can not get video view.";
        str2 = String.valueOf(str1);
        if (str2.length() == 0)
          break label87;
      }
      label87: for (String str3 = "Instream internal error: ".concat(str2); ; str3 = new String("Instream internal error: "))
      {
        zzaxa.zzen(str3);
        zza(paramzzajd, 0);
        return;
        str1 = "can not get video controller.";
        break;
      }
    }
    if (this.zzfsb)
    {
      zzaxa.zzen("Instream ad should not be used again.");
      zza(paramzzajd, 1);
      return;
    }
    this.zzfsb = true;
    zzajf();
    ((ViewGroup)ObjectWrapper.unwrap(paramIObjectWrapper)).addView(this.zzfom, new ViewGroup.LayoutParams(-1, -1));
    zzk.zzmd();
    zzbca.zza(this.zzfom, this);
    zzk.zzmd();
    zzbca.zza(this.zzfom, this);
    zzajg();
    try
    {
      paramzzajd.zzrt();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void zzre()
  {
    zzaxj.zzdvx.post(new zzcbw(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcbv
 * JD-Core Version:    0.6.2
 */