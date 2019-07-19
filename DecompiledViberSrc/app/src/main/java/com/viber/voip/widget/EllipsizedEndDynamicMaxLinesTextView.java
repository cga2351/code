package com.viber.voip.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.ViberTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EllipsizedEndDynamicMaxLinesTextView extends ViberTextView
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Pattern b = Pattern.compile("[. …\\s]*$");
  private CharSequence c;
  private boolean d;
  private boolean e;
  private boolean f;
  private float g = 1.0F;
  private float h = 0.0F;
  private int i;
  private float j;
  private float k = -1.0F;
  private TextPaint l = new TextPaint();

  public EllipsizedEndDynamicMaxLinesTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public EllipsizedEndDynamicMaxLinesTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public EllipsizedEndDynamicMaxLinesTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setEllipsize(null);
    super.setSingleLine(false);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843091 });
    try
    {
      setMaxLines(localTypedArray.getInt(0, 2147483647));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private float a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1 + 1.0F;
    float f2 = paramFloat2 - 1.0F;
    if (f2 >= f1)
    {
      float f3 = (f1 + f2) / 2.0F;
      this.l.set(getPaint());
      this.l.setTextSize(f3);
      float f7;
      float f6;
      if (((Boolean)a(paramInt1, paramInt2, this.l).first).booleanValue())
      {
        f7 = f3 - 1.0F;
        f6 = f1;
        f1 = f7;
      }
      while (true)
      {
        paramFloat1 = f1;
        f1 = f6;
        f2 = f7;
        break;
        float f4 = f3 + 1.0F;
        float f5 = f2;
        f6 = f4;
        f7 = f5;
      }
    }
    return paramFloat1;
  }

  private int a(Layout paramLayout, int paramInt)
  {
    int m = paramLayout.getLineForVertical(paramInt);
    if (paramLayout.getLineBottom(m) <= paramInt);
    while (true)
    {
      return Math.max(0, m);
      m--;
    }
  }

  private Layout a(CharSequence paramCharSequence, int paramInt, TextPaint paramTextPaint)
  {
    return new StaticLayout(paramCharSequence, paramTextPaint, paramInt, Layout.Alignment.ALIGN_NORMAL, this.g, this.h, getIncludeFontPadding());
  }

  private TextPaint a(float paramFloat)
  {
    this.l.set(getPaint());
    this.l.setTextSize(paramFloat);
    return this.l;
  }

  private Pair<Boolean, Integer> a(int paramInt1, int paramInt2, TextPaint paramTextPaint)
  {
    int m = -1 + this.c.length();
    try
    {
      Layout localLayout = a(this.c, paramInt1, paramTextPaint);
      int i1 = Math.min(localLayout.getLineEnd(-1 + Math.min(this.i, 1 + a(localLayout, paramInt2))), m);
      int i2 = i1;
      if (i2 <= 0)
        i2 = m;
      n = i2;
      if ((m >= 0) && (n >= 0) && (n < m))
      {
        bool = true;
        return new Pair(Boolean.valueOf(bool), Integer.valueOf(n));
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        int n = m;
        continue;
        boolean bool = false;
      }
    }
  }

  private void a()
  {
    if (!this.f);
    int m;
    int n;
    do
    {
      return;
      m = getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
      n = getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight();
    }
    while ((m <= 0) || (n <= 0));
    CharSequence localCharSequence1 = this.c;
    Object localObject1;
    float f1;
    if (b())
    {
      localObject1 = a(n, m, a(this.k));
      if (((Boolean)((Pair)localObject1).first).booleanValue())
        f1 = this.k;
    }
    while (true)
    {
      label94: setTextSizeInternally(f1);
      CharSequence localCharSequence2;
      if (((Boolean)((Pair)localObject1).first).booleanValue())
      {
        int i1 = Math.max(0, -3 + ((Integer)((Pair)localObject1).second).intValue());
        Matcher localMatcher = b.matcher(this.c.subSequence(0, i1));
        if (localMatcher.find())
          i1 = Math.max(0, localMatcher.start());
        CharSequence[] arrayOfCharSequence = new CharSequence[2];
        arrayOfCharSequence[0] = this.c.subSequence(0, i1);
        arrayOfCharSequence[1] = "…";
        localCharSequence2 = TextUtils.concat(arrayOfCharSequence);
      }
      Pair localPair;
      float f2;
      while (true)
        while (true)
        {
          this.f = false;
          if (localCharSequence2.equals(getText()))
            break;
          this.d = true;
          try
          {
            setText(localCharSequence2);
            return;
            localPair = a(n, m, a(this.j));
            f2 = this.j;
            if (!((Boolean)localPair.first).booleanValue())
              break label352;
            f1 = a(n, m, this.k, this.j);
            localObject1 = a(n, m, a(f1));
            break label94;
            localObject1 = a(n, m, a(this.j));
            f1 = this.j;
          }
          finally
          {
            this.d = false;
          }
        }
      label352: f1 = f2;
      localObject1 = localPair;
    }
  }

  private boolean b()
  {
    return (this.k > 0.0F) && (this.k < this.j);
  }

  private void setTextSizeInternally(float paramFloat)
  {
    this.e = true;
    try
    {
      setTextSize(0, paramFloat);
      return;
    }
    finally
    {
      this.e = false;
    }
  }

  @SuppressLint({"Override"})
  public int getMaxLines()
  {
    return this.i;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    a();
    super.onDraw(paramCanvas);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = true;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.d)
    {
      this.c = paramCharSequence;
      this.f = true;
    }
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }

  public void setCompoundDrawablePadding(int paramInt)
  {
    this.f = true;
    super.setCompoundDrawablePadding(paramInt);
  }

  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
  }

  public void setGravity(int paramInt)
  {
    this.f = true;
    super.setGravity(paramInt);
  }

  public void setIncludeFontPadding(boolean paramBoolean)
  {
    this.f = true;
    super.setIncludeFontPadding(paramBoolean);
  }

  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.h = paramFloat1;
    this.g = paramFloat2;
    this.f = true;
    super.setLineSpacing(paramFloat1, paramFloat2);
  }

  public void setMaxLines(int paramInt)
  {
    this.i = paramInt;
    this.f = true;
    super.setMaxLines(paramInt);
  }

  public void setMinTextSizePx(float paramFloat)
  {
    this.k = paramFloat;
    this.f = true;
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = true;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = true;
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setSingleLine()
  {
  }

  public void setSingleLine(boolean paramBoolean)
  {
  }

  public void setTextSize(float paramFloat)
  {
    if (!this.e)
    {
      this.j = paramFloat;
      this.f = true;
    }
    super.setTextSize(paramFloat);
  }

  public void setTextSize(int paramInt, float paramFloat)
  {
    if (!this.e)
    {
      this.j = paramFloat;
      this.f = true;
    }
    super.setTextSize(paramInt, paramFloat);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.EllipsizedEndDynamicMaxLinesTextView
 * JD-Core Version:    0.6.2
 */