package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.h;
import com.yandex.metrica.impl.h.b;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class hh
{
  private final String a;
  private final String b;
  private final String c;
  private final Point d;

  @SuppressLint({"NewApi", "HardwareIds", "ObsoleteSdkInt"})
  public hh(Context paramContext, String paramString, iv paramiv)
  {
    this.a = Build.MANUFACTURER;
    this.b = Build.MODEL;
    String str;
    if (bw.a(28))
      if (paramiv.d(paramContext))
        str = Build.getSerial();
    while (true)
    {
      this.c = str;
      h.b localb = h.a(paramContext).f;
      this.d = new Point(localb.a, localb.b);
      return;
      str = oq.b(paramString, "");
      continue;
      if (bw.a(8))
        str = Build.SERIAL;
      else
        str = oq.b(paramString, "");
    }
  }

  public hh(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    this.a = localJSONObject.getString("manufacturer");
    this.b = localJSONObject.getString("model");
    this.c = localJSONObject.getString("serial");
    this.d = new Point(localJSONObject.getInt("width"), localJSONObject.getInt("height"));
  }

  public String a()
  {
    return this.c;
  }

  public JSONObject b()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("manufacturer", this.a);
    localJSONObject.put("model", this.b);
    localJSONObject.put("serial", this.c);
    localJSONObject.put("width", this.d.x);
    localJSONObject.put("height", this.d.y);
    return localJSONObject;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    hh localhh;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localhh = (hh)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localhh.a));
      }
      else
        while (localhh.a != null)
          return false;
      if (this.b != null)
      {
        if (this.b.equals(localhh.b));
      }
      else
        while (localhh.b != null)
          return false;
      if (this.d != null)
        return this.d.equals(localhh.d);
    }
    while (localhh.d == null);
    return false;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.a != null)
    {
      i = this.a.hashCode();
      j = i * 31;
      if (this.b == null)
        break label77;
    }
    label77: for (int k = this.b.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      Point localPoint = this.d;
      int n = 0;
      if (localPoint != null)
        n = this.d.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public String toString()
  {
    return "DeviceSnapshot{mManufacturer='" + this.a + '\'' + ", mModel='" + this.b + '\'' + ", mSerial='" + this.c + '\'' + ", mScreenSize=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hh
 * JD-Core Version:    0.6.2
 */