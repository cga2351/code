package com.viber.jni.memberid;

public abstract interface UsersMemberIdsMigrationDelegate
{
  public abstract void onEnableMidMapping(boolean paramBoolean);

  public abstract void onGetUserMemberIDsReply(PhoneNumberToMidInfo[] paramArrayOfPhoneNumberToMidInfo, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);

  public abstract void onStartClientMigrateToMid();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.memberid.UsersMemberIdsMigrationDelegate
 * JD-Core Version:    0.6.2
 */