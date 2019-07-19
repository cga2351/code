package com.adsnative.b;

import com.adsnative.ads.f;
import com.adsnative.c.i;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  protected JSONObject a;
  private String b;
  private e c;
  private f d;

  public c(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject;
    try
    {
      m();
      return;
    }
    catch (JSONException localJSONException)
    {
      i.e("JSONException in AdResponse : " + localJSONException.getMessage());
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      i.e("ClassCastException in AdResponse : " + localClassCastException.getMessage());
    }
  }

  private void m()
    throws JSONException, ClassCastException
  {
    this.b = this.a.optString("status");
    this.c = new e(this.a);
    this.c.a();
  }

  public boolean a()
    throws JSONException
  {
    if (this.c != null)
      return this.c.b();
    return false;
  }

  public JSONObject b()
  {
    if (this.c != null)
      return this.c.i();
    return null;
  }

  public String c()
  {
    return b().optString("type");
  }

  public String d()
  {
    return this.b;
  }

  public Double e()
  {
    return this.c.j();
  }

  public String f()
  {
    if (this.c != null)
      return this.c.c();
    return null;
  }

  public ArrayList<String> g()
  {
    if (this.c != null)
      return this.c.d();
    return null;
  }

  public ArrayList<String> h()
  {
    if (this.c != null)
      return this.c.e();
    return null;
  }

  public ArrayList<String> i()
  {
    if (this.c != null)
      return this.c.f();
    return null;
  }

  public ArrayList<String> j()
  {
    if (this.c != null)
      return this.c.g();
    return null;
  }

  public ArrayList<String> k()
  {
    if (this.c != null)
      return this.c.h();
    return null;
  }

  public f l()
  {
    if ((this.b != null) && (this.b.equalsIgnoreCase("FAIL")))
    {
      this.d = new f();
      this.d.a(this.a.optString("message"));
      this.d.c(this.a.optString("zid"));
      this.d.b(this.a.optString("uuid"));
      return this.d;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.b.c
 * JD-Core Version:    0.6.2
 */