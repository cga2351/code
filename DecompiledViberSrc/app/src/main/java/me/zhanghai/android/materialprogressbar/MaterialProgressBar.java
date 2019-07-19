package me.zhanghai.android.materialprogressbar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;
import me.zhanghai.android.materialprogressbar.internal.DrawableCompat;

public class MaterialProgressBar extends ProgressBar
{
  public static final int PROGRESS_STYLE_CIRCULAR = 0;
  public static final int PROGRESS_STYLE_HORIZONTAL = 1;
  private static final String TAG = MaterialProgressBar.class.getSimpleName();
  private int mProgressStyle;
  private TintInfo mProgressTint = new TintInfo(null);

  public MaterialProgressBar(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null, 0, 0);
  }

  public MaterialProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet, 0, 0);
  }

  public MaterialProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt, 0);
  }

  @TargetApi(21)
  public MaterialProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  private void applyDeterminateProgressTint()
  {
    if ((this.mProgressTint.mHasTintList) || (this.mProgressTint.mHasTintMode))
    {
      Drawable localDrawable = getProgressDrawable();
      if (localDrawable != null)
        applyTintForDrawable(localDrawable, this.mProgressTint);
    }
  }

  private void applyIndeterminateProgressTint()
  {
    if ((this.mProgressTint.mHasTintList) || (this.mProgressTint.mHasTintMode))
    {
      Drawable localDrawable = getIndeterminateDrawable();
      if (localDrawable != null)
        applyTintForDrawable(localDrawable, this.mProgressTint);
    }
  }

  private void applyProgressTint()
  {
    applyDeterminateProgressTint();
    applyIndeterminateProgressTint();
  }

  @SuppressLint({"NewApi"})
  private void applyTintForDrawable(Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramTintInfo.mHasTintList) || (paramTintInfo.mHasTintMode))
    {
      if (paramTintInfo.mHasTintList)
      {
        if (!(paramDrawable instanceof TintableDrawable))
          break label85;
        ((TintableDrawable)paramDrawable).setTintList(paramTintInfo.mTintList);
      }
      if (paramTintInfo.mHasTintMode)
      {
        if (!(paramDrawable instanceof TintableDrawable))
          break label113;
        ((TintableDrawable)paramDrawable).setTintMode(paramTintInfo.mTintMode);
      }
    }
    while (true)
    {
      if (paramDrawable.isStateful())
        paramDrawable.setState(getDrawableState());
      return;
      label85: Log.w(TAG, "drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
      if (Build.VERSION.SDK_INT < 21)
        break;
      paramDrawable.setTintList(paramTintInfo.mTintList);
      break;
      label113: Log.w(TAG, "drawable did not implement TintableDrawable, it won't be tinted below Lollipop");
      if (Build.VERSION.SDK_INT >= 21)
        paramDrawable.setTintMode(paramTintInfo.mTintMode);
    }
  }

  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MaterialProgressBar, paramInt1, paramInt2);
    this.mProgressStyle = localTypedArray.getInt(R.styleable.MaterialProgressBar_mpb_progressStyle, 0);
    boolean bool1 = localTypedArray.getBoolean(R.styleable.MaterialProgressBar_mpb_setBothDrawables, false);
    boolean bool2 = localTypedArray.getBoolean(R.styleable.MaterialProgressBar_mpb_useIntrinsicPadding, true);
    int i = R.styleable.MaterialProgressBar_mpb_showTrack;
    int j = this.mProgressStyle;
    boolean bool3 = false;
    if (j == 1)
      bool3 = true;
    boolean bool4 = localTypedArray.getBoolean(i, bool3);
    if (localTypedArray.hasValue(R.styleable.MaterialProgressBar_android_tint))
    {
      this.mProgressTint.mTintList = localTypedArray.getColorStateList(R.styleable.MaterialProgressBar_android_tint);
      this.mProgressTint.mHasTintList = true;
    }
    if (localTypedArray.hasValue(R.styleable.MaterialProgressBar_mpb_tintMode))
    {
      this.mProgressTint.mTintMode = DrawableCompat.parseTintMode(localTypedArray.getInt(R.styleable.MaterialProgressBar_mpb_tintMode, -1), null);
      this.mProgressTint.mHasTintMode = true;
    }
    localTypedArray.recycle();
    switch (this.mProgressStyle)
    {
    default:
      throw new IllegalArgumentException("Unknown progress style: " + this.mProgressStyle);
    case 0:
      if ((!isIndeterminate()) || (bool1))
        throw new UnsupportedOperationException("Determinate circular drawable is not yet supported");
      setIndeterminateDrawable(new IndeterminateProgressDrawable(paramContext));
    case 1:
    }
    while (true)
    {
      setUseIntrinsicPadding(bool2);
      setShowTrack(bool4);
      return;
      if ((isIndeterminate()) || (bool1))
        setIndeterminateDrawable(new IndeterminateHorizontalProgressDrawable(paramContext));
      if ((!isIndeterminate()) || (bool1))
        setProgressDrawable(new HorizontalProgressDrawable(paramContext));
    }
  }

  public Drawable getDrawable()
  {
    if (isIndeterminate())
      return getIndeterminateDrawable();
    return getProgressDrawable();
  }

  public int getProgressStyle()
  {
    return this.mProgressStyle;
  }

  public ColorStateList getProgressTintList()
  {
    return this.mProgressTint.mTintList;
  }

  public PorterDuff.Mode getProgressTintMode()
  {
    return this.mProgressTint.mTintMode;
  }

  public boolean getShowTrack()
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable instanceof ShowTrackDrawable))
      return ((ShowTrackDrawable)localDrawable).getShowTrack();
    return false;
  }

  public boolean getUseIntrinsicPadding()
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable instanceof IntrinsicPaddingDrawable))
      return ((IntrinsicPaddingDrawable)localDrawable).getUseIntrinsicPadding();
    throw new IllegalStateException("Drawable does not implement IntrinsicPaddingDrawable");
  }

  public void setIndeterminateDrawable(Drawable paramDrawable)
  {
    super.setIndeterminateDrawable(paramDrawable);
    if (this.mProgressTint != null)
      applyIndeterminateProgressTint();
  }

  public void setProgressDrawable(Drawable paramDrawable)
  {
    super.setProgressDrawable(paramDrawable);
    if (this.mProgressTint != null)
      applyDeterminateProgressTint();
  }

  public void setProgressTintList(ColorStateList paramColorStateList)
  {
    this.mProgressTint.mTintList = paramColorStateList;
    this.mProgressTint.mHasTintList = true;
    applyProgressTint();
  }

  public void setProgressTintMode(PorterDuff.Mode paramMode)
  {
    this.mProgressTint.mTintMode = paramMode;
    this.mProgressTint.mHasTintMode = true;
    applyProgressTint();
  }

  public void setShowTrack(boolean paramBoolean)
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable instanceof ShowTrackDrawable))
      ((ShowTrackDrawable)localDrawable).setShowTrack(paramBoolean);
    while (!paramBoolean)
      return;
    throw new IllegalStateException("Drawable does not implement ShowTrackDrawable");
  }

  public void setUseIntrinsicPadding(boolean paramBoolean)
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable instanceof IntrinsicPaddingDrawable))
    {
      ((IntrinsicPaddingDrawable)localDrawable).setUseIntrinsicPadding(paramBoolean);
      return;
    }
    throw new IllegalStateException("Drawable does not implement IntrinsicPaddingDrawable");
  }

  private static class TintInfo
  {
    boolean mHasTintList;
    boolean mHasTintMode;
    ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.MaterialProgressBar
 * JD-Core Version:    0.6.2
 */