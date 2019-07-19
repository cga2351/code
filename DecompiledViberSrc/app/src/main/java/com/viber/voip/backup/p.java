package com.viber.voip.backup;

import android.content.Context;
import android.content.res.Resources;
import com.viber.voip.R.string;
import com.viber.voip.util.ae;

public class p
{
  private final Context a;
  private final Resources b;

  public p(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = this.a.getResources();
  }

  public String a(long paramLong)
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
    arrayOfObject1[0] = ae.a(this.a, paramLong, null);
    arrayOfObject1[1] = ae.e(paramLong);
    return localResources1.getString(i, arrayOfObject1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.p
 * JD-Core Version:    0.6.2
 */