package com.firebase.jobdispatcher;

import java.util.List;

public final class v
{
  public static final r.c a = new r.c();

  public static r.a a(List<t> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      throw new IllegalArgumentException("Uris must not be null or empty.");
    return new r.a(paramList);
  }

  public static r.b a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Window start can't be less than 0");
    if (paramInt2 < paramInt1)
      throw new IllegalArgumentException("Window end can't be less than window start");
    return new r.b(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.v
 * JD-Core Version:    0.6.2
 */