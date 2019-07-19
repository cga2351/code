package android.support.design.transformation;

import android.content.Context;
import android.support.design.d.b;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.List;

public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View>
{
  private static final int STATE_COLLAPSED = 2;
  private static final int STATE_EXPANDED = 1;
  private static final int STATE_UNINITIALIZED;
  private int currentState = 0;

  public ExpandableBehavior()
  {
  }

  public ExpandableBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private boolean didStateChange(boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      boolean bool;
      if (this.currentState != 0)
      {
        int k = this.currentState;
        bool = false;
        if (k != 2);
      }
      else
      {
        bool = i;
      }
      return bool;
    }
    if (this.currentState == i);
    while (true)
    {
      return i;
      int j = 0;
    }
  }

  public static <T extends ExpandableBehavior> T from(View paramView, Class<T> paramClass)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof CoordinatorLayout.LayoutParams))
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)localLayoutParams).getBehavior();
    if (!(localBehavior instanceof ExpandableBehavior))
      throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    return (ExpandableBehavior)paramClass.cast(localBehavior);
  }

  protected b findExpandableWidget(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    List localList = paramCoordinatorLayout.getDependencies(paramView);
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)localList.get(j);
      if (layoutDependsOn(paramCoordinatorLayout, paramView, localView))
        return (b)localView;
    }
    return null;
  }

  public abstract boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2);

  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    b localb = (b)paramView2;
    if (didStateChange(localb.isExpanded()))
    {
      if (localb.isExpanded());
      for (int i = 1; ; i = 2)
      {
        this.currentState = i;
        return onExpandedStateChange((View)localb, paramView1, localb.isExpanded(), true);
      }
    }
    return false;
  }

  protected abstract boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);

  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, final View paramView, int paramInt)
  {
    final b localb;
    if (!ViewCompat.isLaidOut(paramView))
    {
      localb = findExpandableWidget(paramCoordinatorLayout, paramView);
      if ((localb != null) && (didStateChange(localb.isExpanded())))
        if (!localb.isExpanded())
          break label81;
    }
    label81: for (int i = 1; ; i = 2)
    {
      this.currentState = i;
      final int j = this.currentState;
      paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          paramView.getViewTreeObserver().removeOnPreDrawListener(this);
          if (ExpandableBehavior.this.currentState == j)
            ExpandableBehavior.this.onExpandedStateChange((View)localb, paramView, localb.isExpanded(), false);
          return false;
        }
      });
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.transformation.ExpandableBehavior
 * JD-Core Version:    0.6.2
 */