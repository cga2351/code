package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.calls;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.util.AttributeSet;
import android.view.View;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;

public class CallMessageConstraintHelper extends a
{
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l = -1;
  private int m = -1;
  private int n = -1;

  public CallMessageConstraintHelper(Context paramContext)
  {
    super(paramContext);
    setup(null);
  }

  public CallMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setup(paramAttributeSet);
  }

  public CallMessageConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setup(paramAttributeSet);
  }

  private void a(d paramd1, d paramd2, int paramInt1, int paramInt2)
  {
    paramd1.a(paramd1.a(c.c.e));
    paramd1.a(c.c.e, paramd2, c.c.c, paramInt1);
    paramd2.a(paramd2.a(c.c.f));
    paramd2.a(c.c.c, paramd1, c.c.e);
    paramd2.a(c.c.e, paramd2.j(), c.c.e, paramInt2);
  }

  private void a(d paramd1, d paramd2, c.c paramc1, c.c paramc2, int paramInt)
  {
    paramd1.a(paramd1.a(paramc1));
    paramd1.a(paramc1, paramd2, paramc2);
    paramd2.a(paramd2.a(paramc2));
    paramd2.a(paramc2, paramd1, paramc1, paramInt);
  }

  private void a(d paramd1, d paramd2, d paramd3)
  {
    paramd1.a(paramd1.a(c.c.b));
    paramd1.a(c.c.b, paramd2, c.c.b);
    paramd1.a(paramd1.a(c.c.d));
    paramd1.a(c.c.d, paramd3, c.c.d);
  }

  private boolean b()
  {
    return (this.f != 0) && (this.g != 0) && (this.k != 0);
  }

  private void setup(AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CallMessageConstraintHelper);
    this.f = localTypedArray.getResourceId(R.styleable.CallMessageConstraintHelper_balloonViewId, 0);
    this.k = localTypedArray.getResourceId(R.styleable.CallMessageConstraintHelper_callRedialViewId, 0);
    this.i = localTypedArray.getResourceId(R.styleable.CallMessageConstraintHelper_callSubDescriptionViewId, 0);
    this.g = localTypedArray.getResourceId(R.styleable.CallMessageConstraintHelper_callTypeViewId, 0);
    this.h = localTypedArray.getResourceId(R.styleable.CallMessageConstraintHelper_callSubtitleViewId, 0);
    this.j = localTypedArray.getResourceId(R.styleable.CallMessageConstraintHelper_callTimestampViewId, 0);
    localTypedArray.recycle();
    this.l = getResources().getDimensionPixelSize(R.dimen.call_timestamp_top_margin);
    this.m = getResources().getDimensionPixelSize(R.dimen.call_vertical_margin);
    this.n = getResources().getDimensionPixelSize(R.dimen.call_timestamp_left_margin);
  }

  public void c(ConstraintLayout paramConstraintLayout)
  {
    super.c(paramConstraintLayout);
    if (!b());
    View localView6;
    d locald2;
    d locald5;
    label208: label227: 
    do
    {
      d locald4;
      while (true)
      {
        return;
        View localView1 = paramConstraintLayout.a(this.f);
        View localView2 = paramConstraintLayout.a(this.g);
        View localView3 = paramConstraintLayout.a(this.h);
        View localView4 = paramConstraintLayout.a(this.i);
        View localView5 = paramConstraintLayout.a(this.k);
        localView6 = paramConstraintLayout.a(this.j);
        d locald1 = paramConstraintLayout.a(localView1);
        locald2 = paramConstraintLayout.a(localView2);
        d locald3 = paramConstraintLayout.a(localView5);
        locald4 = paramConstraintLayout.a(localView3);
        locald5 = null;
        if (localView3 != null)
          locald5 = paramConstraintLayout.a(localView6);
        boolean bool = "rtl".equals(localView2.getTag());
        if (!bool)
          a(locald1, locald2, locald3);
        while ((localView3 != null) && (localView6 != null))
        {
          if ((localView3.getVisibility() != 0) || (localView4.getVisibility() != 8))
            break label227;
          if (bool)
            break label208;
          a(locald4, locald5, c.c.d, c.c.b, this.n);
          return;
          a(locald1, locald3, locald2);
        }
      }
      a(locald4, locald5, c.c.b, c.c.d, this.n);
      return;
    }
    while (localView6.getVisibility() != 0);
    a(locald2, locald5, this.l, this.m);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.calls.CallMessageConstraintHelper
 * JD-Core Version:    0.6.2
 */