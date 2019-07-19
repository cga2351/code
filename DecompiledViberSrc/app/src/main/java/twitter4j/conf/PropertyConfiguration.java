package twitter4j.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import twitter4j.internal.util.z_T4JInternalStringUtil;

public final class PropertyConfiguration extends ConfigurationBase
  implements Serializable
{
  public static final String APPLICATION_ONLY_AUTH_ENABLED = "enableApplicationOnlyAuth";
  public static final String ASYNC_DISPATCHER_IMPL = "async.dispatcherImpl";
  public static final String ASYNC_NUM_THREADS = "async.numThreads";
  public static final String CLIENT_URL = "clientURL";
  public static final String CLIENT_VERSION = "clientVersion";
  public static final String CONTRIBUTING_TO = "contributingTo";
  public static final String DEBUG = "debug";
  public static final String HTTP_CONNECTION_TIMEOUT = "http.connectionTimeout";
  public static final String HTTP_DEFAULT_MAX_PER_ROUTE = "http.defaultMaxPerRoute";
  public static final String HTTP_GZIP = "http.gzip";
  public static final String HTTP_MAX_TOTAL_CONNECTIONS = "http.maxTotalConnections";
  public static final String HTTP_PRETTY_DEBUG = "http.prettyDebug";
  public static final String HTTP_PROXY_HOST = "http.proxyHost";
  public static final String HTTP_PROXY_HOST_FALLBACK = "http.proxyHost";
  public static final String HTTP_PROXY_PASSWORD = "http.proxyPassword";
  public static final String HTTP_PROXY_PORT = "http.proxyPort";
  public static final String HTTP_PROXY_PORT_FALLBACK = "http.proxyPort";
  public static final String HTTP_PROXY_USER = "http.proxyUser";
  public static final String HTTP_READ_TIMEOUT = "http.readTimeout";
  public static final String HTTP_RETRY_COUNT = "http.retryCount";
  public static final String HTTP_RETRY_INTERVAL_SECS = "http.retryIntervalSecs";
  public static final String HTTP_STREAMING_READ_TIMEOUT = "http.streamingReadTimeout";
  public static final String HTTP_USER_AGENT = "http.userAgent";
  public static final String HTTP_USE_SSL = "http.useSSL";
  public static final String INCLUDE_ENTITIES = "includeEntities";
  public static final String INCLUDE_MY_RETWEET = "includeMyRetweet";
  public static final String INCLUDE_RTS = "includeRTs";
  public static final String JSON_STORE_ENABLED = "jsonStoreEnabled";
  public static final String LOGGER_FACTORY = "loggerFactory";
  public static final String MBEAN_ENABLED = "mbeanEnabled";
  public static final String MEDIA_PROVIDER = "media.provider";
  public static final String MEDIA_PROVIDER_API_KEY = "media.providerAPIKey";
  public static final String MEDIA_PROVIDER_PARAMETERS = "media.providerParameters";
  public static final String OAUTH2_ACCESS_TOKEN = "oauth2.accessToken";
  public static final String OAUTH2_INVALIDATE_TOKEN_URL = "oauth2.invalidateTokenURL";
  public static final String OAUTH2_TOKEN_TYPE = "oauth2.tokenType";
  public static final String OAUTH2_TOKEN_URL = "oauth2.tokenURL";
  public static final String OAUTH_ACCESS_TOKEN = "oauth.accessToken";
  public static final String OAUTH_ACCESS_TOKEN_SECRET = "oauth.accessTokenSecret";
  public static final String OAUTH_ACCESS_TOKEN_URL = "oauth.accessTokenURL";
  public static final String OAUTH_AUTHENTICATION_URL = "oauth.authenticationURL";
  public static final String OAUTH_AUTHORIZATION_URL = "oauth.authorizationURL";
  public static final String OAUTH_CONSUMER_KEY = "oauth.consumerKey";
  public static final String OAUTH_CONSUMER_SECRET = "oauth.consumerSecret";
  public static final String OAUTH_REQUEST_TOKEN_URL = "oauth.requestTokenURL";
  public static final String PASSWORD = "password";
  public static final String REST_BASE_URL = "restBaseURL";
  public static final String SITE_STREAM_BASE_URL = "siteStreamBaseURL";
  public static final String STREAM_BASE_URL = "streamBaseURL";
  public static final String STREAM_STALL_WARNINGS_ENABLED = "stream.enableStallWarnings";
  public static final String STREAM_USER_REPLIES_ALL = "stream.user.repliesAll";
  public static final String USER = "user";
  public static final String USER_STREAM_BASE_URL = "userStreamBaseURL";
  private static final long serialVersionUID = 6458764415636588373L;

  PropertyConfiguration()
  {
    this("/");
  }

  public PropertyConfiguration(InputStream paramInputStream)
  {
    Properties localProperties = new Properties();
    loadProperties(localProperties, paramInputStream);
    setFieldsWithTreePath(localProperties, "/");
  }

  PropertyConfiguration(String paramString)
  {
    try
    {
      localProperties = (Properties)System.getProperties().clone();
      try
      {
        Map localMap = System.getenv();
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localProperties.setProperty(str, (String)localMap.get(str));
        }
      }
      catch (SecurityException localSecurityException3)
      {
        normalize(localProperties);
      }
      loadProperties(localProperties, "." + File.separatorChar + "twitter4j.properties");
      loadProperties(localProperties, Configuration.class.getResourceAsStream("/twitter4j.properties"));
      loadProperties(localProperties, Configuration.class.getResourceAsStream("/WEB-INF/twitter4j.properties"));
    }
    catch (SecurityException localSecurityException1)
    {
      try
      {
        loadProperties(localProperties, new FileInputStream("WEB-INF/twitter4j.properties"));
        label163: setFieldsWithTreePath(localProperties, paramString);
        return;
        localSecurityException1 = localSecurityException1;
        Properties localProperties = new Properties();
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        break label163;
      }
      catch (SecurityException localSecurityException2)
      {
        break label163;
      }
    }
  }

  public PropertyConfiguration(Properties paramProperties)
  {
    this(paramProperties, "/");
  }

  public PropertyConfiguration(Properties paramProperties, String paramString)
  {
    setFieldsWithTreePath(paramProperties, paramString);
  }

  private boolean loadProperties(Properties paramProperties, InputStream paramInputStream)
  {
    try
    {
      paramProperties.load(paramInputStream);
      normalize(paramProperties);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  // ERROR //
  private boolean loadProperties(Properties paramProperties, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 251	java/io/File
    //   5: dup
    //   6: aload_2
    //   7: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: invokevirtual 297	java/io/File:exists	()Z
    //   17: ifeq +45 -> 62
    //   20: aload 4
    //   22: invokevirtual 300	java/io/File:isFile	()Z
    //   25: ifeq +37 -> 62
    //   28: new 281	java/io/FileInputStream
    //   31: dup
    //   32: aload 4
    //   34: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: astore 6
    //   39: aload_1
    //   40: aload 6
    //   42: invokevirtual 291	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   45: aload_0
    //   46: aload_1
    //   47: invokespecial 240	twitter4j/conf/PropertyConfiguration:normalize	(Ljava/util/Properties;)V
    //   50: aload 6
    //   52: ifnull +8 -> 60
    //   55: aload 6
    //   57: invokevirtual 306	java/io/FileInputStream:close	()V
    //   60: iconst_1
    //   61: ireturn
    //   62: iconst_0
    //   63: ifeq +7 -> 70
    //   66: aconst_null
    //   67: invokevirtual 306	java/io/FileInputStream:close	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: astore 9
    //   74: aload_3
    //   75: ifnull -5 -> 70
    //   78: aload_3
    //   79: invokevirtual 306	java/io/FileInputStream:close	()V
    //   82: goto -12 -> 70
    //   85: astore 10
    //   87: goto -17 -> 70
    //   90: astore 5
    //   92: aconst_null
    //   93: astore 6
    //   95: aload 5
    //   97: astore 7
    //   99: aload 6
    //   101: ifnull +8 -> 109
    //   104: aload 6
    //   106: invokevirtual 306	java/io/FileInputStream:close	()V
    //   109: aload 7
    //   111: athrow
    //   112: astore 13
    //   114: iconst_1
    //   115: ireturn
    //   116: astore 11
    //   118: goto -48 -> 70
    //   121: astore 8
    //   123: goto -14 -> 109
    //   126: astore 7
    //   128: goto -29 -> 99
    //   131: astore 12
    //   133: aload 6
    //   135: astore_3
    //   136: goto -62 -> 74
    //
    // Exception table:
    //   from	to	target	type
    //   2	39	72	java/lang/Exception
    //   78	82	85	java/io/IOException
    //   2	39	90	finally
    //   55	60	112	java/io/IOException
    //   66	70	116	java/io/IOException
    //   104	109	121	java/io/IOException
    //   39	50	126	finally
    //   39	50	131	java/lang/Exception
  }

  private void normalize(Properties paramProperties)
  {
    Set localSet = paramProperties.keySet();
    ArrayList localArrayList = new ArrayList(10);
    Iterator localIterator1 = localSet.iterator();
    while (localIterator1.hasNext())
    {
      String str3 = (String)localIterator1.next();
      if (-1 != str3.indexOf("twitter4j."))
        localArrayList.add(str3);
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      String str2 = paramProperties.getProperty(str1);
      int i = str1.indexOf("twitter4j.");
      paramProperties.setProperty(str1.substring(0, i) + str1.substring(i + 10), str2);
    }
  }

  private boolean notNull(Properties paramProperties, String paramString1, String paramString2)
  {
    return paramProperties.getProperty(paramString1 + paramString2) != null;
  }

  private void setFieldsWithPrefix(Properties paramProperties, String paramString)
  {
    if (notNull(paramProperties, paramString, "debug"))
      setDebug(getBoolean(paramProperties, paramString, "debug"));
    if (notNull(paramProperties, paramString, "user"))
      setUser(getString(paramProperties, paramString, "user"));
    if (notNull(paramProperties, paramString, "password"))
      setPassword(getString(paramProperties, paramString, "password"));
    if (notNull(paramProperties, paramString, "http.useSSL"))
      setUseSSL(getBoolean(paramProperties, paramString, "http.useSSL"));
    if (notNull(paramProperties, paramString, "http.prettyDebug"))
      setPrettyDebugEnabled(getBoolean(paramProperties, paramString, "http.prettyDebug"));
    if (notNull(paramProperties, paramString, "http.gzip"))
      setGZIPEnabled(getBoolean(paramProperties, paramString, "http.gzip"));
    if (notNull(paramProperties, paramString, "http.proxyHost"))
    {
      setHttpProxyHost(getString(paramProperties, paramString, "http.proxyHost"));
      if (notNull(paramProperties, paramString, "http.proxyUser"))
        setHttpProxyUser(getString(paramProperties, paramString, "http.proxyUser"));
      if (notNull(paramProperties, paramString, "http.proxyPassword"))
        setHttpProxyPassword(getString(paramProperties, paramString, "http.proxyPassword"));
      if (!notNull(paramProperties, paramString, "http.proxyPort"))
        break label1257;
      setHttpProxyPort(getIntProperty(paramProperties, paramString, "http.proxyPort"));
    }
    Properties localProperties;
    while (true)
    {
      if (notNull(paramProperties, paramString, "http.connectionTimeout"))
        setHttpConnectionTimeout(getIntProperty(paramProperties, paramString, "http.connectionTimeout"));
      if (notNull(paramProperties, paramString, "http.readTimeout"))
        setHttpReadTimeout(getIntProperty(paramProperties, paramString, "http.readTimeout"));
      if (notNull(paramProperties, paramString, "http.streamingReadTimeout"))
        setHttpStreamingReadTimeout(getIntProperty(paramProperties, paramString, "http.streamingReadTimeout"));
      if (notNull(paramProperties, paramString, "http.retryCount"))
        setHttpRetryCount(getIntProperty(paramProperties, paramString, "http.retryCount"));
      if (notNull(paramProperties, paramString, "http.retryIntervalSecs"))
        setHttpRetryIntervalSeconds(getIntProperty(paramProperties, paramString, "http.retryIntervalSecs"));
      if (notNull(paramProperties, paramString, "http.maxTotalConnections"))
        setHttpMaxTotalConnections(getIntProperty(paramProperties, paramString, "http.maxTotalConnections"));
      if (notNull(paramProperties, paramString, "http.defaultMaxPerRoute"))
        setHttpDefaultMaxPerRoute(getIntProperty(paramProperties, paramString, "http.defaultMaxPerRoute"));
      if (notNull(paramProperties, paramString, "oauth.consumerKey"))
        setOAuthConsumerKey(getString(paramProperties, paramString, "oauth.consumerKey"));
      if (notNull(paramProperties, paramString, "oauth.consumerSecret"))
        setOAuthConsumerSecret(getString(paramProperties, paramString, "oauth.consumerSecret"));
      if (notNull(paramProperties, paramString, "oauth.accessToken"))
        setOAuthAccessToken(getString(paramProperties, paramString, "oauth.accessToken"));
      if (notNull(paramProperties, paramString, "oauth.accessTokenSecret"))
        setOAuthAccessTokenSecret(getString(paramProperties, paramString, "oauth.accessTokenSecret"));
      if (notNull(paramProperties, paramString, "oauth2.tokenType"))
        setOAuth2TokenType(getString(paramProperties, paramString, "oauth2.tokenType"));
      if (notNull(paramProperties, paramString, "oauth2.accessToken"))
        setOAuth2AccessToken(getString(paramProperties, paramString, "oauth2.accessToken"));
      if (notNull(paramProperties, paramString, "async.numThreads"))
        setAsyncNumThreads(getIntProperty(paramProperties, paramString, "async.numThreads"));
      if (notNull(paramProperties, paramString, "contributingTo"))
        setContributingTo(getLongProperty(paramProperties, paramString, "contributingTo"));
      if (notNull(paramProperties, paramString, "async.dispatcherImpl"))
        setDispatcherImpl(getString(paramProperties, paramString, "async.dispatcherImpl"));
      if (notNull(paramProperties, paramString, "clientVersion"))
        setClientVersion(getString(paramProperties, paramString, "clientVersion"));
      if (notNull(paramProperties, paramString, "clientURL"))
        setClientURL(getString(paramProperties, paramString, "clientURL"));
      if (notNull(paramProperties, paramString, "http.userAgent"))
        setUserAgent(getString(paramProperties, paramString, "http.userAgent"));
      if (notNull(paramProperties, paramString, "oauth.requestTokenURL"))
        setOAuthRequestTokenURL(getString(paramProperties, paramString, "oauth.requestTokenURL"));
      if (notNull(paramProperties, paramString, "oauth.authorizationURL"))
        setOAuthAuthorizationURL(getString(paramProperties, paramString, "oauth.authorizationURL"));
      if (notNull(paramProperties, paramString, "oauth.accessTokenURL"))
        setOAuthAccessTokenURL(getString(paramProperties, paramString, "oauth.accessTokenURL"));
      if (notNull(paramProperties, paramString, "oauth.authenticationURL"))
        setOAuthAuthenticationURL(getString(paramProperties, paramString, "oauth.authenticationURL"));
      if (notNull(paramProperties, paramString, "oauth2.tokenURL"))
        setOAuth2TokenURL(getString(paramProperties, paramString, "oauth2.tokenURL"));
      if (notNull(paramProperties, paramString, "oauth2.invalidateTokenURL"))
        setOAuth2InvalidateTokenURL(getString(paramProperties, paramString, "oauth2.invalidateTokenURL"));
      if (notNull(paramProperties, paramString, "restBaseURL"))
        setRestBaseURL(getString(paramProperties, paramString, "restBaseURL"));
      if (notNull(paramProperties, paramString, "streamBaseURL"))
        setStreamBaseURL(getString(paramProperties, paramString, "streamBaseURL"));
      if (notNull(paramProperties, paramString, "userStreamBaseURL"))
        setUserStreamBaseURL(getString(paramProperties, paramString, "userStreamBaseURL"));
      if (notNull(paramProperties, paramString, "siteStreamBaseURL"))
        setSiteStreamBaseURL(getString(paramProperties, paramString, "siteStreamBaseURL"));
      if (notNull(paramProperties, paramString, "includeRTs"))
        setIncludeRTsEnbled(getBoolean(paramProperties, paramString, "includeRTs"));
      if (notNull(paramProperties, paramString, "includeEntities"))
        setIncludeEntitiesEnbled(getBoolean(paramProperties, paramString, "includeEntities"));
      if (notNull(paramProperties, paramString, "includeMyRetweet"))
        setIncludeMyRetweetEnabled(getBoolean(paramProperties, paramString, "includeMyRetweet"));
      if (notNull(paramProperties, paramString, "loggerFactory"))
        setLoggerFactory(getString(paramProperties, paramString, "loggerFactory"));
      if (notNull(paramProperties, paramString, "jsonStoreEnabled"))
        setJSONStoreEnabled(getBoolean(paramProperties, paramString, "jsonStoreEnabled"));
      if (notNull(paramProperties, paramString, "mbeanEnabled"))
        setMBeanEnabled(getBoolean(paramProperties, paramString, "mbeanEnabled"));
      if (notNull(paramProperties, paramString, "stream.user.repliesAll"))
        setUserStreamRepliesAllEnabled(getBoolean(paramProperties, paramString, "stream.user.repliesAll"));
      if (notNull(paramProperties, paramString, "stream.enableStallWarnings"))
        setStallWarningsEnabled(getBoolean(paramProperties, paramString, "stream.enableStallWarnings"));
      if (notNull(paramProperties, paramString, "enableApplicationOnlyAuth"))
        setApplicationOnlyAuthEnabled(getBoolean(paramProperties, paramString, "enableApplicationOnlyAuth"));
      if (notNull(paramProperties, paramString, "media.provider"))
        setMediaProvider(getString(paramProperties, paramString, "media.provider"));
      if (notNull(paramProperties, paramString, "media.providerAPIKey"))
        setMediaProviderAPIKey(getString(paramProperties, paramString, "media.providerAPIKey"));
      if (!notNull(paramProperties, paramString, "media.providerParameters"))
        break label1289;
      String[] arrayOfString1 = z_T4JInternalStringUtil.split(getString(paramProperties, paramString, "media.providerParameters"), "&");
      localProperties = new Properties();
      int i = arrayOfString1.length;
      for (int j = 0; j < i; j++)
      {
        String[] arrayOfString2 = z_T4JInternalStringUtil.split(arrayOfString1[j], "=");
        localProperties.setProperty(arrayOfString2[0], arrayOfString2[1]);
      }
      if (!notNull(paramProperties, paramString, "http.proxyHost"))
        break;
      setHttpProxyHost(getString(paramProperties, paramString, "http.proxyHost"));
      break;
      label1257: if (notNull(paramProperties, paramString, "http.proxyPort"))
        setHttpProxyPort(getIntProperty(paramProperties, paramString, "http.proxyPort"));
    }
    setMediaProviderParameters(localProperties);
    label1289: cacheInstance();
  }

  private void setFieldsWithTreePath(Properties paramProperties, String paramString)
  {
    setFieldsWithPrefix(paramProperties, "");
    String[] arrayOfString = z_T4JInternalStringUtil.split(paramString, "/");
    int i = arrayOfString.length;
    String str1 = null;
    int j = 0;
    if (j < i)
    {
      String str2 = arrayOfString[j];
      if (!"".equals(str2))
        if (str1 != null)
          break label89;
      label89: for (str1 = str2 + "."; ; str1 = str1 + str2 + ".")
      {
        setFieldsWithPrefix(paramProperties, str1);
        j++;
        break;
      }
    }
  }

  protected boolean getBoolean(Properties paramProperties, String paramString1, String paramString2)
  {
    return Boolean.valueOf(paramProperties.getProperty(paramString1 + paramString2)).booleanValue();
  }

  protected int getIntProperty(Properties paramProperties, String paramString1, String paramString2)
  {
    String str = paramProperties.getProperty(paramString1 + paramString2);
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -1;
  }

  protected long getLongProperty(Properties paramProperties, String paramString1, String paramString2)
  {
    String str = paramProperties.getProperty(paramString1 + paramString2);
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -1L;
  }

  protected String getString(Properties paramProperties, String paramString1, String paramString2)
  {
    return paramProperties.getProperty(paramString1 + paramString2);
  }

  protected Object readResolve()
    throws ObjectStreamException
  {
    return super.readResolve();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.conf.PropertyConfiguration
 * JD-Core Version:    0.6.2
 */