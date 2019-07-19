package com.google.android.exoplayer2.video.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.p;
import java.nio.ByteBuffer;

public class b extends com.google.android.exoplayer2.b
{
  private final p a = new p();
  private final e b = new e(1);
  private final r c = new r();
  private long d;
  private a e;
  private long f;

  public b()
  {
    super(5);
  }

  private float[] a(ByteBuffer paramByteBuffer)
  {
    float[] arrayOfFloat;
    if (paramByteBuffer.remaining() != 16)
      arrayOfFloat = null;
    while (true)
    {
      return arrayOfFloat;
      this.c.a(paramByteBuffer.array(), paramByteBuffer.limit());
      this.c.c(4 + paramByteBuffer.arrayOffset());
      arrayOfFloat = new float[3];
      for (int i = 0; i < 3; i++)
        arrayOfFloat[i] = Float.intBitsToFloat(this.c.q());
    }
  }

  private void w()
  {
    this.f = 0L;
    if (this.e != null)
      this.e.b();
  }

  public int a(Format paramFormat)
  {
    if ("application/x-camera-motion".equals(paramFormat.sampleMimeType))
      return 4;
    return 0;
  }

  public void a(int paramInt, Object paramObject)
    throws i
  {
    if (paramInt == 7)
    {
      this.e = ((a)paramObject);
      return;
    }
    super.a(paramInt, paramObject);
  }

  public void a(long paramLong1, long paramLong2)
    throws i
  {
    while (true)
    {
      if ((!g()) && (this.f < 100000L + paramLong1))
      {
        this.b.a();
        if ((a(this.a, this.b, false) == -4) && (!this.b.c()));
      }
      else
      {
        return;
      }
      this.b.h();
      this.f = this.b.c;
      if (this.e != null)
      {
        float[] arrayOfFloat = a(this.b.b);
        if (arrayOfFloat != null)
          ((a)ag.a(this.e)).a(this.f - this.d, arrayOfFloat);
      }
    }
  }

  protected void a(long paramLong, boolean paramBoolean)
    throws i
  {
    w();
  }

  protected void a(Format[] paramArrayOfFormat, long paramLong)
    throws i
  {
    this.d = paramLong;
  }

  protected void p()
  {
    w();
  }

  public boolean u()
  {
    return true;
  }

  public boolean v()
  {
    return g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.a.b
 * JD-Core Version:    0.6.2
 */