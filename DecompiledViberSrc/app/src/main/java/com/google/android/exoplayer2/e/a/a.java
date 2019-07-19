package com.google.android.exoplayer2.e.a;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.g.r;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a extends e
{
  private static final int[] a = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] b = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] c = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] d = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] e = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] f = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] g = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final r h = new r();
  private final int i;
  private final int j;
  private final ArrayList<a> k = new ArrayList();
  private a l = new a(0, 4);
  private List<b> m;
  private List<b> n;
  private int o;
  private int p;
  private boolean q;
  private byte r;
  private byte s;

  public a(String paramString, int paramInt)
  {
    int i1;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i1 = 2;
      this.i = i1;
      switch (paramInt)
      {
      default:
      case 3:
      case 4:
      }
    }
    for (this.j = 1; ; this.j = 2)
    {
      a(0);
      k();
      return;
      i1 = 3;
      break;
    }
  }

  private void a(byte paramByte)
  {
    int i1 = 1;
    this.l.a(' ');
    if ((paramByte & 0x1) == i1);
    while (true)
    {
      int i3 = 0x7 & paramByte >> 1;
      this.l.a(i3, i1);
      return;
      int i2 = 0;
    }
  }

  private void a(int paramInt)
  {
    if (this.o == paramInt);
    int i1;
    do
    {
      return;
      i1 = this.o;
      this.o = paramInt;
      k();
    }
    while ((i1 != 3) && (paramInt != 1) && (paramInt != 0));
    this.m = Collections.emptyList();
  }

  private boolean a(byte paramByte1, byte paramByte2)
  {
    boolean bool = g(paramByte1);
    if (bool)
    {
      if ((this.q) && (this.r == paramByte1) && (this.s == paramByte2))
      {
        this.q = false;
        return true;
      }
      this.q = true;
      this.r = paramByte1;
      this.s = paramByte2;
    }
    if (c(paramByte1, paramByte2))
      a(paramByte2);
    while (true)
    {
      return bool;
      if (d(paramByte1, paramByte2))
        b(paramByte1, paramByte2);
      else if (e(paramByte1, paramByte2))
        this.l.e(paramByte2 - 32);
      else if (f(paramByte1, paramByte2))
        b(paramByte2);
    }
  }

  private void b(byte paramByte)
  {
    switch (paramByte)
    {
    case 33:
    case 34:
    case 35:
    case 36:
    case 40:
    default:
      if (this.o != 0)
        break;
    case 37:
    case 38:
    case 39:
    case 32:
    case 41:
    }
    do
    {
      do
      {
        return;
        a(1);
        b(2);
        return;
        a(1);
        b(3);
        return;
        a(1);
        b(4);
        return;
        a(2);
        return;
        a(3);
        return;
        switch (paramByte)
        {
        case 36:
        default:
          return;
        case 33:
          this.l.b();
          return;
        case 44:
          this.m = Collections.emptyList();
        case 46:
        case 47:
        case 45:
        }
      }
      while ((this.o != 1) && (this.o != 3));
      k();
      return;
      k();
      return;
      this.m = j();
      k();
      return;
    }
    while ((this.o != 1) || (this.l.a()));
    this.l.d();
  }

  private void b(byte paramByte1, byte paramByte2)
  {
    int i1 = a[(paramByte1 & 0x7)];
    int i2;
    int i3;
    label107: boolean bool;
    label117: int i4;
    a locala;
    if ((paramByte2 & 0x20) != 0)
    {
      i2 = 1;
      if (i2 != 0)
        i1++;
      if (i1 != this.l.c())
      {
        if ((this.o != 1) && (!this.l.a()))
        {
          this.l = new a(this.o, this.p);
          this.k.add(this.l);
        }
        this.l.c(i1);
      }
      if ((paramByte2 & 0x10) != 16)
        break label174;
      i3 = 1;
      if ((paramByte2 & 0x1) != 1)
        break label180;
      bool = true;
      i4 = 0x7 & paramByte2 >> 1;
      locala = this.l;
      if (i3 == 0)
        break label186;
    }
    label174: label180: label186: for (int i5 = 8; ; i5 = i4)
    {
      locala.a(i5, bool);
      if (i3 != 0)
        this.l.d(b[i4]);
      return;
      i2 = 0;
      break;
      i3 = 0;
      break label107;
      bool = false;
      break label117;
    }
  }

  private void b(int paramInt)
  {
    this.p = paramInt;
    this.l.b(paramInt);
  }

  private static char c(byte paramByte)
  {
    int i1 = -32 + (paramByte & 0x7F);
    return (char)d[i1];
  }

  private static boolean c(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF7) == 17) && ((paramByte2 & 0xF0) == 32);
  }

  private static char d(byte paramByte)
  {
    int i1 = paramByte & 0xF;
    return (char)e[i1];
  }

  private static boolean d(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF0) == 16) && ((paramByte2 & 0xC0) == 64);
  }

  private static char e(byte paramByte)
  {
    int i1 = paramByte & 0x1F;
    return (char)f[i1];
  }

  private static boolean e(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF7) == 23) && (paramByte2 >= 33) && (paramByte2 <= 35);
  }

  private static char f(byte paramByte)
  {
    int i1 = paramByte & 0x1F;
    return (char)g[i1];
  }

  private static boolean f(byte paramByte1, byte paramByte2)
  {
    return ((paramByte1 & 0xF7) == 20) && ((paramByte2 & 0xF0) == 32);
  }

  private static boolean g(byte paramByte)
  {
    return (paramByte & 0xF0) == 16;
  }

  private List<b> j()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < this.k.size(); i1++)
    {
      b localb = ((a)this.k.get(i1)).f();
      if (localb != null)
        localArrayList.add(localb);
    }
    return localArrayList;
  }

  private void k()
  {
    this.l.a(this.o);
    this.k.clear();
    this.k.add(this.l);
  }

  protected void a(i parami)
  {
    this.h.a(parami.b.array(), parami.b.limit());
    boolean bool = false;
    int i1 = 0;
    while (this.h.b() >= this.i)
    {
      if (this.i == 2);
      int i3;
      int i4;
      for (int i2 = -4; ; i2 = (byte)this.h.h())
      {
        i3 = (byte)(0x7F & this.h.h());
        i4 = (byte)(0x7F & this.h.h());
        if (((i2 & 0x6) != 4) || ((this.j == 1) && ((i2 & 0x1) != 0)) || ((this.j == 2) && ((i2 & 0x1) != 1)) || ((i3 == 0) && (i4 == 0)))
          break;
        if (((i3 & 0xF7) != 17) || ((i4 & 0xF0) != 48))
          break label179;
        this.l.a(d(i4));
        i1 = 1;
        break;
      }
      label179: if (((i3 & 0xF6) == 18) && ((i4 & 0xE0) == 32))
      {
        this.l.b();
        if ((i3 & 0x1) == 0)
        {
          this.l.a(e(i4));
          i1 = 1;
        }
        else
        {
          this.l.a(f(i4));
          i1 = 1;
        }
      }
      else if ((i3 & 0xE0) == 0)
      {
        bool = a(i3, i4);
        i1 = 1;
      }
      else
      {
        this.l.a(c(i3));
        if ((i4 & 0xE0) != 0)
          this.l.a(c(i4));
        i1 = 1;
      }
    }
    if (i1 != 0)
    {
      if (!bool)
        this.q = false;
      if ((this.o == 1) || (this.o == 3))
        this.m = j();
    }
  }

  public void c()
  {
    super.c();
    this.m = null;
    this.n = null;
    a(0);
    b(4);
    k();
    this.q = false;
    this.r = 0;
    this.s = 0;
  }

  public void d()
  {
  }

  protected boolean e()
  {
    return this.m != this.n;
  }

  protected com.google.android.exoplayer2.e.e f()
  {
    this.n = this.m;
    return new f(this.m);
  }

  private static class a
  {
    private final List<a> a = new ArrayList();
    private final List<SpannableString> b = new ArrayList();
    private final StringBuilder c = new StringBuilder();
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public a(int paramInt1, int paramInt2)
    {
      a(paramInt1);
      b(paramInt2);
    }

    private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
    {
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt1, paramInt2, 33);
    }

    private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt3 == -1)
        return;
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt3), paramInt1, paramInt2, 33);
    }

    private static void b(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
    {
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), paramInt1, paramInt2, 33);
    }

    public void a(char paramChar)
    {
      this.c.append(paramChar);
    }

    public void a(int paramInt)
    {
      this.g = paramInt;
      this.a.clear();
      this.b.clear();
      this.c.setLength(0);
      this.d = 15;
      this.e = 0;
      this.f = 0;
    }

    public void a(int paramInt, boolean paramBoolean)
    {
      this.a.add(new a(paramInt, paramBoolean, this.c.length()));
    }

    public boolean a()
    {
      return (this.a.isEmpty()) && (this.b.isEmpty()) && (this.c.length() == 0);
    }

    public void b()
    {
      int i = this.c.length();
      if (i > 0)
      {
        this.c.delete(i - 1, i);
        for (int j = -1 + this.a.size(); j >= 0; j--)
        {
          a locala = (a)this.a.get(j);
          if (locala.c != i)
            break;
          locala.c = (-1 + locala.c);
        }
      }
    }

    public void b(int paramInt)
    {
      this.h = paramInt;
    }

    public int c()
    {
      return this.d;
    }

    public void c(int paramInt)
    {
      this.d = paramInt;
    }

    public void d()
    {
      this.b.add(e());
      this.c.setLength(0);
      this.a.clear();
      int i = Math.min(this.h, this.d);
      while (this.b.size() >= i)
        this.b.remove(0);
    }

    public void d(int paramInt)
    {
      this.e = paramInt;
    }

    public SpannableString e()
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.c);
      int i = localSpannableStringBuilder.length();
      int j = -1;
      int k = -1;
      int m = 0;
      int n = -1;
      int i1 = 0;
      int i2 = -1;
      int i3 = 0;
      if (i3 < this.a.size())
      {
        a locala = (a)this.a.get(i3);
        boolean bool = locala.b;
        int i4 = locala.a;
        label98: label105: int i5;
        int i6;
        if (i4 != 8)
        {
          if (i4 == 7)
          {
            i1 = 1;
            if (i4 != 7)
              break label168;
          }
        }
        else
        {
          i5 = locala.c;
          if (i3 + 1 >= this.a.size())
            break label179;
          i6 = ((a)this.a.get(i3 + 1)).c;
          label149: if (i5 != i6)
            break label185;
        }
        label270: label286: 
        while (true)
        {
          i3++;
          break;
          i1 = 0;
          break label98;
          label168: i2 = a.i()[i4];
          break label105;
          label179: i6 = i;
          break label149;
          label185: if ((j != -1) && (!bool))
          {
            a(localSpannableStringBuilder, j, i5);
            j = -1;
            label204: if ((k == -1) || (i1 != 0))
              break label270;
            b(localSpannableStringBuilder, k, i5);
          }
          for (k = -1; ; k = i5)
            do
            {
              if (i2 == n)
                break label286;
              a(localSpannableStringBuilder, m, i5, n);
              n = i2;
              m = i5;
              break;
              if ((j != -1) || (!bool))
                break label204;
              j = i5;
              break label204;
            }
            while ((k != -1) || (i1 == 0));
        }
      }
      if ((j != -1) && (j != i))
        a(localSpannableStringBuilder, j, i);
      if ((k != -1) && (k != i))
        b(localSpannableStringBuilder, k, i);
      if (m != i)
        a(localSpannableStringBuilder, m, i, n);
      return new SpannableString(localSpannableStringBuilder);
    }

    public void e(int paramInt)
    {
      this.f = paramInt;
    }

    public b f()
    {
      int i = 2;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      for (int j = 0; j < this.b.size(); j++)
      {
        localSpannableStringBuilder.append((CharSequence)this.b.get(j));
        localSpannableStringBuilder.append('\n');
      }
      localSpannableStringBuilder.append(e());
      if (localSpannableStringBuilder.length() == 0)
        return null;
      int k = this.e + this.f;
      int m = 32 - k - localSpannableStringBuilder.length();
      int n = k - m;
      float f1;
      int i1;
      int i2;
      if ((this.g == i) && ((Math.abs(n) < 3) || (m < 0)))
      {
        f1 = 0.5F;
        i1 = 1;
        if ((this.g != 1) && (this.d <= 7))
          break label241;
        i2 = -2 + (-15 + this.d);
      }
      while (true)
      {
        return new b(localSpannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i, f1, i1, 1.4E-45F);
        if ((this.g == i) && (n > 0))
        {
          f1 = 0.1F + 0.8F * ((32 - m) / 32.0F);
          i1 = i;
          break;
        }
        f1 = 0.1F + 0.8F * (k / 32.0F);
        i1 = 0;
        break;
        label241: i2 = this.d;
        i = 0;
      }
    }

    public String toString()
    {
      return this.c.toString();
    }

    private static class a
    {
      public final int a;
      public final boolean b;
      public int c;

      public a(int paramInt1, boolean paramBoolean, int paramInt2)
      {
        this.a = paramInt1;
        this.b = paramBoolean;
        this.c = paramInt2;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.a.a
 * JD-Core Version:    0.6.2
 */