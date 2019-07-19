package com.yandex.metrica.impl;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.yandex.metrica.impl.ob.mq;
import com.yandex.metrica.impl.ob.mw;
import com.yandex.metrica.impl.ob.nz;
import com.yandex.metrica.impl.ob.ol;
import com.yandex.metrica.impl.ob.oo;

@SuppressLint({"ParcelCreator"})
public class k extends ResultReceiver
{
  private a a;

  public k(Handler paramHandler)
  {
    super(paramHandler);
  }

  public static void a(ResultReceiver paramResultReceiver, mq parammq)
  {
    if (paramResultReceiver != null)
      paramResultReceiver.send(2, parammq.a(new Bundle()));
  }

  public static void a(ResultReceiver paramResultReceiver, mw parammw)
  {
    if (paramResultReceiver != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("Uuid", parammw.a);
      localBundle.putString("DeviceId", parammw.b);
      localBundle.putString("DeviceIdHash", parammw.c);
      localBundle.putString("AdUrlGet", parammw.e);
      localBundle.putString("AdUrlReport", parammw.f);
      localBundle.putLong("ServerTimeOffset", oo.a());
      localBundle.putString("Clids", nz.a(ol.a(parammw.l)));
      paramResultReceiver.send(1, localBundle);
    }
  }

  void a(a parama)
  {
    this.a = parama;
  }

  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (this.a != null)
      this.a.a(paramInt, paramBundle);
  }

  static abstract interface a
  {
    public abstract void a(int paramInt, Bundle paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.k
 * JD-Core Version:    0.6.2
 */