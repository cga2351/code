package com.viber.voip.videoconvert.gpu.e;

import android.annotation.TargetApi;
import com.viber.voip.videoconvert.gpu.encoders.b;
import com.viber.voip.videoconvert.gpu.encoders.c.a;
import com.viber.voip.videoconvert.gpu.encoders.c.b;
import com.viber.voip.videoconvert.gpu.encoders.c.c;
import com.viber.voip.videoconvert.gpu.f.d.a;
import com.viber.voip.videoconvert.gpu.opengl.PBufferGLWrapperNative;
import com.viber.voip.videoconvert.gpu.opengl.e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@TargetApi(16)
public class d extends a
{
  com.viber.voip.videoconvert.gpu.opengl.c d;
  e e;
  ByteBuffer f;

  public void a(com.viber.voip.videoconvert.gpu.encoders.c paramc)
  {
    c.a locala = paramc.b();
    this.d = new PBufferGLWrapperNative(locala.b, locala.c);
    this.f = ByteBuffer.allocateDirect(4 * (locala.b * locala.c));
    this.f.order(ByteOrder.nativeOrder());
    if ((b)paramc == null)
      throw new RuntimeException("PBufferDataProvider can be used only with ");
    this.d.init();
    this.d.optimize();
    this.d.makeCurrent();
    this.e = new e();
    super.a(paramc);
  }

  public void a(com.viber.voip.videoconvert.gpu.f.d paramd, d.a parama)
  {
    super.a(paramd, parama);
    if ((com.viber.voip.videoconvert.gpu.f.c)paramd == null)
      throw new RuntimeException("InputSurfaceDataProvider can be used only with TextureVideoSource");
  }

  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, c.c paramc)
  {
    this.b.a(this.e, paramArrayOfFloat1, paramArrayOfFloat2, paramc);
    this.d.swapBuffers();
    c.a locala = this.a.b();
    this.f.rewind();
    this.d.readPixels(0, 0, locala.b, locala.c, this.d.getPixelFormat(), this.d.getDataType(), this.f);
    c.b localb1 = c.b.a;
    if ((this.d.getPixelFormat() == 6408) && (this.d.getDataType() == 32819))
      localb1 = c.b.b;
    if ((this.d.getPixelFormat() == 6408) && (this.d.getDataType() == 32820))
      localb1 = c.b.d;
    if ((this.d.getPixelFormat() == 6407) && (this.d.getDataType() == 33635))
      localb1 = c.b.c;
    if ((this.d.getPixelFormat() == 6408) && (this.d.getDataType() == 5121));
    for (c.b localb2 = c.b.a; ; localb2 = localb1)
    {
      ((b)this.a).a(this.f, localb2, locala.b, locala.c, this.b.e(), false);
      return;
    }
  }

  public void d()
  {
    super.d();
    this.d.doneCurrent();
  }

  public void e()
  {
    this.d.makeCurrent();
    this.e.a();
    if (this.b != null)
    {
      this.b.d();
      this.b = null;
    }
    this.d.doneCurrent();
    this.d.release(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.e.d
 * JD-Core Version:    0.6.2
 */