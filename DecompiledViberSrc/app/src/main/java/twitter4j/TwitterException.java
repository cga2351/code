package twitter4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.http.HttpResponseCode;
import twitter4j.internal.json.z_T4JInternalJSONImplFactory;
import twitter4j.internal.json.z_T4JInternalParseUtil;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public class TwitterException extends Exception
  implements TwitterResponse, HttpResponseCode
{
  private static final String[] FILTER = { "twitter4j" };
  private static final long serialVersionUID = -2623309261327598087L;
  private int errorCode = -1;
  private String errorMessage = null;
  private ExceptionDiagnosis exceptionDiagnosis = null;
  boolean nested = false;
  private HttpResponse response;
  private int statusCode = -1;

  public TwitterException(Exception paramException)
  {
    this(paramException.getMessage(), paramException);
    if ((paramException instanceof TwitterException))
      ((TwitterException)paramException).setNested();
  }

  public TwitterException(String paramString)
  {
    this(paramString, (Throwable)null);
  }

  public TwitterException(String paramString, Exception paramException, int paramInt)
  {
    this(paramString, paramException);
    this.statusCode = paramInt;
  }

  public TwitterException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    decode(paramString);
  }

  public TwitterException(String paramString, HttpResponse paramHttpResponse)
  {
    this(paramString);
    this.response = paramHttpResponse;
    this.statusCode = paramHttpResponse.getStatusCode();
  }

  private void decode(String paramString)
  {
    if ((paramString != null) && (paramString.startsWith("{")));
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (!localJSONObject1.isNull("errors"))
      {
        JSONObject localJSONObject2 = localJSONObject1.getJSONArray("errors").getJSONObject(0);
        this.errorMessage = localJSONObject2.getString("message");
        this.errorCode = z_T4JInternalParseUtil.getInt("code", localJSONObject2);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private static String getCause(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      str = "";
    case 304:
    case 400:
    case 401:
    case 403:
    case 404:
    case 406:
    case 420:
    case 422:
    case 429:
    case 500:
    case 502:
    case 503:
    case 504:
    }
    while (true)
    {
      return paramInt + ":" + str;
      str = "There was no new data to return.";
      continue;
      str = "The request was invalid. An accompanying error message will explain why. This is the status code will be returned during version 1.0 rate limiting(https://dev.twitter.com/pages/rate-limiting). In API v1.1, a request without authentication is considered invalid and you will get this response.";
      continue;
      str = "Authentication credentials (https://dev.twitter.com/pages/auth) were missing or incorrect. Ensure that you have set valid consumer key/secret, access token/secret, and the system clock is in sync.";
      continue;
      str = "The request is understood, but it has been refused. An accompanying error message will explain why. This code is used when requests are being denied due to update limits (https://support.twitter.com/articles/15364-about-twitter-limits-update-api-dm-and-following).";
      continue;
      str = "The URI requested is invalid or the resource requested, such as a user, does not exists. Also returned when the requested format is not supported by the requested method.";
      continue;
      str = "Returned by the Search API when an invalid format is specified in the request.\nReturned by the Streaming API when one or more of the parameters are not suitable for the resource. The track parameter, for example, would throw this error if:\n The track keyword is too long or too short.\n The bounding box specified is invalid.\n No predicates defined for filtered resource, for example, neither track nor follow parameter defined.\n Follow userid cannot be read.";
      continue;
      str = "Returned by the Search and Trends API when you are being rate limited (https://dev.twitter.com/docs/rate-limiting).\nReturned by the Streaming API:\n Too many login attempts in a short period of time.\n Running too many copies of the same application authenticating with the same account name.";
      continue;
      str = "Returned when an image uploaded to POST account/update_profile_banner(https://dev.twitter.com/docs/api/1/post/account/update_profile_banner) is unable to be processed.";
      continue;
      str = "Returned in API v1.1 when a request cannot be served due to the application's rate limit having been exhausted for the resource. See Rate Limiting in API v1.1.(https://dev.twitter.com/docs/rate-limiting/1.1)";
      continue;
      str = "Something is broken. Please post to the group (https://dev.twitter.com/docs/support) so the Twitter team can investigate.";
      continue;
      str = "Twitter is down or being upgraded.";
      continue;
      str = "The Twitter servers are up, but overloaded with requests. Try again later.";
      continue;
      str = "The Twitter servers are up, but the request couldn't be serviced due to some failure within our stack. Try again later.";
    }
  }

  private ExceptionDiagnosis getExceptionDiagnosis()
  {
    if (this.exceptionDiagnosis == null)
      this.exceptionDiagnosis = new ExceptionDiagnosis(this, FILTER);
    return this.exceptionDiagnosis;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TwitterException localTwitterException;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTwitterException = (TwitterException)paramObject;
      if (this.errorCode != localTwitterException.errorCode)
        return false;
      if (this.nested != localTwitterException.nested)
        return false;
      if (this.statusCode != localTwitterException.statusCode)
        return false;
      if (this.errorMessage != null)
      {
        if (this.errorMessage.equals(localTwitterException.errorMessage));
      }
      else
        while (localTwitterException.errorMessage != null)
          return false;
      if (this.exceptionDiagnosis != null)
      {
        if (this.exceptionDiagnosis.equals(localTwitterException.exceptionDiagnosis));
      }
      else
        while (localTwitterException.exceptionDiagnosis != null)
          return false;
      if (this.response == null)
        break;
    }
    while (this.response.equals(localTwitterException.response));
    while (true)
    {
      return false;
      if (localTwitterException.response == null)
        break;
    }
  }

  public boolean exceededRateLimitation()
  {
    return ((this.statusCode == 400) && (getRateLimitStatus() != null)) || (this.statusCode == 420) || (this.statusCode == 429);
  }

  public int getAccessLevel()
  {
    return z_T4JInternalParseUtil.toAccessLevel(this.response);
  }

  public int getErrorCode()
  {
    return this.errorCode;
  }

  public String getErrorMessage()
  {
    return this.errorMessage;
  }

  public String getExceptionCode()
  {
    return getExceptionDiagnosis().asHexString();
  }

  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.errorMessage != null) && (this.errorCode != -1))
    {
      localStringBuilder.append("message - ").append(this.errorMessage).append("\n");
      localStringBuilder.append("code - ").append(this.errorCode).append("\n");
    }
    while (this.statusCode != -1)
    {
      return getCause(this.statusCode) + "\n" + localStringBuilder.toString();
      localStringBuilder.append(super.getMessage());
    }
    return localStringBuilder.toString();
  }

  public RateLimitStatus getRateLimitStatus()
  {
    if (this.response == null)
      return null;
    return z_T4JInternalJSONImplFactory.createRateLimitStatusFromResponseHeader(this.response);
  }

  public String getResponseHeader(String paramString)
  {
    if (this.response != null)
    {
      List localList = (List)this.response.getResponseHeaderFields().get(paramString);
      if (localList.size() > 0)
        return (String)localList.get(0);
    }
    return null;
  }

  public int getRetryAfter()
  {
    int i = -1;
    if (this.statusCode == 400)
    {
      RateLimitStatus localRateLimitStatus = getRateLimitStatus();
      if (localRateLimitStatus != null)
        i = localRateLimitStatus.getSecondsUntilReset();
    }
    while (true)
    {
      return i;
      if (this.statusCode == 420)
        try
        {
          String str = this.response.getResponseHeader("Retry-After");
          if (str != null)
          {
            int j = Integer.valueOf(str).intValue();
            return j;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
        }
    }
    return i;
  }

  public int getStatusCode()
  {
    return this.statusCode;
  }

  public int hashCode()
  {
    int i = 31 * (31 * this.statusCode + this.errorCode);
    int j;
    int m;
    label54: int n;
    if (this.exceptionDiagnosis != null)
    {
      j = this.exceptionDiagnosis.hashCode();
      int k = 31 * (j + i);
      if (this.response == null)
        break label117;
      m = this.response.hashCode();
      n = 31 * (m + k);
      if (this.errorMessage == null)
        break label123;
    }
    label117: label123: for (int i1 = this.errorMessage.hashCode(); ; i1 = 0)
    {
      int i2 = 31 * (i1 + n);
      boolean bool = this.nested;
      int i3 = 0;
      if (bool)
        i3 = 1;
      return i2 + i3;
      j = 0;
      break;
      m = 0;
      break label54;
    }
  }

  public boolean isCausedByNetworkIssue()
  {
    return getCause() instanceof IOException;
  }

  public boolean isErrorMessageAvailable()
  {
    return this.errorMessage != null;
  }

  public boolean resourceNotFound()
  {
    return this.statusCode == 404;
  }

  void setNested()
  {
    this.nested = true;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append(getMessage());
    String str1;
    StringBuilder localStringBuilder2;
    if (this.nested)
    {
      str1 = "";
      localStringBuilder2 = localStringBuilder1.append(str1).append("\nTwitterException{");
      if (!this.nested)
        break label186;
    }
    label186: for (String str2 = ""; ; str2 = "exceptionCode=[" + getExceptionCode() + "], ")
    {
      return str2 + "statusCode=" + this.statusCode + ", message=" + this.errorMessage + ", code=" + this.errorCode + ", retryAfter=" + getRetryAfter() + ", rateLimitStatus=" + getRateLimitStatus() + ", version=" + Version.getVersion() + '}';
      str1 = "\nRelevant discussions can be found on the Internet at:\n\thttp://www.google.co.jp/search?q=" + getExceptionDiagnosis().getStackLineHashAsHex() + " or\n\thttp://www.google.co.jp/search?q=" + getExceptionDiagnosis().getLineNumberHashAsHex();
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.TwitterException
 * JD-Core Version:    0.6.2
 */