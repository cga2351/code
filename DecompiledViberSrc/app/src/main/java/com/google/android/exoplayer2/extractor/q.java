package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;
import java.util.Arrays;

public abstract interface q
{
  public abstract int a(h paramh, int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException;

  public abstract void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, a parama);

  public abstract void a(Format paramFormat);

  public abstract void a(r paramr, int paramInt);

  public static final class a
  {
    public final int a;
    public final byte[] b;
    public final int c;
    public final int d;

    public a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramArrayOfByte;
      this.c = paramInt2;
      this.d = paramInt3;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
      }
      while ((this.a == locala.a) && (this.c == locala.c) && (this.d == locala.d) && (Arrays.equals(this.b, locala.b)));
      return false;
    }

    public int hashCode()
    {
      return 31 * (31 * (31 * this.a + Arrays.hashCode(this.b)) + this.c) + this.d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.q
 * JD-Core Version:    0.6.2
 */