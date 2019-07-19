package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.SimilarPlaces;
import twitter4j.TwitterException;

public abstract interface PlacesGeoResources
{
  public abstract Place createPlace(String paramString1, String paramString2, String paramString3, GeoLocation paramGeoLocation, String paramString4)
    throws TwitterException;

  public abstract Place getGeoDetails(String paramString)
    throws TwitterException;

  public abstract SimilarPlaces getSimilarPlaces(GeoLocation paramGeoLocation, String paramString1, String paramString2, String paramString3)
    throws TwitterException;

  public abstract ResponseList<Place> reverseGeoCode(GeoQuery paramGeoQuery)
    throws TwitterException;

  public abstract ResponseList<Place> searchPlaces(GeoQuery paramGeoQuery)
    throws TwitterException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.api.PlacesGeoResources
 * JD-Core Version:    0.6.2
 */