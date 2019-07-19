package com.viber.voip.messages.orm.entity.impl;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.jni.LocationInfo;
import com.viber.voip.messages.orm.entity.EntityHelper;
import com.viber.voip.model.entity.r;
import com.viber.voip.publicaccount.entity.CrmItem;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.Background;
import com.viber.voip.publicaccount.entity.PublicAccount.GlobalPermissions;

public class PublicAccountEntityHelper
  implements EntityHelper<r>
{
  protected static final int INDX_AUTH_TOKEN = 31;
  protected static final int INDX_BACKGROUND_ID = 4;
  protected static final int INDX_CATEGORY_ID = 32;
  protected static final int INDX_CHAT_BACKGROUND = 39;
  protected static final int INDX_COMMUNITY_PRIVILEGES = 38;
  protected static final int INDX_COUNTRY = 7;
  protected static final int INDX_CRM = 34;
  protected static final int INDX_CUSTOM_CHAT_BACKGROUND = 40;
  protected static final int INDX_EMAIL = 30;
  protected static final int INDX_EXTRA_FLAGS = 26;
  protected static final int INDX_EXTRA_INFO = 37;
  protected static final int INDX_GROUP_ENTER_COUNT = 25;
  protected static final int INDX_GROUP_ID = 1;
  protected static final int INDX_GROUP_URI = 2;
  protected static final int INDX_ID = 0;
  protected static final int INDX_INVITATION_TOKEN = 18;
  protected static final int INDX_INVITER = 17;
  protected static final int INDX_LAST_MEDIA_TYPE = 19;
  protected static final int INDX_LAST_MESSAGE_ID = 14;
  protected static final int INDX_LAST_MSG_TEXT = 20;
  protected static final int INDX_LAST_READ_MESSAGE_ID = 24;
  protected static final int INDX_LOCATION_ADDRESS = 8;
  protected static final int INDX_LOCATION_LAT = 5;
  protected static final int INDX_LOCATION_LNG = 6;
  protected static final int INDX_MY_SETTINGS = 41;
  protected static final int INDX_PUBLIC_ACCOUNT_ID = 27;
  protected static final int INDX_REVISION = 3;
  protected static final int INDX_SENDER_NAME = 22;
  protected static final int INDX_SENDER_PHONE = 21;
  protected static final int INDX_SENDER_PHOTO_ID = 23;
  protected static final int INDX_SERVER_LAST_MESSAGE_ID = 15;
  protected static final int INDX_SUBCATEGORY_ID = 33;
  protected static final int INDX_SUBSCRIBERS_COUNT = 35;
  protected static final int INDX_SUBSCRIPTION = 36;
  protected static final int INDX_TAGS = 12;
  protected static final int INDX_TAG_LINE = 13;
  protected static final int INDX_VERIFIED = 16;
  protected static final int INDX_WATCHERS_COUNT = 9;
  protected static final int INDX_WATCHERS_COUNT_REF = 10;
  protected static final int INDX_WATCHERS_COUNT_REF_DATE = 11;
  protected static final int INDX_WEBHOOK = 28;
  protected static final int INDX_WEBSITE = 29;
  public static final String[] PROJECTIONS = { "_id", "group_id", "group_uri", "revision", "background_id", "location_lat", "location_lng", "country", "location_address", "watchers_count", "watchers_count_ref", "watchers_count_ref_date", "tags", "tag_line", "local_message_id", "server_message_id", "verified", "inviter", "invitation_token", "last_media_type", "last_msg_text", "sender_phone", "sender_name", "sender_photo_id", "last_read_message_id", "group_enter_count", "pg_extra_flags", "public_account_id", "webhook_exists", "website", "email", "auth_token", "category_id", "subcategory_id", "crm", "subscribers_count", "subscription_status", "extra_info", "community_privileges", "chat_background", "custom_chat_background", "my_settings" };

  public static r createEntity(r paramr, Cursor paramCursor, int paramInt)
  {
    paramr.setId(paramCursor.getLong(paramInt + 0));
    paramr.a(paramCursor.getLong(paramInt + 1));
    paramr.b(paramCursor.getString(paramInt + 2));
    paramr.b(paramCursor.getInt(paramInt + 3));
    paramr.c(paramCursor.getString(paramInt + 4));
    paramr.c(paramCursor.getInt(paramInt + 5));
    paramr.d(paramCursor.getInt(paramInt + 6));
    paramr.d(paramCursor.getString(paramInt + 7));
    paramr.j(paramCursor.getString(paramInt + 8));
    paramr.e(paramCursor.getInt(paramInt + 9));
    paramr.f(paramCursor.getInt(paramInt + 10));
    paramr.b(paramCursor.getLong(paramInt + 11));
    paramr.g(paramCursor.getString(paramInt + 12));
    paramr.i(paramCursor.getString(paramInt + 13));
    paramr.j(paramCursor.getInt(paramInt + 14));
    paramr.h(paramCursor.getInt(paramInt + 15));
    paramr.k(paramCursor.getInt(paramInt + 16));
    paramr.k(paramCursor.getString(paramInt + 17));
    paramr.c(paramCursor.getLong(paramInt + 18));
    paramr.p(paramCursor.getString(paramInt + 19));
    paramr.l(paramCursor.getString(paramInt + 20));
    paramr.m(paramCursor.getString(paramInt + 21));
    paramr.n(paramCursor.getString(paramInt + 22));
    paramr.o(paramCursor.getString(paramInt + 23));
    paramr.n(paramCursor.getInt(paramInt + 24));
    paramr.g(paramCursor.getInt(paramInt + 25));
    paramr.l(paramCursor.getInt(paramInt + 26));
    paramr.a(paramCursor.getString(paramInt + 27));
    paramr.a(paramCursor.getInt(paramInt + 28));
    paramr.q(paramCursor.getString(paramInt + 29));
    paramr.r(paramCursor.getString(paramInt + 30));
    paramr.f(paramCursor.getString(paramInt + 31));
    paramr.s(paramCursor.getString(paramInt + 32));
    paramr.t(paramCursor.getString(paramInt + 33));
    paramr.e(paramCursor.getString(paramInt + 34));
    paramr.o(paramCursor.getInt(paramInt + 35));
    paramr.i(paramCursor.getInt(paramInt + 36));
    paramr.u(paramCursor.getString(paramInt + 37));
    paramr.d(paramCursor.getLong(paramInt + 38));
    paramr.v(paramCursor.getString(paramInt + 39));
    paramr.w(paramCursor.getString(paramInt + 40));
    paramr.x(paramCursor.getString(paramInt + 41));
    return paramr;
  }

  public static r createEntity(r paramr, PublicAccount paramPublicAccount)
  {
    int i = 1;
    paramr.a(paramPublicAccount.getGroupID());
    paramr.b(paramPublicAccount.getGroupUri());
    paramr.b(paramPublicAccount.getRevision());
    paramr.c(paramPublicAccount.getBackground().getId());
    LocationInfo localLocationInfo = paramPublicAccount.getLocation();
    if ((localLocationInfo != null) && (!new LocationInfo(paramr.h(), paramr.i()).equals(localLocationInfo)))
    {
      paramr.c(localLocationInfo.getNativeLatitude());
      paramr.d(localLocationInfo.getNativeLongitude());
      paramr.j(paramPublicAccount.getAdressString());
    }
    if (paramPublicAccount.getWatchersCount() != -1)
      paramr.e(paramPublicAccount.getWatchersCount());
    if (paramPublicAccount.getLastMessageId() != 0)
      paramr.h(paramPublicAccount.getLastMessageId());
    paramr.d(paramPublicAccount.getCountryCode());
    paramr.a(paramPublicAccount.getTags());
    paramr.i(paramPublicAccount.getTagLines());
    paramr.k(paramPublicAccount.getFlags());
    paramr.c(paramPublicAccount.isDisplayInvitationLink());
    paramr.a(paramPublicAccount.getPublicAccountId());
    int j;
    String str1;
    label239: String str2;
    label260: label276: String str3;
    if (paramPublicAccount.isWebhookExists())
    {
      j = i;
      paramr.a(j);
      paramr.q(paramPublicAccount.getWebsite());
      paramr.r(paramPublicAccount.getEmail());
      paramr.f(paramPublicAccount.getAuthToken());
      paramr.s(paramPublicAccount.getCategoryId());
      paramr.t(paramPublicAccount.getSubCategoryId());
      if (paramPublicAccount.getCrm() != null)
        break label326;
      str1 = "";
      paramr.e(str1);
      paramr.o(paramPublicAccount.getSubscribersCount());
      if (!paramPublicAccount.hasSubscription())
        break label338;
      paramr.i(i);
      str2 = paramPublicAccount.getExtraInfoJson();
      if (str2 == null)
        break label343;
      paramr.u(str2);
      paramr.d(paramPublicAccount.getGlobalPermissions().getRawPrivileges());
      paramr.v(paramPublicAccount.getChatBackground());
      str3 = paramPublicAccount.getMySettingsJson();
      if (str3 == null)
        break label351;
    }
    while (true)
    {
      paramr.x(str3);
      return paramr;
      j = 0;
      break;
      label326: str1 = paramPublicAccount.getCrm().getName();
      break label239;
      label338: i = 0;
      break label260;
      label343: str2 = "";
      break label276;
      label351: str3 = "";
    }
  }

  public static ContentValues getContentValues(r paramr)
  {
    ContentValues localContentValues = new ContentValues(37);
    if (paramr.getId() > 0L)
      localContentValues.put("_id", Long.valueOf(paramr.getId()));
    localContentValues.put("group_id", Long.valueOf(paramr.a()));
    localContentValues.put("group_uri", paramr.d());
    localContentValues.put("revision", Integer.valueOf(paramr.e()));
    localContentValues.put("background_id", paramr.f());
    localContentValues.put("location_lat", Integer.valueOf(paramr.h()));
    localContentValues.put("location_lng", Integer.valueOf(paramr.i()));
    localContentValues.put("country", paramr.g());
    localContentValues.put("location_address", paramr.w());
    localContentValues.put("watchers_count", Integer.valueOf(paramr.j()));
    localContentValues.put("watchers_count_ref", Integer.valueOf(paramr.k()));
    localContentValues.put("watchers_count_ref_date", Long.valueOf(paramr.l()));
    localContentValues.put("tags", paramr.s());
    localContentValues.put("tag_line", paramr.u());
    localContentValues.put("local_message_id", Integer.valueOf(paramr.v()));
    localContentValues.put("server_message_id", Integer.valueOf(paramr.n()));
    localContentValues.put("verified", Integer.valueOf(paramr.x()));
    localContentValues.put("inviter", paramr.D());
    localContentValues.put("invitation_token", Long.valueOf(paramr.E()));
    localContentValues.put("last_media_type", Integer.valueOf(paramr.J()));
    localContentValues.put("last_msg_text", paramr.F());
    localContentValues.put("sender_phone", paramr.G());
    localContentValues.put("sender_name", paramr.H());
    localContentValues.put("sender_photo_id", paramr.I());
    localContentValues.put("last_read_message_id", Integer.valueOf(paramr.K()));
    localContentValues.put("group_enter_count", Integer.valueOf(paramr.m()));
    localContentValues.put("pg_extra_flags", Integer.valueOf(paramr.A()));
    localContentValues.put("public_account_id", paramr.b());
    localContentValues.put("webhook_exists", Integer.valueOf(paramr.L()));
    localContentValues.put("website", paramr.M());
    localContentValues.put("email", paramr.N());
    localContentValues.put("auth_token", paramr.o());
    localContentValues.put("category_id", paramr.P());
    localContentValues.put("subcategory_id", paramr.Q());
    localContentValues.put("crm", paramr.p());
    localContentValues.put("subscribers_count", Integer.valueOf(paramr.O()));
    localContentValues.put("subscription_status", Integer.valueOf(paramr.q()));
    localContentValues.put("extra_info", paramr.R());
    localContentValues.put("community_privileges", Long.valueOf(paramr.T()));
    localContentValues.put("chat_background", paramr.U());
    localContentValues.put("custom_chat_background", paramr.V());
    localContentValues.put("my_settings", paramr.W());
    return localContentValues;
  }

  public r createEntity(Cursor paramCursor)
  {
    return createEntity(paramCursor, 0);
  }

  public r createEntity(Cursor paramCursor, int paramInt)
  {
    return createEntity(new r(), paramCursor, paramInt);
  }

  public String[] getProjections()
  {
    return PROJECTIONS;
  }

  public String getTable()
  {
    return "public_accounts";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.impl.PublicAccountEntityHelper
 * JD-Core Version:    0.6.2
 */