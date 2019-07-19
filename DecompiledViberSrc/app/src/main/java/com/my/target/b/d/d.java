package com.my.target.b.d;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.my.target.as;
import com.my.target.as.a;
import com.my.target.b.c.b.b;
import com.my.target.bi;
import com.my.target.cj;
import com.my.target.dt;
import com.my.target.dw;
import com.my.target.dz;
import com.my.target.eb;
import com.my.target.ec;
import com.my.target.ef;
import com.my.target.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements as.a, c
{
  private final as a;
  private final cj b;
  private final Context c;
  private final String d;
  private c.a e;
  private a f;
  private com.my.target.b.c.a.c g;

  private d(as paramas, cj paramcj, String paramString, Context paramContext)
  {
    this.a = paramas;
    this.b = paramcj;
    this.c = paramContext;
    this.d = paramString;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 1;
    paramcj.addView(this.a);
    this.a.setLayoutParams(localLayoutParams);
    this.a.setBannerWebViewListener(this);
  }

  private d(String paramString, Context paramContext)
  {
    this(new as(paramContext), new cj(paramContext), paramString, paramContext);
  }

  public static d a(String paramString, Context paramContext)
  {
    return new d(paramString, paramContext);
  }

  private void c(String paramString)
  {
    if ((this.e != null) && (this.g != null))
      this.e.a(this.g, paramString);
  }

  private void d(String paramString)
  {
    if (this.f != null)
      this.f.a(paramString);
  }

  public final cj a()
  {
    return this.b;
  }

  public final void a(b paramb)
  {
    this.g = paramb.f();
    JSONObject localJSONObject = paramb.e();
    String str = paramb.d();
    if (localJSONObject == null)
    {
      d("failed to load, null raw data");
      return;
    }
    if (str == null)
    {
      d("failed to load, null html");
      return;
    }
    this.a.a(localJSONObject, str);
  }

  public final void a(c.a parama)
  {
    this.e = parama;
  }

  public final void a(a parama)
  {
    this.f = parama;
  }

  public final void a(ec paramec)
  {
    String str1 = paramec.a();
    int i = -1;
    switch (str1.hashCode())
    {
    default:
      switch (i)
      {
      case 1:
      case 2:
      case 5:
      case 9:
      case 10:
      case 11:
      case 12:
      default:
      case 0:
      case 3:
      case 4:
      case 6:
      case 7:
      case 8:
      case 13:
      case 14:
      }
      break;
    case -1338265852:
    case 1109243225:
    case 2137867948:
    case -1349867671:
    case 159970502:
    case 1252938159:
    case -2124458952:
    case -1013111741:
    case 172943136:
    case 975410564:
    case 169625780:
    case 1024326959:
    case 567029179:
    case 157935686:
    case -1012956973:
    case 747469392:
    case 2103168704:
    }
    do
    {
      return;
      if (!str1.equals("onReady"))
        break;
      i = 0;
      break;
      if (!str1.equals("onExpand"))
        break;
      i = 1;
      break;
      if (!str1.equals("onCollapse"))
        break;
      i = 2;
      break;
      if (!str1.equals("onError"))
        break;
      i = 3;
      break;
      if (!str1.equals("onAdError"))
        break;
      i = 4;
      break;
      if (!str1.equals("onCloseClick"))
        break;
      i = 5;
      break;
      if (!str1.equals("onComplete"))
        break;
      i = 6;
      break;
      if (!str1.equals("onNoAd"))
        break;
      i = 7;
      break;
      if (!str1.equals("onAdStart"))
        break;
      i = 8;
      break;
      if (!str1.equals("onAdStop"))
        break;
      i = 9;
      break;
      if (!str1.equals("onAdPause"))
        break;
      i = 10;
      break;
      if (!str1.equals("onAdResume"))
        break;
      i = 11;
      break;
      if (!str1.equals("onAdComplete"))
        break;
      i = 12;
      break;
      if (!str1.equals("onAdClick"))
        break;
      i = 13;
      break;
      if (!str1.equals("onStat"))
        break;
      i = 14;
      break;
      if (!str1.equals("onSizeChange"))
        break;
      i = 15;
      break;
      if (!str1.equals("onRequestNewAds"))
        break;
      i = 16;
      break;
    }
    while (this.f == null);
    this.f.a();
    return;
    eb localeb = (eb)paramec;
    if (localeb.b() != null);
    for (String str2 = "JS error" + ": " + localeb.b(); ; str2 = "JS error")
    {
      String str3 = this.a.getUrl();
      y localy = y.a("JS error").b(str2).c(str3);
      if (this.g != null);
      for (String str4 = this.g.k(); ; str4 = null)
      {
        localy.d(str4).a(this.c);
        if (!paramec.a().equals("onError"))
          break;
        d("JS error");
        return;
      }
      d("Ad completed");
      return;
      d("No ad");
      return;
      if ((this.e == null) || (this.g == null))
        break;
      this.e.a(this.g);
      return;
      c(((dz)paramec).b());
      return;
      bi.b(((ef)paramec).b(), this.c);
      return;
    }
  }

  public final void a(String paramString)
  {
    d(paramString);
  }

  public final void b()
  {
    int i = this.c.getResources().getConfiguration().orientation;
    try
    {
      this.a.a(new dw(this.d, null, i));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  public final void b(String paramString)
  {
    if (this.g != null)
      c(paramString);
  }

  public final void c()
  {
    try
    {
      this.a.a(new dt("stop"));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  public final void d()
  {
    try
    {
      this.a.a(new dt("pause"));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  public final void e()
  {
    try
    {
      this.a.a(new dt("resume"));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }

  public final void f()
  {
    this.f = null;
    this.e = null;
    if (this.a.getParent() != null)
      ((ViewGroup)this.a.getParent()).removeView(this.a);
    this.a.destroy();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.d.d
 * JD-Core Version:    0.6.2
 */