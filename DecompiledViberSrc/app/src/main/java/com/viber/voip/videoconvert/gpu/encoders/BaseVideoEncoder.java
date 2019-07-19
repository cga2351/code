package com.viber.voip.videoconvert.gpu.encoders;

import android.opengl.Matrix;
import com.viber.voip.ah;
import com.viber.voip.videoconvert.e;
import com.viber.voip.videoconvert.g;
import com.viber.voip.videoconvert.gpu.e.b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class BaseVideoEncoder
  implements c
{
  protected com.viber.voip.videoconvert.gpu.e.b a;
  protected com.viber.voip.videoconvert.gpu.receivers.b b;
  protected ByteBuffer c;
  protected ByteBuffer d;
  Future<Boolean> e;
  int f = 0;
  private c.d g;
  private c.a h;

  public BaseVideoEncoder(c.a parama)
  {
    this.h = parama;
    a(c.d.a);
  }

  public c.d a()
  {
    return this.g;
  }

  protected void a(long paramLong)
  {
    if (b().i.q <= 0L);
    int i;
    do
    {
      do
        return;
      while (b().i.p == null);
      i = (int)(100L * (paramLong / 1000L) / b().i.q);
    }
    while (i <= this.f);
    this.f = i;
    try
    {
      b().i.p.a(b().i.r, i);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void a(com.viber.voip.videoconvert.gpu.e.b paramb)
  {
    if (this.a != null)
      this.a.a(null);
    this.a = paramb;
    if (this.a != null)
      this.a.a(new b.a()
      {
        public void a()
        {
          e.a().a("VideoSource stream is complete");
          BaseVideoEncoder.this.a(c.d.f);
        }

        public void b()
        {
          e.a().a("error occurred in VideoSource");
          BaseVideoEncoder.this.a(c.d.g);
        }
      });
  }

  public void a(c.d paramd)
  {
    this.g = paramd;
  }

  public void a(com.viber.voip.videoconvert.gpu.receivers.b paramb)
  {
    this.b = paramb;
  }

  public void a(ExecutorService paramExecutorService)
  {
    a(c.d.b);
    this.e = paramExecutorService.submit(new Callable()
    {
      public Boolean a()
      {
        try
        {
          Boolean localBoolean = Boolean.valueOf(BaseVideoEncoder.this.g());
          return localBoolean;
        }
        catch (Throwable localThrowable)
        {
          e.a().a(localThrowable);
        }
        return Boolean.FALSE;
      }
    });
  }

  protected abstract void a(boolean paramBoolean);

  public c.a b()
  {
    return this.h;
  }

  public void b(long paramLong)
  {
    if (this.e == null)
      return;
    if (paramLong == -1L);
    try
    {
      this.e.get();
      while (true)
      {
        this.e = null;
        return;
        this.e.get(paramLong, TimeUnit.MILLISECONDS);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
        e.a().a(localExecutionException);
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        e.a().a(localInterruptedException);
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
      {
        h();
        a(c.d.e);
      }
    }
  }

  protected void c()
  {
    this.c = ByteBuffer.allocateDirect(4 * (this.h.b * this.h.c));
    this.c.order(ByteOrder.nativeOrder());
    this.d = ByteBuffer.allocateDirect(4 * (this.h.b * this.h.c));
    this.d.order(ByteOrder.nativeOrder());
    e.a().a("allocated memory for input buffers");
    this.a.a(this);
    e.a().a("configured input data provider");
    if (this.b != null)
      this.b.a(this);
    e.a().a("configured encoded data receiver");
  }

  public native int convertPixels(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, int paramInt3, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);

  protected void d()
  {
    this.a.c();
    e.a().a("started input data provider");
  }

  protected void e()
  {
    this.a.d();
    e.a().a("stopped input data provider");
  }

  protected void f()
  {
    if (this.a != null)
    {
      this.a.e();
      this.a = null;
    }
    e.a().a("released input data provider");
    if (this.b != null)
    {
      this.b.c();
      this.b = null;
    }
    e.a().a("released encoded data receiver");
  }

  public boolean g()
  {
    c.a locala = b();
    e.a().a("encoding video " + locala.b + "x" + locala.c + " @" + locala.d + " rotationHint: " + locala.f);
    try
    {
      c();
      e.a().a("prepared encoder");
      d();
      e.a().a("started encoder");
      float[] arrayOfFloat1 = new float[16];
      float[] arrayOfFloat2 = new float[16];
      while (true)
      {
        if ((!Thread.interrupted()) && ((a() == c.d.c) || (a() == c.d.b)))
        {
          a(false);
          if (!b().i.s);
        }
        else
        {
          e();
          e.a().a("stopped encoder");
          if (!b().i.s)
            break;
          locald3 = c.d.d;
          a(locald3);
          f();
          e.a().a("encoding completed successfully");
          c.d locald1 = a();
          c.d locald2 = c.d.f;
          boolean bool = false;
          if (locald1 == locald2)
            bool = true;
          return bool;
        }
        this.a.b();
        Matrix.setIdentityM(arrayOfFloat1, 0);
        Matrix.setIdentityM(arrayOfFloat2, 0);
        this.a.a(arrayOfFloat1, arrayOfFloat2, locala.g);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        a(c.d.g);
        e.a().a("encoder state is changed to Status.Failed");
        e.a().a(localException);
        e();
        e.a().a("stopped encoder");
        continue;
        c.d locald3 = c.d.f;
      }
    }
  }

  public void h()
  {
    if (this.e == null)
      return;
    this.e.cancel(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.encoders.BaseVideoEncoder
 * JD-Core Version:    0.6.2
 */