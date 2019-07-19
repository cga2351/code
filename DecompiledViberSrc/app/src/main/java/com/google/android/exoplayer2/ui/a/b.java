package com.google.android.exoplayer2.ui.a;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.google.android.exoplayer2.video.a.d;
import com.google.android.exoplayer2.video.a.d.a;
import com.google.android.exoplayer2.video.a.d.b;
import java.nio.FloatBuffer;

@TargetApi(15)
final class b
{
  private static final String[] a = { "uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}" };
  private static final String[] b = { "#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}" };
  private static final float[] c = { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F };
  private static final float[] d = { 1.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 1.0F };
  private static final float[] e = { 1.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 1.0F };
  private static final float[] f = { 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F };
  private static final float[] g = { 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.5F, 1.0F, 1.0F };
  private int h;
  private a i;
  private a j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;

  public static boolean a(d paramd)
  {
    d.a locala1 = paramd.a;
    d.a locala2 = paramd.b;
    return (locala1.a() == 1) && (locala1.a(0).a == 0) && (locala2.a() == 1) && (locala2.a(0).a == 0);
  }

  void a()
  {
    this.k = a.a(a, b);
    this.l = GLES20.glGetUniformLocation(this.k, "uMvpMatrix");
    this.m = GLES20.glGetUniformLocation(this.k, "uTexMatrix");
    this.n = GLES20.glGetAttribLocation(this.k, "aPosition");
    this.o = GLES20.glGetAttribLocation(this.k, "aTexCoords");
    this.p = GLES20.glGetUniformLocation(this.k, "uTexture");
  }

  void a(int paramInt1, float[] paramArrayOfFloat, int paramInt2)
  {
    if (paramInt2 == 2);
    for (a locala = this.j; locala == null; locala = this.i)
      return;
    GLES20.glUseProgram(this.k);
    a.a();
    GLES20.glEnableVertexAttribArray(this.n);
    GLES20.glEnableVertexAttribArray(this.o);
    a.a();
    float[] arrayOfFloat;
    if (this.h == 1)
      if (paramInt2 == 2)
        arrayOfFloat = e;
    while (true)
    {
      GLES20.glUniformMatrix3fv(this.m, 1, false, arrayOfFloat, 0);
      GLES20.glUniformMatrix4fv(this.l, 1, false, paramArrayOfFloat, 0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramInt1);
      GLES20.glUniform1i(this.p, 0);
      a.a();
      GLES20.glVertexAttribPointer(this.n, 3, 5126, false, 12, a.a(locala));
      a.a();
      GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 8, a.b(locala));
      a.a();
      GLES20.glDrawArrays(a.c(locala), 0, a.d(locala));
      a.a();
      GLES20.glDisableVertexAttribArray(this.n);
      GLES20.glDisableVertexAttribArray(this.o);
      return;
      arrayOfFloat = d;
      continue;
      if (this.h == 2)
      {
        if (paramInt2 == 2)
          arrayOfFloat = g;
        else
          arrayOfFloat = f;
      }
      else
        arrayOfFloat = c;
    }
  }

  public void b(d paramd)
  {
    if (!a(paramd))
      return;
    this.h = paramd.c;
    this.i = new a(paramd.a.a(0));
    if (paramd.d);
    for (a locala = this.i; ; locala = new a(paramd.b.a(0)))
    {
      this.j = locala;
      return;
    }
  }

  private static class a
  {
    private final int a;
    private final FloatBuffer b;
    private final FloatBuffer c;
    private final int d;

    public a(d.b paramb)
    {
      this.a = paramb.a();
      this.b = a.a(paramb.c);
      this.c = a.a(paramb.d);
      switch (paramb.b)
      {
      default:
        this.d = 4;
        return;
      case 1:
        this.d = 5;
        return;
      case 2:
      }
      this.d = 6;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.a.b
 * JD-Core Version:    0.6.2
 */