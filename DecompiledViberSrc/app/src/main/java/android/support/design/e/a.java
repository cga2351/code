package android.support.design.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

public class a
{
  public static ColorStateList a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        ColorStateList localColorStateList = android.support.v7.a.a.a.a(paramContext, i);
        if (localColorStateList != null)
          return localColorStateList;
      }
    }
    return paramTypedArray.getColorStateList(paramInt);
  }

  public static Drawable b(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        Drawable localDrawable = android.support.v7.a.a.a.b(paramContext, i);
        if (localDrawable != null)
          return localDrawable;
      }
    }
    return paramTypedArray.getDrawable(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.e.a
 * JD-Core Version:    0.6.2
 */