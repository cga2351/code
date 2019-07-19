package com.appboy.ui.inappmessage;

import android.app.Activity;
import android.support.v4.view.DisplayCutoutCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.appboy.b.a.h;
import com.appboy.e.d;
import com.appboy.e.m;
import com.appboy.e.n;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.appboy.ui.inappmessage.listeners.SwipeDismissTouchListener.DismissCallbacks;
import com.appboy.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener;
import com.appboy.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener.ITouchListener;
import com.appboy.ui.inappmessage.views.AppboyInAppMessageHtmlBaseView;
import com.appboy.ui.support.ViewUtils;
import java.util.Iterator;
import java.util.List;

public class InAppMessageViewWrapper
  implements IInAppMessageViewWrapper
{
  private static final String TAG = com.appboy.f.c.a(InAppMessageViewWrapper.class);
  private final com.appboy.a.b mAppboyConfigurationProvider;
  private List<View> mButtons;
  private View mClickableInAppMessageView;
  private View mCloseButton;
  private final Animation mClosingAnimation;
  private FrameLayout mContentFrameLayout;
  private Runnable mDismissRunnable;
  private final com.appboy.e.b mInAppMessage;
  private final View mInAppMessageView;
  private final IInAppMessageViewLifecycleListener mInAppMessageViewLifecycleListener;
  private boolean mIsAnimatingClose;
  private final Animation mOpeningAnimation;

  public InAppMessageViewWrapper(View paramView1, com.appboy.e.b paramb, IInAppMessageViewLifecycleListener paramIInAppMessageViewLifecycleListener, com.appboy.a.b paramb1, Animation paramAnimation1, Animation paramAnimation2, View paramView2)
  {
    this.mInAppMessageView = paramView1;
    this.mInAppMessage = paramb;
    this.mInAppMessageViewLifecycleListener = paramIInAppMessageViewLifecycleListener;
    this.mAppboyConfigurationProvider = paramb1;
    this.mIsAnimatingClose = false;
    if (paramView2 != null);
    for (this.mClickableInAppMessageView = paramView2; ; this.mClickableInAppMessageView = this.mInAppMessageView)
    {
      if ((this.mInAppMessage instanceof m))
      {
        TouchAwareSwipeDismissTouchListener localTouchAwareSwipeDismissTouchListener = new TouchAwareSwipeDismissTouchListener(paramView1, null, createDismissCallbacks());
        localTouchAwareSwipeDismissTouchListener.setTouchListener(createTouchAwareListener());
        this.mClickableInAppMessageView.setOnTouchListener(localTouchAwareSwipeDismissTouchListener);
      }
      this.mOpeningAnimation = paramAnimation1;
      this.mClosingAnimation = paramAnimation2;
      this.mClickableInAppMessageView.setOnClickListener(createClickListener());
      return;
    }
  }

  public InAppMessageViewWrapper(View paramView1, com.appboy.e.b paramb, IInAppMessageViewLifecycleListener paramIInAppMessageViewLifecycleListener, com.appboy.a.b paramb1, Animation paramAnimation1, Animation paramAnimation2, View paramView2, List<View> paramList, View paramView3)
  {
    this(paramView1, paramb, paramIInAppMessageViewLifecycleListener, paramb1, paramAnimation1, paramAnimation2, paramView2);
    if (paramView3 != null)
    {
      this.mCloseButton = paramView3;
      this.mCloseButton.setOnClickListener(createCloseInAppMessageClickListener());
    }
    if (paramList != null)
    {
      this.mButtons = paramList;
      Iterator localIterator = this.mButtons.iterator();
      while (localIterator.hasNext())
        ((View)localIterator.next()).setOnClickListener(createButtonClickListener());
    }
  }

  private void addDismissRunnable()
  {
    if (this.mDismissRunnable == null)
    {
      this.mDismissRunnable = new Runnable()
      {
        public void run()
        {
          AppboyInAppMessageManager.getInstance().hideCurrentlyDisplayingInAppMessage(true);
        }
      };
      this.mInAppMessageView.postDelayed(this.mDismissRunnable, this.mInAppMessage.c());
    }
  }

  private void announceForAccessibilityIfNecessary()
  {
    if ((this.mInAppMessageView instanceof IInAppMessageImmersiveView))
      this.mInAppMessageView.announceForAccessibility(this.mInAppMessage.a());
    while (!(this.mInAppMessageView instanceof AppboyInAppMessageHtmlBaseView))
      return;
    this.mInAppMessageView.announceForAccessibility("In-app message displayed.");
  }

  private void closeInAppMessageView()
  {
    com.appboy.f.c.b(TAG, "Closing in-app message view");
    ViewUtils.removeViewFromParent(this.mInAppMessageView);
    if ((this.mInAppMessageView instanceof AppboyInAppMessageHtmlBaseView))
    {
      AppboyInAppMessageHtmlBaseView localAppboyInAppMessageHtmlBaseView = (AppboyInAppMessageHtmlBaseView)this.mInAppMessageView;
      if (localAppboyInAppMessageHtmlBaseView.getMessageWebView() != null)
      {
        com.appboy.f.c.b(TAG, "Called destroy on the AppboyInAppMessageHtmlBaseView WebView");
        localAppboyInAppMessageHtmlBaseView.getMessageWebView().destroy();
      }
    }
    this.mInAppMessageViewLifecycleListener.afterClosed(this.mInAppMessage);
  }

  private Animation.AnimationListener createAnimationListener(boolean paramBoolean)
  {
    if (paramBoolean)
      return new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          if (InAppMessageViewWrapper.this.mInAppMessage.q() == com.appboy.b.a.c.a)
            InAppMessageViewWrapper.this.addDismissRunnable();
          com.appboy.f.c.b(InAppMessageViewWrapper.TAG, "In-app message animated into view.");
          ViewUtils.setFocusableInTouchModeAndRequestFocus(InAppMessageViewWrapper.this.mInAppMessageView);
          InAppMessageViewWrapper.this.announceForAccessibilityIfNecessary();
          InAppMessageViewWrapper.this.mInAppMessageViewLifecycleListener.afterOpened(InAppMessageViewWrapper.this.mInAppMessageView, InAppMessageViewWrapper.this.mInAppMessage);
        }

        public void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
        }

        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
        }
      };
    return new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        InAppMessageViewWrapper.this.mInAppMessageView.clearAnimation();
        InAppMessageViewWrapper.this.mInAppMessageView.setVisibility(8);
        InAppMessageViewWrapper.this.closeInAppMessageView();
      }

      public void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
      }

      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
      }
    };
  }

  private View.OnClickListener createButtonClickListener()
  {
    return new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        d locald = (d)InAppMessageViewWrapper.this.mInAppMessage;
        for (int i = 0; ; i++)
          if (i < InAppMessageViewWrapper.this.mButtons.size())
          {
            if (paramAnonymousView.getId() == ((View)InAppMessageViewWrapper.this.mButtons.get(i)).getId())
            {
              n localn = (n)locald.B().get(i);
              InAppMessageViewWrapper.this.mInAppMessageViewLifecycleListener.onButtonClicked(new InAppMessageCloser(InAppMessageViewWrapper.this), localn, locald);
            }
          }
          else
            return;
      }
    };
  }

  private View.OnClickListener createClickListener()
  {
    return new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((InAppMessageViewWrapper.this.mInAppMessage instanceof d))
        {
          d locald = (d)InAppMessageViewWrapper.this.mInAppMessage;
          if ((locald.B() == null) || (locald.B().size() == 0))
            InAppMessageViewWrapper.this.mInAppMessageViewLifecycleListener.onClicked(new InAppMessageCloser(InAppMessageViewWrapper.this), InAppMessageViewWrapper.this.mInAppMessageView, InAppMessageViewWrapper.this.mInAppMessage);
          return;
        }
        InAppMessageViewWrapper.this.mInAppMessageViewLifecycleListener.onClicked(new InAppMessageCloser(InAppMessageViewWrapper.this), InAppMessageViewWrapper.this.mInAppMessageView, InAppMessageViewWrapper.this.mInAppMessage);
      }
    };
  }

  private View.OnClickListener createCloseInAppMessageClickListener()
  {
    return new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppboyInAppMessageManager.getInstance().hideCurrentlyDisplayingInAppMessage(true);
      }
    };
  }

  private SwipeDismissTouchListener.DismissCallbacks createDismissCallbacks()
  {
    return new SwipeDismissTouchListener.DismissCallbacks()
    {
      public boolean canDismiss(Object paramAnonymousObject)
      {
        return true;
      }

      public void onDismiss(View paramAnonymousView, Object paramAnonymousObject)
      {
        InAppMessageViewWrapper.this.mInAppMessage.b(false);
        AppboyInAppMessageManager.getInstance().hideCurrentlyDisplayingInAppMessage(true);
      }
    };
  }

  private TouchAwareSwipeDismissTouchListener.ITouchListener createTouchAwareListener()
  {
    return new TouchAwareSwipeDismissTouchListener.ITouchListener()
    {
      public void onTouchEnded()
      {
        if (InAppMessageViewWrapper.this.mInAppMessage.q() == com.appboy.b.a.c.a)
          InAppMessageViewWrapper.this.addDismissRunnable();
      }

      public void onTouchStartedOrContinued()
      {
        InAppMessageViewWrapper.this.mInAppMessageView.removeCallbacks(InAppMessageViewWrapper.this.mDismissRunnable);
      }
    };
  }

  private FrameLayout.LayoutParams getLayoutParams(FrameLayout paramFrameLayout, int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    if ((this.mInAppMessage instanceof m))
      if (((m)this.mInAppMessage).B() != h.a)
        break label110;
    label110: for (int j = 48; ; j = 80)
    {
      localLayoutParams.gravity = j;
      if ((paramInt > 0) && (paramInt == paramFrameLayout.getHeight()))
      {
        int i = ViewUtils.getTopVisibleCoordinate(paramFrameLayout);
        com.appboy.f.c.b(TAG, "Detected status bar height of " + i + ".");
        localLayoutParams.setMargins(0, i, 0, 0);
      }
      return localLayoutParams;
    }
  }

  private void open(FrameLayout paramFrameLayout, int paramInt)
  {
    this.mInAppMessageViewLifecycleListener.beforeOpened(this.mInAppMessageView, this.mInAppMessage);
    com.appboy.f.c.b(TAG, "Adding In-app message view to root FrameLayout.");
    paramFrameLayout.addView(this.mInAppMessageView, getLayoutParams(paramFrameLayout, paramInt));
    ViewCompat.requestApplyInsets(paramFrameLayout);
    ViewCompat.setOnApplyWindowInsetsListener(paramFrameLayout, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        DisplayCutoutCompat localDisplayCutoutCompat = paramAnonymousWindowInsetsCompat.getDisplayCutout();
        if (localDisplayCutoutCompat != null)
          ((FrameLayout.LayoutParams)InAppMessageViewWrapper.this.mInAppMessageView.getLayoutParams()).setMargins(localDisplayCutoutCompat.getSafeInsetLeft(), localDisplayCutoutCompat.getSafeInsetTop(), localDisplayCutoutCompat.getSafeInsetRight(), localDisplayCutoutCompat.getSafeInsetBottom());
        return paramAnonymousWindowInsetsCompat;
      }
    });
    if (this.mInAppMessage.l())
    {
      com.appboy.f.c.b(TAG, "In-app message view will animate into the visible area.");
      setAndStartAnimation(true);
      return;
    }
    com.appboy.f.c.b(TAG, "In-app message view will be placed instantly into the visible area.");
    if (this.mInAppMessage.q() == com.appboy.b.a.c.a)
      addDismissRunnable();
    ViewUtils.setFocusableInTouchModeAndRequestFocus(this.mInAppMessageView);
    announceForAccessibilityIfNecessary();
    this.mInAppMessageViewLifecycleListener.afterOpened(this.mInAppMessageView, this.mInAppMessage);
  }

  private static void setAllFrameLayoutChildrenAsAccessibilityAuto(FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout == null)
      com.appboy.f.c.d(TAG, "In-app message FrameLayout was null. Not preparing in-app message accessibility for exclusive mode.");
    while (true)
    {
      return;
      for (int i = 0; i < paramFrameLayout.getChildCount(); i++)
      {
        View localView = paramFrameLayout.getChildAt(i);
        if (localView != null)
          ViewCompat.setImportantForAccessibility(localView, 0);
      }
    }
  }

  private static void setAllFrameLayoutChildrenAsNonAccessibilityImportant(FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout == null)
      com.appboy.f.c.d(TAG, "In-app message FrameLayout was null. Not preparing in-app message accessibility for exclusive mode.");
    while (true)
    {
      return;
      for (int i = 0; i < paramFrameLayout.getChildCount(); i++)
      {
        View localView = paramFrameLayout.getChildAt(i);
        if (localView != null)
          ViewCompat.setImportantForAccessibility(localView, 4);
      }
    }
  }

  private void setAndStartAnimation(boolean paramBoolean)
  {
    if (paramBoolean);
    for (Animation localAnimation = this.mOpeningAnimation; ; localAnimation = this.mClosingAnimation)
    {
      localAnimation.setAnimationListener(createAnimationListener(paramBoolean));
      this.mInAppMessageView.clearAnimation();
      this.mInAppMessageView.setAnimation(localAnimation);
      localAnimation.startNow();
      this.mInAppMessageView.invalidate();
      return;
    }
  }

  public void close()
  {
    if (this.mAppboyConfigurationProvider.z())
      setAllFrameLayoutChildrenAsAccessibilityAuto(this.mContentFrameLayout);
    this.mInAppMessageView.removeCallbacks(this.mDismissRunnable);
    this.mInAppMessageViewLifecycleListener.beforeClosed(this.mInAppMessageView, this.mInAppMessage);
    if (this.mInAppMessage.m())
    {
      this.mIsAnimatingClose = true;
      setAndStartAnimation(false);
      return;
    }
    closeInAppMessageView();
  }

  public com.appboy.e.b getInAppMessage()
  {
    return this.mInAppMessage;
  }

  public View getInAppMessageView()
  {
    return this.mInAppMessageView;
  }

  public boolean getIsAnimatingClose()
  {
    return this.mIsAnimatingClose;
  }

  public void open(Activity paramActivity)
  {
    final FrameLayout localFrameLayout = (FrameLayout)paramActivity.getWindow().getDecorView().findViewById(16908290);
    int i = localFrameLayout.getHeight();
    final int j = ViewUtils.getDisplayHeight(paramActivity);
    if (this.mAppboyConfigurationProvider.z())
    {
      this.mContentFrameLayout = localFrameLayout;
      setAllFrameLayoutChildrenAsNonAccessibilityImportant(this.mContentFrameLayout);
    }
    if (i == 0)
    {
      ViewTreeObserver localViewTreeObserver = localFrameLayout.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
        localViewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            com.appboy.f.c.b(InAppMessageViewWrapper.TAG, "Detected root view height of " + localFrameLayout.getHeight() + ", display height of " + j + " in onGlobalLayout");
            localFrameLayout.removeView(InAppMessageViewWrapper.this.mInAppMessageView);
            InAppMessageViewWrapper.this.open(localFrameLayout, j);
            localFrameLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
          }
        });
      return;
    }
    com.appboy.f.c.b(TAG, "Detected root view height of " + i + ", display height of " + j);
    open(localFrameLayout, j);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.InAppMessageViewWrapper
 * JD-Core Version:    0.6.2
 */