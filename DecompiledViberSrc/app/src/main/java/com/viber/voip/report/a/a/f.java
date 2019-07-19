package com.viber.voip.report.a.a;

import com.viber.voip.api.a.a.a.c;
import com.viber.voip.api.a.a.a.g;
import com.viber.voip.report.a.a;
import com.viber.voip.util.da;
import java.util.Locale;

public class f extends a<c>
{
  private final long b;
  private final long c;
  private final String d;
  private final e e;
  private final String f;
  private final boolean g;

  public f(long paramLong1, long paramLong2, String paramString1, e parame, String paramString2, boolean paramBoolean)
  {
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramString1;
    this.e = parame;
    this.f = paramString2;
    this.g = paramBoolean;
  }

  private String d()
  {
    Locale localLocale = Locale.US;
    String str = e();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(this.b);
    arrayOfObject[1] = this.e.a();
    return String.format(localLocale, str, arrayOfObject);
  }

  private String e()
  {
    if (this.g)
      return "[Community Report] %d - %s";
    return "[DEBUG][Community Report] %d - %s";
  }

  protected void a(com.viber.voip.api.a.a.a.f paramf)
  {
    super.a(paramf);
    if ((this.e == e.g) && (!da.a(this.f)));
    for (String str = this.f; ; str = "report")
    {
      paramf.b(str);
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.d;
      paramf.c(String.format(localLocale, "%s@viber.com", arrayOfObject));
      paramf.e(d());
      return;
    }
  }

  protected void a(g<c> paramg)
  {
    super.a(paramg);
    paramg.b(d());
  }

  protected c c()
  {
    c localc = new c();
    localc.a(this.d);
    localc.b("FORM-REPORTS-CM");
    localc.c(String.valueOf(this.b));
    localc.d(String.valueOf(this.c));
    localc.e(this.e.a());
    return localc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.report.a.a.f
 * JD-Core Version:    0.6.2
 */