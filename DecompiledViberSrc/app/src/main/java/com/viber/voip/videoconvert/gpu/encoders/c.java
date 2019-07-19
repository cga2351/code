package com.viber.voip.videoconvert.gpu.encoders;

import com.viber.voip.videoconvert.g;
import java.util.concurrent.ExecutorService;

public abstract interface c
{
  public abstract d a();

  public abstract void a(com.viber.voip.videoconvert.gpu.e.b paramb);

  public abstract void a(com.viber.voip.videoconvert.gpu.receivers.b paramb);

  public abstract void a(ExecutorService paramExecutorService);

  public abstract a b();

  public abstract void b(long paramLong);

  public static class a
  {
    public String a;
    public int b = 640;
    public int c = 480;
    public int d = 1000000;
    public int e = 30;
    public int f = 0;
    public c.c g = c.c.a;
    public boolean h = false;
    public g i;
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[7];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[3];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
    }
  }

  public static enum d
  {
    static
    {
      d[] arrayOfd = new d[7];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
      arrayOfd[2] = c;
      arrayOfd[3] = d;
      arrayOfd[4] = e;
      arrayOfd[5] = f;
      arrayOfd[6] = g;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.encoders.c
 * JD-Core Version:    0.6.2
 */