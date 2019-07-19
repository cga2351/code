package com.viber.voip.analytics.story.k;

import com.viber.voip.util.ae;
import com.viber.voip.util.ci;

public class e extends a
{
  protected final a c;

  public e(a parama, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.c = parama;
  }

  public void b()
  {
    com.viber.voip.model.e.b("analytics", a(), System.currentTimeMillis());
  }

  public boolean d()
  {
    Long localLong = com.viber.voip.model.e.b("analytics", a());
    ci localci = this.c.a();
    if (localLong == null);
    for (long l = 0L; ; l = localLong.longValue())
      return localci.apply(Long.valueOf(l));
  }

  public static enum a
  {
    private ci<Long> d;

    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }

    private a(ci<Long> paramci)
    {
      this.d = paramci;
    }

    public ci<Long> a()
    {
      return this.d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.k.e
 * JD-Core Version:    0.6.2
 */