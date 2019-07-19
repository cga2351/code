package a.a;

import com.appboy.f.c;
import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class ed extends eo
{
  private static final String b = c.a(ed.class);
  private String c;

  public ed(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.c = paramJSONObject.getJSONObject("data").getString("event_name");
  }

  public JSONObject a()
  {
    JSONObject localJSONObject1 = super.a();
    try
    {
      localJSONObject1.put("type", "custom_event_property");
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
      localJSONObject2.put("event_name", this.c);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      c.d(b, "Caught exception creating CustomEventWithPropertiesTriggerCondition Json.", localJSONException);
    }
    return localJSONObject1;
  }

  public boolean a(ez paramez)
  {
    if ((paramez instanceof ey))
    {
      ey localey = (ey)paramez;
      if ((!i.c(localey.a())) && (localey.a().equals(this.c)))
        return super.a(paramez);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ed
 * JD-Core Version:    0.6.2
 */