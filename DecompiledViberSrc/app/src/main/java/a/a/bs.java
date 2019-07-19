package a.a;

import org.json.JSONObject;

public class bs extends bp
{
  private bs(gs paramgs, JSONObject paramJSONObject)
  {
    super(paramgs, paramJSONObject);
  }

  public static bs e(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cid", paramString1);
    localJSONObject.put("a", paramString2);
    return new bs(gs.d, localJSONObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bs
 * JD-Core Version:    0.6.2
 */