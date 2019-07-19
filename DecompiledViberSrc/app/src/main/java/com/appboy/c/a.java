package com.appboy.c;

import com.appboy.e.a.c;
import java.util.List;

public class a
{
  private final List<c> a;
  private final String b;
  private final long c;
  private final boolean d;

  public a(List<c> paramList, String paramString, long paramLong, boolean paramBoolean)
  {
    this.b = paramString;
    this.a = paramList;
    this.c = paramLong;
    this.d = paramBoolean;
  }

  public boolean a()
  {
    return this.d;
  }

  public List<c> b()
  {
    return this.a;
  }

  public boolean c()
  {
    return this.a.isEmpty();
  }

  public long d()
  {
    return this.c;
  }

  public String toString()
  {
    return "ContentCardsUpdatedEvent{mContentCards=" + this.a + ", mUserId='" + this.b + '\'' + ", mTimestamp=" + this.c + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.c.a
 * JD-Core Version:    0.6.2
 */