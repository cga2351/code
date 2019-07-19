package com.viber.voip.messages.conversation.adapter.viewbinders.helpers;

import android.content.Context;
import android.content.res.Configuration;
import android.support.constraint.ConstraintLayout;
import android.support.v4.util.CircularArray;
import android.util.AttributeSet;

public abstract class a extends android.support.constraint.a
{
  protected CircularArray<b> f = new CircularArray();
  private boolean g = false;

  public a(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  protected abstract void a(Context paramContext, AttributeSet paramAttributeSet);

  public void a(ConstraintLayout paramConstraintLayout)
  {
    super.a(paramConstraintLayout);
    int i = this.f.size();
    for (int j = 0; j < i; j++)
      ((b)this.f.get(j)).d(paramConstraintLayout, this);
    if (this.g)
    {
      this.g = false;
      paramConstraintLayout.requestLayout();
    }
  }

  protected final void a(b paramb)
  {
    this.f.addLast(paramb);
  }

  public void b(ConstraintLayout paramConstraintLayout)
  {
    super.b(paramConstraintLayout);
    int i = this.f.size();
    for (int j = 0; j < i; j++)
      ((b)this.f.get(j)).e(paramConstraintLayout, this);
  }

  public void c(ConstraintLayout paramConstraintLayout)
  {
    super.c(paramConstraintLayout);
    int i = this.f.size();
    for (int j = 0; j < i; j++)
      ((b)this.f.get(j)).f(paramConstraintLayout, this);
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.g = true;
    int i = this.f.size();
    for (int j = 0; j < i; j++)
      ((b)this.f.get(j)).b(paramConfiguration);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.a
 * JD-Core Version:    0.6.2
 */