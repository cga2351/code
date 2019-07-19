package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;

@Deprecated
public class jl extends jh
{
  private static final jo d = new jo("PREF_KEY_OFFSET");
  private jo e = new jo(d.a(), null);

  public jl(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }

  public long a(int paramInt)
  {
    return this.c.getLong(this.e.b(), paramInt);
  }

  public void a()
  {
    h(this.e.b()).j();
  }

  protected String f()
  {
    return "_servertimeoffset";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jl
 * JD-Core Version:    0.6.2
 */