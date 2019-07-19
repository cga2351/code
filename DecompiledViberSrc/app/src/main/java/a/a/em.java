package a.a;

import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class em
  implements eg
{
  private String a;

  em()
  {
  }

  public em(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    if ((localJSONObject != null) && (!localJSONObject.isNull("campaign_id")))
      this.a = localJSONObject.optString("campaign_id", null);
  }

  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", "push_click");
      if (this.a != null)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("campaign_id", this.a);
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
    if ((paramez instanceof fe))
    {
      if (i.c(this.a));
      fe localfe;
      do
      {
        return true;
        localfe = (fe)paramez;
      }
      while ((!i.c(localfe.a())) && (localfe.a().equals(this.a)));
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.em
 * JD-Core Version:    0.6.2
 */