package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.R.dimen;
import android.support.design.R.id;
import android.support.design.R.styleable;
import android.support.design.h.a;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout extends LinearLayout
  implements a
{
  private Button actionView;
  private int maxInlineActionWidth;
  private int maxWidth;
  private TextView messageView;

  public SnackbarContentLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
    this.maxWidth = localTypedArray.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
    this.maxInlineActionWidth = localTypedArray.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
    localTypedArray.recycle();
  }

  private static void updateTopBottomPadding(View paramView, int paramInt1, int paramInt2)
  {
    if (ViewCompat.isPaddingRelative(paramView))
    {
      ViewCompat.setPaddingRelative(paramView, ViewCompat.getPaddingStart(paramView), paramInt1, ViewCompat.getPaddingEnd(paramView), paramInt2);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }

  private boolean updateViewsWithinLayout(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getOrientation();
    boolean bool = false;
    if (paramInt1 != i)
    {
      setOrientation(paramInt1);
      bool = true;
    }
    if ((this.messageView.getPaddingTop() != paramInt2) || (this.messageView.getPaddingBottom() != paramInt3))
    {
      updateTopBottomPadding(this.messageView, paramInt2, paramInt3);
      bool = true;
    }
    return bool;
  }

  public void animateContentIn(int paramInt1, int paramInt2)
  {
    this.messageView.setAlpha(0.0F);
    this.messageView.animate().alpha(1.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
    if (this.actionView.getVisibility() == 0)
    {
      this.actionView.setAlpha(0.0F);
      this.actionView.animate().alpha(1.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
    }
  }

  public void animateContentOut(int paramInt1, int paramInt2)
  {
    this.messageView.setAlpha(1.0F);
    this.messageView.animate().alpha(0.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
    if (this.actionView.getVisibility() == 0)
    {
      this.actionView.setAlpha(1.0F);
      this.actionView.animate().alpha(0.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
    }
  }

  public Button getActionView()
  {
    return this.actionView;
  }

  public TextView getMessageView()
  {
    return this.messageView;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.messageView = ((TextView)findViewById(R.id.snackbar_text));
    this.actionView = ((Button)findViewById(R.id.snackbar_action));
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.maxWidth > 0) && (getMeasuredWidth() > this.maxWidth))
    {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
      super.onMeasure(paramInt1, paramInt2);
    }
    int i = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
    int j = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
    int k;
    int m;
    if (this.messageView.getLayout().getLineCount() > 1)
    {
      k = 1;
      if ((k == 0) || (this.maxInlineActionWidth <= 0) || (this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth))
        break label140;
      if (!updateViewsWithinLayout(1, i, i - j))
        break label167;
      m = 1;
    }
    while (true)
    {
      if (m != 0)
        super.onMeasure(paramInt1, paramInt2);
      return;
      k = 0;
      break;
      label140: if (k != 0);
      while (true)
      {
        if (!updateViewsWithinLayout(0, i, i))
          break label167;
        m = 1;
        break;
        i = j;
      }
      label167: m = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.SnackbarContentLayout
 * JD-Core Version:    0.6.2
 */