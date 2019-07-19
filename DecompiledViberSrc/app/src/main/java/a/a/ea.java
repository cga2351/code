package a.a;

import android.content.Context;
import com.appboy.f.c;
import com.appboy.f.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ea extends eb
  implements dy
{
  private static final String a = c.a(ea.class);
  private au b;
  private String c;
  private String d;
  private String e;
  private String f;
  private long g = -1L;

  public ea(JSONObject paramJSONObject, au paramau)
  {
    super(paramJSONObject);
    c.b(a, "Parsing templated triggered action with JSON: " + dr.a(paramJSONObject));
    JSONObject localJSONObject = paramJSONObject.getJSONObject("data");
    this.c = localJSONObject.getString("trigger_id");
    JSONArray localJSONArray1 = localJSONObject.optJSONArray("prefetch_image_urls");
    if (localJSONArray1 != null)
      this.d = localJSONArray1.getString(0);
    JSONArray localJSONArray2 = localJSONObject.optJSONArray("prefetch_zip_urls");
    if (localJSONArray2 != null)
      this.e = localJSONArray2.getString(0);
    this.b = paramau;
  }

  public void a(Context paramContext, d paramd, ez paramez, long paramLong)
  {
    if (this.b != null)
    {
      this.g = paramLong;
      c.b(a, "Posting templating request after delay of " + c().d() + " seconds.");
      this.b.a(this, paramez);
    }
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public fq d()
  {
    if (!i.c(this.d))
      return new fq(ex.b, this.d);
    if (!i.c(this.e))
      return new fq(ex.a, this.e);
    return null;
  }

  public JSONObject f()
  {
    try
    {
      JSONObject localJSONObject1 = super.f();
      localJSONObject1.put("type", "templated_iam");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("trigger_id", this.c);
      JSONArray localJSONArray1 = new JSONArray();
      if (!i.c(this.d))
      {
        localJSONArray1.put(this.d);
        localJSONObject2.put("prefetch_image_urls", localJSONArray1);
      }
      JSONArray localJSONArray2 = new JSONArray();
      if (!i.c(this.e))
      {
        localJSONArray2.put(this.e);
        localJSONObject2.put("prefetch_zip_urls", localJSONArray2);
      }
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public long g()
  {
    return this.g;
  }

  public String i()
  {
    return this.c;
  }

  public String j()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ea
 * JD-Core Version:    0.6.2
 */