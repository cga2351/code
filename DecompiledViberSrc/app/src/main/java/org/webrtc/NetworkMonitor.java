package org.webrtc;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class NetworkMonitor
{
  private static final String TAG = "NetworkMonitor";

  @Nullable
  private NetworkMonitorAutoDetect autoDetect;
  private final Object autoDetectLock = new Object();
  private volatile NetworkMonitorAutoDetect.ConnectionType currentConnectionType = NetworkMonitorAutoDetect.ConnectionType.CONNECTION_UNKNOWN;
  private final ArrayList<Long> nativeNetworkObservers = new ArrayList();
  private final ArrayList<NetworkObserver> networkObservers = new ArrayList();
  private int numObservers = 0;

  @Deprecated
  public static void addNetworkObserver(NetworkObserver paramNetworkObserver)
  {
    getInstance().addObserver(paramNetworkObserver);
  }

  @CalledByNative
  private static int androidSdkInt()
  {
    return Build.VERSION.SDK_INT;
  }

  private static void assertIsTrue(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new AssertionError("Expected to be true");
  }

  static NetworkMonitorAutoDetect createAndSetAutoDetectForTest(Context paramContext)
  {
    NetworkMonitor localNetworkMonitor = getInstance();
    NetworkMonitorAutoDetect localNetworkMonitorAutoDetect = localNetworkMonitor.createAutoDetect(paramContext);
    localNetworkMonitor.autoDetect = localNetworkMonitorAutoDetect;
    return localNetworkMonitorAutoDetect;
  }

  private NetworkMonitorAutoDetect createAutoDetect(Context paramContext)
  {
    return new NetworkMonitorAutoDetect(new NetworkMonitorAutoDetect.Observer()
    {
      public void onConnectionTypeChanged(NetworkMonitorAutoDetect.ConnectionType paramAnonymousConnectionType)
      {
        NetworkMonitor.this.updateCurrentConnectionType(paramAnonymousConnectionType);
      }

      public void onNetworkConnect(NetworkMonitorAutoDetect.NetworkInformation paramAnonymousNetworkInformation)
      {
        NetworkMonitor.this.notifyObserversOfNetworkConnect(paramAnonymousNetworkInformation);
      }

      public void onNetworkDisconnect(long paramAnonymousLong)
      {
        NetworkMonitor.this.notifyObserversOfNetworkDisconnect(paramAnonymousLong);
      }
    }
    , paramContext);
  }

  private NetworkMonitorAutoDetect.ConnectionType getCurrentConnectionType()
  {
    return this.currentConnectionType;
  }

  private long getCurrentDefaultNetId()
  {
    synchronized (this.autoDetectLock)
    {
      if (this.autoDetect == null)
      {
        l = -1L;
        return l;
      }
      long l = this.autoDetect.getDefaultNetId();
    }
  }

  @CalledByNative
  public static NetworkMonitor getInstance()
  {
    return InstanceHolder.instance;
  }

  private List<Long> getNativeNetworkObserversSync()
  {
    synchronized (this.nativeNetworkObservers)
    {
      ArrayList localArrayList2 = new ArrayList(this.nativeNetworkObservers);
      return localArrayList2;
    }
  }

  @Deprecated
  public static void init(Context paramContext)
  {
  }

  public static boolean isOnline()
  {
    return getInstance().getCurrentConnectionType() != NetworkMonitorAutoDetect.ConnectionType.CONNECTION_NONE;
  }

  private native void nativeNotifyConnectionTypeChanged(long paramLong);

  private native void nativeNotifyOfActiveNetworkList(long paramLong, NetworkMonitorAutoDetect.NetworkInformation[] paramArrayOfNetworkInformation);

  private native void nativeNotifyOfNetworkConnect(long paramLong, NetworkMonitorAutoDetect.NetworkInformation paramNetworkInformation);

  private native void nativeNotifyOfNetworkDisconnect(long paramLong1, long paramLong2);

  @CalledByNative
  private boolean networkBindingSupported()
  {
    while (true)
    {
      synchronized (this.autoDetectLock)
      {
        if ((this.autoDetect != null) && (this.autoDetect.supportNetworkCallback()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  private void notifyObserversOfConnectionTypeChange(NetworkMonitorAutoDetect.ConnectionType paramConnectionType)
  {
    Iterator localIterator1 = getNativeNetworkObserversSync().iterator();
    while (localIterator1.hasNext())
      nativeNotifyConnectionTypeChanged(((Long)localIterator1.next()).longValue());
    synchronized (this.networkObservers)
    {
      ArrayList localArrayList2 = new ArrayList(this.networkObservers);
      Iterator localIterator2 = localArrayList2.iterator();
      if (localIterator2.hasNext())
        ((NetworkObserver)localIterator2.next()).onConnectionTypeChanged(paramConnectionType);
    }
  }

  private void notifyObserversOfNetworkConnect(NetworkMonitorAutoDetect.NetworkInformation paramNetworkInformation)
  {
    Iterator localIterator = getNativeNetworkObserversSync().iterator();
    while (localIterator.hasNext())
      nativeNotifyOfNetworkConnect(((Long)localIterator.next()).longValue(), paramNetworkInformation);
  }

  private void notifyObserversOfNetworkDisconnect(long paramLong)
  {
    Iterator localIterator = getNativeNetworkObserversSync().iterator();
    while (localIterator.hasNext())
      nativeNotifyOfNetworkDisconnect(((Long)localIterator.next()).longValue(), paramLong);
  }

  @Deprecated
  public static void removeNetworkObserver(NetworkObserver paramNetworkObserver)
  {
    getInstance().removeObserver(paramNetworkObserver);
  }

  @CalledByNative
  private void startMonitoring(@Nullable Context paramContext, long paramLong)
  {
    Logging.d("NetworkMonitor", "Start monitoring with native observer " + paramLong);
    if (paramContext != null);
    while (true)
    {
      startMonitoring(paramContext);
      synchronized (this.nativeNetworkObservers)
      {
        this.nativeNetworkObservers.add(Long.valueOf(paramLong));
        updateObserverActiveNetworkList(paramLong);
        notifyObserversOfConnectionTypeChange(this.currentConnectionType);
        return;
        paramContext = ContextUtils.getApplicationContext();
      }
    }
  }

  @CalledByNative
  private void stopMonitoring(long paramLong)
  {
    Logging.d("NetworkMonitor", "Stop monitoring with native observer " + paramLong);
    stopMonitoring();
    synchronized (this.nativeNetworkObservers)
    {
      this.nativeNetworkObservers.remove(Long.valueOf(paramLong));
      return;
    }
  }

  private void updateCurrentConnectionType(NetworkMonitorAutoDetect.ConnectionType paramConnectionType)
  {
    this.currentConnectionType = paramConnectionType;
    notifyObserversOfConnectionTypeChange(paramConnectionType);
  }

  private void updateObserverActiveNetworkList(long paramLong)
  {
    List localList;
    synchronized (this.autoDetectLock)
    {
      if (this.autoDetect == null)
      {
        localList = null;
        if ((localList != null) && (localList.size() != 0));
      }
      else
      {
        localList = this.autoDetect.getActiveNetworkList();
      }
    }
    nativeNotifyOfActiveNetworkList(paramLong, (NetworkMonitorAutoDetect.NetworkInformation[])localList.toArray(new NetworkMonitorAutoDetect.NetworkInformation[localList.size()]));
  }

  public void addObserver(NetworkObserver paramNetworkObserver)
  {
    synchronized (this.networkObservers)
    {
      this.networkObservers.add(paramNetworkObserver);
      return;
    }
  }

  @Nullable
  NetworkMonitorAutoDetect getNetworkMonitorAutoDetect()
  {
    synchronized (this.autoDetectLock)
    {
      NetworkMonitorAutoDetect localNetworkMonitorAutoDetect = this.autoDetect;
      return localNetworkMonitorAutoDetect;
    }
  }

  int getNumObservers()
  {
    synchronized (this.autoDetectLock)
    {
      int i = this.numObservers;
      return i;
    }
  }

  public void removeObserver(NetworkObserver paramNetworkObserver)
  {
    synchronized (this.networkObservers)
    {
      this.networkObservers.remove(paramNetworkObserver);
      return;
    }
  }

  @Deprecated
  public void startMonitoring()
  {
    startMonitoring(ContextUtils.getApplicationContext());
  }

  public void startMonitoring(Context paramContext)
  {
    synchronized (this.autoDetectLock)
    {
      this.numObservers = (1 + this.numObservers);
      if (this.autoDetect == null)
        this.autoDetect = createAutoDetect(paramContext);
      this.currentConnectionType = NetworkMonitorAutoDetect.getConnectionType(this.autoDetect.getCurrentNetworkState());
      return;
    }
  }

  public void stopMonitoring()
  {
    synchronized (this.autoDetectLock)
    {
      int i = -1 + this.numObservers;
      this.numObservers = i;
      if (i == 0)
      {
        this.autoDetect.destroy();
        this.autoDetect = null;
      }
      return;
    }
  }

  private static class InstanceHolder
  {
    static final NetworkMonitor instance = new NetworkMonitor(null);
  }

  public static abstract interface NetworkObserver
  {
    public abstract void onConnectionTypeChanged(NetworkMonitorAutoDetect.ConnectionType paramConnectionType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.NetworkMonitor
 * JD-Core Version:    0.6.2
 */