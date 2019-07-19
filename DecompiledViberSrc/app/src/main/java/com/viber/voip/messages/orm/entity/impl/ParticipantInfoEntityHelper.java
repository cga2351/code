package com.viber.voip.messages.orm.entity.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.viber.voip.messages.orm.entity.EntityHelper;
import com.viber.voip.model.entity.m;
import org.sqlite.database.sqlite.SQLiteStatement;

public class ParticipantInfoEntityHelper
  implements EntityHelper<m>
{
  private static final int INDX_CONTACT_ID = 2;
  private static final int INDX_CONTACT_NAME = 4;
  private static final int INDX_DISPLAY_NAME = 8;
  private static final int INDX_ENCRYPTED_MEMBER_ID = 13;
  private static final int INDX_ENCRYPTED_NUMBER = 11;
  private static final int INDX_FLAGS = 14;
  private static final int INDX_HAS_PHOTO = 10;
  private static final int INDX_ID = 0;
  private static final int INDX_MEMBER_ID = 12;
  private static final int INDX_NATIVE_PHOTO_ID = 9;
  private static final int INDX_NUMBER = 1;
  private static final int INDX_PARTICIPANT_TYPE = 7;
  private static final int INDX_UPDATION_DATE = 15;
  private static final int INDX_VIBER_ID = 3;
  private static final int INDX_VIBER_IMAGE = 6;
  private static final int INDX_VIBER_NAME = 5;
  public static final String[] PROJECTIONS = { "_id", "number", "contact_id", "viber_id", "contact_name", "viber_name", "viber_image", "participant_type", "display_name", "native_photo_id", "has_photo", "encrypted_number", "member_id", "encrypted_member_id", "participant_info_flags", "up_date" };

  public static SQLiteStatement bindInsertStatmentValues(SQLiteStatement paramSQLiteStatement, m paramm)
  {
    long l = 0L;
    label36: label61: label77: label94: label111: String str1;
    label138: label151: String str2;
    if (paramm.getId() > l)
    {
      paramSQLiteStatement.bindLong(1, paramm.getId());
      if (paramm.getNumber() == null)
        break label279;
      paramSQLiteStatement.bindString(2, paramm.getNumber());
      paramSQLiteStatement.bindLong(3, paramm.i());
      if (paramm.c() == null)
        break label287;
      paramSQLiteStatement.bindString(4, paramm.c());
      if (paramm.getContactName() == null)
        break label295;
      paramSQLiteStatement.bindString(5, paramm.getContactName());
      if (paramm.getViberName() == null)
        break label303;
      paramSQLiteStatement.bindString(6, paramm.getViberName());
      if (paramm.e() == null)
        break label312;
      paramSQLiteStatement.bindString(7, paramm.e());
      paramSQLiteStatement.bindLong(8, paramm.g());
      if (!TextUtils.isEmpty(paramm.getContactName()))
        break label321;
      str1 = paramm.getViberName();
      if (str1 == null)
        break label330;
      paramSQLiteStatement.bindString(9, str1);
      paramSQLiteStatement.bindLong(10, paramm.l());
      if ((!TextUtils.isEmpty(paramm.e())) || (paramm.l() > l))
        l = 1L;
      paramSQLiteStatement.bindLong(11, l);
      if (!paramm.h())
        break label339;
      str2 = null;
      label199: if (str2 == null)
        break label348;
      paramSQLiteStatement.bindString(12, str2);
      label212: if (paramm.a() == null)
        break label357;
      paramSQLiteStatement.bindString(13, paramm.a());
      label229: String str3 = paramm.b();
      if (str3 == null)
        break label366;
      paramSQLiteStatement.bindString(14, str3);
    }
    while (true)
    {
      paramSQLiteStatement.bindLong(15, paramm.m());
      paramSQLiteStatement.bindLong(16, paramm.n());
      return paramSQLiteStatement;
      paramSQLiteStatement.bindNull(1);
      break;
      label279: paramSQLiteStatement.bindNull(2);
      break label36;
      label287: paramSQLiteStatement.bindNull(4);
      break label61;
      label295: paramSQLiteStatement.bindNull(5);
      break label77;
      label303: paramSQLiteStatement.bindNull(6);
      break label94;
      label312: paramSQLiteStatement.bindNull(7);
      break label111;
      label321: str1 = paramm.getContactName();
      break label138;
      label330: paramSQLiteStatement.bindNull(9);
      break label151;
      label339: str2 = paramm.d();
      break label199;
      label348: paramSQLiteStatement.bindNull(12);
      break label212;
      label357: paramSQLiteStatement.bindNull(13);
      break label229;
      label366: paramSQLiteStatement.bindNull(14);
    }
  }

  public static m createEntity(m paramm, Cursor paramCursor, int paramInt)
  {
    paramm.setId(paramCursor.getLong(paramInt + 0));
    paramm.c(paramCursor.getString(paramInt + 1));
    paramm.a(paramCursor.getLong(paramInt + 2));
    paramm.b(paramCursor.getString(paramInt + 3));
    paramm.h(paramCursor.getString(paramInt + 4));
    paramm.f(paramCursor.getString(paramInt + 5));
    paramm.g(paramCursor.getString(paramInt + 6));
    paramm.a(paramCursor.getInt(paramInt + 7));
    paramm.b(paramCursor.getLong(paramInt + 9));
    paramm.e(paramCursor.getString(paramInt + 11));
    paramm.d(paramCursor.getString(paramInt + 12));
    paramm.a(paramCursor.getString(paramInt + 13));
    paramm.b(paramCursor.getInt(paramInt + 14));
    paramm.c(paramCursor.getLong(paramInt + 15));
    return paramm;
  }

  public static ContentValues getContentValues(m paramm)
  {
    ContentValues localContentValues = new ContentValues(13);
    if (paramm.getId() > 0L)
      localContentValues.put("_id", Long.valueOf(paramm.getId()));
    localContentValues.put("number", paramm.getNumber());
    localContentValues.put("contact_id", Long.valueOf(paramm.i()));
    localContentValues.put("viber_id", paramm.c());
    localContentValues.put("contact_name", paramm.getContactName());
    localContentValues.put("viber_name", paramm.getViberName());
    localContentValues.put("viber_image", paramm.e());
    localContentValues.put("participant_type", Integer.valueOf(paramm.g()));
    String str;
    if (TextUtils.isEmpty(paramm.getContactName()))
    {
      str = paramm.getViberName();
      localContentValues.put("display_name", str);
      localContentValues.put("native_photo_id", Long.valueOf(paramm.l()));
      if ((TextUtils.isEmpty(paramm.e())) && (paramm.l() <= 0L))
        break label247;
    }
    label247: for (int i = 1; ; i = 0)
    {
      localContentValues.put("has_photo", Integer.valueOf(i));
      if (!paramm.h())
        localContentValues.put("encrypted_number", paramm.d());
      localContentValues.put("member_id", paramm.a());
      localContentValues.put("encrypted_member_id", paramm.b());
      localContentValues.put("participant_info_flags", Integer.valueOf(paramm.m()));
      localContentValues.put("up_date", Long.valueOf(paramm.n()));
      return localContentValues;
      str = paramm.getContactName();
      break;
    }
  }

  public m createEntity(Cursor paramCursor)
  {
    return createEntity(paramCursor, 0);
  }

  public m createEntity(Cursor paramCursor, int paramInt)
  {
    return createEntity(new m(), paramCursor, paramInt);
  }

  public String[] getProjections()
  {
    return PROJECTIONS;
  }

  public String getTable()
  {
    return "participants_info";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.impl.ParticipantInfoEntityHelper
 * JD-Core Version:    0.6.2
 */