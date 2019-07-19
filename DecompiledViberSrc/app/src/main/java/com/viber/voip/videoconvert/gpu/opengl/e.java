package com.viber.voip.videoconvert.gpu.opengl;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class e
{
  private static String a = "TextureRenderer";
  private FloatBuffer b = ByteBuffer.allocateDirect(80).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private float[] c = new float[16];
  private float[] d = new float[16];
  private int e;
  private int f;
  private int g;
  private int h;
  private b i = new b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
  private b j = new b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
  private b k;

  public void a()
  {
    this.i.a();
    this.j.a();
  }

  public void a(d paramd, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a("onDrawFrame start");
    for (int m = 0; m < 16; m++)
      this.c[m] = paramArrayOfFloat2[m];
    for (int n = 0; n < 16; n++)
      this.d[n] = paramArrayOfFloat1[n];
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    a(paramd.f());
    paramd.d();
    this.b.position(0);
    GLES20.glVertexAttribPointer(this.g, 3, 5126, false, 20, this.b);
    a("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.g);
    a("glEnableVertexAttribArray maPositionHandle");
    this.b.position(3);
    GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 20, this.b);
    a("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.h);
    a("glEnableVertexAttribArray maTextureHandle");
    GLES20.glUniformMatrix4fv(this.e, 1, false, this.c, 0);
    GLES20.glUniformMatrix4fv(this.f, 1, false, this.d, 0);
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glFlush();
    paramd.e();
    this.k.c();
  }

  public void a(String paramString)
  {
    int m = GLES20.glGetError();
    if (m != 0)
    {
      com.viber.voip.videoconvert.e.a().a(paramString + ": glError " + m);
      throw new RuntimeException(paramString + ": glError " + m);
    }
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (b localb = this.i; ; localb = this.j)
    {
      this.k = localb;
      this.g = this.k.a("aPosition");
      this.h = this.k.a("aTextureCoord");
      this.e = this.k.b("uMVPMatrix");
      this.f = this.k.b("uSTMatrix");
      this.k.b();
      return;
    }
  }

  public void a(float[] paramArrayOfFloat)
  {
    for (int m = 0; m < 4; m++)
      for (int n = 0; n < 2; n++)
        this.b.put(n + (3 + m * 5), paramArrayOfFloat[(n + m * 2)]);
  }

  public void b(float[] paramArrayOfFloat)
  {
    for (int m = 0; m < 4; m++)
      for (int n = 0; n < 3; n++)
        this.b.put(n + m * 5, paramArrayOfFloat[(n + m * 3)]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.opengl.e
 * JD-Core Version:    0.6.2
 */