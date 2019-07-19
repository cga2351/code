package twitter4j;

import java.io.Serializable;

public abstract interface Friendship extends Serializable
{
  public abstract long getId();

  public abstract String getName();

  public abstract String getScreenName();

  public abstract boolean isFollowedBy();

  public abstract boolean isFollowing();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.Friendship
 * JD-Core Version:    0.6.2
 */