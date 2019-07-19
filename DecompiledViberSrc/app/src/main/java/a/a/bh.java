package a.a;

import com.appboy.e.e;
import com.appboy.f.c;
import org.json.JSONException;
import org.json.JSONObject;

public class bh
  implements e<JSONObject>
{
  private static final String a = c.a(bh.class);
  private final bi b;
  private final double c;
  private volatile Double d;
  private volatile boolean e = false;

  public bh(bi parambi, double paramDouble)
  {
    this(parambi, paramDouble, null, false);
  }

  public bh(bi parambi, double paramDouble, Double paramDouble1, boolean paramBoolean)
  {
    this.b = parambi;
    this.c = paramDouble;
    this.e = paramBoolean;
    this.d = paramDouble1;
  }

  public bh(JSONObject paramJSONObject)
  {
    this.b = bi.a(paramJSONObject.getString("session_id"));
    this.c = paramJSONObject.getDouble("start_time");
    this.e = paramJSONObject.getBoolean("is_sealed");
    if (paramJSONObject.has("end_time"))
      this.d = Double.valueOf(paramJSONObject.getDouble("end_time"));
  }

  public bi a()
  {
    return this.b;
  }

  public void a(Double paramDouble)
  {
    this.d = paramDouble;
  }

  public double b()
  {
    return this.c;
  }

  public Double c()
  {
    return this.d;
  }

  public boolean d()
  {
    return this.e;
  }

  public void e()
  {
    this.e = true;
    a(Double.valueOf(di.b()));
  }

  public long f()
  {
    long l;
    if (this.d == null)
      l = -1L;
    do
    {
      return l;
      l = ()(this.d.doubleValue() - this.c);
    }
    while (l >= 0L);
    c.d(a, "End time '" + this.d + "' for session is less than the start time '" + this.c + "' for this session.");
    return l;
  }

  public JSONObject g()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("session_id", this.b);
      localJSONObject.put("start_time", this.c);
      localJSONObject.put("is_sealed", this.e);
      if (this.d != null)
        localJSONObject.put("end_time", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.d(a, "Caught exception creating Session Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bh
 * JD-Core Version:    0.6.2
 */