package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.List;

class a
{
  private final Context a;
  private final a b;

  a(Context paramContext, i parami)
  {
    this.a = paramContext;
    this.b = new a(parami, null);
  }

  void a()
  {
    this.b.a(this.a, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
  }

  i b()
  {
    return a.a(this.b);
  }

  void c()
  {
    this.b.a(this.a);
  }

  private class a extends BroadcastReceiver
  {
    private final i b;
    private boolean c;

    private a(i arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void a(Context paramContext)
    {
      if (this.c)
      {
        paramContext.unregisterReceiver(a.a(a.this));
        this.c = false;
        return;
      }
      com.android.billingclient.a.a.b("BillingBroadcastManager", "Receiver is not registered.");
    }

    public void a(Context paramContext, IntentFilter paramIntentFilter)
    {
      if (!this.c)
      {
        paramContext.registerReceiver(a.a(a.this), paramIntentFilter);
        this.c = true;
      }
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = com.android.billingclient.a.a.a(paramIntent, "BillingBroadcastManager");
      List localList = com.android.billingclient.a.a.a(paramIntent.getExtras());
      this.b.onPurchasesUpdated(i, localList);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.a
 * JD-Core Version:    0.6.2
 */