package com.viber.voip.messages.orm.entity.impl;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.voip.messages.extensions.model.c.a;
import com.viber.voip.messages.extensions.model.c.b;
import com.viber.voip.model.entity.ChatExtensionEntity;
import java.util.Iterator;
import java.util.Set;

public class ChatExtensionEntityHelper
{
  private static final int INDX_CHATEX_FLAGS_KEY = 12;
  private static final int INDX_CHATEX_ICON = 3;
  private static final int INDX_CHATEX_ICON_OLD = 4;
  private static final int INDX_CHATEX_ID = 0;
  private static final int INDX_CHATEX_NAME = 2;
  private static final int INDX_CHATEX_URI = 5;
  private static final int INDX_FEATURED = 10;
  private static final int INDX_FLAGS = 8;
  private static final int INDX_HEADER_TEXT = 6;
  private static final int INDX_LAST_USE_TIME = 9;
  private static final int INDX_ORDER_KEY = 11;
  private static final int INDX_PUBLIC_ACCOUNT_ID = 1;
  private static final int INDX_SEARCH_HINT = 7;
  public static final String[] PROJECTIONS = { "_id", "public_account_id", "name", "icon", "icon_old", "uri", "header_text", "search_hint", "flags", "last_use_time", "featured_index", "order_key", "chat_extension_flags" };

  public static ChatExtensionEntity createEntity(Cursor paramCursor)
  {
    return createEntity(paramCursor, 0);
  }

  public static ChatExtensionEntity createEntity(Cursor paramCursor, int paramInt)
  {
    ChatExtensionEntity localChatExtensionEntity = new ChatExtensionEntity();
    localChatExtensionEntity.setId(paramCursor.getLong(paramInt + 0));
    localChatExtensionEntity.setPublicAccountId(paramCursor.getString(paramInt + 1));
    localChatExtensionEntity.setName(paramCursor.getString(paramInt + 2));
    localChatExtensionEntity.setIcon(paramCursor.getString(paramInt + 3));
    localChatExtensionEntity.setIconOld(paramCursor.getString(paramInt + 4));
    localChatExtensionEntity.setUri(paramCursor.getString(paramInt + 5));
    localChatExtensionEntity.setHeaderText(paramCursor.getString(paramInt + 6));
    localChatExtensionEntity.setSearchHint(paramCursor.getString(paramInt + 7));
    localChatExtensionEntity.setFlags(paramCursor.getInt(paramInt + 8));
    localChatExtensionEntity.setLastUseTime(paramCursor.getLong(paramInt + 9));
    localChatExtensionEntity.setFeaturedIndex(paramCursor.getInt(paramInt + 10));
    localChatExtensionEntity.setOrderKey(paramCursor.getInt(paramInt + 11));
    localChatExtensionEntity.setChatExtensionFlags(paramCursor.getInt(paramInt + 12));
    return localChatExtensionEntity;
  }

  public static ContentValues getContentValues(c.b paramb, int paramInt)
  {
    ContentValues localContentValues = new ContentValues(10);
    localContentValues.put("public_account_id", paramb.a());
    localContentValues.put("name", paramb.c());
    localContentValues.put("icon", paramb.e());
    localContentValues.put("icon_old", paramb.f());
    localContentValues.put("uri", paramb.b());
    localContentValues.put("header_text", paramb.g());
    localContentValues.put("search_hint", paramb.d());
    localContentValues.put("flags", Integer.valueOf(paramb.h()));
    localContentValues.put("order_key", Integer.valueOf(paramInt));
    localContentValues.put("chat_extension_flags", Integer.valueOf(toChatExtensionFlags(paramb.i())));
    return localContentValues;
  }

  public static ContentValues getContentValues(ChatExtensionEntity paramChatExtensionEntity)
  {
    ContentValues localContentValues = new ContentValues(13);
    if (paramChatExtensionEntity.getId() > 0L)
      localContentValues.put("_id", Long.valueOf(paramChatExtensionEntity.getId()));
    localContentValues.put("public_account_id", paramChatExtensionEntity.getPublicAccountId());
    localContentValues.put("name", paramChatExtensionEntity.getName());
    localContentValues.put("icon", paramChatExtensionEntity.getIcon());
    localContentValues.put("icon_old", paramChatExtensionEntity.getIconOld());
    localContentValues.put("uri", paramChatExtensionEntity.getUri());
    localContentValues.put("header_text", paramChatExtensionEntity.getHeaderText());
    localContentValues.put("search_hint", paramChatExtensionEntity.getSearchHint());
    localContentValues.put("flags", Integer.valueOf(paramChatExtensionEntity.getFlags()));
    localContentValues.put("last_use_time", Long.valueOf(paramChatExtensionEntity.getLastUseTime()));
    localContentValues.put("featured_index", Integer.valueOf(paramChatExtensionEntity.getFeaturedIndex()));
    localContentValues.put("order_key", Integer.valueOf(paramChatExtensionEntity.getOrderKey()));
    localContentValues.put("chat_extension_flags", Integer.valueOf(paramChatExtensionEntity.getChatExtensionFlags()));
    return localContentValues;
  }

  private static int toChatExtensionFlags(Set<c.a> paramSet)
  {
    if (paramSet == null)
      return 0;
    Iterator localIterator = paramSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      if (locala != null)
        i |= locala.a();
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.impl.ChatExtensionEntityHelper
 * JD-Core Version:    0.6.2
 */