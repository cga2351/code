package com.viber.jni.messenger;

import com.viber.jni.LocationInfo;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class FormattedReceiverListener extends ControllerListener<MessengerDelegate.FormattedReceiver>
  implements MessengerDelegate.FormattedReceiver
{
  public boolean onFormattedMessageReceivedFromGroup(final long paramLong1, String paramString1, final long paramLong2, final String paramString2, long paramLong3, final int paramInt1, final int paramInt2, LocationInfo paramLocationInfo, final String paramString3, final String paramString4, final int paramInt3, final int paramInt4, final int paramInt5, final int paramInt6)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.FormattedReceiver paramAnonymousFormattedReceiver)
      {
        paramAnonymousFormattedReceiver.onFormattedMessageReceivedFromGroup(paramLong1, paramLong2, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramInt5, paramInt6, this.val$appId, this.val$chatType, this.val$timebombInSec);
      }
    });
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.FormattedReceiverListener
 * JD-Core Version:    0.6.2
 */