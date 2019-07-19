package a.a;

import com.appboy.e.e;
import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public class bn
  implements bg, e<JSONObject>
{
  private final String a;
  private final Boolean b;
  private final Boolean c;
  private final bm d;

  private bn(String paramString, Boolean paramBoolean1, Boolean paramBoolean2, bm parambm)
  {
    this.a = paramString;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = parambm;
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!i.b(this.a))
        localJSONObject.put("user_id", this.a);
      if (this.b != null)
        localJSONObject.put("feed", this.b);
      if (this.c != null)
        localJSONObject.put("triggers", this.c);
      if (this.d != null)
        localJSONObject.put("config", this.d.a());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public boolean b()
  {
    JSONObject localJSONObject = a();
    if (localJSONObject.length() == 0)
      return true;
    if (localJSONObject.length() == 1)
      return localJSONObject.has("user_id");
    return false;
  }

  public boolean c()
  {
    return this.d != null;
  }

  public boolean d()
  {
    return this.c != null;
  }

  public boolean e()
  {
    return this.b != null;
  }

  public boolean f()
  {
    return !i.b(this.a);
  }

  public static class a
  {
    private String a;
    private Boolean b;
    private Boolean c;
    private bm d;

    public a a()
    {
      this.b = Boolean.valueOf(true);
      return this;
    }

    public a a(bm parambm)
    {
      this.d = parambm;
      return this;
    }

    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public a b()
    {
      this.c = Boolean.valueOf(true);
      return this;
    }

    public bn c()
    {
      return new bn(this.a, this.b, this.c, this.d, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bn
 * JD-Core Version:    0.6.2
 */