package com.appboy.e.a;

import a.a.ap;
import a.a.bc;
import a.a.cz;
import a.a.dr;
import com.appboy.b.c.a;
import com.appboy.b.d;
import org.json.JSONObject;

public final class e extends c
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;

  public e(JSONObject paramJSONObject, c.a parama, ap paramap, cz paramcz, bc parambc)
  {
    super(paramJSONObject, parama, paramap, paramcz, parambc);
    this.a = paramJSONObject.getString(parama.a(com.appboy.b.c.F));
    this.b = paramJSONObject.getString(parama.a(com.appboy.b.c.D));
    this.c = dr.a(paramJSONObject, parama.a(com.appboy.b.c.E));
    this.d = dr.a(paramJSONObject, parama.a(com.appboy.b.c.G));
    this.e = dr.a(paramJSONObject, parama.a(com.appboy.b.c.H));
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.d;
  }

  public String c()
  {
    return this.b;
  }

  public d d()
  {
    return d.d;
  }

  public String e()
  {
    return this.c;
  }

  public String f()
  {
    return this.e;
  }

  public String toString()
  {
    return "ShortNewsCard{" + super.toString() + ", mDescription='" + this.a + '\'' + ", mImageUrl='" + this.b + '\'' + ", mTitle='" + this.c + '\'' + ", mUrl='" + this.d + '\'' + ", mDomain='" + this.e + '\'' + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.a.e
 * JD-Core Version:    0.6.2
 */