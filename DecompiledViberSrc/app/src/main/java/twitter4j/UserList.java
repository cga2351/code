package twitter4j;

import java.io.Serializable;
import java.net.URI;

public abstract interface UserList extends Serializable, Comparable<UserList>, TwitterResponse
{
  public abstract String getDescription();

  public abstract String getFullName();

  public abstract int getId();

  public abstract int getMemberCount();

  public abstract String getName();

  public abstract String getSlug();

  public abstract int getSubscriberCount();

  public abstract URI getURI();

  public abstract User getUser();

  public abstract boolean isFollowing();

  public abstract boolean isPublic();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.UserList
 * JD-Core Version:    0.6.2
 */