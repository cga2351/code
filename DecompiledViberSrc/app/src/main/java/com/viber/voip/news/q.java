package com.viber.voip.news;

import android.content.Context;
import android.support.v4.util.ObjectsCompat;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.h.a;
import com.viber.voip.app.b;
import com.viber.voip.util.cv;
import com.viber.voip.util.da;
import dagger.a;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class q
  implements h.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final g c;
  private final b d;
  private final a<cv> e;
  private final a<ICdrController> f;
  private ViberNewsProviderSpec g;
  private ViberNewsProviderSpec h;

  public q(Context paramContext, g paramg, b paramb, a<cv> parama, a<ICdrController> parama1)
  {
    this.b = paramContext;
    this.c = paramg;
    this.d = paramb;
    this.e = parama;
    this.f = parama1;
  }

  private void a(ViberNewsProviderSpec paramViberNewsProviderSpec)
  {
    if (!paramViberNewsProviderSpec.isNewsProviderExists());
    while (((cv)this.e.get()).c())
      return;
    ((cv)this.e.get()).a(true);
  }

  private ViberNewsProviderSpec b()
  {
    if (this.h == null)
    {
      this.h = c();
      a(this.h);
    }
    return this.h;
  }

  private ViberNewsProviderSpec c()
  {
    b localb = new b(null);
    a locala1 = localb.a(this.c.f());
    if (!da.a(locala1.a))
    {
      int[] arrayOfInt1 = { 3, 2, 1 };
      return new ViberNewsProviderSpec(0, locala1.a, 1, 0L, false, 0, 1, arrayOfInt1);
    }
    a locala2 = localb.a(this.c.g());
    if ((!da.a(locala2.a)) && (locala2.b != 0))
    {
      int[] arrayOfInt2 = { 3, 2, 1, 0, 4 };
      return new ViberNewsProviderSpec(1, locala2.a, -1, TimeUnit.MINUTES.toMillis(locala2.c), true, 1, locala2.b, arrayOfInt2);
    }
    return ViberNewsProviderSpec.NO_NEWS_PROVIDER;
  }

  public ViberNewsProviderSpec a()
  {
    if ((this.g != null) && (this.g.isNewsProviderExists()))
    {
      a(this.g);
      return this.g;
    }
    if (this.d.a(this.b))
      return ViberNewsProviderSpec.NO_NEWS_PROVIDER;
    return b();
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      b();
  }

  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ViberNewsProviderSpec localViberNewsProviderSpec1 = this.h;
      ViberNewsProviderSpec localViberNewsProviderSpec2 = c();
      if (!ObjectsCompat.equals(localViberNewsProviderSpec1, localViberNewsProviderSpec2))
        ((ICdrController)this.f.get()).handleViberNewsProviderChanges(localViberNewsProviderSpec2);
    }
  }

  private static class a
  {
    public final String a;
    public final int b;
    public final int c;

    private a(String paramString, int paramInt1, int paramInt2)
    {
      this.a = paramString;
      this.b = paramInt1;
      this.c = paramInt2;
    }
  }

  private static class b
  {
    private String a(JSONObject paramJSONObject)
    {
      return paramJSONObject.optString("initialURL", "");
    }

    private int b(JSONObject paramJSONObject)
    {
      int i = 1;
      String str = paramJSONObject.optString("entry_point", "");
      int j = -1;
      switch (str.hashCode())
      {
      default:
      case -1170902121:
      case 114581:
      case 1474918487:
      }
      while (true)
        switch (j)
        {
        default:
          i = 0;
        case 0:
          return i;
          if (str.equals("more screen"))
          {
            j = 0;
            continue;
            if (str.equals("tab"))
            {
              j = i;
              continue;
              if (str.equals("more screen + tab"))
                j = 2;
            }
          }
          break;
        case 1:
        case 2:
        }
      return 2;
      return 3;
    }

    private JSONObject b(String paramString)
    {
      if (!da.a(paramString))
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          return localJSONObject;
        }
        catch (JSONException localJSONException)
        {
        }
      return null;
    }

    private int c(JSONObject paramJSONObject)
    {
      return Math.max(0, paramJSONObject.optInt("cache_time", 0));
    }

    public q.a a(String paramString)
    {
      JSONObject localJSONObject = b(paramString);
      if (localJSONObject != null)
        return new q.a(a(localJSONObject), b(localJSONObject), c(localJSONObject), null);
      return new q.a(null, 0, 0, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.q
 * JD-Core Version:    0.6.2
 */