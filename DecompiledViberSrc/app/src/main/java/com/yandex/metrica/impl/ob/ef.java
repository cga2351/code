package com.yandex.metrica.impl.ob;

public final class ef
{
  private final ek a;
  private final Integer b;

  private ef(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
  }

  public static final a a(ek paramek)
  {
    return new a(paramek, (byte)0);
  }

  public ek a()
  {
    return this.a;
  }

  public Integer b()
  {
    return this.b;
  }

  static final class a
  {
    private ek a;
    private Integer b;

    private a(ek paramek)
    {
      this.a = paramek;
    }

    public a a(int paramInt)
    {
      this.b = Integer.valueOf(paramInt);
      return this;
    }

    public ef a()
    {
      return new ef(this, (byte)0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ef
 * JD-Core Version:    0.6.2
 */