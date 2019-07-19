package twitter4j;

import java.io.Serializable;
import java.util.Date;

public abstract interface DirectMessage extends Serializable, EntitySupport, TwitterResponse
{
  public abstract Date getCreatedAt();

  public abstract long getId();

  public abstract User getRecipient();

  public abstract long getRecipientId();

  public abstract String getRecipientScreenName();

  public abstract User getSender();

  public abstract long getSenderId();

  public abstract String getSenderScreenName();

  public abstract String getText();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.DirectMessage
 * JD-Core Version:    0.6.2
 */