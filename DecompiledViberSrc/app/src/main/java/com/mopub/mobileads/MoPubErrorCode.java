package com.mopub.mobileads;

public enum MoPubErrorCode
  implements MoPubError
{
  private final String a;

  static
  {
    NO_FILL = new MoPubErrorCode("NO_FILL", 3, "No ads found.");
    WARMUP = new MoPubErrorCode("WARMUP", 4, "Ad unit is warming up. Try again in a few minutes.");
    SERVER_ERROR = new MoPubErrorCode("SERVER_ERROR", 5, "Unable to connect to MoPub adserver.");
    INTERNAL_ERROR = new MoPubErrorCode("INTERNAL_ERROR", 6, "Unable to serve ad due to invalid internal state.");
    RENDER_PROCESS_GONE_WITH_CRASH = new MoPubErrorCode("RENDER_PROCESS_GONE_WITH_CRASH", 7, "Render process for this WebView has crashed.");
    RENDER_PROCESS_GONE_UNSPECIFIED = new MoPubErrorCode("RENDER_PROCESS_GONE_UNSPECIFIED", 8, "Render process is gone for this WebView. Unspecified cause.");
    CANCELLED = new MoPubErrorCode("CANCELLED", 9, "Ad request was cancelled.");
    MISSING_AD_UNIT_ID = new MoPubErrorCode("MISSING_AD_UNIT_ID", 10, "Unable to serve ad due to missing or empty ad unit ID.");
    NO_CONNECTION = new MoPubErrorCode("NO_CONNECTION", 11, "No internet connection detected.");
    ADAPTER_NOT_FOUND = new MoPubErrorCode("ADAPTER_NOT_FOUND", 12, "Unable to find Native Network or Custom Event adapter.");
    ADAPTER_CONFIGURATION_ERROR = new MoPubErrorCode("ADAPTER_CONFIGURATION_ERROR", 13, "Native Network or Custom Event adapter was configured incorrectly.");
    ADAPTER_INITIALIZATION_SUCCESS = new MoPubErrorCode("ADAPTER_INITIALIZATION_SUCCESS", 14, "AdapterConfiguration initialization success.");
    EXPIRED = new MoPubErrorCode("EXPIRED", 15, "Ad expired since it was not shown within 4 hours.");
    NETWORK_TIMEOUT = new MoPubErrorCode("NETWORK_TIMEOUT", 16, "Third-party network failed to respond in a timely manner.");
    NETWORK_NO_FILL = new MoPubErrorCode("NETWORK_NO_FILL", 17, "Third-party network failed to provide an ad.");
    NETWORK_INVALID_STATE = new MoPubErrorCode("NETWORK_INVALID_STATE", 18, "Third-party network failed due to invalid internal state.");
    MRAID_LOAD_ERROR = new MoPubErrorCode("MRAID_LOAD_ERROR", 19, "Error loading MRAID ad.");
    VIDEO_CACHE_ERROR = new MoPubErrorCode("VIDEO_CACHE_ERROR", 20, "Error creating a cache to store downloaded videos.");
    VIDEO_DOWNLOAD_ERROR = new MoPubErrorCode("VIDEO_DOWNLOAD_ERROR", 21, "Error downloading video.");
    GDPR_DOES_NOT_APPLY = new MoPubErrorCode("GDPR_DOES_NOT_APPLY", 22, "GDPR does not apply. Ignoring consent-related actions.");
    REWARDED_CURRENCIES_PARSING_ERROR = new MoPubErrorCode("REWARDED_CURRENCIES_PARSING_ERROR", 23, "Error parsing rewarded currencies JSON header.");
    REWARD_NOT_SELECTED = new MoPubErrorCode("REWARD_NOT_SELECTED", 24, "Reward not selected for rewarded ad.");
    VIDEO_NOT_AVAILABLE = new MoPubErrorCode("VIDEO_NOT_AVAILABLE", 25, "No video loaded for ad unit.");
    VIDEO_PLAYBACK_ERROR = new MoPubErrorCode("VIDEO_PLAYBACK_ERROR", 26, "Error playing a video.");
    MoPubErrorCode[] arrayOfMoPubErrorCode = new MoPubErrorCode[27];
    arrayOfMoPubErrorCode[0] = AD_SUCCESS;
    arrayOfMoPubErrorCode[1] = DO_NOT_TRACK;
    arrayOfMoPubErrorCode[2] = UNSPECIFIED;
    arrayOfMoPubErrorCode[3] = NO_FILL;
    arrayOfMoPubErrorCode[4] = WARMUP;
    arrayOfMoPubErrorCode[5] = SERVER_ERROR;
    arrayOfMoPubErrorCode[6] = INTERNAL_ERROR;
    arrayOfMoPubErrorCode[7] = RENDER_PROCESS_GONE_WITH_CRASH;
    arrayOfMoPubErrorCode[8] = RENDER_PROCESS_GONE_UNSPECIFIED;
    arrayOfMoPubErrorCode[9] = CANCELLED;
    arrayOfMoPubErrorCode[10] = MISSING_AD_UNIT_ID;
    arrayOfMoPubErrorCode[11] = NO_CONNECTION;
    arrayOfMoPubErrorCode[12] = ADAPTER_NOT_FOUND;
    arrayOfMoPubErrorCode[13] = ADAPTER_CONFIGURATION_ERROR;
    arrayOfMoPubErrorCode[14] = ADAPTER_INITIALIZATION_SUCCESS;
    arrayOfMoPubErrorCode[15] = EXPIRED;
    arrayOfMoPubErrorCode[16] = NETWORK_TIMEOUT;
    arrayOfMoPubErrorCode[17] = NETWORK_NO_FILL;
    arrayOfMoPubErrorCode[18] = NETWORK_INVALID_STATE;
    arrayOfMoPubErrorCode[19] = MRAID_LOAD_ERROR;
    arrayOfMoPubErrorCode[20] = VIDEO_CACHE_ERROR;
    arrayOfMoPubErrorCode[21] = VIDEO_DOWNLOAD_ERROR;
    arrayOfMoPubErrorCode[22] = GDPR_DOES_NOT_APPLY;
    arrayOfMoPubErrorCode[23] = REWARDED_CURRENCIES_PARSING_ERROR;
    arrayOfMoPubErrorCode[24] = REWARD_NOT_SELECTED;
    arrayOfMoPubErrorCode[25] = VIDEO_NOT_AVAILABLE;
    arrayOfMoPubErrorCode[26] = VIDEO_PLAYBACK_ERROR;
  }

  private MoPubErrorCode(String paramString)
  {
    this.a = paramString;
  }

  public int getIntCode()
  {
    switch (1.a[ordinal()])
    {
    default:
      return 10000;
    case 1:
      return 2;
    case 2:
      return 1;
    case 3:
    }
    return 0;
  }

  public String toString()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.MoPubErrorCode
 * JD-Core Version:    0.6.2
 */