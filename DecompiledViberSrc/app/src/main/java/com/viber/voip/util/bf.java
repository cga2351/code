package com.viber.voip.util;

import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;

public class bf
{
  public static <T> T a(Spanned paramSpanned, Class<T> paramClass)
  {
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramSpanned.length(), paramClass);
    if (arrayOfObject.length == 0)
      return null;
    return arrayOfObject[(-1 + arrayOfObject.length)];
  }

  public static void a(Editable paramEditable, Class<?> paramClass, Object[] paramArrayOfObject)
  {
    Object localObject = a(paramEditable, paramClass);
    if (localObject != null)
      a(paramEditable, localObject, paramArrayOfObject);
  }

  public static void a(Editable paramEditable, Object paramObject)
  {
    int i = paramEditable.length();
    paramEditable.setSpan(paramObject, i, i, 17);
  }

  public static void a(Spannable paramSpannable, Object paramObject, Object[] paramArrayOfObject)
  {
    int i = paramSpannable.getSpanStart(paramObject);
    paramSpannable.removeSpan(paramObject);
    int j = paramSpannable.length();
    if (i != j)
    {
      int k = paramArrayOfObject.length;
      for (int m = 0; m < k; m++)
        paramSpannable.setSpan(paramArrayOfObject[m], i, j, 33);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bf
 * JD-Core Version:    0.6.2
 */