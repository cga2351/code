package twitter4j;

import java.util.List;

public abstract interface ResponseList<T> extends List<T>, TwitterResponse
{
  public abstract RateLimitStatus getRateLimitStatus();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.ResponseList
 * JD-Core Version:    0.6.2
 */