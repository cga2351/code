package org.webrtc.videoengine;

import org.json.JSONException;
import org.json.JSONObject;

public class CaptureCapabilityAndroid
{
  private static final String HEIGHT = "height";
  private static final String MAX_FPS = "maxFPS";
  private static final String MIN_FPS = "minFPS";
  private static final String ORIENTATION = "orientation";
  private static final String WIDTH = "width";
  public final Object extra;
  public final int height;
  public final int lens_facing;
  public int maxFPS;
  public final int minFPS;
  public final int orientation;
  public final int width;

  CaptureCapabilityAndroid()
  {
    this(0, 0, 0, 0, 0, 0, null);
  }

  CaptureCapabilityAndroid(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, null);
  }

  CaptureCapabilityAndroid(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.minFPS = paramInt3;
    this.maxFPS = paramInt4;
    this.orientation = paramInt5;
    this.lens_facing = paramInt6;
    this.extra = paramObject;
  }

  public static CaptureCapabilityAndroid fromJson(JSONObject paramJSONObject)
    throws JSONException
  {
    return new CaptureCapabilityAndroid(paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0), paramJSONObject.optInt("minFPS", 0), paramJSONObject.optInt("maxFPS", 0), paramJSONObject.optInt("orientation", 0));
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof CaptureCapabilityAndroid)) && (((CaptureCapabilityAndroid)paramObject).toString().equals(toString()));
  }

  public JSONObject toJson()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("width", this.width);
    localJSONObject.put("height", this.height);
    localJSONObject.put("minFPS", this.minFPS);
    localJSONObject.put("maxFPS", this.maxFPS);
    localJSONObject.put("orientation", this.orientation);
    return localJSONObject;
  }

  public String toString()
  {
    return "" + this.width + "x" + this.height + "@[" + this.minFPS + ":" + this.maxFPS + "]-" + this.orientation;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.CaptureCapabilityAndroid
 * JD-Core Version:    0.6.2
 */