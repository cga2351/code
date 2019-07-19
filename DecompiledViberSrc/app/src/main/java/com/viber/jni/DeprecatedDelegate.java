package com.viber.jni;

import java.util.Map;

abstract interface DeprecatedDelegate
{
  @Deprecated
  public abstract void onGroupRemoveMembers(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String[] paramArrayOfString, Map<String, Integer> paramMap, int paramInt3, int paramInt4);

  @Deprecated
  public abstract boolean onPublicGroupChanged(long paramLong1, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, long paramLong2, long paramLong3, int paramInt4, String paramString3, GroupUserChanged[] paramArrayOfGroupUserChanged, int paramInt5, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, LocationInfo paramLocationInfo, String paramString7, String paramString8, int paramInt6, int paramInt7, PublicAccountAttributes paramPublicAccountAttributes, int paramInt8, String paramString9);

  @Deprecated
  public abstract void onPublicGroupInfo(int paramInt1, long paramLong, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, String paramString4, LocationInfo paramLocationInfo, String paramString5, String paramString6, String[] paramArrayOfString, PublicGroupUserInfo[] paramArrayOfPublicGroupUserInfo, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);

  @Deprecated
  public abstract void onRecoverGroupChats(GroupChatInfo[] paramArrayOfGroupChatInfo, int paramInt1, int paramInt2, boolean paramBoolean, Map<Long, Integer> paramMap);

  @Deprecated
  public abstract void onRecoverPublicAccounts(PublicAccountInfo[] paramArrayOfPublicAccountInfo1, PublicAccountInfo[] paramArrayOfPublicAccountInfo2, int paramInt1, int paramInt2, boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.DeprecatedDelegate
 * JD-Core Version:    0.6.2
 */