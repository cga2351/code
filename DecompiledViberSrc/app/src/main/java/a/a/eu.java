package a.a;

import org.json.JSONException;
import org.json.JSONObject;

public class eu
  implements es
{
  private final int a;

  public eu(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("re_eligibility", -1);
  }

  public boolean a()
  {
    return this.a == 0;
  }

  public boolean b()
  {
    return this.a == -1;
  }

  public Integer c()
  {
    if (this.a > 0)
      return Integer.valueOf(this.a);
    return null;
  }

  public JSONObject d()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("re_eligibility", this.a);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.eu
 * JD-Core Version:    0.6.2
 */