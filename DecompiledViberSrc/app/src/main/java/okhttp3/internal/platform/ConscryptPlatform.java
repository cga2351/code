package okhttp3.internal.platform;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;

public class ConscryptPlatform extends Platform
{
  public static Platform buildIfSupported()
  {
    try
    {
      Class.forName("org.conscrypt.ConscryptEngineSocket");
      if (!Conscrypt.isAvailable())
        return null;
      Conscrypt.setUseEngineSocketByDefault(true);
      ConscryptPlatform localConscryptPlatform = new ConscryptPlatform();
      return localConscryptPlatform;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return null;
  }

  private Provider getProvider()
  {
    return new OpenSSLProvider();
  }

  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket))
    {
      if (paramString != null)
      {
        Conscrypt.setUseSessionTickets(paramSSLSocket, true);
        Conscrypt.setHostname(paramSSLSocket, paramString);
      }
      Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])Platform.alpnProtocolNames(paramList).toArray(new String[0]));
      return;
    }
    super.configureTlsExtensions(paramSSLSocket, paramString, paramList);
  }

  public SSLContext getSSLContext()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS", getProvider());
      return localSSLContext;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException);
    }
  }

  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket))
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    return super.getSelectedProtocol(paramSSLSocket);
  }

  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    if (!Conscrypt.isConscrypt(paramSSLSocketFactory))
      return super.trustManager(paramSSLSocketFactory);
    try
    {
      Object localObject = readFieldOrNull(paramSSLSocketFactory, Object.class, "sslParameters");
      if (localObject != null)
      {
        X509TrustManager localX509TrustManager = (X509TrustManager)readFieldOrNull(localObject, X509TrustManager.class, "x509TrustManager");
        return localX509TrustManager;
      }
      return null;
    }
    catch (Exception localException)
    {
      throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.platform.ConscryptPlatform
 * JD-Core Version:    0.6.2
 */