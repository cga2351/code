package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import com.google.android.exoplayer2.e.a;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;

final class f
{
  private float A;
  private int B;
  private int C;
  private int D;
  private int E;
  private StaticLayout F;
  private int G;
  private int H;
  private int I;
  private Rect J;
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  private final float e;
  private final TextPaint f;
  private final Paint g;
  private CharSequence h;
  private Layout.Alignment i;
  private Bitmap j;
  private float k;
  private int l;
  private int m;
  private float n;
  private int o;
  private float p;
  private float q;
  private boolean r;
  private boolean s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private float y;
  private float z;

  public f(Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(null, new int[] { 16843287, 16843288 }, 0, 0);
    this.e = localTypedArray.getDimensionPixelSize(0, 0);
    this.d = localTypedArray.getFloat(1, 1.0F);
    localTypedArray.recycle();
    int i1 = Math.round(2.0F * paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F);
    this.a = i1;
    this.b = i1;
    this.c = i1;
    this.f = new TextPaint();
    this.f.setAntiAlias(true);
    this.f.setSubpixelText(true);
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setStyle(Paint.Style.FILL);
  }

  private void a()
  {
    int i1 = this.D - this.B;
    int i2 = this.E - this.C;
    this.f.setTextSize(this.y);
    int i3 = (int)(0.5F + 0.125F * this.y);
    int i4 = i1 - i3 * 2;
    if (this.p != 1.4E-45F)
      i4 = (int)(i4 * this.p);
    if (i4 <= 0)
    {
      l.c("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
      return;
    }
    CharSequence localCharSequence = this.h;
    Object localObject1;
    if (!this.r)
      localObject1 = localCharSequence.toString();
    while (true)
    {
      Object localObject2;
      if (Color.alpha(this.u) > 0)
      {
        localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).setSpan(new BackgroundColorSpan(this.u), 0, ((SpannableStringBuilder)localObject2).length(), 16711680);
      }
      while (true)
      {
        if (this.i == null);
        int i10;
        int i12;
        for (Layout.Alignment localAlignment = Layout.Alignment.ALIGN_CENTER; ; localAlignment = this.i)
        {
          this.F = new StaticLayout((CharSequence)localObject2, this.f, i4, localAlignment, this.d, this.e, true);
          i10 = this.F.getHeight();
          int i11 = this.F.getLineCount();
          i12 = 0;
          int i13 = 0;
          while (i13 < i11)
          {
            int i24 = Math.max((int)Math.ceil(this.F.getLineWidth(i13)), i12);
            i13++;
            i12 = i24;
          }
          if (!this.s)
          {
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localCharSequence);
            int i5 = localSpannableStringBuilder.length();
            AbsoluteSizeSpan[] arrayOfAbsoluteSizeSpan = (AbsoluteSizeSpan[])localSpannableStringBuilder.getSpans(0, i5, AbsoluteSizeSpan.class);
            RelativeSizeSpan[] arrayOfRelativeSizeSpan = (RelativeSizeSpan[])localSpannableStringBuilder.getSpans(0, i5, RelativeSizeSpan.class);
            int i6 = arrayOfAbsoluteSizeSpan.length;
            for (int i7 = 0; i7 < i6; i7++)
              localSpannableStringBuilder.removeSpan(arrayOfAbsoluteSizeSpan[i7]);
            int i8 = arrayOfRelativeSizeSpan.length;
            for (int i9 = 0; i9 < i8; i9++)
              localSpannableStringBuilder.removeSpan(arrayOfRelativeSizeSpan[i9]);
            localObject1 = localSpannableStringBuilder;
            break;
          }
          if (this.z <= 0.0F)
            break label871;
          localObject1 = new SpannableStringBuilder(localCharSequence);
          ((SpannableStringBuilder)localObject1).setSpan(new AbsoluteSizeSpan((int)this.z), 0, ((SpannableStringBuilder)localObject1).length(), 16711680);
          break;
        }
        if ((this.p != 1.4E-45F) && (i12 < i4));
        while (true)
        {
          int i14 = i4 + i3 * 2;
          int i22;
          int i23;
          int i16;
          if (this.n != 1.4E-45F)
          {
            i22 = Math.round(i1 * this.n) + this.B;
            if (this.o == 2)
            {
              i22 -= i14;
              i23 = Math.max(i22, this.B);
              i16 = Math.min(i23 + i14, this.D);
            }
          }
          int i18;
          int i15;
          for (int i17 = i23; ; i17 = i15)
          {
            i18 = i16 - i17;
            if (i18 > 0)
              break label602;
            l.c("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
            if (this.o != 1)
              break;
            i22 = (i22 * 2 - i14) / 2;
            break;
            i15 = (i1 - i14) / 2 + this.B;
            i16 = i15 + i14;
          }
          label602: int i21;
          if (this.k != 1.4E-45F)
            if (this.l == 0)
            {
              i21 = Math.round(i2 * this.k) + this.C;
              if (this.m != 2)
                break label796;
              i21 -= i10;
              label651: if (i21 + i10 <= this.E)
                break label818;
              i21 = this.E - i10;
            }
          label672: for (int i19 = i21; ; i19 = this.E - i10 - (int)(i2 * this.A))
          {
            this.F = new StaticLayout((CharSequence)localObject2, this.f, i18, localAlignment, this.d, this.e, true);
            this.G = i17;
            this.H = i19;
            this.I = i3;
            return;
            int i20 = this.F.getLineBottom(0) - this.F.getLineTop(0);
            if (this.k >= 0.0F)
            {
              i21 = Math.round(this.k * i20) + this.C;
              break;
            }
            i21 = Math.round((1.0F + this.k) * i20) + this.E;
            break;
            if (this.m != 1)
              break label651;
            i21 = (i21 * 2 - i10) / 2;
            break label651;
            label818: if (i21 >= this.C)
              break label672;
            i21 = this.C;
            break label672;
          }
          label796: i4 = i12;
        }
        localObject2 = localObject1;
      }
      label871: localObject1 = localCharSequence;
    }
  }

  private void a(Canvas paramCanvas)
  {
    StaticLayout localStaticLayout = this.F;
    if (localStaticLayout == null)
      return;
    int i1 = paramCanvas.save();
    paramCanvas.translate(this.G, this.H);
    if (Color.alpha(this.v) > 0)
    {
      this.g.setColor(this.v);
      paramCanvas.drawRect(-this.I, 0.0F, localStaticLayout.getWidth() + this.I, localStaticLayout.getHeight(), this.g);
    }
    if (this.x == 1)
    {
      this.f.setStrokeJoin(Paint.Join.ROUND);
      this.f.setStrokeWidth(this.a);
      this.f.setColor(this.w);
      this.f.setStyle(Paint.Style.FILL_AND_STROKE);
      localStaticLayout.draw(paramCanvas);
    }
    do
      while (true)
      {
        this.f.setColor(this.t);
        this.f.setStyle(Paint.Style.FILL);
        localStaticLayout.draw(paramCanvas);
        this.f.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        paramCanvas.restoreToCount(i1);
        return;
        if (this.x != 2)
          break;
        this.f.setShadowLayer(this.b, this.c, this.c, this.w);
      }
    while ((this.x != 3) && (this.x != 4));
    int i2;
    label239: int i3;
    if (this.x == 3)
    {
      i2 = 1;
      if (i2 == 0)
        break label337;
      i3 = -1;
      label247: if (i2 == 0)
        break label346;
    }
    label337: label346: for (int i4 = this.w; ; i4 = -1)
    {
      float f1 = this.b / 2.0F;
      this.f.setColor(this.t);
      this.f.setStyle(Paint.Style.FILL);
      this.f.setShadowLayer(this.b, -f1, -f1, i3);
      localStaticLayout.draw(paramCanvas);
      this.f.setShadowLayer(this.b, f1, f1, i4);
      break;
      i2 = 0;
      break label239;
      i3 = this.w;
      break label247;
    }
  }

  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramCanvas);
      return;
    }
    b(paramCanvas);
  }

  private static boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return (paramCharSequence1 == paramCharSequence2) || ((paramCharSequence1 != null) && (paramCharSequence1.equals(paramCharSequence2)));
  }

  private void b()
  {
    int i1 = this.D - this.B;
    int i2 = this.E - this.C;
    float f1 = this.B + i1 * this.n;
    float f2 = this.C + i2 * this.k;
    int i3 = Math.round(i1 * this.p);
    int i4;
    label97: int i5;
    float f3;
    if (this.q != 1.4E-45F)
    {
      i4 = Math.round(i2 * this.q);
      if (this.m != 2)
        break label181;
      f1 -= i3;
      i5 = Math.round(f1);
      if (this.o != 2)
        break label200;
      f3 = f2 - i4;
    }
    while (true)
    {
      int i6 = Math.round(f3);
      this.J = new Rect(i5, i6, i3 + i5, i4 + i6);
      return;
      i4 = Math.round(i3 * (this.j.getHeight() / this.j.getWidth()));
      break;
      label181: if (this.m != 1)
        break label97;
      f1 -= i3 / 2;
      break label97;
      label200: if (this.o == 1)
        f3 = f2 - i4 / 2;
      else
        f3 = f2;
    }
  }

  private void b(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.j, null, this.J, null);
  }

  public void a(b paramb, boolean paramBoolean1, boolean paramBoolean2, a parama, float paramFloat1, float paramFloat2, float paramFloat3, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramb.c == null);
    for (boolean bool = true; ; bool = false)
    {
      i1 = -16777216;
      if (!bool)
        break label54;
      if (!TextUtils.isEmpty(paramb.a))
        break;
      return;
    }
    if ((paramb.k) && (paramBoolean1));
    for (int i1 = paramb.l; (a(this.h, paramb.a)) && (ag.a(this.i, paramb.b)) && (this.j == paramb.c) && (this.k == paramb.d) && (this.l == paramb.e) && (ag.a(Integer.valueOf(this.m), Integer.valueOf(paramb.f))) && (this.n == paramb.g) && (ag.a(Integer.valueOf(this.o), Integer.valueOf(paramb.h))) && (this.p == paramb.i) && (this.q == paramb.j) && (this.r == paramBoolean1) && (this.s == paramBoolean2) && (this.t == parama.b) && (this.u == parama.c) && (this.v == i1) && (this.x == parama.e) && (this.w == parama.f) && (ag.a(this.f.getTypeface(), parama.g)) && (this.y == paramFloat1) && (this.z == paramFloat2) && (this.A == paramFloat3) && (this.B == paramInt1) && (this.C == paramInt2) && (this.D == paramInt3) && (this.E == paramInt4); i1 = parama.d)
    {
      label54: a(paramCanvas, bool);
      return;
    }
    this.h = paramb.a;
    this.i = paramb.b;
    this.j = paramb.c;
    this.k = paramb.d;
    this.l = paramb.e;
    this.m = paramb.f;
    this.n = paramb.g;
    this.o = paramb.h;
    this.p = paramb.i;
    this.q = paramb.j;
    this.r = paramBoolean1;
    this.s = paramBoolean2;
    this.t = parama.b;
    this.u = parama.c;
    this.v = i1;
    this.x = parama.e;
    this.w = parama.f;
    this.f.setTypeface(parama.g);
    this.y = paramFloat1;
    this.z = paramFloat2;
    this.A = paramFloat3;
    this.B = paramInt1;
    this.C = paramInt2;
    this.D = paramInt3;
    this.E = paramInt4;
    if (bool)
      a();
    while (true)
    {
      a(paramCanvas, bool);
      return;
      b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.f
 * JD-Core Version:    0.6.2
 */