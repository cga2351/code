package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.MenuPopupWindow;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class t extends m
  implements o, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static final int e = R.layout.abc_popup_menu_item_layout;
  final MenuPopupWindow a;
  final ViewTreeObserver.OnGlobalLayoutListener b = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if ((t.this.isShowing()) && (!t.this.a.isModal()))
      {
        View localView = t.this.c;
        if ((localView == null) || (!localView.isShown()))
          t.this.dismiss();
      }
      else
      {
        return;
      }
      t.this.a.show();
    }
  };
  View c;
  ViewTreeObserver d;
  private final Context f;
  private final h g;
  private final g h;
  private final boolean i;
  private final int j;
  private final int k;
  private final int l;
  private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener()
  {
    public void onViewAttachedToWindow(View paramAnonymousView)
    {
    }

    public void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (t.this.d != null)
      {
        if (!t.this.d.isAlive())
          t.this.d = paramAnonymousView.getViewTreeObserver();
        t.this.d.removeGlobalOnLayoutListener(t.this.b);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private PopupWindow.OnDismissListener n;
  private View o;
  private o.a p;
  private boolean q;
  private boolean r;
  private int s;
  private int t = 0;
  private boolean u;

  public t(Context paramContext, h paramh, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.f = paramContext;
    this.g = paramh;
    this.i = paramBoolean;
    this.h = new g(paramh, LayoutInflater.from(paramContext), this.i, e);
    this.k = paramInt1;
    this.l = paramInt2;
    Resources localResources = paramContext.getResources();
    this.j = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.o = paramView;
    this.a = new MenuPopupWindow(this.f, null, this.k, this.l);
    paramh.a(this, paramContext);
  }

  private boolean c()
  {
    if (isShowing())
      return true;
    if ((this.q) || (this.o == null))
      return false;
    this.c = this.o;
    this.a.setOnDismissListener(this);
    this.a.setOnItemClickListener(this);
    this.a.setModal(true);
    View localView = this.c;
    if (this.d == null);
    for (int i1 = 1; ; i1 = 0)
    {
      this.d = localView.getViewTreeObserver();
      if (i1 != 0)
        this.d.addOnGlobalLayoutListener(this.b);
      localView.addOnAttachStateChangeListener(this.m);
      this.a.setAnchorView(localView);
      this.a.setDropDownGravity(this.t);
      if (!this.r)
      {
        this.s = a(this.h, null, this.f, this.j);
        this.r = true;
      }
      this.a.setContentWidth(this.s);
      this.a.setInputMethodMode(2);
      this.a.setEpicenterBounds(b());
      this.a.show();
      ListView localListView = this.a.getListView();
      localListView.setOnKeyListener(this);
      if ((this.u) && (this.g.n() != null))
      {
        FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(this.f).inflate(R.layout.abc_popup_menu_header_item_layout, localListView, false);
        TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
        if (localTextView != null)
          localTextView.setText(this.g.n());
        localFrameLayout.setEnabled(false);
        localListView.addHeaderView(localFrameLayout, null, false);
      }
      this.a.setAdapter(this.h);
      this.a.show();
      return true;
    }
  }

  public void a(int paramInt)
  {
    this.t = paramInt;
  }

  public void a(h paramh)
  {
  }

  public void a(View paramView)
  {
    this.o = paramView;
  }

  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.n = paramOnDismissListener;
  }

  public void a(boolean paramBoolean)
  {
    this.h.a(paramBoolean);
  }

  public void b(int paramInt)
  {
    this.a.setHorizontalOffset(paramInt);
  }

  public void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }

  public void c(int paramInt)
  {
    this.a.setVerticalOffset(paramInt);
  }

  public void dismiss()
  {
    if (isShowing())
      this.a.dismiss();
  }

  public boolean flagActionItems()
  {
    return false;
  }

  public ListView getListView()
  {
    return this.a.getListView();
  }

  public boolean isShowing()
  {
    return (!this.q) && (this.a.isShowing());
  }

  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    if (paramh != this.g);
    do
    {
      return;
      dismiss();
    }
    while (this.p == null);
    this.p.onCloseMenu(paramh, paramBoolean);
  }

  public void onDismiss()
  {
    this.q = true;
    this.g.close();
    if (this.d != null)
    {
      if (!this.d.isAlive())
        this.d = this.c.getViewTreeObserver();
      this.d.removeGlobalOnLayoutListener(this.b);
      this.d = null;
    }
    this.c.removeOnAttachStateChangeListener(this.m);
    if (this.n != null)
      this.n.onDismiss();
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      dismiss();
      return true;
    }
    return false;
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
  }

  public Parcelable onSaveInstanceState()
  {
    return null;
  }

  public boolean onSubMenuSelected(u paramu)
  {
    if (paramu.hasVisibleItems())
    {
      n localn = new n(this.f, paramu, this.c, this.i, this.k, this.l);
      localn.setPresenterCallback(this.p);
      localn.setForceShowIcon(m.b(paramu));
      localn.setOnDismissListener(this.n);
      this.n = null;
      this.g.b(false);
      int i1 = this.a.getHorizontalOffset();
      int i2 = this.a.getVerticalOffset();
      if ((0x7 & Gravity.getAbsoluteGravity(this.t, ViewCompat.getLayoutDirection(this.o))) == 5)
        i1 += this.o.getWidth();
      if (localn.tryShow(i1, i2))
      {
        if (this.p != null)
          this.p.onOpenSubMenu(paramu);
        return true;
      }
    }
    return false;
  }

  public void setCallback(o.a parama)
  {
    this.p = parama;
  }

  public void show()
  {
    if (!c())
      throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }

  public void updateMenuView(boolean paramBoolean)
  {
    this.r = false;
    if (this.h != null)
      this.h.notifyDataSetChanged();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.t
 * JD-Core Version:    0.6.2
 */