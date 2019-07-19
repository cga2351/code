package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.r;
import java.io.EOFException;
import java.io.IOException;

public final class f
  implements q
{
  public int a(h paramh, int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int i = paramh.a(paramInt);
    if (i == -1)
    {
      if (paramBoolean)
        return -1;
      throw new EOFException();
    }
    return i;
  }

  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, q.a parama)
  {
  }

  public void a(Format paramFormat)
  {
  }

  public void a(r paramr, int paramInt)
  {
    paramr.d(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f
 * JD-Core Version:    0.6.2
 */