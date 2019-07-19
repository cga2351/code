package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class TooltipPopup
{
  private static final String TAG = "TooltipPopup";
  private final View mContentView;
  private final Context mContext;
  private final WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
  private final TextView mMessageView;
  private final int[] mTmpAnchorPos = new int[2];
  private final int[] mTmpAppPos = new int[2];
  private final Rect mTmpDisplayFrame = new Rect();

  TooltipPopup(Context paramContext)
  {
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(R.layout.abc_tooltip, null);
    this.mMessageView = ((TextView)this.mContentView.findViewById(R.id.message));
    this.mLayoutParams.setTitle(getClass().getSimpleName());
    this.mLayoutParams.packageName = this.mContext.getPackageName();
    this.mLayoutParams.type = 1002;
    this.mLayoutParams.width = -2;
    this.mLayoutParams.height = -2;
    this.mLayoutParams.format = -3;
    this.mLayoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
    this.mLayoutParams.flags = 24;
  }

  private void computePosition(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.token = paramView.getApplicationWindowToken();
    int i = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
    int j;
    int k;
    label69: Resources localResources1;
    if (paramView.getWidth() >= i)
    {
      if (paramView.getHeight() < i)
        break label134;
      int i7 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
      j = paramInt2 + i7;
      k = paramInt2 - i7;
      paramLayoutParams.gravity = 49;
      localResources1 = this.mContext.getResources();
      if (!paramBoolean)
        break label146;
    }
    int n;
    View localView;
    label134: label146: for (int m = R.dimen.tooltip_y_offset_touch; ; m = R.dimen.tooltip_y_offset_non_touch)
    {
      n = localResources1.getDimensionPixelOffset(m);
      localView = getAppRootView(paramView);
      if (localView != null)
        break label154;
      Log.e("TooltipPopup", "Cannot find app view");
      return;
      paramInt1 = paramView.getWidth() / 2;
      break;
      j = paramView.getHeight();
      k = 0;
      break label69;
    }
    label154: localView.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
    Resources localResources2;
    int i5;
    if ((this.mTmpDisplayFrame.left < 0) && (this.mTmpDisplayFrame.top < 0))
    {
      localResources2 = this.mContext.getResources();
      i5 = localResources2.getIdentifier("status_bar_height", "dimen", "android");
      if (i5 == 0)
        break label402;
    }
    int i2;
    int i3;
    int i4;
    label402: for (int i6 = localResources2.getDimensionPixelSize(i5); ; i6 = 0)
    {
      DisplayMetrics localDisplayMetrics = localResources2.getDisplayMetrics();
      this.mTmpDisplayFrame.set(0, i6, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
      localView.getLocationOnScreen(this.mTmpAppPos);
      paramView.getLocationOnScreen(this.mTmpAnchorPos);
      int[] arrayOfInt1 = this.mTmpAnchorPos;
      arrayOfInt1[0] -= this.mTmpAppPos[0];
      int[] arrayOfInt2 = this.mTmpAnchorPos;
      arrayOfInt2[1] -= this.mTmpAppPos[1];
      paramLayoutParams.x = (paramInt1 + this.mTmpAnchorPos[0] - localView.getWidth() / 2);
      int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.mContentView.measure(i1, i1);
      i2 = this.mContentView.getMeasuredHeight();
      i3 = k + this.mTmpAnchorPos[1] - n - i2;
      i4 = n + (j + this.mTmpAnchorPos[1]);
      if (!paramBoolean)
        break label416;
      if (i3 < 0)
        break;
      paramLayoutParams.y = i3;
      return;
    }
    paramLayoutParams.y = i4;
    return;
    label416: if (i2 + i4 <= this.mTmpDisplayFrame.height())
    {
      paramLayoutParams.y = i4;
      return;
    }
    paramLayoutParams.y = i3;
  }

  private static View getAppRootView(View paramView)
  {
    View localView = paramView.getRootView();
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (((localLayoutParams instanceof WindowManager.LayoutParams)) && (((WindowManager.LayoutParams)localLayoutParams).type == 2))
      return localView;
    for (Context localContext = paramView.getContext(); (localContext instanceof ContextWrapper); localContext = ((ContextWrapper)localContext).getBaseContext())
      if ((localContext instanceof Activity))
        return ((Activity)localContext).getWindow().getDecorView();
    return localView;
  }

  void hide()
  {
    if (!isShowing())
      return;
    ((WindowManager)this.mContext.getSystemService("window")).removeView(this.mContentView);
  }

  boolean isShowing()
  {
    return this.mContentView.getParent() != null;
  }

  void show(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (isShowing())
      hide();
    this.mMessageView.setText(paramCharSequence);
    computePosition(paramView, paramInt1, paramInt2, paramBoolean, this.mLayoutParams);
    ((WindowManager)this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.TooltipPopup
 * JD-Core Version:    0.6.2
 */