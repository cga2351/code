package com.yandex.metrica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.yandex.metrica.impl.bz;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.og;
import com.yandex.metrica.impl.ob.ps;
import com.yandex.metrica.impl.ob.pt;
import com.yandex.metrica.impl.ob.px;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetricaEventHandler extends BroadcastReceiver
{
  public static final Set<BroadcastReceiver> a = new HashSet();
  private static final px<BroadcastReceiver[]> b = new pt(new ps("Broadcast receivers"));

  static void a(BroadcastReceiver[] paramArrayOfBroadcastReceiver)
  {
    b.a(paramArrayOfBroadcastReceiver);
    Collections.addAll(a, paramArrayOfBroadcastReceiver);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction()))
    {
      String str2 = paramIntent.getStringExtra("referrer");
      if (!TextUtils.isEmpty(str2))
        bz.b(paramContext).a(str2);
    }
    of localof = og.a();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)localIterator.next();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localBroadcastReceiver.getClass().getName();
      String str1 = String.format("Sending referrer to %s", arrayOfObject);
      if (localof.c())
        localof.a(str1);
      localBroadcastReceiver.onReceive(paramContext, paramIntent);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.MetricaEventHandler
 * JD-Core Version:    0.6.2
 */