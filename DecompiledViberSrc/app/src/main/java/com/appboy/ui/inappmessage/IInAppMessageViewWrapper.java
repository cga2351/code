package com.appboy.ui.inappmessage;

import android.app.Activity;
import android.view.View;
import com.appboy.e.b;

public abstract interface IInAppMessageViewWrapper
{
  public abstract void close();

  public abstract b getInAppMessage();

  public abstract View getInAppMessageView();

  public abstract boolean getIsAnimatingClose();

  public abstract void open(Activity paramActivity);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.IInAppMessageViewWrapper
 * JD-Core Version:    0.6.2
 */