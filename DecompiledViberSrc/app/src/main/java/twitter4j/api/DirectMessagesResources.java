package twitter4j.api;

import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.TwitterException;

public abstract interface DirectMessagesResources
{
  public abstract DirectMessage destroyDirectMessage(long paramLong)
    throws TwitterException;

  public abstract ResponseList<DirectMessage> getDirectMessages()
    throws TwitterException;

  public abstract ResponseList<DirectMessage> getDirectMessages(Paging paramPaging)
    throws TwitterException;

  public abstract ResponseList<DirectMessage> getSentDirectMessages()
    throws TwitterException;

  public abstract ResponseList<DirectMessage> getSentDirectMessages(Paging paramPaging)
    throws TwitterException;

  public abstract DirectMessage sendDirectMessage(long paramLong, String paramString)
    throws TwitterException;

  public abstract DirectMessage sendDirectMessage(String paramString1, String paramString2)
    throws TwitterException;

  public abstract DirectMessage showDirectMessage(long paramLong)
    throws TwitterException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.api.DirectMessagesResources
 * JD-Core Version:    0.6.2
 */