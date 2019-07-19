package com.appboy.ui.inappmessage;

import android.view.View;
import java.util.List;

public abstract interface IInAppMessageImmersiveView extends IInAppMessageView
{
  public abstract List<View> getMessageButtonViews(int paramInt);

  public abstract View getMessageCloseButtonView();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.IInAppMessageImmersiveView
 * JD-Core Version:    0.6.2
 */