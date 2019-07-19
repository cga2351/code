package com.viber.jni.group;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;
import java.util.Map;

public class GroupAssignRoleListener extends ControllerListener<GroupControllerDelegate.AssignRole>
  implements GroupControllerDelegate.AssignRole
{
  public void onGroupAssignRole(final long paramLong1, int paramInt1, final long paramLong2, final int paramInt2, int paramInt3, final String[] paramArrayOfString, final Map<String, Integer> paramMap, final int paramInt4, final int paramInt5)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(GroupControllerDelegate.AssignRole paramAnonymousAssignRole)
      {
        paramAnonymousAssignRole.onGroupAssignRole(paramLong1, paramLong2, paramInt2, paramArrayOfString, paramMap, paramInt4, paramInt5, this.val$status, this.val$revision);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.group.GroupAssignRoleListener
 * JD-Core Version:    0.6.2
 */