package a.a;

import com.appboy.c.a;
import com.appboy.f.c;
import java.net.URI;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ca
  implements Runnable
{
  private static final String a = c.a(ca.class);
  private final ch b;
  private final d c;
  private final d d;
  private final Map<String, String> e;
  private final fg f;
  private final cx g;
  private final dd h;
  private final ct i;
  private final au j;

  public ca(ch paramch, cd paramcd, fg paramfg, d paramd1, d paramd2, cx paramcx, au paramau, dd paramdd, ct paramct)
  {
    this.b = paramch;
    this.c = paramd1;
    this.d = paramd2;
    this.e = paramcd.a();
    this.b.a(this.e);
    this.f = paramfg;
    this.g = paramcx;
    this.j = paramau;
    this.h = paramdd;
    this.i = paramct;
  }

  private bu a()
  {
    URI localURI = dp.a(this.b.a());
    switch (1.a[this.b.i().ordinal()])
    {
    default:
      c.d(a, "Received a request with an unknown Http verb: [" + this.b.i() + "]");
      return null;
    case 1:
      return new bu(this.f.a(localURI, this.e), this.b, this.j);
    case 2:
    }
    JSONObject localJSONObject = this.b.g();
    if (localJSONObject == null)
    {
      c.e(a, "Could not parse request parameters for put request to [%s], canceling request.");
      return null;
    }
    return new bu(this.f.a(localURI, this.e, localJSONObject), this.b, this.j);
  }

  private void a(bw parambw)
  {
    c.e(a, "Received server error from request: " + parambw.a());
  }

  void a(bu parambu)
  {
    if (!parambu.e())
      this.b.a(this.d, parambu);
    while (true)
    {
      b(parambu);
      this.b.a(this.c);
      return;
      a(parambu.n());
      this.b.a(this.c, this.d, parambu.n());
    }
  }

  void b(bu parambu)
  {
    String str = this.j.e();
    if (parambu.a());
    try
    {
      com.appboy.c.b localb1 = this.g.a(parambu.h(), str);
      if (localb1 != null)
        this.d.a(localb1, com.appboy.c.b.class);
      if (!parambu.g());
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        a locala = this.i.a(parambu.m(), str);
        if (locala != null)
          this.d.a(locala, a.class);
        if (parambu.c())
        {
          this.h.a(parambu.j());
          this.c.a(new n(parambu.j()), n.class);
        }
        if (parambu.d())
          this.c.a(new v(parambu.k()), v.class);
        if ((parambu.b()) && ((this.b instanceof cn)))
        {
          cn localcn = (cn)this.b;
          com.appboy.e.b localb = parambu.i();
          localb.a(localcn.k());
          dy localdy = localcn.l();
          this.c.a(new k(localdy, localb, str), k.class);
        }
        if (parambu.f())
          this.c.a(new j(parambu.l()), j.class);
        return;
        localJSONException2 = localJSONException2;
        c.d(a, "Unable to update/publish feed.");
      }
      catch (JSONException localJSONException1)
      {
        while (true)
          c.d(a, "Encountered JSON exception while parsing Content Cards update. Unable to publish Content Cards update event.", localJSONException1);
      }
    }
  }

  public void run()
  {
    try
    {
      bu localbu = a();
      if (localbu != null)
      {
        a(localbu);
        this.c.a(new h(this.b), h.class);
        this.c.a(new f(this.b), f.class);
        return;
      }
      c.d(a, "Api response was null, failing task.");
      this.b.a(this.c, this.d, new bx("An error occurred during request processing, resulting in no valid response being received. Check the error log for more details."));
      this.c.a(new e(this.b), e.class);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        if ((localException instanceof w))
        {
          c.b(a, "Experienced network communication exception processing API response. Sending network error event.");
          this.c.a(new g(this.b), g.class);
        }
        c.c(a, "Experienced exception processing API response. Failing task.", localException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ca
 * JD-Core Version:    0.6.2
 */