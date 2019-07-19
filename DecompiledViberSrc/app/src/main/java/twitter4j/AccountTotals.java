package twitter4j;

import java.io.Serializable;

public abstract interface AccountTotals extends Serializable, TwitterResponse
{
  public abstract int getFavorites();

  public abstract int getFollowers();

  public abstract int getFriends();

  public abstract int getUpdates();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.AccountTotals
 * JD-Core Version:    0.6.2
 */