package com.appboy.ui.inappmessage.listeners;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.appboy.b.e;
import com.appboy.e.b;
import com.appboy.e.n;
import com.appboy.f.k;
import com.appboy.h;
import com.appboy.ui.AppboyNavigator;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.NewsfeedAction;
import com.appboy.ui.actions.UriAction;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import com.appboy.ui.inappmessage.InAppMessageCloser;

public class AppboyInAppMessageViewLifecycleListener
  implements IInAppMessageViewLifecycleListener
{
  private static final String TAG = com.appboy.f.c.a(AppboyInAppMessageViewLifecycleListener.class);

  private AppboyInAppMessageManager getInAppMessageManager()
  {
    return AppboyInAppMessageManager.getInstance();
  }

  private void performClickAction(com.appboy.b.a.a parama, b paramb, InAppMessageCloser paramInAppMessageCloser, Uri paramUri, boolean paramBoolean)
  {
    if (getInAppMessageManager().getActivity() == null)
    {
      com.appboy.f.c.d(TAG, "Can't perform click action because the cached activity is null.");
      return;
    }
    switch (2.$SwitchMap$com$appboy$enums$inappmessage$ClickAction[parama.ordinal()])
    {
    default:
      paramInAppMessageCloser.close(false);
      return;
    case 1:
      paramInAppMessageCloser.close(false);
      NewsfeedAction localNewsfeedAction = new NewsfeedAction(com.appboy.f.d.a(paramb.b()), e.b);
      AppboyNavigator.getAppboyNavigator().gotoNewsFeed(getInAppMessageManager().getActivity(), localNewsfeedAction);
      return;
    case 2:
      paramInAppMessageCloser.close(false);
      UriAction localUriAction = ActionFactory.createUriActionFromUri(paramUri, com.appboy.f.d.a(paramb.b()), paramBoolean, e.b);
      AppboyNavigator.getAppboyNavigator().gotoUri(getInAppMessageManager().getActivity(), localUriAction);
      return;
    case 3:
    }
    paramInAppMessageCloser.close(paramb.m());
  }

  private void performInAppMessageButtonClicked(n paramn, b paramb, InAppMessageCloser paramInAppMessageCloser)
  {
    performClickAction(paramn.b(), paramb, paramInAppMessageCloser, paramn.c(), paramn.i());
  }

  private void performInAppMessageClicked(b paramb, InAppMessageCloser paramInAppMessageCloser)
  {
    performClickAction(paramb.n(), paramb, paramInAppMessageCloser, paramb.o(), paramb.w());
  }

  private void startClearHtmlInAppMessageAssetsThread()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        Activity localActivity = AppboyInAppMessageManager.getInstance().getActivity();
        if (localActivity != null)
          com.appboy.f.a.a(k.a(localActivity));
      }
    }).start();
  }

  public void afterClosed(b paramb)
  {
    com.appboy.f.c.b(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.afterClosed called.");
    getInAppMessageManager().resetAfterInAppMessageClose();
    if ((paramb instanceof com.appboy.e.c))
      startClearHtmlInAppMessageAssetsThread();
    paramb.z();
  }

  public void afterOpened(View paramView, b paramb)
  {
    com.appboy.f.c.b(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.afterOpened called.");
  }

  public void beforeClosed(View paramView, b paramb)
  {
    com.appboy.f.c.b(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.beforeClosed called.");
  }

  public void beforeOpened(View paramView, b paramb)
  {
    com.appboy.f.c.b(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.beforeOpened called.");
    paramb.x();
  }

  public void onButtonClicked(InAppMessageCloser paramInAppMessageCloser, n paramn, com.appboy.e.d paramd)
  {
    com.appboy.f.c.b(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.onButtonClicked called.");
    paramd.a(paramn);
    if (!getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageButtonClicked(paramn, paramInAppMessageCloser))
      performInAppMessageButtonClicked(paramn, paramd, paramInAppMessageCloser);
  }

  public void onClicked(InAppMessageCloser paramInAppMessageCloser, View paramView, b paramb)
  {
    com.appboy.f.c.b(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.onClicked called.");
    paramb.y();
    if (!getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageClicked(paramb, paramInAppMessageCloser))
      performInAppMessageClicked(paramb, paramInAppMessageCloser);
  }

  public void onDismissed(View paramView, b paramb)
  {
    com.appboy.f.c.b(TAG, "InAppMessageViewWrapper.IInAppMessageViewLifecycleListener.onDismissed called.");
    getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageDismissed(paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.AppboyInAppMessageViewLifecycleListener
 * JD-Core Version:    0.6.2
 */