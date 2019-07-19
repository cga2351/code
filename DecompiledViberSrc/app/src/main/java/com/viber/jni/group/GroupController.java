package com.viber.jni.group;

import com.viber.jni.CategoryMap;
import com.viber.jni.LocationInfo;
import com.viber.jni.PublicAccountFieldValueMap;
import java.util.ArrayList;

public abstract interface GroupController
{
  public static final String CRM_ACTION = "action";
  public static final String CRM_ICON = "icon";
  public static final String CRM_NAME = "name";

  public abstract boolean handleChangePublicAccount(long paramLong1, String paramString1, long paramLong2, long paramLong3, String paramString2, String[] paramArrayOfString, LocationInfo paramLocationInfo, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt4);

  public abstract boolean handleCreatePublicAccount(int paramInt, String paramString1, LocationInfo paramLocationInfo, String paramString2, String paramString3, long paramLong1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString4, long paramLong2, boolean paramBoolean, String paramString5, String paramString6, String paramString7, String paramString8);

  public abstract boolean handleGetGroupInfo(int paramInt, long paramLong);

  public abstract String[] handleGetPublicAccountCategoryItem(String paramString1, String paramString2);

  public abstract boolean handleGetPublicAccountsMetaData(CategoryMap paramCategoryMap, ArrayList paramArrayList);

  public abstract boolean handleGroupAddMembers(long paramLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3);

  public abstract boolean handleGroupAssignRole(long paramLong, int paramInt1, String[] paramArrayOfString, int paramInt2);

  public abstract boolean handleGroupRemoveMembers(long paramLong, int paramInt, String[] paramArrayOfString);

  public abstract boolean handleRecoverGroupChats();

  public abstract boolean handleRecoverPublicAccounts();

  public abstract boolean handleValidatePublicAccountFields(int paramInt, PublicAccountFieldValueMap paramPublicAccountFieldValueMap);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.group.GroupController
 * JD-Core Version:    0.6.2
 */