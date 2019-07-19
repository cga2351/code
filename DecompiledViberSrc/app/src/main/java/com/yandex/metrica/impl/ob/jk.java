package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;

@Deprecated
public class jk extends jh
{
  private static final jo d = new jo("SERVICE_API_LEVEL");
  private static final jo e = new jo("CLIENT_API_LEVEL");
  private jo f = new jo(d.a());
  private jo g = new jo(e.a());

  public jk(Context paramContext)
  {
    super(paramContext, null);
  }

  public int a()
  {
    return this.c.getInt(this.f.b(), -1);
  }

  public jk b()
  {
    h(this.f.b());
    return this;
  }

  public jk c()
  {
    h(this.g.b());
    return this;
  }

  protected String f()
  {
    return "_migrationpreferences";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jk
 * JD-Core Version:    0.6.2
 */