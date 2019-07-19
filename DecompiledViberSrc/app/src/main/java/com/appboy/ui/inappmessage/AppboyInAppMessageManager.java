package com.appboy.ui.inappmessage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import com.appboy.a;
import com.appboy.b.a.e;
import com.appboy.b.a.g;
import com.appboy.c.d;
import com.appboy.e.h;
import com.appboy.e.j;
import com.appboy.e.k;
import com.appboy.e.l;
import com.appboy.e.m;
import com.appboy.ui.inappmessage.factories.AppboyFullViewFactory;
import com.appboy.ui.inappmessage.factories.AppboyHtmlFullViewFactory;
import com.appboy.ui.inappmessage.factories.AppboyInAppMessageAnimationFactory;
import com.appboy.ui.inappmessage.factories.AppboyModalViewFactory;
import com.appboy.ui.inappmessage.factories.AppboySlideupViewFactory;
import com.appboy.ui.inappmessage.listeners.AppboyDefaultHtmlInAppMessageActionListener;
import com.appboy.ui.inappmessage.listeners.AppboyDefaultInAppMessageManagerListener;
import com.appboy.ui.inappmessage.listeners.AppboyInAppMessageViewLifecycleListener;
import com.appboy.ui.inappmessage.listeners.AppboyInAppMessageWebViewClientListener;
import com.appboy.ui.inappmessage.listeners.IHtmlInAppMessageActionListener;
import com.appboy.ui.inappmessage.listeners.IInAppMessageManagerListener;
import com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.appboy.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.appboy.ui.support.ViewUtils;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"StaticFieldLeak"})
public final class AppboyInAppMessageManager
{
  private static final String TAG = com.appboy.f.c.a(AppboyInAppMessageManager.class);
  private static volatile AppboyInAppMessageManager sInstance = null;
  private Activity mActivity;
  private com.appboy.a.b mAppboyConfigurationProvider;
  private Context mApplicationContext;
  private com.appboy.e.b mCarryoverInAppMessage;
  private IInAppMessageManagerListener mCustomControlInAppMessageManagerListener;
  private IHtmlInAppMessageActionListener mCustomHtmlInAppMessageActionListener;
  private IInAppMessageAnimationFactory mCustomInAppMessageAnimationFactory;
  private IInAppMessageManagerListener mCustomInAppMessageManagerListener;
  private IInAppMessageViewFactory mCustomInAppMessageViewFactory;
  private IHtmlInAppMessageActionListener mDefaultHtmlInAppMessageActionListener = new AppboyDefaultHtmlInAppMessageActionListener();
  private IInAppMessageManagerListener mDefaultInAppMessageManagerListener = new AppboyDefaultInAppMessageManagerListener();
  private AtomicBoolean mDisplayingInAppMessage = new AtomicBoolean(false);
  private IInAppMessageAnimationFactory mInAppMessageAnimationFactory = new AppboyInAppMessageAnimationFactory();
  private com.appboy.c.c<d> mInAppMessageEventSubscriber;
  private IInAppMessageViewFactory mInAppMessageFullViewFactory = new AppboyFullViewFactory();
  private IInAppMessageViewFactory mInAppMessageHtmlFullViewFactory = new AppboyHtmlFullViewFactory(this.mInAppMessageWebViewClientListener);
  private IInAppMessageViewFactory mInAppMessageModalViewFactory = new AppboyModalViewFactory();
  private IInAppMessageViewFactory mInAppMessageSlideupViewFactory = new AppboySlideupViewFactory();
  private final Stack<com.appboy.e.b> mInAppMessageStack = new Stack();
  private final IInAppMessageViewLifecycleListener mInAppMessageViewLifecycleListener = new AppboyInAppMessageViewLifecycleListener();
  private IInAppMessageViewWrapper mInAppMessageViewWrapper;
  private final IInAppMessageWebViewClientListener mInAppMessageWebViewClientListener = new AppboyInAppMessageWebViewClientListener();
  private Integer mOriginalOrientation;
  private com.appboy.e.b mUnRegisteredInAppMessage;

  private com.appboy.c.c<d> createInAppMessageEventSubscriber()
  {
    return new com.appboy.c.c()
    {
      public void trigger(d paramAnonymousd)
      {
        if (AppboyInAppMessageManager.this.getInAppMessageManagerListener().onInAppMessageReceived(paramAnonymousd.a()))
          return;
        AppboyInAppMessageManager.this.addInAppMessage(paramAnonymousd.a());
      }
    };
  }

  private boolean currentOrientationIsValid(int paramInt, g paramg)
  {
    if ((paramInt == 2) && (paramg == g.b))
    {
      com.appboy.f.c.b(TAG, "Current and preferred orientation are landscape.");
      return true;
    }
    if ((paramInt == 1) && (paramg == g.a))
    {
      com.appboy.f.c.b(TAG, "Current and preferred orientation are portrait.");
      return true;
    }
    com.appboy.f.c.b(TAG, "Current orientation " + paramInt + " and preferred orientation " + paramg + " don't match");
    return false;
  }

  private IInAppMessageAnimationFactory getInAppMessageAnimationFactory()
  {
    if (this.mCustomInAppMessageAnimationFactory != null)
      return this.mCustomInAppMessageAnimationFactory;
    return this.mInAppMessageAnimationFactory;
  }

  private IInAppMessageViewFactory getInAppMessageViewFactory(com.appboy.e.b paramb)
  {
    if (this.mCustomInAppMessageViewFactory != null)
      return this.mCustomInAppMessageViewFactory;
    if ((paramb instanceof m))
      return this.mInAppMessageSlideupViewFactory;
    if ((paramb instanceof l))
      return this.mInAppMessageModalViewFactory;
    if ((paramb instanceof h))
      return this.mInAppMessageFullViewFactory;
    if ((paramb instanceof j))
      return this.mInAppMessageHtmlFullViewFactory;
    return null;
  }

  public static AppboyInAppMessageManager getInstance()
  {
    if (sInstance == null);
    try
    {
      if (sInstance == null)
        sInstance = new AppboyInAppMessageManager();
      return sInstance;
    }
    finally
    {
    }
  }

  public void addInAppMessage(com.appboy.e.b paramb)
  {
    this.mInAppMessageStack.push(paramb);
    requestDisplayInAppMessage();
  }

  boolean displayInAppMessage(com.appboy.e.b paramb, boolean paramBoolean)
  {
    if (!this.mDisplayingInAppMessage.compareAndSet(false, true))
    {
      com.appboy.f.c.b(TAG, "A in-app message is currently being displayed. Adding in-app message back on the stack.");
      this.mInAppMessageStack.push(paramb);
      return false;
    }
    try
    {
      if (this.mActivity == null)
      {
        this.mCarryoverInAppMessage = paramb;
        throw new Exception("No activity is currently registered to receive in-app messages. Registering in-app message as carry-over in-app message. It will automatically be displayed when the next activity registers to receive in-app messages.");
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(TAG, "Could not display in-app message", localException);
      resetAfterInAppMessageClose();
      return false;
    }
    if (!paramBoolean)
    {
      long l1 = paramb.v();
      if (l1 > 0L)
      {
        long l2 = System.currentTimeMillis();
        if (l2 > l1)
          throw new Exception("In-app message is expired. Doing nothing. Expiration: $" + l1 + ". Current time: " + l2);
      }
      else
      {
        com.appboy.f.c.b(TAG, "Expiration timestamp not defined. Continuing.");
      }
    }
    while (!verifyOrientationStatus(paramb))
    {
      throw new Exception("Current orientation did not match specified orientation for in-app message. Doing nothing.");
      com.appboy.f.c.b(TAG, "Not checking expiration status for carry-over in-app message.");
    }
    if (paramb.A())
    {
      com.appboy.f.c.b(TAG, "Not displaying control in-app message. Logging impression and ending display execution.");
      paramb.x();
      resetAfterInAppMessageClose();
      return true;
    }
    IInAppMessageViewFactory localIInAppMessageViewFactory = getInAppMessageViewFactory(paramb);
    if (localIInAppMessageViewFactory == null)
    {
      paramb.a(e.d);
      throw new Exception("ViewFactory from getInAppMessageViewFactory was null.");
    }
    View localView = localIInAppMessageViewFactory.createInAppMessageView(this.mActivity, paramb);
    if (localView == null)
    {
      paramb.a(e.d);
      throw new Exception("The in-app message view returned from the IInAppMessageViewFactory was null. The in-app message will not be displayed and will not be put back on the stack.");
    }
    if (localView.getParent() != null)
    {
      paramb.a(e.d);
      throw new Exception("The in-app message view returned from the IInAppMessageViewFactory already has a parent. This is a sign that the view is being reused. The IInAppMessageViewFactory method createInAppMessageViewmust return a new view without a parent. The in-app message will not be displayed and will not be put back on the stack.");
    }
    Animation localAnimation1 = getInAppMessageAnimationFactory().getOpeningAnimation(paramb);
    Animation localAnimation2 = getInAppMessageAnimationFactory().getClosingAnimation(paramb);
    IInAppMessageImmersiveView localIInAppMessageImmersiveView;
    k localk;
    if ((localView instanceof IInAppMessageImmersiveView))
    {
      com.appboy.f.c.b(TAG, "Creating view wrapper for immersive in-app message.");
      localIInAppMessageImmersiveView = (IInAppMessageImmersiveView)localView;
      localk = (k)paramb;
      if (localk.B() == null)
        break label557;
    }
    label557: for (int i = localk.B().size(); ; i = 0)
    {
      this.mInAppMessageViewWrapper = new InAppMessageViewWrapper(localView, paramb, this.mInAppMessageViewLifecycleListener, this.mAppboyConfigurationProvider, localAnimation1, localAnimation2, localIInAppMessageImmersiveView.getMessageClickableView(), localIInAppMessageImmersiveView.getMessageButtonViews(i), localIInAppMessageImmersiveView.getMessageCloseButtonView());
      while (true)
      {
        this.mInAppMessageViewWrapper.open(this.mActivity);
        return true;
        if ((localView instanceof IInAppMessageView))
        {
          com.appboy.f.c.b(TAG, "Creating view wrapper for base in-app message.");
          IInAppMessageView localIInAppMessageView = (IInAppMessageView)localView;
          this.mInAppMessageViewWrapper = new InAppMessageViewWrapper(localView, paramb, this.mInAppMessageViewLifecycleListener, this.mAppboyConfigurationProvider, localAnimation1, localAnimation2, localIInAppMessageView.getMessageClickableView());
        }
        else
        {
          com.appboy.f.c.b(TAG, "Creating view wrapper for in-app message.");
          this.mInAppMessageViewWrapper = new InAppMessageViewWrapper(localView, paramb, this.mInAppMessageViewLifecycleListener, this.mAppboyConfigurationProvider, localAnimation1, localAnimation2, localView);
        }
      }
    }
  }

  public void ensureSubscribedToInAppMessageEvents(Context paramContext)
  {
    if (this.mInAppMessageEventSubscriber == null)
    {
      com.appboy.f.c.b(TAG, "Subscribing in-app message event subscriber");
      this.mInAppMessageEventSubscriber = createInAppMessageEventSubscriber();
      a.a(paramContext).a(this.mInAppMessageEventSubscriber);
    }
  }

  public Activity getActivity()
  {
    return this.mActivity;
  }

  public Context getApplicationContext()
  {
    return this.mApplicationContext;
  }

  public IInAppMessageManagerListener getControlInAppMessageManagerListener()
  {
    if (this.mCustomControlInAppMessageManagerListener != null)
      return this.mCustomControlInAppMessageManagerListener;
    return this.mDefaultInAppMessageManagerListener;
  }

  public IHtmlInAppMessageActionListener getHtmlInAppMessageActionListener()
  {
    if (this.mCustomHtmlInAppMessageActionListener != null)
      return this.mCustomHtmlInAppMessageActionListener;
    return this.mDefaultHtmlInAppMessageActionListener;
  }

  public IInAppMessageManagerListener getInAppMessageManagerListener()
  {
    if (this.mCustomInAppMessageManagerListener != null)
      return this.mCustomInAppMessageManagerListener;
    return this.mDefaultInAppMessageManagerListener;
  }

  public void hideCurrentlyDisplayingInAppMessage(boolean paramBoolean)
  {
    IInAppMessageViewWrapper localIInAppMessageViewWrapper = this.mInAppMessageViewWrapper;
    if (localIInAppMessageViewWrapper != null)
    {
      if (paramBoolean)
        this.mInAppMessageViewLifecycleListener.onDismissed(localIInAppMessageViewWrapper.getInAppMessageView(), localIInAppMessageViewWrapper.getInAppMessage());
      localIInAppMessageViewWrapper.close();
    }
  }

  public void registerInAppMessageManager(Activity paramActivity)
  {
    com.appboy.f.c.b(TAG, "registerInAppMessageManager called");
    this.mActivity = paramActivity;
    if ((this.mActivity != null) && (this.mApplicationContext == null))
      this.mApplicationContext = this.mActivity.getApplicationContext();
    if (this.mAppboyConfigurationProvider == null)
      this.mAppboyConfigurationProvider = new com.appboy.a.b(this.mApplicationContext);
    if (this.mCarryoverInAppMessage != null)
    {
      com.appboy.f.c.b(TAG, "Requesting display of carryover in-app message.");
      this.mCarryoverInAppMessage.a(false);
      displayInAppMessage(this.mCarryoverInAppMessage, true);
      this.mCarryoverInAppMessage = null;
    }
    while (true)
    {
      ensureSubscribedToInAppMessageEvents(this.mApplicationContext);
      return;
      if (this.mUnRegisteredInAppMessage != null)
      {
        com.appboy.f.c.b(TAG, "Adding previously unregistered in-app message.");
        addInAppMessage(this.mUnRegisteredInAppMessage);
        this.mUnRegisteredInAppMessage = null;
      }
    }
  }

  public boolean requestDisplayInAppMessage()
  {
    try
    {
      if (this.mActivity == null)
        if (!this.mInAppMessageStack.empty())
        {
          com.appboy.f.c.d(TAG, "No activity is currently registered to receive in-app messages. Saving in-app message as unregistered in-app message. It will automatically be displayed when the next activity registers to receive in-app messages.");
          this.mUnRegisteredInAppMessage = ((com.appboy.e.b)this.mInAppMessageStack.pop());
        }
        else
        {
          com.appboy.f.c.b(TAG, "No activity is currently registered to receive in-app messages and the in-app message stack is empty. Doing nothing.");
        }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(TAG, "Error running requestDisplayInAppMessage", localException);
      return false;
    }
    if (this.mDisplayingInAppMessage.get())
    {
      com.appboy.f.c.b(TAG, "A in-app message is currently being displayed. Ignoring request to display in-app message.");
      return false;
    }
    if (this.mInAppMessageStack.isEmpty())
    {
      com.appboy.f.c.b(TAG, "The in-app message stack is empty. No in-app message will be displayed.");
      return false;
    }
    final com.appboy.e.b localb = (com.appboy.e.b)this.mInAppMessageStack.pop();
    if (!localb.A());
    for (InAppMessageOperation localInAppMessageOperation = getInAppMessageManagerListener().beforeInAppMessageDisplayed(localb); ; localInAppMessageOperation = getControlInAppMessageManagerListener().beforeInAppMessageDisplayed(localb))
      switch (3.$SwitchMap$com$appboy$ui$inappmessage$InAppMessageOperation[localInAppMessageOperation.ordinal()])
      {
      default:
        com.appboy.f.c.e(TAG, "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned null instead of a InAppMessageOperation. Ignoring the in-app message. Please check the IInAppMessageStackBehaviour implementation.");
        return false;
        com.appboy.f.c.b(TAG, "Using the control in-app message manager listener.");
      case 1:
      case 2:
      case 3:
      }
    com.appboy.f.c.b(TAG, "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISPLAY_NOW. The in-app message will be displayed.");
    new Handler(this.mApplicationContext.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppboyAsyncInAppMessageDisplayer localAppboyAsyncInAppMessageDisplayer = new AppboyAsyncInAppMessageDisplayer();
        com.appboy.e.b[] arrayOfb = new com.appboy.e.b[1];
        arrayOfb[0] = localb;
        localAppboyAsyncInAppMessageDisplayer.execute(arrayOfb);
      }
    });
    return true;
    com.appboy.f.c.b(TAG, "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISPLAY_LATER. The in-app message will be pushed back onto the stack.");
    this.mInAppMessageStack.push(localb);
    return false;
    com.appboy.f.c.b(TAG, "The IInAppMessageManagerListener method beforeInAppMessageDisplayed returned DISCARD. The in-app message will not be displayed and will not be put back on the stack.");
    return false;
    return false;
  }

  public void resetAfterInAppMessageClose()
  {
    com.appboy.f.c.a(TAG, "Resetting after in-app message close.");
    this.mInAppMessageViewWrapper = null;
    this.mDisplayingInAppMessage.set(false);
    if ((this.mActivity != null) && (this.mOriginalOrientation != null))
    {
      com.appboy.f.c.b(TAG, "Setting requested orientation to original orientation " + this.mOriginalOrientation);
      ViewUtils.setActivityRequestedOrientation(this.mActivity, this.mOriginalOrientation.intValue());
      this.mOriginalOrientation = null;
    }
  }

  public void setCustomInAppMessageManagerListener(IInAppMessageManagerListener paramIInAppMessageManagerListener)
  {
    com.appboy.f.c.b(TAG, "Custom InAppMessageManagerListener set");
    this.mCustomInAppMessageManagerListener = paramIInAppMessageManagerListener;
  }

  public void unregisterInAppMessageManager(Activity paramActivity)
  {
    com.appboy.f.c.b(TAG, "unregisterInAppMessageManager called");
    if (this.mInAppMessageViewWrapper != null)
    {
      ViewUtils.removeViewFromParent(this.mInAppMessageViewWrapper.getInAppMessageView());
      if (this.mInAppMessageViewWrapper.getIsAnimatingClose())
      {
        this.mInAppMessageViewLifecycleListener.afterClosed(this.mInAppMessageViewWrapper.getInAppMessage());
        this.mCarryoverInAppMessage = null;
        this.mInAppMessageViewWrapper = null;
      }
    }
    while (true)
    {
      this.mActivity = null;
      this.mDisplayingInAppMessage.set(false);
      return;
      this.mCarryoverInAppMessage = this.mInAppMessageViewWrapper.getInAppMessage();
      break;
      this.mCarryoverInAppMessage = null;
    }
  }

  @SuppressLint({"InlinedApi"})
  boolean verifyOrientationStatus(com.appboy.e.b paramb)
  {
    if (ViewUtils.isRunningOnTablet(this.mActivity))
      com.appboy.f.c.b(TAG, "Running on tablet. In-app message can be displayed in any orientation.");
    do
    {
      return true;
      g localg = paramb.t();
      if (localg == null)
      {
        com.appboy.f.c.b(TAG, "No orientation specified. In-app message can be displayed in any orientation.");
        return true;
      }
      if (localg == g.c)
      {
        com.appboy.f.c.b(TAG, "Any orientation specified. In-app message can be displayed in any orientation.");
        return true;
      }
      if (!currentOrientationIsValid(this.mActivity.getResources().getConfiguration().orientation, localg))
        break;
    }
    while (this.mOriginalOrientation != null);
    com.appboy.f.c.b(TAG, "Requesting orientation lock.");
    this.mOriginalOrientation = Integer.valueOf(this.mActivity.getRequestedOrientation());
    ViewUtils.setActivityRequestedOrientation(this.mActivity, 14);
    return true;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.AppboyInAppMessageManager
 * JD-Core Version:    0.6.2
 */