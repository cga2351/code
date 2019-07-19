package twitter4j;

import java.io.Serializable;

public abstract interface Relationship extends Serializable, TwitterResponse
{
  public abstract boolean canSourceDm();

  public abstract long getSourceUserId();

  public abstract String getSourceUserScreenName();

  public abstract long getTargetUserId();

  public abstract String getTargetUserScreenName();

  public abstract boolean isSourceBlockingTarget();

  public abstract boolean isSourceFollowedByTarget();

  public abstract boolean isSourceFollowingTarget();

  public abstract boolean isSourceNotificationsEnabled();

  public abstract boolean isSourceWantRetweets();

  public abstract boolean isTargetFollowedBySource();

  public abstract boolean isTargetFollowingSource();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.Relationship
 * JD-Core Version:    0.6.2
 */