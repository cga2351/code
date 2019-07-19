package com.google.android.exoplayer2.g;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.SystemClock;

final class aa
  implements b
{
  public long a()
  {
    return SystemClock.elapsedRealtime();
  }

  public k a(Looper paramLooper, Handler.Callback paramCallback)
  {
    return new ab(new Handler(paramLooper, paramCallback));
  }

  public long b()
  {
    return SystemClock.uptimeMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.aa
 * JD-Core Version:    0.6.2
 */