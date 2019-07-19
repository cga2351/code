package com.viber.jni.group;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import java.util.Map;

public class GroupCreateListener extends ControllerListener<GroupControllerDelegate.GroupCreate>
  implements GroupControllerDelegate.GroupCreate
{
  public void onCreateGroupReply(final int paramInt1, final int paramInt2, final long paramLong, Map<String, Integer> paramMap)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(GroupControllerDelegate.GroupCreate paramAnonymousGroupCreate)
      {
        paramAnonymousGroupCreate.onCreateGroupReply(paramInt1, paramInt2, paramLong, this.val$notFoundMembers);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.group.GroupCreateListener
 * JD-Core Version:    0.6.2
 */