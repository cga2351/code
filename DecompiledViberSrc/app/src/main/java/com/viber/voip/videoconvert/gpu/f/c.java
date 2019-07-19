package com.viber.voip.videoconvert.gpu.f;

import android.graphics.SurfaceTexture;
import com.viber.voip.videoconvert.gpu.e.e;

public abstract class c extends a
  implements d
{
  protected com.viber.voip.videoconvert.gpu.opengl.d e;
  protected e f;

  public void a(d.a parama)
  {
    this.e = new com.viber.voip.videoconvert.gpu.opengl.d(36197);
    this.f = new e(this.e);
  }

  public void d()
  {
    if (this.f != null)
    {
      this.f.a();
      this.f = null;
    }
    if (this.e != null)
    {
      this.e.b();
      this.e = null;
    }
  }

  public long e()
  {
    return this.f.c();
  }

  public void h()
  {
    this.f.d();
  }

  public com.viber.voip.videoconvert.gpu.opengl.d i()
  {
    return this.e;
  }

  public SurfaceTexture j()
  {
    return this.f.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.f.c
 * JD-Core Version:    0.6.2
 */