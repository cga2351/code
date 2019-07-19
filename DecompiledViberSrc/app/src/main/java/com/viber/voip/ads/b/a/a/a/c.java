package com.viber.voip.ads.b.a.a.a;

import android.app.Activity;
import android.location.Location;
import com.google.android.gms.ads.AdSize;
import com.viber.voip.ads.b.a.a.l.a;
import java.util.HashMap;
import java.util.Map;

public class c
  implements l.a
{
  public final Activity a;
  public final int b;
  public final String c;
  public final AdSize[] d;
  public final Location e;
  public final Map<String, String> f;
  public final int g;

  private c(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
  }

  public static final class a
  {
    private final Activity a;
    private final int b;
    private final String c;
    private final AdSize[] d;
    private Location e;
    private Map<String, String> f;
    private int g = 2;

    public a(Activity paramActivity, int paramInt, String paramString, AdSize[] paramArrayOfAdSize)
    {
      this.a = paramActivity;
      this.b = paramInt;
      this.c = paramString;
      this.d = paramArrayOfAdSize;
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

    public c a()
    {
      return new c(this, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.a.a.c
 * JD-Core Version:    0.6.2
 */