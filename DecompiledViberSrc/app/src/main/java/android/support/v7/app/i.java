package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

class i extends a
{
  DecorToolbar a;
  boolean b;
  Window.Callback c;
  private boolean d;
  private boolean e;
  private ArrayList<a.b> f = new ArrayList();
  private final Runnable g = new Runnable()
  {
    public void run()
    {
      i.this.q();
    }
  };
  private final Toolbar.OnMenuItemClickListener h = new Toolbar.OnMenuItemClickListener()
  {
    public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      return i.this.c.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };

  i(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.a = new ToolbarWidgetWrapper(paramToolbar, false);
    this.c = new c(paramCallback);
    this.a.setWindowCallback(this.c);
    paramToolbar.setOnMenuItemClickListener(this.h);
    this.a.setWindowTitle(paramCharSequence);
  }

  private Menu r()
  {
    if (!this.d)
    {
      this.a.setMenuCallbacks(new a(), new b());
      this.d = true;
    }
    return this.a.getMenu();
  }

  public View a()
  {
    return this.a.getCustomView();
  }

  public void a(float paramFloat)
  {
    ViewCompat.setElevation(this.a.getViewGroup(), paramFloat);
  }

  public void a(int paramInt)
  {
    this.a.setIcon(paramInt);
  }

  public void a(int paramInt1, int paramInt2)
  {
    int i = this.a.getDisplayOptions();
    this.a.setDisplayOptions(paramInt1 & paramInt2 | i & (paramInt2 ^ 0xFFFFFFFF));
  }

  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
  }

  public void a(Drawable paramDrawable)
  {
    this.a.setBackgroundDrawable(paramDrawable);
  }

  public void a(View paramView)
  {
    a(paramView, new a.a(-2, -2));
  }

  public void a(View paramView, a.a parama)
  {
    if (paramView != null)
      paramView.setLayoutParams(parama);
    this.a.setCustomView(paramView);
  }

  public void a(CharSequence paramCharSequence)
  {
    this.a.setTitle(paramCharSequence);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 2; ; i = 0)
    {
      a(i, 2);
      return;
    }
  }

  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = r();
    boolean bool1 = false;
    int i;
    if (localMenu != null)
    {
      if (paramKeyEvent == null)
        break label59;
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1)
        break label65;
    }
    label59: label65: for (boolean bool2 = true; ; bool2 = false)
    {
      localMenu.setQwertyMode(bool2);
      bool1 = localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      return bool1;
      i = -1;
      break;
    }
  }

  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1)
      k();
    return true;
  }

  public CharSequence b()
  {
    return this.a.getTitle();
  }

  public void b(int paramInt)
  {
    DecorToolbar localDecorToolbar = this.a;
    if (paramInt != 0);
    for (CharSequence localCharSequence = this.a.getContext().getText(paramInt); ; localCharSequence = null)
    {
      localDecorToolbar.setTitle(localCharSequence);
      return;
    }
  }

  public void b(CharSequence paramCharSequence)
  {
    this.a.setSubtitle(paramCharSequence);
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 4; ; i = 0)
    {
      a(i, 4);
      return;
    }
  }

  public CharSequence c()
  {
    return this.a.getSubtitle();
  }

  public void c(int paramInt)
  {
    DecorToolbar localDecorToolbar = this.a;
    if (paramInt != 0);
    for (CharSequence localCharSequence = this.a.getContext().getText(paramInt); ; localCharSequence = null)
    {
      localDecorToolbar.setSubtitle(localCharSequence);
      return;
    }
  }

  public void c(CharSequence paramCharSequence)
  {
    this.a.setWindowTitle(paramCharSequence);
  }

  public void c(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 8; ; i = 0)
    {
      a(i, 8);
      return;
    }
  }

  public int d()
  {
    return this.a.getDisplayOptions();
  }

  public void d(int paramInt)
  {
    this.a.setNavigationIcon(paramInt);
  }

  public void d(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 16; ; i = 0)
    {
      a(i, 16);
      return;
    }
  }

  public int e()
  {
    return this.a.getHeight();
  }

  public void e(int paramInt)
  {
    this.a.setNavigationContentDescription(paramInt);
  }

  public void e(boolean paramBoolean)
  {
  }

  public void f()
  {
    this.a.setVisibility(0);
  }

  public void g()
  {
    this.a.setVisibility(8);
  }

  public void g(boolean paramBoolean)
  {
  }

  public void h(boolean paramBoolean)
  {
  }

  public boolean h()
  {
    return this.a.getVisibility() == 0;
  }

  public Context i()
  {
    return this.a.getContext();
  }

  public void i(boolean paramBoolean)
  {
    if (paramBoolean == this.e);
    while (true)
    {
      return;
      this.e = paramBoolean;
      int i = this.f.size();
      for (int j = 0; j < i; j++)
        ((a.b)this.f.get(j)).a(paramBoolean);
    }
  }

  public boolean k()
  {
    return this.a.showOverflowMenu();
  }

  public boolean l()
  {
    return this.a.hideOverflowMenu();
  }

  public boolean m()
  {
    this.a.getViewGroup().removeCallbacks(this.g);
    ViewCompat.postOnAnimation(this.a.getViewGroup(), this.g);
    return true;
  }

  public boolean n()
  {
    if (this.a.hasExpandedActionView())
    {
      this.a.collapseActionView();
      return true;
    }
    return false;
  }

  void o()
  {
    this.a.getViewGroup().removeCallbacks(this.g);
  }

  public Window.Callback p()
  {
    return this.c;
  }

  void q()
  {
    Menu localMenu = r();
    h localh;
    if ((localMenu instanceof h))
      localh = (h)localMenu;
    while (true)
    {
      if (localh != null)
        localh.h();
      try
      {
        localMenu.clear();
        if ((!this.c.onCreatePanelMenu(0, localMenu)) || (!this.c.onPreparePanel(0, null, localMenu)))
          localMenu.clear();
        return;
        localh = null;
      }
      finally
      {
        if (localh != null)
          localh.i();
      }
    }
  }

  private final class a
    implements o.a
  {
    private boolean b;

    a()
    {
    }

    public void onCloseMenu(h paramh, boolean paramBoolean)
    {
      if (this.b)
        return;
      this.b = true;
      i.this.a.dismissPopupMenus();
      if (i.this.c != null)
        i.this.c.onPanelClosed(108, paramh);
      this.b = false;
    }

    public boolean onOpenSubMenu(h paramh)
    {
      if (i.this.c != null)
      {
        i.this.c.onMenuOpened(108, paramh);
        return true;
      }
      return false;
    }
  }

  private final class b
    implements h.a
  {
    b()
    {
    }

    public boolean onMenuItemSelected(h paramh, MenuItem paramMenuItem)
    {
      return false;
    }

    public void onMenuModeChange(h paramh)
    {
      if (i.this.c != null)
      {
        if (!i.this.a.isOverflowMenuShowing())
          break label41;
        i.this.c.onPanelClosed(108, paramh);
      }
      label41: 
      while (!i.this.c.onPreparePanel(0, null, paramh))
        return;
      i.this.c.onMenuOpened(108, paramh);
    }
  }

  private class c extends android.support.v7.view.i
  {
    public c(Window.Callback arg2)
    {
      super();
    }

    public View onCreatePanelView(int paramInt)
    {
      if (paramInt == 0)
        return new View(i.this.a.getContext());
      return super.onCreatePanelView(paramInt);
    }

    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!i.this.b))
      {
        i.this.a.setMenuPrepared();
        i.this.b = true;
      }
      return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.i
 * JD-Core Version:    0.6.2
 */