package com.viber.voip.util;

import android.graphics.drawable.Drawable;
import android.support.v4.text.BidiFormatter;
import android.view.View;
import android.widget.TextView;
import com.viber.common.d.c;

public final class co
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.insert(0, "‏");
    return localStringBuilder.toString();
  }

  public static String a(String paramString, BidiFormatter paramBidiFormatter)
  {
    if (paramString == null)
      return null;
    if (paramBidiFormatter == null)
      paramBidiFormatter = BidiFormatter.getInstance();
    if (paramBidiFormatter.isRtl(paramString))
      return "‎‏" + paramString + "‎";
    return "‎" + paramString + "‎";
  }

  public static void a(View paramView)
  {
    int i = paramView.getPaddingLeft();
    paramView.setPadding(paramView.getPaddingRight(), paramView.getPaddingTop(), i, paramView.getPaddingBottom());
  }

  public static void a(TextView paramTextView, Drawable paramDrawable)
  {
    if (c.a())
    {
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramDrawable, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
  }

  public static String b(String paramString)
  {
    return "‎" + paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.co
 * JD-Core Version:    0.6.2
 */