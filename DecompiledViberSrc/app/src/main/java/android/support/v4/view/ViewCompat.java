package android.support.v4.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.compat.R.id;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.DragShadowBuilder;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewCompat
{
  public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
  public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
  public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
  public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;

  @Deprecated
  public static final int LAYER_TYPE_HARDWARE = 2;

  @Deprecated
  public static final int LAYER_TYPE_NONE = 0;

  @Deprecated
  public static final int LAYER_TYPE_SOFTWARE = 1;
  public static final int LAYOUT_DIRECTION_INHERIT = 2;
  public static final int LAYOUT_DIRECTION_LOCALE = 3;
  public static final int LAYOUT_DIRECTION_LTR = 0;
  public static final int LAYOUT_DIRECTION_RTL = 1;

  @Deprecated
  public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

  @Deprecated
  public static final int MEASURED_SIZE_MASK = 16777215;

  @Deprecated
  public static final int MEASURED_STATE_MASK = -16777216;

  @Deprecated
  public static final int MEASURED_STATE_TOO_SMALL = 16777216;

  @Deprecated
  public static final int OVER_SCROLL_ALWAYS = 0;

  @Deprecated
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

  @Deprecated
  public static final int OVER_SCROLL_NEVER = 2;
  public static final int SCROLL_AXIS_HORIZONTAL = 1;
  public static final int SCROLL_AXIS_NONE = 0;
  public static final int SCROLL_AXIS_VERTICAL = 2;
  public static final int SCROLL_INDICATOR_BOTTOM = 2;
  public static final int SCROLL_INDICATOR_END = 32;
  public static final int SCROLL_INDICATOR_LEFT = 4;
  public static final int SCROLL_INDICATOR_RIGHT = 8;
  public static final int SCROLL_INDICATOR_START = 16;
  public static final int SCROLL_INDICATOR_TOP = 1;
  private static final String TAG = "ViewCompat";
  public static final int TYPE_NON_TOUCH = 1;
  public static final int TYPE_TOUCH;
  private static boolean sAccessibilityDelegateCheckFailed = false;
  private static Field sAccessibilityDelegateField;
  private static Method sChildrenDrawingOrderMethod;
  private static Method sDispatchFinishTemporaryDetach;
  private static Method sDispatchStartTemporaryDetach;
  private static Field sMinHeightField;
  private static boolean sMinHeightFieldFetched;
  private static Field sMinWidthField;
  private static boolean sMinWidthFieldFetched;
  private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
  private static boolean sTempDetachBound;
  private static ThreadLocal<Rect> sThreadLocalRect;
  private static WeakHashMap<View, String> sTransitionNameMap;
  private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap = null;

  public static void addKeyboardNavigationClusters(View paramView, Collection<View> paramCollection, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26)
      paramView.addKeyboardNavigationClusters(paramCollection, paramInt);
  }

  public static void addOnUnhandledKeyEventListener(View paramView, OnUnhandledKeyEventListenerCompat paramOnUnhandledKeyEventListenerCompat)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      Object localObject = (Map)paramView.getTag(R.id.tag_unhandled_key_listeners);
      if (localObject == null)
      {
        localObject = new ArrayMap();
        paramView.setTag(R.id.tag_unhandled_key_listeners, localObject);
      }
      OnUnhandledKeyEventListenerWrapper localOnUnhandledKeyEventListenerWrapper = new OnUnhandledKeyEventListenerWrapper(paramOnUnhandledKeyEventListenerCompat);
      ((Map)localObject).put(paramOnUnhandledKeyEventListenerCompat, localOnUnhandledKeyEventListenerWrapper);
      paramView.addOnUnhandledKeyEventListener(localOnUnhandledKeyEventListenerWrapper);
    }
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        paramView.setTag(R.id.tag_unhandled_key_listeners, localArrayList);
      }
      localArrayList.add(paramOnUnhandledKeyEventListenerCompat);
    }
    while (localArrayList.size() != 1);
    UnhandledKeyEventManager.registerListeningView(paramView);
  }

  public static ViewPropertyAnimatorCompat animate(View paramView)
  {
    if (sViewPropertyAnimatorMap == null)
      sViewPropertyAnimatorMap = new WeakHashMap();
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)sViewPropertyAnimatorMap.get(paramView);
    if (localViewPropertyAnimatorCompat == null)
    {
      localViewPropertyAnimatorCompat = new ViewPropertyAnimatorCompat(paramView);
      sViewPropertyAnimatorMap.put(paramView, localViewPropertyAnimatorCompat);
    }
    return localViewPropertyAnimatorCompat;
  }

  private static void bindTempDetach()
  {
    try
    {
      sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
      sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
      sTempDetachBound = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        Log.e("ViewCompat", "Couldn't find method", localNoSuchMethodException);
    }
  }

  @Deprecated
  public static boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }

  @Deprecated
  public static boolean canScrollVertically(View paramView, int paramInt)
  {
    return paramView.canScrollVertically(paramInt);
  }

  public static void cancelDragAndDrop(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 24)
      paramView.cancelDragAndDrop();
  }

  @Deprecated
  public static int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return View.combineMeasuredStates(paramInt1, paramInt2);
  }

  private static void compatOffsetLeftAndRight(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
    if (paramView.getVisibility() == 0)
    {
      tickleInvalidationFlag(paramView);
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
        tickleInvalidationFlag((View)localViewParent);
    }
  }

  private static void compatOffsetTopAndBottom(View paramView, int paramInt)
  {
    paramView.offsetTopAndBottom(paramInt);
    if (paramView.getVisibility() == 0)
    {
      tickleInvalidationFlag(paramView);
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
        tickleInvalidationFlag((View)localViewParent);
    }
  }

  public static WindowInsetsCompat dispatchApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      WindowInsets localWindowInsets1 = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
      WindowInsets localWindowInsets2 = paramView.dispatchApplyWindowInsets(localWindowInsets1);
      if (localWindowInsets2 != localWindowInsets1)
        localWindowInsets1 = new WindowInsets(localWindowInsets2);
      paramWindowInsetsCompat = WindowInsetsCompat.wrap(localWindowInsets1);
    }
    return paramWindowInsetsCompat;
  }

  public static void dispatchFinishTemporaryDetach(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView.dispatchFinishTemporaryDetach();
      return;
    }
    if (!sTempDetachBound)
      bindTempDetach();
    if (sDispatchFinishTemporaryDetach != null)
      try
      {
        sDispatchFinishTemporaryDetach.invoke(paramView, new Object[0]);
        return;
      }
      catch (Exception localException)
      {
        Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", localException);
        return;
      }
    paramView.onFinishTemporaryDetach();
  }

  public static boolean dispatchNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    if ((paramView instanceof NestedScrollingChild))
      return ((NestedScrollingChild)paramView).dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    return false;
  }

  public static boolean dispatchNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.dispatchNestedPreFling(paramFloat1, paramFloat2);
    if ((paramView instanceof NestedScrollingChild))
      return ((NestedScrollingChild)paramView).dispatchNestedPreFling(paramFloat1, paramFloat2);
    return false;
  }

  public static boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    if ((paramView instanceof NestedScrollingChild))
      return ((NestedScrollingChild)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    return false;
  }

  public static boolean dispatchNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    if ((paramView instanceof NestedScrollingChild2))
      return ((NestedScrollingChild2)paramView).dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
    if (paramInt3 == 0)
      return dispatchNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    return false;
  }

  public static boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    if ((paramView instanceof NestedScrollingChild))
      return ((NestedScrollingChild)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    return false;
  }

  public static boolean dispatchNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    if ((paramView instanceof NestedScrollingChild2))
      return ((NestedScrollingChild2)paramView).dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
    if (paramInt5 == 0)
      return dispatchNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    return false;
  }

  public static void dispatchStartTemporaryDetach(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramView.dispatchStartTemporaryDetach();
      return;
    }
    if (!sTempDetachBound)
      bindTempDetach();
    if (sDispatchStartTemporaryDetach != null)
      try
      {
        sDispatchStartTemporaryDetach.invoke(paramView, new Object[0]);
        return;
      }
      catch (Exception localException)
      {
        Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", localException);
        return;
      }
    paramView.onStartTemporaryDetach();
  }

  static boolean dispatchUnhandledKeyEventBeforeCallback(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return false;
    return UnhandledKeyEventManager.at(paramView).dispatch(paramView, paramKeyEvent);
  }

  static boolean dispatchUnhandledKeyEventBeforeHierarchy(View paramView, KeyEvent paramKeyEvent)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return false;
    return UnhandledKeyEventManager.at(paramView).preDispatch(paramKeyEvent);
  }

  public static int generateViewId()
  {
    if (Build.VERSION.SDK_INT >= 17)
      return View.generateViewId();
    int i;
    int j;
    do
    {
      i = sNextGeneratedId.get();
      j = i + 1;
      if (j > 16777215)
        j = 1;
    }
    while (!sNextGeneratedId.compareAndSet(i, j));
    return i;
  }

  public static int getAccessibilityLiveRegion(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramView.getAccessibilityLiveRegion();
    return 0;
  }

  public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      AccessibilityNodeProvider localAccessibilityNodeProvider = paramView.getAccessibilityNodeProvider();
      if (localAccessibilityNodeProvider != null)
        return new AccessibilityNodeProviderCompat(localAccessibilityNodeProvider);
    }
    return null;
  }

  @Deprecated
  public static float getAlpha(View paramView)
  {
    return paramView.getAlpha();
  }

  public static ColorStateList getBackgroundTintList(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.getBackgroundTintList();
    if ((paramView instanceof TintableBackgroundView))
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintList();
    return null;
  }

  public static PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.getBackgroundTintMode();
    if ((paramView instanceof TintableBackgroundView))
      return ((TintableBackgroundView)paramView).getSupportBackgroundTintMode();
    return null;
  }

  public static Rect getClipBounds(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18)
      return paramView.getClipBounds();
    return null;
  }

  public static Display getDisplay(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return paramView.getDisplay();
    if (isAttachedToWindow(paramView))
      return ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay();
    return null;
  }

  public static float getElevation(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.getElevation();
    return 0.0F;
  }

  private static Rect getEmptyTempRect()
  {
    if (sThreadLocalRect == null)
      sThreadLocalRect = new ThreadLocal();
    Rect localRect = (Rect)sThreadLocalRect.get();
    if (localRect == null)
    {
      localRect = new Rect();
      sThreadLocalRect.set(localRect);
    }
    localRect.setEmpty();
    return localRect;
  }

  public static boolean getFitsSystemWindows(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.getFitsSystemWindows();
    return false;
  }

  public static int getImportantForAccessibility(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.getImportantForAccessibility();
    return 0;
  }

  @SuppressLint({"InlinedApi"})
  public static int getImportantForAutofill(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramView.getImportantForAutofill();
    return 0;
  }

  public static int getLabelFor(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return paramView.getLabelFor();
    return 0;
  }

  @Deprecated
  public static int getLayerType(View paramView)
  {
    return paramView.getLayerType();
  }

  public static int getLayoutDirection(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return paramView.getLayoutDirection();
    return 0;
  }

  @Deprecated
  public static Matrix getMatrix(View paramView)
  {
    return paramView.getMatrix();
  }

  @Deprecated
  public static int getMeasuredHeightAndState(View paramView)
  {
    return paramView.getMeasuredHeightAndState();
  }

  @Deprecated
  public static int getMeasuredState(View paramView)
  {
    return paramView.getMeasuredState();
  }

  @Deprecated
  public static int getMeasuredWidthAndState(View paramView)
  {
    return paramView.getMeasuredWidthAndState();
  }

  public static int getMinimumHeight(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.getMinimumHeight();
    if (!sMinHeightFieldFetched);
    try
    {
      sMinHeightField = View.class.getDeclaredField("mMinHeight");
      sMinHeightField.setAccessible(true);
      label37: sMinHeightFieldFetched = true;
      if (sMinHeightField != null)
        try
        {
          int i = ((Integer)sMinHeightField.get(paramView)).intValue();
          return i;
        }
        catch (Exception localException)
        {
        }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label37;
    }
  }

  public static int getMinimumWidth(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.getMinimumWidth();
    if (!sMinWidthFieldFetched);
    try
    {
      sMinWidthField = View.class.getDeclaredField("mMinWidth");
      sMinWidthField.setAccessible(true);
      label37: sMinWidthFieldFetched = true;
      if (sMinWidthField != null)
        try
        {
          int i = ((Integer)sMinWidthField.get(paramView)).intValue();
          return i;
        }
        catch (Exception localException)
        {
        }
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label37;
    }
  }

  public static int getNextClusterForwardId(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramView.getNextClusterForwardId();
    return -1;
  }

  @Deprecated
  public static int getOverScrollMode(View paramView)
  {
    return paramView.getOverScrollMode();
  }

  public static int getPaddingEnd(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return paramView.getPaddingEnd();
    return paramView.getPaddingRight();
  }

  public static int getPaddingStart(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return paramView.getPaddingStart();
    return paramView.getPaddingLeft();
  }

  public static ViewParent getParentForAccessibility(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.getParentForAccessibility();
    return paramView.getParent();
  }

  @Deprecated
  public static float getPivotX(View paramView)
  {
    return paramView.getPivotX();
  }

  @Deprecated
  public static float getPivotY(View paramView)
  {
    return paramView.getPivotY();
  }

  @Deprecated
  public static float getRotation(View paramView)
  {
    return paramView.getRotation();
  }

  @Deprecated
  public static float getRotationX(View paramView)
  {
    return paramView.getRotationX();
  }

  @Deprecated
  public static float getRotationY(View paramView)
  {
    return paramView.getRotationY();
  }

  @Deprecated
  public static float getScaleX(View paramView)
  {
    return paramView.getScaleX();
  }

  @Deprecated
  public static float getScaleY(View paramView)
  {
    return paramView.getScaleY();
  }

  public static int getScrollIndicators(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramView.getScrollIndicators();
    return 0;
  }

  public static String getTransitionName(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.getTransitionName();
    if (sTransitionNameMap == null)
      return null;
    return (String)sTransitionNameMap.get(paramView);
  }

  @Deprecated
  public static float getTranslationX(View paramView)
  {
    return paramView.getTranslationX();
  }

  @Deprecated
  public static float getTranslationY(View paramView)
  {
    return paramView.getTranslationY();
  }

  public static float getTranslationZ(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.getTranslationZ();
    return 0.0F;
  }

  public static int getWindowSystemUiVisibility(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.getWindowSystemUiVisibility();
    return 0;
  }

  @Deprecated
  public static float getX(View paramView)
  {
    return paramView.getX();
  }

  @Deprecated
  public static float getY(View paramView)
  {
    return paramView.getY();
  }

  public static float getZ(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.getZ();
    return 0.0F;
  }

  // ERROR //
  public static boolean hasAccessibilityDelegate(View paramView)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: getstatic 90	android/support/v4/view/ViewCompat:sAccessibilityDelegateCheckFailed	Z
    //   5: ifeq +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic 580	android/support/v4/view/ViewCompat:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   13: ifnonnull +21 -> 34
    //   16: ldc 101
    //   18: ldc_w 582
    //   21: invokevirtual 476	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   24: putstatic 580	android/support/v4/view/ViewCompat:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   27: getstatic 580	android/support/v4/view/ViewCompat:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   30: iconst_1
    //   31: invokevirtual 484	java/lang/reflect/Field:setAccessible	(Z)V
    //   34: getstatic 580	android/support/v4/view/ViewCompat:sAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   37: aload_0
    //   38: invokevirtual 485	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +13 -> 56
    //   46: iload_1
    //   47: ireturn
    //   48: astore 4
    //   50: iload_1
    //   51: putstatic 90	android/support/v4/view/ViewCompat:sAccessibilityDelegateCheckFailed	Z
    //   54: iconst_0
    //   55: ireturn
    //   56: iconst_0
    //   57: istore_1
    //   58: goto -12 -> 46
    //   61: astore_2
    //   62: iload_1
    //   63: putstatic 90	android/support/v4/view/ViewCompat:sAccessibilityDelegateCheckFailed	Z
    //   66: iconst_0
    //   67: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   16	34	48	java/lang/Throwable
    //   34	42	61	java/lang/Throwable
  }

  public static boolean hasExplicitFocusable(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramView.hasExplicitFocusable();
    return paramView.hasFocusable();
  }

  public static boolean hasNestedScrollingParent(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.hasNestedScrollingParent();
    if ((paramView instanceof NestedScrollingChild))
      return ((NestedScrollingChild)paramView).hasNestedScrollingParent();
    return false;
  }

  public static boolean hasNestedScrollingParent(View paramView, int paramInt)
  {
    if ((paramView instanceof NestedScrollingChild2))
      ((NestedScrollingChild2)paramView).hasNestedScrollingParent(paramInt);
    while (paramInt != 0)
      return false;
    return hasNestedScrollingParent(paramView);
  }

  public static boolean hasOnClickListeners(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 15)
      return paramView.hasOnClickListeners();
    return false;
  }

  public static boolean hasOverlappingRendering(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.hasOverlappingRendering();
    return true;
  }

  public static boolean hasTransientState(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.hasTransientState();
    return false;
  }

  public static boolean isAttachedToWindow(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramView.isAttachedToWindow();
    return paramView.getWindowToken() != null;
  }

  public static boolean isFocusedByDefault(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramView.isFocusedByDefault();
    return false;
  }

  public static boolean isImportantForAccessibility(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.isImportantForAccessibility();
    return true;
  }

  public static boolean isImportantForAutofill(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramView.isImportantForAutofill();
    return true;
  }

  public static boolean isInLayout(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18)
      return paramView.isInLayout();
    return false;
  }

  public static boolean isKeyboardNavigationCluster(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramView.isKeyboardNavigationCluster();
    return false;
  }

  public static boolean isLaidOut(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramView.isLaidOut();
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }

  public static boolean isLayoutDirectionResolved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramView.isLayoutDirectionResolved();
    return false;
  }

  public static boolean isNestedScrollingEnabled(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.isNestedScrollingEnabled();
    if ((paramView instanceof NestedScrollingChild))
      return ((NestedScrollingChild)paramView).isNestedScrollingEnabled();
    return false;
  }

  @Deprecated
  public static boolean isOpaque(View paramView)
  {
    return paramView.isOpaque();
  }

  public static boolean isPaddingRelative(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return paramView.isPaddingRelative();
    return false;
  }

  @Deprecated
  public static void jumpDrawablesToCurrentState(View paramView)
  {
    paramView.jumpDrawablesToCurrentState();
  }

  public static View keyboardNavigationClusterSearch(View paramView1, View paramView2, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramView1.keyboardNavigationClusterSearch(paramView2, paramInt);
    return null;
  }

  public static void offsetLeftAndRight(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetLeftAndRight(paramInt);
      return;
    }
    Rect localRect;
    ViewParent localViewParent;
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localRect = getEmptyTempRect();
      localViewParent = paramView.getParent();
      if (!(localViewParent instanceof View))
        break label148;
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))
        i = 1;
    }
    while (true)
    {
      compatOffsetLeftAndRight(paramView, paramInt);
      if ((i == 0) || (!localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())))
        break;
      ((View)localViewParent).invalidate(localRect);
      return;
      i = 0;
      continue;
      compatOffsetLeftAndRight(paramView, paramInt);
      return;
      label148: i = 0;
    }
  }

  public static void offsetTopAndBottom(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramView.offsetTopAndBottom(paramInt);
      return;
    }
    Rect localRect;
    ViewParent localViewParent;
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localRect = getEmptyTempRect();
      localViewParent = paramView.getParent();
      if (!(localViewParent instanceof View))
        break label148;
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))
        i = 1;
    }
    while (true)
    {
      compatOffsetTopAndBottom(paramView, paramInt);
      if ((i == 0) || (!localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())))
        break;
      ((View)localViewParent).invalidate(localRect);
      return;
      i = 0;
      continue;
      compatOffsetTopAndBottom(paramView, paramInt);
      return;
      label148: i = 0;
    }
  }

  public static WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      WindowInsets localWindowInsets1 = (WindowInsets)WindowInsetsCompat.unwrap(paramWindowInsetsCompat);
      WindowInsets localWindowInsets2 = paramView.onApplyWindowInsets(localWindowInsets1);
      if (localWindowInsets2 != localWindowInsets1)
        localWindowInsets1 = new WindowInsets(localWindowInsets2);
      paramWindowInsetsCompat = WindowInsetsCompat.wrap(localWindowInsets1);
    }
    return paramWindowInsetsCompat;
  }

  @Deprecated
  public static void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }

  public static void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramView.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfoCompat.unwrap());
  }

  @Deprecated
  public static void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    paramView.onPopulateAccessibilityEvent(paramAccessibilityEvent);
  }

  public static boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
      return paramView.performAccessibilityAction(paramInt, paramBundle);
    return false;
  }

  public static void postInvalidateOnAnimation(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postInvalidateOnAnimation();
      return;
    }
    paramView.postInvalidate();
  }

  public static void postInvalidateOnAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postInvalidateOnAnimation(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postOnAnimation(paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
  }

  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postOnAnimationDelayed(paramRunnable, paramLong);
      return;
    }
    paramView.postDelayed(paramRunnable, paramLong + ValueAnimator.getFrameDelay());
  }

  public static void removeOnUnhandledKeyEventListener(View paramView, OnUnhandledKeyEventListenerCompat paramOnUnhandledKeyEventListenerCompat)
  {
    Map localMap;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localMap = (Map)paramView.getTag(R.id.tag_unhandled_key_listeners);
      if (localMap != null);
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        View.OnUnhandledKeyEventListener localOnUnhandledKeyEventListener;
        do
        {
          return;
          localOnUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener)localMap.get(paramOnUnhandledKeyEventListenerCompat);
        }
        while (localOnUnhandledKeyEventListener == null);
        paramView.removeOnUnhandledKeyEventListener(localOnUnhandledKeyEventListener);
        return;
        localArrayList = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
      }
      while (localArrayList == null);
      localArrayList.remove(paramOnUnhandledKeyEventListenerCompat);
    }
    while (localArrayList.size() != 0);
    UnhandledKeyEventManager.unregisterListeningView(paramView);
  }

  public static void requestApplyInsets(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 20)
      paramView.requestApplyInsets();
    while (Build.VERSION.SDK_INT < 16)
      return;
    paramView.requestFitSystemWindows();
  }

  public static <T extends View> T requireViewById(View paramView, int paramInt)
  {
    View localView;
    if (Build.VERSION.SDK_INT >= 28)
      localView = paramView.requireViewById(paramInt);
    do
    {
      return localView;
      localView = paramView.findViewById(paramInt);
    }
    while (localView != null);
    throw new IllegalArgumentException("ID does not reference a View inside this View");
  }

  @Deprecated
  public static int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }

  public static boolean restoreDefaultFocus(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramView.restoreDefaultFocus();
    return paramView.requestFocus();
  }

  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    if (paramAccessibilityDelegateCompat == null);
    for (View.AccessibilityDelegate localAccessibilityDelegate = null; ; localAccessibilityDelegate = paramAccessibilityDelegateCompat.getBridge())
    {
      paramView.setAccessibilityDelegate(localAccessibilityDelegate);
      return;
    }
  }

  public static void setAccessibilityLiveRegion(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
      paramView.setAccessibilityLiveRegion(paramInt);
  }

  @Deprecated
  public static void setActivated(View paramView, boolean paramBoolean)
  {
    paramView.setActivated(paramBoolean);
  }

  @Deprecated
  public static void setAlpha(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }

  public static void setAutofillHints(View paramView, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 26)
      paramView.setAutofillHints(paramArrayOfString);
  }

  public static void setBackground(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }

  public static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        localDrawable = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null))
          break label72;
        i = 1;
        if ((localDrawable != null) && (i != 0))
        {
          if (localDrawable.isStateful())
            localDrawable.setState(paramView.getDrawableState());
          paramView.setBackground(localDrawable);
        }
      }
    }
    label72: 
    while (!(paramView instanceof TintableBackgroundView))
      while (true)
      {
        Drawable localDrawable;
        return;
        int i = 0;
      }
    ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList);
  }

  public static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setBackgroundTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        localDrawable = paramView.getBackground();
        if ((paramView.getBackgroundTintList() == null) && (paramView.getBackgroundTintMode() == null))
          break label72;
        i = 1;
        if ((localDrawable != null) && (i != 0))
        {
          if (localDrawable.isStateful())
            localDrawable.setState(paramView.getDrawableState());
          paramView.setBackground(localDrawable);
        }
      }
    }
    label72: 
    while (!(paramView instanceof TintableBackgroundView))
      while (true)
      {
        Drawable localDrawable;
        return;
        int i = 0;
      }
    ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode);
  }

  // ERROR //
  @Deprecated
  public static void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 864	android/support/v4/view/ViewCompat:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   3: ifnonnull +37 -> 40
    //   6: iconst_1
    //   7: anewarray 174	java/lang/Class
    //   10: astore 13
    //   12: aload 13
    //   14: iconst_0
    //   15: getstatic 870	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   18: aastore
    //   19: ldc_w 872
    //   22: ldc_w 873
    //   25: aload 13
    //   27: invokevirtual 178	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   30: putstatic 864	android/support/v4/view/ViewCompat:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   33: getstatic 864	android/support/v4/view/ViewCompat:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   36: iconst_1
    //   37: invokevirtual 874	java/lang/reflect/Method:setAccessible	(Z)V
    //   40: getstatic 864	android/support/v4/view/ViewCompat:sChildrenDrawingOrderMethod	Ljava/lang/reflect/Method;
    //   43: astore 8
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: astore 9
    //   51: aload 9
    //   53: iconst_0
    //   54: iload_1
    //   55: invokestatic 878	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   58: aastore
    //   59: aload 8
    //   61: aload_0
    //   62: aload 9
    //   64: invokevirtual 260	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: return
    //   69: astore 11
    //   71: ldc 51
    //   73: ldc_w 880
    //   76: aload 11
    //   78: invokestatic 194	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   81: pop
    //   82: goto -49 -> 33
    //   85: astore 6
    //   87: ldc 51
    //   89: ldc_w 882
    //   92: aload 6
    //   94: invokestatic 194	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   97: pop
    //   98: return
    //   99: astore 4
    //   101: ldc 51
    //   103: ldc_w 882
    //   106: aload 4
    //   108: invokestatic 194	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   111: pop
    //   112: return
    //   113: astore_2
    //   114: ldc 51
    //   116: ldc_w 882
    //   119: aload_2
    //   120: invokestatic 194	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   123: pop
    //   124: return
    //
    // Exception table:
    //   from	to	target	type
    //   6	33	69	java/lang/NoSuchMethodException
    //   40	68	85	java/lang/IllegalAccessException
    //   40	68	99	java/lang/IllegalArgumentException
    //   40	68	113	java/lang/reflect/InvocationTargetException
  }

  public static void setClipBounds(View paramView, Rect paramRect)
  {
    if (Build.VERSION.SDK_INT >= 18)
      paramView.setClipBounds(paramRect);
  }

  public static void setElevation(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramView.setElevation(paramFloat);
  }

  @Deprecated
  public static void setFitsSystemWindows(View paramView, boolean paramBoolean)
  {
    paramView.setFitsSystemWindows(paramBoolean);
  }

  public static void setFocusedByDefault(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26)
      paramView.setFocusedByDefault(paramBoolean);
  }

  public static void setHasTransientState(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16)
      paramView.setHasTransientState(paramBoolean);
  }

  public static void setImportantForAccessibility(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
      paramView.setImportantForAccessibility(paramInt);
    while (Build.VERSION.SDK_INT < 16)
      return;
    if (paramInt == 4)
      paramInt = 2;
    paramView.setImportantForAccessibility(paramInt);
  }

  public static void setImportantForAutofill(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26)
      paramView.setImportantForAutofill(paramInt);
  }

  public static void setKeyboardNavigationCluster(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26)
      paramView.setKeyboardNavigationCluster(paramBoolean);
  }

  public static void setLabelFor(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
      paramView.setLabelFor(paramInt);
  }

  public static void setLayerPaint(View paramView, Paint paramPaint)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView.setLayerPaint(paramPaint);
      return;
    }
    paramView.setLayerType(paramView.getLayerType(), paramPaint);
    paramView.invalidate();
  }

  @Deprecated
  public static void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }

  public static void setLayoutDirection(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
      paramView.setLayoutDirection(paramInt);
  }

  public static void setNestedScrollingEnabled(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramView.setNestedScrollingEnabled(paramBoolean);
    while (!(paramView instanceof NestedScrollingChild))
      return;
    ((NestedScrollingChild)paramView).setNestedScrollingEnabled(paramBoolean);
  }

  public static void setNextClusterForwardId(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 26)
      paramView.setNextClusterForwardId(paramInt);
  }

  public static void setOnApplyWindowInsetsListener(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramOnApplyWindowInsetsListener == null)
        paramView.setOnApplyWindowInsetsListener(null);
    }
    else
      return;
    paramView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
    {
      public WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
      {
        WindowInsetsCompat localWindowInsetsCompat = WindowInsetsCompat.wrap(paramAnonymousWindowInsets);
        return (WindowInsets)WindowInsetsCompat.unwrap(this.val$listener.onApplyWindowInsets(paramAnonymousView, localWindowInsetsCompat));
      }
    });
  }

  @Deprecated
  public static void setOverScrollMode(View paramView, int paramInt)
  {
    paramView.setOverScrollMode(paramInt);
  }

  public static void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  @Deprecated
  public static void setPivotX(View paramView, float paramFloat)
  {
    paramView.setPivotX(paramFloat);
  }

  @Deprecated
  public static void setPivotY(View paramView, float paramFloat)
  {
    paramView.setPivotY(paramFloat);
  }

  public static void setPointerIcon(View paramView, PointerIconCompat paramPointerIconCompat)
  {
    if (Build.VERSION.SDK_INT >= 24)
      if (paramPointerIconCompat == null)
        break label29;
    label29: for (Object localObject = paramPointerIconCompat.getPointerIcon(); ; localObject = null)
    {
      paramView.setPointerIcon((PointerIcon)localObject);
      return;
    }
  }

  @Deprecated
  public static void setRotation(View paramView, float paramFloat)
  {
    paramView.setRotation(paramFloat);
  }

  @Deprecated
  public static void setRotationX(View paramView, float paramFloat)
  {
    paramView.setRotationX(paramFloat);
  }

  @Deprecated
  public static void setRotationY(View paramView, float paramFloat)
  {
    paramView.setRotationY(paramFloat);
  }

  @Deprecated
  public static void setSaveFromParentEnabled(View paramView, boolean paramBoolean)
  {
    paramView.setSaveFromParentEnabled(paramBoolean);
  }

  @Deprecated
  public static void setScaleX(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }

  @Deprecated
  public static void setScaleY(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }

  public static void setScrollIndicators(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
      paramView.setScrollIndicators(paramInt);
  }

  public static void setScrollIndicators(View paramView, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 23)
      paramView.setScrollIndicators(paramInt1, paramInt2);
  }

  public static void setTooltipText(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
      paramView.setTooltipText(paramCharSequence);
  }

  public static void setTransitionName(View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setTransitionName(paramString);
      return;
    }
    if (sTransitionNameMap == null)
      sTransitionNameMap = new WeakHashMap();
    sTransitionNameMap.put(paramView, paramString);
  }

  @Deprecated
  public static void setTranslationX(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }

  @Deprecated
  public static void setTranslationY(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }

  public static void setTranslationZ(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramView.setTranslationZ(paramFloat);
  }

  @Deprecated
  public static void setX(View paramView, float paramFloat)
  {
    paramView.setX(paramFloat);
  }

  @Deprecated
  public static void setY(View paramView, float paramFloat)
  {
    paramView.setY(paramFloat);
  }

  public static void setZ(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramView.setZ(paramFloat);
  }

  public static boolean startDragAndDrop(View paramView, ClipData paramClipData, View.DragShadowBuilder paramDragShadowBuilder, Object paramObject, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
      return paramView.startDragAndDrop(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
    return paramView.startDrag(paramClipData, paramDragShadowBuilder, paramObject, paramInt);
  }

  public static boolean startNestedScroll(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.startNestedScroll(paramInt);
    if ((paramView instanceof NestedScrollingChild))
      return ((NestedScrollingChild)paramView).startNestedScroll(paramInt);
    return false;
  }

  public static boolean startNestedScroll(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof NestedScrollingChild2))
      return ((NestedScrollingChild2)paramView).startNestedScroll(paramInt1, paramInt2);
    if (paramInt2 == 0)
      return startNestedScroll(paramView, paramInt1);
    return false;
  }

  public static void stopNestedScroll(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramView.stopNestedScroll();
    while (!(paramView instanceof NestedScrollingChild))
      return;
    ((NestedScrollingChild)paramView).stopNestedScroll();
  }

  public static void stopNestedScroll(View paramView, int paramInt)
  {
    if ((paramView instanceof NestedScrollingChild2))
      ((NestedScrollingChild2)paramView).stopNestedScroll(paramInt);
    while (paramInt != 0)
      return;
    stopNestedScroll(paramView);
  }

  private static void tickleInvalidationFlag(View paramView)
  {
    float f = paramView.getTranslationY();
    paramView.setTranslationY(1.0F + f);
    paramView.setTranslationY(f);
  }

  public static void updateDragShadow(View paramView, View.DragShadowBuilder paramDragShadowBuilder)
  {
    if (Build.VERSION.SDK_INT >= 24)
      paramView.updateDragShadow(paramDragShadowBuilder);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface FocusDirection
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface FocusRealDirection
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface FocusRelativeDirection
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface NestedScrollType
  {
  }

  public static abstract interface OnUnhandledKeyEventListenerCompat
  {
    public abstract boolean onUnhandledKeyEvent(View paramView, KeyEvent paramKeyEvent);
  }

  private static class OnUnhandledKeyEventListenerWrapper
    implements View.OnUnhandledKeyEventListener
  {
    private ViewCompat.OnUnhandledKeyEventListenerCompat mCompatListener;

    OnUnhandledKeyEventListenerWrapper(ViewCompat.OnUnhandledKeyEventListenerCompat paramOnUnhandledKeyEventListenerCompat)
    {
      this.mCompatListener = paramOnUnhandledKeyEventListenerCompat;
    }

    public boolean onUnhandledKeyEvent(View paramView, KeyEvent paramKeyEvent)
    {
      return this.mCompatListener.onUnhandledKeyEvent(paramView, paramKeyEvent);
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScrollAxis
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScrollIndicators
  {
  }

  static class UnhandledKeyEventManager
  {
    private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList();
    private SparseArray<WeakReference<View>> mCapturedKeys = null;
    private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
    private WeakHashMap<View, Boolean> mViewsContainingListeners = null;

    static UnhandledKeyEventManager at(View paramView)
    {
      UnhandledKeyEventManager localUnhandledKeyEventManager = (UnhandledKeyEventManager)paramView.getTag(R.id.tag_unhandled_key_event_manager);
      if (localUnhandledKeyEventManager == null)
      {
        localUnhandledKeyEventManager = new UnhandledKeyEventManager();
        paramView.setTag(R.id.tag_unhandled_key_event_manager, localUnhandledKeyEventManager);
      }
      return localUnhandledKeyEventManager;
    }

    private View dispatchInOrder(View paramView, KeyEvent paramKeyEvent)
    {
      if ((this.mViewsContainingListeners == null) || (!this.mViewsContainingListeners.containsKey(paramView)))
        paramView = null;
      do
      {
        return paramView;
        if ((paramView instanceof ViewGroup))
        {
          ViewGroup localViewGroup = (ViewGroup)paramView;
          for (int i = -1 + localViewGroup.getChildCount(); i >= 0; i--)
          {
            View localView = dispatchInOrder(localViewGroup.getChildAt(i), paramKeyEvent);
            if (localView != null)
              return localView;
          }
        }
      }
      while (onUnhandledKeyEvent(paramView, paramKeyEvent));
      return null;
    }

    private SparseArray<WeakReference<View>> getCapturedKeys()
    {
      if (this.mCapturedKeys == null)
        this.mCapturedKeys = new SparseArray();
      return this.mCapturedKeys;
    }

    private boolean onUnhandledKeyEvent(View paramView, KeyEvent paramKeyEvent)
    {
      ArrayList localArrayList = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
      if (localArrayList != null)
        for (int i = -1 + localArrayList.size(); i >= 0; i--)
          if (((ViewCompat.OnUnhandledKeyEventListenerCompat)localArrayList.get(i)).onUnhandledKeyEvent(paramView, paramKeyEvent))
            return true;
      return false;
    }

    private void recalcViewsWithUnhandled()
    {
      if (this.mViewsContainingListeners != null)
        this.mViewsContainingListeners.clear();
      if (sViewsWithListeners.isEmpty())
        return;
      while (true)
      {
        int i;
        synchronized (sViewsWithListeners)
        {
          if (this.mViewsContainingListeners == null)
            this.mViewsContainingListeners = new WeakHashMap();
          i = -1 + sViewsWithListeners.size();
          if (i >= 0)
          {
            View localView = (View)((WeakReference)sViewsWithListeners.get(i)).get();
            if (localView == null)
            {
              sViewsWithListeners.remove(i);
            }
            else
            {
              this.mViewsContainingListeners.put(localView, Boolean.TRUE);
              ViewParent localViewParent = localView.getParent();
              if ((localViewParent instanceof View))
              {
                this.mViewsContainingListeners.put((View)localViewParent, Boolean.TRUE);
                localViewParent = localViewParent.getParent();
                continue;
              }
            }
          }
          else
          {
            return;
          }
        }
        i--;
      }
    }

    static void registerListeningView(View paramView)
    {
      synchronized (sViewsWithListeners)
      {
        Iterator localIterator = sViewsWithListeners.iterator();
        while (localIterator.hasNext())
          if (((WeakReference)localIterator.next()).get() == paramView)
            return;
        sViewsWithListeners.add(new WeakReference(paramView));
        return;
      }
    }

    static void unregisterListeningView(View paramView)
    {
      ArrayList localArrayList = sViewsWithListeners;
      for (int i = 0; ; i++)
        try
        {
          if (i < sViewsWithListeners.size())
          {
            if (((WeakReference)sViewsWithListeners.get(i)).get() == paramView)
              sViewsWithListeners.remove(i);
          }
          else
            return;
        }
        finally
        {
        }
    }

    boolean dispatch(View paramView, KeyEvent paramKeyEvent)
    {
      if (paramKeyEvent.getAction() == 0)
        recalcViewsWithUnhandled();
      View localView = dispatchInOrder(paramView, paramKeyEvent);
      if (paramKeyEvent.getAction() == 0)
      {
        int i = paramKeyEvent.getKeyCode();
        if ((localView != null) && (!KeyEvent.isModifierKey(i)))
          getCapturedKeys().put(i, new WeakReference(localView));
      }
      return localView != null;
    }

    boolean preDispatch(KeyEvent paramKeyEvent)
    {
      if ((this.mLastDispatchedPreViewKeyEvent != null) && (this.mLastDispatchedPreViewKeyEvent.get() == paramKeyEvent))
        return false;
      this.mLastDispatchedPreViewKeyEvent = new WeakReference(paramKeyEvent);
      SparseArray localSparseArray = getCapturedKeys();
      int i = paramKeyEvent.getAction();
      WeakReference localWeakReference = null;
      if (i == 1)
      {
        int j = localSparseArray.indexOfKey(paramKeyEvent.getKeyCode());
        localWeakReference = null;
        if (j >= 0)
        {
          localWeakReference = (WeakReference)localSparseArray.valueAt(j);
          localSparseArray.removeAt(j);
        }
      }
      if (localWeakReference == null)
        localWeakReference = (WeakReference)localSparseArray.get(paramKeyEvent.getKeyCode());
      if (localWeakReference != null)
      {
        View localView = (View)localWeakReference.get();
        if ((localView != null) && (ViewCompat.isAttachedToWindow(localView)))
          onUnhandledKeyEvent(localView, paramKeyEvent);
        return true;
      }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat
 * JD-Core Version:    0.6.2
 */