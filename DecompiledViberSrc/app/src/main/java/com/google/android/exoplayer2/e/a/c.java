package com.google.android.exoplayer2.e.a;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.e.i;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c extends e
{
  private final r a = new r();
  private final q b = new q();
  private final int c;
  private final a[] d;
  private a e;
  private List<com.google.android.exoplayer2.e.b> f;
  private List<com.google.android.exoplayer2.e.b> g;
  private b h;
  private int i;

  public c(int paramInt, List<byte[]> paramList)
  {
    if (paramInt == -1)
      paramInt = 1;
    this.c = paramInt;
    this.d = new a[8];
    for (int j = 0; j < 8; j++)
      this.d[j] = new a();
    this.e = this.d[0];
    p();
  }

  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      if ((paramInt >= 17) && (paramInt <= 23))
      {
        l.c("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + paramInt);
        this.b.b(8);
      }
      break;
    case 0:
    case 14:
      return;
    case 3:
      this.f = o();
      return;
    case 8:
      this.e.f();
      return;
    case 12:
      p();
      return;
    case 13:
      this.e.a('\n');
      return;
    }
    if ((paramInt >= 24) && (paramInt <= 31))
    {
      l.c("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + paramInt);
      this.b.b(16);
      return;
    }
    l.c("Cea708Decoder", "Invalid C0 command: " + paramInt);
  }

  private void b(int paramInt)
  {
    boolean bool1 = true;
    switch (paramInt)
    {
    case 147:
    case 148:
    case 149:
    case 150:
    default:
      l.c("Cea708Decoder", "Invalid C1 command: " + paramInt);
    case 142:
    case 128:
    case 129:
    case 130:
    case 131:
    case 132:
    case 133:
    case 134:
    case 135:
    case 136:
    case 137:
    case 138:
    case 139:
    case 140:
    case 141:
    case 143:
    case 144:
    case 145:
    case 146:
    case 151:
    case 152:
    case 153:
    case 154:
    case 155:
    case 156:
    case 157:
    case 158:
    case 159:
    }
    label315: label368: int j;
    do
    {
      while (true)
      {
        return;
        int k = paramInt - 128;
        if (this.i != k)
        {
          this.i = k;
          this.e = this.d[k];
          return;
          while (bool1 <= true)
          {
            if (this.b.e())
              this.d[(true - bool1)].c();
            bool1++;
          }
          continue;
          for (boolean bool4 = bool1; bool4 <= true; bool4++)
            if (this.b.e())
              this.d[(true - bool4)].a(bool1);
          continue;
          while (bool1 <= true)
          {
            if (this.b.e())
              this.d[(true - bool1)].a(false);
            bool1++;
          }
          continue;
          boolean bool2 = bool1;
          a locala;
          if (bool2 <= true)
            if (this.b.e())
            {
              locala = this.d[(true - bool2)];
              if (locala.e())
                break label368;
            }
          for (boolean bool3 = bool1; ; bool3 = false)
          {
            locala.a(bool3);
            bool2++;
            break label315;
            break;
          }
          while (bool1 <= true)
          {
            if (this.b.e())
              this.d[(true - bool1)].b();
            bool1++;
          }
        }
      }
      this.b.b(8);
      return;
      p();
      return;
      if (!this.e.d())
      {
        this.b.b(16);
        return;
      }
      k();
      return;
      if (!this.e.d())
      {
        this.b.b(24);
        return;
      }
      l();
      return;
      if (!this.e.d())
      {
        this.b.b(16);
        return;
      }
      m();
      return;
      if (!this.e.d())
      {
        this.b.b(32);
        return;
      }
      n();
      return;
      j = paramInt - 152;
      i(j);
    }
    while (this.i == j);
    this.i = j;
    this.e = this.d[j];
  }

  private void c(int paramInt)
  {
    if (paramInt <= 7);
    do
    {
      return;
      if (paramInt <= 15)
      {
        this.b.b(8);
        return;
      }
      if (paramInt <= 23)
      {
        this.b.b(16);
        return;
      }
    }
    while (paramInt > 31);
    this.b.b(24);
  }

  private void d(int paramInt)
  {
    if (paramInt <= 135)
      this.b.b(32);
    do
    {
      return;
      if (paramInt <= 143)
      {
        this.b.b(40);
        return;
      }
    }
    while (paramInt > 159);
    this.b.b(2);
    int j = this.b.c(6);
    this.b.b(j * 8);
  }

  private void e(int paramInt)
  {
    if (paramInt == 127)
    {
      this.e.a('♫');
      return;
    }
    this.e.a((char)(paramInt & 0xFF));
  }

  private void f(int paramInt)
  {
    this.e.a((char)(paramInt & 0xFF));
  }

  private void g(int paramInt)
  {
    switch (paramInt)
    {
    default:
      l.c("Cea708Decoder", "Invalid G2 character: " + paramInt);
      return;
    case 32:
      this.e.a(' ');
      return;
    case 33:
      this.e.a(' ');
      return;
    case 37:
      this.e.a('…');
      return;
    case 42:
      this.e.a('Š');
      return;
    case 44:
      this.e.a('Œ');
      return;
    case 48:
      this.e.a('█');
      return;
    case 49:
      this.e.a('‘');
      return;
    case 50:
      this.e.a('’');
      return;
    case 51:
      this.e.a('“');
      return;
    case 52:
      this.e.a('”');
      return;
    case 53:
      this.e.a('•');
      return;
    case 57:
      this.e.a('™');
      return;
    case 58:
      this.e.a('š');
      return;
    case 60:
      this.e.a('œ');
      return;
    case 61:
      this.e.a('℠');
      return;
    case 63:
      this.e.a('Ÿ');
      return;
    case 118:
      this.e.a('⅛');
      return;
    case 119:
      this.e.a('⅜');
      return;
    case 120:
      this.e.a('⅝');
      return;
    case 121:
      this.e.a('⅞');
      return;
    case 122:
      this.e.a('│');
      return;
    case 123:
      this.e.a('┐');
      return;
    case 124:
      this.e.a('└');
      return;
    case 125:
      this.e.a('─');
      return;
    case 126:
      this.e.a('┘');
      return;
    case 127:
    }
    this.e.a('┌');
  }

  private void h(int paramInt)
  {
    if (paramInt == 160)
    {
      this.e.a('㏄');
      return;
    }
    l.c("Cea708Decoder", "Invalid G3 character: " + paramInt);
    this.e.a('_');
  }

  private void i()
  {
    if (this.h == null)
      return;
    j();
    this.h = null;
  }

  private void i(int paramInt)
  {
    a locala = this.d[paramInt];
    this.b.b(2);
    boolean bool1 = this.b.e();
    boolean bool2 = this.b.e();
    boolean bool3 = this.b.e();
    int j = this.b.c(3);
    boolean bool4 = this.b.e();
    int k = this.b.c(7);
    int m = this.b.c(8);
    int n = this.b.c(4);
    int i1 = this.b.c(4);
    this.b.b(2);
    int i2 = this.b.c(6);
    this.b.b(2);
    locala.a(bool1, bool2, bool3, j, bool4, k, m, i1, i2, n, this.b.c(3), this.b.c(3));
  }

  private void j()
  {
    if (this.h.d != -1 + 2 * this.h.b)
      l.c("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + (-1 + 2 * this.h.b) + ", but current index is " + this.h.d + " (sequence number " + this.h.a + "); ignoring packet");
    int m;
    do
    {
      int j;
      do
      {
        do
        {
          return;
          this.b.a(this.h.c, this.h.d);
          j = this.b.c(3);
          int k = this.b.c(5);
          if (j == 7)
          {
            this.b.b(2);
            j = this.b.c(6);
            if (j < 7)
              l.c("Cea708Decoder", "Invalid extended service number: " + j);
          }
          if (k != 0)
            break;
        }
        while (j == 0);
        l.c("Cea708Decoder", "serviceNumber is non-zero (" + j + ") when blockSize is 0");
        return;
      }
      while (j != this.c);
      m = 0;
      while (this.b.a() > 0)
      {
        int n = this.b.c(8);
        if (n != 16)
        {
          if (n <= 31)
          {
            a(n);
          }
          else if (n <= 127)
          {
            e(n);
            m = 1;
          }
          else if (n <= 159)
          {
            b(n);
            m = 1;
          }
          else if (n <= 255)
          {
            f(n);
            m = 1;
          }
          else
          {
            l.c("Cea708Decoder", "Invalid base command: " + n);
          }
        }
        else
        {
          int i1 = this.b.c(8);
          if (i1 <= 31)
          {
            c(i1);
          }
          else if (i1 <= 127)
          {
            g(i1);
            m = 1;
          }
          else if (i1 <= 159)
          {
            d(i1);
          }
          else if (i1 <= 255)
          {
            h(i1);
            m = 1;
          }
          else
          {
            l.c("Cea708Decoder", "Invalid extended command: " + i1);
          }
        }
      }
    }
    while (m == 0);
    this.f = o();
  }

  private void k()
  {
    int j = this.b.c(4);
    int k = this.b.c(2);
    int m = this.b.c(2);
    boolean bool1 = this.b.e();
    boolean bool2 = this.b.e();
    int n = this.b.c(3);
    int i1 = this.b.c(3);
    this.e.a(j, k, m, bool1, bool2, n, i1);
  }

  private void l()
  {
    int j = this.b.c(2);
    int k = a.a(this.b.c(2), this.b.c(2), this.b.c(2), j);
    int m = this.b.c(2);
    int n = a.a(this.b.c(2), this.b.c(2), this.b.c(2), m);
    this.b.b(2);
    int i1 = a.b(this.b.c(2), this.b.c(2), this.b.c(2));
    this.e.a(k, n, i1);
  }

  private void m()
  {
    this.b.b(4);
    int j = this.b.c(4);
    this.b.b(2);
    int k = this.b.c(6);
    this.e.a(j, k);
  }

  private void n()
  {
    int j = this.b.c(2);
    int k = a.a(this.b.c(2), this.b.c(2), this.b.c(2), j);
    int m = this.b.c(2);
    int n = a.b(this.b.c(2), this.b.c(2), this.b.c(2));
    if (this.b.e())
      m |= 4;
    boolean bool = this.b.e();
    int i1 = this.b.c(2);
    int i2 = this.b.c(2);
    int i3 = this.b.c(2);
    this.b.b(8);
    this.e.a(k, n, bool, m, i1, i2, i3);
  }

  private List<com.google.android.exoplayer2.e.b> o()
  {
    ArrayList localArrayList = new ArrayList();
    for (int j = 0; j < 8; j++)
      if ((!this.d[j].a()) && (this.d[j].e()))
        localArrayList.add(this.d[j].h());
    Collections.sort(localArrayList);
    return Collections.unmodifiableList(localArrayList);
  }

  private void p()
  {
    for (int j = 0; j < 8; j++)
      this.d[j].b();
  }

  protected void a(i parami)
  {
    byte[] arrayOfByte1 = parami.b.array();
    this.a.a(arrayOfByte1, parami.b.limit());
    label60: label336: 
    while (this.a.b() >= 3)
    {
      int j = 0x7 & this.a.h();
      int k = j & 0x3;
      int m;
      int n;
      int i1;
      if ((j & 0x4) == 4)
      {
        m = 1;
        n = (byte)this.a.h();
        i1 = (byte)this.a.h();
        if (((k == 2) || (k == 3)) && (m != 0))
          if (k == 3)
          {
            i();
            int i4 = (n & 0xC0) >> 6;
            int i5 = n & 0x3F;
            if (i5 == 0)
              i5 = 64;
            this.h = new b(i4, i5);
            byte[] arrayOfByte4 = this.h.c;
            b localb3 = this.h;
            int i6 = localb3.d;
            localb3.d = (i6 + 1);
            arrayOfByte4[i6] = i1;
          }
      }
      else
      {
        while (true)
        {
          if (this.h.d != -1 + 2 * this.h.b)
            break label336;
          i();
          break;
          m = 0;
          break label60;
          if (k == 2);
          for (boolean bool = true; ; bool = false)
          {
            a.a(bool);
            if (this.h != null)
              break label259;
            l.d("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
            break;
          }
          byte[] arrayOfByte2 = this.h.c;
          b localb1 = this.h;
          int i2 = localb1.d;
          localb1.d = (i2 + 1);
          arrayOfByte2[i2] = n;
          byte[] arrayOfByte3 = this.h.c;
          b localb2 = this.h;
          int i3 = localb2.d;
          localb2.d = (i3 + 1);
          arrayOfByte3[i3] = i1;
        }
      }
    }
    label259:
  }

  public void c()
  {
    super.c();
    this.f = null;
    this.g = null;
    this.i = 0;
    this.e = this.d[this.i];
    p();
    this.h = null;
  }

  protected boolean e()
  {
    return this.f != this.g;
  }

  protected com.google.android.exoplayer2.e.e f()
  {
    this.g = this.f;
    return new f(this.f);
  }

  private static final class a
  {
    public static final int a = a(2, 2, 2, 0);
    public static final int b = a(0, 0, 0, 0);
    public static final int c = a(0, 0, 0, 3);
    private static final int[] d = { 0, 0, 0, 0, 0, 2, 0 };
    private static final int[] e = { 0, 0, 0, 0, 0, 0, 2 };
    private static final int[] f = { 3, 3, 3, 3, 3, 3, 1 };
    private static final boolean[] g = { 0, 0, 0, 1, 1, 1, 0 };
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;
    private static final int[] k = arrayOfInt2;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private final List<SpannableString> l = new ArrayList();
    private final SpannableStringBuilder m = new SpannableStringBuilder();
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    static
    {
      int[] arrayOfInt1 = new int[7];
      arrayOfInt1[0] = b;
      arrayOfInt1[1] = c;
      arrayOfInt1[2] = b;
      arrayOfInt1[3] = b;
      arrayOfInt1[4] = c;
      arrayOfInt1[5] = b;
      arrayOfInt1[6] = b;
      h = arrayOfInt1;
      i = new int[] { 0, 1, 2, 3, 4, 3, 4 };
      j = new int[] { 0, 0, 0, 0, 0, 3, 3 };
      int[] arrayOfInt2 = new int[7];
      arrayOfInt2[0] = b;
      arrayOfInt2[1] = b;
      arrayOfInt2[2] = b;
      arrayOfInt2[3] = b;
      arrayOfInt2[4] = b;
      arrayOfInt2[5] = c;
      arrayOfInt2[6] = c;
    }

    public a()
    {
      b();
    }

    public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i1 = 255;
      a.a(paramInt1, 0, 4);
      a.a(paramInt2, 0, 4);
      a.a(paramInt3, 0, 4);
      a.a(paramInt4, 0, 4);
      int i2;
      int i3;
      label77: int i4;
      switch (paramInt4)
      {
      default:
        i2 = i1;
        if (paramInt1 > 1)
        {
          i3 = i1;
          if (paramInt2 <= 1)
            break label129;
          i4 = i1;
          label86: if (paramInt3 <= 1)
            break label135;
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        return Color.argb(i2, i3, i4, i1);
        i2 = i1;
        break;
        i2 = 127;
        break;
        i2 = 0;
        break;
        i3 = 0;
        break label77;
        label129: i4 = 0;
        break label86;
        label135: i1 = 0;
      }
    }

    public static int b(int paramInt1, int paramInt2, int paramInt3)
    {
      return a(paramInt1, paramInt2, paramInt3, 0);
    }

    public void a(char paramChar)
    {
      if (paramChar == '\n')
      {
        this.l.add(g());
        this.m.clear();
        if (this.A != -1)
          this.A = 0;
        if (this.B != -1)
          this.B = 0;
        if (this.C != -1)
          this.C = 0;
        if (this.E != -1)
          this.E = 0;
        while (((this.v) && (this.l.size() >= this.u)) || (this.l.size() >= 15))
          this.l.remove(0);
      }
      this.m.append(paramChar);
    }

    public void a(int paramInt1, int paramInt2)
    {
      if (this.G != paramInt1)
        a('\n');
      this.G = paramInt1;
    }

    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((this.C != -1) && (this.D != paramInt1))
        this.m.setSpan(new ForegroundColorSpan(this.D), this.C, this.m.length(), 33);
      if (paramInt1 != a)
      {
        this.C = this.m.length();
        this.D = paramInt1;
      }
      if ((this.E != -1) && (this.F != paramInt2))
        this.m.setSpan(new BackgroundColorSpan(this.F), this.E, this.m.length(), 33);
      if (paramInt2 != b)
      {
        this.E = this.m.length();
        this.F = paramInt2;
      }
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5)
    {
      if (this.A != -1)
        if (!paramBoolean1)
        {
          this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
          this.A = -1;
        }
      do
        while (this.B != -1)
        {
          if (!paramBoolean2)
          {
            this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
            this.B = -1;
          }
          return;
          if (paramBoolean1)
            this.A = this.m.length();
        }
      while (!paramBoolean2);
      this.B = this.m.length();
    }

    public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.z = paramInt1;
      this.w = paramInt6;
    }

    public void a(boolean paramBoolean)
    {
      this.o = paramBoolean;
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, boolean paramBoolean4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      this.n = true;
      this.o = paramBoolean1;
      this.v = paramBoolean2;
      this.p = paramInt1;
      this.q = paramBoolean4;
      this.r = paramInt2;
      this.s = paramInt3;
      this.t = paramInt6;
      if (this.u != paramInt4 + 1)
      {
        this.u = (paramInt4 + 1);
        while (((paramBoolean2) && (this.l.size() >= this.u)) || (this.l.size() >= 15))
          this.l.remove(0);
      }
      if ((paramInt7 != 0) && (this.x != paramInt7))
      {
        this.x = paramInt7;
        int i2 = paramInt7 - 1;
        a(h[i2], c, g[i2], 0, e[i2], f[i2], d[i2]);
      }
      if ((paramInt8 != 0) && (this.y != paramInt8))
      {
        this.y = paramInt8;
        int i1 = paramInt8 - 1;
        a(0, 1, 1, false, false, j[i1], i[i1]);
        a(a, k[i1], b);
      }
    }

    public boolean a()
    {
      return (!d()) || ((this.l.isEmpty()) && (this.m.length() == 0));
    }

    public void b()
    {
      c();
      this.n = false;
      this.o = false;
      this.p = 4;
      this.q = false;
      this.r = 0;
      this.s = 0;
      this.t = 0;
      this.u = 15;
      this.v = true;
      this.w = 0;
      this.x = 0;
      this.y = 0;
      this.z = b;
      this.D = a;
      this.F = b;
    }

    public void c()
    {
      this.l.clear();
      this.m.clear();
      this.A = -1;
      this.B = -1;
      this.C = -1;
      this.E = -1;
      this.G = 0;
    }

    public boolean d()
    {
      return this.n;
    }

    public boolean e()
    {
      return this.o;
    }

    public void f()
    {
      int i1 = this.m.length();
      if (i1 > 0)
        this.m.delete(i1 - 1, i1);
    }

    public SpannableString g()
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.m);
      int i1 = localSpannableStringBuilder.length();
      if (i1 > 0)
      {
        if (this.A != -1)
          localSpannableStringBuilder.setSpan(new StyleSpan(2), this.A, i1, 33);
        if (this.B != -1)
          localSpannableStringBuilder.setSpan(new UnderlineSpan(), this.B, i1, 33);
        if (this.C != -1)
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, i1, 33);
        if (this.E != -1)
          localSpannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, i1, 33);
      }
      return new SpannableString(localSpannableStringBuilder);
    }

    public b h()
    {
      if (a())
        return null;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      for (int i1 = 0; i1 < this.l.size(); i1++)
      {
        localSpannableStringBuilder.append((CharSequence)this.l.get(i1));
        localSpannableStringBuilder.append('\n');
      }
      localSpannableStringBuilder.append(g());
      Layout.Alignment localAlignment;
      float f1;
      float f2;
      label170: float f3;
      float f4;
      int i2;
      label206: int i3;
      switch (this.w)
      {
      default:
        throw new IllegalArgumentException("Unexpected justification value: " + this.w);
      case 0:
      case 3:
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if (this.q)
        {
          f1 = this.s / 99.0F;
          f2 = this.r / 99.0F;
          f3 = 0.05F + f1 * 0.9F;
          f4 = 0.05F + f2 * 0.9F;
          if (this.t % 3 != 0)
            break label305;
          i2 = 0;
          if (this.t / 3 != 0)
            break label327;
          i3 = 0;
          label218: if (this.z == b)
            break label349;
        }
        break;
      case 1:
      case 2:
      }
      label305: label327: label349: for (boolean bool = true; ; bool = false)
      {
        return new b(localSpannableStringBuilder, localAlignment, f4, 0, i2, f3, i3, 1.4E-45F, bool, this.z, this.p);
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        f1 = this.s / 209.0F;
        f2 = this.r / 74.0F;
        break label170;
        if (this.t % 3 == 1)
        {
          i2 = 1;
          break label206;
        }
        i2 = 2;
        break label206;
        if (this.t / 3 == 1)
        {
          i3 = 1;
          break label218;
        }
        i3 = 2;
        break label218;
      }
    }
  }

  private static final class b
  {
    public final int a;
    public final int b;
    public final byte[] c;
    int d;

    public b(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = new byte[-1 + paramInt2 * 2];
      this.d = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.a.c
 * JD-Core Version:    0.6.2
 */