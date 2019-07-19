package com.viber.voip.messages;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.l.b;
import com.viber.voip.util.ae;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class i
{

  @SuppressLint({"StaticFieldLeak"})
  private static i a;
  private Resources b = this.c.getResources();
  private Context c = ViberApplication.getApplication();

  public static i a()
  {
    if (a == null)
      a = new i();
    return a;
  }

  public String a(long paramLong)
  {
    b localb = ViberApplication.getInstance().getLocaleDataCache();
    if (ae.a(paramLong))
      return localb.a;
    if (ae.b(paramLong))
      return localb.b;
    return localb.b().format(Long.valueOf(paramLong));
  }

  public String b(long paramLong)
  {
    return ae.e(paramLong);
  }

  public String c(long paramLong)
  {
    if (ae.a(paramLong))
      return ae.e(paramLong);
    if (ae.b(paramLong))
    {
      Resources localResources = this.b;
      int i = R.string.active_yesterday_at;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = ae.e(paramLong);
      return localResources.getString(i, arrayOfObject2);
    }
    String str = ViberApplication.getInstance().getLocaleDataCache().c;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = ae.a(this.c, paramLong, false, "MMM dd");
    arrayOfObject1[1] = ae.e(paramLong);
    return String.format(str, arrayOfObject1);
  }

  public String d(long paramLong)
  {
    if (ae.a(paramLong))
    {
      Resources localResources3 = this.b;
      int k = R.string.active_today_at;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = ae.e(paramLong);
      return localResources3.getString(k, arrayOfObject3);
    }
    if (ae.b(paramLong))
    {
      Resources localResources2 = this.b;
      int j = R.string.active_yesterday_at;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = ae.e(paramLong);
      return localResources2.getString(j, arrayOfObject2);
    }
    Resources localResources1 = this.b;
    int i = R.string.active_at;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = ae.a(this.c, paramLong, false, "MMM dd");
    arrayOfObject1[1] = ae.e(paramLong);
    return localResources1.getString(i, arrayOfObject1);
  }

  public String e(long paramLong)
  {
    Date localDate = new Date(paramLong);
    DateFormat localDateFormat = DateFormat.getDateTimeInstance(1, 3, Locale.getDefault());
    Resources localResources = this.b;
    int i = R.string.view_media_received_on;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localDateFormat.format(localDate);
    arrayOfObject[1] = "";
    return localResources.getString(i, arrayOfObject);
  }

  public String f(long paramLong)
  {
    b localb = ViberApplication.getInstance().getLocaleDataCache();
    if (ae.a(paramLong))
      return ae.e(paramLong);
    if (ae.b(paramLong))
      return localb.b;
    if (ae.c(paramLong))
      return ae.a(this.c, paramLong, "EEE");
    if (ae.d(paramLong))
      return ae.a(this.c, paramLong, "MMM dd");
    return localb.b().format(Long.valueOf(paramLong));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.i
 * JD-Core Version:    0.6.2
 */