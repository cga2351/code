package twitter4j.internal.json;

import java.util.HashMap;
import java.util.Map;
import twitter4j.MediaEntity;
import twitter4j.MediaEntity.Size;
import twitter4j.TwitterException;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public class MediaEntityJSONImpl extends EntityIndex
  implements MediaEntity
{
  private static final long serialVersionUID = 224487082931268487L;
  private String displayURL;
  private String expandedURL;
  private long id;
  private String mediaURL;
  private String mediaURLHttps;
  private Map<Integer, MediaEntity.Size> sizes;
  private String type;
  private String url;

  MediaEntityJSONImpl()
  {
  }

  MediaEntityJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("indices");
      setStart(localJSONArray.getInt(0));
      setEnd(localJSONArray.getInt(1));
      this.id = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
      this.url = paramJSONObject.getString("url");
      this.expandedURL = paramJSONObject.getString("expanded_url");
      this.mediaURL = paramJSONObject.getString("media_url");
      this.mediaURLHttps = paramJSONObject.getString("media_url_https");
      this.displayURL = paramJSONObject.getString("display_url");
      JSONObject localJSONObject = paramJSONObject.getJSONObject("sizes");
      this.sizes = new HashMap(4);
      addMediaEntitySizeIfNotNull(this.sizes, localJSONObject, MediaEntity.Size.LARGE, "large");
      addMediaEntitySizeIfNotNull(this.sizes, localJSONObject, MediaEntity.Size.MEDIUM, "medium");
      addMediaEntitySizeIfNotNull(this.sizes, localJSONObject, MediaEntity.Size.SMALL, "small");
      addMediaEntitySizeIfNotNull(this.sizes, localJSONObject, MediaEntity.Size.THUMB, "thumb");
      if (!paramJSONObject.isNull("type"))
        this.type = paramJSONObject.getString("type");
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
  }

  private void addMediaEntitySizeIfNotNull(Map<Integer, MediaEntity.Size> paramMap, JSONObject paramJSONObject, Integer paramInteger, String paramString)
    throws JSONException
  {
    if (!paramJSONObject.isNull(paramString))
      paramMap.put(paramInteger, new Size(paramJSONObject.getJSONObject(paramString)));
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    MediaEntityJSONImpl localMediaEntityJSONImpl;
    do
    {
      return true;
      if (!(paramObject instanceof MediaEntityJSONImpl))
        return false;
      localMediaEntityJSONImpl = (MediaEntityJSONImpl)paramObject;
    }
    while (this.id == localMediaEntityJSONImpl.id);
    return false;
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

  public long getId()
  {
    return this.id;
  }

  public String getMediaURL()
  {
    return this.mediaURL;
  }

  public String getMediaURLHttps()
  {
    return this.mediaURLHttps;
  }

  public Map<Integer, MediaEntity.Size> getSizes()
  {
    return this.sizes;
  }

  public int getStart()
  {
    return super.getStart();
  }

  public String getText()
  {
    return this.url;
  }

  public String getType()
  {
    return this.type;
  }

  public String getURL()
  {
    return this.url;
  }

  public int hashCode()
  {
    return (int)(this.id ^ this.id >>> 32);
  }

  public String toString()
  {
    return "MediaEntityJSONImpl{id=" + this.id + ", url=" + this.url + ", mediaURL=" + this.mediaURL + ", mediaURLHttps=" + this.mediaURLHttps + ", expandedURL=" + this.expandedURL + ", displayURL='" + this.displayURL + '\'' + ", sizes=" + this.sizes + ", type=" + this.type + '}';
  }

  static class Size
    implements MediaEntity.Size
  {
    private static final long serialVersionUID = 8681853416159361581L;
    int height;
    int resize;
    int width;

    Size(JSONObject paramJSONObject)
      throws JSONException
    {
      this.width = paramJSONObject.getInt("w");
      this.height = paramJSONObject.getInt("h");
      if ("fit".equals(paramJSONObject.getString("resize")));
      for (int i = 100; ; i = 101)
      {
        this.resize = i;
        return;
      }
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Size localSize;
      do
      {
        return true;
        if (!(paramObject instanceof Size))
          return false;
        localSize = (Size)paramObject;
        if (this.height != localSize.height)
          return false;
        if (this.resize != localSize.resize)
          return false;
      }
      while (this.width == localSize.width);
      return false;
    }

    public int getHeight()
    {
      return this.height;
    }

    public int getResize()
    {
      return this.resize;
    }

    public int getWidth()
    {
      return this.width;
    }

    public int hashCode()
    {
      return 31 * (31 * this.width + this.height) + this.resize;
    }

    public String toString()
    {
      return "Size{width=" + this.width + ", height=" + this.height + ", resize=" + this.resize + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.MediaEntityJSONImpl
 * JD-Core Version:    0.6.2
 */