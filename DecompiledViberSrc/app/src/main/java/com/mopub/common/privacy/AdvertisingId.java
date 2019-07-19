package com.mopub.common.privacy;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

public class AdvertisingId
  implements Serializable
{
  final Calendar a;
  final String b;
  final String c;
  final boolean d;

  AdvertisingId(String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean;
    this.a = Calendar.getInstance();
    this.a.setTimeInMillis(paramLong);
  }

  static AdvertisingId b()
  {
    Calendar localCalendar = Calendar.getInstance();
    return new AdvertisingId("", d(), false, localCalendar.getTimeInMillis() - 86400000L - 1L);
  }

  static AdvertisingId c()
  {
    Calendar localCalendar = Calendar.getInstance();
    return new AdvertisingId("", d(), false, localCalendar.getTimeInMillis());
  }

  static String d()
  {
    return UUID.randomUUID().toString();
  }

  String a()
  {
    if (TextUtils.isEmpty(this.b))
      return "";
    return "ifa:" + this.b;
  }

  boolean e()
  {
    Calendar localCalendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    Calendar localCalendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    localCalendar2.setTimeInMillis(this.a.getTimeInMillis());
    return (localCalendar1.get(6) != localCalendar2.get(6)) || (localCalendar1.get(1) != localCalendar2.get(1));
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (this == paramObject)
      bool2 = true;
    AdvertisingId localAdvertisingId;
    boolean bool5;
    do
    {
      boolean bool3;
      boolean bool4;
      do
      {
        boolean bool1;
        do
        {
          return bool2;
          bool1 = paramObject instanceof AdvertisingId;
          bool2 = false;
        }
        while (!bool1);
        localAdvertisingId = (AdvertisingId)paramObject;
        bool3 = this.d;
        bool4 = localAdvertisingId.d;
        bool2 = false;
      }
      while (bool3 != bool4);
      bool5 = this.b.equals(localAdvertisingId.b);
      bool2 = false;
    }
    while (!bool5);
    return this.c.equals(localAdvertisingId.c);
  }

  public String getIdWithPrefix(boolean paramBoolean)
  {
    if ((this.d) || (!paramBoolean) || (this.b.isEmpty()))
      return "mopub:" + this.c;
    return "ifa:" + this.b;
  }

  public String getIdentifier(boolean paramBoolean)
  {
    if ((this.d) || (!paramBoolean))
      return this.c;
    return this.b;
  }

  public int hashCode()
  {
    int i = 31 * (31 * this.b.hashCode() + this.c.hashCode());
    if (this.d);
    for (int j = 1; ; j = 0)
      return j + i;
  }

  public boolean isDoNotTrack()
  {
    return this.d;
  }

  public String toString()
  {
    return "AdvertisingId{mLastRotation=" + this.a + ", mAdvertisingId='" + this.b + '\'' + ", mMopubId='" + this.c + '\'' + ", mDoNotTrack=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.AdvertisingId
 * JD-Core Version:    0.6.2
 */