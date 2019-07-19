package com.viber.voip.messages.conversation.adapter.viewbinders.helpers;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.a;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.view.View;
import com.viber.voip.util.dj;

public class c
{
  public static int a(ConstraintLayout paramConstraintLayout, a parama)
  {
    int[] arrayOfInt = parama.getReferencedIds();
    int i = 0;
    if (arrayOfInt != null)
    {
      int j = arrayOfInt.length;
      int k = 0;
      while (k < j)
      {
        int m = i + a(paramConstraintLayout, paramConstraintLayout.a(arrayOfInt[k]), true);
        k++;
        i = m;
      }
    }
    return i;
  }

  public static int a(ConstraintLayout paramConstraintLayout, View paramView, boolean paramBoolean)
  {
    int i = 0;
    if (paramView != null)
    {
      int j = paramView.getVisibility();
      i = 0;
      if (j != 8)
      {
        d locald = paramConstraintLayout.a(paramView);
        i = 0 + locald.o();
        if (paramBoolean)
          i += a(locald, c.c.b) + a(locald, c.c.d);
      }
    }
    return i;
  }

  public static int a(d paramd, c.c paramc)
  {
    android.support.constraint.a.a.c localc = paramd.a(paramc);
    if (localc != null)
      return localc.e();
    return 0;
  }

  public static void a(View paramView1, View paramView2, View paramView3, int paramInt)
  {
    if (dj.e(paramView1))
    {
      if ((!dj.e(paramView2)) && (dj.e(paramView3)))
        paramView1.setPadding(paramView1.getPaddingLeft(), 0, paramView1.getPaddingRight(), paramView1.getPaddingBottom());
    }
    else
      return;
    paramView1.setPadding(paramView1.getPaddingLeft(), paramInt, paramView1.getPaddingRight(), paramView1.getPaddingBottom());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.c
 * JD-Core Version:    0.6.2
 */