package twitter4j.internal.json;

import java.io.Serializable;
import twitter4j.OEmbed;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public class OEmbedJSONImpl extends TwitterResponseImpl
  implements Serializable, OEmbed
{
  private static final long serialVersionUID = -675438169712979958L;
  private String authorName;
  private String authorURL;
  private long cacheAge;
  private String html;
  private String url;
  private String version;
  private int width;

  OEmbedJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    super(paramHttpResponse);
    JSONObject localJSONObject = paramHttpResponse.asJSONObject();
    init(localJSONObject);
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, localJSONObject);
    }
  }

  OEmbedJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    init(paramJSONObject);
  }

  private void init(JSONObject paramJSONObject)
    throws TwitterException
  {
    try
    {
      this.html = paramJSONObject.getString("html");
      this.authorName = paramJSONObject.getString("author_name");
      this.url = paramJSONObject.getString("url");
      this.version = paramJSONObject.getString("version");
      this.cacheAge = paramJSONObject.getLong("cache_age");
      this.authorURL = paramJSONObject.getString("author_url");
      this.width = paramJSONObject.getInt("width");
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    OEmbedJSONImpl localOEmbedJSONImpl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localOEmbedJSONImpl = (OEmbedJSONImpl)paramObject;
      if (this.cacheAge != localOEmbedJSONImpl.cacheAge)
        return false;
      if (this.width != localOEmbedJSONImpl.width)
        return false;
      if (this.authorName != null)
      {
        if (this.authorName.equals(localOEmbedJSONImpl.authorName));
      }
      else
        while (localOEmbedJSONImpl.authorName != null)
          return false;
      if (this.authorURL != null)
      {
        if (this.authorURL.equals(localOEmbedJSONImpl.authorURL));
      }
      else
        while (localOEmbedJSONImpl.authorURL != null)
          return false;
      if (this.html != null)
      {
        if (this.html.equals(localOEmbedJSONImpl.html));
      }
      else
        while (localOEmbedJSONImpl.html != null)
          return false;
      if (this.url != null)
      {
        if (this.url.equals(localOEmbedJSONImpl.url));
      }
      else
        while (localOEmbedJSONImpl.url != null)
          return false;
      if (this.version == null)
        break;
    }
    while (this.version.equals(localOEmbedJSONImpl.version));
    while (true)
    {
      return false;
      if (localOEmbedJSONImpl.version == null)
        break;
    }
  }

  public String getAuthorName()
  {
    return this.authorName;
  }

  public String getAuthorURL()
  {
    return this.authorURL;
  }

  public long getCacheAge()
  {
    return this.cacheAge;
  }

  public String getHtml()
  {
    return this.html;
  }

  public String getURL()
  {
    return this.url;
  }

  public String getVersion()
  {
    return this.version;
  }

  public int getWidth()
  {
    return this.width;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i1;
    if (this.html != null)
    {
      i = this.html.hashCode();
      int j = i * 31;
      if (this.authorName == null)
        break label154;
      k = this.authorName.hashCode();
      int m = 31 * (k + j);
      if (this.url == null)
        break label159;
      n = this.url.hashCode();
      i1 = 31 * (n + m);
      if (this.version == null)
        break label165;
    }
    label154: label159: label165: for (int i2 = this.version.hashCode(); ; i2 = 0)
    {
      int i3 = 31 * (31 * (i2 + i1) + (int)(this.cacheAge ^ this.cacheAge >>> 32));
      String str = this.authorURL;
      int i4 = 0;
      if (str != null)
        i4 = this.authorURL.hashCode();
      return 31 * (i3 + i4) + this.width;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
    }
  }

  public String toString()
  {
    return "OEmbedJSONImpl{html='" + this.html + '\'' + ", authorName='" + this.authorName + '\'' + ", url='" + this.url + '\'' + ", version='" + this.version + '\'' + ", cacheAge=" + this.cacheAge + ", authorURL='" + this.authorURL + '\'' + ", width=" + this.width + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.OEmbedJSONImpl
 * JD-Core Version:    0.6.2
 */