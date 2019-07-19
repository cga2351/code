package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.id;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class AlertDialogLayout extends LinearLayoutCompat
{
  public AlertDialogLayout(Context paramContext)
  {
    super(paramContext);
  }

  public AlertDialogLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void forceUniformWidth(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    for (int j = 0; j < paramInt1; j++)
    {
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        LinearLayoutCompat.LayoutParams localLayoutParams = (LinearLayoutCompat.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.width == -1)
        {
          int k = localLayoutParams.height;
          localLayoutParams.height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, i, 0, paramInt2, 0);
          localLayoutParams.height = k;
        }
      }
    }
  }

  private static int resolveMinimumHeight(View paramView)
  {
    int i = ViewCompat.getMinimumHeight(paramView);
    if (i > 0)
      return i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      if (localViewGroup.getChildCount() == 1)
        return resolveMinimumHeight(localViewGroup.getChildAt(0));
    }
    return 0;
  }

  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }

  private boolean tryOnMeasure(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = getChildCount();
    int j = 0;
    Object localObject3 = null;
    if (j < i)
    {
      Object localObject4 = getChildAt(j);
      Object localObject5;
      if (((View)localObject4).getVisibility() == 8)
      {
        localObject4 = localObject2;
        localObject5 = localObject1;
      }
      while (true)
      {
        j++;
        localObject1 = localObject5;
        localObject2 = localObject4;
        break;
        int i23 = ((View)localObject4).getId();
        if (i23 == R.id.topPanel)
        {
          Object localObject6 = localObject2;
          localObject5 = localObject4;
          localObject4 = localObject6;
        }
        else if (i23 == R.id.buttonPanel)
        {
          localObject5 = localObject1;
        }
        else
        {
          if ((i23 != R.id.contentPanel) && (i23 != R.id.customPanel))
            break label143;
          if (localObject3 != null)
            return false;
          localObject3 = localObject4;
          localObject4 = localObject2;
          localObject5 = localObject1;
        }
      }
      label143: return false;
    }
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = View.MeasureSpec.getMode(paramInt1);
    int i1 = getPaddingTop() + getPaddingBottom();
    int i2 = 0;
    if (localObject1 != null)
    {
      localObject1.measure(paramInt1, 0);
      i1 += localObject1.getMeasuredHeight();
      i2 = View.combineMeasuredStates(0, localObject1.getMeasuredState());
    }
    int i3;
    int i22;
    if (localObject2 != null)
    {
      localObject2.measure(paramInt1, 0);
      i3 = resolveMinimumHeight(localObject2);
      i22 = localObject2.getMeasuredHeight() - i3;
      i1 += i3;
      i2 = View.combineMeasuredStates(i2, localObject2.getMeasuredState());
    }
    for (int i4 = i22; ; i4 = 0)
    {
      int i20;
      int i21;
      if (localObject3 != null)
        if (k == 0)
        {
          i20 = 0;
          localObject3.measure(paramInt1, i20);
          i21 = localObject3.getMeasuredHeight();
          i1 += i21;
          i2 = View.combineMeasuredStates(i2, localObject3.getMeasuredState());
        }
      for (int i5 = i21; ; i5 = 0)
      {
        int i6 = m - i1;
        int i8;
        int i9;
        int i7;
        if (localObject2 != null)
        {
          int i16 = i1 - i3;
          int i17 = Math.min(i6, i4);
          if (i17 > 0)
          {
            i6 -= i17;
            i3 += i17;
          }
          localObject2.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
          int i18 = i16 + localObject2.getMeasuredHeight();
          i8 = View.combineMeasuredStates(i2, localObject2.getMeasuredState());
          int i19 = i6;
          i9 = i18;
          i7 = i19;
        }
        while (true)
        {
          int i11;
          int i10;
          if ((localObject3 != null) && (i7 > 0))
          {
            int i14 = i9 - i5;
            (i7 - i7);
            localObject3.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i7 + i5, k));
            int i15 = i14 + localObject3.getMeasuredHeight();
            i11 = View.combineMeasuredStates(i8, localObject3.getMeasuredState());
            i10 = i15;
          }
          while (true)
          {
            int i12 = 0;
            int i13 = 0;
            while (true)
              if (i13 < i)
              {
                View localView = getChildAt(i13);
                if (localView.getVisibility() != 8)
                  i12 = Math.max(i12, localView.getMeasuredWidth());
                i13++;
                continue;
                i20 = View.MeasureSpec.makeMeasureSpec(Math.max(0, m - i1), k);
                break;
              }
            setMeasuredDimension(View.resolveSizeAndState(i12 + (getPaddingLeft() + getPaddingRight()), paramInt1, i11), View.resolveSizeAndState(i10, paramInt2, 0));
            if (n != 1073741824)
              forceUniformWidth(i, paramInt2);
            return true;
            i10 = i9;
            i11 = i8;
          }
          i7 = i6;
          i8 = i2;
          i9 = i1;
        }
      }
      i3 = 0;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = j - getPaddingRight();
    int m = j - i - getPaddingRight();
    int n = getMeasuredHeight();
    int i1 = getChildCount();
    int i2 = getGravity();
    int i3 = i2 & 0x70;
    int i4 = i2 & 0x800007;
    int i5;
    Drawable localDrawable;
    int i6;
    label112: int i7;
    int i8;
    label119: View localView;
    int i9;
    int i10;
    LinearLayoutCompat.LayoutParams localLayoutParams;
    int i12;
    switch (i3)
    {
    default:
      i5 = getPaddingTop();
      localDrawable = getDividerDrawable();
      if (localDrawable == null)
      {
        i6 = 0;
        i7 = 0;
        i8 = i5;
        if (i7 >= i1)
          break label386;
        localView = getChildAt(i7);
        if ((localView != null) && (localView.getVisibility() != 8))
        {
          i9 = localView.getMeasuredWidth();
          i10 = localView.getMeasuredHeight();
          localLayoutParams = (LinearLayoutCompat.LayoutParams)localView.getLayoutParams();
          int i11 = localLayoutParams.gravity;
          if (i11 < 0)
            i11 = i4;
          switch (0x7 & GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)))
          {
          default:
            i12 = i + localLayoutParams.leftMargin;
            label238: if (!hasDividerBeforeChildAt(i7));
            break;
          case 1:
          case 5:
          }
        }
      }
      break;
    case 80:
    case 16:
    }
    for (int i13 = i8 + i6; ; i13 = i8)
    {
      int i14 = i13 + localLayoutParams.topMargin;
      setChildFrame(localView, i12, i14, i9, i10);
      i8 = i14 + (i10 + localLayoutParams.bottomMargin);
      i7++;
      break label119;
      i5 = paramInt4 + getPaddingTop() - paramInt2 - n;
      break;
      i5 = getPaddingTop() + (paramInt4 - paramInt2 - n) / 2;
      break;
      i6 = localDrawable.getIntrinsicHeight();
      break label112;
      i12 = i + (m - i9) / 2 + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
      break label238;
      i12 = k - i9 - localLayoutParams.rightMargin;
      break label238;
      label386: return;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!tryOnMeasure(paramInt1, paramInt2))
      super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.AlertDialogLayout
 * JD-Core Version:    0.6.2
 */