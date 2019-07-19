package com.viber.jni.secure;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class QueryDestOperationSupportListener extends ControllerListener<QueryDestOperationSupportDelegate>
  implements QueryDestOperationSupportDelegate
{
  public void onQueryDestOperationSupportReplyMsg(final int paramInt1, final byte[] paramArrayOfByte, final int paramInt2, final int paramInt3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(QueryDestOperationSupportDelegate paramAnonymousQueryDestOperationSupportDelegate)
      {
        paramAnonymousQueryDestOperationSupportDelegate.onQueryDestOperationSupportReplyMsg(paramInt1, paramArrayOfByte, paramInt2, paramInt3);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.secure.QueryDestOperationSupportListener
 * JD-Core Version:    0.6.2
 */