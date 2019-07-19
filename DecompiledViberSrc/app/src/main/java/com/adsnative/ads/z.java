package com.adsnative.ads;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.adsnative.b.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class z
{
  private static final p b = new p()
  {
    public void a()
    {
    }

    public void a(n paramAnonymousn)
    {
    }

    public void a(String paramAnonymousString)
    {
    }

    public boolean b(n paramAnonymousn)
    {
      return false;
    }
  };
  protected i a;
  private final Context c;
  private final g d;
  private final HashMap<n, WeakReference<View>> e;
  private final WeakHashMap<View, n> f;
  private p g = b;
  private String h;
  private o i;
  private b j;
  private t k;
  private String l;

  public z(Context paramContext, String paramString)
  {
    this.c = paramContext;
    this.h = paramString;
    this.d = new g(paramContext);
    this.e = new HashMap();
    this.f = new WeakHashMap();
    a();
  }

  private void a()
  {
    q.a local2 = new q.a()
    {
      public void a(String paramAnonymousString)
      {
        if (z.this.a(paramAnonymousString))
          z.a(z.this, paramAnonymousString);
      }

      public void a(JSONObject paramAnonymousJSONObject)
        throws JSONException
      {
        if (z.a(z.this) != null)
        {
          com.adsnative.c.i.b("PMNativeAd -> onVideoConfigsLoad() : " + paramAnonymousJSONObject.toString());
          z.a(z.this).a(paramAnonymousJSONObject);
          return;
        }
        com.adsnative.c.i.e("Attempted to updateVideoConfigs on null mAdRenderer");
      }
    };
    this.a = new i(this.h, this.c, local2);
    this.a.a();
  }

  public void a(aa paramaa)
  {
    a(this.h, paramaa);
  }

  public void a(n paramn, View paramView)
  {
    if ((paramn != null) && (paramView != null))
    {
      if (!paramn.F())
        this.d.a(paramView, paramn);
      paramn.a(paramView);
      return;
    }
    com.adsnative.c.i.e("Attempted to attachViewForInteraction when nativeAdUnit or view is null");
  }

  public void a(p paramp)
  {
    this.g = paramp;
  }

  public void a(String paramString, aa paramaa)
  {
    this.j = new b(paramString, paramaa, this.c);
    this.j.a(this.a);
    this.i = new o()
    {
      public void a(f paramAnonymousf)
      {
        z.b(z.this).a(paramAnonymousf.a());
      }

      public void a(n paramAnonymousn)
      {
        paramAnonymousn.a(z.b(z.this));
        z.b(z.this).a(paramAnonymousn);
      }

      public void b(f paramAnonymousf)
      {
      }
    };
    this.j.a(this.i);
    this.j.a();
  }

  protected boolean a(String paramString)
  {
    int m = this.c.getResources().getIdentifier(paramString, "layout", this.c.getPackageName());
    if (m == 0);
    u localu;
    do
    {
      do
        return false;
      while (this.k == null);
      localu = this.k.a();
    }
    while (localu == null);
    if (m != localu.a())
    {
      localu.a(m);
      this.k.a(localu);
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.z
 * JD-Core Version:    0.6.2
 */