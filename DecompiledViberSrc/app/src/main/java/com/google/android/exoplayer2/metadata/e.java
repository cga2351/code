package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.i;
import com.google.android.exoplayer2.p;
import java.util.Arrays;

public final class e extends com.google.android.exoplayer2.b
  implements Handler.Callback
{
  private final b a;
  private final d b;
  private final Handler c;
  private final p d;
  private final c e;
  private final Metadata[] f;
  private final long[] g;
  private int h;
  private int i;
  private a j;
  private boolean k;

  public e(d paramd, Looper paramLooper)
  {
    this(paramd, paramLooper, b.a);
  }

  public e(d paramd, Looper paramLooper, b paramb)
  {
    super(4);
    this.b = ((d)com.google.android.exoplayer2.g.a.a(paramd));
    if (paramLooper == null);
    for (Handler localHandler = null; ; localHandler = ag.a(paramLooper, this))
    {
      this.c = localHandler;
      this.a = ((b)com.google.android.exoplayer2.g.a.a(paramb));
      this.d = new p();
      this.e = new c();
      this.f = new Metadata[5];
      this.g = new long[5];
      return;
    }
  }

  private void a(Metadata paramMetadata)
  {
    if (this.c != null)
    {
      this.c.obtainMessage(0, paramMetadata).sendToTarget();
      return;
    }
    b(paramMetadata);
  }

  private void b(Metadata paramMetadata)
  {
    this.b.a(paramMetadata);
  }

  private void w()
  {
    Arrays.fill(this.f, null);
    this.h = 0;
    this.i = 0;
  }

  public int a(Format paramFormat)
  {
    if (this.a.a(paramFormat))
    {
      if (a(null, paramFormat.drmInitData))
        return 4;
      return 2;
    }
    return 0;
  }

  public void a(long paramLong1, long paramLong2)
    throws i
  {
    if ((!this.k) && (this.i < 5))
    {
      this.e.a();
      if (a(this.d, this.e, false) == -4)
      {
        if (!this.e.c())
          break label122;
        this.k = true;
      }
    }
    while (true)
    {
      if ((this.i > 0) && (this.g[this.h] <= paramLong1))
      {
        a(this.f[this.h]);
        this.f[this.h] = null;
        this.h = ((1 + this.h) % 5);
        this.i = (-1 + this.i);
      }
      return;
      label122: if (!this.e.j_())
      {
        this.e.d = this.d.a.subsampleOffsetUs;
        this.e.h();
        int m = (this.h + this.i) % 5;
        Metadata localMetadata = this.j.a(this.e);
        if (localMetadata != null)
        {
          this.f[m] = localMetadata;
          this.g[m] = this.e.c;
          this.i = (1 + this.i);
        }
      }
    }
  }

  protected void a(long paramLong, boolean paramBoolean)
  {
    w();
    this.k = false;
  }

  protected void a(Format[] paramArrayOfFormat, long paramLong)
    throws i
  {
    this.j = this.a.b(paramArrayOfFormat[0]);
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      throw new IllegalStateException();
    case 0:
    }
    b((Metadata)paramMessage.obj);
    return true;
  }

  protected void p()
  {
    w();
    this.j = null;
  }

  public boolean u()
  {
    return true;
  }

  public boolean v()
  {
    return this.k;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.e
 * JD-Core Version:    0.6.2
 */