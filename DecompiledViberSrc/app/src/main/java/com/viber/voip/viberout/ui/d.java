package com.viber.voip.viberout.ui;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.viber.common.b.b;
import com.viber.voip.R.color;
import com.viber.voip.R.string;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.a.a;
import com.viber.voip.settings.d.bj;
import com.viber.voip.util.bp;
import com.viber.voip.util.da;
import java.util.Locale;

public class d
{
  private static Spannable a(int paramInt1, int paramInt2, Spannable paramSpannable, Context paramContext)
  {
    if ((paramInt1 >= 0) && (paramInt1 < paramInt2))
      paramSpannable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(paramContext, R.color.mantis)), paramInt1, paramInt2, 17);
    return paramSpannable;
  }

  public static CharSequence a(String paramString, int paramInt, Context paramContext)
  {
    Spannable localSpannable;
    if ((paramString == null) || ("no_balance".equals(paramString)))
      if (paramInt > 0)
      {
        int i = R.string.active_plans_count;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(paramInt);
        SpannableString localSpannableString1 = new SpannableString(paramContext.getString(i, arrayOfObject1));
        localSpannable = a(0, localSpannableString1.length(), localSpannableString1, paramContext);
      }
    SpannableString localSpannableString2;
    int k;
    do
    {
      do
      {
        return localSpannable;
        return a(paramString, paramContext);
        if (paramInt <= 0)
          break;
        int j = R.string.balance_plans_label;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = paramString;
        arrayOfObject2[1] = Integer.valueOf(paramInt);
        localSpannableString2 = new SpannableString(paramContext.getString(j, arrayOfObject2));
        localSpannable = a(0, localSpannableString2.length(), localSpannableString2, paramContext);
      }
      while (!a());
      k = paramContext.getString(R.string.balance_plans_label).indexOf("%1$s");
    }
    while (k < 0);
    b(k, k + paramString.length(), localSpannableString2, paramContext);
    return localSpannable;
    if (a())
      return b(0, paramString.length(), new SpannableString(paramString), paramContext);
    return a(0, paramString.length(), new SpannableString(paramString), paramContext);
  }

  public static CharSequence a(String paramString, Context paramContext)
  {
    if (paramString == null)
      paramString = paramContext.getString(R.string.viberout_not_available_credit);
    while (!"no_balance".equals(paramString))
      return paramString;
    g localg = g.a();
    a.a locala;
    if (bp.a(paramContext))
      if (d.bj.a.d())
        locala = a.a.h;
    while ((locala != null) && (localg.a(locala)) && (!da.b(localg.a(locala, false))))
    {
      String str = localg.a(locala, true);
      return a(0, str.length(), new SpannableString(str), paramContext);
      locala = a.a.g;
      continue;
      boolean bool = bp.a(paramContext.getResources()).getLanguage().startsWith("ru");
      locala = null;
      if (bool)
        locala = a.a.f;
    }
    if (d.bj.a.d())
      return paramContext.getString(R.string.viberout_no_credit);
    return paramContext.getString(R.string.vo_my_account_marketing);
  }

  private static boolean a()
  {
    return d.bj.g.d();
  }

  private static Spannable b(int paramInt1, int paramInt2, Spannable paramSpannable, Context paramContext)
  {
    if ((paramInt1 >= 0) && (paramInt1 < paramInt2))
      paramSpannable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(paramContext, R.color.balance_low)), paramInt1, paramInt2, 17);
    return paramSpannable;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.d
 * JD-Core Version:    0.6.2
 */