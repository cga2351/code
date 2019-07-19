package com.mopub.mobileads;

import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.common.util.ResponseHeader;
import com.mopub.network.HeaderUtils;
import org.json.JSONObject;

public class AdTypeTranslator
{
  public static final String BANNER_SUFFIX = "_banner";
  public static final String INTERSTITIAL_SUFFIX = "_interstitial";

  public static String getCustomEventName(AdFormat paramAdFormat, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    Preconditions.checkNotNull(paramAdFormat);
    Preconditions.checkNotNull(paramString1);
    String str = paramString1.toLowerCase();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -1349088399:
    case 3271912:
    case 797120100:
    case -1364000502:
    case 474479519:
    case 3213227:
    case 104156535:
    case 604727084:
    }
    while (true)
      switch (i)
      {
      default:
        return CustomEventType.a(paramString1 + "_banner").toString();
        if (str.equals("custom"))
        {
          i = 0;
          continue;
          if (str.equals("json"))
          {
            i = 1;
            continue;
            if (str.equals("json_video"))
            {
              i = 2;
              continue;
              if (str.equals("rewarded_video"))
              {
                i = 3;
                continue;
                if (str.equals("rewarded_playable"))
                {
                  i = 4;
                  continue;
                  if (str.equals("html"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("mraid"))
                    {
                      i = 6;
                      continue;
                      if (str.equals("interstitial"))
                        i = 7;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    return HeaderUtils.extractHeader(paramJSONObject, ResponseHeader.CUSTOM_EVENT_NAME);
    return CustomEventType.MOPUB_NATIVE.toString();
    return CustomEventType.MOPUB_VIDEO_NATIVE.toString();
    return CustomEventType.MOPUB_REWARDED_VIDEO.toString();
    return CustomEventType.MOPUB_REWARDED_PLAYABLE.toString();
    if (AdFormat.INTERSTITIAL.equals(paramAdFormat));
    for (CustomEventType localCustomEventType = CustomEventType.a(paramString1 + "_interstitial"); ; localCustomEventType = CustomEventType.a(paramString1 + "_banner"))
      return localCustomEventType.toString();
    return CustomEventType.a(paramString2 + "_interstitial").toString();
  }

  public static enum CustomEventType
  {
    private final String a;
    private final String b;
    private final boolean c;

    static
    {
      HTML_BANNER = new CustomEventType("HTML_BANNER", 6, "html_banner", "com.mopub.mobileads.HtmlBanner", true);
      HTML_INTERSTITIAL = new CustomEventType("HTML_INTERSTITIAL", 7, "html_interstitial", "com.mopub.mobileads.HtmlInterstitial", true);
      VAST_VIDEO_INTERSTITIAL = new CustomEventType("VAST_VIDEO_INTERSTITIAL", 8, "vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial", true);
      MOPUB_NATIVE = new CustomEventType("MOPUB_NATIVE", 9, "mopub_native", "com.mopub.nativeads.MoPubCustomEventNative", true);
      MOPUB_VIDEO_NATIVE = new CustomEventType("MOPUB_VIDEO_NATIVE", 10, "mopub_video_native", "com.mopub.nativeads.MoPubCustomEventVideoNative", true);
      MOPUB_REWARDED_VIDEO = new CustomEventType("MOPUB_REWARDED_VIDEO", 11, "rewarded_video", "com.mopub.mobileads.MoPubRewardedVideo", true);
      MOPUB_REWARDED_PLAYABLE = new CustomEventType("MOPUB_REWARDED_PLAYABLE", 12, "rewarded_playable", "com.mopub.mobileads.MoPubRewardedPlayable", true);
      UNSPECIFIED = new CustomEventType("UNSPECIFIED", 13, "", null, false);
      CustomEventType[] arrayOfCustomEventType = new CustomEventType[14];
      arrayOfCustomEventType[0] = GOOGLE_PLAY_SERVICES_BANNER;
      arrayOfCustomEventType[1] = GOOGLE_PLAY_SERVICES_INTERSTITIAL;
      arrayOfCustomEventType[2] = MILLENNIAL_BANNER;
      arrayOfCustomEventType[3] = MILLENNIAL_INTERSTITIAL;
      arrayOfCustomEventType[4] = MRAID_BANNER;
      arrayOfCustomEventType[5] = MRAID_INTERSTITIAL;
      arrayOfCustomEventType[6] = HTML_BANNER;
      arrayOfCustomEventType[7] = HTML_INTERSTITIAL;
      arrayOfCustomEventType[8] = VAST_VIDEO_INTERSTITIAL;
      arrayOfCustomEventType[9] = MOPUB_NATIVE;
      arrayOfCustomEventType[10] = MOPUB_VIDEO_NATIVE;
      arrayOfCustomEventType[11] = MOPUB_REWARDED_VIDEO;
      arrayOfCustomEventType[12] = MOPUB_REWARDED_PLAYABLE;
      arrayOfCustomEventType[13] = UNSPECIFIED;
    }

    private CustomEventType(String paramString1, String paramString2, boolean paramBoolean)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramBoolean;
    }

    private static CustomEventType b(String paramString)
    {
      for (CustomEventType localCustomEventType : values())
        if (localCustomEventType.a.equals(paramString))
          return localCustomEventType;
      return UNSPECIFIED;
    }

    private static CustomEventType c(String paramString)
    {
      for (CustomEventType localCustomEventType : values())
        if ((localCustomEventType.b != null) && (localCustomEventType.b.equals(paramString)))
          return localCustomEventType;
      return UNSPECIFIED;
    }

    public static boolean isMoPubSpecific(String paramString)
    {
      return c(paramString).c;
    }

    public String toString()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.AdTypeTranslator
 * JD-Core Version:    0.6.2
 */