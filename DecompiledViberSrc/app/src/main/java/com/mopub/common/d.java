package com.mopub.common;

import android.os.Handler;
import android.os.Looper;

class d
  implements SdkInitializationListener
{
  private SdkInitializationListener a;
  private int b;

  public d(SdkInitializationListener paramSdkInitializationListener, int paramInt)
  {
    Preconditions.checkNotNull(paramSdkInitializationListener);
    this.a = paramSdkInitializationListener;
    this.b = paramInt;
  }

  public void onInitializationFinished()
  {
    this.b = (-1 + this.b);
    if (this.b <= 0)
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          if (d.a(d.this) != null)
          {
            d.a(d.this).onInitializationFinished();
            d.a(d.this, null);
          }
        }
      });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.d
 * JD-Core Version:    0.6.2
 */