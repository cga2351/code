package com.viber.jni.ptt;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class VideoPttControllerDelegate
{
  public static abstract interface VideoPlayer
  {
    public abstract void onVideoPttPlayError(int paramInt1, int paramInt2);

    public abstract void onVideoPttPlayRestarted(int paramInt);

    public abstract void onVideoPttPlayStarted(int paramInt);

    public abstract void onVideoPttPlayStopped(int paramInt);

    public abstract void onVideoPttPlayStopping(int paramInt);
  }

  public static abstract interface VideoPttDelegate extends VideoPttControllerDelegate.VideoPlayer, VideoPttControllerDelegate.VideoRecorder
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface VideoPttPlayReason
  {
    public static final int INCORRECT_RTP_DUMP = 1;
    public static final int INTERNAL_ERROR = 0;
    public static final int MEDIA_SESSION_IS_BUSY = 2;
    public static final int UNKNOWN_ERROR = 3;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface VideoPttRecordReason
  {
    public static final int ERROR_ON_FILE_OPEN = 1;
    public static final int INTERNAL_ERROR = 2;
    public static final int PREVIEW_SAVE_ERROR = 4;
    public static final int STOP_WITH_ERROR_OMITTED = 5;
    public static final int UNKNOWN_ERROR = 32000;
    public static final int VIDEO_IS_DISABLED = 0;
    public static final int WRONG_API_USAGE = 3;
  }

  public static abstract interface VideoRecorder
  {
    public abstract void onVideoPttRecordError(int paramInt);

    public abstract void onVideoPttRecordInited();

    public abstract void onVideoPttRecordStarted();

    public abstract void onVideoPttRecordStopped(String paramString, boolean paramBoolean, byte[] paramArrayOfByte);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ptt.VideoPttControllerDelegate
 * JD-Core Version:    0.6.2
 */