package com.viber.voip.videoconvert.gpu.e;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.viber.voip.videoconvert.gpu.opengl.d;

@TargetApi(18)
public class e
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static String a = "SurfaceTextureManager";
  private SurfaceTexture b;
  private Object c = new Object();
  private boolean d = false;
  private boolean e = false;
  private long f = -1L;

  public e(d paramd)
  {
    this.b = new SurfaceTexture(paramd.c());
    this.b.setOnFrameAvailableListener(this);
  }

  public void a()
  {
    this.b = null;
  }

  public void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      com.viber.voip.videoconvert.e.a().a(paramString + ": glError " + i);
      throw new RuntimeException(paramString + ": glError " + i);
    }
  }

  public SurfaceTexture b()
  {
    return this.b;
  }

  public long c()
  {
    return this.b.getTimestamp();
  }

  public void d()
  {
    do
    {
      synchronized (this.c)
      {
        while (true)
        {
          boolean bool1 = this.d;
          if (!bool1)
            try
            {
              long l1 = System.nanoTime();
              long l2 = 10000000000L;
              do
              {
                if ((this.d) || (this.e))
                  break;
                this.c.wait(l2 / 1000000L);
                l2 -= System.nanoTime() - l1;
              }
              while (l2 > 0L);
              boolean bool2 = this.e;
              if (bool2)
                return;
              if (!this.d)
                throw new RuntimeException("No frame was available for 10000ms, this is possibly an error");
            }
            catch (InterruptedException localInterruptedException)
            {
              throw new RuntimeException(localInterruptedException);
            }
        }
      }
      this.d = false;
      a("before updateTexImage");
      this.b.updateTexImage();
    }
    while (this.f != -1L);
    this.f = this.b.getTimestamp();
  }

  public void e()
  {
    synchronized (this.c)
    {
      this.e = true;
      this.c.notifyAll();
      return;
    }
  }

  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    synchronized (this.c)
    {
      if (this.d)
        com.viber.voip.videoconvert.e.a().a("mFrameAvailable already set, frame could be dropped");
      this.d = true;
      this.c.notifyAll();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.e.e
 * JD-Core Version:    0.6.2
 */