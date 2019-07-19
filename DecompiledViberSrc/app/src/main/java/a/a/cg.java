package a.a;

import android.net.Uri;
import com.appboy.f.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class cg extends bz
{
  private static final String b = c.a(cg.class);
  private final be c;

  public cg(String paramString, be parambe)
  {
    super(Uri.parse(paramString + "geofence/report"), null);
    this.c = parambe;
  }

  public void a(d paramd, bu parambu)
  {
    c.b(b, "GeofenceReportRequest executed successfully.");
  }

  public JSONObject g()
  {
    JSONObject localJSONObject = super.g();
    if (localJSONObject == null)
      return null;
    try
    {
      if (this.c != null)
        localJSONObject.put("geofence_event", this.c.h());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.c(b, "Experienced JSONException while creating geofence report request. Returning null.", localJSONException);
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
 * Qualified Name:     a.a.cg
 * JD-Core Version:    0.6.2
 */