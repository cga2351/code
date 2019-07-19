package com.viber.voip.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.viber.voip.R.styleable;
import com.viber.voip.ui.ViberTextView;

public class ViberCallView extends LinearLayout
{
  private AppCompatImageView a;
  private ViberTextView b;

  public ViberCallView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ViberCallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ViberCallView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public ViberCallView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet, paramInt1);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    setOrientation(1);
    setGravity(17);
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.ViberCallView, paramInt, 0);
    int i = localTypedArray.getResourceId(R.styleable.ViberCallView_cvDrawable, 0);
    int j = localTypedArray.getDimensionPixelSize(R.styleable.ViberCallView_cvButtonSize, 0);
    this.a = new AppCompatImageView(paramContext);
    label120: int k;
    int m;
    int n;
    int i1;
    int i2;
    LinearLayout.LayoutParams localLayoutParams;
    if (j > 0)
    {
      addView(this.a, j, j);
      this.b = new ViberTextView(paramContext);
      this.b.setGravity(17);
      addView(this.b);
      if (i <= 0)
        break label293;
      this.a.setImageResource(i);
      k = localTypedArray.getDimensionPixelSize(R.styleable.ViberCallView_cvDrawableMargin, 0);
      m = localTypedArray.getDimensionPixelSize(R.styleable.ViberCallView_cvDrawableMarginTop, 0);
      n = localTypedArray.getDimensionPixelSize(R.styleable.ViberCallView_cvDrawableMarginBottom, 0);
      i1 = localTypedArray.getDimensionPixelSize(R.styleable.ViberCallView_cvDrawableMarginStart, 0);
      i2 = localTypedArray.getDimensionPixelSize(R.styleable.ViberCallView_cvDrawableMarginEnd, 0);
      localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
      if (i1 <= 0)
        break label305;
      label192: if (m <= 0)
        break label312;
      label197: if (i2 <= 0)
        break label319;
      label202: if (n <= 0)
        break label326;
    }
    CharSequence localCharSequence;
    while (true)
    {
      localLayoutParams.setMargins(i1, m, i2, n);
      this.a.setLayoutParams(localLayoutParams);
      int i3 = localTypedArray.getResourceId(R.styleable.ViberCallView_cvTextAppearance, 0);
      if (i3 > 0)
        TextViewCompat.setTextAppearance(this.b, i3);
      localCharSequence = localTypedArray.getText(R.styleable.ViberCallView_cvText);
      if (!TextUtils.isEmpty(localCharSequence))
        break label333;
      this.b.setVisibility(8);
      return;
      addView(this.a);
      break;
      label293: this.a.setVisibility(8);
      break label120;
      label305: i1 = k;
      break label192;
      label312: m = k;
      break label197;
      label319: i2 = k;
      break label202;
      label326: n = k;
    }
    label333: this.b.setText(localCharSequence);
  }

  public void setDrawable(int paramInt)
  {
    if (this.a != null)
      this.a.setImageResource(paramInt);
  }

  public void setDrawable(Bitmap paramBitmap)
  {
    if (this.a != null)
      this.a.setImageBitmap(paramBitmap);
  }

  public void setDrawable(Drawable paramDrawable)
  {
    if (this.a != null)
      this.a.setImageDrawable(paramDrawable);
  }

  public void setEnabled(boolean paramBoolean)
  {
    if (this.a != null)
      this.a.setEnabled(paramBoolean);
    if (this.b != null)
      this.b.setEnabled(paramBoolean);
    super.setEnabled(paramBoolean);
  }

  public void setText(int paramInt)
  {
    if (this.b != null)
      this.b.setText(paramInt);
  }

  public void setText(CharSequence paramCharSequence)
  {
    if (this.b != null)
      this.b.setText(paramCharSequence);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ViberCallView
 * JD-Core Version:    0.6.2
 */