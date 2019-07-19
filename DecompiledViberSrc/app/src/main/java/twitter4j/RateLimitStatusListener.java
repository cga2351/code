package twitter4j;

public abstract interface RateLimitStatusListener
{
  public abstract void onRateLimitReached(RateLimitStatusEvent paramRateLimitStatusEvent);

  public abstract void onRateLimitStatus(RateLimitStatusEvent paramRateLimitStatusEvent);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.RateLimitStatusListener
 * JD-Core Version:    0.6.2
 */