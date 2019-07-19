package com.iab.omid.library.appnexus.walking.a;

import java.util.HashSet;
import org.json.JSONObject;

public abstract class a extends b
{
  protected final HashSet<String> a;
  protected final JSONObject b;
  protected final double c;

  public a(b.b paramb, HashSet<String> paramHashSet, JSONObject paramJSONObject, double paramDouble)
  {
    super(paramb);
    this.a = new HashSet(paramHashSet);
    this.b = paramJSONObject;
    this.c = paramDouble;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.walking.a.a
 * JD-Core Version:    0.6.2
 */