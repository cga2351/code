package twitter4j.internal.json;

import twitter4j.Location;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class LocationJSONImpl
  implements Location
{
  private static final long serialVersionUID = 7095092358530897222L;
  private final String countryCode;
  private final String countryName;
  private final String name;
  private final int placeCode;
  private final String placeName;
  private final String url;
  private final int woeid;

  LocationJSONImpl(JSONObject paramJSONObject)
    throws TwitterException
  {
    try
    {
      this.woeid = z_T4JInternalParseUtil.getInt("woeid", paramJSONObject);
      this.countryName = z_T4JInternalParseUtil.getUnescapedString("country", paramJSONObject);
      this.countryCode = z_T4JInternalParseUtil.getRawString("countryCode", paramJSONObject);
      JSONObject localJSONObject;
      if (!paramJSONObject.isNull("placeType"))
      {
        localJSONObject = paramJSONObject.getJSONObject("placeType");
        this.placeName = z_T4JInternalParseUtil.getUnescapedString("name", localJSONObject);
      }
      for (this.placeCode = z_T4JInternalParseUtil.getInt("code", localJSONObject); ; this.placeCode = -1)
      {
        this.name = z_T4JInternalParseUtil.getUnescapedString("name", paramJSONObject);
        this.url = z_T4JInternalParseUtil.getUnescapedString("url", paramJSONObject);
        return;
        this.placeName = null;
      }
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
  }

  static ResponseList<Location> createLocationList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
    throws TwitterException
  {
    if (paramConfiguration.isJSONStoreEnabled())
      DataObjectFactoryUtil.clearThreadLocalMap();
    return createLocationList(paramHttpResponse.asJSONArray(), paramConfiguration.isJSONStoreEnabled());
  }

  static ResponseList<Location> createLocationList(JSONArray paramJSONArray, boolean paramBoolean)
    throws TwitterException
  {
    while (true)
    {
      int j;
      try
      {
        int i = paramJSONArray.length();
        ResponseListImpl localResponseListImpl = new ResponseListImpl(i, null);
        j = 0;
        if (j < i)
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(j);
          LocationJSONImpl localLocationJSONImpl = new LocationJSONImpl(localJSONObject);
          localResponseListImpl.add(localLocationJSONImpl);
          if (paramBoolean)
            DataObjectFactoryUtil.registerJSONObject(localLocationJSONImpl, localJSONObject);
        }
        else
        {
          if (paramBoolean)
            DataObjectFactoryUtil.registerJSONObject(localResponseListImpl, paramJSONArray);
          return localResponseListImpl;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new TwitterException(localJSONException);
      }
      catch (TwitterException localTwitterException)
      {
        throw localTwitterException;
      }
      j++;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationJSONImpl localLocationJSONImpl;
    do
    {
      return true;
      if (!(paramObject instanceof LocationJSONImpl))
        return false;
      localLocationJSONImpl = (LocationJSONImpl)paramObject;
    }
    while (this.woeid == localLocationJSONImpl.woeid);
    return false;
  }

  public String getCountryCode()
  {
    return this.countryCode;
  }

  public String getCountryName()
  {
    return this.countryName;
  }

  public String getName()
  {
    return this.name;
  }

  public int getPlaceCode()
  {
    return this.placeCode;
  }

  public String getPlaceName()
  {
    return this.placeName;
  }

  public String getURL()
  {
    return this.url;
  }

  public int getWoeid()
  {
    return this.woeid;
  }

  public int hashCode()
  {
    return this.woeid;
  }

  public String toString()
  {
    return "LocationJSONImpl{woeid=" + this.woeid + ", countryName='" + this.countryName + '\'' + ", countryCode='" + this.countryCode + '\'' + ", placeName='" + this.placeName + '\'' + ", placeCode='" + this.placeCode + '\'' + ", name='" + this.name + '\'' + ", url='" + this.url + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.LocationJSONImpl
 * JD-Core Version:    0.6.2
 */