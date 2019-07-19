package twitter4j;

import java.io.Serializable;

public abstract interface IDs extends Serializable, CursorSupport, TwitterResponse
{
  public abstract long[] getIDs();

  public abstract long getNextCursor();

  public abstract long getPreviousCursor();

  public abstract boolean hasNext();

  public abstract boolean hasPrevious();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.IDs
 * JD-Core Version:    0.6.2
 */