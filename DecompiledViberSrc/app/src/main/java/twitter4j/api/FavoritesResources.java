package twitter4j.api;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;

public abstract interface FavoritesResources
{
  public abstract Status createFavorite(long paramLong)
    throws TwitterException;

  public abstract Status destroyFavorite(long paramLong)
    throws TwitterException;

  public abstract ResponseList<Status> getFavorites()
    throws TwitterException;

  public abstract ResponseList<Status> getFavorites(long paramLong)
    throws TwitterException;

  public abstract ResponseList<Status> getFavorites(long paramLong, Paging paramPaging)
    throws TwitterException;

  public abstract ResponseList<Status> getFavorites(String paramString)
    throws TwitterException;

  public abstract ResponseList<Status> getFavorites(String paramString, Paging paramPaging)
    throws TwitterException;

  public abstract ResponseList<Status> getFavorites(Paging paramPaging)
    throws TwitterException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.api.FavoritesResources
 * JD-Core Version:    0.6.2
 */