package com.viber.voip.news;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ObjectsCompat;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dz;
import com.viber.voip.util.i.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NewsSession
  implements Parcelable
{
  public static final Parcelable.Creator<NewsSession> CREATOR = new Parcelable.Creator()
  {
    public NewsSession a(Parcel paramAnonymousParcel)
    {
      return new NewsSession(paramAnonymousParcel);
    }

    public NewsSession[] a(int paramAnonymousInt)
    {
      return new NewsSession[paramAnonymousInt];
    }
  };
  private static final Logger L = ViberEnv.getLogger();
  private long mLastVisitedOpened;
  private String mLastVisitedUrl;
  private final long mStartTimeMillis;
  private long mStopTimeMillis;
  private final HashMap<String, Long> mVisitedUrls;

  private NewsSession(long paramLong)
  {
    this.mStartTimeMillis = paramLong;
    this.mStopTimeMillis = 0L;
    this.mVisitedUrls = new HashMap();
  }

  NewsSession(Parcel paramParcel)
  {
    this.mStartTimeMillis = paramParcel.readLong();
    this.mStopTimeMillis = paramParcel.readLong();
    this.mVisitedUrls = ((HashMap)paramParcel.readSerializable());
    this.mLastVisitedUrl = paramParcel.readString();
    this.mLastVisitedOpened = paramParcel.readLong();
  }

  private void saveLastVisitedDuration(long paramLong)
  {
    Long localLong;
    if (dz.a(this.mLastVisitedUrl))
    {
      localLong = (Long)this.mVisitedUrls.get(this.mLastVisitedUrl);
      if (localLong == null)
        break label68;
    }
    label68: for (long l1 = localLong.longValue(); ; l1 = 0L)
    {
      long l2 = l1 + Math.max(paramLong - this.mLastVisitedOpened, 0L);
      this.mVisitedUrls.put(this.mLastVisitedUrl, Long.valueOf(l2));
      return;
    }
  }

  static NewsSession startSession(a parama)
  {
    return new NewsSession(parama.a());
  }

  public int describeContents()
  {
    return 0;
  }

  public long getSessionTimeMillis()
  {
    return Math.max(this.mStopTimeMillis - this.mStartTimeMillis, 0L);
  }

  public Map<String, Long> getVisitedUrls()
  {
    return Collections.unmodifiableMap(this.mVisitedUrls);
  }

  boolean isSessionStopped()
  {
    return this.mStopTimeMillis != 0L;
  }

  void stopSession(a parama)
  {
    if (isSessionStopped())
      return;
    this.mStopTimeMillis = parama.a();
    saveLastVisitedDuration(this.mStopTimeMillis);
    this.mLastVisitedUrl = null;
    this.mLastVisitedOpened = 0L;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("NewsSession{mStartTimeMillis=").append(this.mStartTimeMillis).append(", mStopTimeMillis=").append(this.mStopTimeMillis);
    if (isSessionStopped());
    for (String str = ", sessionTimeMillis=" + (this.mStopTimeMillis - this.mStartTimeMillis); ; str = "")
      return str + ", mVisitedUrls=" + this.mVisitedUrls + ", mLastVisitedUrl='" + this.mLastVisitedUrl + '\'' + ", mLastVisitedOpened=" + this.mLastVisitedOpened + '}';
  }

  void trackUrl(String paramString, a parama)
  {
    if (isSessionStopped());
    while ((!dz.a(paramString)) || (ObjectsCompat.equals(this.mLastVisitedUrl, paramString)))
      return;
    long l = parama.a();
    saveLastVisitedDuration(l);
    this.mLastVisitedUrl = paramString;
    this.mLastVisitedOpened = l;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mStartTimeMillis);
    paramParcel.writeLong(this.mStopTimeMillis);
    paramParcel.writeSerializable(this.mVisitedUrls);
    paramParcel.writeString(this.mLastVisitedUrl);
    paramParcel.writeLong(this.mLastVisitedOpened);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.NewsSession
 * JD-Core Version:    0.6.2
 */