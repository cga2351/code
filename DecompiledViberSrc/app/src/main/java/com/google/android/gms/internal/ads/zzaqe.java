package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzaqe
{
  private static final Object lock = new Object();

  @VisibleForTesting
  @GuardedBy("lock")
  private static boolean zzdjg = false;

  @VisibleForTesting
  @GuardedBy("lock")
  private static boolean zzxs = false;

  @VisibleForTesting
  private zzdag zzdjh;

  @VisibleForTesting
  private final void zzm(Context paramContext)
  {
    synchronized (lock)
    {
      zzaci localzzaci = zzact.zzcuv;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      {
        boolean bool = zzdjg;
        if (bool);
      }
      try
      {
        zzdjg = true;
        this.zzdjh = ((zzdag)zzbaf.zza(paramContext, "com.google.android.gms.ads.omid.DynamiteOmid", zzaqf.zzbze));
        return;
      }
      catch (zzbah localzzbah)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localzzbah);
      }
    }
  }

  public final String getVersion(Context paramContext)
  {
    zzaci localzzaci = zzact.zzcuv;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return null;
    try
    {
      zzm(paramContext);
      String str1 = String.valueOf(this.zzdjh.getVersion());
      if (str1.length() != 0)
        return "a.".concat(str1);
      String str2 = new String("a.");
      return str2;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      return null;
    }
    catch (NullPointerException localNullPointerException)
    {
      label72: break label72;
    }
  }

  public final IObjectWrapper zza(String paramString1, WebView paramWebView, String paramString2, String paramString3, String paramString4)
  {
    return zza(paramString1, paramWebView, paramString2, paramString3, paramString4, "Google");
  }

  public final IObjectWrapper zza(String paramString1, WebView paramWebView, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    synchronized (lock)
    {
      zzaci localzzaci = zzact.zzcuv;
      if ((!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) || (!zzxs))
        return null;
    }
    try
    {
      IObjectWrapper localIObjectWrapper = this.zzdjh.zza(paramString1, ObjectWrapper.wrap(paramWebView), paramString2, paramString3, paramString4, paramString5);
      return localIObjectWrapper;
      localObject2 = finally;
      throw localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      zzbae.zze("#007 Could not call remote method.", localNullPointerException);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      label80: break label80;
    }
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, View paramView)
  {
    synchronized (lock)
    {
      zzaci localzzaci = zzact.zzcuv;
      if ((!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) || (!zzxs))
        return;
    }
    try
    {
      this.zzdjh.zzd(paramIObjectWrapper, ObjectWrapper.wrap(paramView));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      label56: break label56;
    }
  }

  public final void zzaa(IObjectWrapper paramIObjectWrapper)
  {
    synchronized (lock)
    {
      zzaci localzzaci = zzact.zzcuv;
      if ((!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) || (!zzxs))
        return;
    }
    try
    {
      this.zzdjh.zzaa(paramIObjectWrapper);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      label52: break label52;
    }
  }

  public final void zzab(IObjectWrapper paramIObjectWrapper)
  {
    synchronized (lock)
    {
      zzaci localzzaci = zzact.zzcuv;
      if ((!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) || (!zzxs))
        return;
    }
    try
    {
      this.zzdjh.zzab(paramIObjectWrapper);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      label52: break label52;
    }
  }

  public final boolean zzl(Context paramContext)
  {
    synchronized (lock)
    {
      zzaci localzzaci = zzact.zzcuv;
      if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        return false;
      if (zzxs)
        return true;
    }
    try
    {
      zzm(paramContext);
      boolean bool = this.zzdjh.zzap(ObjectWrapper.wrap(paramContext));
      zzxs = bool;
      return bool;
      label77: Throwable localThrowable;
      zzbae.zze("#007 Could not call remote method.", localThrowable);
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      break label77;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label77;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaqe
 * JD-Core Version:    0.6.2
 */