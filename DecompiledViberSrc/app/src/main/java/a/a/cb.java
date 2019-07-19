package a.a;

import android.net.Uri;
import com.appboy.f.c;
import com.appboy.f.i;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class cb extends bz
{
  private static final String b = c.a(cb.class);
  private final long c;
  private final long d;
  private final String e;

  public cb(String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    super(Uri.parse(paramString1 + "content_cards/sync"), null);
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramString2;
  }

  public void a(d paramd, bu parambu)
  {
    c.b(b, "ContentCardsSyncRequest executed successfully.");
  }

  public void a(Map<String, String> paramMap)
  {
    super.a(paramMap);
    paramMap.put("X-Braze-DataRequest", "true");
    paramMap.put("X-Braze-ContentCardsRequest", "true");
  }

  public JSONObject g()
  {
    JSONObject localJSONObject = super.g();
    if (localJSONObject == null)
      return null;
    try
    {
      localJSONObject.put("last_full_sync_at", this.d);
      localJSONObject.put("last_card_updated_at", this.c);
      if (!i.c(this.e))
        localJSONObject.put("user_id", this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.c(b, "Experienced JSONException while creating Content Cards request. Returning null.", localJSONException);
    }
    return null;
  }

  public boolean h()
  {
    return false;
  }

  public gu i()
  {
    return gu.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cb
 * JD-Core Version:    0.6.2
 */