package com.viber.jni.publicaccount;

import com.viber.jni.PublicAccountInfo;
import com.viber.jni.PublicGroupInfo;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PublicAccountSearchListener extends ControllerListener<PublicAccountControllerDelegate.PublicAccountSearchReceiver>
  implements PublicAccountControllerDelegate.PublicAccountSearchReceiver
{
  public void onSearchPublicAccounts(final int paramInt1, final PublicAccountInfo[] paramArrayOfPublicAccountInfo, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountSearchReceiver paramAnonymousPublicAccountSearchReceiver)
      {
        paramAnonymousPublicAccountSearchReceiver.onSearchPublicAccounts(paramInt1, paramArrayOfPublicAccountInfo, paramInt2);
      }
    });
  }

  public void onSearchPublicGroups(final int paramInt1, final PublicGroupInfo[] paramArrayOfPublicGroupInfo, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicAccountControllerDelegate.PublicAccountSearchReceiver paramAnonymousPublicAccountSearchReceiver)
      {
        paramAnonymousPublicAccountSearchReceiver.onSearchPublicGroups(paramInt1, paramArrayOfPublicGroupInfo, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountSearchListener
 * JD-Core Version:    0.6.2
 */