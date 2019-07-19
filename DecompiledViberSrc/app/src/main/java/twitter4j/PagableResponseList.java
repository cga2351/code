package twitter4j;

public abstract interface PagableResponseList<T extends TwitterResponse> extends CursorSupport, ResponseList<T>
{
  public abstract long getNextCursor();

  public abstract long getPreviousCursor();

  public abstract boolean hasNext();

  public abstract boolean hasPrevious();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.PagableResponseList
 * JD-Core Version:    0.6.2
 */