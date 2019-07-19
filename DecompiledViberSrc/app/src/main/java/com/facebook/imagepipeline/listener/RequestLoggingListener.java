package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class RequestLoggingListener
  implements RequestListener
{
  private static final String TAG = "RequestLoggingListener";

  @GuardedBy("this")
  private final Map<Pair<String, String>, Long> mProducerStartTimeMap = new HashMap();

  @GuardedBy("this")
  private final Map<String, Long> mRequestStartTimeMap = new HashMap();

  private static long getElapsedTime(@Nullable Long paramLong, long paramLong1)
  {
    if (paramLong != null)
      return paramLong1 - paramLong.longValue();
    return -1L;
  }

  private static long getTime()
  {
    return SystemClock.uptimeMillis();
  }

  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Pair localPair = Pair.create(paramString1, paramString2);
        Long localLong = (Long)this.mProducerStartTimeMap.get(localPair);
        long l = getTime();
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = Long.valueOf(getTime());
        arrayOfObject[1] = paramString1;
        arrayOfObject[2] = paramString2;
        arrayOfObject[3] = paramString3;
        arrayOfObject[4] = Long.valueOf(getElapsedTime(localLong, l));
        FLog.v("RequestLoggingListener", "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", arrayOfObject);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onProducerFinishWithCancellation(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Pair localPair = Pair.create(paramString1, paramString2);
        Long localLong = (Long)this.mProducerStartTimeMap.remove(localPair);
        long l = getTime();
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = Long.valueOf(l);
        arrayOfObject[1] = paramString1;
        arrayOfObject[2] = paramString2;
        arrayOfObject[3] = Long.valueOf(getElapsedTime(localLong, l));
        arrayOfObject[4] = paramMap;
        FLog.v("RequestLoggingListener", "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", arrayOfObject);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, @Nullable Map<String, String> paramMap)
  {
    try
    {
      if (FLog.isLoggable(5))
      {
        Pair localPair = Pair.create(paramString1, paramString2);
        Long localLong = (Long)this.mProducerStartTimeMap.remove(localPair);
        long l = getTime();
        Object[] arrayOfObject = new Object[6];
        arrayOfObject[0] = Long.valueOf(l);
        arrayOfObject[1] = paramString1;
        arrayOfObject[2] = paramString2;
        arrayOfObject[3] = Long.valueOf(getElapsedTime(localLong, l));
        arrayOfObject[4] = paramMap;
        arrayOfObject[5] = paramThrowable.toString();
        FLog.w("RequestLoggingListener", paramThrowable, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", arrayOfObject);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onProducerFinishWithSuccess(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Pair localPair = Pair.create(paramString1, paramString2);
        Long localLong = (Long)this.mProducerStartTimeMap.remove(localPair);
        long l = getTime();
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = Long.valueOf(l);
        arrayOfObject[1] = paramString1;
        arrayOfObject[2] = paramString2;
        arrayOfObject[3] = Long.valueOf(getElapsedTime(localLong, l));
        arrayOfObject[4] = paramMap;
        FLog.v("RequestLoggingListener", "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", arrayOfObject);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onProducerStart(String paramString1, String paramString2)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Pair localPair = Pair.create(paramString1, paramString2);
        long l = getTime();
        this.mProducerStartTimeMap.put(localPair, Long.valueOf(l));
        FLog.v("RequestLoggingListener", "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(l), paramString1, paramString2);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onRequestCancellation(String paramString)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Long localLong = (Long)this.mRequestStartTimeMap.remove(paramString);
        long l = getTime();
        FLog.v("RequestLoggingListener", "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(l), paramString, Long.valueOf(getElapsedTime(localLong, l)));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    try
    {
      if (FLog.isLoggable(5))
      {
        Long localLong = (Long)this.mRequestStartTimeMap.remove(paramString);
        long l = getTime();
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = Long.valueOf(l);
        arrayOfObject[1] = paramString;
        arrayOfObject[2] = Long.valueOf(getElapsedTime(localLong, l));
        arrayOfObject[3] = paramThrowable.toString();
        FLog.w("RequestLoggingListener", "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", arrayOfObject);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        FLog.v("RequestLoggingListener", "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(getTime()), paramString, paramObject, Boolean.valueOf(paramBoolean));
        this.mRequestStartTimeMap.put(paramString, Long.valueOf(getTime()));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Long localLong = (Long)this.mRequestStartTimeMap.remove(paramString);
        long l = getTime();
        FLog.v("RequestLoggingListener", "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(l), paramString, Long.valueOf(getElapsedTime(localLong, l)));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      if (FLog.isLoggable(2))
      {
        Pair localPair = Pair.create(paramString1, paramString2);
        Long localLong = (Long)this.mProducerStartTimeMap.remove(localPair);
        long l = getTime();
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = Long.valueOf(l);
        arrayOfObject[1] = paramString1;
        arrayOfObject[2] = paramString2;
        arrayOfObject[3] = Long.valueOf(getElapsedTime(localLong, l));
        arrayOfObject[4] = Boolean.valueOf(paramBoolean);
        FLog.v("RequestLoggingListener", "time %d: onUltimateProducerReached: {requestId: %s, producer: %s, elapsedTime: %d ms, success: %b}", arrayOfObject);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean requiresExtraMap(String paramString)
  {
    return FLog.isLoggable(2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.listener.RequestLoggingListener
 * JD-Core Version:    0.6.2
 */