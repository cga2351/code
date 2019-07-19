package com.shopchat.library.events;

public class RecommendedHttpFailure
{
  private Throwable _cause;

  public RecommendedHttpFailure(Throwable paramThrowable)
  {
    this._cause = paramThrowable;
  }

  public Throwable getCause()
  {
    return this._cause;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.events.RecommendedHttpFailure
 * JD-Core Version:    0.6.2
 */