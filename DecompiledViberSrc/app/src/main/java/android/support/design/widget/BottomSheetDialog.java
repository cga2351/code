package android.support.design.widget;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.R.attr;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.f;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

public class BottomSheetDialog extends f
{
  private BottomSheetBehavior<FrameLayout> behavior;
  private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback()
  {
    public void onSlide(View paramAnonymousView, float paramAnonymousFloat)
    {
    }

    public void onStateChanged(View paramAnonymousView, int paramAnonymousInt)
    {
      if (paramAnonymousInt == 5)
        BottomSheetDialog.this.cancel();
    }
  };
  boolean cancelable = true;
  private boolean canceledOnTouchOutside = true;
  private boolean canceledOnTouchOutsideSet;

  public BottomSheetDialog(Context paramContext)
  {
    this(paramContext, 0);
  }

  public BottomSheetDialog(Context paramContext, int paramInt)
  {
    super(paramContext, getThemeResId(paramContext, paramInt));
    supportRequestWindowFeature(1);
  }

  protected BottomSheetDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    supportRequestWindowFeature(1);
    this.cancelable = paramBoolean;
  }

  private static int getThemeResId(Context paramContext, int paramInt)
  {
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      if (paramContext.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, localTypedValue, true))
        paramInt = localTypedValue.resourceId;
    }
    else
    {
      return paramInt;
    }
    return R.style.Theme_Design_Light_BottomSheetDialog;
  }

  private View wrapInBottomSheet(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout localFrameLayout1 = (FrameLayout)View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)localFrameLayout1.findViewById(R.id.coordinator);
    if ((paramInt != 0) && (paramView == null))
      paramView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
    FrameLayout localFrameLayout2 = (FrameLayout)localCoordinatorLayout.findViewById(R.id.design_bottom_sheet);
    this.behavior = BottomSheetBehavior.from(localFrameLayout2);
    this.behavior.setBottomSheetCallback(this.bottomSheetCallback);
    this.behavior.setHideable(this.cancelable);
    if (paramLayoutParams == null)
      localFrameLayout2.addView(paramView);
    while (true)
    {
      localCoordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ((BottomSheetDialog.this.cancelable) && (BottomSheetDialog.this.isShowing()) && (BottomSheetDialog.this.shouldWindowCloseOnTouchOutside()))
            BottomSheetDialog.this.cancel();
        }
      });
      ViewCompat.setAccessibilityDelegate(localFrameLayout2, new AccessibilityDelegateCompat()
      {
        public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
        {
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
          if (BottomSheetDialog.this.cancelable)
          {
            paramAnonymousAccessibilityNodeInfoCompat.addAction(1048576);
            paramAnonymousAccessibilityNodeInfoCompat.setDismissable(true);
            return;
          }
          paramAnonymousAccessibilityNodeInfoCompat.setDismissable(false);
        }

        public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          if ((paramAnonymousInt == 1048576) && (BottomSheetDialog.this.cancelable))
          {
            BottomSheetDialog.this.cancel();
            return true;
          }
          return super.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
        }
      });
      localFrameLayout2.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      return localFrameLayout1;
      localFrameLayout2.addView(paramView, paramLayoutParams);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        localWindow.clearFlags(67108864);
        localWindow.addFlags(-2147483648);
      }
      localWindow.setLayout(-1, -1);
    }
  }

  protected void onStart()
  {
    super.onStart();
    if ((this.behavior != null) && (this.behavior.getState() == 5))
      this.behavior.setState(4);
  }

  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.cancelable != paramBoolean)
    {
      this.cancelable = paramBoolean;
      if (this.behavior != null)
        this.behavior.setHideable(paramBoolean);
    }
  }

  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.cancelable))
      this.cancelable = true;
    this.canceledOnTouchOutside = paramBoolean;
    this.canceledOnTouchOutsideSet = true;
  }

  public void setContentView(int paramInt)
  {
    super.setContentView(wrapInBottomSheet(paramInt, null, null));
  }

  public void setContentView(View paramView)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, null));
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(wrapInBottomSheet(0, paramView, paramLayoutParams));
  }

  boolean shouldWindowCloseOnTouchOutside()
  {
    if (!this.canceledOnTouchOutsideSet)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(new int[] { 16843611 });
      this.canceledOnTouchOutside = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
      this.canceledOnTouchOutsideSet = true;
    }
    return this.canceledOnTouchOutside;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.BottomSheetDialog
 * JD-Core Version:    0.6.2
 */