package com.viber.jni.memberid;

public abstract interface MemberIdMigrationController
{
  public abstract boolean handleDoneClientMigrationToMid();

  public abstract boolean handleDoneMidMapping();

  public abstract boolean handleGetUserMemberIDs(String[] paramArrayOfString, int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.memberid.MemberIdMigrationController
 * JD-Core Version:    0.6.2
 */