package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow
  implements MenuItemHoverListener
{
  private static final String TAG = "MenuPopupWindow";
  private static Method sSetTouchModalMethod;
  private MenuItemHoverListener mHoverListener;

  static
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      sSetTouchModalMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", arrayOfClass);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
    }
  }

  public MenuPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  DropDownListView createDropDownListView(Context paramContext, boolean paramBoolean)
  {
    MenuDropDownListView localMenuDropDownListView = new MenuDropDownListView(paramContext, paramBoolean);
    localMenuDropDownListView.setHoverListener(this);
    return localMenuDropDownListView;
  }

  public void onItemHoverEnter(h paramh, MenuItem paramMenuItem)
  {
    if (this.mHoverListener != null)
      this.mHoverListener.onItemHoverEnter(paramh, paramMenuItem);
  }

  public void onItemHoverExit(h paramh, MenuItem paramMenuItem)
  {
    if (this.mHoverListener != null)
      this.mHoverListener.onItemHoverExit(paramh, paramMenuItem);
  }

  public void setEnterTransition(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 23)
      this.mPopup.setEnterTransition((Transition)paramObject);
  }

  public void setExitTransition(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 23)
      this.mPopup.setExitTransition((Transition)paramObject);
  }

  public void setHoverListener(MenuItemHoverListener paramMenuItemHoverListener)
  {
    this.mHoverListener = paramMenuItemHoverListener;
  }

  public void setTouchModal(boolean paramBoolean)
  {
    if (sSetTouchModalMethod != null);
    try
    {
      Method localMethod = sSetTouchModalMethod;
      PopupWindow localPopupWindow = this.mPopup;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(localPopupWindow, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
    }
  }

  public static class MenuDropDownListView extends DropDownListView
  {
    final int mAdvanceKey;
    private MenuItemHoverListener mHoverListener;
    private MenuItem mHoveredMenuItem;
    final int mRetreatKey;

    public MenuDropDownListView(Context paramContext, boolean paramBoolean)
    {
      super(paramBoolean);
      Configuration localConfiguration = paramContext.getResources().getConfiguration();
      if ((Build.VERSION.SDK_INT >= 17) && (1 == localConfiguration.getLayoutDirection()))
      {
        this.mAdvanceKey = 21;
        this.mRetreatKey = 22;
        return;
      }
      this.mAdvanceKey = 22;
      this.mRetreatKey = 21;
    }

    public void clearSelection()
    {
      setSelection(-1);
    }

    public boolean onHoverEvent(MotionEvent paramMotionEvent)
    {
      ListAdapter localListAdapter;
      int i;
      g localg;
      int k;
      if (this.mHoverListener != null)
      {
        localListAdapter = getAdapter();
        if (!(localListAdapter instanceof HeaderViewListAdapter))
          break label168;
        HeaderViewListAdapter localHeaderViewListAdapter = (HeaderViewListAdapter)localListAdapter;
        i = localHeaderViewListAdapter.getHeadersCount();
        localg = (g)localHeaderViewListAdapter.getWrappedAdapter();
        if (paramMotionEvent.getAction() == 10)
          break label179;
        int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (j == -1)
          break label179;
        k = j - i;
        if ((k < 0) || (k >= localg.getCount()))
          break label179;
      }
      label168: label179: for (j localj = localg.a(k); ; localj = null)
      {
        MenuItem localMenuItem = this.mHoveredMenuItem;
        if (localMenuItem != localj)
        {
          h localh = localg.a();
          if (localMenuItem != null)
            this.mHoverListener.onItemHoverExit(localh, localMenuItem);
          this.mHoveredMenuItem = localj;
          if (localj != null)
            this.mHoverListener.onItemHoverEnter(localh, localj);
        }
        return super.onHoverEvent(paramMotionEvent);
        localg = (g)localListAdapter;
        i = 0;
        break;
      }
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
      ListMenuItemView localListMenuItemView = (ListMenuItemView)getSelectedView();
      if ((localListMenuItemView != null) && (paramInt == this.mAdvanceKey))
      {
        if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu()))
          performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
        return true;
      }
      if ((localListMenuItemView != null) && (paramInt == this.mRetreatKey))
      {
        setSelection(-1);
        ((g)getAdapter()).a().b(false);
        return true;
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public void setHoverListener(MenuItemHoverListener paramMenuItemHoverListener)
    {
      this.mHoverListener = paramMenuItemHoverListener;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.MenuPopupWindow
 * JD-Core Version:    0.6.2
 */