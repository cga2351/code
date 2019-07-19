package com.appboy.e.b;

import a.a.bl;
import com.appboy.e.e;
import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements e<JSONObject>
{
  private static final String a = com.appboy.f.c.a(c.class);
  private final String b;
  private final String c;
  private final boolean d;
  private final bl e;
  private final String f;

  public c(String paramString1, String paramString2, boolean paramBoolean, bl parambl, String paramString3)
  {
    if (i.c(paramString1))
      throw new IllegalArgumentException("Message cannot be null or blank");
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean;
    this.e = parambl;
    this.f = paramString3;
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("message", i.a(this.b));
      localJSONObject.put("reply_to", this.c);
      localJSONObject.put("is_bug", this.d);
      if (this.e != null)
        localJSONObject.put("device", this.e.a());
      if (!i.b(this.f))
        localJSONObject.put("user_id", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      com.appboy.f.c.d(a, "Caught exception creating feedback Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.b.c
 * JD-Core Version:    0.6.2
 */