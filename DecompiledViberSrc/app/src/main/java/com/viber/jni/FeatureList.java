package com.viber.jni;

import java.util.HashSet;

public class FeatureList
{
  public static final String CLIENT_FEATURE_AD_INFO_SUPPORT = "AD";
  public static final String CLIENT_FEATURE_CONFERENCE_CALLS = "CC";
  public static final String CLIENT_FEATURE_DATA_INDICATOR = "DI";
  public static final String CLIENT_FEATURE_DISPLAY_INVITATION_LINK_ALL = "DA";
  public static final String CLIENT_FEATURE_G2_MUTE = "MC";
  public static final String CLIENT_FEATURE_M2M = "M2";
  public static final String CLIENT_FEATURE_ORIGINAL_NUMBERS_IN_AB_REPLY = "ON";
  public static final String CLIENT_FEATURE_PAPI_VER_7 = "P7";
  public static final String CLIENT_FEATURE_PAPI_VER_8 = "P8";
  public static final String CLIENT_FEATURE_PAPI_VER_9 = "P9";
  public static final String CLIENT_FEATURE_PG_INFO_CHUNKED = "LG";
  public static final String CLIENT_FEATURE_REPORT_COMMUNITIES = "RC";
  public static final String CLIENT_FEATURE_VIBER_LOCAL_NUMBER_CALL = "LN";
  public static final String CLIENT_FEATURE_VIBER_LOCAL_NUMBER_SMS = "LS";
  public static final String CLIENT_FEATURE_WEBRTC = "WR";
  private HashSet<String> mFeatureSet = new HashSet();

  public FeatureList addFeature(String paramString)
  {
    this.mFeatureSet.add(paramString);
    return this;
  }

  public String[] toArray()
  {
    return (String[])this.mFeatureSet.toArray(new String[this.mFeatureSet.size()]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.FeatureList
 * JD-Core Version:    0.6.2
 */