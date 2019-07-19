package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public abstract class BaseNativeAd
{
  private final Set<String> a = new HashSet();
  private final Set<String> b = new HashSet();
  private NativeEventListener c;
  private boolean d = false;

  protected final void a()
  {
    if (this.c != null)
      this.c.onAdImpressed();
  }

  protected final void a(Object paramObject)
    throws ClassCastException
  {
    if (!(paramObject instanceof JSONArray))
      throw new ClassCastException("Expected impression trackers of type JSONArray.");
    JSONArray localJSONArray = (JSONArray)paramObject;
    int i = 0;
    while (true)
      if (i < localJSONArray.length())
        try
        {
          addImpressionTracker(localJSONArray.getString(i));
          i++;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Unable to parse impression trackers." });
        }
  }

  public final void addClickTracker(String paramString)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramString, "clickTracker url is not allowed to be null"))
      return;
    this.b.add(paramString);
  }

  public final void addImpressionTracker(String paramString)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramString, "impressionTracker url is not allowed to be null"))
      return;
    this.a.add(paramString);
  }

  protected final void b()
  {
    if (this.c != null)
      this.c.onAdClicked();
  }

  protected final void b(Object paramObject)
    throws ClassCastException
  {
    if (!(paramObject instanceof JSONArray))
      throw new ClassCastException("Expected click trackers of type JSONArray.");
    JSONArray localJSONArray = (JSONArray)paramObject;
    int i = 0;
    while (true)
      if (i < localJSONArray.length())
        try
        {
          addClickTracker(localJSONArray.getString(i));
          i++;
        }
        catch (JSONException localJSONException)
        {
          while (true)
            MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Unable to parse click trackers." });
        }
  }

  Set<String> c()
  {
    return new HashSet(this.a);
  }

  public abstract void clear(View paramView);

  Set<String> d()
  {
    return new HashSet(this.b);
  }

  public abstract void destroy();

  public void invalidate()
  {
    this.d = true;
  }

  public boolean isInvalidated()
  {
    return this.d;
  }

  public abstract void prepare(View paramView);

  public void setNativeEventListener(NativeEventListener paramNativeEventListener)
  {
    this.c = paramNativeEventListener;
  }

  public static abstract interface NativeEventListener
  {
    public abstract void onAdClicked();

    public abstract void onAdImpressed();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.BaseNativeAd
 * JD-Core Version:    0.6.2
 */