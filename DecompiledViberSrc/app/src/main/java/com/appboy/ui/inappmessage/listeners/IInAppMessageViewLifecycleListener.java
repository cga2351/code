package com.appboy.ui.inappmessage.listeners;

import android.view.View;
import com.appboy.e.b;
import com.appboy.e.d;
import com.appboy.e.n;
import com.appboy.ui.inappmessage.InAppMessageCloser;

public abstract interface IInAppMessageViewLifecycleListener
{
  public abstract void afterClosed(b paramb);

  public abstract void afterOpened(View paramView, b paramb);

  public abstract void beforeClosed(View paramView, b paramb);

  public abstract void beforeOpened(View paramView, b paramb);

  public abstract void onButtonClicked(InAppMessageCloser paramInAppMessageCloser, n paramn, d paramd);

  public abstract void onClicked(InAppMessageCloser paramInAppMessageCloser, View paramView, b paramb);

  public abstract void onDismissed(View paramView, b paramb);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener
 * JD-Core Version:    0.6.2
 */