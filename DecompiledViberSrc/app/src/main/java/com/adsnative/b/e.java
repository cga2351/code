package com.adsnative.b;

import com.adsnative.c.i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  private String a;
  private String b;
  private JSONObject c;
  private JSONObject d;
  private ArrayList<String> e;
  private ArrayList<String> f;
  private ArrayList<String> g;
  private ArrayList<String> h;
  private ArrayList<String> i;
  private int j = 0;
  private Double k;
  private JSONObject l;
  private JSONArray m;
  private JSONObject n;
  private String o;
  private int p;
  private int q;
  private boolean r;

  e(JSONObject paramJSONObject)
    throws JSONException, ClassCastException
  {
    this.n = paramJSONObject;
    this.m = ((JSONArray)paramJSONObject.opt("networks"));
    this.l = ((JSONObject)paramJSONObject.opt("ad"));
    this.j = paramJSONObject.optInt("count");
    this.p = 0;
    if (this.m != null)
      this.q = this.m.length();
  }

  private void a(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.optString("providerName");
    this.k = Double.valueOf(paramJSONObject.optDouble("ecpm"));
    this.o = this.l.optString("vastUrl");
    if ((paramJSONObject.opt("providerData") instanceof String));
    for (String str = (String)paramJSONObject.opt("providerData"); ; str = null)
    {
      if (str != null)
        this.c = new JSONObject(str);
      if ((paramJSONObject.opt("customFields") instanceof JSONObject));
      for (JSONObject localJSONObject = (JSONObject)paramJSONObject.opt("customFields"); ; localJSONObject = null)
      {
        if (localJSONObject != null)
          this.d = localJSONObject;
        if (((this.c instanceof JSONObject)) && (this.c != null));
        for (this.b = this.c.optString("adNetworkClassName"); ; this.b = null)
        {
          b(paramJSONObject);
          return;
        }
      }
    }
  }

  private void b(JSONObject paramJSONObject)
    throws JSONException
  {
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = new ArrayList();
    this.i = new ArrayList();
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("trackingUrls");
    JSONArray localJSONArray1 = localJSONObject1.getJSONArray("impressions");
    for (int i1 = 0; i1 < localJSONArray1.length(); i1++)
      this.e.add(localJSONArray1.optString(i1));
    JSONArray localJSONArray2 = localJSONObject1.getJSONArray("viewables");
    for (int i2 = 0; i2 < localJSONArray2.length(); i2++)
      this.f.add(localJSONArray2.optString(i2));
    JSONArray localJSONArray3 = localJSONObject1.getJSONArray("clicks");
    for (int i3 = 0; i3 < localJSONArray3.length(); i3++)
      this.g.add(localJSONArray3.optString(i3));
    JSONObject localJSONObject2 = localJSONObject1.optJSONObject("noticeUrls");
    if (localJSONObject2 != null)
    {
      JSONArray localJSONArray4 = localJSONObject2.optJSONArray("win");
      if (localJSONArray4 != null)
        for (int i5 = 0; i5 < localJSONArray4.length(); i5++)
          this.h.add(localJSONArray4.optString(i5));
      JSONArray localJSONArray5 = localJSONObject2.optJSONArray("loss");
      int i4 = 0;
      if (localJSONArray5 != null)
        while (i4 < localJSONArray5.length())
        {
          this.i.add(localJSONArray5.optString(i4));
          i4++;
        }
    }
  }

  private void k()
    throws JSONException
  {
    this.a = "adsnative";
    this.b = null;
    this.c = null;
    this.k = Double.valueOf(this.n.optDouble("ecpm"));
    this.o = this.l.optString("vastUrl");
    b(this.l);
  }

  public void a()
    throws JSONException
  {
    if ((this.m != null) && (this.m.length() > 0))
    {
      if (this.j > 1)
        this.r = true;
      a((JSONObject)this.m.get(this.p));
    }
    while (true)
    {
      i.b("IsFallbackAvailable: " + this.r);
      return;
      if (this.l != null)
        k();
      this.r = false;
    }
  }

  public boolean b()
    throws JSONException
  {
    boolean bool1 = this.r;
    boolean bool2 = false;
    if (bool1)
    {
      int i1 = 1 + this.p;
      this.p = i1;
      if (i1 >= this.q)
        break label53;
      a((JSONObject)this.m.get(this.p));
      bool2 = true;
    }
    label53: JSONObject localJSONObject;
    do
    {
      return bool2;
      this.r = false;
      localJSONObject = this.l;
      bool2 = false;
    }
    while (localJSONObject == null);
    k();
    return true;
  }

  String c()
  {
    return this.b;
  }

  ArrayList<String> d()
  {
    if (this.e != null)
      return this.e;
    return new ArrayList();
  }

  ArrayList<String> e()
  {
    if (this.f != null)
      return this.f;
    return new ArrayList();
  }

  ArrayList<String> f()
  {
    if (this.g != null)
      return this.g;
    return new ArrayList();
  }

  ArrayList<String> g()
  {
    if (this.h != null)
      return this.h;
    return new ArrayList();
  }

  ArrayList<String> h()
  {
    if (this.i != null)
      return this.i;
    return new ArrayList();
  }

  JSONObject i()
  {
    return this.l;
  }

  public Double j()
  {
    return this.k;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.b.e
 * JD-Core Version:    0.6.2
 */