package com.viber.voip.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;

public class LayoutCompleteAwareLinearLayoutManager extends LinearLayoutManager
{
  private a a;

  public LayoutCompleteAwareLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }

  public LayoutCompleteAwareLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public void a(a parama)
  {
    this.a = parama;
  }

  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    if (this.a != null)
      this.a.a();
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.LayoutCompleteAwareLinearLayoutManager
 * JD-Core Version:    0.6.2
 */