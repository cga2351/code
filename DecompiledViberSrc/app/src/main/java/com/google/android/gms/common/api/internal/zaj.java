package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;

public class zaj extends zal
{
  private final SparseArray<zaa> zacv = new SparseArray();

  private zaj(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("AutoManageHelper", this);
  }

  public static zaj zaa(LifecycleActivity paramLifecycleActivity)
  {
    LifecycleFragment localLifecycleFragment = getFragment(paramLifecycleActivity);
    zaj localzaj = (zaj)localLifecycleFragment.getCallbackOrNull("AutoManageHelper", zaj.class);
    if (localzaj != null)
      return localzaj;
    return new zaj(localLifecycleFragment);
  }

  private final zaa zab(int paramInt)
  {
    if (this.zacv.size() <= paramInt)
      return null;
    return (zaa)this.zacv.get(this.zacv.keyAt(paramInt));
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    for (int i = 0; i < this.zacv.size(); i++)
    {
      zaa localzaa = zab(i);
      if (localzaa != null)
      {
        paramPrintWriter.append(paramString).append("GoogleApiClient #").print(localzaa.zacw);
        paramPrintWriter.println(":");
        localzaa.zacx.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
  }

  public void onStart()
  {
    super.onStart();
    boolean bool = this.mStarted;
    String str = String.valueOf(this.zacv);
    Log.d("AutoManageHelper", 14 + String.valueOf(str).length() + "onStart " + bool + " " + str);
    if (this.zade.get() == null)
      for (int i = 0; i < this.zacv.size(); i++)
      {
        zaa localzaa = zab(i);
        if (localzaa != null)
          localzaa.zacx.connect();
      }
  }

  public void onStop()
  {
    super.onStop();
    for (int i = 0; i < this.zacv.size(); i++)
    {
      zaa localzaa = zab(i);
      if (localzaa != null)
        localzaa.zacx.disconnect();
    }
  }

  public final void zaa(int paramInt)
  {
    zaa localzaa = (zaa)this.zacv.get(paramInt);
    this.zacv.remove(paramInt);
    if (localzaa != null)
    {
      localzaa.zacx.unregisterConnectionFailedListener(localzaa);
      localzaa.zacx.disconnect();
    }
  }

  public final void zaa(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.zacv.indexOfKey(paramInt) < 0);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkState(bool1, 54 + "Already managing a GoogleApiClient with id " + paramInt);
      zam localzam = (zam)this.zade.get();
      boolean bool2 = this.mStarted;
      String str1 = String.valueOf(localzam);
      Log.d("AutoManageHelper", 49 + String.valueOf(str1).length() + "starting AutoManage for client " + paramInt + " " + bool2 + " " + str1);
      zaa localzaa = new zaa(paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
      this.zacv.put(paramInt, localzaa);
      if ((this.mStarted) && (localzam == null))
      {
        String str2 = String.valueOf(paramGoogleApiClient);
        Log.d("AutoManageHelper", 11 + String.valueOf(str2).length() + "connecting " + str2);
        paramGoogleApiClient.connect();
      }
      return;
    }
  }

  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt)
  {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0)
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
    GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener;
    do
    {
      zaa localzaa;
      do
      {
        return;
        localzaa = (zaa)this.zacv.get(paramInt);
      }
      while (localzaa == null);
      zaa(paramInt);
      localOnConnectionFailedListener = localzaa.zacy;
    }
    while (localOnConnectionFailedListener == null);
    localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
  }

  protected final void zao()
  {
    for (int i = 0; i < this.zacv.size(); i++)
    {
      zaa localzaa = zab(i);
      if (localzaa != null)
        localzaa.zacx.connect();
    }
  }

  private final class zaa
    implements GoogleApiClient.OnConnectionFailedListener
  {
    public final int zacw;
    public final GoogleApiClient zacx;
    public final GoogleApiClient.OnConnectionFailedListener zacy;

    public zaa(int paramGoogleApiClient, GoogleApiClient paramOnConnectionFailedListener, GoogleApiClient.OnConnectionFailedListener arg4)
    {
      this.zacw = paramGoogleApiClient;
      this.zacx = paramOnConnectionFailedListener;
      Object localObject;
      this.zacy = localObject;
      paramOnConnectionFailedListener.registerConnectionFailedListener(this);
    }

    public final void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      String str = String.valueOf(paramConnectionResult);
      Log.d("AutoManageHelper", 27 + String.valueOf(str).length() + "beginFailureResolution for " + str);
      zaj.this.zab(paramConnectionResult, this.zacw);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaj
 * JD-Core Version:    0.6.2
 */