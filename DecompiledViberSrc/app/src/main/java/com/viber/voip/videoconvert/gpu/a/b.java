package com.viber.voip.videoconvert.gpu.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  private static final b a = new b();
  private ExecutorService b = Executors.newFixedThreadPool(5);

  public static ExecutorService a()
  {
    return a.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.a.b
 * JD-Core Version:    0.6.2
 */