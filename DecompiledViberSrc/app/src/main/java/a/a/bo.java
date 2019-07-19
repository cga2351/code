package a.a;

import com.appboy.e.e;
import org.json.JSONArray;
import org.json.JSONObject;

public class bo
  implements bg, e<JSONArray>
{
  private final JSONObject a;
  private final JSONArray b;

  public bo(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject;
    this.b = new JSONArray();
    this.b.put(this.a);
  }

  public JSONObject a()
  {
    return this.a;
  }

  public boolean b()
  {
    if ((this.a == null) || (this.a.length() == 0));
    while ((this.a.length() == 1) && (this.a.has("user_id")))
      return true;
    return false;
  }

  public JSONArray c()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bo
 * JD-Core Version:    0.6.2
 */