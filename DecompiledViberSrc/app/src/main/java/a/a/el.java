package a.a;

import com.appboy.f.c;
import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class el extends eo
{
  private static final String b = c.a(el.class);
  private String c;

  public el(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.c = paramJSONObject.getJSONObject("data").getString("product_id");
  }

  public JSONObject a()
  {
    JSONObject localJSONObject1 = super.a();
    try
    {
      localJSONObject1.put("type", "purchase_property");
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
      localJSONObject2.put("product_id", this.c);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      c.d(b, "Caught exception creating Json.", localJSONException);
    }
    return localJSONObject1;
  }

  public boolean a(ez paramez)
  {
    if ((paramez instanceof fd))
    {
      if (i.c(this.c))
        return false;
      fd localfd = (fd)paramez;
      if ((!i.c(localfd.a())) && (localfd.a().equals(this.c)))
        return super.a(paramez);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.el
 * JD-Core Version:    0.6.2
 */