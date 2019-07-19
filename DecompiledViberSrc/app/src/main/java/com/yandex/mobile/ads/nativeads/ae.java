package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public abstract class ae<T extends aw> extends FrameLayout
{
  private T a;

  public ae(Context paramContext)
  {
    super(paramContext);
  }

  public ae(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ae(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(int paramInt)
  {
    if (this.a != null)
      this.a.a(paramInt);
  }

  protected final void a(T paramT)
  {
    this.a = paramT;
  }

  public T getNativeAd()
  {
    return this.a;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.a != null)
      this.a.b();
  }

  protected void onDetachedFromWindow()
  {
    if (this.a != null)
      this.a.c();
    super.onDetachedFromWindow();
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    new StringBuilder("onVisibilityChanged(), changedView = ").append(paramView).append(", viewVisibility = ").append(paramInt);
    if (this == paramView)
      a(paramInt);
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    new StringBuilder("onWindowVisibilityChanged(), windowVisibility = ").append(paramInt).append(", this.getVisibility = ").append(getVisibility());
    if ((paramInt == 0) && (getVisibility() == 0));
    for (int i = 0; ; i = 8)
    {
      a(i);
      super.onWindowVisibilityChanged(paramInt);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.nativeads.ae
 * JD-Core Version:    0.6.2
 */