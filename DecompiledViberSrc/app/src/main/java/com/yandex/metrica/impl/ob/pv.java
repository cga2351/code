package com.yandex.metrica.impl.ob;

public final class pv
{
  private final Class<? extends px> a;
  private final boolean b;
  private final String c;

  private pv(px<?> parampx, boolean paramBoolean, String paramString)
  {
    this.a = parampx.getClass();
    this.b = paramBoolean;
    this.c = paramString;
  }

  public static final pv a(px<?> parampx)
  {
    return new pv(parampx, true, "");
  }

  public static final pv a(px<?> parampx, String paramString)
  {
    return new pv(parampx, false, paramString);
  }

  public final boolean a()
  {
    return this.b;
  }

  public final String b()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pv
 * JD-Core Version:    0.6.2
 */