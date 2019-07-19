package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

class AppCompatPopupWindow extends PopupWindow
{
  private static final boolean COMPAT_OVERLAP_ANCHOR;
  private boolean mOverlapAnchor;

  static
  {
    if (Build.VERSION.SDK_INT < 21);
    for (boolean bool = true; ; bool = false)
    {
      COMPAT_OVERLAP_ANCHOR = bool;
      return;
    }
  }

  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt, 0);
  }

  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.PopupWindow, paramInt1, paramInt2);
    if (localTintTypedArray.hasValue(R.styleable.PopupWindow_overlapAnchor))
      setSupportOverlapAnchor(localTintTypedArray.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
    setBackgroundDrawable(localTintTypedArray.getDrawable(R.styleable.PopupWindow_android_popupBackground));
    localTintTypedArray.recycle();
  }

  private void setSupportOverlapAnchor(boolean paramBoolean)
  {
    if (COMPAT_OVERLAP_ANCHOR)
    {
      this.mOverlapAnchor = paramBoolean;
      return;
    }
    PopupWindowCompat.setOverlapAnchor(this, paramBoolean);
  }

  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if ((COMPAT_OVERLAP_ANCHOR) && (this.mOverlapAnchor))
      paramInt2 -= paramView.getHeight();
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }

  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((COMPAT_OVERLAP_ANCHOR) && (this.mOverlapAnchor))
      paramInt2 -= paramView.getHeight();
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }

  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((COMPAT_OVERLAP_ANCHOR) && (this.mOverlapAnchor));
    for (int i = paramInt2 - paramView.getHeight(); ; i = paramInt2)
    {
      super.update(paramView, paramInt1, i, paramInt3, paramInt4);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AppCompatPopupWindow
 * JD-Core Version:    0.6.2
 */