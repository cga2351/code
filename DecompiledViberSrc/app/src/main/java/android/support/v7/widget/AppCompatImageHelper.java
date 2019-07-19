package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.a.a.a;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageHelper
{
  private TintInfo mImageTint;
  private TintInfo mInternalImageTint;
  private TintInfo mTmpInfo;
  private final ImageView mView;

  public AppCompatImageHelper(ImageView paramImageView)
  {
    this.mView = paramImageView;
  }

  private boolean applyFrameworkTintUsingColorFilter(Drawable paramDrawable)
  {
    if (this.mTmpInfo == null)
      this.mTmpInfo = new TintInfo();
    TintInfo localTintInfo = this.mTmpInfo;
    localTintInfo.clear();
    ColorStateList localColorStateList = ImageViewCompat.getImageTintList(this.mView);
    if (localColorStateList != null)
    {
      localTintInfo.mHasTintList = true;
      localTintInfo.mTintList = localColorStateList;
    }
    PorterDuff.Mode localMode = ImageViewCompat.getImageTintMode(this.mView);
    if (localMode != null)
    {
      localTintInfo.mHasTintMode = true;
      localTintInfo.mTintMode = localMode;
    }
    if ((localTintInfo.mHasTintList) || (localTintInfo.mHasTintMode))
    {
      AppCompatDrawableManager.tintDrawable(paramDrawable, localTintInfo, this.mView.getDrawableState());
      return true;
    }
    return false;
  }

  private boolean shouldApplyFrameworkTintUsingColorFilter()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21)
      if (this.mInternalImageTint == null);
    while (i == 21)
    {
      return true;
      return false;
    }
    return false;
  }

  void applySupportImageTint()
  {
    Drawable localDrawable = this.mView.getDrawable();
    if (localDrawable != null)
      DrawableUtils.fixDrawable(localDrawable);
    if ((localDrawable == null) || ((shouldApplyFrameworkTintUsingColorFilter()) && (applyFrameworkTintUsingColorFilter(localDrawable))));
    do
    {
      return;
      if (this.mImageTint != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, this.mImageTint, this.mView.getDrawableState());
        return;
      }
    }
    while (this.mInternalImageTint == null);
    AppCompatDrawableManager.tintDrawable(localDrawable, this.mInternalImageTint, this.mView.getDrawableState());
  }

  ColorStateList getSupportImageTintList()
  {
    if (this.mImageTint != null)
      return this.mImageTint.mTintList;
    return null;
  }

  PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.mImageTint != null)
      return this.mImageTint.mTintMode;
    return null;
  }

  boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.mView.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }

  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, R.styleable.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.mView.getDrawable();
      if (localDrawable == null)
      {
        int i = localTintTypedArray.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
        if (i != -1)
        {
          localDrawable = a.b(this.mView.getContext(), i);
          if (localDrawable != null)
            this.mView.setImageDrawable(localDrawable);
        }
      }
      if (localDrawable != null)
        DrawableUtils.fixDrawable(localDrawable);
      if (localTintTypedArray.hasValue(R.styleable.AppCompatImageView_tint))
        ImageViewCompat.setImageTintList(this.mView, localTintTypedArray.getColorStateList(R.styleable.AppCompatImageView_tint));
      if (localTintTypedArray.hasValue(R.styleable.AppCompatImageView_tintMode))
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(localTintTypedArray.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
      return;
    }
    finally
    {
      localTintTypedArray.recycle();
    }
  }

  public void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = a.b(this.mView.getContext(), paramInt);
      if (localDrawable != null)
        DrawableUtils.fixDrawable(localDrawable);
      this.mView.setImageDrawable(localDrawable);
    }
    while (true)
    {
      applySupportImageTint();
      return;
      this.mView.setImageDrawable(null);
    }
  }

  void setInternalImageTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.mInternalImageTint == null)
        this.mInternalImageTint = new TintInfo();
      this.mInternalImageTint.mTintList = paramColorStateList;
      this.mInternalImageTint.mHasTintList = true;
    }
    while (true)
    {
      applySupportImageTint();
      return;
      this.mInternalImageTint = null;
    }
  }

  void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.mImageTint == null)
      this.mImageTint = new TintInfo();
    this.mImageTint.mTintList = paramColorStateList;
    this.mImageTint.mHasTintList = true;
    applySupportImageTint();
  }

  void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mImageTint == null)
      this.mImageTint = new TintInfo();
    this.mImageTint.mTintMode = paramMode;
    this.mImageTint.mHasTintMode = true;
    applySupportImageTint();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatImageHelper
 * JD-Core Version:    0.6.2
 */