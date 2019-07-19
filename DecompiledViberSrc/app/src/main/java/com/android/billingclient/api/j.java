package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  private final String a;
  private final JSONObject b;

  public j(String paramString)
    throws JSONException
  {
    this.a = paramString;
    this.b = new JSONObject(this.a);
  }

  public String a()
  {
    return this.b.optString("productId");
  }

  public String b()
  {
    return this.b.optString("type");
  }

  public String c()
  {
    return this.b.optString("price");
  }

  public long d()
  {
    return this.b.optLong("price_amount_micros");
  }

  public String e()
  {
    return this.b.optString("price_currency_code");
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    j localj = (j)paramObject;
    return TextUtils.equals(this.a, localj.a);
  }

  public String f()
  {
    return this.b.optString("title");
  }

  public String g()
  {
    return this.b.optString("description");
  }

  public boolean h()
  {
    return this.b.has("rewardToken");
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  String i()
  {
    return this.b.optString("rewardToken");
  }

  public String toString()
  {
    return "SkuDetails: " + this.a;
  }

  public static class a
  {
    private List<j> a;
    private int b;

    public a(int paramInt, List<j> paramList)
    {
      this.a = paramList;
      this.b = paramInt;
    }

    public List<j> a()
    {
      return this.a;
    }

    public int b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.j
 * JD-Core Version:    0.6.2
 */