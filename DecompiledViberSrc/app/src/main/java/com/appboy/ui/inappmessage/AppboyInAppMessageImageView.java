package com.appboy.ui.inappmessage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.appboy.b.a.b;
import com.appboy.f.c;

@SuppressLint({"AppCompatCustomView"})
public class AppboyInAppMessageImageView extends ImageView
  implements IInAppMessageImageView
{
  private static final String TAG = c.a(AppboyInAppMessageImageView.class);
  private float mAspectRatio = -1.0F;
  private Path mClipPath = new Path();
  private float[] mInAppRadii;
  private RectF mRect = new RectF();
  private boolean mSetToHalfParentHeight = false;

  public AppboyInAppMessageImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setAdjustViewBounds(true);
  }

  boolean clipCanvasToPath(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = this.mInAppRadii;
    boolean bool = false;
    if (arrayOfFloat != null);
    try
    {
      this.mClipPath.reset();
      this.mRect.set(0.0F, 0.0F, paramInt1, paramInt2);
      this.mClipPath.addRoundRect(this.mRect, this.mInAppRadii, Path.Direction.CW);
      paramCanvas.clipPath(this.mClipPath);
      bool = true;
      return bool;
    }
    catch (Exception localException)
    {
      c.d(TAG, "Encountered exception while trying to clip in-app message image", localException);
    }
    return false;
  }

  Path getClipPath()
  {
    return this.mClipPath;
  }

  float[] getInAppRadii()
  {
    return this.mInAppRadii;
  }

  RectF getRectf()
  {
    return this.mRect;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    clipCanvasToPath(paramCanvas, getWidth(), getHeight());
    super.onDraw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mAspectRatio != -1.0F)
    {
      int j = getMeasuredWidth();
      int k = (int)(j / this.mAspectRatio);
      setMeasuredDimension(j, 1 + Math.min(getMeasuredHeight(), k));
    }
    if (this.mSetToHalfParentHeight)
    {
      int i = ((View)getParent()).getHeight();
      setMeasuredDimension(getMeasuredWidth(), (int)(0.5D * i));
    }
  }

  public void setAspectRatio(float paramFloat)
  {
    this.mAspectRatio = paramFloat;
    requestLayout();
  }

  void setClipPath(Path paramPath)
  {
    this.mClipPath = paramPath;
  }

  public void setCornersRadiiPx(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mInAppRadii = new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
  }

  public void setCornersRadiusPx(float paramFloat)
  {
    setCornersRadiiPx(paramFloat, paramFloat, paramFloat, paramFloat);
  }

  public void setInAppMessageImageCropType(b paramb)
  {
    if (paramb.equals(b.a))
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    while (!paramb.equals(b.b))
      return;
    setScaleType(ImageView.ScaleType.CENTER_CROP);
  }

  void setRectf(RectF paramRectF)
  {
    this.mRect = paramRectF;
  }

  public void setToHalfParentHeight(boolean paramBoolean)
  {
    this.mSetToHalfParentHeight = paramBoolean;
    requestLayout();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.AppboyInAppMessageImageView
 * JD-Core Version:    0.6.2
 */