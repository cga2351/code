package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class ViewParentCompat
{
  private static final String TAG = "ViewParentCompat";

  public static void notifySubtreeAccessibilityStateChanged(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
      paramViewParent.notifySubtreeAccessibilityStateChanged(paramView1, paramView2, paramInt);
  }

  public static boolean onNestedFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
      try
      {
        bool = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
        return bool;
      }
      catch (AbstractMethodError localAbstractMethodError)
      {
        Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedFling", localAbstractMethodError);
      }
    while (!(paramViewParent instanceof NestedScrollingParent))
    {
      boolean bool;
      return false;
    }
    return ((NestedScrollingParent)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }

  public static boolean onNestedPreFling(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21)
      try
      {
        bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
        return bool;
      }
      catch (AbstractMethodError localAbstractMethodError)
      {
        Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedPreFling", localAbstractMethodError);
      }
    while (!(paramViewParent instanceof NestedScrollingParent))
    {
      boolean bool;
      return false;
    }
    return ((NestedScrollingParent)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
  }

  public static void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    onNestedPreScroll(paramViewParent, paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }

  public static void onNestedPreScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if ((paramViewParent instanceof NestedScrollingParent2))
      ((NestedScrollingParent2)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    do
    {
      do
        return;
      while (paramInt3 != 0);
      if (Build.VERSION.SDK_INT >= 21)
        try
        {
          paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
          return;
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedPreScroll", localAbstractMethodError);
          return;
        }
    }
    while (!(paramViewParent instanceof NestedScrollingParent));
    ((NestedScrollingParent)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
  }

  public static void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onNestedScroll(paramViewParent, paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }

  public static void onNestedScroll(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramViewParent instanceof NestedScrollingParent2))
      ((NestedScrollingParent2)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    do
    {
      do
        return;
      while (paramInt5 != 0);
      if (Build.VERSION.SDK_INT >= 21)
        try
        {
          paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
          return;
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedScroll", localAbstractMethodError);
          return;
        }
    }
    while (!(paramViewParent instanceof NestedScrollingParent));
    ((NestedScrollingParent)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    onNestedScrollAccepted(paramViewParent, paramView1, paramView2, paramInt, 0);
  }

  public static void onNestedScrollAccepted(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof NestedScrollingParent2))
      ((NestedScrollingParent2)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt1, paramInt2);
    do
    {
      do
        return;
      while (paramInt2 != 0);
      if (Build.VERSION.SDK_INT >= 21)
        try
        {
          paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt1);
          return;
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onNestedScrollAccepted", localAbstractMethodError);
          return;
        }
    }
    while (!(paramViewParent instanceof NestedScrollingParent));
    ((NestedScrollingParent)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt1);
  }

  public static boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    return onStartNestedScroll(paramViewParent, paramView1, paramView2, paramInt, 0);
  }

  public static boolean onStartNestedScroll(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if ((paramViewParent instanceof NestedScrollingParent2))
      return ((NestedScrollingParent2)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt1, paramInt2);
    if (paramInt2 == 0)
    {
      if (Build.VERSION.SDK_INT < 21)
        break label90;
      try
      {
        bool = paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt1);
        return bool;
      }
      catch (AbstractMethodError localAbstractMethodError)
      {
        Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onStartNestedScroll", localAbstractMethodError);
      }
    }
    label90: 
    while (!(paramViewParent instanceof NestedScrollingParent))
    {
      boolean bool;
      return false;
    }
    return ((NestedScrollingParent)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt1);
  }

  public static void onStopNestedScroll(ViewParent paramViewParent, View paramView)
  {
    onStopNestedScroll(paramViewParent, paramView, 0);
  }

  public static void onStopNestedScroll(ViewParent paramViewParent, View paramView, int paramInt)
  {
    if ((paramViewParent instanceof NestedScrollingParent2))
      ((NestedScrollingParent2)paramViewParent).onStopNestedScroll(paramView, paramInt);
    do
    {
      do
        return;
      while (paramInt != 0);
      if (Build.VERSION.SDK_INT >= 21)
        try
        {
          paramViewParent.onStopNestedScroll(paramView);
          return;
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          Log.e("ViewParentCompat", "ViewParent " + paramViewParent + " does not implement interface " + "method onStopNestedScroll", localAbstractMethodError);
          return;
        }
    }
    while (!(paramViewParent instanceof NestedScrollingParent));
    ((NestedScrollingParent)paramViewParent).onStopNestedScroll(paramView);
  }

  @Deprecated
  public static boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return paramViewParent.requestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewParentCompat
 * JD-Core Version:    0.6.2
 */