package a.a;

import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ec
  implements eg
{
  private String a;

  public ec(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.getJSONObject("data").getString("event_name");
  }

  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", "custom_event");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("event_name", this.a);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public boolean a(ez paramez)
  {
    if ((paramez instanceof ey))
    {
      ey localey = (ey)paramez;
      if ((!i.c(localey.a())) && (localey.a().equals(this.a)))
        return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ec
 * JD-Core Version:    0.6.2
 */