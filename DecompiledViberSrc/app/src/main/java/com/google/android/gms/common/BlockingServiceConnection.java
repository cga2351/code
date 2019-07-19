package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@KeepForSdk
public class BlockingServiceConnection
  implements ServiceConnection
{
  private boolean zze = false;
  private final BlockingQueue<IBinder> zzf = new LinkedBlockingQueue();

  @KeepForSdk
  public IBinder getService()
    throws InterruptedException
  {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
    if (this.zze)
      throw new IllegalStateException("Cannot call get on this connection more than once");
    this.zze = true;
    return (IBinder)this.zzf.take();
  }

  @KeepForSdk
  public IBinder getServiceWithTimeout(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException
  {
    Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (this.zze)
      throw new IllegalStateException("Cannot call get on this connection more than once");
    this.zze = true;
    IBinder localIBinder = (IBinder)this.zzf.poll(paramLong, paramTimeUnit);
    if (localIBinder == null)
      throw new TimeoutException("Timed out waiting for the service connection");
    return localIBinder;
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.zzf.add(paramIBinder);
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.BlockingServiceConnection
 * JD-Core Version:    0.6.2
 */