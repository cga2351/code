package com.iab.omid.library.appnexus.adsession.video;

import com.iab.omid.library.appnexus.d.c;
import com.iab.omid.library.appnexus.d.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class VastProperties
{
  private final boolean a;
  private final Float b;
  private final boolean c;
  private final Position d;

  private VastProperties(boolean paramBoolean1, Float paramFloat, boolean paramBoolean2, Position paramPosition)
  {
    this.a = paramBoolean1;
    this.b = paramFloat;
    this.c = paramBoolean2;
    this.d = paramPosition;
  }

  public static VastProperties createVastPropertiesForNonSkippableVideo(boolean paramBoolean, Position paramPosition)
  {
    e.a(paramPosition, "Position is null");
    return new VastProperties(false, null, paramBoolean, paramPosition);
  }

  public static VastProperties createVastPropertiesForSkippableVideo(float paramFloat, boolean paramBoolean, Position paramPosition)
  {
    e.a(paramPosition, "Position is null");
    return new VastProperties(true, Float.valueOf(paramFloat), paramBoolean, paramPosition);
  }

  JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("skippable", this.a);
      if (this.a)
        localJSONObject.put("skipOffset", this.b);
      localJSONObject.put("autoPlay", this.c);
      localJSONObject.put("position", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.a("VastProperties: JSON error", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.video.VastProperties
 * JD-Core Version:    0.6.2
 */