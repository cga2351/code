package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Map;

@Deprecated
public class jg extends jh
{
  private final jo d = new jo("init_event_pref_key", i());
  private final jo e = new jo("init_event_pref_key");
  private final jo f = new jo("first_event_pref_key", i());
  private final jo g = new jo("fitst_event_description_key", i());

  public jg(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }

  private void a(jo paramjo)
  {
    this.c.edit().remove(paramjo.b()).apply();
  }

  static String f(String paramString)
  {
    return new jo("init_event_pref_key", paramString).b();
  }

  static String g(String paramString)
  {
    return paramString.replace("init_event_pref_key", "");
  }

  @Deprecated
  public String a(String paramString)
  {
    return this.c.getString(this.e.b(), paramString);
  }

  public void a()
  {
    a(this.d.b(), "DONE").j();
  }

  public String b(String paramString)
  {
    return this.c.getString(this.d.b(), paramString);
  }

  @Deprecated
  public void b()
  {
    a(this.e);
  }

  public String c(String paramString)
  {
    return this.c.getString(this.f.b(), paramString);
  }

  public void c()
  {
    a(this.d);
  }

  public void d()
  {
    a(this.f);
  }

  @Deprecated
  public void d(String paramString)
  {
    a(new jo("init_event_pref_key", paramString));
  }

  public String e(String paramString)
  {
    return this.c.getString(this.g.b(), paramString);
  }

  public void e()
  {
    a(this.g);
  }

  protected String f()
  {
    return "_initpreferences";
  }

  Map<String, ?> g()
  {
    return this.c.getAll();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jg
 * JD-Core Version:    0.6.2
 */