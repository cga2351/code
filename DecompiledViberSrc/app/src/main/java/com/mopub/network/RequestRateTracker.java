package com.mopub.network;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RequestRateTracker
{
  private Map<String, TimeRecord> a = Collections.synchronizedMap(new HashMap());

  private static long b()
  {
    return SystemClock.elapsedRealtime();
  }

  private long b(String paramString)
  {
    TimeRecord localTimeRecord = (TimeRecord)this.a.get(paramString);
    if (localTimeRecord == null)
      return 0L;
    return localTimeRecord.a() - b();
  }

  public static RequestRateTracker getInstance()
  {
    return a.a();
  }

  void a(String paramString1, Integer paramInteger, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return;
    if ((paramInteger != null) && (paramInteger.intValue() > 0))
    {
      this.a.put(paramString1, new TimeRecord(paramInteger.intValue(), paramString2));
      return;
    }
    this.a.remove(paramString1);
  }

  boolean a(String paramString)
  {
    return b(paramString) > 0L;
  }

  public TimeRecord getRecordForAdUnit(String paramString)
  {
    return (TimeRecord)this.a.get(paramString);
  }

  public static class TimeRecord
  {
    final long a = RequestRateTracker.a();
    public final int mBlockIntervalMs;
    public final String mReason;

    TimeRecord(int paramInt, String paramString)
    {
      this.mBlockIntervalMs = paramInt;
      if (paramString == null)
        paramString = "unknown";
      this.mReason = paramString;
    }

    long a()
    {
      return this.a + this.mBlockIntervalMs;
    }
  }

  private static class a
  {
    private static RequestRateTracker a = new RequestRateTracker();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.RequestRateTracker
 * JD-Core Version:    0.6.2
 */