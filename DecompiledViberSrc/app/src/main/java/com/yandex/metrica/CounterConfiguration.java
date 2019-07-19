package com.yandex.metrica;

import android.content.ContentValues;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.hw;

@Deprecated
public class CounterConfiguration
  implements Parcelable
{
  public static final Parcelable.Creator<CounterConfiguration> CREATOR = new Parcelable.Creator()
  {
  };
  private final ContentValues a;
  private ResultReceiver b = null;

  public CounterConfiguration()
  {
    this.a = new ContentValues();
  }

  CounterConfiguration(ContentValues paramContentValues)
  {
    this.a = paramContentValues;
  }

  private CounterConfiguration(ContentValues paramContentValues, ResultReceiver paramResultReceiver)
  {
    this.a = paramContentValues;
    this.b = paramResultReceiver;
  }

  public CounterConfiguration(ResultReceiver paramResultReceiver)
  {
    this();
    this.b = paramResultReceiver;
  }

  public CounterConfiguration(CounterConfiguration paramCounterConfiguration)
  {
    try
    {
      this.a = new ContentValues(paramCounterConfiguration.a);
      this.b = paramCounterConfiguration.b;
      return;
    }
    finally
    {
    }
  }

  public CounterConfiguration(e parame)
  {
    this();
    while (true)
    {
      try
      {
        e(parame.apiKey);
        a(parame.sessionTimeout);
        b(parame.a);
        c(parame.b);
        Boolean localBoolean = parame.logs;
        if (localBoolean != null)
        {
          i = 1;
          if (i != 0)
            c(localBoolean.booleanValue());
          a(parame.statisticsSending);
          return;
        }
      }
      finally
      {
      }
      int i = 0;
    }
  }

  public CounterConfiguration(g paramg)
  {
    this();
    while (true)
    {
      try
      {
        e(paramg.apiKey);
        a(paramg.sessionTimeout);
        if (paramg.location != null)
        {
          j = i;
          if (j != 0)
            a(paramg.location);
          if (paramg.locationTracking == null)
            break label278;
          k = i;
          if (k != 0)
            a(paramg.locationTracking.booleanValue());
          if (paramg.installedAppCollecting == null)
            break label284;
          m = i;
          if (m != 0)
            b(paramg.installedAppCollecting.booleanValue());
          if (paramg.a == null)
            break label290;
          n = i;
          if (n != 0)
            a(paramg.a);
          b(paramg.f);
          c(paramg.g);
          if (!TextUtils.isEmpty(paramg.appVersion))
            d(paramg.appVersion);
          if (paramg.e == null)
            break label296;
          i1 = i;
          if (i1 != 0)
            d(paramg.e.intValue());
          if (paramg.j == null)
            break label302;
          i2 = i;
          if (i2 != 0)
            d(paramg.j.booleanValue());
          if (paramg.k == null)
            break label308;
          i3 = i;
          if (i3 != 0)
            e(paramg.k.booleanValue());
          if (paramg.firstActivationAsUpdate == null)
            break label314;
          if (i != 0)
            f(paramg.firstActivationAsUpdate.booleanValue());
          a(paramg.statisticsSending);
          return;
        }
      }
      finally
      {
      }
      int j = 0;
      continue;
      label278: int k = 0;
      continue;
      label284: int m = 0;
      continue;
      label290: int n = 0;
      continue;
      label296: int i1 = 0;
      continue;
      label302: int i2 = 0;
      continue;
      label308: int i3 = 0;
      continue;
      label314: i = 0;
    }
  }

  private void a(Boolean paramBoolean)
  {
    if (paramBoolean != null);
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        g(paramBoolean.booleanValue());
      return;
    }
  }

  private void a(Integer paramInteger)
  {
    if (paramInteger != null);
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        c(paramInteger.intValue());
      return;
    }
  }

  private boolean a(String paramString, boolean paramBoolean)
  {
    Boolean localBoolean = this.a.getAsBoolean(paramString);
    if (localBoolean == null)
      return paramBoolean;
    return localBoolean.booleanValue();
  }

  private void b(Integer paramInteger)
  {
    if (paramInteger != null);
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        a(paramInteger.intValue());
      return;
    }
  }

  public static CounterConfiguration c(Bundle paramBundle)
  {
    if (paramBundle != null);
    while (true)
    {
      try
      {
        localCounterConfiguration = (CounterConfiguration)paramBundle.getParcelable("COUNTER_CFG_OBJ");
        if (localCounterConfiguration == null)
          localCounterConfiguration = new CounterConfiguration();
        localCounterConfiguration.b(paramBundle);
        return localCounterConfiguration;
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      CounterConfiguration localCounterConfiguration = null;
    }
  }

  private void c(Integer paramInteger)
  {
    if (paramInteger != null);
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        b(paramInteger.intValue());
      return;
    }
  }

  private void e(String paramString)
  {
    if (paramString != null);
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        b(paramString);
      return;
    }
  }

  private void i(boolean paramBoolean)
  {
    try
    {
      this.a.put("CFG_MAIN_REPORTER", Boolean.valueOf(paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void j(boolean paramBoolean)
  {
    try
    {
      this.a.put("CFG_COMMUTATION_REPORTER", Boolean.valueOf(paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public ResultReceiver a()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    try
    {
      this.a.put("CFG_DISPATCH_PERIOD", Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(Location paramLocation)
  {
    try
    {
      this.a.put("CFG_MANUAL_LOCATION", hw.a(paramLocation));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Bundle paramBundle)
  {
    try
    {
      paramBundle.putParcelable("COUNTER_CFG_OBJ", this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void a(String paramString)
  {
    try
    {
      ContentValues localContentValues = this.a;
      if (TextUtils.isEmpty(paramString))
        paramString = null;
      localContentValues.put("CFG_DEVICE_SIZE_TYPE", paramString);
      return;
    }
    finally
    {
    }
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      this.a.put("CFG_LOCATION_TRACKING", Boolean.valueOf(paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Integer b()
  {
    return this.a.getAsInteger("CFG_DISPATCH_PERIOD");
  }

  public void b(int paramInt)
  {
    try
    {
      ContentValues localContentValues = this.a;
      if (paramInt <= 0)
        paramInt = 2147483647;
      localContentValues.put("CFG_MAX_REPORTS_COUNT", Integer.valueOf(paramInt));
      return;
    }
    finally
    {
    }
  }

  public void b(Bundle paramBundle)
  {
    if (paramBundle == null);
    while (true)
    {
      return;
      try
      {
        if (paramBundle.getInt("CFG_DISPATCH_PERIOD") != 0)
          a(paramBundle.getInt("CFG_DISPATCH_PERIOD"));
        if (paramBundle.getInt("CFG_SESSION_TIMEOUT") != 0)
          c(paramBundle.getInt("CFG_SESSION_TIMEOUT"));
        if (paramBundle.getInt("CFG_MAX_REPORTS_COUNT") != 0)
          b(paramBundle.getInt("CFG_MAX_REPORTS_COUNT"));
        if ((paramBundle.getString("CFG_API_KEY") == null) || ("-1".equals(paramBundle.getString("CFG_API_KEY"))))
          continue;
        b(paramBundle.getString("CFG_API_KEY"));
      }
      finally
      {
      }
    }
  }

  public void b(String paramString)
  {
    try
    {
      this.a.put("CFG_API_KEY", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(boolean paramBoolean)
  {
    try
    {
      ContentValues localContentValues = this.a;
      if (paramBoolean);
      for (int i = a.c.d; ; i = a.b.d)
      {
        localContentValues.put("CFG_COLLECT_INSTALLED_APPS", Integer.valueOf(i));
        return;
      }
    }
    finally
    {
    }
  }

  public Integer c()
  {
    return this.a.getAsInteger("CFG_MAX_REPORTS_COUNT");
  }

  public void c(int paramInt)
  {
    try
    {
      this.a.put("CFG_SESSION_TIMEOUT", Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c(String paramString)
  {
    try
    {
      this.a.put("CFG_UUID", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c(boolean paramBoolean)
  {
    try
    {
      this.a.put("CFG_IS_LOG_ENABLED", Boolean.valueOf(paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Integer d()
  {
    return this.a.getAsInteger("CFG_SESSION_TIMEOUT");
  }

  public void d(int paramInt)
  {
    try
    {
      this.a.put("CFG_APP_VERSION_CODE", String.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void d(String paramString)
  {
    try
    {
      this.a.put("CFG_APP_VERSION", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d(boolean paramBoolean)
  {
    try
    {
      this.a.put("CFG_AUTO_PRELOAD_INFO_DETECTION", Boolean.valueOf(paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.a.getAsString("CFG_DEVICE_SIZE_TYPE");
  }

  public void e(boolean paramBoolean)
  {
    try
    {
      this.a.put("CFG_PERMISSIONS_COLLECTING", Boolean.valueOf(paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String f()
  {
    return this.a.getAsString("CFG_API_KEY");
  }

  public final void f(boolean paramBoolean)
  {
    try
    {
      this.a.put("CFG_IS_FIRST_ACTIVATION_AS_UPDATE", Boolean.valueOf(paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Boolean g()
  {
    return this.a.getAsBoolean("CFG_LOCATION_TRACKING");
  }

  public final void g(boolean paramBoolean)
  {
    try
    {
      this.a.put("CFG_STATISTICS_SENDING", Boolean.valueOf(paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String h()
  {
    return this.a.getAsString("CFG_APP_VERSION");
  }

  public void h(boolean paramBoolean)
  {
    try
    {
      i(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String i()
  {
    return this.a.getAsString("CFG_APP_VERSION_CODE");
  }

  public a j()
  {
    Object localObject = this.a.get("CFG_COLLECT_INSTALLED_APPS");
    if (localObject != null)
    {
      if ((localObject instanceof Integer))
        return a.a(((Integer)localObject).intValue());
      if ((localObject instanceof Boolean))
      {
        if (((Boolean)localObject).booleanValue())
          return a.c;
        return a.b;
      }
    }
    return a.a;
  }

  public Boolean k()
  {
    return this.a.getAsBoolean("CFG_IS_LOG_ENABLED");
  }

  public Location l()
  {
    if (this.a.containsKey("CFG_MANUAL_LOCATION"))
      return hw.a(this.a.getAsByteArray("CFG_MANUAL_LOCATION"));
    return null;
  }

  public Boolean m()
  {
    return this.a.getAsBoolean("CFG_AUTO_PRELOAD_INFO_DETECTION");
  }

  public Boolean n()
  {
    return this.a.getAsBoolean("CFG_IS_FIRST_ACTIVATION_AS_UPDATE");
  }

  public Boolean o()
  {
    return this.a.getAsBoolean("CFG_STATISTICS_SENDING");
  }

  public void p()
  {
    try
    {
      j(true);
      i(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean q()
  {
    return a("CFG_MAIN_REPORTER", true);
  }

  public boolean r()
  {
    return a("CFG_COMMUTATION_REPORTER", false);
  }

  public String toString()
  {
    try
    {
      String str = "CounterConfiguration{mParamsMapping=" + this.a + '}';
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("com.yandex.metrica.CounterConfiguration.data", this.a);
      if (this.b != null)
        localBundle.putParcelable("com.yandex.metrica.CounterConfiguration.receiver", this.b);
      paramParcel.writeBundle(localBundle);
      return;
    }
    finally
    {
    }
  }

  public static enum a
  {
    public final int d;

    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }

    private a(int paramInt)
    {
      this.d = paramInt;
    }

    public static a a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return a;
      case -1:
        return a;
      case 0:
        return b;
      case 1:
      }
      return c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.CounterConfiguration
 * JD-Core Version:    0.6.2
 */