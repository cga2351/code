package com.viber.voip.analytics.e;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.MixpanelAPI.c;
import com.mixpanel.android.mpmetrics.i;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.a;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.j;
import com.viber.voip.analytics.story.k;
import com.viber.voip.analytics.t;
import com.viber.voip.analytics.y;
import com.viber.voip.settings.d.f;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a
  implements b
{
  private static final Logger c = ViberEnv.getLogger();
  private MixpanelAPI d;
  private final d e;
  private Context f;
  private String g;
  private e h;

  public c(Context paramContext, y paramy, e parame, d paramd)
  {
    super(paramy);
    this.f = paramContext.getApplicationContext();
    this.h = parame;
    this.e = paramd;
  }

  private void a(String paramString, Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString, paramObject);
      label15: h().registerSuperProperties(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label15;
    }
  }

  private void c(String paramString)
  {
    h().unregisterSuperProperty(paramString);
  }

  private void g()
  {
    if (this.d == null)
    {
      this.e.a(i.a(this.f));
      this.d = MixpanelAPI.getInstance(this.f, "a9b47cf8f1246dc2742ec37dd46c9409");
    }
  }

  private MixpanelAPI h()
  {
    if (this.d == null)
      g();
    return this.d;
  }

  protected void b(String paramString)
  {
    if ((this.d != null) && (paramString.equals(this.g)))
      return;
    g();
    String str = d.f.r.d();
    if ("anonymous_user".equals(paramString))
    {
      this.d.identify(this.d.getDistinctId());
      this.d.getPeople().a(this.d.getDistinctId());
    }
    while (true)
    {
      d.f.r.a(paramString);
      this.g = paramString;
      return;
      if ((!TextUtils.isEmpty(str)) && (!str.equals(paramString)))
        this.d.alias(paramString, null);
      this.d.identify(paramString);
      this.d.getPeople().a(paramString);
    }
  }

  protected boolean b(f paramf, g paramg)
  {
    MixpanelAPI.c localc = h().getPeople();
    switch (1.a[paramg.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      return true;
      localc.a(paramf.b(b.class));
      continue;
      localc.b(paramf.b(b.class));
      continue;
      Iterator localIterator5 = paramf.b(b.class).entrySet().iterator();
      while (localIterator5.hasNext())
      {
        Map.Entry localEntry4 = (Map.Entry)localIterator5.next();
        localc.a((String)localEntry4.getKey(), ((Number)localEntry4.getValue()).doubleValue());
      }
      Iterator localIterator4 = paramf.b(b.class).entrySet().iterator();
      while (localIterator4.hasNext())
      {
        Map.Entry localEntry3 = (Map.Entry)localIterator4.next();
        localc.a((String)localEntry3.getKey(), (JSONArray)localEntry3.getValue());
      }
      Iterator localIterator3 = paramf.b(b.class).keySet().iterator();
      while (localIterator3.hasNext())
        localc.b((String)localIterator3.next());
      Iterator localIterator2 = paramf.b(b.class).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        localc.b((String)localEntry2.getKey(), localEntry2.getValue());
      }
      Iterator localIterator1 = paramf.b(b.class).entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        localc.c((String)localEntry1.getKey(), localEntry1.getValue());
      }
    }
  }

  protected boolean c(com.viber.voip.analytics.story.e parame)
  {
    Map.Entry localEntry = parame.a(b.class);
    if ((localEntry == null) || (!(localEntry.getValue() instanceof String)))
      return false;
    try
    {
      h().track((String)localEntry.getValue(), parame.b(b.class, t.a));
      label50: return true;
    }
    catch (JSONException localJSONException)
    {
      break label50;
    }
  }

  protected boolean c(j paramj)
  {
    Map.Entry localEntry = paramj.a(b.class);
    if ((localEntry == null) || (localEntry.getKey() == null) || (localEntry.getValue() == null))
      return false;
    a((String)localEntry.getKey(), localEntry.getValue());
    return true;
  }

  public void d()
  {
    if (!b())
      return;
    h().flush();
  }

  protected void d(com.viber.voip.analytics.story.e parame)
  {
  }

  protected boolean d(j paramj)
  {
    Map.Entry localEntry = paramj.a(b.class);
    if ((localEntry == null) || (localEntry.getKey() == null))
      return false;
    c((String)localEntry.getKey());
    return true;
  }

  protected void e()
  {
    if (this.d != null)
      a("$ignore", Boolean.valueOf(true));
    this.g = null;
  }

  protected boolean e(com.viber.voip.analytics.story.e parame)
  {
    Map.Entry localEntry = parame.a(b.class);
    if (localEntry != null)
      h().timeEvent(localEntry.getValue().toString());
    return true;
  }

  protected void q_()
  {
    h().unregisterSuperProperty("$ignore");
    this.h.a(h());
    k.i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.e.c
 * JD-Core Version:    0.6.2
 */