package com.viber.voip.pixie;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PixieProxySelector extends ProxySelector
{
  private static final Logger L = ViberEnv.getLogger();
  private final HashSet<String> frontDomains;
  private boolean mShouldRedirect = true;
  private List<Proxy> noProxy;
  private List<Proxy> pixieProxy = new LinkedList();

  public PixieProxySelector(Proxy paramProxy, HashSet<String> paramHashSet)
  {
    this.pixieProxy.add(paramProxy);
    this.noProxy = new LinkedList();
    this.noProxy.add(Proxy.NO_PROXY);
    this.frontDomains = paramHashSet;
  }

  private boolean isFrontingDomain(String paramString)
  {
    return this.frontDomains.contains(paramString.toLowerCase());
  }

  public void connectFailed(URI paramURI, SocketAddress paramSocketAddress, IOException paramIOException)
  {
  }

  public void redirect(boolean paramBoolean)
  {
    this.mShouldRedirect = paramBoolean;
  }

  public List<Proxy> select(URI paramURI)
  {
    try
    {
      if (isFrontingDomain(paramURI.getAuthority()))
      {
        List localList = this.noProxy;
        return localList;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      String str = paramURI.getScheme();
      if ((this.mShouldRedirect) && (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str))))
        return this.pixieProxy;
    }
    return this.noProxy;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.PixieProxySelector
 * JD-Core Version:    0.6.2
 */