package twitter4j.internal.json;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class QueryResultJSONImpl extends TwitterResponseImpl
  implements Serializable, QueryResult
{
  static Method queryFactoryMethod;
  private static final long serialVersionUID = -6781654399437121238L;
  private double completedIn;
  private int count;
  private long maxId;
  private String nextResults;
  private String query;
  private String refreshUrl;
  private long sinceId;
  private List<Status> tweets;

  static
  {
    Method[] arrayOfMethod = Query.class.getDeclaredMethods();
    int i = arrayOfMethod.length;
    for (int j = 0; ; j++)
      if (j < i)
      {
        Method localMethod = arrayOfMethod[j];
        if (localMethod.getName().equals("createWithNextPageQuery"))
        {
          queryFactoryMethod = localMethod;
          queryFactoryMethod.setAccessible(true);
        }
      }
      else
      {
        if (queryFactoryMethod != null)
          break;
        throw new ExceptionInInitializerError(new NoSuchMethodException("twitter4j.Query.createWithNextPageQuery(java.lang.String)"));
      }
  }

  QueryResultJSONImpl(Query paramQuery)
  {
    this.sinceId = paramQuery.getSinceId();
    this.count = paramQuery.getCount();
    this.tweets = new ArrayList(0);
  }

  QueryResultJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    super(paramHttpResponse);
    JSONObject localJSONObject1 = paramHttpResponse.asJSONObject();
    while (true)
    {
      try
      {
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject("search_metadata");
        this.completedIn = z_T4JInternalParseUtil.getDouble("completed_in", localJSONObject2);
        this.count = z_T4JInternalParseUtil.getInt("count", localJSONObject2);
        this.maxId = z_T4JInternalParseUtil.getLong("max_id", localJSONObject2);
        String str;
        if (localJSONObject2.has("next_results"))
        {
          str = localJSONObject2.getString("next_results");
          this.nextResults = str;
          this.query = z_T4JInternalParseUtil.getURLDecodedString("query", localJSONObject2);
          this.refreshUrl = z_T4JInternalParseUtil.getUnescapedString("refresh_url", localJSONObject2);
          this.sinceId = z_T4JInternalParseUtil.getLong("since_id", localJSONObject2);
          JSONArray localJSONArray = localJSONObject1.getJSONArray("statuses");
          this.tweets = new ArrayList(localJSONArray.length());
          if (!paramConfiguration.isJSONStoreEnabled())
            break label242;
          DataObjectFactoryUtil.clearThreadLocalMap();
          break label242;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject3 = localJSONArray.getJSONObject(i);
            this.tweets.add(new StatusJSONImpl(localJSONObject3, paramConfiguration));
            i++;
            continue;
          }
        }
        else
        {
          str = null;
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new TwitterException(localJSONException.getMessage() + ":" + localJSONObject1.toString(), localJSONException);
      }
      return;
      label242: int i = 0;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    QueryResult localQueryResult;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localQueryResult = (QueryResult)paramObject;
      if (Double.compare(localQueryResult.getCompletedIn(), this.completedIn) != 0)
        return false;
      if (this.maxId != localQueryResult.getMaxId())
        return false;
      if (this.count != localQueryResult.getCount())
        return false;
      if (this.sinceId != localQueryResult.getSinceId())
        return false;
      if (!this.query.equals(localQueryResult.getQuery()))
        return false;
      if (this.refreshUrl != null)
      {
        if (this.refreshUrl.equals(localQueryResult.getRefreshUrl()));
      }
      else
        while (localQueryResult.getRefreshUrl() != null)
          return false;
      if (this.tweets == null)
        break;
    }
    while (this.tweets.equals(localQueryResult.getTweets()));
    while (true)
    {
      return false;
      if (localQueryResult.getTweets() == null)
        break;
    }
  }

  public double getCompletedIn()
  {
    return this.completedIn;
  }

  public int getCount()
  {
    return this.count;
  }

  public long getMaxId()
  {
    return this.maxId;
  }

  public String getQuery()
  {
    return this.query;
  }

  public String getRefreshURL()
  {
    return this.refreshUrl;
  }

  public String getRefreshUrl()
  {
    return getRefreshURL();
  }

  public long getSinceId()
  {
    return this.sinceId;
  }

  public List<Status> getTweets()
  {
    return this.tweets;
  }

  public boolean hasNext()
  {
    return this.nextResults != null;
  }

  public int hashCode()
  {
    int i = 31 * (31 * (int)(this.sinceId ^ this.sinceId >>> 32) + (int)(this.maxId ^ this.maxId >>> 32));
    int j;
    int k;
    if (this.refreshUrl != null)
    {
      j = this.refreshUrl.hashCode();
      k = 31 * (j + i) + this.count;
      if (this.completedIn == 0.0D)
        break label145;
    }
    label145: for (long l = Double.doubleToLongBits(this.completedIn); ; l = 0L)
    {
      int m = 31 * (31 * (k * 31 + (int)(l ^ l >>> 32)) + this.query.hashCode());
      List localList = this.tweets;
      int n = 0;
      if (localList != null)
        n = this.tweets.hashCode();
      return m + n;
      j = 0;
      break;
    }
  }

  public Query nextQuery()
  {
    if (this.nextResults == null)
      return null;
    try
    {
      Method localMethod = queryFactoryMethod;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.nextResults;
      Query localQuery = (Query)localMethod.invoke(null, arrayOfString);
      return localQuery;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException(localInvocationTargetException);
    }
  }

  public String toString()
  {
    return "QueryResultJSONImpl{sinceId=" + this.sinceId + ", maxId=" + this.maxId + ", refreshUrl='" + this.refreshUrl + '\'' + ", count=" + this.count + ", completedIn=" + this.completedIn + ", query='" + this.query + '\'' + ", tweets=" + this.tweets + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.QueryResultJSONImpl
 * JD-Core Version:    0.6.2
 */