package com.viber.jni.memberid;

import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.ControllerListener.ControllerListenerAction;

public class UsersMembersIdsMigrationListener extends ControllerListener<UsersMemberIdsMigrationDelegate>
  implements UsersMemberIdsMigrationDelegate
{
  public void onEnableMidMapping(final boolean paramBoolean)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(UsersMemberIdsMigrationDelegate paramAnonymousUsersMemberIdsMigrationDelegate)
      {
        paramAnonymousUsersMemberIdsMigrationDelegate.onEnableMidMapping(paramBoolean);
      }
    });
  }

  public void onGetUserMemberIDsReply(final PhoneNumberToMidInfo[] paramArrayOfPhoneNumberToMidInfo, final int paramInt1, final int paramInt2, final boolean paramBoolean, final int paramInt3)
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(UsersMemberIdsMigrationDelegate paramAnonymousUsersMemberIdsMigrationDelegate)
      {
        paramAnonymousUsersMemberIdsMigrationDelegate.onGetUserMemberIDsReply(paramArrayOfPhoneNumberToMidInfo, paramInt1, paramInt2, paramBoolean, paramInt3);
      }
    });
  }

  public void onStartClientMigrateToMid()
  {
    notifyListeners(new ControllerListener.ControllerListenerAction()
    {
      public void execute(UsersMemberIdsMigrationDelegate paramAnonymousUsersMemberIdsMigrationDelegate)
      {
        paramAnonymousUsersMemberIdsMigrationDelegate.onStartClientMigrateToMid();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.memberid.UsersMembersIdsMigrationListener
 * JD-Core Version:    0.6.2
 */