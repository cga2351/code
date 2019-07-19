package a.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class ei
  implements eg
{
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "open");
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public boolean a(ez paramez)
  {
    return paramez instanceof fc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ei
 * JD-Core Version:    0.6.2
 */