package twitter4j;

import java.io.Serializable;
import java.util.Date;

public abstract interface SavedSearch extends Serializable, Comparable<SavedSearch>, TwitterResponse
{
  public abstract Date getCreatedAt();

  public abstract int getId();

  public abstract String getName();

  public abstract int getPosition();

  public abstract String getQuery();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.SavedSearch
 * JD-Core Version:    0.6.2
 */