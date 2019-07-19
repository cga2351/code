package com.crashlytics.android.a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import c.a.a.a.a.d.a;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class af
  implements a<ad>
{
  public byte[] a(ad paramad)
    throws IOException
  {
    return b(paramad).toString().getBytes("UTF-8");
  }

  @TargetApi(9)
  public JSONObject b(ad paramad)
    throws IOException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      ae localae = paramad.a;
      localJSONObject.put("appBundleId", localae.a);
      localJSONObject.put("executionId", localae.b);
      localJSONObject.put("installationId", localae.c);
      localJSONObject.put("limitAdTrackingEnabled", localae.d);
      localJSONObject.put("betaDeviceToken", localae.e);
      localJSONObject.put("buildId", localae.f);
      localJSONObject.put("osVersion", localae.g);
      localJSONObject.put("deviceModel", localae.h);
      localJSONObject.put("appVersionCode", localae.i);
      localJSONObject.put("appVersionName", localae.j);
      localJSONObject.put("timestamp", paramad.b);
      localJSONObject.put("type", paramad.c.toString());
      if (paramad.d != null)
        localJSONObject.put("details", new JSONObject(paramad.d));
      localJSONObject.put("customType", paramad.e);
      if (paramad.f != null)
        localJSONObject.put("customAttributes", new JSONObject(paramad.f));
      localJSONObject.put("predefinedType", paramad.g);
      if (paramad.h != null)
        localJSONObject.put("predefinedAttributes", new JSONObject(paramad.h));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (Build.VERSION.SDK_INT >= 9)
        throw new IOException(localJSONException.getMessage(), localJSONException);
      throw new IOException(localJSONException.getMessage());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.af
 * JD-Core Version:    0.6.2
 */