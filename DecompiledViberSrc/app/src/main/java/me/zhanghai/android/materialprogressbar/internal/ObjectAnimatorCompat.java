package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.util.Property;

public class ObjectAnimatorCompat
{
  public static <T> ObjectAnimator ofArgb(T paramT, Property<T, Integer> paramProperty, int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ObjectAnimatorCompatLollipop.ofArgb(paramT, paramProperty, paramArrayOfInt);
    return ObjectAnimatorCompatBase.ofArgb(paramT, paramProperty, paramArrayOfInt);
  }

  public static ObjectAnimator ofArgb(Object paramObject, String paramString, int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ObjectAnimatorCompatLollipop.ofArgb(paramObject, paramString, paramArrayOfInt);
    return ObjectAnimatorCompatBase.ofArgb(paramObject, paramString, paramArrayOfInt);
  }

  public static <T> ObjectAnimator ofFloat(T paramT, Property<T, Float> paramProperty1, Property<T, Float> paramProperty2, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ObjectAnimatorCompatLollipop.ofFloat(paramT, paramProperty1, paramProperty2, paramPath);
    return ObjectAnimatorCompatBase.ofFloat(paramT, paramProperty1, paramProperty2, paramPath);
  }

  public static ObjectAnimator ofFloat(Object paramObject, String paramString1, String paramString2, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ObjectAnimatorCompatLollipop.ofFloat(paramObject, paramString1, paramString2, paramPath);
    return ObjectAnimatorCompatBase.ofFloat(paramObject, paramString1, paramString2, paramPath);
  }

  public static <T> ObjectAnimator ofInt(T paramT, Property<T, Integer> paramProperty1, Property<T, Integer> paramProperty2, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ObjectAnimatorCompatLollipop.ofInt(paramT, paramProperty1, paramProperty2, paramPath);
    return ObjectAnimatorCompatBase.ofInt(paramT, paramProperty1, paramProperty2, paramPath);
  }

  public static ObjectAnimator ofInt(Object paramObject, String paramString1, String paramString2, Path paramPath)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return ObjectAnimatorCompatLollipop.ofInt(paramObject, paramString1, paramString2, paramPath);
    return ObjectAnimatorCompatBase.ofInt(paramObject, paramString1, paramString2, paramPath);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.internal.ObjectAnimatorCompat
 * JD-Core Version:    0.6.2
 */