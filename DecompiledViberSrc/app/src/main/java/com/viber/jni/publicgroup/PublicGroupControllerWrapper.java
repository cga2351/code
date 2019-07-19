package com.viber.jni.publicgroup;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class PublicGroupControllerWrapper
  implements PublicGroupController
{
  private static final Logger L = ViberEnv.getLogger();
  private PublicGroupController mPublicGroupController;

  public PublicGroupControllerWrapper(PublicGroupController paramPublicGroupController)
  {
    this.mPublicGroupController = paramPublicGroupController;
  }

  public boolean handleGetPublicGroupMessages(int paramInt1, long paramLong, int paramInt2)
  {
    return this.mPublicGroupController.handleGetPublicGroupMessages(paramInt1, paramLong, paramInt2);
  }

  public boolean handleGroupAddMembers(long paramLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3)
  {
    return this.mPublicGroupController.handleGroupAddMembers(paramLong, paramInt1, paramArrayOfString, paramInt2, paramInt3);
  }

  public boolean handleJoinPublicGroup(long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    return this.mPublicGroupController.handleJoinPublicGroup(paramLong1, paramInt, paramString, paramLong2);
  }

  public boolean handleRefreshPublicAccountToken(int paramInt, String paramString)
  {
    return this.mPublicGroupController.handleRefreshPublicAccountToken(paramInt, paramString);
  }

  public boolean handleReportPublicGroupStatistics(long paramLong1, long paramLong2, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    return this.mPublicGroupController.handleReportPublicGroupStatistics(paramLong1, paramLong2, paramString1, paramBoolean, paramString2, paramString3);
  }

  public boolean handleSearchPublicAccountsByParams(int paramInt1, String paramString1, String paramString2, int paramInt2, Bundle paramBundle)
  {
    return this.mPublicGroupController.handleSearchPublicAccountsByParams(paramInt1, paramString1, paramString2, paramInt2, paramBundle);
  }

  public boolean handleSearchPublicGroupsForCountry(int paramInt1, String paramString, int paramInt2)
  {
    return this.mPublicGroupController.handleSearchPublicGroupsForCountry(paramInt1, paramString, paramInt2);
  }

  public boolean handleSendPublicGroupInvite(int paramInt1, String[] paramArrayOfString, long paramLong, int paramInt2)
  {
    return this.mPublicGroupController.handleSendPublicGroupInvite(paramInt1, paramArrayOfString, paramLong, paramInt2);
  }

  public boolean handleSendPublicGroupInviteToGroup(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    return this.mPublicGroupController.handleSendPublicGroupInviteToGroup(paramInt1, paramLong1, paramLong2, paramInt2);
  }

  public void handleSendPublicGroupsUpdatedAck(long paramLong)
  {
    this.mPublicGroupController.handleSendPublicGroupsUpdatedAck(paramLong);
  }

  public boolean handleValidatePublicGroupUri(int paramInt, String paramString)
  {
    return this.mPublicGroupController.handleValidatePublicGroupUri(paramInt, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicgroup.PublicGroupControllerWrapper
 * JD-Core Version:    0.6.2
 */