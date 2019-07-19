package com.my.target.b.c.b;

import com.my.target.b.c.a.c;
import com.my.target.l;
import org.json.JSONObject;

public final class b extends l
{
  private c a;
  private boolean b = true;
  private String c;
  private JSONObject d;

  public static b b()
  {
    return new b();
  }

  public final int a()
  {
    if (this.a == null)
      return 0;
    return 1;
  }

  public final void a(c paramc)
  {
    this.a = paramc;
  }

  public final void a(JSONObject paramJSONObject)
  {
    this.d = paramJSONObject;
  }

  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public final void b(String paramString)
  {
    this.c = paramString;
  }

  public final boolean c()
  {
    return this.b;
  }

  public final String d()
  {
    return this.c;
  }

  public final JSONObject e()
  {
    return this.d;
  }

  public final c f()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.c.b.b
 * JD-Core Version:    0.6.2
 */