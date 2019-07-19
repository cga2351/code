package twitter4j.internal.http;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class HttpClientFactory
{
  private static final Constructor HTTP_CLIENT_CONSTRUCTOR;
  private static final String HTTP_CLIENT_IMPLEMENTATION = "twitter4j.http.httpClient";

  // ERROR //
  static
  {
    // Byte code:
    //   0: ldc 10
    //   2: invokestatic 22	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_0
    //   6: aconst_null
    //   7: astore_1
    //   8: aload_0
    //   9: ifnull +12 -> 21
    //   12: aload_0
    //   13: invokestatic 28	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   16: astore 8
    //   18: aload 8
    //   20: astore_1
    //   21: aload_1
    //   22: ifnonnull +13 -> 35
    //   25: ldc 30
    //   27: invokestatic 28	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   30: astore 6
    //   32: aload 6
    //   34: astore_1
    //   35: aload_1
    //   36: ifnonnull +13 -> 49
    //   39: ldc 32
    //   41: invokestatic 28	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   44: astore 4
    //   46: aload 4
    //   48: astore_1
    //   49: aload_1
    //   50: iconst_1
    //   51: anewarray 24	java/lang/Class
    //   54: dup
    //   55: iconst_0
    //   56: ldc 34
    //   58: aastore
    //   59: invokevirtual 38	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   62: putstatic 40	twitter4j/internal/http/HttpClientFactory:HTTP_CLIENT_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
    //   65: return
    //   66: astore_3
    //   67: new 42	java/lang/AssertionError
    //   70: dup
    //   71: aload_3
    //   72: invokespecial 46	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   75: athrow
    //   76: astore_2
    //   77: new 42	java/lang/AssertionError
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 46	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   85: athrow
    //   86: astore 7
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -69 -> 21
    //   93: astore 5
    //   95: goto -60 -> 35
    //
    // Exception table:
    //   from	to	target	type
    //   39	46	66	java/lang/ClassNotFoundException
    //   49	65	76	java/lang/NoSuchMethodException
    //   12	18	86	java/lang/ClassNotFoundException
    //   25	32	93	java/lang/ClassNotFoundException
  }

  public static HttpClient getInstance(HttpClientConfiguration paramHttpClientConfiguration)
  {
    try
    {
      HttpClient localHttpClient = (HttpClient)HTTP_CLIENT_CONSTRUCTOR.newInstance(new Object[] { paramHttpClientConfiguration });
      return localHttpClient;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new AssertionError(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new AssertionError(localInvocationTargetException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.http.HttpClientFactory
 * JD-Core Version:    0.6.2
 */