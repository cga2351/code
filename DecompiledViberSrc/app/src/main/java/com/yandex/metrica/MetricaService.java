package com.yandex.metrica;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.yandex.metrica.impl.ai;
import com.yandex.metrica.impl.aj;
import com.yandex.metrica.impl.ak;
import com.yandex.metrica.impl.aw;
import com.yandex.metrica.impl.ob.h;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.p;
import com.yandex.metrica.impl.v;

public class MetricaService extends Service
{
  private c a = new c()
  {
    public void a(int paramAnonymousInt)
    {
      MetricaService.this.stopSelfResult(paramAnonymousInt);
    }
  };
  private ai b;
  private final IMetricaService.Stub c = new IMetricaService.Stub()
  {
    public void reportData(Bundle paramAnonymousBundle)
      throws RemoteException
    {
      MetricaService.a(MetricaService.this).a(paramAnonymousBundle);
    }

    @Deprecated
    public void reportEvent(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, Bundle paramAnonymousBundle)
      throws RemoteException
    {
      MetricaService.a(MetricaService.this).a(paramAnonymousString1, paramAnonymousInt, paramAnonymousString2, paramAnonymousBundle);
    }
  };

  private static void a(Configuration paramConfiguration)
  {
    h.a().b(new p(aw.a(paramConfiguration.locale)));
  }

  public IBinder onBind(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Object localObject;
    if ("com.yandex.metrica.ACTION_BIND_TO_LOCAL_SERVER".equals(str))
      localObject = new b();
    while (true)
    {
      this.b.a(paramIntent);
      return localObject;
      if ("com.yandex.metrica.ACTION_C_BG_L".equals(str))
        localObject = new a();
      else
        localObject = this.c;
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a(paramConfiguration);
  }

  public void onCreate()
  {
    super.onCreate();
    v.a(getApplicationContext());
    a(getResources().getConfiguration());
    of.a(getApplicationContext());
    this.b = new aj(new ak(getApplicationContext(), this.a));
    this.b.a();
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.b.b();
  }

  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
    this.b.b(paramIntent);
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    this.b.a(paramIntent, paramInt);
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.b.a(paramIntent, paramInt1, paramInt2);
    return 2;
  }

  public boolean onUnbind(Intent paramIntent)
  {
    this.b.c(paramIntent);
    String str = paramIntent.getAction();
    if ("com.yandex.metrica.ACTION_BIND_TO_LOCAL_SERVER".equals(str));
    while (true)
    {
      return false;
      if ("com.yandex.metrica.ACTION_C_BG_L".equals(str))
        return true;
      if ((paramIntent == null) || (paramIntent.getData() == null));
      for (int i = 1; i == 0; i = 0)
        return true;
    }
  }

  static class a extends Binder
  {
  }

  static class b extends Binder
  {
  }

  public static abstract interface c
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.MetricaService
 * JD-Core Version:    0.6.2
 */