package com.appboy.e;

import a.a.au;
import a.a.bp;
import a.a.dr;
import a.a.fb;
import android.graphics.Color;
import com.appboy.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class k extends f
  implements d
{
  protected com.appboy.b.a.d j = com.appboy.b.a.d.b;
  private int k = Color.parseColor("#333333");
  private int l = Color.parseColor("#9B9B9B");
  private String m;
  private List<n> n;
  private Integer o = null;
  private com.appboy.b.a.i p = com.appboy.b.a.i.b;
  private boolean q;
  private String r = null;

  protected k()
  {
  }

  public k(JSONObject paramJSONObject, au paramau)
  {
    this(paramJSONObject, paramau, paramJSONObject.optString("header"), paramJSONObject.optInt("header_text_color"), paramJSONObject.optInt("close_btn_color"), (com.appboy.b.a.d)dr.a(paramJSONObject, "image_style", com.appboy.b.a.d.class, com.appboy.b.a.d.b), (com.appboy.b.a.i)dr.a(paramJSONObject, "text_align_header", com.appboy.b.a.i.class, com.appboy.b.a.i.b), (com.appboy.b.a.i)dr.a(paramJSONObject, "text_align_message", com.appboy.b.a.i.class, com.appboy.b.a.i.b));
    if (paramJSONObject.optJSONArray("btns") != null)
    {
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray = paramJSONObject.optJSONArray("btns");
      for (int i = 0; i < localJSONArray.length(); i++)
        localArrayList.add(new n(localJSONArray.optJSONObject(i)));
      a(localArrayList);
    }
    if ((this.n != null) && (this.n.size() == 2))
    {
      ((n)this.n.get(0)).a(true);
      ((n)this.n.get(1)).a(false);
    }
  }

  private k(JSONObject paramJSONObject, au paramau, String paramString, int paramInt1, int paramInt2, com.appboy.b.a.d paramd, com.appboy.b.a.i parami1, com.appboy.b.a.i parami2)
  {
    super(paramJSONObject, paramau);
    this.m = paramString;
    this.k = paramInt1;
    this.l = paramInt2;
    if (paramJSONObject.has("frame_color"))
      this.o = Integer.valueOf(paramJSONObject.optInt("frame_color"));
    this.j = paramd;
    this.p = parami1;
    this.f = parami2;
  }

  public List<n> B()
  {
    return this.n;
  }

  public com.appboy.b.a.d C()
  {
    return this.j;
  }

  public JSONObject E()
  {
    if (this.h != null)
      return this.h;
    try
    {
      JSONObject localJSONObject = super.E();
      localJSONObject.putOpt("header", this.m);
      localJSONObject.put("header_text_color", this.k);
      localJSONObject.put("close_btn_color", this.l);
      localJSONObject.putOpt("image_style", this.j.toString());
      localJSONObject.putOpt("text_align_header", this.p.toString());
      if (this.o != null)
        localJSONObject.put("frame_color", this.o.intValue());
      if (this.n != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.n.iterator();
        while (localIterator.hasNext())
          localJSONArray.put(((n)localIterator.next()).j());
        localJSONObject.put("btns", localJSONArray);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public String F()
  {
    return this.m;
  }

  public int G()
  {
    return this.k;
  }

  public int H()
  {
    return this.l;
  }

  public Integer I()
  {
    return this.o;
  }

  public com.appboy.b.a.i J()
  {
    return this.p;
  }

  public void a(List<n> paramList)
  {
    this.n = paramList;
  }

  public boolean a(n paramn)
  {
    if ((com.appboy.f.i.c(this.b)) && (com.appboy.f.i.c(this.c)) && (com.appboy.f.i.c(this.d)))
    {
      c.b(a, "Campaign, trigger, and card Ids not found. Not logging button click.");
      return false;
    }
    if (paramn == null)
    {
      c.d(a, "Message button was null. Ignoring button click.");
      return false;
    }
    if (this.q)
    {
      c.c(a, "Button click already logged for this message. Ignoring.");
      return false;
    }
    if (this.i == null)
    {
      c.e(a, "Cannot log a button click because the AppboyManager is null.");
      return false;
    }
    try
    {
      bp localbp = bp.a(this.b, this.c, this.d, paramn);
      this.r = bp.a(paramn);
      this.i.a(localbp);
      this.q = true;
      return true;
    }
    catch (JSONException localJSONException)
    {
      this.i.a(localJSONException);
    }
    return false;
  }

  public void z()
  {
    super.z();
    if ((this.q) && (!com.appboy.f.i.c(this.d)) && (!com.appboy.f.i.c(this.r)))
      this.i.a(new fb(this.d, this.r));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.k
 * JD-Core Version:    0.6.2
 */