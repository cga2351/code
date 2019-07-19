package twitter4j;

import java.io.Serializable;

public abstract interface RateLimitStatus extends Serializable
{
  public abstract int getLimit();

  public abstract int getRemaining();

  public abstract int getRemainingHits();

  public abstract int getResetTimeInSeconds();

  public abstract int getSecondsUntilReset();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.RateLimitStatus
 * JD-Core Version:    0.6.2
 */