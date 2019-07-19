package com.google.android.exoplayer2.e.h;

import android.text.TextUtils;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.w;
import java.util.ArrayList;
import java.util.List;

public final class g extends c
{
  private final f a = new f();
  private final r b = new r();
  private final e.a c = new e.a();
  private final a d = new a();
  private final List<d> e = new ArrayList();

  public g()
  {
    super("WebvttDecoder");
  }

  private static int a(r paramr)
  {
    int i = 0;
    int j = -1;
    if (j == -1)
    {
      int k = paramr.d();
      String str = paramr.B();
      int m;
      if (str == null)
        m = 0;
      while (true)
      {
        j = m;
        i = k;
        break;
        if ("STYLE".equals(str))
          m = 2;
        else if (str.startsWith("NOTE"))
          m = 1;
        else
          m = 3;
      }
    }
    paramr.c(i);
    return j;
  }

  private static void b(r paramr)
  {
    while (!TextUtils.isEmpty(paramr.B()));
  }

  protected i b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws com.google.android.exoplayer2.e.g
  {
    this.b.a(paramArrayOfByte, paramInt);
    this.c.a();
    this.e.clear();
    ArrayList localArrayList;
    while (true)
    {
      int i;
      try
      {
        h.a(this.b);
        if (!TextUtils.isEmpty(this.b.B()))
          continue;
        localArrayList = new ArrayList();
        i = a(this.b);
        if (i == 0)
          break;
        if (i == 1)
        {
          b(this.b);
          continue;
        }
      }
      catch (w localw)
      {
        throw new com.google.android.exoplayer2.e.g(localw);
      }
      if (i == 2)
      {
        if (!localArrayList.isEmpty())
          throw new com.google.android.exoplayer2.e.g("A style block was found after the first cue.");
        this.b.B();
        d locald = this.d.a(this.b);
        if (locald != null)
          this.e.add(locald);
      }
      else if ((i == 3) && (this.a.a(this.b, this.c, this.e)))
      {
        localArrayList.add(this.c.b());
        this.c.a();
      }
    }
    return new i(localArrayList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.h.g
 * JD-Core Version:    0.6.2
 */