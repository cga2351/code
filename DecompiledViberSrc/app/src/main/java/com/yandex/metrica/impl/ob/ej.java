package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import org.json.JSONException;

public class ej
  implements ei
{
  protected fw a;
  private final String b;
  private nz.a c;

  public ej(fw paramfw, String paramString)
  {
    this.a = paramfw;
    this.b = paramString;
    nz.a locala1 = new nz.a();
    try
    {
      String str = this.a.d(this.b);
      if (!TextUtils.isEmpty(str))
      {
        locala2 = new nz.a(str);
        this.c = locala2;
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
        nz.a locala2 = locala1;
    }
  }

  private void a(String paramString, Object paramObject)
  {
    try
    {
      this.c.put(paramString, paramObject);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public ej a(long paramLong)
  {
    a("SESSION_COUNTER_ID", Long.valueOf(paramLong));
    return this;
  }

  public ej a(boolean paramBoolean)
  {
    a("SESSION_IS_ALIVE_REPORT_NEEDED", Boolean.valueOf(paramBoolean));
    return this;
  }

  public void a()
  {
    this.c = new nz.a();
    h();
  }

  public ej b(long paramLong)
  {
    a("SESSION_SLEEP_START", Long.valueOf(paramLong));
    return this;
  }

  public Long b()
  {
    return this.c.c("SESSION_ID");
  }

  public ej c(long paramLong)
  {
    a("SESSION_LAST_EVENT_OFFSET", Long.valueOf(paramLong));
    return this;
  }

  public Long c()
  {
    return this.c.c("SESSION_INIT_TIME");
  }

  public ej d(long paramLong)
  {
    a("SESSION_ID", Long.valueOf(paramLong));
    return this;
  }

  public Long d()
  {
    return this.c.c("SESSION_COUNTER_ID");
  }

  public ej e(long paramLong)
  {
    a("SESSION_INIT_TIME", Long.valueOf(paramLong));
    return this;
  }

  public Long e()
  {
    return this.c.c("SESSION_SLEEP_START");
  }

  public Long f()
  {
    return this.c.c("SESSION_LAST_EVENT_OFFSET");
  }

  public Boolean g()
  {
    return this.c.d("SESSION_IS_ALIVE_REPORT_NEEDED");
  }

  public void h()
  {
    this.a.a(this.b, this.c.toString());
    this.a.i();
  }

  public boolean i()
  {
    return this.c.length() > 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ej
 * JD-Core Version:    0.6.2
 */