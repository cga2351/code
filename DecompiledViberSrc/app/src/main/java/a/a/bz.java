package a.a;

import android.net.Uri;
import com.appboy.a;
import com.appboy.b.j;
import com.appboy.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bz extends cl
  implements bg, ch
{
  private static final String b = c.a(bz.class);
  private Long c;
  private String d;
  private String e;
  private String f;
  private bl g;
  private String h;
  private j i;
  private bo j;
  private bn k;
  private bb l;

  protected bz(Uri paramUri, Map<String, String> paramMap)
  {
    super(paramUri, paramMap);
  }

  public Uri a()
  {
    return a.a(this.a);
  }

  public void a(long paramLong)
  {
    this.c = Long.valueOf(paramLong);
  }

  public void a(bb parambb)
  {
    this.l = parambb;
  }

  public void a(bl parambl)
  {
    this.g = parambl;
  }

  public void a(bn parambn)
  {
    this.k = parambn;
  }

  public void a(bo parambo)
  {
    this.j = parambo;
  }

  public void a(d paramd)
  {
    if (this.j != null)
      paramd.a(new m(this.j), m.class);
    if (this.g != null)
      paramd.a(new i(this.g), i.class);
  }

  public void a(d paramd1, d paramd2, bw parambw)
  {
    c.e(b, "Error occurred while executing Braze request: " + parambw.a());
  }

  public void a(j paramj)
  {
    this.i = paramj;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public void a(Map<String, String> paramMap)
  {
    paramMap.put("X-Braze-Api-Key", this.e);
  }

  public void b(String paramString)
  {
    this.e = paramString;
  }

  public boolean b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.g);
    localArrayList.add(this.j);
    localArrayList.add(this.l);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      bg localbg = (ch)localIterator.next();
      if ((localbg != null) && (!localbg.b()))
        return false;
    }
    return true;
  }

  public bl c()
  {
    return this.g;
  }

  public void c(String paramString)
  {
    this.f = paramString;
  }

  public bo d()
  {
    return this.j;
  }

  public void d(String paramString)
  {
    this.h = paramString;
  }

  public bn e()
  {
    return this.k;
  }

  public bb f()
  {
    return this.l;
  }

  public JSONObject g()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.h != null)
        localJSONObject.put("app_version", this.h);
      if (this.d != null)
        localJSONObject.put("device_id", this.d);
      if (this.c != null)
        localJSONObject.put("time", this.c);
      if (this.e != null)
        localJSONObject.put("api_key", this.e);
      if (this.f != null)
        localJSONObject.put("sdk_version", this.f);
      if ((this.g != null) && (!this.g.b()))
        localJSONObject.put("device", this.g.a());
      if ((this.j != null) && (!this.j.b()))
        localJSONObject.put("attributes", this.j.c());
      if ((this.l != null) && (!this.l.b()))
        localJSONObject.put("events", dr.a(this.l.a()));
      if (this.i != null)
        localJSONObject.put("sdk_flavor", this.i.a());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.c(b, "Experienced JSONException while retrieving parameters. Returning null.", localJSONException);
    }
    return null;
  }

  public boolean h()
  {
    return b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bz
 * JD-Core Version:    0.6.2
 */