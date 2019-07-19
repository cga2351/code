package com.my.target;

import android.content.Context;
import android.view.View;

public final class bz extends View
{
  private a a;
  private final b b = new b();

  public bz(Context paramContext)
  {
    super(paramContext);
  }

  private void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
    this.b.b(hasWindowFocus());
    if (this.b.a())
      if (this.a != null)
        this.a.a(true);
    while ((paramBoolean) || (this.a == null))
      return;
    this.a.a(false);
  }

  public final boolean a()
  {
    return this.b.a();
  }

  final b getViewabilityState()
  {
    return this.b;
  }

  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a(true);
  }

  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a(false);
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(1, 1);
  }

  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.b.b(paramBoolean);
    if (this.b.a())
      if (this.a != null)
        this.a.a(true);
    while ((paramBoolean) || (this.a == null))
      return;
    this.a.a(false);
  }

  public final void setViewabilityListener(a parama)
  {
    this.a = parama;
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }

  static final class b
  {
    private boolean a;
    private boolean b;

    final void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    final boolean a()
    {
      return (this.a) && (this.b);
    }

    final void b(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bz
 * JD-Core Version:    0.6.2
 */