package twitter4j.auth;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.BASE64Encoder;
import twitter4j.internal.http.HttpClientWrapper;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpRequest;
import twitter4j.internal.http.RequestMethod;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.util.z_T4JInternalStringUtil;

public class OAuthAuthorization
  implements Serializable, Authorization, OAuthSupport
{
  private static final String HMAC_SHA1 = "HmacSHA1";
  private static final HttpParameter OAUTH_SIGNATURE_METHOD = new HttpParameter("oauth_signature_method", "HMAC-SHA1");
  private static Random RAND = new Random();
  private static transient HttpClientWrapper http;
  private static final Logger logger = Logger.getLogger(OAuthAuthorization.class);
  private static final long serialVersionUID = -4368426677157998618L;
  private final Configuration conf;
  private String consumerKey = "";
  private String consumerSecret;
  private OAuthToken oauthToken = null;
  private String realm = null;

  public OAuthAuthorization(Configuration paramConfiguration)
  {
    this.conf = paramConfiguration;
    http = new HttpClientWrapper(paramConfiguration);
    setOAuthConsumer(paramConfiguration.getOAuthConsumerKey(), paramConfiguration.getOAuthConsumerSecret());
    if ((paramConfiguration.getOAuthAccessToken() != null) && (paramConfiguration.getOAuthAccessTokenSecret() != null))
      setOAuthAccessToken(new AccessToken(paramConfiguration.getOAuthAccessToken(), paramConfiguration.getOAuthAccessTokenSecret()));
  }

  static String constructRequestURL(String paramString)
  {
    int i = paramString.indexOf("?");
    if (-1 != i)
      paramString = paramString.substring(0, i);
    int j = paramString.indexOf("/", 8);
    String str = paramString.substring(0, j).toLowerCase();
    int k = str.indexOf(":", 8);
    if (-1 != k)
      if ((!str.startsWith("http://")) || (!str.endsWith(":80")))
        break label103;
    for (str = str.substring(0, k); ; str = str.substring(0, k))
      label103: 
      do
        return str + paramString.substring(j);
      while ((!str.startsWith("https://")) || (!str.endsWith(":443")));
  }

  public static String encodeParameters(List<HttpParameter> paramList)
  {
    return encodeParameters(paramList, "&", false);
  }

  public static String encodeParameters(List<HttpParameter> paramList, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      HttpParameter localHttpParameter = (HttpParameter)localIterator.next();
      if (!localHttpParameter.isFile())
      {
        if (localStringBuilder.length() != 0)
        {
          if (paramBoolean)
            localStringBuilder.append("\"");
          localStringBuilder.append(paramString);
        }
        localStringBuilder.append(HttpParameter.encode(localHttpParameter.getName())).append("=");
        if (paramBoolean)
          localStringBuilder.append("\"");
        localStringBuilder.append(HttpParameter.encode(localHttpParameter.getValue()));
      }
    }
    if ((localStringBuilder.length() != 0) && (paramBoolean))
      localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }

  private void ensureTokenIsAvailable()
  {
    if (this.oauthToken == null)
      throw new IllegalStateException("No Token available.");
  }

  static String normalizeAuthorizationHeaders(List<HttpParameter> paramList)
  {
    Collections.sort(paramList);
    return encodeParameters(paramList);
  }

  static String normalizeRequestParameters(List<HttpParameter> paramList)
  {
    Collections.sort(paramList);
    return encodeParameters(paramList);
  }

  static String normalizeRequestParameters(HttpParameter[] paramArrayOfHttpParameter)
  {
    return normalizeRequestParameters(toParamList(paramArrayOfHttpParameter));
  }

  private void parseGetParameters(String paramString, List<HttpParameter> paramList)
  {
    int i = 0;
    int j = paramString.indexOf("?");
    String[] arrayOfString1;
    if (-1 != j)
      arrayOfString1 = z_T4JInternalStringUtil.split(paramString.substring(j + 1), "&");
    while (true)
    {
      try
      {
        int k = arrayOfString1.length;
        if (i < k)
        {
          String[] arrayOfString2 = z_T4JInternalStringUtil.split(arrayOfString1[i], "=");
          if (arrayOfString2.length == 2)
            paramList.add(new HttpParameter(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8")));
          else
            paramList.add(new HttpParameter(URLDecoder.decode(arrayOfString2[0], "UTF-8"), ""));
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
      }
      return;
      i++;
    }
  }

  static List<HttpParameter> toParamList(HttpParameter[] paramArrayOfHttpParameter)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfHttpParameter.length);
    localArrayList.addAll(Arrays.asList(paramArrayOfHttpParameter));
    return localArrayList;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    OAuthAuthorization localOAuthAuthorization;
    do
    {
      return true;
      if (!(paramObject instanceof OAuthSupport))
        return false;
      localOAuthAuthorization = (OAuthAuthorization)paramObject;
      if (this.consumerKey != null)
      {
        if (this.consumerKey.equals(localOAuthAuthorization.consumerKey));
      }
      else
        while (localOAuthAuthorization.consumerKey != null)
          return false;
      if (this.consumerSecret != null)
      {
        if (this.consumerSecret.equals(localOAuthAuthorization.consumerSecret));
      }
      else
        while (localOAuthAuthorization.consumerSecret != null)
          return false;
      if (this.oauthToken == null)
        break;
    }
    while (this.oauthToken.equals(localOAuthAuthorization.oauthToken));
    while (true)
    {
      return false;
      if (localOAuthAuthorization.oauthToken == null)
        break;
    }
  }

  String generateAuthorizationHeader(String paramString1, String paramString2, HttpParameter[] paramArrayOfHttpParameter, String paramString3, String paramString4, OAuthToken paramOAuthToken)
  {
    if (paramArrayOfHttpParameter == null)
      paramArrayOfHttpParameter = new HttpParameter[0];
    ArrayList localArrayList1 = new ArrayList(5);
    localArrayList1.add(new HttpParameter("oauth_consumer_key", this.consumerKey));
    localArrayList1.add(OAUTH_SIGNATURE_METHOD);
    localArrayList1.add(new HttpParameter("oauth_timestamp", paramString4));
    localArrayList1.add(new HttpParameter("oauth_nonce", paramString3));
    localArrayList1.add(new HttpParameter("oauth_version", "1.0"));
    if (paramOAuthToken != null)
      localArrayList1.add(new HttpParameter("oauth_token", paramOAuthToken.getToken()));
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size() + paramArrayOfHttpParameter.length);
    localArrayList2.addAll(localArrayList1);
    if (!HttpParameter.containsFile(paramArrayOfHttpParameter))
      localArrayList2.addAll(toParamList(paramArrayOfHttpParameter));
    parseGetParameters(paramString2, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder(paramString1).append("&").append(HttpParameter.encode(constructRequestURL(paramString2))).append("&");
    localStringBuilder.append(HttpParameter.encode(normalizeRequestParameters(localArrayList2)));
    String str1 = localStringBuilder.toString();
    logger.debug("OAuth base string: ", str1);
    String str2 = generateSignature(str1, paramOAuthToken);
    logger.debug("OAuth signature: ", str2);
    localArrayList1.add(new HttpParameter("oauth_signature", str2));
    if (this.realm != null)
      localArrayList1.add(new HttpParameter("realm", this.realm));
    return "OAuth " + encodeParameters(localArrayList1, ",", true);
  }

  String generateAuthorizationHeader(String paramString1, String paramString2, HttpParameter[] paramArrayOfHttpParameter, OAuthToken paramOAuthToken)
  {
    long l = System.currentTimeMillis() / 1000L;
    return generateAuthorizationHeader(paramString1, paramString2, paramArrayOfHttpParameter, String.valueOf(l + RAND.nextInt()), String.valueOf(l), paramOAuthToken);
  }

  public List<HttpParameter> generateOAuthSignatureHttpParams(String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis() / 1000L;
    long l2 = l1 + RAND.nextInt();
    ArrayList localArrayList1 = new ArrayList(5);
    localArrayList1.add(new HttpParameter("oauth_consumer_key", this.consumerKey));
    localArrayList1.add(OAUTH_SIGNATURE_METHOD);
    localArrayList1.add(new HttpParameter("oauth_timestamp", l1));
    localArrayList1.add(new HttpParameter("oauth_nonce", l2));
    localArrayList1.add(new HttpParameter("oauth_version", "1.0"));
    if (this.oauthToken != null)
      localArrayList1.add(new HttpParameter("oauth_token", this.oauthToken.getToken()));
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    localArrayList2.addAll(localArrayList1);
    parseGetParameters(paramString2, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder(paramString1).append("&").append(HttpParameter.encode(constructRequestURL(paramString2))).append("&");
    localStringBuilder.append(HttpParameter.encode(normalizeRequestParameters(localArrayList2)));
    localArrayList1.add(new HttpParameter("oauth_signature", generateSignature(localStringBuilder.toString(), this.oauthToken)));
    return localArrayList1;
  }

  String generateSignature(String paramString)
  {
    return generateSignature(paramString, null);
  }

  String generateSignature(String paramString, OAuthToken paramOAuthToken)
  {
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA1");
      SecretKeySpec localSecretKeySpec;
      if (paramOAuthToken == null)
        localSecretKeySpec = new SecretKeySpec((HttpParameter.encode(this.consumerSecret) + "&").getBytes(), "HmacSHA1");
      while (true)
      {
        localMac.init(localSecretKeySpec);
        byte[] arrayOfByte = localMac.doFinal(paramString.getBytes());
        return BASE64Encoder.encode(arrayOfByte);
        localSecretKeySpec = paramOAuthToken.getSecretKeySpec();
        if (localSecretKeySpec == null)
        {
          localSecretKeySpec = new SecretKeySpec((HttpParameter.encode(this.consumerSecret) + "&" + HttpParameter.encode(paramOAuthToken.getTokenSecret())).getBytes(), "HmacSHA1");
          paramOAuthToken.setSecretKeySpec(localSecretKeySpec);
        }
      }
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      logger.error("Failed initialize \"Message Authentication Code\" (MAC)", localInvalidKeyException);
      throw new AssertionError(localInvalidKeyException);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      logger.error("Failed to get HmacSHA1 \"Message Authentication Code\" (MAC)", localNoSuchAlgorithmException);
      throw new AssertionError(localNoSuchAlgorithmException);
    }
  }

  public String getAuthorizationHeader(HttpRequest paramHttpRequest)
  {
    return generateAuthorizationHeader(paramHttpRequest.getMethod().name(), paramHttpRequest.getURL(), paramHttpRequest.getParameters(), this.oauthToken);
  }

  public AccessToken getOAuthAccessToken()
    throws TwitterException
  {
    ensureTokenIsAvailable();
    if ((this.oauthToken instanceof AccessToken))
      return (AccessToken)this.oauthToken;
    this.oauthToken = new AccessToken(http.post(this.conf.getOAuthAccessTokenURL(), this));
    return (AccessToken)this.oauthToken;
  }

  public AccessToken getOAuthAccessToken(String paramString)
    throws TwitterException
  {
    ensureTokenIsAvailable();
    HttpClientWrapper localHttpClientWrapper = http;
    String str = this.conf.getOAuthAccessTokenURL();
    HttpParameter[] arrayOfHttpParameter = new HttpParameter[1];
    arrayOfHttpParameter[0] = new HttpParameter("oauth_verifier", paramString);
    this.oauthToken = new AccessToken(localHttpClientWrapper.post(str, arrayOfHttpParameter, this));
    return (AccessToken)this.oauthToken;
  }

  public AccessToken getOAuthAccessToken(String paramString1, String paramString2)
    throws TwitterException
  {
    try
    {
      String str = this.conf.getOAuthAccessTokenURL();
      if (str.indexOf("http://") == 0)
        str = "https://" + str.substring(7);
      HttpClientWrapper localHttpClientWrapper = http;
      HttpParameter[] arrayOfHttpParameter = new HttpParameter[3];
      arrayOfHttpParameter[0] = new HttpParameter("x_auth_username", paramString1);
      arrayOfHttpParameter[1] = new HttpParameter("x_auth_password", paramString2);
      arrayOfHttpParameter[2] = new HttpParameter("x_auth_mode", "client_auth");
      this.oauthToken = new AccessToken(localHttpClientWrapper.post(str, arrayOfHttpParameter, this));
      AccessToken localAccessToken = (AccessToken)this.oauthToken;
      return localAccessToken;
    }
    catch (TwitterException localTwitterException)
    {
      throw new TwitterException("The screen name / password combination seems to be invalid.", localTwitterException, localTwitterException.getStatusCode());
    }
  }

  public AccessToken getOAuthAccessToken(RequestToken paramRequestToken)
    throws TwitterException
  {
    this.oauthToken = paramRequestToken;
    return getOAuthAccessToken();
  }

  public AccessToken getOAuthAccessToken(RequestToken paramRequestToken, String paramString)
    throws TwitterException
  {
    this.oauthToken = paramRequestToken;
    return getOAuthAccessToken(paramString);
  }

  public RequestToken getOAuthRequestToken()
    throws TwitterException
  {
    return getOAuthRequestToken(null, null);
  }

  public RequestToken getOAuthRequestToken(String paramString)
    throws TwitterException
  {
    return getOAuthRequestToken(paramString, null);
  }

  public RequestToken getOAuthRequestToken(String paramString1, String paramString2)
    throws TwitterException
  {
    if ((this.oauthToken instanceof AccessToken))
      throw new IllegalStateException("Access token already available.");
    ArrayList localArrayList = new ArrayList();
    if (paramString1 != null)
      localArrayList.add(new HttpParameter("oauth_callback", paramString1));
    if (paramString2 != null)
      localArrayList.add(new HttpParameter("x_auth_access_type", paramString2));
    this.oauthToken = new RequestToken(http.post(this.conf.getOAuthRequestTokenURL(), (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()]), this), this);
    return (RequestToken)this.oauthToken;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.consumerKey != null)
    {
      i = this.consumerKey.hashCode();
      j = i * 31;
      if (this.consumerSecret == null)
        break label77;
    }
    label77: for (int k = this.consumerSecret.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      OAuthToken localOAuthToken = this.oauthToken;
      int n = 0;
      if (localOAuthToken != null)
        n = this.oauthToken.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public boolean isEnabled()
  {
    return (this.oauthToken != null) && ((this.oauthToken instanceof AccessToken));
  }

  public void setOAuthAccessToken(AccessToken paramAccessToken)
  {
    this.oauthToken = paramAccessToken;
  }

  public void setOAuthConsumer(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      this.consumerKey = paramString1;
      if (paramString2 == null)
        break label25;
    }
    while (true)
    {
      this.consumerSecret = paramString2;
      return;
      paramString1 = "";
      break;
      label25: paramString2 = "";
    }
  }

  public void setOAuthRealm(String paramString)
  {
    this.realm = paramString;
  }

  public String toString()
  {
    return "OAuthAuthorization{consumerKey='" + this.consumerKey + '\'' + ", consumerSecret='******************************************'" + ", oauthToken=" + this.oauthToken + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.auth.OAuthAuthorization
 * JD-Core Version:    0.6.2
 */