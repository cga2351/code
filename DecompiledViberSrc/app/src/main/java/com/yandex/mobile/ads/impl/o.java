package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;

public final class o
  implements m
{
  private final Activity a;
  private final ResultReceiver b;

  public o(Activity paramActivity, ResultReceiver paramResultReceiver)
  {
    this.a = paramActivity;
    this.b = paramResultReceiver;
  }

  public final void a()
  {
    this.a.finish();
  }

  public final void a(int paramInt)
  {
    this.a.setRequestedOrientation(paramInt);
  }

  public final void a(int paramInt, Bundle paramBundle)
  {
    if (this.b != null)
      this.b.send(paramInt, paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.o
 * JD-Core Version:    0.6.2
 */