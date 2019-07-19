package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

public abstract interface zzbjg extends IInterface
{
  public abstract void beginAdUnitExposure(String paramString)
    throws RemoteException;

  public abstract void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;

  public abstract void endAdUnitExposure(String paramString)
    throws RemoteException;

  public abstract long generateEventId()
    throws RemoteException;

  public abstract String getAppIdOrigin()
    throws RemoteException;

  public abstract String getAppInstanceId()
    throws RemoteException;

  public abstract List getConditionalUserProperties(String paramString1, String paramString2)
    throws RemoteException;

  public abstract String getCurrentScreenClass()
    throws RemoteException;

  public abstract String getCurrentScreenName()
    throws RemoteException;

  public abstract String getGmpAppId()
    throws RemoteException;

  public abstract int getMaxUserProperties(String paramString)
    throws RemoteException;

  public abstract Map getUserProperties(String paramString1, String paramString2, boolean paramBoolean)
    throws RemoteException;

  public abstract void logEvent(String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException;

  public abstract void performAction(Bundle paramBundle)
    throws RemoteException;

  public abstract Bundle performActionWithResponse(Bundle paramBundle)
    throws RemoteException;

  public abstract void setConditionalUserProperty(Bundle paramBundle)
    throws RemoteException;

  public abstract void zza(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper)
    throws RemoteException;

  public abstract void zzb(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2)
    throws RemoteException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbjg
 * JD-Core Version:    0.6.2
 */