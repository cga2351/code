package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import java.util.Map;
import java.util.Set;

public abstract interface ExternalViewabilitySession
{
  public abstract Boolean createDisplaySession(Context paramContext, WebView paramWebView, boolean paramBoolean);

  public abstract Boolean createVideoSession(Activity paramActivity, View paramView, Set<String> paramSet, Map<String, String> paramMap);

  public abstract Boolean endDisplaySession();

  public abstract Boolean endVideoSession();

  public abstract String getName();

  public abstract Boolean initialize(Context paramContext);

  public abstract Boolean invalidate();

  public abstract Boolean onVideoPrepared(View paramView, int paramInt);

  public abstract Boolean recordVideoEvent(VideoEvent paramVideoEvent, int paramInt);

  public abstract Boolean registerVideoObstruction(View paramView);

  public abstract Boolean startDeferredDisplaySession(Activity paramActivity);

  public static enum VideoEvent
  {
    private String a;
    private String b;

    static
    {
      AD_PAUSED = new VideoEvent("AD_PAUSED", 3, "AD_EVT_PAUSED", "recordAdPausedEvent");
      AD_PLAYING = new VideoEvent("AD_PLAYING", 4, "AD_EVT_PLAYING", "recordAdPlayingEvent");
      AD_SKIPPED = new VideoEvent("AD_SKIPPED", 5, "AD_EVT_SKIPPED", "recordAdSkippedEvent");
      AD_IMPRESSED = new VideoEvent("AD_IMPRESSED", 6, null, "recordAdImpressionEvent");
      AD_CLICK_THRU = new VideoEvent("AD_CLICK_THRU", 7, null, "recordAdClickThruEvent");
      AD_VIDEO_FIRST_QUARTILE = new VideoEvent("AD_VIDEO_FIRST_QUARTILE", 8, "AD_EVT_FIRST_QUARTILE", "recordAdVideoFirstQuartileEvent");
      AD_VIDEO_MIDPOINT = new VideoEvent("AD_VIDEO_MIDPOINT", 9, "AD_EVT_MID_POINT", "recordAdVideoMidpointEvent");
      AD_VIDEO_THIRD_QUARTILE = new VideoEvent("AD_VIDEO_THIRD_QUARTILE", 10, "AD_EVT_THIRD_QUARTILE", "recordAdVideoThirdQuartileEvent");
      AD_COMPLETE = new VideoEvent("AD_COMPLETE", 11, "AD_EVT_COMPLETE", "recordAdCompleteEvent");
      RECORD_AD_ERROR = new VideoEvent("RECORD_AD_ERROR", 12, null, "recordAdError");
      VideoEvent[] arrayOfVideoEvent = new VideoEvent[13];
      arrayOfVideoEvent[0] = AD_LOADED;
      arrayOfVideoEvent[1] = AD_STARTED;
      arrayOfVideoEvent[2] = AD_STOPPED;
      arrayOfVideoEvent[3] = AD_PAUSED;
      arrayOfVideoEvent[4] = AD_PLAYING;
      arrayOfVideoEvent[5] = AD_SKIPPED;
      arrayOfVideoEvent[6] = AD_IMPRESSED;
      arrayOfVideoEvent[7] = AD_CLICK_THRU;
      arrayOfVideoEvent[8] = AD_VIDEO_FIRST_QUARTILE;
      arrayOfVideoEvent[9] = AD_VIDEO_MIDPOINT;
      arrayOfVideoEvent[10] = AD_VIDEO_THIRD_QUARTILE;
      arrayOfVideoEvent[11] = AD_COMPLETE;
      arrayOfVideoEvent[12] = RECORD_AD_ERROR;
    }

    private VideoEvent(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }

    public String getAvidMethodName()
    {
      return this.b;
    }

    public String getMoatEnumName()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.ExternalViewabilitySession
 * JD-Core Version:    0.6.2
 */