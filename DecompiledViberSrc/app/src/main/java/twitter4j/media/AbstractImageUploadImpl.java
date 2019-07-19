package twitter4j.media;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import twitter4j.TwitterException;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpClientWrapper;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.logging.Logger;

abstract class AbstractImageUploadImpl
  implements ImageUpload
{

  @Deprecated
  public static final String TWITTER_VERIFY_CREDENTIALS_JSON_V1 = "https://api.twitter.com/1/account/verify_credentials.json";
  public static final String TWITTER_VERIFY_CREDENTIALS_JSON_V1_1 = "https://api.twitter.com/1.1/account/verify_credentials.json";

  @Deprecated
  public static final String TWITTER_VERIFY_CREDENTIALS_XML_V1 = "https://api.twitter.com/1/account/verify_credentials.xml";
  protected static final Logger logger = Logger.getLogger(AbstractImageUploadImpl.class);
  protected String apiKey = null;
  protected HttpParameter[] appendParameter = null;
  private HttpClientWrapper client;
  protected Configuration conf = null;
  protected Map<String, String> headers = new HashMap();
  protected HttpResponse httpResponse = null;
  protected HttpParameter image = null;
  protected HttpParameter message = null;
  protected OAuthAuthorization oauth = null;
  protected HttpParameter[] postParameter = null;
  protected String uploadUrl = null;

  public AbstractImageUploadImpl(Configuration paramConfiguration, String paramString, OAuthAuthorization paramOAuthAuthorization)
  {
    this(paramConfiguration, paramOAuthAuthorization);
    this.apiKey = paramString;
  }

  AbstractImageUploadImpl(Configuration paramConfiguration, OAuthAuthorization paramOAuthAuthorization)
  {
    this.oauth = paramOAuthAuthorization;
    this.conf = paramConfiguration;
    this.client = new HttpClientWrapper(paramConfiguration);
  }

  private String upload()
    throws TwitterException
  {
    if (this.conf.getMediaProviderParameters() != null)
    {
      Set localSet = this.conf.getMediaProviderParameters().keySet();
      HttpParameter[] arrayOfHttpParameter = new HttpParameter[localSet.size()];
      Iterator localIterator = localSet.iterator();
      for (int i = 0; localIterator.hasNext(); i++)
      {
        Object localObject = localIterator.next();
        String str2 = this.conf.getMediaProviderParameters().getProperty((String)localObject);
        arrayOfHttpParameter[i] = new HttpParameter((String)localObject, str2);
      }
      this.appendParameter = arrayOfHttpParameter;
    }
    preUpload();
    if (this.postParameter == null)
      throw new AssertionError("Incomplete implementation. postParameter is not set.");
    if (this.uploadUrl == null)
      throw new AssertionError("Incomplete implementation. uploadUrl is not set.");
    if ((this.conf.getMediaProviderParameters() != null) && (this.appendParameter.length > 0))
      this.postParameter = appendHttpParameters(this.postParameter, this.appendParameter);
    this.httpResponse = this.client.post(this.uploadUrl, this.postParameter, this.headers);
    String str1 = postUpload();
    logger.debug("uploaded url [" + str1 + "]");
    return str1;
  }

  protected HttpParameter[] appendHttpParameters(HttpParameter[] paramArrayOfHttpParameter1, HttpParameter[] paramArrayOfHttpParameter2)
  {
    int i = paramArrayOfHttpParameter1.length;
    int j = paramArrayOfHttpParameter2.length;
    HttpParameter[] arrayOfHttpParameter = new HttpParameter[i + j];
    System.arraycopy(paramArrayOfHttpParameter1, 0, arrayOfHttpParameter, 0, i);
    System.arraycopy(paramArrayOfHttpParameter2, 0, arrayOfHttpParameter, i, j);
    return arrayOfHttpParameter;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AbstractImageUploadImpl localAbstractImageUploadImpl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localAbstractImageUploadImpl = (AbstractImageUploadImpl)paramObject;
      if (this.apiKey != null)
      {
        if (this.apiKey.equals(localAbstractImageUploadImpl.apiKey));
      }
      else
        while (localAbstractImageUploadImpl.apiKey != null)
          return false;
      if (!Arrays.equals(this.appendParameter, localAbstractImageUploadImpl.appendParameter))
        return false;
      if (this.client != null)
      {
        if (this.client.equals(localAbstractImageUploadImpl.client));
      }
      else
        while (localAbstractImageUploadImpl.client != null)
          return false;
      if (this.conf != null)
      {
        if (this.conf.equals(localAbstractImageUploadImpl.conf));
      }
      else
        while (localAbstractImageUploadImpl.conf != null)
          return false;
      if (this.headers != null)
      {
        if (this.headers.equals(localAbstractImageUploadImpl.headers));
      }
      else
        while (localAbstractImageUploadImpl.headers != null)
          return false;
      if (this.httpResponse != null)
      {
        if (this.httpResponse.equals(localAbstractImageUploadImpl.httpResponse));
      }
      else
        while (localAbstractImageUploadImpl.httpResponse != null)
          return false;
      if (this.image != null)
      {
        if (this.image.equals(localAbstractImageUploadImpl.image));
      }
      else
        while (localAbstractImageUploadImpl.image != null)
          return false;
      if (this.message != null)
      {
        if (this.message.equals(localAbstractImageUploadImpl.message));
      }
      else
        while (localAbstractImageUploadImpl.message != null)
          return false;
      if (this.oauth != null)
      {
        if (this.oauth.equals(localAbstractImageUploadImpl.oauth));
      }
      else
        while (localAbstractImageUploadImpl.oauth != null)
          return false;
      if (!Arrays.equals(this.postParameter, localAbstractImageUploadImpl.postParameter))
        return false;
      if (this.uploadUrl == null)
        break;
    }
    while (this.uploadUrl.equals(localAbstractImageUploadImpl.uploadUrl));
    while (true)
    {
      return false;
      if (localAbstractImageUploadImpl.uploadUrl == null)
        break;
    }
  }

  protected String generateVerifyCredentialsAuthorizationHeader(String paramString)
  {
    List localList = this.oauth.generateOAuthSignatureHttpParams("GET", paramString);
    return "OAuth realm=\"http://api.twitter.com/\"," + OAuthAuthorization.encodeParameters(localList, ",", true);
  }

  protected String generateVerifyCredentialsAuthorizationURL(String paramString)
  {
    List localList = this.oauth.generateOAuthSignatureHttpParams("GET", paramString);
    return paramString + "?" + OAuthAuthorization.encodeParameters(localList);
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label111: int i6;
    label137: int i8;
    label163: int i10;
    label189: int i12;
    label215: int i13;
    if (this.client != null)
    {
      i = this.client.hashCode();
      int j = i * 31;
      if (this.conf == null)
        break label287;
      k = this.conf.hashCode();
      int m = 31 * (k + j);
      if (this.apiKey == null)
        break label292;
      n = this.apiKey.hashCode();
      int i1 = 31 * (n + m);
      if (this.oauth == null)
        break label298;
      i2 = this.oauth.hashCode();
      int i3 = 31 * (i2 + i1);
      if (this.uploadUrl == null)
        break label304;
      i4 = this.uploadUrl.hashCode();
      int i5 = 31 * (i4 + i3);
      if (this.postParameter == null)
        break label310;
      i6 = Arrays.hashCode(this.postParameter);
      int i7 = 31 * (i6 + i5);
      if (this.appendParameter == null)
        break label316;
      i8 = Arrays.hashCode(this.appendParameter);
      int i9 = 31 * (i8 + i7);
      if (this.image == null)
        break label322;
      i10 = this.image.hashCode();
      int i11 = 31 * (i10 + i9);
      if (this.message == null)
        break label328;
      i12 = this.message.hashCode();
      i13 = 31 * (i12 + i11);
      if (this.headers == null)
        break label334;
    }
    label287: label292: label298: label304: label310: label316: label322: label328: label334: for (int i14 = this.headers.hashCode(); ; i14 = 0)
    {
      int i15 = 31 * (i14 + i13);
      HttpResponse localHttpResponse = this.httpResponse;
      int i16 = 0;
      if (localHttpResponse != null)
        i16 = this.httpResponse.hashCode();
      return i15 + i16;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label85;
      i4 = 0;
      break label111;
      i6 = 0;
      break label137;
      i8 = 0;
      break label163;
      i10 = 0;
      break label189;
      i12 = 0;
      break label215;
    }
  }

  protected abstract String postUpload()
    throws TwitterException;

  protected abstract void preUpload()
    throws TwitterException;

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("AbstractImageUploadImpl{client=").append(this.client).append(", conf=").append(this.conf).append(", apiKey='").append(this.apiKey).append('\'').append(", oauth=").append(this.oauth).append(", uploadUrl='").append(this.uploadUrl).append('\'').append(", postParameter=");
    Object localObject1;
    StringBuilder localStringBuilder2;
    Object localObject2;
    if (this.postParameter == null)
    {
      localObject1 = null;
      localStringBuilder2 = localStringBuilder1.append(localObject1).append(", appendParameter=");
      HttpParameter[] arrayOfHttpParameter = this.appendParameter;
      localObject2 = null;
      if (arrayOfHttpParameter != null)
        break label194;
    }
    while (true)
    {
      return localObject2 + ", image=" + this.image + ", message=" + this.message + ", headers=" + this.headers + ", httpResponse=" + this.httpResponse + '}';
      localObject1 = Arrays.asList(this.postParameter);
      break;
      label194: localObject2 = Arrays.asList(this.appendParameter);
    }
  }

  public String upload(File paramFile)
    throws TwitterException
  {
    this.image = new HttpParameter("media", paramFile);
    return upload();
  }

  public String upload(File paramFile, String paramString)
    throws TwitterException
  {
    this.image = new HttpParameter("media", paramFile);
    this.message = new HttpParameter("message", paramString);
    return upload();
  }

  public String upload(String paramString, InputStream paramInputStream)
    throws TwitterException
  {
    this.image = new HttpParameter("media", paramString, paramInputStream);
    return upload();
  }

  public String upload(String paramString1, InputStream paramInputStream, String paramString2)
    throws TwitterException
  {
    this.image = new HttpParameter("media", paramString1, paramInputStream);
    this.message = new HttpParameter("message", paramString2);
    return upload();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.media.AbstractImageUploadImpl
 * JD-Core Version:    0.6.2
 */