package com.viber.jni.messenger;

import com.viber.jni.EncryptionParams;
import com.viber.jni.LocationInfo;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class MediaReceiverListener extends ControllerListener<MessengerDelegate.MediaReceiver>
  implements MessengerDelegate.MediaReceiver
{
  public boolean onMediaReceivedFromGroup(final long paramLong1, String paramString1, final long paramLong2, final String paramString2, byte[] paramArrayOfByte, final long paramLong3, final int paramInt1, final int paramInt2, LocationInfo paramLocationInfo, final int paramInt3, final String paramString3, final String paramString4, final String paramString5, final String paramString6, final int paramInt4, final int paramInt5, final String paramString7, final EncryptionParams paramEncryptionParams, final int paramInt6, final int paramInt7)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(MessengerDelegate.MediaReceiver paramAnonymousMediaReceiver)
      {
        paramAnonymousMediaReceiver.onMediaReceivedFromGroup(paramLong1, paramLong2, paramString2, paramLong3, paramInt1, paramInt2, paramInt3, paramString3, paramString4, paramString5, paramString6, paramInt4, paramInt5, paramString7, paramEncryptionParams, paramInt6, paramInt7, this.val$encParam, this.val$chatType, this.val$timebombInSec);
      }
    });
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.messenger.MediaReceiverListener
 * JD-Core Version:    0.6.2
 */