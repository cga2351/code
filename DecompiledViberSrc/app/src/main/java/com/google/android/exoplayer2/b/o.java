package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import com.google.android.exoplayer2.g.ag;

final class o
{
  private final a a;
  private int b;
  private long c;
  private long d;
  private long e;
  private long f;

  public o(AudioTrack paramAudioTrack)
  {
    if (ag.a >= 19)
    {
      this.a = new a(paramAudioTrack);
      e();
      return;
    }
    this.a = null;
    a(3);
  }

  private void a(int paramInt)
  {
    this.b = paramInt;
    switch (paramInt)
    {
    default:
      throw new IllegalStateException();
    case 0:
      this.e = 0L;
      this.f = -1L;
      this.c = (System.nanoTime() / 1000L);
      this.d = 5000L;
      return;
    case 1:
      this.d = 5000L;
      return;
    case 2:
    case 3:
      this.d = 10000000L;
      return;
    case 4:
    }
    this.d = 500000L;
  }

  public void a()
  {
    a(4);
  }

  public boolean a(long paramLong)
  {
    boolean bool;
    if ((this.a == null) || (paramLong - this.e < this.d))
      bool = false;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool;
            this.e = paramLong;
            bool = this.a.a();
            switch (this.b)
            {
            case 4:
            default:
              throw new IllegalStateException();
            case 0:
              if (bool)
              {
                if (this.a.b() >= this.c)
                {
                  this.f = this.a.c();
                  a(1);
                  return bool;
                }
                return false;
              }
              break;
            case 1:
            case 2:
            case 3:
            }
          }
          while (paramLong - this.c <= 500000L);
          a(3);
          return bool;
          if (!bool)
            break;
        }
        while (this.a.c() <= this.f);
        a(2);
        return bool;
        e();
        return bool;
      }
      while (bool);
      e();
      return bool;
    }
    while (!bool);
    e();
    return bool;
  }

  public void b()
  {
    if (this.b == 4)
      e();
  }

  public boolean c()
  {
    return (this.b == 1) || (this.b == 2);
  }

  public boolean d()
  {
    return this.b == 2;
  }

  public void e()
  {
    if (this.a != null)
      a(0);
  }

  public long f()
  {
    if (this.a != null)
      return this.a.b();
    return -9223372036854775807L;
  }

  public long g()
  {
    if (this.a != null)
      return this.a.c();
    return -1L;
  }

  @TargetApi(19)
  private static final class a
  {
    private final AudioTrack a;
    private final AudioTimestamp b;
    private long c;
    private long d;
    private long e;

    public a(AudioTrack paramAudioTrack)
    {
      this.a = paramAudioTrack;
      this.b = new AudioTimestamp();
    }

    public boolean a()
    {
      boolean bool = this.a.getTimestamp(this.b);
      if (bool)
      {
        long l = this.b.framePosition;
        if (this.d > l)
          this.c = (1L + this.c);
        this.d = l;
        this.e = (l + (this.c << 32));
      }
      return bool;
    }

    public long b()
    {
      return this.b.nanoTime / 1000L;
    }

    public long c()
    {
      return this.e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.o
 * JD-Core Version:    0.6.2
 */