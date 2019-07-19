package com.viber.voip.report.a;

import com.viber.voip.api.a.a.a.b;
import com.viber.voip.api.a.a.a.e;
import com.viber.voip.api.a.a.a.f;
import com.viber.voip.api.a.a.a.g;

public class a<T extends b>
{
  public static final String[] a = { "Report Public Chat" };

  public final g<T> a()
  {
    g localg = new g();
    a(localg);
    b(localg);
    c(localg);
    f localf = new f();
    a(localf);
    localg.a(localf);
    localg.a(b());
    return localg;
  }

  protected void a(f paramf)
  {
    paramf.a("in");
    paramf.d("reports@viber.com");
  }

  protected void a(g<T> paramg)
  {
    paramg.a("email");
    paramg.c("resolved");
  }

  protected T b()
  {
    return null;
  }

  protected void b(g<T> paramg)
  {
    paramg.a(a);
  }

  protected void c(g<T> paramg)
  {
    e locale = new e();
    com.viber.voip.api.a.a.a.a locala = new com.viber.voip.api.a.a.a.a();
    locala.a("group");
    locala.b("/api/v2/groups/598972");
    locale.a(locala);
    paramg.a(locale);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.report.a.a
 * JD-Core Version:    0.6.2
 */