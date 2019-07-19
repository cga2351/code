package com.viber.voip.messages.extensions.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a;
import android.util.AttributeSet;
import android.view.View;
import com.viber.voip.R.styleable;
import com.viber.voip.util.dj;

public class ChatExtensionListConstraintHelper extends a
{
  int f;
  int g;
  int h;
  int i;
  int j;
  private boolean k;
  private boolean l;

  public ChatExtensionListConstraintHelper(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ChatExtensionListConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ChatExtensionListConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ChatExtensionListConstraintHelper);
    try
    {
      this.k = localTypedArray.getBoolean(R.styleable.ChatExtensionListConstraintHelper_recentsSectionVisible, true);
      this.l = localTypedArray.getBoolean(R.styleable.ChatExtensionListConstraintHelper_generalSectionVisible, true);
      this.f = localTypedArray.getResourceId(R.styleable.ChatExtensionListConstraintHelper_recentListLabelViewId, -1);
      this.g = localTypedArray.getResourceId(R.styleable.ChatExtensionListConstraintHelper_recentListViewId, -1);
      this.h = localTypedArray.getResourceId(R.styleable.ChatExtensionListConstraintHelper_dividerViewId, -1);
      this.i = localTypedArray.getResourceId(R.styleable.ChatExtensionListConstraintHelper_generalListLabelViewId, -1);
      this.j = localTypedArray.getResourceId(R.styleable.ChatExtensionListConstraintHelper_generalListViewId, -1);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public void a(ConstraintLayout paramConstraintLayout)
  {
    super.a(paramConstraintLayout);
    if (!d())
      return;
    View localView1 = paramConstraintLayout.a(this.f);
    View localView2 = paramConstraintLayout.a(this.g);
    View localView3 = paramConstraintLayout.a(this.h);
    View localView4 = paramConstraintLayout.a(this.i);
    View localView5 = paramConstraintLayout.a(this.j);
    dj.b(localView1, this.k);
    dj.b(localView2, this.k);
    dj.b(localView3, this.k);
    dj.b(localView4, this.l);
    dj.b(localView5, this.l);
  }

  public boolean b()
  {
    return this.l;
  }

  public boolean c()
  {
    return this.k;
  }

  protected boolean d()
  {
    return (this.f != -1) && (this.g != -1) && (this.h != -1) && (this.i != -1) && (this.j != -1);
  }

  public void setGeneralSectionVisible(boolean paramBoolean)
  {
    if (paramBoolean != this.l)
    {
      this.l = paramBoolean;
      invalidate();
    }
  }

  public void setRecentsSectionVisible(boolean paramBoolean)
  {
    if (paramBoolean != this.k)
    {
      this.k = paramBoolean;
      invalidate();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.ChatExtensionListConstraintHelper
 * JD-Core Version:    0.6.2
 */