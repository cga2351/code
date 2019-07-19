package com.mopub.common.util;

public enum ResponseHeader
{
  private final String a;

  static
  {
    BACKOFF_MS = new ResponseHeader("BACKOFF_MS", 1, "backoff_ms");
    AD_TIMEOUT = new ResponseHeader("AD_TIMEOUT", 2, "x-ad-timeout-ms");
    AD_TYPE = new ResponseHeader("AD_TYPE", 3, "x-adtype");
    IMPRESSION_DATA = new ResponseHeader("IMPRESSION_DATA", 4, "impdata");
    CLICK_TRACKING_URL = new ResponseHeader("CLICK_TRACKING_URL", 5, "x-clickthrough");
    CUSTOM_EVENT_DATA = new ResponseHeader("CUSTOM_EVENT_DATA", 6, "x-custom-event-class-data");
    CUSTOM_EVENT_NAME = new ResponseHeader("CUSTOM_EVENT_NAME", 7, "x-custom-event-class-name");
    CREATIVE_ID = new ResponseHeader("CREATIVE_ID", 8, "x-creativeid");
    DSP_CREATIVE_ID = new ResponseHeader("DSP_CREATIVE_ID", 9, "x-dspcreativeid");
    FAIL_URL = new ResponseHeader("FAIL_URL", 10, "x-next-url");
    FULL_AD_TYPE = new ResponseHeader("FULL_AD_TYPE", 11, "x-fulladtype");
    HEIGHT = new ResponseHeader("HEIGHT", 12, "x-height");
    IMPRESSION_URL = new ResponseHeader("IMPRESSION_URL", 13, "x-imptracker");
    IMPRESSION_URLS = new ResponseHeader("IMPRESSION_URLS", 14, "imptrackers");
    NATIVE_PARAMS = new ResponseHeader("NATIVE_PARAMS", 15, "x-nativeparams");
    NETWORK_TYPE = new ResponseHeader("NETWORK_TYPE", 16, "x-networktype");
    ORIENTATION = new ResponseHeader("ORIENTATION", 17, "x-orientation");
    REFRESH_TIME = new ResponseHeader("REFRESH_TIME", 18, "x-refreshtime");
    WARMUP = new ResponseHeader("WARMUP", 19, "x-warmup");
    WIDTH = new ResponseHeader("WIDTH", 20, "x-width");
    BACKFILL = new ResponseHeader("BACKFILL", 21, "x-backfill");
    REQUEST_ID = new ResponseHeader("REQUEST_ID", 22, "x-request-id");
    CONTENT_TYPE = new ResponseHeader("CONTENT_TYPE", 23, "content-type");
    LOCATION = new ResponseHeader("LOCATION", 24, "location");
    USER_AGENT = new ResponseHeader("USER_AGENT", 25, "user-agent");
    ACCEPT_LANGUAGE = new ResponseHeader("ACCEPT_LANGUAGE", 26, "accept-language");
    BROWSER_AGENT = new ResponseHeader("BROWSER_AGENT", 27, "x-browser-agent");
    BANNER_IMPRESSION_MIN_VISIBLE_DIPS = new ResponseHeader("BANNER_IMPRESSION_MIN_VISIBLE_DIPS", 28, "x-banner-impression-min-pixels");
    BANNER_IMPRESSION_MIN_VISIBLE_MS = new ResponseHeader("BANNER_IMPRESSION_MIN_VISIBLE_MS", 29, "x-banner-impression-min-ms");
    IMPRESSION_MIN_VISIBLE_PERCENT = new ResponseHeader("IMPRESSION_MIN_VISIBLE_PERCENT", 30, "x-impression-min-visible-percent");
    IMPRESSION_VISIBLE_MS = new ResponseHeader("IMPRESSION_VISIBLE_MS", 31, "x-impression-visible-ms");
    IMPRESSION_MIN_VISIBLE_PX = new ResponseHeader("IMPRESSION_MIN_VISIBLE_PX", 32, "x-native-impression-min-px");
    PLAY_VISIBLE_PERCENT = new ResponseHeader("PLAY_VISIBLE_PERCENT", 33, "x-play-visible-percent");
    PAUSE_VISIBLE_PERCENT = new ResponseHeader("PAUSE_VISIBLE_PERCENT", 34, "x-pause-visible-percent");
    MAX_BUFFER_MS = new ResponseHeader("MAX_BUFFER_MS", 35, "x-max-buffer-ms");
    REWARDED_VIDEO_CURRENCY_NAME = new ResponseHeader("REWARDED_VIDEO_CURRENCY_NAME", 36, "x-rewarded-video-currency-name");
    REWARDED_VIDEO_CURRENCY_AMOUNT = new ResponseHeader("REWARDED_VIDEO_CURRENCY_AMOUNT", 37, "x-rewarded-video-currency-amount");
    REWARDED_CURRENCIES = new ResponseHeader("REWARDED_CURRENCIES", 38, "x-rewarded-currencies");
    REWARDED_VIDEO_COMPLETION_URL = new ResponseHeader("REWARDED_VIDEO_COMPLETION_URL", 39, "x-rewarded-video-completion-url");
    REWARDED_DURATION = new ResponseHeader("REWARDED_DURATION", 40, "x-rewarded-duration");
    SHOULD_REWARD_ON_CLICK = new ResponseHeader("SHOULD_REWARD_ON_CLICK", 41, "x-should-reward-on-click");
    VIDEO_TRACKERS = new ResponseHeader("VIDEO_TRACKERS", 42, "x-video-trackers");
    VIDEO_VIEWABILITY_TRACKERS = new ResponseHeader("VIDEO_VIEWABILITY_TRACKERS", 43, "x-video-viewability-trackers");
    DISABLE_VIEWABILITY = new ResponseHeader("DISABLE_VIEWABILITY", 44, "x-disable-viewability");
    AD_RESPONSES = new ResponseHeader("AD_RESPONSES", 45, "ad-responses");
    CONTENT = new ResponseHeader("CONTENT", 46, "content");
    METADATA = new ResponseHeader("METADATA", 47, "metadata");
    BEFORE_LOAD_URL = new ResponseHeader("BEFORE_LOAD_URL", 48, "x-before-load-url");
    AFTER_LOAD_URL = new ResponseHeader("AFTER_LOAD_URL", 49, "x-after-load-url");
    AFTER_LOAD_SUCCESS_URL = new ResponseHeader("AFTER_LOAD_SUCCESS_URL", 50, "x-after-load-success-url");
    AFTER_LOAD_FAIL_URL = new ResponseHeader("AFTER_LOAD_FAIL_URL", 51, "x-after-load-fail-url");
    INVALIDATE_CONSENT = new ResponseHeader("INVALIDATE_CONSENT", 52, "invalidate_consent");
    FORCE_EXPLICIT_NO = new ResponseHeader("FORCE_EXPLICIT_NO", 53, "force_explicit_no");
    REACQUIRE_CONSENT = new ResponseHeader("REACQUIRE_CONSENT", 54, "reacquire_consent");
    CONSENT_CHANGE_REASON = new ResponseHeader("CONSENT_CHANGE_REASON", 55, "consent_change_reason");
    FORCE_GDPR_APPLIES = new ResponseHeader("FORCE_GDPR_APPLIES", 56, "force_gdpr_applies");
    ENABLE_DEBUG_LOGGING = new ResponseHeader("ENABLE_DEBUG_LOGGING", 57, "enable_debug_logging");
    ResponseHeader[] arrayOfResponseHeader = new ResponseHeader[58];
    arrayOfResponseHeader[0] = BACKOFF_REASON;
    arrayOfResponseHeader[1] = BACKOFF_MS;
    arrayOfResponseHeader[2] = AD_TIMEOUT;
    arrayOfResponseHeader[3] = AD_TYPE;
    arrayOfResponseHeader[4] = IMPRESSION_DATA;
    arrayOfResponseHeader[5] = CLICK_TRACKING_URL;
    arrayOfResponseHeader[6] = CUSTOM_EVENT_DATA;
    arrayOfResponseHeader[7] = CUSTOM_EVENT_NAME;
    arrayOfResponseHeader[8] = CREATIVE_ID;
    arrayOfResponseHeader[9] = DSP_CREATIVE_ID;
    arrayOfResponseHeader[10] = FAIL_URL;
    arrayOfResponseHeader[11] = FULL_AD_TYPE;
    arrayOfResponseHeader[12] = HEIGHT;
    arrayOfResponseHeader[13] = IMPRESSION_URL;
    arrayOfResponseHeader[14] = IMPRESSION_URLS;
    arrayOfResponseHeader[15] = NATIVE_PARAMS;
    arrayOfResponseHeader[16] = NETWORK_TYPE;
    arrayOfResponseHeader[17] = ORIENTATION;
    arrayOfResponseHeader[18] = REFRESH_TIME;
    arrayOfResponseHeader[19] = WARMUP;
    arrayOfResponseHeader[20] = WIDTH;
    arrayOfResponseHeader[21] = BACKFILL;
    arrayOfResponseHeader[22] = REQUEST_ID;
    arrayOfResponseHeader[23] = CONTENT_TYPE;
    arrayOfResponseHeader[24] = LOCATION;
    arrayOfResponseHeader[25] = USER_AGENT;
    arrayOfResponseHeader[26] = ACCEPT_LANGUAGE;
    arrayOfResponseHeader[27] = BROWSER_AGENT;
    arrayOfResponseHeader[28] = BANNER_IMPRESSION_MIN_VISIBLE_DIPS;
    arrayOfResponseHeader[29] = BANNER_IMPRESSION_MIN_VISIBLE_MS;
    arrayOfResponseHeader[30] = IMPRESSION_MIN_VISIBLE_PERCENT;
    arrayOfResponseHeader[31] = IMPRESSION_VISIBLE_MS;
    arrayOfResponseHeader[32] = IMPRESSION_MIN_VISIBLE_PX;
    arrayOfResponseHeader[33] = PLAY_VISIBLE_PERCENT;
    arrayOfResponseHeader[34] = PAUSE_VISIBLE_PERCENT;
    arrayOfResponseHeader[35] = MAX_BUFFER_MS;
    arrayOfResponseHeader[36] = REWARDED_VIDEO_CURRENCY_NAME;
    arrayOfResponseHeader[37] = REWARDED_VIDEO_CURRENCY_AMOUNT;
    arrayOfResponseHeader[38] = REWARDED_CURRENCIES;
    arrayOfResponseHeader[39] = REWARDED_VIDEO_COMPLETION_URL;
    arrayOfResponseHeader[40] = REWARDED_DURATION;
    arrayOfResponseHeader[41] = SHOULD_REWARD_ON_CLICK;
    arrayOfResponseHeader[42] = VIDEO_TRACKERS;
    arrayOfResponseHeader[43] = VIDEO_VIEWABILITY_TRACKERS;
    arrayOfResponseHeader[44] = DISABLE_VIEWABILITY;
    arrayOfResponseHeader[45] = AD_RESPONSES;
    arrayOfResponseHeader[46] = CONTENT;
    arrayOfResponseHeader[47] = METADATA;
    arrayOfResponseHeader[48] = BEFORE_LOAD_URL;
    arrayOfResponseHeader[49] = AFTER_LOAD_URL;
    arrayOfResponseHeader[50] = AFTER_LOAD_SUCCESS_URL;
    arrayOfResponseHeader[51] = AFTER_LOAD_FAIL_URL;
    arrayOfResponseHeader[52] = INVALIDATE_CONSENT;
    arrayOfResponseHeader[53] = FORCE_EXPLICIT_NO;
    arrayOfResponseHeader[54] = REACQUIRE_CONSENT;
    arrayOfResponseHeader[55] = CONSENT_CHANGE_REASON;
    arrayOfResponseHeader[56] = FORCE_GDPR_APPLIES;
    arrayOfResponseHeader[57] = ENABLE_DEBUG_LOGGING;
  }

  private ResponseHeader(String paramString)
  {
    this.a = paramString;
  }

  public String getKey()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.ResponseHeader
 * JD-Core Version:    0.6.2
 */