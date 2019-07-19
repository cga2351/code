package twitter4j;

public abstract interface EntitySupport
{
  public abstract HashtagEntity[] getHashtagEntities();

  public abstract MediaEntity[] getMediaEntities();

  public abstract SymbolEntity[] getSymbolEntities();

  public abstract URLEntity[] getURLEntities();

  public abstract UserMentionEntity[] getUserMentionEntities();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.EntitySupport
 * JD-Core Version:    0.6.2
 */