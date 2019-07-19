package com.viber.jni.publicgroup;

import android.os.Bundle;

public abstract interface PublicGroupController
{
  public abstract boolean handleGetPublicGroupMessages(int paramInt1, long paramLong, int paramInt2);

  public abstract boolean handleGroupAddMembers(long paramLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3);

  public abstract boolean handleJoinPublicGroup(long paramLong1, int paramInt, String paramString, long paramLong2);

  public abstract boolean handleRefreshPublicAccountToken(int paramInt, String paramString);

  public abstract boolean handleReportPublicGroupStatistics(long paramLong1, long paramLong2, String paramString1, boolean paramBoolean, String paramString2, String paramString3);

  public abstract boolean handleSearchPublicAccountsByParams(int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle);

  public abstract boolean handleSearchPublicGroupsForCountry(int paramInt1, String paramString, int paramInt2);

  public abstract boolean handleSendPublicGroupInvite(int paramInt1, String[] paramArrayOfString, long paramLong, int paramInt2);

  public abstract boolean handleSendPublicGroupInviteToGroup(int paramInt1, long paramLong1, long paramLong2, int paramInt2);

  public abstract void handleSendPublicGroupsUpdatedAck(long paramLong);

  public abstract boolean handleValidatePublicGroupUri(int paramInt, String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicgroup.PublicGroupController
 * JD-Core Version:    0.6.2
 */