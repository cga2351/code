package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.drawable.ScalingUtils.InterpolatingScaleType;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.util.Map;
import javax.annotation.Nullable;

@TargetApi(19)
public class DraweeTransition extends Transition
{
  private static final String PROPNAME_BOUNDS = "draweeTransition:bounds";

  @Nullable
  private final PointF mFromFocusPoint;
  private final ScalingUtils.ScaleType mFromScale;

  @Nullable
  private final PointF mToFocusPoint;
  private final ScalingUtils.ScaleType mToScale;

  public DraweeTransition(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2)
  {
    this(paramScaleType1, paramScaleType2, null, null);
  }

  public DraweeTransition(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2, @Nullable PointF paramPointF1, @Nullable PointF paramPointF2)
  {
    this.mFromScale = paramScaleType1;
    this.mToScale = paramScaleType2;
    this.mFromFocusPoint = paramPointF1;
    this.mToFocusPoint = paramPointF2;
  }

  private void captureValues(TransitionValues paramTransitionValues)
  {
    if ((paramTransitionValues.view instanceof GenericDraweeView))
      paramTransitionValues.values.put("draweeTransition:bounds", new Rect(0, 0, paramTransitionValues.view.getWidth(), paramTransitionValues.view.getHeight()));
  }

  public static TransitionSet createTransitionSet(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2)
  {
    return createTransitionSet(paramScaleType1, paramScaleType2, null, null);
  }

  public static TransitionSet createTransitionSet(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2, @Nullable PointF paramPointF1, @Nullable PointF paramPointF2)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition(new ChangeBounds());
    localTransitionSet.addTransition(new DraweeTransition(paramScaleType1, paramScaleType2, paramPointF1, paramPointF2));
    return localTransitionSet;
  }

  public void captureEndValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }

  public void captureStartValues(TransitionValues paramTransitionValues)
  {
    captureValues(paramTransitionValues);
  }

  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 == null) || (paramTransitionValues2 == null));
    Rect localRect1;
    Rect localRect2;
    do
    {
      return null;
      localRect1 = (Rect)paramTransitionValues1.values.get("draweeTransition:bounds");
      localRect2 = (Rect)paramTransitionValues2.values.get("draweeTransition:bounds");
    }
    while ((localRect1 == null) || (localRect2 == null) || ((this.mFromScale == this.mToScale) && (this.mFromFocusPoint == this.mToFocusPoint)));
    final GenericDraweeView localGenericDraweeView = (GenericDraweeView)paramTransitionValues1.view;
    final ScalingUtils.InterpolatingScaleType localInterpolatingScaleType = new ScalingUtils.InterpolatingScaleType(this.mFromScale, this.mToScale, localRect1, localRect2, this.mFromFocusPoint, this.mToFocusPoint);
    ((GenericDraweeHierarchy)localGenericDraweeView.getHierarchy()).setActualImageScaleType(localInterpolatingScaleType);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        localInterpolatingScaleType.setValue(f);
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ((GenericDraweeHierarchy)localGenericDraweeView.getHierarchy()).setActualImageScaleType(DraweeTransition.this.mToScale);
        if (DraweeTransition.this.mToFocusPoint != null)
          ((GenericDraweeHierarchy)localGenericDraweeView.getHierarchy()).setActualImageFocusPoint(DraweeTransition.this.mToFocusPoint);
      }
    });
    return localValueAnimator;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.view.DraweeTransition
 * JD-Core Version:    0.6.2
 */