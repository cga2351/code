package com.viber.voip.util.i;

import android.os.SystemClock;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class a extends e
{
  public long a()
  {
    return SystemClock.elapsedRealtime();
  }

  public long b()
  {
    return SystemClock.uptimeMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.i.a
 * JD-Core Version:    0.6.2
 */