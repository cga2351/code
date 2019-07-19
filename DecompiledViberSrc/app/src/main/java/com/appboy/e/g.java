package com.appboy.e;

import a.a.au;
import a.a.bp;
import com.appboy.f.c;
import com.appboy.f.i;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends f
{
  private boolean j = false;

  public g(JSONObject paramJSONObject, au paramau)
  {
    super(paramJSONObject, paramau);
  }

  public boolean x()
  {
    if (this.j)
    {
      c.c(a, "Control impression already logged for this in-app message. Ignoring.");
      return false;
    }
    if (i.b(this.d))
    {
      c.d(a, "Trigger Id not found. Not logging in-app message control impression.");
      return false;
    }
    if (this.i == null)
    {
      c.e(a, "Cannot log an in-app message control impression because the AppboyManager is null.");
      return false;
    }
    try
    {
      c.a(a, "Logging control in-app message impression event");
      bp localbp = bp.a(this.b, this.c, this.d);
      this.i.a(localbp);
      this.j = true;
      return true;
    }
    catch (JSONException localJSONException)
    {
      this.i.a(localJSONException);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.g
 * JD-Core Version:    0.6.2
 */