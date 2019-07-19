package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.R.attr;
import android.support.design.R.layout;
import android.support.design.h.a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Snackbar extends BaseTransientBottomBar<Snackbar>
{
  public static final int LENGTH_INDEFINITE = -2;
  public static final int LENGTH_LONG = 0;
  public static final int LENGTH_SHORT = -1;
  private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = arrayOfInt;
  private final AccessibilityManager accessibilityManager;
  private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
  private boolean hasAction;

  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = R.attr.snackbarButtonStyle;
  }

  private Snackbar(ViewGroup paramViewGroup, View paramView, a parama)
  {
    super(paramViewGroup, paramView, parama);
    this.accessibilityManager = ((AccessibilityManager)paramViewGroup.getContext().getSystemService("accessibility"));
  }

  private static ViewGroup findSuitableParent(View paramView)
  {
    ViewGroup localViewGroup = null;
    View localView = paramView;
    while (true)
    {
      if ((localView instanceof CoordinatorLayout))
        return (ViewGroup)localView;
      if ((localView instanceof FrameLayout))
      {
        if (localView.getId() == 16908290)
          return (ViewGroup)localView;
        localViewGroup = (ViewGroup)localView;
      }
      ViewParent localViewParent;
      if (localView != null)
      {
        localViewParent = localView.getParent();
        if (!(localViewParent instanceof View))
          break label69;
      }
      label69: for (localView = (View)localViewParent; localView == null; localView = null)
        return localViewGroup;
    }
  }

  protected static boolean hasSnackbarButtonStyleAttr(Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
    int i = localTypedArray.getResourceId(0, -1);
    localTypedArray.recycle();
    boolean bool = false;
    if (i != -1)
      bool = true;
    return bool;
  }

  public static Snackbar make(View paramView, int paramInt1, int paramInt2)
  {
    return make(paramView, paramView.getResources().getText(paramInt1), paramInt2);
  }

  public static Snackbar make(View paramView, CharSequence paramCharSequence, int paramInt)
  {
    ViewGroup localViewGroup = findSuitableParent(paramView);
    if (localViewGroup == null)
      throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    LayoutInflater localLayoutInflater = LayoutInflater.from(localViewGroup.getContext());
    if (hasSnackbarButtonStyleAttr(localViewGroup.getContext()));
    for (int i = R.layout.mtrl_layout_snackbar_include; ; i = R.layout.design_layout_snackbar_include)
    {
      SnackbarContentLayout localSnackbarContentLayout = (SnackbarContentLayout)localLayoutInflater.inflate(i, localViewGroup, false);
      Snackbar localSnackbar = new Snackbar(localViewGroup, localSnackbarContentLayout, localSnackbarContentLayout);
      localSnackbar.setText(paramCharSequence);
      localSnackbar.setDuration(paramInt);
      return localSnackbar;
    }
  }

  public void dismiss()
  {
    super.dismiss();
  }

  public int getDuration()
  {
    if ((this.hasAction) && (this.accessibilityManager.isTouchExplorationEnabled()))
      return -2;
    return super.getDuration();
  }

  public boolean isShown()
  {
    return super.isShown();
  }

  public Snackbar setAction(int paramInt, View.OnClickListener paramOnClickListener)
  {
    return setAction(getContext().getText(paramInt), paramOnClickListener);
  }

  public Snackbar setAction(CharSequence paramCharSequence, final View.OnClickListener paramOnClickListener)
  {
    Button localButton = ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView();
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramOnClickListener == null))
    {
      localButton.setVisibility(8);
      localButton.setOnClickListener(null);
      this.hasAction = false;
      return this;
    }
    this.hasAction = true;
    localButton.setVisibility(0);
    localButton.setText(paramCharSequence);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramOnClickListener.onClick(paramAnonymousView);
        Snackbar.this.dispatchDismiss(1);
      }
    });
    return this;
  }

  public Snackbar setActionTextColor(int paramInt)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(paramInt);
    return this;
  }

  public Snackbar setActionTextColor(ColorStateList paramColorStateList)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getActionView().setTextColor(paramColorStateList);
    return this;
  }

  @Deprecated
  public Snackbar setCallback(Callback paramCallback)
  {
    if (this.callback != null)
      removeCallback(this.callback);
    if (paramCallback != null)
      addCallback(paramCallback);
    this.callback = paramCallback;
    return this;
  }

  public Snackbar setText(int paramInt)
  {
    return setText(getContext().getText(paramInt));
  }

  public Snackbar setText(CharSequence paramCharSequence)
  {
    ((SnackbarContentLayout)this.view.getChildAt(0)).getMessageView().setText(paramCharSequence);
    return this;
  }

  public void show()
  {
    super.show();
  }

  public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar>
  {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;

    public void onDismissed(Snackbar paramSnackbar, int paramInt)
    {
    }

    public void onShown(Snackbar paramSnackbar)
    {
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Duration
  {
  }

  public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout
  {
    public SnackbarLayout(Context paramContext)
    {
      super();
    }

    public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      int i = getChildCount();
      int j = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
      for (int k = 0; k < i; k++)
      {
        View localView = getChildAt(k);
        if (localView.getLayoutParams().width == -1)
          localView.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.Snackbar
 * JD-Core Version:    0.6.2
 */