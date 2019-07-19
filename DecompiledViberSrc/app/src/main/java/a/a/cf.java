package a.a;

import android.net.Uri;
import com.appboy.f.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class cf extends bz
{
  private static final String b = c.a(cf.class);
  private final be c;

  public cf(String paramString, bf parambf)
  {
    super(Uri.parse(paramString + "geofence/request"), null);
    this.c = bp.a(parambf);
  }

  public void a(d paramd, bu parambu)
  {
    c.b(b, "GeofenceRefreshRequest executed successfully.");
  }

  public JSONObject g()
  {
    JSONObject localJSONObject = super.g();
    if (localJSONObject == null)
      return null;
    try
    {
      if (this.c != null)
        localJSONObject.put("location_event", this.c.h());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.c(b, "Experienced JSONException while creating geofence refresh request. Returning null.", localJSONException);
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
 * Qualified Name:     a.a.cf
 * JD-Core Version:    0.6.2
 */