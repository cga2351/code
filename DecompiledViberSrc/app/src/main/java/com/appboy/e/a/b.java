package com.appboy.e.a;

import a.a.ap;
import a.a.bc;
import a.a.cz;
import a.a.dr;
import com.appboy.b.c.a;
import com.appboy.b.d;
import org.json.JSONObject;

public final class b extends c
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final float f;

  public b(JSONObject paramJSONObject, c.a parama, ap paramap, cz paramcz, bc parambc)
  {
    super(paramJSONObject, parama, paramap, paramcz, parambc);
    this.a = paramJSONObject.getString(parama.a(com.appboy.b.c.t));
    this.b = paramJSONObject.getString(parama.a(com.appboy.b.c.u));
    this.c = paramJSONObject.getString(parama.a(com.appboy.b.c.v));
    this.d = dr.a(paramJSONObject, parama.a(com.appboy.b.c.w));
    this.e = dr.a(paramJSONObject, parama.a(com.appboy.b.c.x));
    this.f = ((float)paramJSONObject.optDouble(parama.a(com.appboy.b.c.y), 0.0D));
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
    return d.b;
  }

  public String e()
  {
    return this.c;
  }

  public String f()
  {
    return this.e;
  }

  public float g()
  {
    return this.f;
  }

  public String toString()
  {
    return "CaptionedImageCard{" + super.toString() + ", mImageUrl='" + this.a + '\'' + ", mTitle='" + this.b + '\'' + ", mDescription='" + this.c + '\'' + ", mUrl='" + this.d + '\'' + ", mDomain='" + this.e + '\'' + ", mAspectRatio='" + this.f + '\'' + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.a.b
 * JD-Core Version:    0.6.2
 */