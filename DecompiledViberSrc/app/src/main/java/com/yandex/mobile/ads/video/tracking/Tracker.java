package com.yandex.mobile.ads.video.tracking;

import android.content.Context;
import com.yandex.mobile.ads.impl.px;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.models.ad.Creative;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Tracker
{
  private final Context a;
  private ErrorListener b;

  public Tracker()
  {
    this.a = null;
  }

  public Tracker(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }

  private void a(String paramString, Map<String, List<String>> paramMap)
  {
    List localList = (List)paramMap.get(paramString);
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        px.a(this.a).a(str, this.b);
      }
    }
    if (this.b != null)
      this.b.onTrackingError(VideoAdError.createInternalError(String.format("For %s there are no events.", new Object[] { paramString })));
  }

  public void setErrorListener(ErrorListener paramErrorListener)
  {
    this.b = paramErrorListener;
  }

  public void trackAdEvent(VideoAd paramVideoAd, String paramString)
  {
    a(paramString, paramVideoAd.getTrackingEvents());
  }

  public void trackCreativeEvent(Creative paramCreative, String paramString)
  {
    a(paramString, paramCreative.getTrackingEvents());
  }

  public static abstract interface ErrorListener
  {
    public abstract void onTrackingError(VideoAdError paramVideoAdError);
  }

  public static class Events
  {
    public static final String AD_IMPRESSION = "impression";
    public static final String CREATIVE_CLICK_TRACKING = "clickTracking";
    public static final String CREATIVE_CLOSE = "close";
    public static final String CREATIVE_COLLAPSE = "collapse";
    public static final String CREATIVE_COMPLETE = "complete";
    public static final String CREATIVE_EXPAND = "expand";
    public static final String CREATIVE_FIRST_QUARTILE = "firstQuartile";
    public static final String CREATIVE_FULLSCREEN = "fullscreen";
    public static final String CREATIVE_MIDPOINT = "midpoint";
    public static final String CREATIVE_MUTE = "mute";
    public static final String CREATIVE_START = "start";
    public static final String CREATIVE_THIRD_QUARTILE = "thirdQuartile";
    public static final String CREATIVE_UNMUTE = "unmute";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.tracking.Tracker
 * JD-Core Version:    0.6.2
 */