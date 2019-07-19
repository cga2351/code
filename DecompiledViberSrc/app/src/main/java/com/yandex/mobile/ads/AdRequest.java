package com.yandex.mobile.ads;

import android.location.Location;
import java.util.List;
import java.util.Map;

public final class AdRequest
{
  private final String a;
  private final String b;
  private final String c;
  private final List<String> d;
  private final Location e;
  private final Map<String, String> f;

  private AdRequest(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.b = Builder.b(paramBuilder);
    this.c = Builder.c(paramBuilder);
    this.d = Builder.d(paramBuilder);
    this.e = Builder.e(paramBuilder);
    this.f = Builder.f(paramBuilder);
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AdRequest localAdRequest;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localAdRequest = (AdRequest)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localAdRequest.a));
      }
      else
        while (localAdRequest.a != null)
          return false;
      if (this.b != null)
      {
        if (this.b.equals(localAdRequest.b));
      }
      else
        while (localAdRequest.b != null)
          return false;
      if (this.c != null)
      {
        if (this.c.equals(localAdRequest.c));
      }
      else
        while (localAdRequest.c != null)
          return false;
      if (this.d != null)
      {
        if (this.d.equals(localAdRequest.d));
      }
      else
        while (localAdRequest.d != null)
          return false;
      if (this.f != null)
        return this.f.equals(localAdRequest.f);
    }
    while (localAdRequest.f == null);
    return false;
  }

  public final String getAge()
  {
    return this.a;
  }

  public final String getContextQuery()
  {
    return this.c;
  }

  public final List<String> getContextTags()
  {
    return this.d;
  }

  public final String getGender()
  {
    return this.b;
  }

  public final Location getLocation()
  {
    return this.e;
  }

  public final Map<String, String> getParameters()
  {
    return this.f;
  }

  public final int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i1;
    if (this.a != null)
    {
      i = this.a.hashCode();
      int j = i * 31;
      if (this.b == null)
        break label133;
      k = this.b.hashCode();
      int m = 31 * (k + j);
      if (this.c == null)
        break label138;
      n = this.c.hashCode();
      i1 = 31 * (n + m);
      if (this.d == null)
        break label144;
    }
    label133: label138: label144: for (int i2 = this.d.hashCode(); ; i2 = 0)
    {
      int i3 = 31 * (i2 + i1);
      Map localMap = this.f;
      int i4 = 0;
      if (localMap != null)
        i4 = this.f.hashCode();
      return i3 + i4;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
    }
  }

  public static final class Builder
  {
    private String a;
    private String b;
    private Location c;
    private String d;
    private List<String> e;
    private Map<String, String> f;

    public final AdRequest build()
    {
      return new AdRequest(this, (byte)0);
    }

    public final Builder withAge(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public final Builder withContextQuery(String paramString)
    {
      this.d = paramString;
      return this;
    }

    public final Builder withContextTags(List<String> paramList)
    {
      this.e = paramList;
      return this;
    }

    public final Builder withGender(String paramString)
    {
      this.b = paramString;
      return this;
    }

    public final Builder withLocation(Location paramLocation)
    {
      this.c = paramLocation;
      return this;
    }

    public final Builder withParameters(Map<String, String> paramMap)
    {
      this.f = paramMap;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.AdRequest
 * JD-Core Version:    0.6.2
 */