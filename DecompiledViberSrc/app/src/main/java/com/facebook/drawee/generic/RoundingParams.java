package com.facebook.drawee.generic;

import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;

public class RoundingParams
{
  private int mBorderColor = 0;
  private float mBorderWidth = 0.0F;
  private float[] mCornersRadii = null;
  private int mOverlayColor = 0;
  private float mPadding = 0.0F;
  private boolean mRoundAsCircle = false;
  private RoundingMethod mRoundingMethod = RoundingMethod.BITMAP_ONLY;
  private boolean mScaleDownInsideBorders = false;

  public static RoundingParams asCircle()
  {
    return new RoundingParams().setRoundAsCircle(true);
  }

  public static RoundingParams fromCornersRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new RoundingParams().setCornersRadii(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public static RoundingParams fromCornersRadii(float[] paramArrayOfFloat)
  {
    return new RoundingParams().setCornersRadii(paramArrayOfFloat);
  }

  public static RoundingParams fromCornersRadius(float paramFloat)
  {
    return new RoundingParams().setCornersRadius(paramFloat);
  }

  private float[] getOrCreateRoundedCornersRadii()
  {
    if (this.mCornersRadii == null)
      this.mCornersRadii = new float[8];
    return this.mCornersRadii;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    RoundingParams localRoundingParams;
    boolean bool4;
    boolean bool5;
    do
    {
      RoundingMethod localRoundingMethod1;
      RoundingMethod localRoundingMethod2;
      do
      {
        int i1;
        do
        {
          int m;
          int n;
          do
          {
            int k;
            do
            {
              int i;
              int j;
              do
              {
                boolean bool2;
                boolean bool3;
                do
                {
                  Class localClass1;
                  Class localClass2;
                  do
                  {
                    do
                    {
                      return bool1;
                      bool1 = false;
                    }
                    while (paramObject == null);
                    localClass1 = getClass();
                    localClass2 = paramObject.getClass();
                    bool1 = false;
                  }
                  while (localClass1 != localClass2);
                  localRoundingParams = (RoundingParams)paramObject;
                  bool2 = this.mRoundAsCircle;
                  bool3 = localRoundingParams.mRoundAsCircle;
                  bool1 = false;
                }
                while (bool2 != bool3);
                i = this.mOverlayColor;
                j = localRoundingParams.mOverlayColor;
                bool1 = false;
              }
              while (i != j);
              k = Float.compare(localRoundingParams.mBorderWidth, this.mBorderWidth);
              bool1 = false;
            }
            while (k != 0);
            m = this.mBorderColor;
            n = localRoundingParams.mBorderColor;
            bool1 = false;
          }
          while (m != n);
          i1 = Float.compare(localRoundingParams.mPadding, this.mPadding);
          bool1 = false;
        }
        while (i1 != 0);
        localRoundingMethod1 = this.mRoundingMethod;
        localRoundingMethod2 = localRoundingParams.mRoundingMethod;
        bool1 = false;
      }
      while (localRoundingMethod1 != localRoundingMethod2);
      bool4 = this.mScaleDownInsideBorders;
      bool5 = localRoundingParams.mScaleDownInsideBorders;
      bool1 = false;
    }
    while (bool4 != bool5);
    return Arrays.equals(this.mCornersRadii, localRoundingParams.mCornersRadii);
  }

  public int getBorderColor()
  {
    return this.mBorderColor;
  }

  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }

  public float[] getCornersRadii()
  {
    return this.mCornersRadii;
  }

  public int getOverlayColor()
  {
    return this.mOverlayColor;
  }

  public float getPadding()
  {
    return this.mPadding;
  }

  public boolean getRoundAsCircle()
  {
    return this.mRoundAsCircle;
  }

  public RoundingMethod getRoundingMethod()
  {
    return this.mRoundingMethod;
  }

  public boolean getScaleDownInsideBorders()
  {
    return this.mScaleDownInsideBorders;
  }

  public int hashCode()
  {
    int i = 1;
    int j;
    int m;
    label32: int i1;
    label57: int i3;
    label93: int i5;
    label129: int i6;
    if (this.mRoundingMethod != null)
    {
      j = this.mRoundingMethod.hashCode();
      int k = j * 31;
      if (!this.mRoundAsCircle)
        break label156;
      m = i;
      int n = 31 * (m + k);
      if (this.mCornersRadii == null)
        break label162;
      i1 = Arrays.hashCode(this.mCornersRadii);
      int i2 = 31 * (31 * (i1 + n) + this.mOverlayColor);
      if (this.mBorderWidth == 0.0F)
        break label168;
      i3 = Float.floatToIntBits(this.mBorderWidth);
      int i4 = 31 * (31 * (i3 + i2) + this.mBorderColor);
      if (this.mPadding == 0.0F)
        break label174;
      i5 = Float.floatToIntBits(this.mPadding);
      i6 = 31 * (i5 + i4);
      if (!this.mScaleDownInsideBorders)
        break label180;
    }
    while (true)
    {
      return i6 + i;
      j = 0;
      break;
      label156: m = 0;
      break label32;
      label162: i1 = 0;
      break label57;
      label168: i3 = 0;
      break label93;
      label174: i5 = 0;
      break label129;
      label180: i = 0;
    }
  }

  public RoundingParams setBorder(int paramInt, float paramFloat)
  {
    if (paramFloat >= 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "the border width cannot be < 0");
      this.mBorderWidth = paramFloat;
      this.mBorderColor = paramInt;
      return this;
    }
  }

  public RoundingParams setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
    return this;
  }

  public RoundingParams setBorderWidth(float paramFloat)
  {
    if (paramFloat >= 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "the border width cannot be < 0");
      this.mBorderWidth = paramFloat;
      return this;
    }
  }

  public RoundingParams setCornersRadii(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = getOrCreateRoundedCornersRadii();
    arrayOfFloat[1] = paramFloat1;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[3] = paramFloat2;
    arrayOfFloat[2] = paramFloat2;
    arrayOfFloat[5] = paramFloat3;
    arrayOfFloat[4] = paramFloat3;
    arrayOfFloat[7] = paramFloat4;
    arrayOfFloat[6] = paramFloat4;
    return this;
  }

  public RoundingParams setCornersRadii(float[] paramArrayOfFloat)
  {
    Preconditions.checkNotNull(paramArrayOfFloat);
    if (paramArrayOfFloat.length == 8);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, getOrCreateRoundedCornersRadii(), 0, 8);
      return this;
    }
  }

  public RoundingParams setCornersRadius(float paramFloat)
  {
    Arrays.fill(getOrCreateRoundedCornersRadii(), paramFloat);
    return this;
  }

  public RoundingParams setOverlayColor(int paramInt)
  {
    this.mOverlayColor = paramInt;
    this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
    return this;
  }

  public RoundingParams setPadding(float paramFloat)
  {
    if (paramFloat >= 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "the padding cannot be < 0");
      this.mPadding = paramFloat;
      return this;
    }
  }

  public RoundingParams setRoundAsCircle(boolean paramBoolean)
  {
    this.mRoundAsCircle = paramBoolean;
    return this;
  }

  public RoundingParams setRoundingMethod(RoundingMethod paramRoundingMethod)
  {
    this.mRoundingMethod = paramRoundingMethod;
    return this;
  }

  public RoundingParams setScaleDownInsideBorders(boolean paramBoolean)
  {
    this.mScaleDownInsideBorders = paramBoolean;
    return this;
  }

  public static enum RoundingMethod
  {
    static
    {
      BITMAP_ONLY = new RoundingMethod("BITMAP_ONLY", 1);
      RoundingMethod[] arrayOfRoundingMethod = new RoundingMethod[2];
      arrayOfRoundingMethod[0] = OVERLAY_COLOR;
      arrayOfRoundingMethod[1] = BITMAP_ONLY;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.generic.RoundingParams
 * JD-Core Version:    0.6.2
 */