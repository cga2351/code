package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import android.os.Process;

public final class zzko extends HandlerThread
{
  private final int priority = -16;

  public zzko(String paramString, int paramInt)
  {
    super(paramString);
  }

  public final void run()
  {
    Process.setThreadPriority(this.priority);
    super.run();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzko
 * JD-Core Version:    0.6.2
 */