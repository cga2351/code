package com.viber.voip.ads.b.a.a.a;

import android.app.Activity;
import android.location.Location;
import com.viber.voip.ads.b.a.a.l.a;
import java.util.HashMap;
import java.util.Map;

public class a
  implements l.a
{
  public final Activity a;
  public final int b;
  public final String c;
  public final String d;
  public final Location e;
  public final Map<String, String> f;
  public final Map<String, String> g;
  public final int h;

  private a(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
  }

  public static final class a
  {
    private final Activity a;
    private final int b;
    private final String c;
    private final String d;
    private Location e;
    private Map<String, String> f;
    private Map<String, String> g;
    private int h = 2;

    public a(Activity paramActivity, int paramInt, String paramString1, String paramString2)
    {
      this.a = paramActivity;
      this.b = paramInt;
      this.c = paramString1;
      this.d = paramString2;
    }

    public a a(int paramInt)
    {
      this.h = paramInt;
      return this;
    }

    public a a(Location paramLocation)
    {
      this.e = paramLocation;
      return this;
    }

    public a a(Map<String, String> paramMap)
    {
      if (this.f == null)
        this.f = new HashMap();
      this.f.putAll(paramMap);
      return this;
    }

    public a a()
    {
      return new a(this, null);
    }

    public a b(Map<String, String> paramMap)
    {
      if (this.g == null)
        this.g = new HashMap();
      this.g.putAll(paramMap);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.a.a.a
 * JD-Core Version:    0.6.2
 */