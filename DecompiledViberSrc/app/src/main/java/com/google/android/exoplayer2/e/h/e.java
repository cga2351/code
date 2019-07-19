package com.google.android.exoplayer2.e.h;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.g.l;

public final class e extends b
{
  public final long o;
  public final long p;

  public e(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this(paramLong1, paramLong2, paramCharSequence, null, 1.4E-45F, -2147483648, -2147483648, 1.4E-45F, -2147483648, 1.4E-45F);
  }

  public e(long paramLong1, long paramLong2, CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    super(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3);
    this.o = paramLong1;
    this.p = paramLong2;
  }

  public e(CharSequence paramCharSequence)
  {
    this(0L, 0L, paramCharSequence);
  }

  public boolean a()
  {
    return (this.d == 1.4E-45F) && (this.g == 1.4E-45F);
  }

  public static class a
  {
    private long a;
    private long b;
    private SpannableStringBuilder c;
    private Layout.Alignment d;
    private float e;
    private int f;
    private int g;
    private float h;
    private int i;
    private float j;

    public a()
    {
      a();
    }

    private a c()
    {
      if (this.d == null)
      {
        this.i = -2147483648;
        return this;
      }
      switch (e.1.a[this.d.ordinal()])
      {
      default:
        l.c("WebvttCueBuilder", "Unrecognized alignment: " + this.d);
        this.i = 0;
        return this;
      case 1:
        this.i = 0;
        return this;
      case 2:
        this.i = 1;
        return this;
      case 3:
      }
      this.i = 2;
      return this;
    }

    public a a(float paramFloat)
    {
      this.e = paramFloat;
      return this;
    }

    public a a(int paramInt)
    {
      this.f = paramInt;
      return this;
    }

    public a a(long paramLong)
    {
      this.a = paramLong;
      return this;
    }

    public a a(Layout.Alignment paramAlignment)
    {
      this.d = paramAlignment;
      return this;
    }

    public a a(SpannableStringBuilder paramSpannableStringBuilder)
    {
      this.c = paramSpannableStringBuilder;
      return this;
    }

    public void a()
    {
      this.a = 0L;
      this.b = 0L;
      this.c = null;
      this.d = null;
      this.e = 1.4E-45F;
      this.f = -2147483648;
      this.g = -2147483648;
      this.h = 1.4E-45F;
      this.i = -2147483648;
      this.j = 1.4E-45F;
    }

    public a b(float paramFloat)
    {
      this.h = paramFloat;
      return this;
    }

    public a b(int paramInt)
    {
      this.g = paramInt;
      return this;
    }

    public a b(long paramLong)
    {
      this.b = paramLong;
      return this;
    }

    public e b()
    {
      if ((this.h != 1.4E-45F) && (this.i == -2147483648))
        c();
      return new e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }

    public a c(float paramFloat)
    {
      this.j = paramFloat;
      return this;
    }

    public a c(int paramInt)
    {
      this.i = paramInt;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.h.e
 * JD-Core Version:    0.6.2
 */