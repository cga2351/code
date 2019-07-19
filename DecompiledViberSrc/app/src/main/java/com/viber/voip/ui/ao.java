package com.viber.voip.ui;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.viber.common.d.a;
import com.viber.voip.R.attr;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;

public class ao
{
  private final Toolbar a;
  private int b;

  public ao(Toolbar paramToolbar)
  {
    this(paramToolbar, dc.d(paramToolbar.getContext(), R.attr.menuItemIconTint));
  }

  public ao(Toolbar paramToolbar, int paramInt)
  {
    this.a = paramToolbar;
    this.b = paramInt;
  }

  public static void a(Toolbar paramToolbar)
  {
    Drawable localDrawable1 = paramToolbar.getNavigationIcon();
    Drawable localDrawable2 = paramToolbar.getOverflowIcon();
    int[] arrayOfInt = { 16842910, -16842919 };
    if (localDrawable1 != null)
    {
      paramToolbar.setNavigationIcon(null);
      localDrawable1.setState(arrayOfInt);
      paramToolbar.setNavigationIcon(localDrawable1);
    }
    if (localDrawable2 != null)
    {
      paramToolbar.setOverflowIcon(null);
      localDrawable2.setState(arrayOfInt);
      paramToolbar.setOverflowIcon(localDrawable2);
    }
  }

  public void a()
  {
    this.a.setNavigationIcon(df.a(this.a.getNavigationIcon(), this.b, true));
    this.a.setOverflowIcon(df.a(this.a.getOverflowIcon(), this.b, true));
    if (!a.g())
      a(this.a);
    Menu localMenu = this.a.getMenu();
    if (localMenu != null)
    {
      int i = 0;
      int j = localMenu.size();
      if (i < j)
      {
        MenuItem localMenuItem = localMenu.getItem(i);
        if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null));
        while (true)
        {
          i++;
          break;
          MenuItemCompat.setIconTintList(localMenuItem, ColorStateList.valueOf(this.b));
        }
      }
    }
  }

  public void a(int paramInt)
  {
    if (this.b == paramInt)
      return;
    this.b = paramInt;
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ao
 * JD-Core Version:    0.6.2
 */