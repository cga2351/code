package com.appboy.c;

import a.a.dr;
import com.appboy.e.b;
import org.json.JSONObject;

public class d
{
  private final b a;
  private final String b;

  public d(b paramb, String paramString)
  {
    this.b = paramString;
    if (paramb == null)
      throw new NullPointerException();
    this.a = paramb;
  }

  public b a()
  {
    return this.a;
  }

  public String toString()
  {
    return dr.a((JSONObject)this.a.h());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.c.d
 * JD-Core Version:    0.6.2
 */