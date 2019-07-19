package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.yandex.metrica.impl.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class no
  implements nq<List<nn>>
{
  private final nj a;
  private iv b;

  no(nj paramnj, iv paramiv)
  {
    this.a = paramnj;
    this.b = paramiv;
  }

  private nn b()
  {
    return new nn(c(), e(), h(), f(), null);
  }

  private Integer c()
  {
    try
    {
      String str = this.a.c().getSimOperator().substring(0, 3);
      if (TextUtils.isEmpty(str))
        return null;
      Integer localInteger = Integer.valueOf(Integer.parseInt(str));
      return localInteger;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private Integer e()
  {
    try
    {
      String str = this.a.c().getSimOperator().substring(3);
      if (TextUtils.isEmpty(str))
        return null;
      Integer localInteger = Integer.valueOf(Integer.parseInt(str));
      return localInteger;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private String f()
  {
    try
    {
      String str = this.a.c().getSimOperatorName();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  @TargetApi(23)
  private List<nn> g()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.b.d(this.a.d()))
      try
      {
        List localList = SubscriptionManager.from(this.a.d()).getActiveSubscriptionInfoList();
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
            localArrayList.add(new nn((SubscriptionInfo)localIterator.next()));
        }
      }
      catch (Exception localException)
      {
      }
    return localArrayList;
  }

  private boolean h()
  {
    if (this.b.d(this.a.d()))
      try
      {
        boolean bool = this.a.c().isNetworkRoaming();
        return bool;
      }
      catch (Exception localException)
      {
      }
    return false;
  }

  public List<nn> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a.h())
    {
      if (!bw.a(23))
        break label59;
      localArrayList.addAll(g());
      if (localArrayList.size() == 0)
        localArrayList.add(b());
    }
    return localArrayList;
    label59: localArrayList.add(b());
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.no
 * JD-Core Version:    0.6.2
 */