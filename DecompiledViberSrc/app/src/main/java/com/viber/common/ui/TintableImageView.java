package com.viber.common.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.viber.common.R.styleable;

public class TintableImageView extends ImageView
{
  private ColorStateList a;
  private ColorStateList b;

  public TintableImageView(Context paramContext)
  {
    super(paramContext);
  }

  public TintableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TintableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TintableImageView, paramInt, 0);
    this.a = localTypedArray.getColorStateList(R.styleable.TintableImageView_imgTint);
    this.b = localTypedArray.getColorStateList(R.styleable.TintableImageView_drawableTint);
    localTypedArray.recycle();
  }

  private void a()
  {
    setColorFilter(this.a.getColorForState(getDrawableState(), 0));
  }

  private void b()
  {
    int i = this.b.getColorForState(getDrawableState(), 0);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
      localDrawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.a != null)
      a();
    if (this.b != null)
      b();
  }

  public void setColorFilter(ColorStateList paramColorStateList)
  {
    this.a = paramColorStateList;
    a();
  }

  public void setDrawableTint(ColorStateList paramColorStateList)
  {
    this.b = paramColorStateList;
    b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.TintableImageView
 * JD-Core Version:    0.6.2
 */