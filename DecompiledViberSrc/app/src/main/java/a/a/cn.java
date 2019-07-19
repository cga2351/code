package a.a;

import android.net.Uri;
import android.os.Handler;
import com.appboy.b.a.e;
import com.appboy.e.b;
import com.appboy.f.c;
import com.appboy.f.i;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class cn extends bz
{
  private static final String b = c.a(cn.class);
  private final String c;
  private final long d;
  private final String e;
  private final ez f;
  private final ea g;
  private final bn h;
  private final au i;
  private final cp j;
  private final long k;

  public cn(String paramString1, ea paramea, ez paramez, au paramau, String paramString2)
  {
    super(Uri.parse(paramString1 + "template"), null);
    this.c = paramea.i();
    this.d = paramea.g();
    this.e = paramea.j();
    this.f = paramez;
    this.h = new bn.a().a(paramString2).c();
    this.i = paramau;
    this.g = paramea;
    this.k = a(this.g.c());
    this.j = o();
  }

  private long a(et paramet)
  {
    if (paramet.e() == -1)
      return TimeUnit.SECONDS.toMillis(30 + paramet.d());
    return paramet.e();
  }

  private cp o()
  {
    return new cp((int)Math.min(this.k, TimeUnit.MINUTES.toMillis(1L)), (int)TimeUnit.SECONDS.toMillis(1L));
  }

  public void a(d paramd, bu parambu)
  {
    this.j.a();
    if ((parambu != null) && (parambu.b()))
    {
      if (!i.c(this.e))
        parambu.i().a(this.e);
      return;
    }
    m();
  }

  public void a(d paramd1, d paramd2, bw parambw)
  {
    super.a(paramd1, paramd2, parambw);
    m();
    if ((parambw instanceof bt))
      paramd1.a(new u(this.f, this.g), u.class);
    while (!(parambw instanceof bx))
      return;
    c.a(b, "Response error was a server failure. Retrying request after some delay if not expired.");
    long l = this.f.d() + this.k;
    if (di.c() < l)
    {
      int m = this.j.c();
      c.b(b, "Retrying template request after delay of " + m + " ms");
      do.a().postDelayed(new Runnable()
      {
        public void run()
        {
          c.b(cn.n(), "Adding request to dispatch");
          cn.a(cn.this).a(jdField_this);
        }
      }
      , m);
      return;
    }
    c.b(b, "Template request expired at time: " + l + " and is not eligible for a backoff response. Not retrying or performing any fallback triggers");
  }

  public JSONObject g()
  {
    JSONObject localJSONObject1 = super.g();
    if (localJSONObject1 == null)
      return null;
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("trigger_id", this.c);
      localJSONObject2.put("trigger_event_type", this.f.b());
      if (this.f.e() != null)
        localJSONObject2.put("data", this.f.e().h());
      localJSONObject1.put("template", localJSONObject2);
      if (this.h.f())
        localJSONObject1.put("respond_with", this.h.a());
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      c.c(b, "Experienced JSONException while retrieving parameters. Returning null.", localJSONException);
    }
    return null;
  }

  public boolean h()
  {
    return false;
  }

  public gu i()
  {
    return gu.b;
  }

  public long k()
  {
    return this.d;
  }

  public dy l()
  {
    return this.g;
  }

  void m()
  {
    c.c(b, "Template request failed. Attempting to log in-app message template request failure.");
    if (i.c(this.c))
    {
      c.b(b, "Trigger ID not found. Not logging in-app message template request failure.");
      return;
    }
    if (this.i == null)
    {
      c.e(b, "Cannot log an in-app message template request failure because the IAppboyManager is null.");
      return;
    }
    try
    {
      bp localbp = bp.a(null, null, this.c, e.b);
      this.i.a(localbp);
      return;
    }
    catch (JSONException localJSONException)
    {
      this.i.a(localJSONException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cn
 * JD-Core Version:    0.6.2
 */