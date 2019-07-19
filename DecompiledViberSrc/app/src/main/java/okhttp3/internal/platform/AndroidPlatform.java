package okhttp3.internal.platform;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

class AndroidPlatform extends Platform
{
  private static final int MAX_LOG_LENGTH = 4000;
  private final CloseGuard closeGuard = CloseGuard.get();
  private final OptionalMethod<Socket> getAlpnSelectedProtocol;
  private final OptionalMethod<Socket> setAlpnProtocols;
  private final OptionalMethod<Socket> setHostname;
  private final OptionalMethod<Socket> setUseSessionTickets;
  private final Class<?> sslParametersClass;

  AndroidPlatform(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
  {
    this.sslParametersClass = paramClass;
    this.setUseSessionTickets = paramOptionalMethod1;
    this.setHostname = paramOptionalMethod2;
    this.getAlpnSelectedProtocol = paramOptionalMethod3;
    this.setAlpnProtocols = paramOptionalMethod4;
  }

  private boolean api23IsCleartextTrafficPermitted(String paramString, Class<?> paramClass, Object paramObject)
    throws InvocationTargetException, IllegalAccessException
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return super.isCleartextTrafficPermitted(paramString);
  }

  private boolean api24IsCleartextTrafficPermitted(String paramString, Class<?> paramClass, Object paramObject)
    throws InvocationTargetException, IllegalAccessException
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(paramObject, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return api23IsCleartextTrafficPermitted(paramString, paramClass, paramObject);
  }

  public static Platform buildIfSupported()
  {
    while (true)
    {
      try
      {
        Class localClass2 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        localObject = localClass2;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          Object localObject;
          Class[] arrayOfClass = new Class[1];
          arrayOfClass[0] = Boolean.TYPE;
          OptionalMethod localOptionalMethod1 = new OptionalMethod(null, "setUseSessionTickets", arrayOfClass);
          OptionalMethod localOptionalMethod2 = new OptionalMethod(null, "setHostname", new Class[] { String.class });
          if (supportsAlpn())
          {
            localOptionalMethod3 = new OptionalMethod([B.class, "getAlpnSelectedProtocol", new Class[0]);
            localOptionalMethod4 = new OptionalMethod(null, "setAlpnProtocols", new Class[] { [B.class });
            return new AndroidPlatform((Class)localObject, localOptionalMethod1, localOptionalMethod2, localOptionalMethod3, localOptionalMethod4);
            localClassNotFoundException1 = localClassNotFoundException1;
            Class localClass1 = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            localObject = localClass1;
            continue;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          return null;
        }
      }
      OptionalMethod localOptionalMethod3 = null;
      OptionalMethod localOptionalMethod4 = null;
    }
  }

  private static boolean supportsAlpn()
  {
    if (Security.getProvider("GMSCore_OpenSSL") != null)
      return true;
    try
    {
      Class.forName("android.net.Network");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }

  public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Class localClass = Class.forName("android.net.http.X509TrustManagerExtensions");
      AndroidCertificateChainCleaner localAndroidCertificateChainCleaner = new AndroidCertificateChainCleaner(localClass.getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager }), localClass.getMethod("checkServerTrusted", new Class[] { [Ljava.security.cert.X509Certificate.class, String.class, String.class }));
      return localAndroidCertificateChainCleaner;
    }
    catch (Exception localException)
    {
    }
    return super.buildCertificateChainCleaner(paramX509TrustManager);
  }

  public TrustRootIndex buildTrustRootIndex(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Method localMethod = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      localMethod.setAccessible(true);
      AndroidTrustRootIndex localAndroidTrustRootIndex = new AndroidTrustRootIndex(paramX509TrustManager, localMethod);
      return localAndroidTrustRootIndex;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return super.buildTrustRootIndex(paramX509TrustManager);
  }

  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    if (paramString != null)
    {
      OptionalMethod localOptionalMethod = this.setUseSessionTickets;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Boolean.valueOf(true);
      localOptionalMethod.invokeOptionalWithoutCheckedException(paramSSLSocket, arrayOfObject2);
      this.setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
    }
    if ((this.setAlpnProtocols != null) && (this.setAlpnProtocols.isSupported(paramSSLSocket)))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = concatLengthPrefixed(paramList);
      this.setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, arrayOfObject1);
    }
  }

  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      if (Util.isAndroidGetsocknameError(localAssertionError))
        throw new IOException(localAssertionError);
      throw localAssertionError;
    }
    catch (SecurityException localSecurityException)
    {
      IOException localIOException2 = new IOException("Exception in connect");
      localIOException2.initCause(localSecurityException);
      throw localIOException2;
    }
    catch (ClassCastException localClassCastException)
    {
      if (Build.VERSION.SDK_INT == 26)
      {
        IOException localIOException1 = new IOException("Exception in connect");
        localIOException1.initCause(localClassCastException);
        throw localIOException1;
      }
      throw localClassCastException;
    }
  }

  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    if (this.getAlpnSelectedProtocol == null);
    while (!this.getAlpnSelectedProtocol.isSupported(paramSSLSocket))
      return null;
    byte[] arrayOfByte = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
    if (arrayOfByte != null);
    for (String str = new String(arrayOfByte, Util.UTF_8); ; str = null)
      return str;
  }

  public Object getStackTraceForCloseable(String paramString)
  {
    return this.closeGuard.createAndOpen(paramString);
  }

  public boolean isCleartextTrafficPermitted(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.security.NetworkSecurityPolicy");
      boolean bool = api24IsCleartextTrafficPermitted(paramString, localClass, localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return super.isCleartextTrafficPermitted(paramString);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw Util.assertionError("unable to determine cleartext support", localIllegalAccessException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label47;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label47;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label40: label47: break label40;
    }
  }

  public void log(int paramInt, String paramString, Throwable paramThrowable)
  {
    int i;
    int j;
    int k;
    label48: int m;
    if (paramInt == 5)
    {
      i = 5;
      if (paramThrowable != null)
        paramString = paramString + '\n' + Log.getStackTraceString(paramThrowable);
      j = 0;
      k = paramString.length();
      if (j >= k)
        break label130;
      m = paramString.indexOf('\n', j);
      if (m == -1)
        break label123;
    }
    while (true)
    {
      int n = Math.min(m, j + 4000);
      Log.println(i, "OkHttp", paramString.substring(j, n));
      if (n >= m)
      {
        j = n + 1;
        break label48;
        i = 3;
        break;
        label123: m = k;
        continue;
        label130: return;
      }
      j = n;
    }
  }

  public void logCloseableLeak(String paramString, Object paramObject)
  {
    if (!this.closeGuard.warnIfOpen(paramObject))
      log(5, paramString, null);
  }

  protected X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Object localObject1 = readFieldOrNull(paramSSLSocketFactory, this.sslParametersClass, "sslParameters");
    if (localObject1 == null);
    while (true)
    {
      try
      {
        Object localObject3 = readFieldOrNull(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
        localObject2 = localObject3;
        X509TrustManager localX509TrustManager = (X509TrustManager)readFieldOrNull(localObject2, X509TrustManager.class, "x509TrustManager");
        if (localX509TrustManager != null)
          return localX509TrustManager;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return super.trustManager(paramSSLSocketFactory);
      }
      return (X509TrustManager)readFieldOrNull(localObject2, X509TrustManager.class, "trustManager");
      Object localObject2 = localObject1;
    }
  }

  static final class AndroidCertificateChainCleaner extends CertificateChainCleaner
  {
    private final Method checkServerTrusted;
    private final Object x509TrustManagerExtensions;

    AndroidCertificateChainCleaner(Object paramObject, Method paramMethod)
    {
      this.x509TrustManagerExtensions = paramObject;
      this.checkServerTrusted = paramMethod;
    }

    public List<Certificate> clean(List<Certificate> paramList, String paramString)
      throws SSLPeerUnverifiedException
    {
      try
      {
        X509Certificate[] arrayOfX509Certificate = (X509Certificate[])paramList.toArray(new X509Certificate[paramList.size()]);
        List localList = (List)this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[] { arrayOfX509Certificate, "RSA", paramString });
        return localList;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        SSLPeerUnverifiedException localSSLPeerUnverifiedException = new SSLPeerUnverifiedException(localInvocationTargetException.getMessage());
        localSSLPeerUnverifiedException.initCause(localInvocationTargetException);
        throw localSSLPeerUnverifiedException;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
    }

    public boolean equals(Object paramObject)
    {
      return paramObject instanceof AndroidCertificateChainCleaner;
    }

    public int hashCode()
    {
      return 0;
    }
  }

  static final class AndroidTrustRootIndex
    implements TrustRootIndex
  {
    private final Method findByIssuerAndSignatureMethod;
    private final X509TrustManager trustManager;

    AndroidTrustRootIndex(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      this.findByIssuerAndSignatureMethod = paramMethod;
      this.trustManager = paramX509TrustManager;
    }

    public boolean equals(Object paramObject)
    {
      if (paramObject == this);
      AndroidTrustRootIndex localAndroidTrustRootIndex;
      do
      {
        return true;
        if (!(paramObject instanceof AndroidTrustRootIndex))
          return false;
        localAndroidTrustRootIndex = (AndroidTrustRootIndex)paramObject;
      }
      while ((this.trustManager.equals(localAndroidTrustRootIndex.trustManager)) && (this.findByIssuerAndSignatureMethod.equals(localAndroidTrustRootIndex.findByIssuerAndSignatureMethod)));
      return false;
    }

    public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
    {
      try
      {
        TrustAnchor localTrustAnchor = (TrustAnchor)this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[] { paramX509Certificate });
        if (localTrustAnchor != null)
        {
          X509Certificate localX509Certificate = localTrustAnchor.getTrustedCert();
          return localX509Certificate;
        }
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw Util.assertionError("unable to get issues and signature", localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
      }
      return null;
    }

    public int hashCode()
    {
      return this.trustManager.hashCode() + 31 * this.findByIssuerAndSignatureMethod.hashCode();
    }
  }

  static final class CloseGuard
  {
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    CloseGuard(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.getMethod = paramMethod1;
      this.openMethod = paramMethod2;
      this.warnIfOpenMethod = paramMethod3;
    }

    static CloseGuard get()
    {
      try
      {
        Class localClass = Class.forName("dalvik.system.CloseGuard");
        localMethod3 = localClass.getMethod("get", new Class[0]);
        localMethod2 = localClass.getMethod("open", new Class[] { String.class });
        Method localMethod4 = localClass.getMethod("warnIfOpen", new Class[0]);
        localMethod1 = localMethod4;
        return new CloseGuard(localMethod3, localMethod2, localMethod1);
      }
      catch (Exception localException)
      {
        while (true)
        {
          Method localMethod1 = null;
          Method localMethod2 = null;
          Method localMethod3 = null;
        }
      }
    }

    Object createAndOpen(String paramString)
    {
      if (this.getMethod != null)
        try
        {
          Object localObject = this.getMethod.invoke(null, new Object[0]);
          this.openMethod.invoke(localObject, new Object[] { paramString });
          return localObject;
        }
        catch (Exception localException)
        {
        }
      return null;
    }

    boolean warnIfOpen(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != null);
      try
      {
        this.warnIfOpenMethod.invoke(paramObject, new Object[0]);
        bool = true;
        return bool;
      }
      catch (Exception localException)
      {
      }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.platform.AndroidPlatform
 * JD-Core Version:    0.6.2
 */