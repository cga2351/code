package twitter4j;

import java.util.EventObject;

public final class RateLimitStatusEvent extends EventObject
{
  private static final long serialVersionUID = -2332507741769177298L;
  private boolean isAccountRateLimitStatus;
  private RateLimitStatus rateLimitStatus;

  RateLimitStatusEvent(Object paramObject, RateLimitStatus paramRateLimitStatus, boolean paramBoolean)
  {
    super(paramObject);
    this.rateLimitStatus = paramRateLimitStatus;
    this.isAccountRateLimitStatus = paramBoolean;
  }

  public RateLimitStatus getRateLimitStatus()
  {
    return this.rateLimitStatus;
  }

  public boolean isAccountRateLimitStatus()
  {
    return this.isAccountRateLimitStatus;
  }

  public boolean isIPRateLimitStatus()
  {
    return !this.isAccountRateLimitStatus;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.RateLimitStatusEvent
 * JD-Core Version:    0.6.2
 */