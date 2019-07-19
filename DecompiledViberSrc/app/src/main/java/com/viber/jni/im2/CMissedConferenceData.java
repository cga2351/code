package com.viber.jni.im2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CMissedConferenceData
{
  public final String confID;
  public final int duration;
  public final String[] memberIDs;
  public final int state;

  public CMissedConferenceData(int paramInt1, String[] paramArrayOfString, String paramString, int paramInt2)
  {
    this.state = paramInt1;
    this.memberIDs = ((String[])Im2Utils.checkArrayValue(paramArrayOfString, [Ljava.lang.String.class));
    this.confID = Im2Utils.checkStringValue(paramString);
    this.duration = paramInt2;
    init();
  }

  private void init()
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface EState
  {
    public static final int CONFERENCE_ANSWERED_ON_ANOTHER_DEVICE = 3;
    public static final int CONFERENCE_ENDED = 1;
    public static final int CONFERENCE_IN_PROGRESS = 0;
    public static final int CONFERENCE_MISSED = 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CMissedConferenceData
 * JD-Core Version:    0.6.2
 */