package twitter4j.api;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;

public abstract interface SearchResource
{
  public abstract QueryResult search(Query paramQuery)
    throws TwitterException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.api.SearchResource
 * JD-Core Version:    0.6.2
 */