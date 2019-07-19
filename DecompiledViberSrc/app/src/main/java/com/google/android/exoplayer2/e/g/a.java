package com.google.android.exoplayer2.e.g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.nio.charset.Charset;
import java.util.List;

public final class a extends c
{
  private static final int a = ag.g("styl");
  private static final int b = ag.g("tbox");
  private final r c = new r();
  private boolean d;
  private int e;
  private int f;
  private String g;
  private float h;
  private int i;

  public a(List<byte[]> paramList)
  {
    super("Tx3gDecoder");
    a(paramList);
  }

  private static String a(r paramr)
    throws g
  {
    if (paramr.b() >= 2);
    int j;
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      j = paramr.i();
      if (j != 0)
        break;
      return "";
    }
    if (paramr.b() >= 2)
    {
      int k = paramr.g();
      if ((k == 65279) || (k == 65534))
        return paramr.a(j, Charset.forName("UTF-16"));
    }
    return paramr.a(j, Charset.forName("UTF-8"));
  }

  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = 1;
    int k;
    int m;
    int n;
    if (paramInt1 != paramInt2)
    {
      k = paramInt5 | 0x21;
      if ((paramInt1 & 0x1) == 0)
        break label122;
      m = j;
      if ((paramInt1 & 0x2) == 0)
        break label128;
      n = j;
      label35: if (m == 0)
        break label155;
      if (n == 0)
        break label134;
      paramSpannableStringBuilder.setSpan(new StyleSpan(3), paramInt3, paramInt4, k);
      label62: if ((paramInt1 & 0x4) == 0)
        break label180;
    }
    while (true)
    {
      if (j != 0)
        paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt3, paramInt4, k);
      if ((j == 0) && (m == 0) && (n == 0))
        paramSpannableStringBuilder.setSpan(new StyleSpan(0), paramInt3, paramInt4, k);
      return;
      label122: m = 0;
      break;
      label128: n = 0;
      break label35;
      label134: paramSpannableStringBuilder.setSpan(new StyleSpan(j), paramInt3, paramInt4, k);
      break label62;
      label155: if (n == 0)
        break label62;
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), paramInt3, paramInt4, k);
      break label62;
      label180: j = 0;
    }
  }

  private static void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString1 != paramString2)
      paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramString1), paramInt1, paramInt2, paramInt3 | 0x21);
  }

  private void a(r paramr, SpannableStringBuilder paramSpannableStringBuilder)
    throws g
  {
    if (paramr.b() >= 12);
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      int j = paramr.i();
      int k = paramr.i();
      paramr.d(2);
      int m = paramr.h();
      paramr.d(1);
      int n = paramr.p();
      a(paramSpannableStringBuilder, m, this.e, j, k, 0);
      b(paramSpannableStringBuilder, n, this.f, j, k, 0);
      return;
    }
  }

  private void a(List<byte[]> paramList)
  {
    if ((paramList != null) && (paramList.size() == 1) && ((((byte[])paramList.get(0)).length == 48) || (((byte[])paramList.get(0)).length == 53)))
    {
      byte[] arrayOfByte = (byte[])paramList.get(0);
      this.e = arrayOfByte[24];
      this.f = ((0xFF & arrayOfByte[26]) << 24 | (0xFF & arrayOfByte[27]) << 16 | (0xFF & arrayOfByte[28]) << 8 | 0xFF & arrayOfByte[29]);
      String str;
      if ("Serif".equals(ag.a(arrayOfByte, 43, -43 + arrayOfByte.length)))
      {
        str = "serif";
        this.g = str;
        this.i = (20 * arrayOfByte[25]);
        if ((0x20 & arrayOfByte[0]) == 0)
          break label228;
      }
      label228: for (boolean bool = true; ; bool = false)
      {
        this.d = bool;
        if (!this.d)
          break label234;
        this.h = (((0xFF & arrayOfByte[10]) << 8 | 0xFF & arrayOfByte[11]) / this.i);
        this.h = ag.a(this.h, 0.0F, 0.95F);
        return;
        str = "sans-serif";
        break;
      }
      label234: this.h = 0.85F;
      return;
    }
    this.e = 0;
    this.f = -1;
    this.g = "sans-serif";
    this.d = false;
    this.h = 0.85F;
  }

  private static void a(boolean paramBoolean)
    throws g
  {
    if (!paramBoolean)
      throw new g("Unexpected subtitle format.");
  }

  private static void b(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 != paramInt2)
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan((paramInt1 & 0xFF) << 24 | paramInt1 >>> 8), paramInt3, paramInt4, paramInt5 | 0x21);
  }

  protected e a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws g
  {
    this.c.a(paramArrayOfByte, paramInt);
    String str = a(this.c);
    if (str.isEmpty())
      return b.a;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
    a(localSpannableStringBuilder, this.e, 0, 0, localSpannableStringBuilder.length(), 16711680);
    b(localSpannableStringBuilder, this.f, -1, 0, localSpannableStringBuilder.length(), 16711680);
    a(localSpannableStringBuilder, this.g, "sans-serif", 0, localSpannableStringBuilder.length(), 16711680);
    float f1 = this.h;
    if (this.c.b() >= 8)
    {
      int j = this.c.d();
      int k = this.c.p();
      int m = this.c.p();
      if (m == a)
      {
        if (this.c.b() >= 2);
        for (boolean bool2 = true; ; bool2 = false)
        {
          a(bool2);
          int n = this.c.i();
          for (int i1 = 0; i1 < n; i1++)
            a(this.c, localSpannableStringBuilder);
        }
      }
      if ((m == b) && (this.d))
        if (this.c.b() < 2)
          break label280;
      label280: for (boolean bool1 = true; ; bool1 = false)
      {
        a(bool1);
        f1 = ag.a(this.c.i() / this.i, 0.0F, 0.95F);
        this.c.c(j + k);
        break;
      }
    }
    return new b(new com.google.android.exoplayer2.e.b(localSpannableStringBuilder, null, f1, 0, 0, 1.4E-45F, -2147483648, 1.4E-45F));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.g.a
 * JD-Core Version:    0.6.2
 */