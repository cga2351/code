package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

public final class RouteSelector
{
  private final Address address;
  private final Call call;
  private final EventListener eventListener;
  private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
  private int nextProxyIndex;
  private final List<Route> postponedRoutes = new ArrayList();
  private List<Proxy> proxies = Collections.emptyList();
  private final RouteDatabase routeDatabase;

  public RouteSelector(Address paramAddress, RouteDatabase paramRouteDatabase, Call paramCall, EventListener paramEventListener)
  {
    this.address = paramAddress;
    this.routeDatabase = paramRouteDatabase;
    this.call = paramCall;
    this.eventListener = paramEventListener;
    resetNextProxy(paramAddress.url(), paramAddress.proxy());
  }

  static String getHostString(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null)
      return paramInetSocketAddress.getHostName();
    return localInetAddress.getHostAddress();
  }

  private boolean hasNextProxy()
  {
    return this.nextProxyIndex < this.proxies.size();
  }

  private Proxy nextProxy()
    throws IOException
  {
    if (!hasNextProxy())
      throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    List localList = this.proxies;
    int i = this.nextProxyIndex;
    this.nextProxyIndex = (i + 1);
    Proxy localProxy = (Proxy)localList.get(i);
    resetNextInetSocketAddress(localProxy);
    return localProxy;
  }

  private void resetNextInetSocketAddress(Proxy paramProxy)
    throws IOException
  {
    this.inetSocketAddresses = new ArrayList();
    String str1;
    int i;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS))
    {
      str1 = this.address.url().host();
      i = this.address.url().port();
    }
    String str2;
    for (Object localObject = str1; (i < 1) || (i > 65535); localObject = str2)
    {
      throw new SocketException("No route to " + (String)localObject + ":" + i + "; port is out of range");
      SocketAddress localSocketAddress = paramProxy.address();
      if (!(localSocketAddress instanceof InetSocketAddress))
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localSocketAddress.getClass());
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)localSocketAddress;
      str2 = getHostString(localInetSocketAddress);
      i = localInetSocketAddress.getPort();
    }
    if (paramProxy.type() == Proxy.Type.SOCKS)
      this.inetSocketAddresses.add(InetSocketAddress.createUnresolved((String)localObject, i));
    while (true)
    {
      return;
      this.eventListener.dnsStart(this.call, (String)localObject);
      List localList = this.address.dns().lookup((String)localObject);
      if (localList.isEmpty())
        throw new UnknownHostException(this.address.dns() + " returned no addresses for " + (String)localObject);
      this.eventListener.dnsEnd(this.call, (String)localObject, localList);
      int j = localList.size();
      for (int k = 0; k < j; k++)
      {
        InetAddress localInetAddress = (InetAddress)localList.get(k);
        this.inetSocketAddresses.add(new InetSocketAddress(localInetAddress, i));
      }
    }
  }

  private void resetNextProxy(HttpUrl paramHttpUrl, Proxy paramProxy)
  {
    if (paramProxy != null)
    {
      this.proxies = Collections.singletonList(paramProxy);
      this.nextProxyIndex = 0;
      return;
    }
    List localList1 = this.address.proxySelector().select(paramHttpUrl.uri());
    if ((localList1 != null) && (!localList1.isEmpty()));
    Proxy[] arrayOfProxy;
    for (List localList2 = Util.immutableList(localList1); ; localList2 = Util.immutableList(arrayOfProxy))
    {
      this.proxies = localList2;
      break;
      arrayOfProxy = new Proxy[1];
      arrayOfProxy[0] = Proxy.NO_PROXY;
    }
  }

  public void connectFailed(Route paramRoute, IOException paramIOException)
  {
    if ((paramRoute.proxy().type() != Proxy.Type.DIRECT) && (this.address.proxySelector() != null))
      this.address.proxySelector().connectFailed(this.address.url().uri(), paramRoute.proxy().address(), paramIOException);
    this.routeDatabase.failed(paramRoute);
  }

  public boolean hasNext()
  {
    return (hasNextProxy()) || (!this.postponedRoutes.isEmpty());
  }

  public Selection next()
    throws IOException
  {
    if (!hasNext())
      throw new NoSuchElementException();
    ArrayList localArrayList = new ArrayList();
    do
    {
      if (!hasNextProxy())
        break;
      Proxy localProxy = nextProxy();
      int i = this.inetSocketAddresses.size();
      int j = 0;
      if (j < i)
      {
        Route localRoute = new Route(this.address, localProxy, (InetSocketAddress)this.inetSocketAddresses.get(j));
        if (this.routeDatabase.shouldPostpone(localRoute))
          this.postponedRoutes.add(localRoute);
        while (true)
        {
          j++;
          break;
          localArrayList.add(localRoute);
        }
      }
    }
    while (localArrayList.isEmpty());
    if (localArrayList.isEmpty())
    {
      localArrayList.addAll(this.postponedRoutes);
      this.postponedRoutes.clear();
    }
    return new Selection(localArrayList);
  }

  public static final class Selection
  {
    private int nextRouteIndex = 0;
    private final List<Route> routes;

    Selection(List<Route> paramList)
    {
      this.routes = paramList;
    }

    public List<Route> getAll()
    {
      return new ArrayList(this.routes);
    }

    public boolean hasNext()
    {
      return this.nextRouteIndex < this.routes.size();
    }

    public Route next()
    {
      if (!hasNext())
        throw new NoSuchElementException();
      List localList = this.routes;
      int i = this.nextRouteIndex;
      this.nextRouteIndex = (i + 1);
      return (Route)localList.get(i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.connection.RouteSelector
 * JD-Core Version:    0.6.2
 */