package android.support.design.d;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewParent;

public final class c
{
  private final View a;
  private boolean b = false;
  private int c = 0;

  public c(b paramb)
  {
    this.a = ((View)paramb);
  }

  private void d()
  {
    ViewParent localViewParent = this.a.getParent();
    if ((localViewParent instanceof CoordinatorLayout))
      ((CoordinatorLayout)localViewParent).dispatchDependentViewsChanged(this.a);
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(Bundle paramBundle)
  {
    this.b = paramBundle.getBoolean("expanded", false);
    this.c = paramBundle.getInt("expandedComponentIdHint", 0);
    if (this.b)
      d();
  }

  public boolean a()
  {
    return this.b;
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      d();
      return true;
    }
    return false;
  }

  public Bundle b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", this.b);
    localBundle.putInt("expandedComponentIdHint", this.c);
    return localBundle;
  }

  public int c()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.d.c
 * JD-Core Version:    0.6.2
 */