package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  private final String a;
  private final String b;
  private final JSONObject c;

  public h(String paramString1, String paramString2)
    throws JSONException
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = new JSONObject(this.a);
  }

  public String a()
  {
    return this.c.optString("productId");
  }

  public String b()
  {
    return this.c.optString("token", this.c.optString("purchaseToken"));
  }

  public String c()
  {
    return this.a;
  }

  public String d()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    h localh;
    do
    {
      return true;
      if (!(paramObject instanceof h))
        return false;
      localh = (h)paramObject;
    }
    while ((TextUtils.equals(this.a, localh.c())) && (TextUtils.equals(this.b, localh.d())));
    return false;
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public String toString()
  {
    return "Purchase. Json: " + this.a;
  }

  public static class a
  {
    private List<h> a;
    private int b;

    public a(int paramInt, List<h> paramList)
    {
      this.a = paramList;
      this.b = paramInt;
    }

    public int a()
    {
      return this.b;
    }

    public List<h> b()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.h
 * JD-Core Version:    0.6.2
 */