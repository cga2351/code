package org.webrtc;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import android.net.wifi.WifiInfo;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Build.VERSION;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class NetworkMonitorAutoDetect extends BroadcastReceiver
{
  static final long INVALID_NET_ID = -1L;
  private static final String TAG = "NetworkMonitorAutoDetect";

  @Nullable
  private final ConnectivityManager.NetworkCallback allNetworkCallback;
  private ConnectionType connectionType;
  private ConnectivityManagerDelegate connectivityManagerDelegate;
  private final Context context;
  private final IntentFilter intentFilter;
  private boolean isRegistered;

  @Nullable
  private final ConnectivityManager.NetworkCallback mobileNetworkCallback;
  private final Observer observer;
  private WifiDirectManagerDelegate wifiDirectManagerDelegate;
  private WifiManagerDelegate wifiManagerDelegate;
  private String wifiSSID;

  @SuppressLint({"NewApi"})
  public NetworkMonitorAutoDetect(Observer paramObserver, Context paramContext)
  {
    this.observer = paramObserver;
    this.context = paramContext;
    this.connectivityManagerDelegate = new ConnectivityManagerDelegate(paramContext);
    this.wifiManagerDelegate = new WifiManagerDelegate(paramContext);
    NetworkState localNetworkState = this.connectivityManagerDelegate.getNetworkState();
    this.connectionType = getConnectionType(localNetworkState);
    this.wifiSSID = getWifiSSID(localNetworkState);
    this.intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    if (PeerConnectionFactory.fieldTrialsFindFullName("IncludeWifiDirect").equals("Enabled"))
      this.wifiDirectManagerDelegate = new WifiDirectManagerDelegate(paramObserver, paramContext);
    registerReceiver();
    if (this.connectivityManagerDelegate.supportNetworkCallback())
    {
      ConnectivityManager.NetworkCallback localNetworkCallback = new ConnectivityManager.NetworkCallback();
      try
      {
        this.connectivityManagerDelegate.requestMobileNetwork(localNetworkCallback);
        this.mobileNetworkCallback = localNetworkCallback;
        this.allNetworkCallback = new SimpleNetworkCallback(null);
        this.connectivityManagerDelegate.registerNetworkCallback(this.allNetworkCallback);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        while (true)
        {
          Logging.w("NetworkMonitorAutoDetect", "Unable to obtain permission to request a cellular network.");
          localNetworkCallback = null;
        }
      }
    }
    this.mobileNetworkCallback = null;
    this.allNetworkCallback = null;
  }

  private void connectionTypeChanged(NetworkState paramNetworkState)
  {
    ConnectionType localConnectionType = getConnectionType(paramNetworkState);
    String str = getWifiSSID(paramNetworkState);
    if ((localConnectionType == this.connectionType) && (str.equals(this.wifiSSID)))
      return;
    this.connectionType = localConnectionType;
    this.wifiSSID = str;
    Logging.d("NetworkMonitorAutoDetect", "Network connectivity changed, type is: " + this.connectionType);
    this.observer.onConnectionTypeChanged(localConnectionType);
  }

  public static ConnectionType getConnectionType(NetworkState paramNetworkState)
  {
    return getConnectionType(paramNetworkState.isConnected(), paramNetworkState.getNetworkType(), paramNetworkState.getNetworkSubType());
  }

  private static ConnectionType getConnectionType(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
      return ConnectionType.CONNECTION_NONE;
    switch (paramInt1)
    {
    default:
      return ConnectionType.CONNECTION_UNKNOWN;
    case 9:
      return ConnectionType.CONNECTION_ETHERNET;
    case 1:
      return ConnectionType.CONNECTION_WIFI;
    case 6:
      return ConnectionType.CONNECTION_4G;
    case 7:
      return ConnectionType.CONNECTION_BLUETOOTH;
    case 0:
      switch (paramInt2)
      {
      default:
        return ConnectionType.CONNECTION_UNKNOWN_CELLULAR;
      case 1:
      case 2:
      case 4:
      case 7:
      case 11:
        return ConnectionType.CONNECTION_2G;
      case 3:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
      case 15:
        return ConnectionType.CONNECTION_3G;
      case 13:
      }
      return ConnectionType.CONNECTION_4G;
    case 17:
    }
    return ConnectionType.CONNECTION_VPN;
  }

  private static ConnectionType getUnderlyingConnectionTypeForVpn(NetworkState paramNetworkState)
  {
    if (paramNetworkState.getNetworkType() != 17)
      return ConnectionType.CONNECTION_NONE;
    return getConnectionType(paramNetworkState.isConnected(), paramNetworkState.getUnderlyingNetworkTypeForVpn(), paramNetworkState.getUnderlyingNetworkSubtypeForVpn());
  }

  private String getWifiSSID(NetworkState paramNetworkState)
  {
    if (getConnectionType(paramNetworkState) != ConnectionType.CONNECTION_WIFI)
      return "";
    return this.wifiManagerDelegate.getWifiSSID();
  }

  @SuppressLint({"NewApi"})
  private static long networkToNetId(Network paramNetwork)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramNetwork.getNetworkHandle();
    return Integer.parseInt(paramNetwork.toString());
  }

  private void registerReceiver()
  {
    if (this.isRegistered)
      return;
    this.isRegistered = true;
    this.context.registerReceiver(this, this.intentFilter);
  }

  private void unregisterReceiver()
  {
    if (!this.isRegistered)
      return;
    this.isRegistered = false;
    this.context.unregisterReceiver(this);
  }

  public void destroy()
  {
    if (this.allNetworkCallback != null)
      this.connectivityManagerDelegate.releaseCallback(this.allNetworkCallback);
    if (this.mobileNetworkCallback != null)
      this.connectivityManagerDelegate.releaseCallback(this.mobileNetworkCallback);
    if (this.wifiDirectManagerDelegate != null)
      this.wifiDirectManagerDelegate.release();
    unregisterReceiver();
  }

  @Nullable
  List<NetworkInformation> getActiveNetworkList()
  {
    List localList = this.connectivityManagerDelegate.getActiveNetworkList();
    Object localObject;
    if (localList == null)
      localObject = null;
    do
    {
      return localObject;
      localObject = new ArrayList(localList);
    }
    while (this.wifiDirectManagerDelegate == null);
    ((ArrayList)localObject).addAll(this.wifiDirectManagerDelegate.getActiveNetworkList());
    return localObject;
  }

  public NetworkState getCurrentNetworkState()
  {
    return this.connectivityManagerDelegate.getNetworkState();
  }

  public long getDefaultNetId()
  {
    return this.connectivityManagerDelegate.getDefaultNetId();
  }

  boolean isReceiverRegisteredForTesting()
  {
    return this.isRegistered;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    NetworkState localNetworkState = getCurrentNetworkState();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
      connectionTypeChanged(localNetworkState);
  }

  void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate paramConnectivityManagerDelegate)
  {
    this.connectivityManagerDelegate = paramConnectivityManagerDelegate;
  }

  void setWifiManagerDelegateForTests(WifiManagerDelegate paramWifiManagerDelegate)
  {
    this.wifiManagerDelegate = paramWifiManagerDelegate;
  }

  public boolean supportNetworkCallback()
  {
    return this.connectivityManagerDelegate.supportNetworkCallback();
  }

  public static enum ConnectionType
  {
    static
    {
      CONNECTION_ETHERNET = new ConnectionType("CONNECTION_ETHERNET", 1);
      CONNECTION_WIFI = new ConnectionType("CONNECTION_WIFI", 2);
      CONNECTION_4G = new ConnectionType("CONNECTION_4G", 3);
      CONNECTION_3G = new ConnectionType("CONNECTION_3G", 4);
      CONNECTION_2G = new ConnectionType("CONNECTION_2G", 5);
      CONNECTION_UNKNOWN_CELLULAR = new ConnectionType("CONNECTION_UNKNOWN_CELLULAR", 6);
      CONNECTION_BLUETOOTH = new ConnectionType("CONNECTION_BLUETOOTH", 7);
      CONNECTION_VPN = new ConnectionType("CONNECTION_VPN", 8);
      CONNECTION_NONE = new ConnectionType("CONNECTION_NONE", 9);
      ConnectionType[] arrayOfConnectionType = new ConnectionType[10];
      arrayOfConnectionType[0] = CONNECTION_UNKNOWN;
      arrayOfConnectionType[1] = CONNECTION_ETHERNET;
      arrayOfConnectionType[2] = CONNECTION_WIFI;
      arrayOfConnectionType[3] = CONNECTION_4G;
      arrayOfConnectionType[4] = CONNECTION_3G;
      arrayOfConnectionType[5] = CONNECTION_2G;
      arrayOfConnectionType[6] = CONNECTION_UNKNOWN_CELLULAR;
      arrayOfConnectionType[7] = CONNECTION_BLUETOOTH;
      arrayOfConnectionType[8] = CONNECTION_VPN;
      arrayOfConnectionType[9] = CONNECTION_NONE;
    }
  }

  static class ConnectivityManagerDelegate
  {

    @Nullable
    private final ConnectivityManager connectivityManager;

    ConnectivityManagerDelegate()
    {
      this.connectivityManager = null;
    }

    ConnectivityManagerDelegate(Context paramContext)
    {
      this.connectivityManager = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    }

    private NetworkMonitorAutoDetect.NetworkState getNetworkState(@Nullable NetworkInfo paramNetworkInfo)
    {
      if ((paramNetworkInfo == null) || (!paramNetworkInfo.isConnected()))
        return new NetworkMonitorAutoDetect.NetworkState(false, -1, -1, -1, -1);
      return new NetworkMonitorAutoDetect.NetworkState(true, paramNetworkInfo.getType(), paramNetworkInfo.getSubtype(), -1, -1);
    }

    @Nullable
    @SuppressLint({"NewApi"})
    private NetworkMonitorAutoDetect.NetworkInformation networkToInfo(@Nullable Network paramNetwork)
    {
      if ((paramNetwork == null) || (this.connectivityManager == null))
        return null;
      LinkProperties localLinkProperties = this.connectivityManager.getLinkProperties(paramNetwork);
      if (localLinkProperties == null)
      {
        Logging.w("NetworkMonitorAutoDetect", "Detected unknown network: " + paramNetwork.toString());
        return null;
      }
      if (localLinkProperties.getInterfaceName() == null)
      {
        Logging.w("NetworkMonitorAutoDetect", "Null interface name for network " + paramNetwork.toString());
        return null;
      }
      NetworkMonitorAutoDetect.NetworkState localNetworkState = getNetworkState(paramNetwork);
      NetworkMonitorAutoDetect.ConnectionType localConnectionType1 = NetworkMonitorAutoDetect.getConnectionType(localNetworkState);
      if (localConnectionType1 == NetworkMonitorAutoDetect.ConnectionType.CONNECTION_NONE)
      {
        Logging.d("NetworkMonitorAutoDetect", "Network " + paramNetwork.toString() + " is disconnected");
        return null;
      }
      if ((localConnectionType1 == NetworkMonitorAutoDetect.ConnectionType.CONNECTION_UNKNOWN) || (localConnectionType1 == NetworkMonitorAutoDetect.ConnectionType.CONNECTION_UNKNOWN_CELLULAR))
        Logging.d("NetworkMonitorAutoDetect", "Network " + paramNetwork.toString() + " connection type is " + localConnectionType1 + " because it has type " + localNetworkState.getNetworkType() + " and subtype " + localNetworkState.getNetworkSubType());
      NetworkMonitorAutoDetect.ConnectionType localConnectionType2 = NetworkMonitorAutoDetect.getUnderlyingConnectionTypeForVpn(localNetworkState);
      return new NetworkMonitorAutoDetect.NetworkInformation(localLinkProperties.getInterfaceName(), localConnectionType1, localConnectionType2, NetworkMonitorAutoDetect.networkToNetId(paramNetwork), getIPAddresses(localLinkProperties));
    }

    @Nullable
    List<NetworkMonitorAutoDetect.NetworkInformation> getActiveNetworkList()
    {
      Object localObject;
      if (!supportNetworkCallback())
        localObject = null;
      while (true)
      {
        return localObject;
        localObject = new ArrayList();
        Network[] arrayOfNetwork = getAllNetworks();
        int i = arrayOfNetwork.length;
        for (int j = 0; j < i; j++)
        {
          NetworkMonitorAutoDetect.NetworkInformation localNetworkInformation = networkToInfo(arrayOfNetwork[j]);
          if (localNetworkInformation != null)
            ((ArrayList)localObject).add(localNetworkInformation);
        }
      }
    }

    @SuppressLint({"NewApi"})
    Network[] getAllNetworks()
    {
      if (this.connectivityManager == null)
        return new Network[0];
      return this.connectivityManager.getAllNetworks();
    }

    @SuppressLint({"NewApi"})
    long getDefaultNetId()
    {
      if (!supportNetworkCallback())
      {
        l = -1L;
        return l;
      }
      NetworkInfo localNetworkInfo1 = this.connectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo1 == null)
        return -1L;
      Network[] arrayOfNetwork = getAllNetworks();
      int i = arrayOfNetwork.length;
      int j = 0;
      long l = -1L;
      label47: Network localNetwork;
      if (j < i)
      {
        localNetwork = arrayOfNetwork[j];
        if (hasInternetCapability(localNetwork))
          break label74;
      }
      while (true)
      {
        j++;
        break label47;
        break;
        label74: NetworkInfo localNetworkInfo2 = this.connectivityManager.getNetworkInfo(localNetwork);
        if ((localNetworkInfo2 != null) && (localNetworkInfo2.getType() == localNetworkInfo1.getType()))
        {
          if (l != -1L)
            throw new RuntimeException("Multiple connected networks of same type are not supported.");
          l = NetworkMonitorAutoDetect.networkToNetId(localNetwork);
        }
      }
    }

    @SuppressLint({"NewApi"})
    NetworkMonitorAutoDetect.IPAddress[] getIPAddresses(LinkProperties paramLinkProperties)
    {
      NetworkMonitorAutoDetect.IPAddress[] arrayOfIPAddress = new NetworkMonitorAutoDetect.IPAddress[paramLinkProperties.getLinkAddresses().size()];
      Iterator localIterator = paramLinkProperties.getLinkAddresses().iterator();
      for (int i = 0; localIterator.hasNext(); i++)
        arrayOfIPAddress[i] = new NetworkMonitorAutoDetect.IPAddress(((LinkAddress)localIterator.next()).getAddress().getAddress());
      return arrayOfIPAddress;
    }

    NetworkMonitorAutoDetect.NetworkState getNetworkState()
    {
      if (this.connectivityManager == null)
        return new NetworkMonitorAutoDetect.NetworkState(false, -1, -1, -1, -1);
      return getNetworkState(this.connectivityManager.getActiveNetworkInfo());
    }

    @SuppressLint({"NewApi"})
    NetworkMonitorAutoDetect.NetworkState getNetworkState(@Nullable Network paramNetwork)
    {
      if ((paramNetwork == null) || (this.connectivityManager == null))
        return new NetworkMonitorAutoDetect.NetworkState(false, -1, -1, -1, -1);
      NetworkInfo localNetworkInfo1 = this.connectivityManager.getNetworkInfo(paramNetwork);
      if (localNetworkInfo1 == null)
      {
        Logging.w("NetworkMonitorAutoDetect", "Couldn't retrieve information from network " + paramNetwork.toString());
        return new NetworkMonitorAutoDetect.NetworkState(false, -1, -1, -1, -1);
      }
      if (localNetworkInfo1.getType() != 17)
      {
        NetworkCapabilities localNetworkCapabilities = this.connectivityManager.getNetworkCapabilities(paramNetwork);
        if ((localNetworkCapabilities == null) || (!localNetworkCapabilities.hasTransport(4)))
          return getNetworkState(localNetworkInfo1);
        return new NetworkMonitorAutoDetect.NetworkState(localNetworkInfo1.isConnected(), 17, -1, localNetworkInfo1.getType(), localNetworkInfo1.getSubtype());
      }
      if ((localNetworkInfo1.getType() == 17) && (paramNetwork.equals(this.connectivityManager.getActiveNetwork())))
      {
        NetworkInfo localNetworkInfo2 = this.connectivityManager.getActiveNetworkInfo();
        if (localNetworkInfo2.getType() != 17)
          return new NetworkMonitorAutoDetect.NetworkState(localNetworkInfo1.isConnected(), 17, -1, localNetworkInfo2.getType(), localNetworkInfo2.getSubtype());
      }
      return getNetworkState(localNetworkInfo1);
    }

    @SuppressLint({"NewApi"})
    boolean hasInternetCapability(Network paramNetwork)
    {
      if (this.connectivityManager == null);
      NetworkCapabilities localNetworkCapabilities;
      do
      {
        return false;
        localNetworkCapabilities = this.connectivityManager.getNetworkCapabilities(paramNetwork);
      }
      while ((localNetworkCapabilities == null) || (!localNetworkCapabilities.hasCapability(12)));
      return true;
    }

    @SuppressLint({"NewApi"})
    public void registerNetworkCallback(ConnectivityManager.NetworkCallback paramNetworkCallback)
    {
      this.connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), paramNetworkCallback);
    }

    @SuppressLint({"NewApi"})
    public void releaseCallback(ConnectivityManager.NetworkCallback paramNetworkCallback)
    {
      if (supportNetworkCallback())
      {
        Logging.d("NetworkMonitorAutoDetect", "Unregister network callback");
        this.connectivityManager.unregisterNetworkCallback(paramNetworkCallback);
      }
    }

    @SuppressLint({"NewApi"})
    public void requestMobileNetwork(ConnectivityManager.NetworkCallback paramNetworkCallback)
    {
      NetworkRequest.Builder localBuilder = new NetworkRequest.Builder();
      localBuilder.addCapability(12).addTransportType(0);
      this.connectivityManager.requestNetwork(localBuilder.build(), paramNetworkCallback);
    }

    public boolean supportNetworkCallback()
    {
      return (Build.VERSION.SDK_INT >= 21) && (this.connectivityManager != null);
    }
  }

  public static class IPAddress
  {
    public final byte[] address;

    public IPAddress(byte[] paramArrayOfByte)
    {
      this.address = paramArrayOfByte;
    }

    @CalledByNative("IPAddress")
    private byte[] getAddress()
    {
      return this.address;
    }
  }

  public static class NetworkInformation
  {
    public final long handle;
    public final NetworkMonitorAutoDetect.IPAddress[] ipAddresses;
    public final String name;
    public final NetworkMonitorAutoDetect.ConnectionType type;
    public final NetworkMonitorAutoDetect.ConnectionType underlyingTypeForVpn;

    public NetworkInformation(String paramString, NetworkMonitorAutoDetect.ConnectionType paramConnectionType1, NetworkMonitorAutoDetect.ConnectionType paramConnectionType2, long paramLong, NetworkMonitorAutoDetect.IPAddress[] paramArrayOfIPAddress)
    {
      this.name = paramString;
      this.type = paramConnectionType1;
      this.underlyingTypeForVpn = paramConnectionType2;
      this.handle = paramLong;
      this.ipAddresses = paramArrayOfIPAddress;
    }

    @CalledByNative("NetworkInformation")
    private NetworkMonitorAutoDetect.ConnectionType getConnectionType()
    {
      return this.type;
    }

    @CalledByNative("NetworkInformation")
    private long getHandle()
    {
      return this.handle;
    }

    @CalledByNative("NetworkInformation")
    private NetworkMonitorAutoDetect.IPAddress[] getIpAddresses()
    {
      return this.ipAddresses;
    }

    @CalledByNative("NetworkInformation")
    private String getName()
    {
      return this.name;
    }

    @CalledByNative("NetworkInformation")
    private NetworkMonitorAutoDetect.ConnectionType getUnderlyingConnectionTypeForVpn()
    {
      return this.underlyingTypeForVpn;
    }
  }

  static class NetworkState
  {
    private final boolean connected;
    private final int subtype;
    private final int type;
    private final int underlyingNetworkSubtypeForVpn;
    private final int underlyingNetworkTypeForVpn;

    public NetworkState(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.connected = paramBoolean;
      this.type = paramInt1;
      this.subtype = paramInt2;
      this.underlyingNetworkTypeForVpn = paramInt3;
      this.underlyingNetworkSubtypeForVpn = paramInt4;
    }

    public int getNetworkSubType()
    {
      return this.subtype;
    }

    public int getNetworkType()
    {
      return this.type;
    }

    public int getUnderlyingNetworkSubtypeForVpn()
    {
      return this.underlyingNetworkSubtypeForVpn;
    }

    public int getUnderlyingNetworkTypeForVpn()
    {
      return this.underlyingNetworkTypeForVpn;
    }

    public boolean isConnected()
    {
      return this.connected;
    }
  }

  public static abstract interface Observer
  {
    public abstract void onConnectionTypeChanged(NetworkMonitorAutoDetect.ConnectionType paramConnectionType);

    public abstract void onNetworkConnect(NetworkMonitorAutoDetect.NetworkInformation paramNetworkInformation);

    public abstract void onNetworkDisconnect(long paramLong);
  }

  @SuppressLint({"NewApi"})
  private class SimpleNetworkCallback extends ConnectivityManager.NetworkCallback
  {
    private SimpleNetworkCallback()
    {
    }

    private void onNetworkChanged(Network paramNetwork)
    {
      NetworkMonitorAutoDetect.NetworkInformation localNetworkInformation = NetworkMonitorAutoDetect.this.connectivityManagerDelegate.networkToInfo(paramNetwork);
      if (localNetworkInformation != null)
        NetworkMonitorAutoDetect.this.observer.onNetworkConnect(localNetworkInformation);
    }

    public void onAvailable(Network paramNetwork)
    {
      Logging.d("NetworkMonitorAutoDetect", "Network becomes available: " + paramNetwork.toString());
      onNetworkChanged(paramNetwork);
    }

    public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
    {
      Logging.d("NetworkMonitorAutoDetect", "capabilities changed: " + paramNetworkCapabilities.toString());
      onNetworkChanged(paramNetwork);
    }

    public void onLinkPropertiesChanged(Network paramNetwork, LinkProperties paramLinkProperties)
    {
      Logging.d("NetworkMonitorAutoDetect", "link properties changed: " + paramLinkProperties.toString());
      onNetworkChanged(paramNetwork);
    }

    public void onLosing(Network paramNetwork, int paramInt)
    {
      Logging.d("NetworkMonitorAutoDetect", "Network " + paramNetwork.toString() + " is about to lose in " + paramInt + "ms");
    }

    public void onLost(Network paramNetwork)
    {
      Logging.d("NetworkMonitorAutoDetect", "Network " + paramNetwork.toString() + " is disconnected");
      NetworkMonitorAutoDetect.this.observer.onNetworkDisconnect(NetworkMonitorAutoDetect.networkToNetId(paramNetwork));
    }
  }

  static class WifiDirectManagerDelegate extends BroadcastReceiver
  {
    private static final int WIFI_P2P_NETWORK_HANDLE;
    private final Context context;
    private final NetworkMonitorAutoDetect.Observer observer;

    @Nullable
    private NetworkMonitorAutoDetect.NetworkInformation wifiP2pNetworkInfo = null;

    WifiDirectManagerDelegate(NetworkMonitorAutoDetect.Observer paramObserver, Context paramContext)
    {
      this.context = paramContext;
      this.observer = paramObserver;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
      localIntentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
      paramContext.registerReceiver(this, localIntentFilter);
    }

    private void onWifiP2pGroupChange(@Nullable WifiP2pGroup paramWifiP2pGroup)
    {
      if ((paramWifiP2pGroup == null) || (paramWifiP2pGroup.getInterface() == null))
        return;
      NetworkMonitorAutoDetect.IPAddress[] arrayOfIPAddress;
      try
      {
        NetworkInterface localNetworkInterface = NetworkInterface.getByName(paramWifiP2pGroup.getInterface());
        ArrayList localArrayList = Collections.list(localNetworkInterface.getInetAddresses());
        arrayOfIPAddress = new NetworkMonitorAutoDetect.IPAddress[localArrayList.size()];
        for (int i = 0; i < localArrayList.size(); i++)
          arrayOfIPAddress[i] = new NetworkMonitorAutoDetect.IPAddress(((InetAddress)localArrayList.get(i)).getAddress());
      }
      catch (SocketException localSocketException)
      {
        Logging.e("NetworkMonitorAutoDetect", "Unable to get WifiP2p network interface", localSocketException);
        return;
      }
      this.wifiP2pNetworkInfo = new NetworkMonitorAutoDetect.NetworkInformation(paramWifiP2pGroup.getInterface(), NetworkMonitorAutoDetect.ConnectionType.CONNECTION_WIFI, NetworkMonitorAutoDetect.ConnectionType.CONNECTION_NONE, 0L, arrayOfIPAddress);
      this.observer.onNetworkConnect(this.wifiP2pNetworkInfo);
    }

    private void onWifiP2pStateChange(int paramInt)
    {
      if (paramInt == 1)
      {
        this.wifiP2pNetworkInfo = null;
        this.observer.onNetworkDisconnect(0L);
      }
    }

    public List<NetworkMonitorAutoDetect.NetworkInformation> getActiveNetworkList()
    {
      if (this.wifiP2pNetworkInfo != null)
        return Collections.singletonList(this.wifiP2pNetworkInfo);
      return Collections.emptyList();
    }

    @SuppressLint({"InlinedApi"})
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.net.wifi.p2p.CONNECTION_STATE_CHANGE".equals(paramIntent.getAction()))
        onWifiP2pGroupChange((WifiP2pGroup)paramIntent.getParcelableExtra("p2pGroupInfo"));
      while (!"android.net.wifi.p2p.STATE_CHANGED".equals(paramIntent.getAction()))
        return;
      onWifiP2pStateChange(paramIntent.getIntExtra("wifi_p2p_state", 0));
    }

    public void release()
    {
      this.context.unregisterReceiver(this);
    }
  }

  static class WifiManagerDelegate
  {

    @Nullable
    private final Context context;

    WifiManagerDelegate()
    {
      this.context = null;
    }

    WifiManagerDelegate(Context paramContext)
    {
      this.context = paramContext;
    }

    String getWifiSSID()
    {
      Intent localIntent = this.context.registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
      if (localIntent != null)
      {
        WifiInfo localWifiInfo = (WifiInfo)localIntent.getParcelableExtra("wifiInfo");
        if (localWifiInfo != null)
        {
          String str = localWifiInfo.getSSID();
          if (str != null)
            return str;
        }
      }
      return "";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.NetworkMonitorAutoDetect
 * JD-Core Version:    0.6.2
 */