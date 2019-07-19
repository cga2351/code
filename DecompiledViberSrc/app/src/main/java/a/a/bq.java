package a.a;

import org.json.JSONObject;

public class bq extends bp
{
  private final String a;

  private bq(gs paramgs, JSONObject paramJSONObject, String paramString)
  {
    super(paramgs, paramJSONObject);
    this.a = paramString;
  }

  public static bq e(String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cid", paramString1);
    localJSONObject.put("a", paramString2);
    return new bq(gs.f, localJSONObject, paramString3);
  }

  public boolean n()
  {
    return this.a.equals("ab_none");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bq
 * JD-Core Version:    0.6.2
 */