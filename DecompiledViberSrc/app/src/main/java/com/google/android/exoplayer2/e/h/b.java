package com.google.android.exoplayer2.e.h;

import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b extends com.google.android.exoplayer2.e.c
{
  private static final int a = ag.g("payl");
  private static final int b = ag.g("sttg");
  private static final int c = ag.g("vttc");
  private final r d = new r();
  private final e.a e = new e.a();

  public b()
  {
    super("Mp4WebvttDecoder");
  }

  private static com.google.android.exoplayer2.e.b a(r paramr, e.a parama, int paramInt)
    throws g
  {
    parama.a();
    while (paramInt > 0)
    {
      if (paramInt < 8)
        throw new g("Incomplete vtt cue box header found.");
      int i = paramr.p();
      int j = paramr.p();
      int k = paramInt - 8;
      int m = i - 8;
      String str = ag.a(paramr.a, paramr.d(), m);
      paramr.d(m);
      paramInt = k - m;
      if (j == b)
        f.a(str, parama);
      else if (j == a)
        f.a(null, str.trim(), parama, Collections.emptyList());
    }
    return parama.b();
  }

  protected c b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws g
  {
    this.d.a(paramArrayOfByte, paramInt);
    ArrayList localArrayList = new ArrayList();
    while (this.d.b() > 0)
    {
      if (this.d.b() < 8)
        throw new g("Incomplete Mp4Webvtt Top Level box header found.");
      int i = this.d.p();
      if (this.d.p() == c)
        localArrayList.add(a(this.d, this.e, i - 8));
      else
        this.d.d(i - 8);
    }
    return new c(localArrayList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.h.b
 * JD-Core Version:    0.6.2
 */