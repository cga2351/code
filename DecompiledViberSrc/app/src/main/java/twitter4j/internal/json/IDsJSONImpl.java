package twitter4j.internal.json;

import java.util.Arrays;
import twitter4j.IDs;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class IDsJSONImpl extends TwitterResponseImpl
  implements IDs
{
  private static final long serialVersionUID = -6585026560164704953L;
  private long[] ids;
  private long nextCursor = -1L;
  private long previousCursor = -1L;

  IDsJSONImpl(String paramString)
    throws TwitterException
  {
    init(paramString);
  }

  IDsJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    super(paramHttpResponse);
    String str = paramHttpResponse.asString();
    init(str);
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, str);
    }
  }

  private void init(String paramString)
    throws TwitterException
  {
    int i = 0;
    JSONObject localJSONObject;
    try
    {
      if (!paramString.startsWith("{"))
        break label140;
      localJSONObject = new JSONObject(paramString);
      JSONArray localJSONArray1 = localJSONObject.getJSONArray("ids");
      this.ids = new long[localJSONArray1.length()];
      while (true)
      {
        int j = localJSONArray1.length();
        if (i < j)
          try
          {
            this.ids[i] = Long.parseLong(localJSONArray1.getString(i));
            i++;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            throw new TwitterException("Twitter API returned malformed response: " + localJSONObject, localNumberFormatException1);
          }
      }
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
    this.previousCursor = z_T4JInternalParseUtil.getLong("previous_cursor", localJSONObject);
    this.nextCursor = z_T4JInternalParseUtil.getLong("next_cursor", localJSONObject);
    return;
    label140: JSONArray localJSONArray2 = new JSONArray(paramString);
    this.ids = new long[localJSONArray2.length()];
    while (true)
    {
      int k = localJSONArray2.length();
      if (i < k)
        try
        {
          this.ids[i] = Long.parseLong(localJSONArray2.getString(i));
          i++;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          throw new TwitterException("Twitter API returned malformed response: " + localJSONArray2, localNumberFormatException2);
        }
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    IDs localIDs;
    do
    {
      return true;
      if (!(paramObject instanceof IDs))
        return false;
      localIDs = (IDs)paramObject;
    }
    while (Arrays.equals(this.ids, localIDs.getIDs()));
    return false;
  }

  public long[] getIDs()
  {
    return this.ids;
  }

  public long getNextCursor()
  {
    return this.nextCursor;
  }

  public long getPreviousCursor()
  {
    return this.previousCursor;
  }

  public boolean hasNext()
  {
    return 0L != this.nextCursor;
  }

  public boolean hasPrevious()
  {
    return 0L != this.previousCursor;
  }

  public int hashCode()
  {
    if (this.ids != null)
      return Arrays.hashCode(this.ids);
    return 0;
  }

  public String toString()
  {
    return "IDsJSONImpl{ids=" + Arrays.toString(this.ids) + ", previousCursor=" + this.previousCursor + ", nextCursor=" + this.nextCursor + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.IDsJSONImpl
 * JD-Core Version:    0.6.2
 */