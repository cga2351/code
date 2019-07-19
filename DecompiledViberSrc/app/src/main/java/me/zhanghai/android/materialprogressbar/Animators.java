package me.zhanghai.android.materialprogressbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import me.zhanghai.android.materialprogressbar.internal.ObjectAnimatorCompat;

class Animators
{
  private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X;
  private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X = new Path();
  private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X;
  private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X;

  static
  {
    PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.moveTo(-522.59998F, 0.0F);
    PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.rCubicTo(48.899719F, 0.0F, 166.02657F, 0.0F, 301.21729F, 0.0F);
    PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.rCubicTo(197.58128F, 0.0F, 420.9827F, 0.0F, 420.9827F, 0.0F);
    PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X = new Path();
    PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.moveTo(0.0F, 0.1F);
    PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.lineTo(1.0F, 0.8268492F);
    PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.lineTo(2.0F, 0.1F);
    PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X = new Path();
    PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.moveTo(-197.60001F, 0.0F);
    PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.rCubicTo(14.28182F, 0.0F, 85.07782F, 0.0F, 135.54689F, 0.0F);
    PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.rCubicTo(54.261909F, 0.0F, 90.424606F, 0.0F, 168.24332F, 0.0F);
    PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.rCubicTo(144.72154F, 0.0F, 316.40982F, 0.0F, 316.40982F, 0.0F);
    PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X = new Path();
    PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.moveTo(0.0F, 0.1F);
    PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.lineTo(1.0F, 0.5713795F);
    PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.lineTo(2.0F, 0.9099503F);
    PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.lineTo(3.0F, 0.1F);
  }

  public static Animator createIndeterminate(Object paramObject)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramObject, "trimPathStart", new float[] { 0.0F, 0.75F });
    localObjectAnimator1.setDuration(1333L);
    localObjectAnimator1.setInterpolator(Interpolators.TRIM_PATH_START.INSTANCE);
    localObjectAnimator1.setRepeatCount(-1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramObject, "trimPathEnd", new float[] { 0.0F, 0.75F });
    localObjectAnimator2.setDuration(1333L);
    localObjectAnimator2.setInterpolator(Interpolators.TRIM_PATH_END.INSTANCE);
    localObjectAnimator2.setRepeatCount(-1);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramObject, "trimPathOffset", new float[] { 0.0F, 0.25F });
    localObjectAnimator3.setDuration(1333L);
    localObjectAnimator3.setInterpolator(Interpolators.LINEAR.INSTANCE);
    localObjectAnimator3.setRepeatCount(-1);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    return localAnimatorSet;
  }

  public static Animator createIndeterminateHorizontalRect1(Object paramObject)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimatorCompat.ofFloat(paramObject, "translateX", null, PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X);
    localObjectAnimator1.setDuration(2000L);
    localObjectAnimator1.setInterpolator(Interpolators.INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.INSTANCE);
    localObjectAnimator1.setRepeatCount(-1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimatorCompat.ofFloat(paramObject, null, "scaleX", PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X);
    localObjectAnimator2.setDuration(2000L);
    localObjectAnimator2.setInterpolator(Interpolators.INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.INSTANCE);
    localObjectAnimator2.setRepeatCount(-1);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    return localAnimatorSet;
  }

  public static Animator createIndeterminateHorizontalRect2(Object paramObject)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimatorCompat.ofFloat(paramObject, "translateX", null, PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X);
    localObjectAnimator1.setDuration(2000L);
    localObjectAnimator1.setInterpolator(Interpolators.INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.INSTANCE);
    localObjectAnimator1.setRepeatCount(-1);
    ObjectAnimator localObjectAnimator2 = ObjectAnimatorCompat.ofFloat(paramObject, null, "scaleX", PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X);
    localObjectAnimator2.setDuration(2000L);
    localObjectAnimator2.setInterpolator(Interpolators.INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.INSTANCE);
    localObjectAnimator2.setRepeatCount(-1);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    return localAnimatorSet;
  }

  public static Animator createIndeterminateRotation(Object paramObject)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramObject, "rotation", new float[] { 0.0F, 720.0F });
    localObjectAnimator.setDuration(6665L);
    localObjectAnimator.setInterpolator(Interpolators.LINEAR.INSTANCE);
    localObjectAnimator.setRepeatCount(-1);
    return localObjectAnimator;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.Animators
 * JD-Core Version:    0.6.2
 */