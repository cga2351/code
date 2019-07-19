package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;

@Deprecated
public class jn extends jh
{
  private jo d = new jo("LOCATION_TRACKING_ENABLED");

  public jn(Context paramContext)
  {
    this(paramContext, null);
  }

  public jn(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }

  public boolean a()
  {
    return this.c.getBoolean(this.d.b(), false);
  }

  public void b()
  {
    h(this.d.b()).j();
  }

  protected String f()
  {
    return "_serviceproviderspreferences";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jn
 * JD-Core Version:    0.6.2
 */