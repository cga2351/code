package com.viber.jni.memberid;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.ConnectedCaller;
import com.viber.voip.ViberEnv;

public class MemberIdMigrationWrapper extends ConnectedCaller
  implements MemberIdMigrationController
{
  private static final Logger L = ViberEnv.getLogger();
  private final MemberIdMigrationController mMemberIdMigrationController;

  public MemberIdMigrationWrapper(Engine paramEngine, MemberIdMigrationController paramMemberIdMigrationController)
  {
    super(paramEngine);
    this.mMemberIdMigrationController = paramMemberIdMigrationController;
  }

  public boolean handleDoneClientMigrationToMid()
  {
    this.mMemberIdMigrationController.handleDoneClientMigrationToMid();
    return true;
  }

  public boolean handleDoneMidMapping()
  {
    runOnConnect(new Runnable()
    {
      public void run()
      {
        MemberIdMigrationWrapper.this.mMemberIdMigrationController.handleDoneMidMapping();
      }
    });
    return true;
  }

  public boolean handleGetUserMemberIDs(final String[] paramArrayOfString, final int paramInt)
  {
    runOnConnect(paramInt, new Runnable()
    {
      public void run()
      {
        MemberIdMigrationWrapper.this.mMemberIdMigrationController.handleGetUserMemberIDs(paramArrayOfString, paramInt);
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.memberid.MemberIdMigrationWrapper
 * JD-Core Version:    0.6.2
 */