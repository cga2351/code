package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.Util;

public final class Address
{

  @Nullable
  final CertificatePinner certificatePinner;
  final List<ConnectionSpec> connectionSpecs;
  final Dns dns;

  @Nullable
  final HostnameVerifier hostnameVerifier;
  final List<Protocol> protocols;

  @Nullable
  final Proxy proxy;
  final Authenticator proxyAuthenticator;
  final ProxySelector proxySelector;
  final SocketFactory socketFactory;

  @Nullable
  final SSLSocketFactory sslSocketFactory;
  final HttpUrl url;

  public Address(String paramString, int paramInt, Dns paramDns, SocketFactory paramSocketFactory, @Nullable SSLSocketFactory paramSSLSocketFactory, @Nullable HostnameVerifier paramHostnameVerifier, @Nullable CertificatePinner paramCertificatePinner, Authenticator paramAuthenticator, @Nullable Proxy paramProxy, List<Protocol> paramList, List<ConnectionSpec> paramList1, ProxySelector paramProxySelector)
  {
    HttpUrl.Builder localBuilder = new HttpUrl.Builder();
    if (paramSSLSocketFactory != null);
    for (String str = "https"; ; str = "http")
    {
      this.url = localBuilder.scheme(str).host(paramString).port(paramInt).build();
      if (paramDns != null)
        break;
      throw new NullPointerException("dns == null");
    }
    this.dns = paramDns;
    if (paramSocketFactory == null)
      throw new NullPointerException("socketFactory == null");
    this.socketFactory = paramSocketFactory;
    if (paramAuthenticator == null)
      throw new NullPointerException("proxyAuthenticator == null");
    this.proxyAuthenticator = paramAuthenticator;
    if (paramList == null)
      throw new NullPointerException("protocols == null");
    this.protocols = Util.immutableList(paramList);
    if (paramList1 == null)
      throw new NullPointerException("connectionSpecs == null");
    this.connectionSpecs = Util.immutableList(paramList1);
    if (paramProxySelector == null)
      throw new NullPointerException("proxySelector == null");
    this.proxySelector = paramProxySelector;
    this.proxy = paramProxy;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.certificatePinner = paramCertificatePinner;
  }

  @Nullable
  public CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }

  public List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }

  public Dns dns()
  {
    return this.dns;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Address)) && (this.url.equals(((Address)paramObject).url)) && (equalsNonHost((Address)paramObject));
  }

  boolean equalsNonHost(Address paramAddress)
  {
    return (this.dns.equals(paramAddress.dns)) && (this.proxyAuthenticator.equals(paramAddress.proxyAuthenticator)) && (this.protocols.equals(paramAddress.protocols)) && (this.connectionSpecs.equals(paramAddress.connectionSpecs)) && (this.proxySelector.equals(paramAddress.proxySelector)) && (Util.equal(this.proxy, paramAddress.proxy)) && (Util.equal(this.sslSocketFactory, paramAddress.sslSocketFactory)) && (Util.equal(this.hostnameVerifier, paramAddress.hostnameVerifier)) && (Util.equal(this.certificatePinner, paramAddress.certificatePinner)) && (url().port() == paramAddress.url().port());
  }

  public int hashCode()
  {
    int i = 31 * (31 * (31 * (31 * (31 * (31 * (527 + this.url.hashCode()) + this.dns.hashCode()) + this.proxyAuthenticator.hashCode()) + this.protocols.hashCode()) + this.connectionSpecs.hashCode()) + this.proxySelector.hashCode());
    int j;
    int m;
    label112: int n;
    if (this.proxy != null)
    {
      j = this.proxy.hashCode();
      int k = 31 * (j + i);
      if (this.sslSocketFactory == null)
        break label181;
      m = this.sslSocketFactory.hashCode();
      n = 31 * (m + k);
      if (this.hostnameVerifier == null)
        break label187;
    }
    label181: label187: for (int i1 = this.hostnameVerifier.hashCode(); ; i1 = 0)
    {
      int i2 = 31 * (i1 + n);
      CertificatePinner localCertificatePinner = this.certificatePinner;
      int i3 = 0;
      if (localCertificatePinner != null)
        i3 = this.certificatePinner.hashCode();
      return i2 + i3;
      j = 0;
      break;
      m = 0;
      break label112;
    }
  }

  @Nullable
  public HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }

  public List<Protocol> protocols()
  {
    return this.protocols;
  }

  @Nullable
  public Proxy proxy()
  {
    return this.proxy;
  }

  public Authenticator proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }

  public ProxySelector proxySelector()
  {
    return this.proxySelector;
  }

  public SocketFactory socketFactory()
  {
    return this.socketFactory;
  }

  @Nullable
  public SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Address{").append(this.url.host()).append(":").append(this.url.port());
    if (this.proxy != null)
      localStringBuilder.append(", proxy=").append(this.proxy);
    while (true)
    {
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append(", proxySelector=").append(this.proxySelector);
    }
  }

  public HttpUrl url()
  {
    return this.url;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Address
 * JD-Core Version:    0.6.2
 */