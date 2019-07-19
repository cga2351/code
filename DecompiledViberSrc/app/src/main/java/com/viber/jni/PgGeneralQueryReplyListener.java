package com.viber.jni;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class PgGeneralQueryReplyListener extends ControllerListener<PgGeneralQueryReplyDelegate>
  implements PgGeneralQueryReplyDelegate
{
  public void onPGGeneralQueryReply(final int paramInt1, final long paramLong, String paramString, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(PgGeneralQueryReplyDelegate paramAnonymousPgGeneralQueryReplyDelegate)
      {
        paramAnonymousPgGeneralQueryReplyDelegate.onPGGeneralQueryReply(paramInt1, paramLong, paramInt2, this.val$status);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PgGeneralQueryReplyListener
 * JD-Core Version:    0.6.2
 */