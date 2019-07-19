package com.google.android.gms.common.api.internal;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zaag extends GoogleApiClient
{
  private final String zafr;

  public zaag(String paramString)
  {
    this.zafr = paramString;
  }

  public ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public void connect()
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public void disconnect()
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public ConnectionResult getConnectionResult(Api<?> paramApi)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public boolean hasConnectedApi(Api<?> paramApi)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public boolean isConnected()
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public boolean isConnecting()
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public void reconnect()
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(this.zafr);
  }

  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(this.zafr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaag
 * JD-Core Version:    0.6.2
 */