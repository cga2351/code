package com.viber.jni.ptt;

public abstract interface VideoPttController
{
  public static final String KEY_PREVIEW_DATA = "PreviewData";
  public static final String KEY_PREVIEW_ERROR = "Error";
  public static final String KEY_PREVIEW_HEIGHT = "Height";
  public static final String KEY_PREVIEW_WIDTH = "Width";

  public abstract void handleInitVideoPttRecord();

  public abstract void handleStartVideoPttRecord(Object paramObject, String paramString);

  public abstract void handleStopVideoPttRecord();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ptt.VideoPttController
 * JD-Core Version:    0.6.2
 */