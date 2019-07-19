package com.google.android.exoplayer2.e.b;

import com.google.android.exoplayer2.g.r;
import java.util.List;

public final class a extends com.google.android.exoplayer2.e.c
{
  private final b a;

  public a(List<byte[]> paramList)
  {
    super("DvbDecoder");
    r localr = new r((byte[])paramList.get(0));
    this.a = new b(localr.i(), localr.i());
  }

  protected c b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      this.a.a();
    return new c(this.a.a(paramArrayOfByte, paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.b.a
 * JD-Core Version:    0.6.2
 */