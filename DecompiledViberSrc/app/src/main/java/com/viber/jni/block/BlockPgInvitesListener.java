package com.viber.jni.block;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class BlockPgInvitesListener extends ControllerListener<BlockControllerDelegate.BlockPgInvites>
  implements BlockControllerDelegate.BlockPgInvites
{
  public void onBlockGroupInviteReply(final int paramInt1, final int paramInt2)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(BlockControllerDelegate.BlockPgInvites paramAnonymousBlockPgInvites)
      {
        paramAnonymousBlockPgInvites.onBlockGroupInviteReply(paramInt1, paramInt2);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.block.BlockPgInvitesListener
 * JD-Core Version:    0.6.2
 */