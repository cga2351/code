package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.layout;
import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.MenuPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class e extends m
  implements o, View.OnKeyListener, PopupWindow.OnDismissListener
{
  private static final int g = R.layout.abc_cascading_menu_item_layout;
  private PopupWindow.OnDismissListener A;
  final Handler a;
  final List<a> b = new ArrayList();
  final ViewTreeObserver.OnGlobalLayoutListener c = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public void onGlobalLayout()
    {
      if ((e.this.isShowing()) && (e.this.b.size() > 0) && (!((e.a)e.this.b.get(0)).a.isModal()))
      {
        View localView = e.this.d;
        if ((localView != null) && (localView.isShown()))
          break label77;
        e.this.dismiss();
      }
      while (true)
      {
        return;
        label77: Iterator localIterator = e.this.b.iterator();
        while (localIterator.hasNext())
          ((e.a)localIterator.next()).a.show();
      }
    }
  };
  View d;
  ViewTreeObserver e;
  boolean f;
  private final Context h;
  private final int i;
  private final int j;
  private final int k;
  private final boolean l;
  private final List<h> m = new ArrayList();
  private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener()
  {
    public void onViewAttachedToWindow(View paramAnonymousView)
    {
    }

    public void onViewDetachedFromWindow(View paramAnonymousView)
    {
      if (e.this.e != null)
      {
        if (!e.this.e.isAlive())
          e.this.e = paramAnonymousView.getViewTreeObserver();
        e.this.e.removeGlobalOnLayoutListener(e.this.c);
      }
      paramAnonymousView.removeOnAttachStateChangeListener(this);
    }
  };
  private final MenuItemHoverListener o = new MenuItemHoverListener()
  {
    public void onItemHoverEnter(final h paramAnonymoush, final MenuItem paramAnonymousMenuItem)
    {
      e.this.a.removeCallbacksAndMessages(null);
      int i = 0;
      int j = e.this.b.size();
      if (i < j)
        if (paramAnonymoush != ((e.a)e.this.b.get(i)).b);
      for (int k = i; ; k = -1)
      {
        if (k == -1)
        {
          return;
          i++;
          break;
        }
        int m = k + 1;
        if (m < e.this.b.size());
        for (final e.a locala = (e.a)e.this.b.get(m); ; locala = null)
        {
          Runnable local1 = new Runnable()
          {
            public void run()
            {
              if (locala != null)
              {
                e.this.f = true;
                locala.b.b(false);
                e.this.f = false;
              }
              if ((paramAnonymousMenuItem.isEnabled()) && (paramAnonymousMenuItem.hasSubMenu()))
                paramAnonymoush.a(paramAnonymousMenuItem, 4);
            }
          };
          long l = 200L + SystemClock.uptimeMillis();
          e.this.a.postAtTime(local1, paramAnonymoush, l);
          return;
        }
      }
    }

    public void onItemHoverExit(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
    {
      e.this.a.removeCallbacksAndMessages(paramAnonymoush);
    }
  };
  private int p = 0;
  private int q = 0;
  private View r;
  private int s;
  private boolean t;
  private boolean u;
  private int v;
  private int w;
  private boolean x;
  private boolean y;
  private o.a z;

  public e(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.h = paramContext;
    this.r = paramView;
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramBoolean;
    this.x = false;
    this.s = d();
    Resources localResources = paramContext.getResources();
    this.i = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    this.a = new Handler();
  }

  private MenuItem a(h paramh1, h paramh2)
  {
    int i1 = paramh1.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      MenuItem localMenuItem = paramh1.getItem(i2);
      if ((localMenuItem.hasSubMenu()) && (paramh2 == localMenuItem.getSubMenu()))
        return localMenuItem;
    }
    return null;
  }

  private View a(a parama, h paramh)
  {
    int i1 = 0;
    MenuItem localMenuItem = a(parama.b, paramh);
    if (localMenuItem == null)
      return null;
    ListView localListView = parama.a();
    ListAdapter localListAdapter = localListView.getAdapter();
    int i2;
    g localg;
    if ((localListAdapter instanceof HeaderViewListAdapter))
    {
      HeaderViewListAdapter localHeaderViewListAdapter = (HeaderViewListAdapter)localListAdapter;
      i2 = localHeaderViewListAdapter.getHeadersCount();
      localg = (g)localHeaderViewListAdapter.getWrappedAdapter();
      int i3 = localg.getCount();
      label72: if (i1 >= i3)
        break label157;
      if (localMenuItem != localg.a(i1))
        break label113;
    }
    label157: for (int i4 = i1; ; i4 = -1)
    {
      if (i4 == -1)
      {
        return null;
        localg = (g)localListAdapter;
        i2 = 0;
        break;
        label113: i1++;
        break label72;
      }
      int i5 = i4 + i2 - localListView.getFirstVisiblePosition();
      if ((i5 < 0) || (i5 >= localListView.getChildCount()))
        return null;
      return localListView.getChildAt(i5);
    }
  }

  private MenuPopupWindow c()
  {
    MenuPopupWindow localMenuPopupWindow = new MenuPopupWindow(this.h, null, this.j, this.k);
    localMenuPopupWindow.setHoverListener(this.o);
    localMenuPopupWindow.setOnItemClickListener(this);
    localMenuPopupWindow.setOnDismissListener(this);
    localMenuPopupWindow.setAnchorView(this.r);
    localMenuPopupWindow.setDropDownGravity(this.q);
    localMenuPopupWindow.setModal(true);
    localMenuPopupWindow.setInputMethodMode(2);
    return localMenuPopupWindow;
  }

  private void c(h paramh)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.h);
    g localg = new g(paramh, localLayoutInflater, this.l, g);
    int i1;
    MenuPopupWindow localMenuPopupWindow;
    View localView;
    a locala1;
    label137: int i3;
    label171: int i5;
    int i4;
    label198: int i6;
    if ((!isShowing()) && (this.x))
    {
      localg.a(true);
      i1 = a(localg, null, this.h, this.i);
      localMenuPopupWindow = c();
      localMenuPopupWindow.setAdapter(localg);
      localMenuPopupWindow.setContentWidth(i1);
      localMenuPopupWindow.setDropDownGravity(this.q);
      if (this.b.size() <= 0)
        break label381;
      a locala3 = (a)this.b.get(-1 + this.b.size());
      localView = a(locala3, paramh);
      locala1 = locala3;
      if (localView == null)
        break label529;
      localMenuPopupWindow.setTouchModal(false);
      localMenuPopupWindow.setEnterTransition(null);
      int i2 = d(i1);
      if (i2 != 1)
        break label390;
      i3 = 1;
      this.s = i2;
      if (Build.VERSION.SDK_INT < 26)
        break label396;
      localMenuPopupWindow.setAnchorView(localView);
      i5 = 0;
      i4 = 0;
      if ((0x5 & this.q) != 5)
        break label501;
      if (i3 == 0)
        break label488;
      i6 = i4 + i1;
      label220: localMenuPopupWindow.setHorizontalOffset(i6);
      localMenuPopupWindow.setOverlapAnchor(true);
      localMenuPopupWindow.setVerticalOffset(i5);
    }
    while (true)
    {
      a locala2 = new a(localMenuPopupWindow, paramh, this.s);
      this.b.add(locala2);
      localMenuPopupWindow.show();
      ListView localListView = localMenuPopupWindow.getListView();
      localListView.setOnKeyListener(this);
      if ((locala1 == null) && (this.y) && (paramh.n() != null))
      {
        FrameLayout localFrameLayout = (FrameLayout)localLayoutInflater.inflate(R.layout.abc_popup_menu_header_item_layout, localListView, false);
        TextView localTextView = (TextView)localFrameLayout.findViewById(16908310);
        localFrameLayout.setEnabled(false);
        localTextView.setText(paramh.n());
        localListView.addHeaderView(localFrameLayout, null, false);
        localMenuPopupWindow.show();
      }
      return;
      if (!isShowing())
        break;
      localg.a(m.b(paramh));
      break;
      label381: localView = null;
      locala1 = null;
      break label137;
      label390: i3 = 0;
      break label171;
      label396: int[] arrayOfInt1 = new int[2];
      this.r.getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      localView.getLocationOnScreen(arrayOfInt2);
      if ((0x7 & this.q) == 5)
      {
        arrayOfInt1[0] += this.r.getWidth();
        arrayOfInt2[0] += localView.getWidth();
      }
      i4 = arrayOfInt2[0] - arrayOfInt1[0];
      i5 = arrayOfInt2[1] - arrayOfInt1[1];
      break label198;
      label488: i6 = i4 - localView.getWidth();
      break label220;
      label501: if (i3 != 0)
      {
        i6 = i4 + localView.getWidth();
        break label220;
      }
      i6 = i4 - i1;
      break label220;
      label529: if (this.t)
        localMenuPopupWindow.setHorizontalOffset(this.v);
      if (this.u)
        localMenuPopupWindow.setVerticalOffset(this.w);
      localMenuPopupWindow.setEpicenterBounds(b());
    }
  }

  private int d()
  {
    int i1 = 1;
    if (ViewCompat.getLayoutDirection(this.r) == i1)
      i1 = 0;
    return i1;
  }

  private int d(int paramInt)
  {
    ListView localListView = ((a)this.b.get(-1 + this.b.size())).a();
    int[] arrayOfInt = new int[2];
    localListView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    this.d.getWindowVisibleDisplayFrame(localRect);
    if (this.s == 1)
    {
      if (paramInt + (arrayOfInt[0] + localListView.getWidth()) > localRect.right)
        return 0;
      return 1;
    }
    if (arrayOfInt[0] - paramInt < 0)
      return 1;
    return 0;
  }

  private int d(h paramh)
  {
    int i1 = 0;
    int i2 = this.b.size();
    while (i1 < i2)
    {
      if (paramh == ((a)this.b.get(i1)).b)
        return i1;
      i1++;
    }
    return -1;
  }

  public void a(int paramInt)
  {
    if (this.p != paramInt)
    {
      this.p = paramInt;
      this.q = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this.r));
    }
  }

  public void a(h paramh)
  {
    paramh.a(this, this.h);
    if (isShowing())
    {
      c(paramh);
      return;
    }
    this.m.add(paramh);
  }

  public void a(View paramView)
  {
    if (this.r != paramView)
    {
      this.r = paramView;
      this.q = GravityCompat.getAbsoluteGravity(this.p, ViewCompat.getLayoutDirection(this.r));
    }
  }

  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.A = paramOnDismissListener;
  }

  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }

  protected boolean a()
  {
    return false;
  }

  public void b(int paramInt)
  {
    this.t = true;
    this.v = paramInt;
  }

  public void b(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }

  public void c(int paramInt)
  {
    this.u = true;
    this.w = paramInt;
  }

  public void dismiss()
  {
    int i1 = this.b.size();
    if (i1 > 0)
    {
      a[] arrayOfa = (a[])this.b.toArray(new a[i1]);
      for (int i2 = i1 - 1; i2 >= 0; i2--)
      {
        a locala = arrayOfa[i2];
        if (locala.a.isShowing())
          locala.a.dismiss();
      }
    }
  }

  public boolean flagActionItems()
  {
    return false;
  }

  public ListView getListView()
  {
    if (this.b.isEmpty())
      return null;
    return ((a)this.b.get(-1 + this.b.size())).a();
  }

  public boolean isShowing()
  {
    return (this.b.size() > 0) && (((a)this.b.get(0)).a.isShowing());
  }

  public void onCloseMenu(h paramh, boolean paramBoolean)
  {
    int i1 = d(paramh);
    if (i1 < 0);
    do
    {
      return;
      int i2 = i1 + 1;
      if (i2 < this.b.size())
        ((a)this.b.get(i2)).b.b(false);
      a locala = (a)this.b.remove(i1);
      locala.b.b(this);
      if (this.f)
      {
        locala.a.setExitTransition(null);
        locala.a.setAnimationStyle(0);
      }
      locala.a.dismiss();
      int i3 = this.b.size();
      if (i3 > 0);
      for (this.s = ((a)this.b.get(i3 - 1)).c; i3 == 0; this.s = d())
      {
        dismiss();
        if (this.z != null)
          this.z.onCloseMenu(paramh, true);
        if (this.e != null)
        {
          if (this.e.isAlive())
            this.e.removeGlobalOnLayoutListener(this.c);
          this.e = null;
        }
        this.d.removeOnAttachStateChangeListener(this.n);
        this.A.onDismiss();
        return;
      }
    }
    while (!paramBoolean);
    ((a)this.b.get(0)).b.b(false);
  }

  public void onDismiss()
  {
    int i1 = this.b.size();
    int i2 = 0;
    a locala;
    if (i2 < i1)
    {
      locala = (a)this.b.get(i2);
      if (locala.a.isShowing());
    }
    while (true)
    {
      if (locala != null)
        locala.b.b(false);
      return;
      i2++;
      break;
      locala = null;
    }
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
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramu == locala.b)
      {
        locala.a().requestFocus();
        return true;
      }
    }
    if (paramu.hasVisibleItems())
    {
      a(paramu);
      if (this.z != null)
        this.z.onOpenSubMenu(paramu);
      return true;
    }
    return false;
  }

  public void setCallback(o.a parama)
  {
    this.z = parama;
  }

  public void show()
  {
    if (isShowing());
    do
    {
      return;
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext())
        c((h)localIterator.next());
      this.m.clear();
      this.d = this.r;
    }
    while (this.d == null);
    if (this.e == null);
    for (int i1 = 1; ; i1 = 0)
    {
      this.e = this.d.getViewTreeObserver();
      if (i1 != 0)
        this.e.addOnGlobalLayoutListener(this.c);
      this.d.addOnAttachStateChangeListener(this.n);
      return;
    }
  }

  public void updateMenuView(boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      a(((a)localIterator.next()).a().getAdapter()).notifyDataSetChanged();
  }

  private static class a
  {
    public final MenuPopupWindow a;
    public final h b;
    public final int c;

    public a(MenuPopupWindow paramMenuPopupWindow, h paramh, int paramInt)
    {
      this.a = paramMenuPopupWindow;
      this.b = paramh;
      this.c = paramInt;
    }

    public ListView a()
    {
      return this.a.getListView();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.e
 * JD-Core Version:    0.6.2
 */