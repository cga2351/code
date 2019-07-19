package com.appboy.c;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static final String a = com.appboy.f.c.a(b.class);
  private final List<com.appboy.e.a.c> b;
  private final String c;
  private final boolean d;
  private final long e;

  public b(List<com.appboy.e.a.c> paramList, String paramString, boolean paramBoolean, long paramLong)
  {
    this.c = paramString;
    this.d = paramBoolean;
    if (paramList == null)
      throw new NullPointerException();
    this.b = paramList;
    this.e = paramLong;
  }

  public List<com.appboy.e.a.c> a(EnumSet<com.appboy.b.b> paramEnumSet)
  {
    if (paramEnumSet == null);
    ArrayList localArrayList;
    try
    {
      com.appboy.f.c.c(a, "The categories passed to getFeedCards are null, FeedUpdatedEvent is going to return all the cards in cache.");
      paramEnumSet = com.appboy.b.b.a();
      if (paramEnumSet.isEmpty())
      {
        com.appboy.f.c.d(a, "The parameter passed into categories is not valid, Braze is returning an empty card list.Please pass in a non-empty EnumSet of CardCategory for getFeedCards().");
        return new ArrayList();
      }
      localArrayList = new ArrayList();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        com.appboy.e.a.c localc = (com.appboy.e.a.c)localIterator.next();
        if ((localc.a(paramEnumSet)) && (!localc.t()))
          localArrayList.add(localc);
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(a, "Unable to get cards with categories[" + paramEnumSet + "]. Ignoring.", localException);
      return null;
    }
    return localArrayList;
  }

  public boolean a()
  {
    return this.d;
  }

  public int b(EnumSet<com.appboy.b.b> paramEnumSet)
  {
    if (paramEnumSet == null)
    {
      com.appboy.f.c.c(a, "The categories passed into getCardCount are null, FeedUpdatedEvent is going to return the count of all the cards in cache.");
      return this.b.size();
    }
    if (paramEnumSet.isEmpty())
    {
      com.appboy.f.c.d(a, "The parameters passed into categories are not valid, Braze is returning 0 in getCardCount().Please pass in a non-empty EnumSet of CardCategory.");
      return 0;
    }
    return a(paramEnumSet).size();
  }

  public long b()
  {
    return this.e;
  }

  public int c(EnumSet<com.appboy.b.b> paramEnumSet)
  {
    if (paramEnumSet == null)
    {
      com.appboy.f.c.d(a, "The categories passed to getUnreadCardCount are null, FeedUpdatedEvent is going to return the count of all the unread cards in cache.");
      return c(com.appboy.b.b.a());
    }
    if (paramEnumSet.isEmpty())
    {
      com.appboy.f.c.d(a, "The parameters passed into categories are Empty, Braze is returning 0 in getUnreadCardCount().Please pass in a non-empty EnumSet of CardCategory.");
      return 0;
    }
    Iterator localIterator = this.b.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      com.appboy.e.a.c localc = (com.appboy.e.a.c)localIterator.next();
      if ((!localc.a(paramEnumSet)) || (localc.l()) || (localc.t()))
        break label109;
    }
    label109: for (int j = i + 1; ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FeedUpdatedEvent{");
    localStringBuilder.append("mFeedCards=").append(this.b);
    localStringBuilder.append(", mUserId='").append(this.c).append('\'');
    localStringBuilder.append(", mFromOfflineStorage=").append(this.d);
    localStringBuilder.append(", mTimestamp=").append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.c.b
 * JD-Core Version:    0.6.2
 */