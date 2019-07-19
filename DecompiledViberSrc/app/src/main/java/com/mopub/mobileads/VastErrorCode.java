package com.mopub.mobileads;

import com.mopub.common.Preconditions;

public enum VastErrorCode
{
  private final String a;

  static
  {
    WRAPPER_TIMEOUT = new VastErrorCode("WRAPPER_TIMEOUT", 1, "301");
    NO_ADS_VAST_RESPONSE = new VastErrorCode("NO_ADS_VAST_RESPONSE", 2, "303");
    GENERAL_LINEAR_AD_ERROR = new VastErrorCode("GENERAL_LINEAR_AD_ERROR", 3, "400");
    GENERAL_COMPANION_AD_ERROR = new VastErrorCode("GENERAL_COMPANION_AD_ERROR", 4, "600");
    UNDEFINED_ERROR = new VastErrorCode("UNDEFINED_ERROR", 5, "900");
    VastErrorCode[] arrayOfVastErrorCode = new VastErrorCode[6];
    arrayOfVastErrorCode[0] = XML_PARSING_ERROR;
    arrayOfVastErrorCode[1] = WRAPPER_TIMEOUT;
    arrayOfVastErrorCode[2] = NO_ADS_VAST_RESPONSE;
    arrayOfVastErrorCode[3] = GENERAL_LINEAR_AD_ERROR;
    arrayOfVastErrorCode[4] = GENERAL_COMPANION_AD_ERROR;
    arrayOfVastErrorCode[5] = UNDEFINED_ERROR;
  }

  private VastErrorCode(String paramString)
  {
    Preconditions.checkNotNull(paramString, "errorCode cannot be null");
    this.a = paramString;
  }

  String a()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastErrorCode
 * JD-Core Version:    0.6.2
 */