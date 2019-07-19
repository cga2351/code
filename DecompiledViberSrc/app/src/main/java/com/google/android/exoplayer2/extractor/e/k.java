package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.io.IOException;
import java.util.ArrayList;

final class k extends i
{
  private a a;
  private int b;
  private boolean c;
  private l.d d;
  private l.b e;

  static int a(byte paramByte, int paramInt1, int paramInt2)
  {
    return paramByte >> paramInt2 & 255 >>> 8 - paramInt1;
  }

  private static int a(byte paramByte, a parama)
  {
    int i = a(paramByte, parama.e, 1);
    if (!parama.d[i].a)
      return parama.a.g;
    return parama.a.h;
  }

  static void a(r paramr, long paramLong)
  {
    paramr.b(4 + paramr.c());
    paramr.a[(-4 + paramr.c())] = ((byte)(int)(paramLong & 0xFF));
    paramr.a[(-3 + paramr.c())] = ((byte)(int)(0xFF & paramLong >>> 8));
    paramr.a[(-2 + paramr.c())] = ((byte)(int)(0xFF & paramLong >>> 16));
    paramr.a[(-1 + paramr.c())] = ((byte)(int)(0xFF & paramLong >>> 24));
  }

  public static boolean a(r paramr)
  {
    try
    {
      boolean bool = l.a(1, paramr, true);
      return bool;
    }
    catch (w localw)
    {
    }
    return false;
  }

  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      this.a = null;
      this.d = null;
      this.e = null;
    }
    this.b = 0;
    this.c = false;
  }

  protected boolean a(r paramr, long paramLong, i.a parama)
    throws IOException, InterruptedException
  {
    if (this.a != null)
      return false;
    this.a = c(paramr);
    if (this.a == null)
      return true;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.a.a.j);
    localArrayList.add(this.a.c);
    parama.a = Format.createAudioSampleFormat(null, "audio/vorbis", null, this.a.a.e, -1, this.a.a.b, (int)this.a.a.c, localArrayList, null, 0, null);
    return true;
  }

  protected long b(r paramr)
  {
    if ((0x1 & paramr.a[0]) == 1)
      return -1L;
    int i = a(paramr.a[0], this.a);
    boolean bool = this.c;
    int j = 0;
    if (bool)
      j = (i + this.b) / 4;
    a(paramr, j);
    this.c = true;
    this.b = i;
    return j;
  }

  a c(r paramr)
    throws IOException
  {
    if (this.d == null)
    {
      this.d = l.a(paramr);
      return null;
    }
    if (this.e == null)
    {
      this.e = l.b(paramr);
      return null;
    }
    byte[] arrayOfByte = new byte[paramr.c()];
    System.arraycopy(paramr.a, 0, arrayOfByte, 0, paramr.c());
    l.c[] arrayOfc = l.a(paramr, this.d.b);
    int i = l.a(-1 + arrayOfc.length);
    return new a(this.d, this.e, arrayOfByte, arrayOfc, i);
  }

  protected void c(long paramLong)
  {
    super.c(paramLong);
    if (paramLong != 0L);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      l.d locald = this.d;
      int i = 0;
      if (locald != null)
        i = this.d.g;
      this.b = i;
      return;
    }
  }

  static final class a
  {
    public final l.d a;
    public final l.b b;
    public final byte[] c;
    public final l.c[] d;
    public final int e;

    public a(l.d paramd, l.b paramb, byte[] paramArrayOfByte, l.c[] paramArrayOfc, int paramInt)
    {
      this.a = paramd;
      this.b = paramb;
      this.c = paramArrayOfByte;
      this.d = paramArrayOfc;
      this.e = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.k
 * JD-Core Version:    0.6.2
 */