package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;

public final class b
{
  public static final b a = new a().a();
  public final int b;
  public final int c;
  public final int d;
  private AudioAttributes e;

  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }

  @TargetApi(21)
  public AudioAttributes a()
  {
    if (this.e == null)
      this.e = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.c).setUsage(this.d).build();
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    b localb;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localb = (b)paramObject;
    }
    while ((this.b == localb.b) && (this.c == localb.c) && (this.d == localb.d));
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * (527 + this.b) + this.c) + this.d;
  }

  public static final class a
  {
    private int a = 0;
    private int b = 0;
    private int c = 1;

    public a a(int paramInt)
    {
      this.a = paramInt;
      return this;
    }

    public b a()
    {
      return new b(this.a, this.b, this.c, null);
    }

    public a b(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.b
 * JD-Core Version:    0.6.2
 */