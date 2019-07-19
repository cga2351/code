package com.appboy.e.a;

import a.a.ap;
import a.a.bc;
import a.a.cz;
import a.a.dr;
import com.appboy.b.c.a;
import com.appboy.b.d;
import org.json.JSONObject;

public final class a extends c
{
  private final String a;
  private final String b;
  private final String c;
  private final float d;

  public a(JSONObject paramJSONObject, c.a parama, ap paramap, cz paramcz, bc parambc)
  {
    super(paramJSONObject, parama, paramap, paramcz, parambc);
    this.a = paramJSONObject.getString(parama.a(com.appboy.b.c.p));
    this.b = dr.a(paramJSONObject, parama.a(com.appboy.b.c.q));
    this.c = dr.a(paramJSONObject, parama.a(com.appboy.b.c.r));
    this.d = ((float)paramJSONObject.optDouble(parama.a(com.appboy.b.c.s), 0.0D));
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public float c()
  {
    return this.d;
  }

  public d d()
  {
    return d.a;
  }

  public String toString()
  {
    return "BannerImageCard{" + super.toString() + ", mImageUrl='" + this.a + '\'' + ", mUrl='" + this.b + '\'' + ", mDomain='" + this.c + '\'' + ", mAspectRatio='" + this.d + '\'' + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.a.a
 * JD-Core Version:    0.6.2
 */