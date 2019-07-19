package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.util.Property;

@TargetApi(21)
class ObjectAnimatorCompatLollipop
{
  public static <T> ObjectAnimator ofArgb(T paramT, Property<T, Integer> paramProperty, int[] paramArrayOfInt)
  {
    return ObjectAnimator.ofArgb(paramT, paramProperty, paramArrayOfInt);
  }

  public static ObjectAnimator ofArgb(Object paramObject, String paramString, int[] paramArrayOfInt)
  {
    return ObjectAnimator.ofArgb(paramObject, paramString, paramArrayOfInt);
  }

  public static <T> ObjectAnimator ofFloat(T paramT, Property<T, Float> paramProperty1, Property<T, Float> paramProperty2, Path paramPath)
  {
    return ObjectAnimator.ofFloat(paramT, paramProperty1, paramProperty2, paramPath);
  }

  public static ObjectAnimator ofFloat(Object paramObject, String paramString1, String paramString2, Path paramPath)
  {
    return ObjectAnimator.ofFloat(paramObject, paramString1, paramString2, paramPath);
  }

  public static <T> ObjectAnimator ofInt(T paramT, Property<T, Integer> paramProperty1, Property<T, Integer> paramProperty2, Path paramPath)
  {
    return ObjectAnimator.ofInt(paramT, paramProperty1, paramProperty2, paramPath);
  }

  public static ObjectAnimator ofInt(Object paramObject, String paramString1, String paramString2, Path paramPath)
  {
    return ObjectAnimator.ofInt(paramObject, paramString1, paramString2, paramPath);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.internal.ObjectAnimatorCompatLollipop
 * JD-Core Version:    0.6.2
 */