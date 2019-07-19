package com.adsnative.ads;

import android.location.Location;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aa
{
  private final List<String> a;
  private Map<String, String> b;
  private Map<String, ArrayList<String>> c;
  private final Location d;
  private final EnumSet<Object> e;
  private final boolean f;

  private aa(a parama)
  {
    this.a = a.a(parama);
    this.d = a.b(parama);
    this.e = a.c(parama);
    this.b = a.d(parama);
    this.c = parama.a;
    this.f = a.e(parama);
  }

  public final List<String> a()
  {
    return this.a;
  }

  public final Map<String, String> b()
  {
    return this.b;
  }

  public Map<String, ArrayList<String>> c()
  {
    return this.c;
  }

  public final Location d()
  {
    return this.d;
  }

  public final boolean e()
  {
    return this.f;
  }

  public static final class a
  {
    public Map<String, ArrayList<String>> a = new HashMap();
    private List<String> b;
    private Location c;
    private EnumSet<Object> d;
    private Map<String, String> e;
    private boolean f = true;

    public final a a(Location paramLocation)
    {
      this.c = paramLocation;
      return this;
    }

    public final a a(String paramString, String[] paramArrayOfString)
    {
      if (!this.a.containsKey(paramString))
        this.a.put(paramString, new ArrayList());
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        ((ArrayList)this.a.get(paramString)).add(str);
      }
      return this;
    }

    public final a a(Map<String, String> paramMap)
    {
      this.e = paramMap;
      return this;
    }

    public final a a(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }

    public final aa a()
    {
      return new aa(this, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.aa
 * JD-Core Version:    0.6.2
 */