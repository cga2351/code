package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Property;

class ObjectAnimatorCompatBase
{
  private static final int NUM_POINTS = 201;

  private static void calculateXYValues(Path paramPath, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f = localPathMeasure.getLength();
    float[] arrayOfFloat = new float[2];
    for (int i = 0; i < 201; i++)
    {
      localPathMeasure.getPosTan(f * i / 200.0F, arrayOfFloat, null);
      paramArrayOfFloat1[i] = arrayOfFloat[0];
      paramArrayOfFloat2[i] = arrayOfFloat[1];
    }
  }

  private static void calculateXYValues(Path paramPath, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f = localPathMeasure.getLength();
    float[] arrayOfFloat = new float[2];
    for (int i = 0; i < 201; i++)
    {
      localPathMeasure.getPosTan(f * i / 200.0F, arrayOfFloat, null);
      paramArrayOfInt1[i] = Math.round(arrayOfFloat[0]);
      paramArrayOfInt2[i] = Math.round(arrayOfFloat[1]);
    }
  }

  public static <T> ObjectAnimator ofArgb(T paramT, Property<T, Integer> paramProperty, int[] paramArrayOfInt)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(paramT, paramProperty, paramArrayOfInt);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    return localObjectAnimator;
  }

  public static ObjectAnimator ofArgb(Object paramObject, String paramString, int[] paramArrayOfInt)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(paramObject, paramString, paramArrayOfInt);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    return localObjectAnimator;
  }

  public static <T> ObjectAnimator ofFloat(T paramT, Property<T, Float> paramProperty1, Property<T, Float> paramProperty2, Path paramPath)
  {
    float[] arrayOfFloat1 = new float['É'];
    float[] arrayOfFloat2 = new float['É'];
    calculateXYValues(paramPath, arrayOfFloat1, arrayOfFloat2);
    return ObjectAnimator.ofPropertyValuesHolder(paramT, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(paramProperty1, arrayOfFloat1), PropertyValuesHolder.ofFloat(paramProperty2, arrayOfFloat2) });
  }

  public static ObjectAnimator ofFloat(Object paramObject, String paramString1, String paramString2, Path paramPath)
  {
    float[] arrayOfFloat1 = new float['É'];
    float[] arrayOfFloat2 = new float['É'];
    calculateXYValues(paramPath, arrayOfFloat1, arrayOfFloat2);
    return ObjectAnimator.ofPropertyValuesHolder(paramObject, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(paramString1, arrayOfFloat1), PropertyValuesHolder.ofFloat(paramString2, arrayOfFloat2) });
  }

  public static <T> ObjectAnimator ofInt(T paramT, Property<T, Integer> paramProperty1, Property<T, Integer> paramProperty2, Path paramPath)
  {
    int[] arrayOfInt1 = new int['É'];
    int[] arrayOfInt2 = new int['É'];
    calculateXYValues(paramPath, arrayOfInt1, arrayOfInt2);
    return ObjectAnimator.ofPropertyValuesHolder(paramT, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(paramProperty1, arrayOfInt1), PropertyValuesHolder.ofInt(paramProperty2, arrayOfInt2) });
  }

  public static ObjectAnimator ofInt(Object paramObject, String paramString1, String paramString2, Path paramPath)
  {
    int[] arrayOfInt1 = new int['É'];
    int[] arrayOfInt2 = new int['É'];
    calculateXYValues(paramPath, arrayOfInt1, arrayOfInt2);
    return ObjectAnimator.ofPropertyValuesHolder(paramObject, new PropertyValuesHolder[] { PropertyValuesHolder.ofInt(paramString1, arrayOfInt1), PropertyValuesHolder.ofInt(paramString2, arrayOfInt2) });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.internal.ObjectAnimatorCompatBase
 * JD-Core Version:    0.6.2
 */