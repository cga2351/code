package com.viber.voip.ui;

import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.appcompat.R.id;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dc;

public class MenuSearchMediator extends ac
{
  protected static final Logger a = ViberEnv.getLogger();
  public static boolean b;
  private MenuItem d;
  private ViberSearchView e;

  public MenuSearchMediator()
  {
    super(null);
  }

  public MenuSearchMediator(ac.a parama)
  {
    super(parama);
  }

  public String a()
  {
    if (this.e != null)
      return this.e.getQuery().toString();
    return "";
  }

  public void a(MenuItem paramMenuItem, boolean paramBoolean, String paramString)
  {
    this.d = paramMenuItem;
    MenuItemCompat.setOnActionExpandListener(this.d, new MenuItemCompat.OnActionExpandListener()
    {
      public boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
      {
        boolean bool1 = true;
        boolean bool2 = MenuSearchMediator.a(MenuSearchMediator.this).isCollapsable();
        MenuSearchMediator.b = false;
        if ((MenuSearchMediator.this.c == null) || (((MenuSearchMediator.ViberSearchView.access$100(MenuSearchMediator.a(MenuSearchMediator.this))) || (bool2)) && (MenuSearchMediator.this.c.onSearchViewShow(false))));
        while (true)
        {
          MenuSearchMediator.ViberSearchView.access$102(MenuSearchMediator.a(MenuSearchMediator.this), false);
          if (bool1)
            MenuSearchMediator.this.b();
          return bool1;
          bool1 = false;
        }
      }

      public boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
      {
        boolean bool = true;
        MenuSearchMediator.b = bool;
        if (MenuSearchMediator.this.c != null)
          bool = MenuSearchMediator.this.c.onSearchViewShow(bool);
        return bool;
      }
    });
    this.e = ((ViberSearchView)MenuItemCompat.getActionView(this.d));
    SearchView.OnQueryTextListener local2;
    if (this.e != null)
    {
      local2 = new SearchView.OnQueryTextListener()
      {
        public boolean onQueryTextChange(String paramAnonymousString)
        {
          return (MenuSearchMediator.this.c != null) && (MenuSearchMediator.this.c.onQueryTextChange(paramAnonymousString));
        }

        public boolean onQueryTextSubmit(String paramAnonymousString)
        {
          return (MenuSearchMediator.this.c != null) && (MenuSearchMediator.this.c.onQueryTextSubmit(paramAnonymousString));
        }
      };
      if (!paramBoolean)
      {
        this.e.setQuery(paramString, false);
        this.e.setOnQueryTextListener(local2);
      }
    }
    else
    {
      return;
    }
    this.e.setQueryOnExpand(paramString, local2);
    this.d.expandActionView();
  }

  public void a(String paramString)
  {
    if (this.e != null)
    {
      ViberSearchView localViberSearchView = this.e;
      if (paramString == null)
        paramString = "";
      localViberSearchView.setQuery(paramString, true);
    }
  }

  public void a(boolean paramBoolean)
  {
    if (this.d != null)
      this.d.setVisible(paramBoolean);
  }

  public void b()
  {
    this.e.setQuery("", false);
  }

  public void b(boolean paramBoolean)
  {
    if (this.e != null)
    {
      this.e.setFocusable(paramBoolean);
      this.e.clearFocus();
    }
  }

  public View c()
  {
    return this.e;
  }

  public void d()
  {
    if (this.d != null)
      this.d.expandActionView();
  }

  public boolean e()
  {
    if (this.d != null)
      return this.d.isActionViewExpanded();
    return false;
  }

  public void f()
  {
    if (this.d != null)
      this.d.collapseActionView();
  }

  public void g()
  {
    if (this.d != null)
    {
      ViberSearchView.access$202(this.e, true);
      this.d.collapseActionView();
    }
  }

  public void h()
  {
    this.e.requestForcedHide();
  }

  public static class ViberSearchView extends SearchView
  {
    Runnable mCollapsableStateRunnable;
    private boolean mIsCollapsable = true;
    private boolean mIsForcedHideRequested;
    private SearchView.OnQueryTextListener mListener;
    private boolean mPostInit;
    private CharSequence mQuery;

    public ViberSearchView(Context paramContext)
    {
      super();
      this.mCollapsableStateRunnable = new u(this);
      init(paramContext);
    }

    public ViberSearchView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      this.mCollapsableStateRunnable = new v(this);
      init(paramContext);
    }

    public ViberSearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      this.mCollapsableStateRunnable = new w(this);
      init(paramContext);
    }

    void init(Context paramContext)
    {
      AppCompatAutoCompleteTextView localAppCompatAutoCompleteTextView = (AppCompatAutoCompleteTextView)findViewById(R.id.search_src_text);
      localAppCompatAutoCompleteTextView.setTextColor(dc.d(paramContext, R.attr.toolbarTextSearchViewColor));
      localAppCompatAutoCompleteTextView.setHintTextColor(dc.d(paramContext, R.attr.toolbarHintSearchViewColor));
    }

    public boolean isCollapsable()
    {
      return this.mIsCollapsable;
    }

    public void onActionViewExpanded()
    {
      super.onActionViewExpanded();
      if (this.mPostInit)
      {
        this.mPostInit = false;
        boolean bool = TextUtils.isEmpty(this.mQuery);
        if (!bool)
          setQuery(this.mQuery, false);
        setOnQueryTextListener(this.mListener);
        if (!bool)
          this.mListener.onQueryTextChange(this.mQuery.toString());
        this.mListener = null;
        this.mQuery = null;
      }
    }

    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      if (paramBoolean)
        postDelayed(this.mCollapsableStateRunnable, 100L);
      do
      {
        return;
        removeCallbacks(this.mCollapsableStateRunnable);
      }
      while (this.mIsForcedHideRequested);
      this.mIsCollapsable = false;
    }

    public void requestForcedHide()
    {
      this.mIsForcedHideRequested = true;
    }

    public void setQueryOnExpand(CharSequence paramCharSequence, SearchView.OnQueryTextListener paramOnQueryTextListener)
    {
      this.mPostInit = true;
      this.mQuery = paramCharSequence;
      this.mListener = paramOnQueryTextListener;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.MenuSearchMediator
 * JD-Core Version:    0.6.2
 */