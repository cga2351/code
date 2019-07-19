package com.appnexus.opensdk;

public enum MediaType
{
  static
  {
    INSTREAM_VIDEO = new MediaType("INSTREAM_VIDEO", 3);
    MediaType[] arrayOfMediaType = new MediaType[4];
    arrayOfMediaType[0] = BANNER;
    arrayOfMediaType[1] = INTERSTITIAL;
    arrayOfMediaType[2] = NATIVE;
    arrayOfMediaType[3] = INSTREAM_VIDEO;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.MediaType
 * JD-Core Version:    0.6.2
 */