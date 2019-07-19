package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.view.MenuItem;
import android.view.SubMenu;

public final class b extends h
{
  public b(Context paramContext)
  {
    super(paramContext);
  }

  protected MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    if (1 + size() > 5)
      throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    h();
    MenuItem localMenuItem = super.a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    if ((localMenuItem instanceof j))
      ((j)localMenuItem).a(true);
    i();
    return localMenuItem;
  }

  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.b
 * JD-Core Version:    0.6.2
 */