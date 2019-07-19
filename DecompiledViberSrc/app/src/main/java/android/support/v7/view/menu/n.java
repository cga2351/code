package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class n
{
  private static final int TOUCH_EPICENTER_SIZE_DP = 48;
  private View mAnchorView;
  private final Context mContext;
  private int mDropDownGravity = 8388611;
  private boolean mForceShowIcon;
  private final PopupWindow.OnDismissListener mInternalOnDismissListener = new PopupWindow.OnDismissListener()
  {
    public void onDismiss()
    {
      n.this.onDismiss();
    }
  };
  private final h mMenu;
  private PopupWindow.OnDismissListener mOnDismissListener;
  private final boolean mOverflowOnly;
  private m mPopup;
  private final int mPopupStyleAttr;
  private final int mPopupStyleRes;
  private o.a mPresenterCallback;

  public n(Context paramContext, h paramh)
  {
    this(paramContext, paramh, null, false, R.attr.popupMenuStyle, 0);
  }

  public n(Context paramContext, h paramh, View paramView)
  {
    this(paramContext, paramh, paramView, false, R.attr.popupMenuStyle, 0);
  }

  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramh, paramView, paramBoolean, paramInt, 0);
  }

  public n(Context paramContext, h paramh, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.mMenu = paramh;
    this.mAnchorView = paramView;
    this.mOverflowOnly = paramBoolean;
    this.mPopupStyleAttr = paramInt1;
    this.mPopupStyleRes = paramInt2;
  }

  private m createPopup()
  {
    Display localDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    int i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplay.getRealSize(localPoint);
      if (Math.min(localPoint.x, localPoint.y) < this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width))
        break label166;
      i = 1;
      label68: if (i == 0)
        break label171;
    }
    label166: label171: for (Object localObject = new e(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly); ; localObject = new t(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly))
    {
      ((m)localObject).a(this.mMenu);
      ((m)localObject).a(this.mInternalOnDismissListener);
      ((m)localObject).a(this.mAnchorView);
      ((m)localObject).setCallback(this.mPresenterCallback);
      ((m)localObject).a(this.mForceShowIcon);
      ((m)localObject).a(this.mDropDownGravity);
      return localObject;
      localDisplay.getSize(localPoint);
      break;
      i = 0;
      break label68;
    }
  }

  private void showPopup(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    m localm = getPopup();
    localm.b(paramBoolean2);
    if (paramBoolean1)
    {
      if ((0x7 & GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView))) == 5)
        paramInt1 -= this.mAnchorView.getWidth();
      localm.b(paramInt1);
      localm.c(paramInt2);
      int i = (int)(48.0F * this.mContext.getResources().getDisplayMetrics().density / 2.0F);
      localm.a(new Rect(paramInt1 - i, paramInt2 - i, paramInt1 + i, i + paramInt2));
    }
    localm.show();
  }

  public void dismiss()
  {
    if (isShowing())
      this.mPopup.dismiss();
  }

  public int getGravity()
  {
    return this.mDropDownGravity;
  }

  public ListView getListView()
  {
    return getPopup().getListView();
  }

  public m getPopup()
  {
    if (this.mPopup == null)
      this.mPopup = createPopup();
    return this.mPopup;
  }

  public boolean isShowing()
  {
    return (this.mPopup != null) && (this.mPopup.isShowing());
  }

  protected void onDismiss()
  {
    this.mPopup = null;
    if (this.mOnDismissListener != null)
      this.mOnDismissListener.onDismiss();
  }

  public void setAnchorView(View paramView)
  {
    this.mAnchorView = paramView;
  }

  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
    if (this.mPopup != null)
      this.mPopup.a(paramBoolean);
  }

  public void setGravity(int paramInt)
  {
    this.mDropDownGravity = paramInt;
  }

  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }

  public void setPresenterCallback(o.a parama)
  {
    this.mPresenterCallback = parama;
    if (this.mPopup != null)
      this.mPopup.setCallback(parama);
  }

  public void show()
  {
    if (!tryShow())
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }

  public void show(int paramInt1, int paramInt2)
  {
    if (!tryShow(paramInt1, paramInt2))
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }

  public boolean tryShow()
  {
    if (isShowing())
      return true;
    if (this.mAnchorView == null)
      return false;
    showPopup(0, 0, false, false);
    return true;
  }

  public boolean tryShow(int paramInt1, int paramInt2)
  {
    if (isShowing())
      return true;
    if (this.mAnchorView == null)
      return false;
    showPopup(paramInt1, paramInt2, true, true);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.view.menu.n
 * JD-Core Version:    0.6.2
 */