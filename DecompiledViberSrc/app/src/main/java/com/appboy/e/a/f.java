package com.appboy.e.a;

import a.a.ap;
import a.a.bc;
import a.a.cz;
import a.a.dr;
import com.appboy.b.c.a;
import com.appboy.b.d;
import org.json.JSONObject;

public final class f extends c
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;

  public f(JSONObject paramJSONObject, c.a parama, ap paramap, cz paramcz, bc parambc)
  {
    super(paramJSONObject, parama, paramap, paramcz, parambc);
    this.b = dr.a(paramJSONObject, parama.a(com.appboy.b.c.z));
    this.a = paramJSONObject.getString(parama.a(com.appboy.b.c.A));
    this.c = dr.a(paramJSONObject, parama.a(com.appboy.b.c.B));
    this.d = dr.a(paramJSONObject, parama.a(com.appboy.b.c.C));
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.c;
  }

  public String c()
  {
    return this.b;
  }

  public d d()
  {
    return d.e;
  }

  public String e()
  {
    return this.d;
  }

  public String toString()
  {
    return "TextAnnouncementCard{" + super.toString() + ", mDescription='" + this.a + '\'' + ", mTitle='" + this.b + '\'' + ", mUrl='" + this.c + '\'' + ", mDomain='" + this.d + '\'' + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.a.f
 * JD-Core Version:    0.6.2
 */