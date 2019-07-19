package org.webrtc;

import android.graphics.Point;
import android.view.View;
import android.view.View.MeasureSpec;

public class RendererCommon
{
  private static float BALANCED_VISIBLE_FRACTION = 0.5625F;

  private static void adjustOrigin(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[12] -= 0.5F * (paramArrayOfFloat[0] + paramArrayOfFloat[4]);
    paramArrayOfFloat[13] -= 0.5F * (paramArrayOfFloat[1] + paramArrayOfFloat[5]);
    paramArrayOfFloat[12] = (0.5F + paramArrayOfFloat[12]);
    paramArrayOfFloat[13] = (0.5F + paramArrayOfFloat[13]);
  }

  public static float[] convertMatrixFromAndroidGraphicsMatrix(android.graphics.Matrix paramMatrix)
  {
    float[] arrayOfFloat1 = new float[9];
    paramMatrix.getValues(arrayOfFloat1);
    float[] arrayOfFloat2 = new float[16];
    arrayOfFloat2[0] = arrayOfFloat1[0];
    arrayOfFloat2[1] = arrayOfFloat1[3];
    arrayOfFloat2[2] = 0.0F;
    arrayOfFloat2[3] = arrayOfFloat1[6];
    arrayOfFloat2[4] = arrayOfFloat1[1];
    arrayOfFloat2[5] = arrayOfFloat1[4];
    arrayOfFloat2[6] = 0.0F;
    arrayOfFloat2[7] = arrayOfFloat1[7];
    arrayOfFloat2[8] = 0.0F;
    arrayOfFloat2[9] = 0.0F;
    arrayOfFloat2[10] = 1.0F;
    arrayOfFloat2[11] = 0.0F;
    arrayOfFloat2[12] = arrayOfFloat1[2];
    arrayOfFloat2[13] = arrayOfFloat1[5];
    arrayOfFloat2[14] = 0.0F;
    arrayOfFloat2[15] = arrayOfFloat1[8];
    return arrayOfFloat2;
  }

  public static android.graphics.Matrix convertMatrixToAndroidGraphicsMatrix(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[9];
    arrayOfFloat[0] = paramArrayOfFloat[0];
    arrayOfFloat[1] = paramArrayOfFloat[4];
    arrayOfFloat[2] = paramArrayOfFloat[12];
    arrayOfFloat[3] = paramArrayOfFloat[1];
    arrayOfFloat[4] = paramArrayOfFloat[5];
    arrayOfFloat[5] = paramArrayOfFloat[13];
    arrayOfFloat[6] = paramArrayOfFloat[3];
    arrayOfFloat[7] = paramArrayOfFloat[7];
    arrayOfFloat[8] = paramArrayOfFloat[15];
    android.graphics.Matrix localMatrix = new android.graphics.Matrix();
    localMatrix.setValues(arrayOfFloat);
    return localMatrix;
  }

  private static float convertScalingTypeToVisibleFraction(ScalingType paramScalingType)
  {
    switch (1.$SwitchMap$org$webrtc$RendererCommon$ScalingType[paramScalingType.ordinal()])
    {
    default:
      throw new IllegalArgumentException();
    case 1:
      return 1.0F;
    case 2:
      return 0.0F;
    case 3:
    }
    return BALANCED_VISIBLE_FRACTION;
  }

  private static Point getDisplaySize(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((paramFloat1 == 0.0F) || (paramFloat2 == 0.0F))
      return new Point(paramInt1, paramInt2);
    return new Point(Math.min(paramInt1, Math.round(paramFloat2 * (paramInt2 / paramFloat1))), Math.min(paramInt2, Math.round(paramInt1 / paramFloat1 / paramFloat2)));
  }

  public static Point getDisplaySize(ScalingType paramScalingType, float paramFloat, int paramInt1, int paramInt2)
  {
    return getDisplaySize(convertScalingTypeToVisibleFraction(paramScalingType), paramFloat, paramInt1, paramInt2);
  }

  public static float[] getLayoutMatrix(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    float f2;
    float f1;
    if (paramFloat2 > paramFloat1)
    {
      f2 = paramFloat1 / paramFloat2;
      f1 = 1.0F;
    }
    while (true)
    {
      if (paramBoolean)
        f1 *= -1.0F;
      float[] arrayOfFloat = new float[16];
      android.opengl.Matrix.setIdentityM(arrayOfFloat, 0);
      android.opengl.Matrix.scaleM(arrayOfFloat, 0, f1, f2, 1.0F);
      adjustOrigin(arrayOfFloat);
      return arrayOfFloat;
      f1 = paramFloat2 / paramFloat1;
      f2 = 1.0F;
    }
  }

  public static abstract interface GlDrawer
  {
    public abstract void drawOes(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);

    public abstract void drawRgb(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);

    public abstract void drawYuv(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);

    public abstract void release();
  }

  public static abstract interface RendererEvents
  {
    public abstract void onFirstFrameRendered();

    public abstract void onFrameResolutionChanged(int paramInt1, int paramInt2, int paramInt3);
  }

  public static enum ScalingType
  {
    static
    {
      SCALE_ASPECT_FILL = new ScalingType("SCALE_ASPECT_FILL", 1);
      SCALE_ASPECT_BALANCED = new ScalingType("SCALE_ASPECT_BALANCED", 2);
      ScalingType[] arrayOfScalingType = new ScalingType[3];
      arrayOfScalingType[0] = SCALE_ASPECT_FIT;
      arrayOfScalingType[1] = SCALE_ASPECT_FILL;
      arrayOfScalingType[2] = SCALE_ASPECT_BALANCED;
    }
  }

  public static class VideoLayoutMeasure
  {
    private RendererCommon.ScalingType scalingTypeMatchOrientation = RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;
    private RendererCommon.ScalingType scalingTypeMismatchOrientation = RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;

    public Point measure(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 1;
      int j = View.getDefaultSize(2147483647, paramInt1);
      int k = View.getDefaultSize(2147483647, paramInt2);
      Point localPoint;
      if ((paramInt3 == 0) || (paramInt4 == 0) || (j == 0) || (k == 0))
      {
        localPoint = new Point(j, k);
        return localPoint;
      }
      float f1 = paramInt3 / paramInt4;
      float f2 = j / k;
      int m;
      if (f1 > 1.0F)
      {
        m = i;
        label82: if (f2 <= 1.0F)
          break label156;
        label89: if (m != i)
          break label162;
      }
      label156: label162: for (RendererCommon.ScalingType localScalingType = this.scalingTypeMatchOrientation; ; localScalingType = this.scalingTypeMismatchOrientation)
      {
        localPoint = RendererCommon.getDisplaySize(localScalingType, f1, j, k);
        if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
          localPoint.x = j;
        if (View.MeasureSpec.getMode(paramInt2) != 1073741824)
          break;
        localPoint.y = k;
        return localPoint;
        m = 0;
        break label82;
        i = 0;
        break label89;
      }
    }

    public void setScalingType(RendererCommon.ScalingType paramScalingType)
    {
      this.scalingTypeMatchOrientation = paramScalingType;
      this.scalingTypeMismatchOrientation = paramScalingType;
    }

    public void setScalingType(RendererCommon.ScalingType paramScalingType1, RendererCommon.ScalingType paramScalingType2)
    {
      this.scalingTypeMatchOrientation = paramScalingType1;
      this.scalingTypeMismatchOrientation = paramScalingType2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.RendererCommon
 * JD-Core Version:    0.6.2
 */