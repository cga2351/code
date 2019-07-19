package com.viber.voip.videoconvert.gpu.e;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.Matrix;
import android.view.Surface;
import com.viber.voip.videoconvert.gpu.encoders.c.c;
import com.viber.voip.videoconvert.gpu.f.d;
import com.viber.voip.videoconvert.gpu.f.d.a;

@TargetApi(18)
public class c extends a
{
  com.viber.voip.videoconvert.gpu.opengl.a d = null;
  com.viber.voip.videoconvert.gpu.opengl.e e = null;

  public void a(com.viber.voip.videoconvert.gpu.encoders.c paramc)
  {
    com.viber.voip.videoconvert.gpu.encoders.a locala = (com.viber.voip.videoconvert.gpu.encoders.a)paramc;
    if (locala == null)
      throw new RuntimeException("InputSurfaceDataProvider can be used only with MediaCodecEncoder");
    locala.j().setInteger("color-format", 2130708361);
    super.a(paramc);
  }

  public void a(d paramd, d.a parama)
  {
    super.a(paramd, parama);
    if ((com.viber.voip.videoconvert.gpu.f.c)paramd == null)
      throw new RuntimeException("InputSurfaceDataProvider can be used only with TextureVideoSource");
  }

  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, c.c paramc)
  {
    Matrix.scaleM(paramArrayOfFloat1, 0, 1.0F, -1.0F, 1.0F);
    this.b.a(this.e, paramArrayOfFloat2, paramArrayOfFloat1, paramc);
    this.d.a(this.b.e());
    this.d.swapBuffers();
  }

  public void c()
  {
    Surface localSurface = ((com.viber.voip.videoconvert.gpu.encoders.a)this.a).i().createInputSurface();
    this.d.a(localSurface);
    this.d.init();
    this.d.makeCurrent();
    this.e = new com.viber.voip.videoconvert.gpu.opengl.e();
    super.c();
  }

  public void e()
  {
    if (this.b != null)
    {
      this.b.d();
      this.b = null;
    }
    com.viber.voip.videoconvert.e.a().a("released video source");
    if (this.e != null)
    {
      this.e.a();
      this.e = null;
    }
    com.viber.voip.videoconvert.e.a().a("released texture renderer");
    this.d.doneCurrent();
    this.d.release(false);
    com.viber.voip.videoconvert.e.a().a("released gl wrapper");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.e.c
 * JD-Core Version:    0.6.2
 */