package a.a;

import android.content.Context;
import com.appboy.e.b;
import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public class dz extends eb
  implements dy
{
  private static final String a = com.appboy.f.c.a(dz.class);
  private b b;
  private au c;
  private String d;

  public dz(JSONObject paramJSONObject, au paramau)
  {
    super(paramJSONObject);
    com.appboy.f.c.b(a, "Parsing in-app message triggered action with JSON: " + dr.a(paramJSONObject));
    JSONObject localJSONObject = paramJSONObject.getJSONObject("data");
    if (localJSONObject != null)
    {
      this.c = paramau;
      this.b = dq.a(localJSONObject, this.c);
      return;
    }
    com.appboy.f.c.d(a, "InAppMessageTriggeredAction Json did not contain in-app message.");
  }

  public void a(Context paramContext, d paramd, ez paramez, long paramLong)
  {
    try
    {
      com.appboy.f.c.b(a, "Attempting to publish in-app message after delay of " + c().d() + " seconds.");
      if (!i.c(this.d))
        this.b.a(this.d);
      this.b.a(paramLong);
      paramd.a(new k(this, this.b, this.c.e()), k.class);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(a, "Caught exception while performing triggered action.", localException);
    }
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public fq d()
  {
    if (i.c(this.b.s()))
      return null;
    if ((this.b instanceof com.appboy.e.c))
      return new fq(ex.a, this.b.s());
    return new fq(ex.b, this.b.s());
  }

  public JSONObject f()
  {
    try
    {
      JSONObject localJSONObject = super.f();
      localJSONObject.put("data", this.b.h());
      localJSONObject.put("type", "inapp");
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dz
 * JD-Core Version:    0.6.2
 */