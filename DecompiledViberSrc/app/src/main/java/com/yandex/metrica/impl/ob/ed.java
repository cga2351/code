package com.yandex.metrica.impl.ob;

public class ed
{
  private final ek a;
  private final Long b;
  private final Long c;
  private final Integer d;
  private final Long e;
  private final Boolean f;
  private final Long g;
  private final Long h;

  private ed(a parama)
  {
    this.a = a.a(parama);
    this.d = a.b(parama);
    this.b = a.c(parama);
    this.c = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = parama.a;
  }

  public int a(int paramInt)
  {
    if (this.d == null)
      return paramInt;
    return this.d.intValue();
  }

  public long a(long paramLong)
  {
    if (this.b == null)
      return paramLong;
    return this.b.longValue();
  }

  public ek a()
  {
    return this.a;
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.f == null)
      return paramBoolean;
    return this.f.booleanValue();
  }

  public long b(long paramLong)
  {
    if (this.c == null)
      return paramLong;
    return this.c.longValue();
  }

  public long c(long paramLong)
  {
    if (this.e == null)
      return paramLong;
    return this.e.longValue();
  }

  public long d(long paramLong)
  {
    if (this.g == null)
      return paramLong;
    return this.g.longValue();
  }

  public long e(long paramLong)
  {
    if (this.h == null)
      return paramLong;
    return this.h.longValue();
  }

  static final class a
  {
    public Long a;
    private ek b;
    private Long c;
    private Long d;
    private Integer e;
    private Long f;
    private Boolean g;
    private Long h;

    private a(ef paramef)
    {
      this.b = paramef.a();
      this.e = paramef.b();
    }

    public a a(Boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }

    public a a(Long paramLong)
    {
      this.c = paramLong;
      return this;
    }

    public ed a()
    {
      return new ed(this, (byte)0);
    }

    public a b(Long paramLong)
    {
      this.d = paramLong;
      return this;
    }

    public a c(Long paramLong)
    {
      this.f = paramLong;
      return this;
    }

    public a d(Long paramLong)
    {
      this.h = paramLong;
      return this;
    }

    public a e(Long paramLong)
    {
      this.a = paramLong;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ed
 * JD-Core Version:    0.6.2
 */