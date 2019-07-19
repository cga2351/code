package com.google.android.exoplayer2.ui.a;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ac;
import com.google.android.exoplayer2.video.a.e;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

class c
  implements com.google.android.exoplayer2.video.a.a, com.google.android.exoplayer2.video.d
{
  private final AtomicBoolean a = new AtomicBoolean();
  private final AtomicBoolean b = new AtomicBoolean(true);
  private final b c = new b();
  private final com.google.android.exoplayer2.video.a.c d = new com.google.android.exoplayer2.video.a.c();
  private final ac<Long> e = new ac();
  private final ac<com.google.android.exoplayer2.video.a.d> f = new ac();
  private final float[] g = new float[16];
  private final float[] h = new float[16];
  private int i;
  private SurfaceTexture j;
  private volatile int k = 0;
  private int l = -1;
  private byte[] m;

  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    byte[] arrayOfByte1 = this.m;
    int n = this.l;
    this.m = paramArrayOfByte;
    if (paramInt == -1)
      paramInt = this.k;
    this.l = paramInt;
    if ((n == this.l) && (Arrays.equals(arrayOfByte1, this.m)))
      return;
    byte[] arrayOfByte2 = this.m;
    com.google.android.exoplayer2.video.a.d locald = null;
    if (arrayOfByte2 != null)
      locald = e.a(this.m, this.l);
    if ((locald != null) && (b.a(locald)));
    while (true)
    {
      this.f.a(paramLong, locald);
      return;
      locald = com.google.android.exoplayer2.video.a.d.a(this.l);
    }
  }

  public SurfaceTexture a()
  {
    GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
    a.a();
    this.c.a();
    a.a();
    this.i = a.b();
    this.j = new SurfaceTexture(this.i);
    this.j.setOnFrameAvailableListener(new d(this));
    return this.j;
  }

  public void a(int paramInt)
  {
    this.k = paramInt;
  }

  public void a(long paramLong1, long paramLong2, Format paramFormat)
  {
    this.e.a(paramLong2, Long.valueOf(paramLong1));
    a(paramFormat.projectionData, paramFormat.stereoMode, paramLong2);
  }

  public void a(long paramLong, float[] paramArrayOfFloat)
  {
    this.d.a(paramLong, paramArrayOfFloat);
  }

  public void a(float[] paramArrayOfFloat, int paramInt)
  {
    GLES20.glClear(16384);
    a.a();
    if (this.a.compareAndSet(true, false))
    {
      ((SurfaceTexture)com.google.android.exoplayer2.g.a.a(this.j)).updateTexImage();
      a.a();
      if (this.b.compareAndSet(true, false))
        Matrix.setIdentityM(this.g, 0);
      long l1 = this.j.getTimestamp();
      Long localLong = (Long)this.e.b(l1);
      if (localLong != null)
        this.d.a(this.g, localLong.longValue());
      com.google.android.exoplayer2.video.a.d locald = (com.google.android.exoplayer2.video.a.d)this.f.a(l1);
      if (locald != null)
        this.c.b(locald);
    }
    Matrix.multiplyMM(this.h, 0, paramArrayOfFloat, 0, this.g, 0);
    this.c.a(this.i, this.h, paramInt);
  }

  public void b()
  {
    this.e.a();
    this.d.a();
    this.b.set(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.a.c
 * JD-Core Version:    0.6.2
 */