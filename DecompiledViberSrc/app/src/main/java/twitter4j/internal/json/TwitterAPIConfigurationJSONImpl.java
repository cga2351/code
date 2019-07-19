package twitter4j.internal.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import twitter4j.MediaEntity.Size;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class TwitterAPIConfigurationJSONImpl extends TwitterResponseImpl
  implements TwitterAPIConfiguration
{
  private static final long serialVersionUID = 5786291660087491465L;
  private int charactersReservedPerMedia;
  private int maxMediaPerUpload;
  private String[] nonUsernamePaths;
  private int photoSizeLimit;
  private Map<Integer, MediaEntity.Size> photoSizes;
  private int shortURLLength;
  private int shortURLLengthHttps;

  TwitterAPIConfigurationJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    super(paramHttpResponse);
    try
    {
      JSONObject localJSONObject1 = paramHttpResponse.asJSONObject();
      this.photoSizeLimit = z_T4JInternalParseUtil.getInt("photo_size_limit", localJSONObject1);
      this.shortURLLength = z_T4JInternalParseUtil.getInt("short_url_length", localJSONObject1);
      this.shortURLLengthHttps = z_T4JInternalParseUtil.getInt("short_url_length_https", localJSONObject1);
      this.charactersReservedPerMedia = z_T4JInternalParseUtil.getInt("characters_reserved_per_media", localJSONObject1);
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("photo_sizes");
      this.photoSizes = new HashMap(4);
      this.photoSizes.put(MediaEntity.Size.LARGE, new MediaEntityJSONImpl.Size(localJSONObject2.getJSONObject("large")));
      if (localJSONObject2.isNull("med"));
      for (JSONObject localJSONObject3 = localJSONObject2.getJSONObject("medium"); ; localJSONObject3 = localJSONObject2.getJSONObject("med"))
      {
        this.photoSizes.put(MediaEntity.Size.MEDIUM, new MediaEntityJSONImpl.Size(localJSONObject3));
        this.photoSizes.put(MediaEntity.Size.SMALL, new MediaEntityJSONImpl.Size(localJSONObject2.getJSONObject("small")));
        this.photoSizes.put(MediaEntity.Size.THUMB, new MediaEntityJSONImpl.Size(localJSONObject2.getJSONObject("thumb")));
        if (paramConfiguration.isJSONStoreEnabled())
        {
          DataObjectFactoryUtil.clearThreadLocalMap();
          DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse.asJSONObject());
        }
        JSONArray localJSONArray = localJSONObject1.getJSONArray("non_username_paths");
        this.nonUsernamePaths = new String[localJSONArray.length()];
        for (int i = 0; i < localJSONArray.length(); i++)
          this.nonUsernamePaths[i] = localJSONArray.getString(i);
      }
      this.maxMediaPerUpload = z_T4JInternalParseUtil.getInt("max_media_per_upload", localJSONObject1);
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
    TwitterAPIConfigurationJSONImpl localTwitterAPIConfigurationJSONImpl;
    do
    {
      return true;
      if (!(paramObject instanceof TwitterAPIConfigurationJSONImpl))
        return false;
      localTwitterAPIConfigurationJSONImpl = (TwitterAPIConfigurationJSONImpl)paramObject;
      if (this.charactersReservedPerMedia != localTwitterAPIConfigurationJSONImpl.charactersReservedPerMedia)
        return false;
      if (this.maxMediaPerUpload != localTwitterAPIConfigurationJSONImpl.maxMediaPerUpload)
        return false;
      if (this.photoSizeLimit != localTwitterAPIConfigurationJSONImpl.photoSizeLimit)
        return false;
      if (this.shortURLLength != localTwitterAPIConfigurationJSONImpl.shortURLLength)
        return false;
      if (this.shortURLLengthHttps != localTwitterAPIConfigurationJSONImpl.shortURLLengthHttps)
        return false;
      if (!Arrays.equals(this.nonUsernamePaths, localTwitterAPIConfigurationJSONImpl.nonUsernamePaths))
        return false;
      if (this.photoSizes == null)
        break;
    }
    while (this.photoSizes.equals(localTwitterAPIConfigurationJSONImpl.photoSizes));
    while (true)
    {
      return false;
      if (localTwitterAPIConfigurationJSONImpl.photoSizes == null)
        break;
    }
  }

  public int getCharactersReservedPerMedia()
  {
    return this.charactersReservedPerMedia;
  }

  public int getMaxMediaPerUpload()
  {
    return this.maxMediaPerUpload;
  }

  public String[] getNonUsernamePaths()
  {
    return this.nonUsernamePaths;
  }

  public int getPhotoSizeLimit()
  {
    return this.photoSizeLimit;
  }

  public Map<Integer, MediaEntity.Size> getPhotoSizes()
  {
    return this.photoSizes;
  }

  public int getShortURLLength()
  {
    return this.shortURLLength;
  }

  public int getShortURLLengthHttps()
  {
    return this.shortURLLengthHttps;
  }

  public int hashCode()
  {
    int i = 31 * (31 * (31 * (31 * this.photoSizeLimit + this.shortURLLength) + this.shortURLLengthHttps) + this.charactersReservedPerMedia);
    if (this.photoSizes != null);
    for (int j = this.photoSizes.hashCode(); ; j = 0)
    {
      int k = 31 * (j + i);
      String[] arrayOfString = this.nonUsernamePaths;
      int m = 0;
      if (arrayOfString != null)
        m = Arrays.hashCode(this.nonUsernamePaths);
      return 31 * (k + m) + this.maxMediaPerUpload;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("TwitterAPIConfigurationJSONImpl{photoSizeLimit=").append(this.photoSizeLimit).append(", shortURLLength=").append(this.shortURLLength).append(", shortURLLengthHttps=").append(this.shortURLLengthHttps).append(", charactersReservedPerMedia=").append(this.charactersReservedPerMedia).append(", photoSizes=").append(this.photoSizes).append(", nonUsernamePaths=");
    if (this.nonUsernamePaths == null);
    for (Object localObject = null; ; localObject = Arrays.asList(this.nonUsernamePaths))
      return localObject + ", maxMediaPerUpload=" + this.maxMediaPerUpload + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.TwitterAPIConfigurationJSONImpl
 * JD-Core Version:    0.6.2
 */