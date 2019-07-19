package com.yandex.metrica.impl.ob;

import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class hf
{
  private final he a;
  private final hh b;
  private final long c;
  private final boolean d;
  private final long e;

  public hf(he paramhe, hh paramhh, long paramLong)
  {
    this.a = paramhe;
    this.b = paramhh;
    this.c = paramLong;
    this.d = d();
    this.e = -1L;
  }

  public hf(JSONObject paramJSONObject, long paramLong)
    throws JSONException
  {
    this.a = new he(paramJSONObject.optString("device_id", null), paramJSONObject.optString("device_id_hash", null));
    if (paramJSONObject.has("device_snapshot_key"));
    for (this.b = new hh(paramJSONObject.optString("device_snapshot_key", null)); ; this.b = null)
    {
      this.c = paramJSONObject.optLong("last_elections_time", -1L);
      this.d = d();
      this.e = paramLong;
      return;
    }
  }

  private boolean d()
  {
    boolean bool1 = this.c < -1L;
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = System.currentTimeMillis() - this.c < 604800000L;
      bool2 = false;
      if (bool3)
        bool2 = true;
    }
    return bool2;
  }

  public String a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("device_id", this.a.a);
    localJSONObject.put("device_id_hash", this.a.b);
    if (this.b != null)
      localJSONObject.put("device_snapshot_key", this.b.b());
    localJSONObject.put("last_elections_time", this.c);
    return localJSONObject.toString();
  }

  public he b()
  {
    return this.a;
  }

  public hh c()
  {
    return this.b;
  }

  public String toString()
  {
    return "Credentials{mIdentifiers=" + this.a + ", mDeviceSnapshot=" + this.b + ", mLastElectionsTime=" + this.c + ", mFresh=" + this.d + ", mLastModified=" + this.e + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hf
 * JD-Core Version:    0.6.2
 */