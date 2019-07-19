package com.yandex.metrica.impl.ob;

public class fu extends fx
{
  private final jo a = new jo("init_event_pref_key");
  private final jo b = new jo("first_event_pref_key");
  private final jo c = new jo("first_event_description_key");
  private final jo d = new jo("preload_info_auto_tracking_enabled");

  public fu(fk paramfk)
  {
    super(paramfk);
  }

  public String a(String paramString)
  {
    return c(this.a.b(), paramString);
  }

  public void a()
  {
    b(this.a.b(), "DONE").i();
  }

  public void a(boolean paramBoolean)
  {
    a(this.d.b(), paramBoolean).i();
  }

  public String b(String paramString)
  {
    return c(this.b.b(), paramString);
  }

  public void b()
  {
    b(this.b.b(), "DONE").i();
  }

  public boolean b(boolean paramBoolean)
  {
    return b(this.d.b(), paramBoolean);
  }

  public void c(String paramString)
  {
    b(this.c.b(), paramString).i();
  }

  public boolean c()
  {
    return a(null) != null;
  }

  public String d(String paramString)
  {
    return c(this.c.b(), paramString);
  }

  public boolean d()
  {
    return b(null) != null;
  }

  public void e()
  {
    p(this.c.b()).i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fu
 * JD-Core Version:    0.6.2
 */