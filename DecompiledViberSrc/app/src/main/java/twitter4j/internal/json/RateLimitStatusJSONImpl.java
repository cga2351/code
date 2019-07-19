package twitter4j.internal.json;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import twitter4j.RateLimitStatus;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class RateLimitStatusJSONImpl
  implements Serializable, RateLimitStatus
{
  private static final long serialVersionUID = 1625565652687304084L;
  private int limit;
  private int remaining;
  private int resetTimeInSeconds;
  private int secondsUntilReset;

  private RateLimitStatusJSONImpl(int paramInt1, int paramInt2, int paramInt3)
  {
    this.limit = paramInt1;
    this.remaining = paramInt2;
    this.resetTimeInSeconds = paramInt3;
    this.secondsUntilReset = ((int)((1000L * paramInt3 - System.currentTimeMillis()) / 1000L));
  }

  RateLimitStatusJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    init(paramJSONObject);
  }

  static RateLimitStatus createFromResponseHeader(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null);
    int i;
    int j;
    String str3;
    do
    {
      String str2;
      do
      {
        String str1;
        do
        {
          return null;
          str1 = paramHttpResponse.getResponseHeader("X-Rate-Limit-Limit");
        }
        while (str1 == null);
        i = Integer.parseInt(str1);
        str2 = paramHttpResponse.getResponseHeader("X-Rate-Limit-Remaining");
      }
      while (str2 == null);
      j = Integer.parseInt(str2);
      str3 = paramHttpResponse.getResponseHeader("X-Rate-Limit-Reset");
    }
    while (str3 == null);
    return new RateLimitStatusJSONImpl(i, j, (int)Long.parseLong(str3));
  }

  static Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    JSONObject localJSONObject = paramHttpResponse.asJSONObject();
    Map localMap = createRateLimitStatuses(localJSONObject);
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(localMap, localJSONObject);
    }
    return localMap;
  }

  static Map<String, RateLimitStatus> createRateLimitStatuses(JSONObject paramJSONObject)
    throws TwitterException
  {
    HashMap localHashMap = new HashMap();
    try
    {
      JSONObject localJSONObject1 = paramJSONObject.getJSONObject("resources");
      Iterator localIterator1 = localJSONObject1.keys();
      while (localIterator1.hasNext())
      {
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject((String)localIterator1.next());
        Iterator localIterator2 = localJSONObject2.keys();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          localHashMap.put(str, new RateLimitStatusJSONImpl(localJSONObject2.getJSONObject(str)));
        }
      }
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
    Map localMap = Collections.unmodifiableMap(localHashMap);
    return localMap;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    RateLimitStatusJSONImpl localRateLimitStatusJSONImpl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localRateLimitStatusJSONImpl = (RateLimitStatusJSONImpl)paramObject;
      if (this.limit != localRateLimitStatusJSONImpl.limit)
        return false;
      if (this.remaining != localRateLimitStatusJSONImpl.remaining)
        return false;
      if (this.resetTimeInSeconds != localRateLimitStatusJSONImpl.resetTimeInSeconds)
        return false;
    }
    while (this.secondsUntilReset == localRateLimitStatusJSONImpl.secondsUntilReset);
    return false;
  }

  public int getLimit()
  {
    return this.limit;
  }

  public int getRemaining()
  {
    return this.remaining;
  }

  public int getRemainingHits()
  {
    return getRemaining();
  }

  public int getResetTimeInSeconds()
  {
    return this.resetTimeInSeconds;
  }

  public int getSecondsUntilReset()
  {
    return this.secondsUntilReset;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * this.remaining + this.limit) + this.resetTimeInSeconds) + this.secondsUntilReset;
  }

  void init(JSONObject paramJSONObject)
    throws TwitterException
  {
    this.limit = z_T4JInternalParseUtil.getInt("limit", paramJSONObject);
    this.remaining = z_T4JInternalParseUtil.getInt("remaining", paramJSONObject);
    this.resetTimeInSeconds = z_T4JInternalParseUtil.getInt("reset", paramJSONObject);
    this.secondsUntilReset = ((int)((1000L * this.resetTimeInSeconds - System.currentTimeMillis()) / 1000L));
  }

  public String toString()
  {
    return "RateLimitStatusJSONImpl{remaining=" + this.remaining + ", limit=" + this.limit + ", resetTimeInSeconds=" + this.resetTimeInSeconds + ", secondsUntilReset=" + this.secondsUntilReset + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.RateLimitStatusJSONImpl
 * JD-Core Version:    0.6.2
 */