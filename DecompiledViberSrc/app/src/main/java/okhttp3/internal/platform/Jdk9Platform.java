package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.Util;

final class Jdk9Platform extends Platform
{
  final Method getProtocolMethod;
  final Method setProtocolMethod;

  Jdk9Platform(Method paramMethod1, Method paramMethod2)
  {
    this.setProtocolMethod = paramMethod1;
    this.getProtocolMethod = paramMethod2;
  }

  public static Jdk9Platform buildIfSupported()
  {
    try
    {
      Jdk9Platform localJdk9Platform = new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { [Ljava.lang.String.class }), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
      return localJdk9Platform;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return null;
  }

  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    try
    {
      SSLParameters localSSLParameters = paramSSLSocket.getSSLParameters();
      List localList = alpnProtocolNames(paramList);
      Method localMethod = this.setProtocolMethod;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localList.toArray(new String[localList.size()]);
      localMethod.invoke(localSSLParameters, arrayOfObject);
      paramSSLSocket.setSSLParameters(localSSLParameters);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw Util.assertionError("unable to set ssl parameters", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label64: break label64;
    }
  }

  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    try
    {
      String str = (String)this.getProtocolMethod.invoke(paramSSLSocket, new Object[0]);
      if (str != null)
      {
        boolean bool = str.equals("");
        if (!bool);
      }
      else
      {
        str = null;
      }
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw Util.assertionError("unable to get selected protocols", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label38: break label38;
    }
  }

  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.platform.Jdk9Platform
 * JD-Core Version:    0.6.2
 */