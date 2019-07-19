package a.a;

import com.appboy.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class eb
  implements dy
{
  private static final String a = c.a(eb.class);
  private final String b;
  private final et c;
  private final List<eg> d = new ArrayList();
  private boolean e;
  private fr f;

  protected eb(JSONObject paramJSONObject)
  {
    this.b = paramJSONObject.getString("id");
    this.c = new ev(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.getJSONArray("trigger_condition");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
      this.d.addAll(fs.a(localJSONArray));
    this.e = paramJSONObject.optBoolean("prefetch", true);
  }

  public void a(fr paramfr)
  {
    this.f = paramfr;
  }

  public boolean a()
  {
    return this.e;
  }

  public boolean a(ez paramez)
  {
    if (!k())
    {
      c.b(a, "Triggered action " + this.b + "not eligible to be triggered by " + paramez.b() + " event. Current device time outside triggered action time window.");
      return false;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      if (((eg)localIterator.next()).a(paramez))
        return true;
    return false;
  }

  public String b()
  {
    return this.b;
  }

  public et c()
  {
    return this.c;
  }

  public fr e()
  {
    return this.f;
  }

  public JSONObject f()
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = (JSONObject)this.c.h();
      localJSONObject.put("id", this.b);
      if (this.d != null)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext())
          localJSONArray.put(((eg)localIterator.next()).h());
        localJSONObject.put("trigger_condition", localJSONArray);
        localJSONObject.put("prefetch", this.e);
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONObject = null;
    }
    return localJSONObject;
  }

  boolean k()
  {
    return (l()) && (m());
  }

  boolean l()
  {
    return (this.c.a() == -1L) || (di.a() > this.c.a());
  }

  boolean m()
  {
    return (this.c.b() == -1L) || (di.a() < this.c.b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.eb
 * JD-Core Version:    0.6.2
 */