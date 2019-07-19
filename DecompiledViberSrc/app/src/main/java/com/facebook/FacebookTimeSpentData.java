package com.facebook;

import android.os.Bundle;
import com.facebook.internal.Logger;
import java.io.Serializable;

class FacebookTimeSpentData
  implements Serializable
{
  private static final long APP_ACTIVATE_SUPPRESSION_PERIOD_IN_MILLISECONDS = 300000L;
  private static final long FIRST_TIME_LOAD_RESUME_TIME = -1L;
  private static final long[] INACTIVE_SECONDS_QUANTA = { 300000L, 900000L, 1800000L, 3600000L, 21600000L, 43200000L, 86400000L, 172800000L, 259200000L, 604800000L, 1209600000L, 1814400000L, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L };
  private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
  private static final long NUM_MILLISECONDS_IDLE_TO_BE_NEW_SESSION = 60000L;
  private static final String TAG = AppEventsLogger.class.getCanonicalName();
  private static final long serialVersionUID = 1L;
  private String firstOpenSourceApplication;
  private int interruptionCount;
  private boolean isAppActive;
  private boolean isWarmLaunch;
  private long lastActivateEventLoggedTime;
  private long lastResumeTime;
  private long lastSuspendTime;
  private long millisecondsSpentInSession;

  FacebookTimeSpentData()
  {
    resetSession();
  }

  private FacebookTimeSpentData(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    resetSession();
    this.lastResumeTime = paramLong1;
    this.lastSuspendTime = paramLong2;
    this.millisecondsSpentInSession = paramLong3;
    this.interruptionCount = paramInt;
  }

  private FacebookTimeSpentData(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
  {
    resetSession();
    this.lastResumeTime = paramLong1;
    this.lastSuspendTime = paramLong2;
    this.millisecondsSpentInSession = paramLong3;
    this.interruptionCount = paramInt;
    this.firstOpenSourceApplication = paramString;
  }

  private static int getQuantaIndex(long paramLong)
  {
    for (int i = 0; (i < INACTIVE_SECONDS_QUANTA.length) && (INACTIVE_SECONDS_QUANTA[i] < paramLong); i++);
    return i;
  }

  private boolean isColdLaunch()
  {
    if (!this.isWarmLaunch);
    for (boolean bool = true; ; bool = false)
    {
      this.isWarmLaunch = true;
      return bool;
    }
  }

  private void logAppDeactivatedEvent(AppEventsLogger paramAppEventsLogger, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fb_mobile_app_interruptions", this.interruptionCount);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(getQuantaIndex(paramLong));
    localBundle.putString("fb_mobile_time_between_sessions", String.format("session_quanta_%d", arrayOfObject));
    localBundle.putString("fb_mobile_launch_source", this.firstOpenSourceApplication);
    paramAppEventsLogger.logEvent("fb_mobile_deactivate_app", this.millisecondsSpentInSession / 1000L, localBundle);
    resetSession();
  }

  private void resetSession()
  {
    this.isAppActive = false;
    this.lastResumeTime = -1L;
    this.lastSuspendTime = -1L;
    this.interruptionCount = 0;
    this.millisecondsSpentInSession = 0L;
  }

  private boolean wasSuspendedEver()
  {
    return this.lastSuspendTime != -1L;
  }

  private Object writeReplace()
  {
    return new SerializationProxyV2(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
  }

  void onResume(AppEventsLogger paramAppEventsLogger, long paramLong, String paramString)
  {
    long l1 = 0L;
    if ((isColdLaunch()) || (paramLong - this.lastActivateEventLoggedTime > 300000L))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("fb_mobile_launch_source", paramString);
      paramAppEventsLogger.logEvent("fb_mobile_activate_app", localBundle);
      this.lastActivateEventLoggedTime = paramLong;
    }
    if (this.isAppActive)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Resume for active app");
      return;
    }
    long l2;
    if (wasSuspendedEver())
    {
      l2 = paramLong - this.lastSuspendTime;
      if (l2 >= l1)
        break label176;
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    }
    while (true)
    {
      if (l1 > 60000L)
        logAppDeactivatedEvent(paramAppEventsLogger, l1);
      while (true)
      {
        if (this.interruptionCount == 0)
          this.firstOpenSourceApplication = paramString;
        this.lastResumeTime = paramLong;
        this.isAppActive = true;
        return;
        l2 = l1;
        break;
        if (l1 > 1000L)
          this.interruptionCount = (1 + this.interruptionCount);
      }
      label176: l1 = l2;
    }
  }

  void onSuspend(AppEventsLogger paramAppEventsLogger, long paramLong)
  {
    long l1 = 0L;
    if (!this.isAppActive)
    {
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Suspend for inactive app");
      return;
    }
    long l2 = paramLong - this.lastResumeTime;
    if (l2 < l1)
      Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Clock skew detected");
    while (true)
    {
      this.millisecondsSpentInSession = (l1 + this.millisecondsSpentInSession);
      this.lastSuspendTime = paramLong;
      this.isAppActive = false;
      return;
      l1 = l2;
    }
  }

  private static class SerializationProxyV1
    implements Serializable
  {
    private static final long serialVersionUID = 6L;
    private final int interruptionCount;
    private final long lastResumeTime;
    private final long lastSuspendTime;
    private final long millisecondsSpentInSession;

    SerializationProxyV1(long paramLong1, long paramLong2, long paramLong3, int paramInt)
    {
      this.lastResumeTime = paramLong1;
      this.lastSuspendTime = paramLong2;
      this.millisecondsSpentInSession = paramLong3;
      this.interruptionCount = paramInt;
    }

    private Object readResolve()
    {
      return new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, null);
    }
  }

  private static class SerializationProxyV2
    implements Serializable
  {
    private static final long serialVersionUID = 6L;
    private final String firstOpenSourceApplication;
    private final int interruptionCount;
    private final long lastResumeTime;
    private final long lastSuspendTime;
    private final long millisecondsSpentInSession;

    SerializationProxyV2(long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString)
    {
      this.lastResumeTime = paramLong1;
      this.lastSuspendTime = paramLong2;
      this.millisecondsSpentInSession = paramLong3;
      this.interruptionCount = paramInt;
      this.firstOpenSourceApplication = paramString;
    }

    private Object readResolve()
    {
      return new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.FacebookTimeSpentData
 * JD-Core Version:    0.6.2
 */