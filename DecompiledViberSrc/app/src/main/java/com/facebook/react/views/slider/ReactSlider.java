package com.facebook.react.views.slider;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import javax.annotation.Nullable;

public class ReactSlider extends AppCompatSeekBar
{
  private static int DEFAULT_TOTAL_STEPS = 128;
  private double mMaxValue = 0.0D;
  private double mMinValue = 0.0D;
  private double mStep = 0.0D;
  private double mStepCalculated = 0.0D;
  private double mValue = 0.0D;

  public ReactSlider(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    disableStateListAnimatorIfNeeded();
  }

  private void disableStateListAnimatorIfNeeded()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (Build.VERSION.SDK_INT < 26))
      super.setStateListAnimator(null);
  }

  private double getStepValue()
  {
    if (this.mStep > 0.0D)
      return this.mStep;
    return this.mStepCalculated;
  }

  private int getTotalSteps()
  {
    return (int)Math.ceil((this.mMaxValue - this.mMinValue) / getStepValue());
  }

  private void updateAll()
  {
    if (this.mStep == 0.0D)
      this.mStepCalculated = ((this.mMaxValue - this.mMinValue) / DEFAULT_TOTAL_STEPS);
    setMax(getTotalSteps());
    updateValue();
  }

  private void updateValue()
  {
    setProgress((int)Math.round((this.mValue - this.mMinValue) / (this.mMaxValue - this.mMinValue) * getTotalSteps()));
  }

  void setMaxValue(double paramDouble)
  {
    this.mMaxValue = paramDouble;
    updateAll();
  }

  void setMinValue(double paramDouble)
  {
    this.mMinValue = paramDouble;
    updateAll();
  }

  void setStep(double paramDouble)
  {
    this.mStep = paramDouble;
    updateAll();
  }

  void setValue(double paramDouble)
  {
    this.mValue = paramDouble;
    updateValue();
  }

  public double toRealProgress(int paramInt)
  {
    if (paramInt == getMax())
      return this.mMaxValue;
    return paramInt * getStepValue() + this.mMinValue;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.slider.ReactSlider
 * JD-Core Version:    0.6.2
 */