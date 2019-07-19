package a.a;

import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ek
  implements eg
{
  String a;

  ek()
  {
  }

  public ek(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    if ((localJSONObject != null) && (!localJSONObject.isNull("product_id")))
      this.a = localJSONObject.optString("product_id", null);
  }

  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", "purchase");
      if (this.a != null)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("product_id", this.a);
        localJSONObject1.putOpt("data", localJSONObject2);
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public boolean a(ez paramez)
  {
    if ((paramez instanceof fd))
    {
      if (i.c(this.a));
      fd localfd;
      do
      {
        return true;
        localfd = (fd)paramez;
      }
      while ((!i.c(localfd.a())) && (localfd.a().equals(this.a)));
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ek
 * JD-Core Version:    0.6.2
 */