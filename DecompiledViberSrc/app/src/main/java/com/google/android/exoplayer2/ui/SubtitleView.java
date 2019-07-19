package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.e.a;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.g.ag;
import java.util.ArrayList;
import java.util.List;

public final class SubtitleView extends View
  implements k
{
  private final List<f> a = new ArrayList();
  private List<b> b;
  private int c = 0;
  private float d = 0.0533F;
  private boolean e = true;
  private boolean f = true;
  private a g = a.a;
  private float h = 0.08F;

  public SubtitleView(Context paramContext)
  {
    this(paramContext, null);
  }

  public SubtitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private float a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default:
      paramFloat = 1.4E-45F;
    case 2:
      return paramFloat;
    case 0:
      return paramFloat * paramInt3;
    case 1:
    }
    return paramFloat * paramInt2;
  }

  private float a(b paramb, int paramInt1, int paramInt2)
  {
    if ((paramb.m == -2147483648) || (paramb.n == 1.4E-45F))
      return 0.0F;
    return Math.max(a(paramb.m, paramb.n, paramInt1, paramInt2), 0.0F);
  }

  private void a(int paramInt, float paramFloat)
  {
    if ((this.c == paramInt) && (this.d == paramFloat))
      return;
    this.c = paramInt;
    this.d = paramFloat;
    invalidate();
  }

  @TargetApi(19)
  private boolean c()
  {
    return ((CaptioningManager)getContext().getSystemService("captioning")).isEnabled();
  }

  @TargetApi(19)
  private float getUserCaptionFontScaleV19()
  {
    return ((CaptioningManager)getContext().getSystemService("captioning")).getFontScale();
  }

  @TargetApi(19)
  private a getUserCaptionStyleV19()
  {
    return a.a(((CaptioningManager)getContext().getSystemService("captioning")).getUserStyle());
  }

  public void a()
  {
    if ((ag.a >= 19) && (!isInEditMode()));
    for (float f1 = getUserCaptionFontScaleV19(); ; f1 = 1.0F)
    {
      setFractionalTextSize(f1 * 0.0533F);
      return;
    }
  }

  public void a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      a(i, paramFloat);
      return;
    }
  }

  public void a(List<b> paramList)
  {
    setCues(paramList);
  }

  public void b()
  {
    if ((ag.a >= 19) && (c()) && (!isInEditMode()));
    for (a locala = getUserCaptionStyleV19(); ; locala = a.a)
    {
      setStyle(locala);
      return;
    }
  }

  public void dispatchDraw(Canvas paramCanvas)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if (this.b == null)
    {
      i = 0;
      j = getHeight();
      k = getPaddingLeft();
      m = getPaddingTop();
      n = getWidth() - getPaddingRight();
      i1 = j - getPaddingBottom();
      if ((i1 > m) && (n > k))
        break label73;
    }
    while (true)
    {
      return;
      i = this.b.size();
      break;
      label73: int i2 = i1 - m;
      float f1 = a(this.c, this.d, j, i2);
      if (f1 > 0.0F)
        for (int i3 = 0; i3 < i; i3++)
        {
          b localb = (b)this.b.get(i3);
          float f2 = a(localb, j, i2);
          ((f)this.a.get(i3)).a(localb, this.e, this.f, this.g, f1, f2, this.h, paramCanvas, k, m, n, i1);
        }
    }
  }

  public void setApplyEmbeddedFontSizes(boolean paramBoolean)
  {
    if (this.f == paramBoolean)
      return;
    this.f = paramBoolean;
    invalidate();
  }

  public void setApplyEmbeddedStyles(boolean paramBoolean)
  {
    if ((this.e == paramBoolean) && (this.f == paramBoolean))
      return;
    this.e = paramBoolean;
    this.f = paramBoolean;
    invalidate();
  }

  public void setBottomPaddingFraction(float paramFloat)
  {
    if (this.h == paramFloat)
      return;
    this.h = paramFloat;
    invalidate();
  }

  public void setCues(List<b> paramList)
  {
    if (this.b == paramList)
      return;
    this.b = paramList;
    int i;
    if (paramList == null)
      i = 0;
    while (this.a.size() < i)
    {
      this.a.add(new f(getContext()));
      continue;
      i = paramList.size();
    }
    invalidate();
  }

  public void setFractionalTextSize(float paramFloat)
  {
    a(paramFloat, false);
  }

  public void setStyle(a parama)
  {
    if (this.g == parama)
      return;
    this.g = parama;
    invalidate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.SubtitleView
 * JD-Core Version:    0.6.2
 */