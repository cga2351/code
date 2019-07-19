package com.yandex.metrica.impl.ob;

import org.json.JSONException;
import org.json.JSONObject;

public final class hj
{
  private final String a;
  private final int b;
  private final boolean c;

  public hj(String paramString, int paramInt, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramBoolean;
  }

  public hj(String paramString, boolean paramBoolean)
  {
    this(paramString, -1, paramBoolean);
  }

  public hj(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.getString("name");
    this.c = paramJSONObject.getBoolean("required");
    this.b = paramJSONObject.optInt("version", -1);
  }

  public JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject().put("name", this.a).put("required", this.c);
    if (this.b != -1)
      localJSONObject.put("version", this.b);
    return localJSONObject;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    hj localhj;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localhj = (hj)paramObject;
      if (this.b != localhj.b)
        return false;
      if (this.c != localhj.c)
        return false;
      if (this.a != null)
        return this.a.equals(localhj.a);
    }
    while (localhj.a == null);
    return false;
  }

  public int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
    {
      int j = 31 * (i * 31 + this.b);
      boolean bool = this.c;
      int k = 0;
      if (bool)
        k = 1;
      return j + k;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hj
 * JD-Core Version:    0.6.2
 */