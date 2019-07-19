package com.viber.jni.group;

import com.viber.jni.GroupUserChanged;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class GroupInfoListener extends ControllerListener<GroupControllerDelegate.GroupInfo>
  implements GroupControllerDelegate.GroupInfo
{
  public void onGroupInfo(final int paramInt1, final long paramLong, String paramString1, final String paramString2, final GroupUserChanged[] paramArrayOfGroupUserChanged, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, final String paramString3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(GroupControllerDelegate.GroupInfo paramAnonymousGroupInfo)
      {
        paramAnonymousGroupInfo.onGroupInfo(paramInt1, paramLong, paramString2, paramArrayOfGroupUserChanged, paramInt2, paramInt3, paramInt4, paramInt5, paramString3, this.val$inviteLinkData);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.group.GroupInfoListener
 * JD-Core Version:    0.6.2
 */