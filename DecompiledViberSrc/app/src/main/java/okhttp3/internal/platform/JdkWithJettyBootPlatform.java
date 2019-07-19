package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Protocol;
import okhttp3.internal.Util;

class JdkWithJettyBootPlatform extends Platform
{
  private final Class<?> clientProviderClass;
  private final Method getMethod;
  private final Method putMethod;
  private final Method removeMethod;
  private final Class<?> serverProviderClass;

  JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.putMethod = paramMethod1;
    this.getMethod = paramMethod2;
    this.removeMethod = paramMethod3;
    this.clientProviderClass = paramClass1;
    this.serverProviderClass = paramClass2;
  }

  public static Platform buildIfSupported()
  {
    try
    {
      Class localClass1 = Class.forName("org.eclipse.jetty.alpn.ALPN");
      Class localClass2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
      Class localClass3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
      Class localClass4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
      JdkWithJettyBootPlatform localJdkWithJettyBootPlatform = new JdkWithJettyBootPlatform(localClass1.getMethod("put", new Class[] { SSLSocket.class, localClass2 }), localClass1.getMethod("get", new Class[] { SSLSocket.class }), localClass1.getMethod("remove", new Class[] { SSLSocket.class }), localClass3, localClass4);
      return localJdkWithJettyBootPlatform;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label146: break label146;
    }
  }

  public void afterHandshake(SSLSocket paramSSLSocket)
  {
    try
    {
      this.removeMethod.invoke(null, new Object[] { paramSSLSocket });
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw Util.assertionError("unable to remove alpn", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label19: break label19;
    }
  }

  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    List localList = alpnProtocolNames(paramList);
    try
    {
      ClassLoader localClassLoader = Platform.class.getClassLoader();
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = this.clientProviderClass;
      arrayOfClass[1] = this.serverProviderClass;
      Object localObject = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new JettyNegoProvider(localList));
      this.putMethod.invoke(null, new Object[] { paramSSLSocket, localObject });
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw Util.assertionError("unable to set alpn", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label78: break label78;
    }
  }

  @Nullable
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    String str;
    try
    {
      JettyNegoProvider localJettyNegoProvider = (JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
      if ((!localJettyNegoProvider.unsupported) && (localJettyNegoProvider.selected == null))
      {
        Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
        return null;
      }
      if (localJettyNegoProvider.unsupported)
        str = null;
      else
        str = localJettyNegoProvider.selected;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw Util.assertionError("unable to get selected protocol", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label72: break label72;
    }
    return str;
  }

  private static class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    String selected;
    boolean unsupported;

    JettyNegoProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str1 = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      if (paramArrayOfObject == null)
        paramArrayOfObject = Util.EMPTY_STRING_ARRAY;
      if ((str1.equals("supports")) && (Boolean.TYPE == localClass))
        return Boolean.valueOf(true);
      if ((str1.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.unsupported = true;
        return null;
      }
      if ((str1.equals("protocols")) && (paramArrayOfObject.length == 0))
        return this.protocols;
      if (((str1.equals("selectProtocol")) || (str1.equals("select"))) && (String.class == localClass) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof List)))
      {
        List localList = (List)paramArrayOfObject[0];
        int i = localList.size();
        for (int j = 0; j < i; j++)
          if (this.protocols.contains(localList.get(j)))
          {
            String str3 = (String)localList.get(j);
            this.selected = str3;
            return str3;
          }
        String str2 = (String)this.protocols.get(0);
        this.selected = str2;
        return str2;
      }
      if (((str1.equals("protocolSelected")) || (str1.equals("selected"))) && (paramArrayOfObject.length == 1))
      {
        this.selected = ((String)paramArrayOfObject[0]);
        return null;
      }
      return paramMethod.invoke(this, paramArrayOfObject);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.platform.JdkWithJettyBootPlatform
 * JD-Core Version:    0.6.2
 */