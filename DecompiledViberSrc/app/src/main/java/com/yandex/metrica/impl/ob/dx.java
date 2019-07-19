package com.yandex.metrica.impl.ob;

public abstract class dx
  implements ea<ec>
{
  private final ab a;
  private final fw b;
  private final ej c;
  private final ef d;

  public dx(ab paramab, fw paramfw, ej paramej, ef paramef)
  {
    this.a = paramab;
    this.b = paramfw;
    this.c = paramej;
    this.d = paramef;
  }

  public final eb a()
  {
    if (this.c.i())
      return new eb(this.a, this.c, b());
    return null;
  }

  ed b()
  {
    return new ed.a(this.d, (byte)0).a(this.c.g()).c(this.c.d()).b(this.c.c()).a(this.c.b()).d(this.c.e()).e(this.c.f()).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.dx
 * JD-Core Version:    0.6.2
 */