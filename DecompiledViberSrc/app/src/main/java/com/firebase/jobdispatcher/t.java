package com.firebase.jobdispatcher;

import android.net.Uri;

public final class t
{
  private final Uri a;
  private final int b;

  public t(Uri paramUri, int paramInt)
  {
    if (paramUri == null)
      throw new IllegalArgumentException("URI must not be null.");
    this.a = paramUri;
    this.b = paramInt;
  }

  public Uri a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    t localt;
    do
    {
      return true;
      if (!(paramObject instanceof t))
        return false;
      localt = (t)paramObject;
    }
    while ((this.b == localt.b) && (this.a.equals(localt.a)));
    return false;
  }

  public int hashCode()
  {
    return this.a.hashCode() ^ this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.t
 * JD-Core Version:    0.6.2
 */