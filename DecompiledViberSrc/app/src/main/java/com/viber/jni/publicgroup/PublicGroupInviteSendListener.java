package com.viber.jni.publicgroup;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import java.util.Map;

public class PublicGroupInviteSendListener extends ControllerListener<PublicGroupControllerDelegate.InviteSend>
  implements PublicGroupControllerDelegate.InviteSend
{
  public void onSendPublicGroupInviteReply(final int paramInt1, final long paramLong, int paramInt2, final Map<String, Integer> paramMap)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PublicGroupControllerDelegate.InviteSend paramAnonymousInviteSend)
      {
        paramAnonymousInviteSend.onSendPublicGroupInviteReply(paramInt1, paramLong, paramMap, this.val$failures);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicgroup.PublicGroupInviteSendListener
 * JD-Core Version:    0.6.2
 */