package twitter4j.internal.json;

import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class URLEntityJSONImpl extends EntityIndex
  implements URLEntity
{
  private static final long serialVersionUID = -8948472760821379376L;
  private String displayURL;
  private String expandedURL;
  private String url;

  URLEntityJSONImpl()
  {
  }

  URLEntityJSONImpl(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    setStart(paramInt1);
    setEnd(paramInt2);
    this.url = paramString1;
    this.expandedURL = paramString2;
    this.displayURL = paramString3;
  }

  URLEntityJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    init(paramJSONObject);
  }

  private void init(JSONObject paramJSONObject)
    throws TwitterException
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("indices");
      setStart(localJSONArray.getInt(0));
      setEnd(localJSONArray.getInt(1));
      this.url = paramJSONObject.getString("url");
      if (!paramJSONObject.isNull("expanded_url"));
      for (this.expandedURL = paramJSONObject.getString("expanded_url"); !paramJSONObject.isNull("display_url"); this.expandedURL = this.url)
      {
        this.displayURL = paramJSONObject.getString("display_url");
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
    this.displayURL = this.url;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    URLEntityJSONImpl localURLEntityJSONImpl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localURLEntityJSONImpl = (URLEntityJSONImpl)paramObject;
      if (this.displayURL != null)
      {
        if (this.displayURL.equals(localURLEntityJSONImpl.displayURL));
      }
      else
        while (localURLEntityJSONImpl.displayURL != null)
          return false;
      if (this.expandedURL != null)
      {
        if (this.expandedURL.equals(localURLEntityJSONImpl.expandedURL));
      }
      else
        while (localURLEntityJSONImpl.expandedURL != null)
          return false;
      if (this.url == null)
        break;
    }
    while (this.url.equals(localURLEntityJSONImpl.url));
    while (true)
    {
      return false;
      if (localURLEntityJSONImpl.url == null)
        break;
    }
  }

  public String getDisplayURL()
  {
    return this.displayURL;
  }

  public int getEnd()
  {
    return super.getEnd();
  }

  public String getExpandedURL()
  {
    return this.expandedURL;
  }

  public int getStart()
  {
    return super.getStart();
  }

  public String getText()
  {
    return this.url;
  }

  public String getURL()
  {
    return this.url;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.url != null)
    {
      i = this.url.hashCode();
      j = i * 31;
      if (this.expandedURL == null)
        break label77;
    }
    label77: for (int k = this.expandedURL.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      String str = this.displayURL;
      int n = 0;
      if (str != null)
        n = this.displayURL.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public String toString()
  {
    return "URLEntityJSONImpl{url='" + this.url + '\'' + ", expandedURL='" + this.expandedURL + '\'' + ", displayURL='" + this.displayURL + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.URLEntityJSONImpl
 * JD-Core Version:    0.6.2
 */