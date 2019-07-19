package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzazq
{

  @GuardedBy("this")
  private final BroadcastReceiver zzdyf = new zzazr(this);

  @GuardedBy("this")
  private final Map<BroadcastReceiver, IntentFilter> zzdyg = new WeakHashMap();
  private boolean zzdyh;
  private boolean zzxs = false;
  private Context zzys;

  private final void zzc(Context paramContext, Intent paramIntent)
  {
    try
    {
      Iterator localIterator = this.zzdyg.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((IntentFilter)localEntry.getValue()).hasAction(paramIntent.getAction()))
          ((BroadcastReceiver)localEntry.getKey()).onReceive(paramContext, paramIntent);
      }
    }
    finally
    {
    }
  }

  public final void initialize(Context paramContext)
  {
    try
    {
      boolean bool = this.zzxs;
      if (bool);
      while (true)
      {
        return;
        this.zzys = paramContext.getApplicationContext();
        if (this.zzys == null)
          this.zzys = paramContext;
        zzact.initialize(this.zzys);
        zzaci localzzaci = zzact.zzcsk;
        this.zzdyh = ((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue();
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zzys.registerReceiver(this.zzdyf, localIntentFilter);
        this.zzxs = true;
      }
    }
    finally
    {
    }
  }

  public final void zza(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    try
    {
      if (this.zzdyh)
        this.zzdyg.remove(paramBroadcastReceiver);
      while (true)
      {
        return;
        paramContext.unregisterReceiver(paramBroadcastReceiver);
      }
    }
    finally
    {
    }
  }

  public final void zza(Context paramContext, BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    try
    {
      if (this.zzdyh)
        this.zzdyg.put(paramBroadcastReceiver, paramIntentFilter);
      while (true)
      {
        return;
        paramContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazq
 * JD-Core Version:    0.6.2
 */