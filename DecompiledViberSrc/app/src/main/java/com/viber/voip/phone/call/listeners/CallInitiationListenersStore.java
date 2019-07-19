package com.viber.voip.phone.call.listeners;

import com.viber.voip.util.bo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CallInitiationListenersStore extends bo<Listener, Params>
{
  public static final long UNKNOWN_CALL_INITIATION_ID = -1L;

  public CallInitiationListenersStore()
  {
    super(CallInitiationListenersStore..Lambda.0.$instance);
  }

  public void notifyListeners(int paramInt, long paramLong)
  {
    notifyListeners(new Params(paramInt, paramLong));
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface CallInitiationResult
  {
    public static final int FAILED_BLOCKED = 6;
    public static final int FAILED_EMERGENCY_CALL = 3;
    public static final int FAILED_INVALID = 4;
    public static final int FAILED_LOCAL_VIDEO_UNAVAILABLE = 8;
    public static final int FAILED_NOT_ON_VIBER = 5;
    public static final int FAILED_NO_INTERNET = 1;
    public static final int FAILED_NO_SERVICE = 2;
    public static final int FAILED_NO_VIBER_DATA = 7;
    public static final int FAILED_UNALLOWED = 0;
    public static final int OK_VIBER_CALL = 9;
    public static final int OK_VIBER_OUT_CALL = 11;
    public static final int OK_VIDEO_CALL = 10;
  }

  public static abstract interface Listener
  {
    public abstract void onInitiationResult(int paramInt, long paramLong);
  }

  public static class Params
  {
    public final long callInitiationId;
    public final int callInitiationResult;

    public Params(int paramInt, long paramLong)
    {
      this.callInitiationResult = paramInt;
      this.callInitiationId = paramLong;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.listeners.CallInitiationListenersStore
 * JD-Core Version:    0.6.2
 */