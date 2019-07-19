package twitter4j;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

public final class TwitterFactory
  implements Serializable
{
  static final Authorization DEFAULT_AUTHORIZATION = AuthorizationFactory.getInstance(ConfigurationContext.getInstance());
  private static final Twitter SINGLETON;
  private static final Constructor<Twitter> TWITTER_CONSTRUCTOR;
  private static final long serialVersionUID = 5193900138477709155L;
  private final Configuration conf;

  // ERROR //
  static
  {
    // Byte code:
    //   0: invokestatic 37	twitter4j/conf/ConfigurationContext:getInstance	()Ltwitter4j/conf/Configuration;
    //   3: invokestatic 42	twitter4j/auth/AuthorizationFactory:getInstance	(Ltwitter4j/conf/Configuration;)Ltwitter4j/auth/Authorization;
    //   6: putstatic 44	twitter4j/TwitterFactory:DEFAULT_AUTHORIZATION	Ltwitter4j/auth/Authorization;
    //   9: invokestatic 37	twitter4j/conf/ConfigurationContext:getInstance	()Ltwitter4j/conf/Configuration;
    //   12: invokeinterface 50 1 0
    //   17: istore_0
    //   18: aconst_null
    //   19: astore_1
    //   20: iload_0
    //   21: ifeq +12 -> 33
    //   24: ldc 52
    //   26: invokestatic 58	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   29: pop
    //   30: ldc 52
    //   32: astore_1
    //   33: aload_1
    //   34: ifnonnull +6 -> 40
    //   37: ldc 60
    //   39: astore_1
    //   40: aload_1
    //   41: invokestatic 58	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   44: iconst_2
    //   45: anewarray 54	java/lang/Class
    //   48: dup
    //   49: iconst_0
    //   50: ldc 46
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: ldc 62
    //   57: aastore
    //   58: invokevirtual 66	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   61: astore 4
    //   63: aload 4
    //   65: putstatic 68	twitter4j/TwitterFactory:TWITTER_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
    //   68: getstatic 68	twitter4j/TwitterFactory:TWITTER_CONSTRUCTOR	Ljava/lang/reflect/Constructor;
    //   71: astore 8
    //   73: iconst_2
    //   74: anewarray 4	java/lang/Object
    //   77: astore 9
    //   79: aload 9
    //   81: iconst_0
    //   82: invokestatic 37	twitter4j/conf/ConfigurationContext:getInstance	()Ltwitter4j/conf/Configuration;
    //   85: aastore
    //   86: aload 9
    //   88: iconst_1
    //   89: getstatic 44	twitter4j/TwitterFactory:DEFAULT_AUTHORIZATION	Ltwitter4j/auth/Authorization;
    //   92: aastore
    //   93: aload 8
    //   95: aload 9
    //   97: invokevirtual 74	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 76	twitter4j/Twitter
    //   103: putstatic 78	twitter4j/TwitterFactory:SINGLETON	Ltwitter4j/Twitter;
    //   106: return
    //   107: astore_3
    //   108: new 80	java/lang/AssertionError
    //   111: dup
    //   112: aload_3
    //   113: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   116: athrow
    //   117: astore_2
    //   118: new 80	java/lang/AssertionError
    //   121: dup
    //   122: aload_2
    //   123: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   126: athrow
    //   127: astore 7
    //   129: new 80	java/lang/AssertionError
    //   132: dup
    //   133: aload 7
    //   135: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   138: athrow
    //   139: astore 6
    //   141: new 80	java/lang/AssertionError
    //   144: dup
    //   145: aload 6
    //   147: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   150: athrow
    //   151: astore 5
    //   153: new 80	java/lang/AssertionError
    //   156: dup
    //   157: aload 5
    //   159: invokespecial 84	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   162: athrow
    //   163: astore 10
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -134 -> 33
    //
    // Exception table:
    //   from	to	target	type
    //   40	63	107	java/lang/NoSuchMethodException
    //   40	63	117	java/lang/ClassNotFoundException
    //   68	106	127	java/lang/InstantiationException
    //   68	106	139	java/lang/IllegalAccessException
    //   68	106	151	java/lang/reflect/InvocationTargetException
    //   24	30	163	java/lang/ClassNotFoundException
  }

  public TwitterFactory()
  {
    this(ConfigurationContext.getInstance());
  }

  public TwitterFactory(String paramString)
  {
    this(ConfigurationContext.getInstance(paramString));
  }

  public TwitterFactory(Configuration paramConfiguration)
  {
    if (paramConfiguration == null)
      throw new NullPointerException("configuration cannot be null");
    this.conf = paramConfiguration;
  }

  public static Twitter getSingleton()
  {
    return SINGLETON;
  }

  public Twitter getInstance()
  {
    return getInstance(AuthorizationFactory.getInstance(this.conf));
  }

  public Twitter getInstance(AccessToken paramAccessToken)
  {
    String str1 = this.conf.getOAuthConsumerKey();
    String str2 = this.conf.getOAuthConsumerSecret();
    if ((str1 == null) && (str2 == null))
      throw new IllegalStateException("Consumer key and Consumer secret not supplied.");
    OAuthAuthorization localOAuthAuthorization = new OAuthAuthorization(this.conf);
    localOAuthAuthorization.setOAuthAccessToken(paramAccessToken);
    return getInstance(localOAuthAuthorization);
  }

  public Twitter getInstance(Authorization paramAuthorization)
  {
    try
    {
      Constructor localConstructor = TWITTER_CONSTRUCTOR;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.conf;
      arrayOfObject[1] = paramAuthorization;
      Twitter localTwitter = (Twitter)localConstructor.newInstance(arrayOfObject);
      return localTwitter;
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
 * Qualified Name:     twitter4j.TwitterFactory
 * JD-Core Version:    0.6.2
 */