package twitter4j.api;

import twitter4j.IDs;
import twitter4j.OEmbed;
import twitter4j.OEmbedRequest;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;

public abstract interface TweetsResources
{
  public abstract Status destroyStatus(long paramLong)
    throws TwitterException;

  public abstract OEmbed getOEmbed(OEmbedRequest paramOEmbedRequest)
    throws TwitterException;

  public abstract IDs getRetweeterIds(long paramLong1, int paramInt, long paramLong2)
    throws TwitterException;

  public abstract IDs getRetweeterIds(long paramLong1, long paramLong2)
    throws TwitterException;

  public abstract ResponseList<Status> getRetweets(long paramLong)
    throws TwitterException;

  public abstract Status retweetStatus(long paramLong)
    throws TwitterException;

  public abstract Status showStatus(long paramLong)
    throws TwitterException;

  public abstract Status updateStatus(String paramString)
    throws TwitterException;

  public abstract Status updateStatus(StatusUpdate paramStatusUpdate)
    throws TwitterException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.api.TweetsResources
 * JD-Core Version:    0.6.2
 */