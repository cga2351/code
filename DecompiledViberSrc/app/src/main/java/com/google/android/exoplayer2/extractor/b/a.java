package com.google.android.exoplayer2.extractor.b;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.Collections;

final class a extends e
{
  private static final int[] b = { 5512, 11025, 22050, 44100 };
  private boolean c;
  private boolean d;
  private int e;

  public a(q paramq)
  {
    super(paramq);
  }

  protected void a(r paramr, long paramLong)
    throws w
  {
    if (this.e == 2)
    {
      int k = paramr.b();
      this.a.a(paramr, k);
      this.a.a(paramLong, 1, k, 0, null);
    }
    int i;
    do
    {
      return;
      i = paramr.h();
      if ((i == 0) && (!this.d))
      {
        byte[] arrayOfByte = new byte[paramr.b()];
        paramr.a(arrayOfByte, 0, arrayOfByte.length);
        Pair localPair = c.a(arrayOfByte);
        Format localFormat = Format.createAudioSampleFormat(null, "audio/mp4a-latm", null, -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(arrayOfByte), null, 0, null);
        this.a.a(localFormat);
        this.d = true;
        return;
      }
    }
    while ((this.e == 10) && (i != 1));
    int j = paramr.b();
    this.a.a(paramr, j);
    this.a.a(paramLong, 1, j, 0, null);
  }

  protected boolean a(r paramr)
    throws e.a
  {
    int i;
    if (!this.c)
    {
      i = paramr.h();
      this.e = (0xF & i >> 4);
      if (this.e == 2)
      {
        int k = 0x3 & i >> 2;
        Format localFormat2 = Format.createAudioSampleFormat(null, "audio/mpeg", null, -1, -1, 1, b[k], null, null, 0, null);
        this.a.a(localFormat2);
        this.d = true;
        this.c = true;
      }
    }
    while (true)
    {
      return true;
      if ((this.e == 7) || (this.e == 8))
      {
        String str;
        if (this.e == 7)
        {
          str = "audio/g711-alaw";
          label112: if ((i & 0x1) != 1)
            break label167;
        }
        label167: for (int j = 2; ; j = 3)
        {
          Format localFormat1 = Format.createAudioSampleFormat(null, str, null, -1, -1, 1, 8000, j, null, null, 0, null);
          this.a.a(localFormat1);
          this.d = true;
          break;
          str = "audio/g711-mlaw";
          break label112;
        }
      }
      if (this.e == 10)
        break;
      throw new e.a("Audio format not supported: " + this.e);
      paramr.d(1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.b.a
 * JD-Core Version:    0.6.2
 */