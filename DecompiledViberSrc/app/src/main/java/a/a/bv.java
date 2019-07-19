package a.a;

import org.json.JSONArray;
import org.json.JSONObject;

public class bv
{
  private final long a;
  private final long b;
  private final boolean c;
  private final JSONArray d;

  public bv(String paramString)
  {
    this.c = false;
    this.a = -1L;
    this.b = -1L;
    JSONObject localJSONObject = new JSONObject(paramString);
    this.d = new JSONArray().put(localJSONObject);
  }

  public bv(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optLong("last_card_updated_at", -1L);
    this.b = paramJSONObject.optLong("last_full_sync_at", -1L);
    this.c = paramJSONObject.optBoolean("full_sync", false);
    this.d = paramJSONObject.optJSONArray("cards");
  }

  public long a()
  {
    return this.b;
  }

  public long b()
  {
    return this.a;
  }

  public boolean c()
  {
    return this.c;
  }

  public JSONArray d()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bv
 * JD-Core Version:    0.6.2
 */