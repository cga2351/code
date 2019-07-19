package com.viber.voip.ads.b.a.a.a;

import com.viber.voip.ads.b.a.a.l.a;

public class b
{
  private final a a;
  private final c b;
  private final d c;
  private final e d;
  private final Integer e;

  private b(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
  }

  public l.a a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 5:
      return this.a;
    case 2:
      return this.b;
    case 1:
      return this.c;
    case 2147483647:
    }
    return this.d;
  }

  public Integer a()
  {
    return this.e;
  }

  public static class a
  {
    private a a;
    private c b;
    private d c;
    private e d;
    private Integer e;

    public a a(int paramInt)
    {
      this.e = Integer.valueOf(paramInt);
      return this;
    }

    public a a(a parama)
    {
      this.a = parama;
      return this;
    }

    public a a(c paramc)
    {
      this.b = paramc;
      return this;
    }

    public a a(d paramd)
    {
      this.c = paramd;
      return this;
    }

    public a a(e parame)
    {
      this.d = parame;
      return this;
    }

    public b a()
    {
      return new b(this, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.a.a.b
 * JD-Core Version:    0.6.2
 */