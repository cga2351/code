package okhttp3.internal.platform;

import f.c;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

public class Platform
{
  public static final int INFO = 4;
  private static final Platform PLATFORM = findPlatform();
  public static final int WARN = 5;
  private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());

  public static List<String> alpnProtocolNames(List<Protocol> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = paramList.size();
    int j = 0;
    if (j < i)
    {
      Protocol localProtocol = (Protocol)paramList.get(j);
      if (localProtocol == Protocol.HTTP_1_0);
      while (true)
      {
        j++;
        break;
        localArrayList.add(localProtocol.toString());
      }
    }
    return localArrayList;
  }

  static byte[] concatLengthPrefixed(List<Protocol> paramList)
  {
    c localc = new c();
    int i = paramList.size();
    int j = 0;
    if (j < i)
    {
      Protocol localProtocol = (Protocol)paramList.get(j);
      if (localProtocol == Protocol.HTTP_1_0);
      while (true)
      {
        j++;
        break;
        localc.b(localProtocol.toString().length());
        localc.a(localProtocol.toString());
      }
    }
    return localc.u();
  }

  private static Platform findPlatform()
  {
    Object localObject = AndroidPlatform.buildIfSupported();
    if (localObject != null);
    do
    {
      do
      {
        do
        {
          return localObject;
          if (!isConscryptPreferred())
            break;
          localObject = ConscryptPlatform.buildIfSupported();
        }
        while (localObject != null);
        localObject = Jdk9Platform.buildIfSupported();
      }
      while (localObject != null);
      localObject = JdkWithJettyBootPlatform.buildIfSupported();
    }
    while (localObject != null);
    return new Platform();
  }

  public static Platform get()
  {
    return PLATFORM;
  }

  public static boolean isConscryptPreferred()
  {
    if ("conscrypt".equals(System.getProperty("okhttp.platform")))
      return true;
    return "Conscrypt".equals(java.security.Security.getProviders()[0].getName());
  }

  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString)
  {
    Class localClass = paramObject.getClass();
    while (localClass != Object.class)
      try
      {
        Field localField = localClass.getDeclaredField(paramString);
        localField.setAccessible(true);
        Object localObject2 = localField.get(paramObject);
        if ((localObject2 == null) || (!paramClass.isInstance(localObject2)))
          break label114;
        Object localObject3 = paramClass.cast(localObject2);
        return localObject3;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    if (!paramString.equals("delegate"))
    {
      Object localObject1 = readFieldOrNull(paramObject, Object.class, "delegate");
      if (localObject1 != null)
        return readFieldOrNull(localObject1, paramClass, paramString);
    }
    return null;
    label114: return null;
  }

  public void afterHandshake(SSLSocket paramSSLSocket)
  {
  }

  public CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory paramSSLSocketFactory)
  {
    X509TrustManager localX509TrustManager = trustManager(paramSSLSocketFactory);
    if (localX509TrustManager == null)
      throw new IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + paramSSLSocketFactory.getClass());
    return buildCertificateChainCleaner(localX509TrustManager);
  }

  public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager paramX509TrustManager)
  {
    return new BasicCertificateChainCleaner(buildTrustRootIndex(paramX509TrustManager));
  }

  public TrustRootIndex buildTrustRootIndex(X509TrustManager paramX509TrustManager)
  {
    return new BasicTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }

  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
  }

  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }

  public String getPrefix()
  {
    return "OkHttp";
  }

  public SSLContext getSSLContext()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
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
    return null;
  }

  public Object getStackTraceForCloseable(String paramString)
  {
    if (logger.isLoggable(Level.FINE))
      return new Throwable(paramString);
    return null;
  }

  public boolean isCleartextTrafficPermitted(String paramString)
  {
    return true;
  }

  public void log(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt == 5);
    for (Level localLevel = Level.WARNING; ; localLevel = Level.INFO)
    {
      logger.log(localLevel, paramString, paramThrowable);
      return;
    }
  }

  public void logCloseableLeak(String paramString, Object paramObject)
  {
    if (paramObject == null)
      paramString = paramString + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    log(5, paramString, (Throwable)paramObject);
  }

  protected X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      Object localObject = readFieldOrNull(paramSSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
      if (localObject == null)
        return null;
      X509TrustManager localX509TrustManager = (X509TrustManager)readFieldOrNull(localObject, X509TrustManager.class, "trustManager");
      return localX509TrustManager;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.platform.Platform
 * JD-Core Version:    0.6.2
 */