package com.facebook.react.uimanager;

import com.facebook.yoga.YogaConstants;
import java.util.Arrays;

public class Spacing
{
  public static final int ALL = 8;
  public static final int BOTTOM = 3;
  public static final int END = 5;
  public static final int HORIZONTAL = 6;
  public static final int LEFT = 0;
  public static final int RIGHT = 2;
  public static final int START = 4;
  public static final int TOP = 1;
  public static final int VERTICAL = 7;
  private static final int[] sFlagsMap = { 1, 2, 4, 8, 16, 32, 64, 128, 256 };
  private final float mDefaultValue;
  private boolean mHasAliasesSet;
  private final float[] mSpacing;
  private int mValueFlags = 0;

  public Spacing()
  {
    this(0.0F);
  }

  public Spacing(float paramFloat)
  {
    this.mDefaultValue = paramFloat;
    this.mSpacing = newFullSpacingArray();
  }

  public Spacing(Spacing paramSpacing)
  {
    this.mDefaultValue = paramSpacing.mDefaultValue;
    this.mSpacing = Arrays.copyOf(paramSpacing.mSpacing, paramSpacing.mSpacing.length);
    this.mValueFlags = paramSpacing.mValueFlags;
    this.mHasAliasesSet = paramSpacing.mHasAliasesSet;
  }

  private static float[] newFullSpacingArray()
  {
    return new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
  }

  public float get(int paramInt)
  {
    float f;
    if ((paramInt == 4) || (paramInt == 5))
    {
      f = (0.0F / 0.0F);
      if (this.mValueFlags != 0)
        break label30;
    }
    label30: 
    do
    {
      do
      {
        return f;
        f = this.mDefaultValue;
        break;
        if ((this.mValueFlags & sFlagsMap[paramInt]) != 0)
          return this.mSpacing[paramInt];
      }
      while (!this.mHasAliasesSet);
      if ((paramInt == 1) || (paramInt == 3));
      for (int i = 7; (this.mValueFlags & sFlagsMap[i]) != 0; i = 6)
        return this.mSpacing[i];
    }
    while ((this.mValueFlags & sFlagsMap[8]) == 0);
    return this.mSpacing[8];
  }

  public float getRaw(int paramInt)
  {
    return this.mSpacing[paramInt];
  }

  float getWithFallback(int paramInt1, int paramInt2)
  {
    if ((this.mValueFlags & sFlagsMap[paramInt1]) != 0)
      return this.mSpacing[paramInt1];
    return get(paramInt2);
  }

  public void reset()
  {
    Arrays.fill(this.mSpacing, (0.0F / 0.0F));
    this.mHasAliasesSet = false;
    this.mValueFlags = 0;
  }

  public boolean set(int paramInt, float paramFloat)
  {
    if (!FloatUtil.floatsEqual(this.mSpacing[paramInt], paramFloat))
    {
      this.mSpacing[paramInt] = paramFloat;
      if (YogaConstants.isUndefined(paramFloat));
      for (this.mValueFlags &= (0xFFFFFFFF ^ sFlagsMap[paramInt]); ; this.mValueFlags |= sFlagsMap[paramInt])
      {
        boolean bool;
        if (((this.mValueFlags & sFlagsMap[8]) == 0) && ((this.mValueFlags & sFlagsMap[7]) == 0))
        {
          int i = this.mValueFlags & sFlagsMap[6];
          bool = false;
          if (i == 0);
        }
        else
        {
          bool = true;
        }
        this.mHasAliasesSet = bool;
        return true;
      }
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.Spacing
 * JD-Core Version:    0.6.2
 */