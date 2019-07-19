package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class ArrayDrawable extends Drawable
  implements Drawable.Callback, TransformAwareDrawable, TransformCallback
{
  private final DrawableParent[] mDrawableParents;
  private final DrawableProperties mDrawableProperties = new DrawableProperties();
  private boolean mIsMutated = false;
  private boolean mIsStateful = false;
  private boolean mIsStatefulCalculated = false;
  private final Drawable[] mLayers;
  private final Rect mTmpRect = new Rect();
  private TransformCallback mTransformCallback;

  public ArrayDrawable(Drawable[] paramArrayOfDrawable)
  {
    Preconditions.checkNotNull(paramArrayOfDrawable);
    this.mLayers = paramArrayOfDrawable;
    while (i < this.mLayers.length)
    {
      DrawableUtils.setCallbacks(this.mLayers[i], this, this);
      i++;
    }
    this.mDrawableParents = new DrawableParent[this.mLayers.length];
  }

  private DrawableParent createDrawableParentForIndex(final int paramInt)
  {
    return new DrawableParent()
    {
      public Drawable getDrawable()
      {
        return ArrayDrawable.this.getDrawable(paramInt);
      }

      public Drawable setDrawable(Drawable paramAnonymousDrawable)
      {
        return ArrayDrawable.this.setDrawable(paramInt, paramAnonymousDrawable);
      }
    };
  }

  public void draw(Canvas paramCanvas)
  {
    for (int i = 0; i < this.mLayers.length; i++)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.draw(paramCanvas);
    }
  }

  @Nullable
  public Drawable getDrawable(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt >= 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramInt >= this.mLayers.length)
        break label37;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      return this.mLayers[paramInt];
      bool2 = false;
      break;
      label37: bool1 = false;
    }
  }

  public DrawableParent getDrawableParentForIndex(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt >= 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramInt >= this.mDrawableParents.length)
        break label57;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      if (this.mDrawableParents[paramInt] == null)
        this.mDrawableParents[paramInt] = createDrawableParentForIndex(paramInt);
      return this.mDrawableParents[paramInt];
      bool2 = false;
      break;
      label57: bool1 = false;
    }
  }

  public int getIntrinsicHeight()
  {
    int i = 0;
    int j = -1;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        j = Math.max(j, localDrawable.getIntrinsicHeight());
      i++;
    }
    if (j > 0)
      return j;
    return -1;
  }

  public int getIntrinsicWidth()
  {
    int i = 0;
    int j = -1;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        j = Math.max(j, localDrawable.getIntrinsicWidth());
      i++;
    }
    if (j > 0)
      return j;
    return -1;
  }

  public int getNumberOfLayers()
  {
    return this.mLayers.length;
  }

  public int getOpacity()
  {
    int i;
    if (this.mLayers.length == 0)
      i = -2;
    while (true)
    {
      return i;
      i = -1;
      for (int j = 1; j < this.mLayers.length; j++)
      {
        Drawable localDrawable = this.mLayers[j];
        if (localDrawable != null)
          i = Drawable.resolveOpacity(i, localDrawable.getOpacity());
      }
    }
  }

  public boolean getPadding(Rect paramRect)
  {
    int i = 0;
    paramRect.left = 0;
    paramRect.top = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
    Rect localRect = this.mTmpRect;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
      {
        localDrawable.getPadding(localRect);
        paramRect.left = Math.max(paramRect.left, localRect.left);
        paramRect.top = Math.max(paramRect.top, localRect.top);
        paramRect.right = Math.max(paramRect.right, localRect.right);
        paramRect.bottom = Math.max(paramRect.bottom, localRect.bottom);
      }
      i++;
    }
    return true;
  }

  public void getRootBounds(RectF paramRectF)
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getRootBounds(paramRectF);
      return;
    }
    paramRectF.set(getBounds());
  }

  public void getTransform(Matrix paramMatrix)
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getTransform(paramMatrix);
      return;
    }
    paramMatrix.reset();
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }

  public boolean isStateful()
  {
    if (!this.mIsStatefulCalculated)
    {
      this.mIsStateful = false;
      int i = 0;
      if (i < this.mLayers.length)
      {
        Drawable localDrawable = this.mLayers[i];
        boolean bool1 = this.mIsStateful;
        if ((localDrawable != null) && (localDrawable.isStateful()));
        for (boolean bool2 = true; ; bool2 = false)
        {
          this.mIsStateful = (bool2 | bool1);
          i++;
          break;
        }
      }
      this.mIsStatefulCalculated = true;
    }
    return this.mIsStateful;
  }

  public Drawable mutate()
  {
    for (int i = 0; i < this.mLayers.length; i++)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.mutate();
    }
    this.mIsMutated = true;
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    for (int i = 0; i < this.mLayers.length; i++)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setBounds(paramRect);
    }
  }

  protected boolean onLevelChange(int paramInt)
  {
    int i = 0;
    boolean bool = false;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if ((localDrawable != null) && (localDrawable.setLevel(paramInt)))
        bool = true;
      i++;
    }
    return bool;
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = 0;
    boolean bool = false;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if ((localDrawable != null) && (localDrawable.setState(paramArrayOfInt)))
        bool = true;
      i++;
    }
    return bool;
  }

  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }

  public void setAlpha(int paramInt)
  {
    this.mDrawableProperties.setAlpha(paramInt);
    for (int i = 0; i < this.mLayers.length; i++)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setAlpha(paramInt);
    }
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawableProperties.setColorFilter(paramColorFilter);
    for (int i = 0; i < this.mLayers.length; i++)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setColorFilter(paramColorFilter);
    }
  }

  public void setDither(boolean paramBoolean)
  {
    this.mDrawableProperties.setDither(paramBoolean);
    for (int i = 0; i < this.mLayers.length; i++)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setDither(paramBoolean);
    }
  }

  @Nullable
  public Drawable setDrawable(int paramInt, @Nullable Drawable paramDrawable)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt >= 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramInt >= this.mLayers.length)
        break label118;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      Drawable localDrawable = this.mLayers[paramInt];
      if (paramDrawable != localDrawable)
      {
        if ((paramDrawable != null) && (this.mIsMutated))
          paramDrawable.mutate();
        DrawableUtils.setCallbacks(this.mLayers[paramInt], null, null);
        DrawableUtils.setCallbacks(paramDrawable, null, null);
        DrawableUtils.setDrawableProperties(paramDrawable, this.mDrawableProperties);
        DrawableUtils.copyProperties(paramDrawable, this);
        DrawableUtils.setCallbacks(paramDrawable, this, this);
        this.mIsStatefulCalculated = false;
        this.mLayers[paramInt] = paramDrawable;
        invalidateSelf();
      }
      return localDrawable;
      bool2 = false;
      break;
      label118: bool1 = false;
    }
  }

  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawableProperties.setFilterBitmap(paramBoolean);
    for (int i = 0; i < this.mLayers.length; i++)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setFilterBitmap(paramBoolean);
    }
  }

  @TargetApi(21)
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    for (int i = 0; i < this.mLayers.length; i++)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }

  public void setTransformCallback(TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    for (int i = 0; i < this.mLayers.length; i++)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }

  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.ArrayDrawable
 * JD-Core Version:    0.6.2
 */