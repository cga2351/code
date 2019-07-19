package com.viber.jni.messenger;

import com.viber.jni.LocationInfo;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PttReceiverListener extends ControllerListener<MessengerDelegate.PttReceiver>
  implements MessengerDelegate.PttReceiver
{
  public boolean onPttReceivedFromGroup(final long paramLong1, String paramString1, final long paramLong2, final String paramString2, long paramLong3, final int paramInt1, final int paramInt2, LocationInfo paramLocationInfo, final String paramString3, final int paramInt3, final String paramString4, final int paramInt4, final int paramInt5, final String paramString5, final int paramInt6, final int paramInt7)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.PttReceiver paramAnonymousPttReceiver)
      {
        paramAnonymousPttReceiver.onPttReceivedFromGroup(paramLong1, paramLong2, paramString2, paramInt1, paramInt2, paramString3, paramInt3, paramString4, paramInt4, paramInt5, paramString5, paramInt6, paramInt7, this.val$msgInfo, this.val$chatType, this.val$timebombInSec);
      }
    });
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.PttReceiverListener
 * JD-Core Version:    0.6.2
 */