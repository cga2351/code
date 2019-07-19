package com.appboy.e;

import a.a.fv;
import a.a.fx;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.Geofence.Builder;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements e<JSONObject>, Comparable<a>
{
  final int a;
  final boolean b;
  final boolean c;
  final int d;
  double e = -1.0D;
  private final JSONObject f;
  private final String g;
  private final double h;
  private final double i;
  private final int j;
  private final int k;
  private final boolean l;
  private final boolean m;

  public a(JSONObject paramJSONObject)
  {
    this(paramJSONObject, paramJSONObject.getString("id"), paramJSONObject.getDouble("latitude"), paramJSONObject.getDouble("longitude"), paramJSONObject.getInt("radius"), paramJSONObject.getInt("cooldown_enter"), paramJSONObject.getInt("cooldown_exit"), paramJSONObject.getBoolean("analytics_enabled_enter"), paramJSONObject.getBoolean("analytics_enabled_exit"), paramJSONObject.optBoolean("enter_events", true), paramJSONObject.optBoolean("exit_events", true), paramJSONObject.optInt("notification_responsiveness", 30000));
  }

  a(JSONObject paramJSONObject, String paramString, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt4)
  {
    this.f = paramJSONObject;
    this.g = paramString;
    this.h = paramDouble1;
    this.i = paramDouble2;
    this.a = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.m = paramBoolean1;
    this.l = paramBoolean2;
    this.b = paramBoolean3;
    this.c = paramBoolean4;
    this.d = paramInt4;
  }

  public String a()
  {
    return this.g;
  }

  public void a(double paramDouble)
  {
    this.e = paramDouble;
  }

  public boolean a(a parama)
  {
    try
    {
      fv.a(parama.k(), this.f, fx.b);
      return true;
    }
    catch (JSONException localJSONException)
    {
      return false;
    }
    catch (AssertionError localAssertionError)
    {
    }
    return false;
  }

  public int b(a parama)
  {
    if (this.e == -1.0D);
    while (this.e >= parama.i())
      return 1;
    return -1;
  }

  public boolean b()
  {
    return this.m;
  }

  public boolean c()
  {
    return this.l;
  }

  public int d()
  {
    return this.j;
  }

  public int e()
  {
    return this.k;
  }

  public double f()
  {
    return this.h;
  }

  public double g()
  {
    return this.i;
  }

  public double i()
  {
    return this.e;
  }

  public Geofence j()
  {
    Geofence.Builder localBuilder = new Geofence.Builder();
    localBuilder.setRequestId(this.g).setCircularRegion(this.h, this.i, this.a).setNotificationResponsiveness(this.d).setExpirationDuration(-1L);
    boolean bool = this.b;
    int n = 0;
    if (bool)
      n = 1;
    if (this.c)
      n |= 2;
    localBuilder.setTransitionTypes(n);
    return localBuilder.build();
  }

  public JSONObject k()
  {
    return this.f;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AppboyGeofence{");
    localStringBuilder.append("id=").append(this.g);
    localStringBuilder.append(", latitude='").append(this.h);
    localStringBuilder.append(", longitude=").append(this.i);
    localStringBuilder.append(", radiusMeters=").append(this.a);
    localStringBuilder.append(", cooldownEnterSeconds=").append(this.j);
    localStringBuilder.append(", cooldownExitSeconds=").append(this.k);
    localStringBuilder.append(", analyticsEnabledEnter=").append(this.m);
    localStringBuilder.append(", analyticsEnabledExit=").append(this.l);
    localStringBuilder.append(", enterEvents=").append(this.b);
    localStringBuilder.append(", exitEvents=").append(this.c);
    localStringBuilder.append(", notificationResponsivenessMs=").append(this.d);
    localStringBuilder.append(", distanceFromGeofenceRefresh=").append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.a
 * JD-Core Version:    0.6.2
 */