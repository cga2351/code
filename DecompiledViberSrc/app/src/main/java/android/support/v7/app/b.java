package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.b.a.d;
import android.view.View;

public class b
  implements DrawerLayout.DrawerListener
{
  boolean a;
  private final a b;
  private d c;
  private boolean d;
  private final int e;
  private final int f;

  private void a(float paramFloat)
  {
    if (paramFloat == 1.0F)
      this.c.a(true);
    while (true)
    {
      this.c.a(paramFloat);
      return;
      if (paramFloat == 0.0F)
        this.c.a(false);
    }
  }

  void a(int paramInt)
  {
    this.b.a(paramInt);
  }

  public void onDrawerClosed(View paramView)
  {
    a(0.0F);
    if (this.a)
      a(this.e);
  }

  public void onDrawerOpened(View paramView)
  {
    a(1.0F);
    if (this.a)
      a(this.f);
  }

  public void onDrawerSlide(View paramView, float paramFloat)
  {
    if (this.d)
    {
      a(Math.min(1.0F, Math.max(0.0F, paramFloat)));
      return;
    }
    a(0.0F);
  }

  public void onDrawerStateChanged(int paramInt)
  {
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.b
 * JD-Core Version:    0.6.2
 */