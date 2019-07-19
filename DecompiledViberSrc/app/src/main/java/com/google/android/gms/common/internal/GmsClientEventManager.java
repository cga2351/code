package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zal;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager
  implements Handler.Callback
{
  private final Handler mHandler;
  private final Object mLock = new Object();
  private final GmsClientEventState zaok;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zaol = new ArrayList();

  @VisibleForTesting
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zaom = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zaon = new ArrayList();
  private volatile boolean zaoo = false;
  private final AtomicInteger zaop = new AtomicInteger(0);
  private boolean zaoq = false;

  public GmsClientEventManager(Looper paramLooper, GmsClientEventState paramGmsClientEventState)
  {
    this.zaok = paramGmsClientEventState;
    this.mHandler = new zal(paramLooper, this);
  }

  public final boolean areCallbacksEnabled()
  {
    return this.zaoo;
  }

  public final void disableCallbacks()
  {
    this.zaoo = false;
    this.zaop.incrementAndGet();
  }

  public final void enableCallbacks()
  {
    this.zaoo = true;
  }

  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)paramMessage.obj;
      synchronized (this.mLock)
      {
        if ((this.zaoo) && (this.zaok.isConnected()) && (this.zaol.contains(localConnectionCallbacks)))
          localConnectionCallbacks.onConnected(this.zaok.getConnectionHint());
        return true;
      }
    }
    int i = paramMessage.what;
    Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
    return false;
  }

  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock)
    {
      boolean bool = this.zaol.contains(paramConnectionCallbacks);
      return bool;
    }
  }

  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock)
    {
      boolean bool = this.zaon.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }

  @VisibleForTesting
  public final void onConnectionFailure(ConnectionResult paramConnectionResult)
  {
    int i = 0;
    if (Looper.myLooper() == this.mHandler.getLooper());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.mLock)
      {
        ArrayList localArrayList1 = new ArrayList(this.zaon);
        int j = this.zaop.get();
        ArrayList localArrayList2 = (ArrayList)localArrayList1;
        int k = localArrayList2.size();
        while (i < k)
        {
          Object localObject3 = localArrayList2.get(i);
          i++;
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)localObject3;
          if ((!this.zaoo) || (this.zaop.get() != j))
            return;
          if (this.zaon.contains(localOnConnectionFailedListener))
            localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
        }
      }
      return;
    }
  }

  @VisibleForTesting
  protected final void onConnectionSuccess()
  {
    synchronized (this.mLock)
    {
      onConnectionSuccess(this.zaok.getConnectionHint());
      return;
    }
  }

  @VisibleForTesting
  public final void onConnectionSuccess(Bundle paramBundle)
  {
    boolean bool1 = true;
    int i = 0;
    boolean bool2;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool2 = bool1;
      Preconditions.checkState(bool2, "onConnectionSuccess must only be called on the Handler thread");
    }
    while (true)
    {
      synchronized (this.mLock)
      {
        if (this.zaoq)
          break label206;
        bool3 = bool1;
        Preconditions.checkState(bool3);
        this.mHandler.removeMessages(1);
        this.zaoq = true;
        if (this.zaom.size() != 0)
          break label212;
        Preconditions.checkState(bool1);
        ArrayList localArrayList1 = new ArrayList(this.zaol);
        int j = this.zaop.get();
        ArrayList localArrayList2 = (ArrayList)localArrayList1;
        int k = localArrayList2.size();
        if (i >= k)
          break label217;
        Object localObject3 = localArrayList2.get(i);
        i++;
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localObject3;
        if ((!this.zaoo) || (!this.zaok.isConnected()) || (this.zaop.get() != j))
          break label217;
        if (this.zaom.contains(localConnectionCallbacks))
          continue;
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool2 = false;
      break;
      label206: boolean bool3 = false;
      continue;
      label212: bool1 = false;
    }
    label217: this.zaom.clear();
    this.zaoq = false;
  }

  @VisibleForTesting
  public final void onUnintentionalDisconnection(int paramInt)
  {
    int i = 0;
    if (Looper.myLooper() == this.mHandler.getLooper());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.mLock)
      {
        this.zaoq = true;
        ArrayList localArrayList1 = new ArrayList(this.zaol);
        int j = this.zaop.get();
        ArrayList localArrayList2 = (ArrayList)localArrayList1;
        int k = localArrayList2.size();
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
        do
        {
          if (i >= k)
            break;
          Object localObject3 = localArrayList2.get(i);
          i++;
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localObject3;
          if ((!this.zaoo) || (this.zaop.get() != j))
            break;
        }
        while (!this.zaol.contains(localConnectionCallbacks));
        localConnectionCallbacks.onConnectionSuspended(paramInt);
      }
    }
    this.zaom.clear();
    this.zaoq = false;
  }

  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock)
    {
      if (this.zaol.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        Log.w("GmsClientEvents", 62 + String.valueOf(str).length() + "registerConnectionCallbacks(): listener " + str + " is already registered");
        if (this.zaok.isConnected())
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        return;
      }
      this.zaol.add(paramConnectionCallbacks);
    }
  }

  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock)
    {
      if (this.zaon.contains(paramOnConnectionFailedListener))
      {
        String str = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", 67 + String.valueOf(str).length() + "registerConnectionFailedListener(): listener " + str + " is already registered");
        return;
      }
      this.zaon.add(paramOnConnectionFailedListener);
    }
  }

  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    Preconditions.checkNotNull(paramConnectionCallbacks);
    synchronized (this.mLock)
    {
      if (!this.zaol.remove(paramConnectionCallbacks))
      {
        str = String.valueOf(paramConnectionCallbacks);
        Log.w("GmsClientEvents", 52 + String.valueOf(str).length() + "unregisterConnectionCallbacks(): listener " + str + " not found");
      }
      while (!this.zaoq)
      {
        String str;
        return;
      }
      this.zaom.add(paramConnectionCallbacks);
    }
  }

  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    Preconditions.checkNotNull(paramOnConnectionFailedListener);
    synchronized (this.mLock)
    {
      if (!this.zaon.remove(paramOnConnectionFailedListener))
      {
        String str = String.valueOf(paramOnConnectionFailedListener);
        Log.w("GmsClientEvents", 57 + String.valueOf(str).length() + "unregisterConnectionFailedListener(): listener " + str + " not found");
      }
      return;
    }
  }

  @VisibleForTesting
  public static abstract interface GmsClientEventState
  {
    public abstract Bundle getConnectionHint();

    public abstract boolean isConnected();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.GmsClientEventManager
 * JD-Core Version:    0.6.2
 */