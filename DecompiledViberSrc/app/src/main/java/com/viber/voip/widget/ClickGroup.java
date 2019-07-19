package com.viber.voip.widget;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

public class ClickGroup extends a
{
  private View.OnClickListener f;

  public ClickGroup(Context paramContext)
  {
    super(paramContext);
  }

  public ClickGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ClickGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(ConstraintLayout paramConstraintLayout)
  {
    super.a(paramConstraintLayout);
    for (int i = 0; i < this.b; i++)
    {
      View localView = paramConstraintLayout.a(this.a[i]);
      if (localView != null)
        localView.setOnClickListener(this.f);
    }
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ClickGroup
 * JD-Core Version:    0.6.2
 */