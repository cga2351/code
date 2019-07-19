package com.viber.voip.messages.controller.manager;

import android.database.Cursor;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity.a;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.s.a;
import java.util.ArrayList;
import java.util.Collection;

public class ag extends aa
  implements af
{
  public static final String[] g = a(RegularConversationLoaderEntity.PROJECTIONS);
  private static final Logger h = ViberEnv.getLogger();
  private static final String i = 400 + "conversations" + " LEFT OUTER JOIN messages ON (messages._id=(SELECT messages._id FROM messages WHERE messages.conversation_id=conversations._id AND messages.deleted=0 AND messages.extra_mime<>1007 AND messages.status<>12 AND messages.extra_flags&4194304=0 AND (messages.flag&131072=0 OR send_type=0) ORDER BY messages.order_key DESC, messages.msg_date DESC LIMIT 1))" + " LEFT OUTER JOIN participants ON (conversations._id=participants.conversation_id)" + " LEFT OUTER JOIN participants_info ON (participants.participant_info_id=participants_info._id) " + " LEFT OUTER JOIN public_accounts ON (public_accounts.group_id=conversations.group_id)";
  private static final String j = 1550 + "SELECT " + a.d(g) + " FROM " + i + " WHERE " + "conversations.deleted=0 AND (conversations.conversation_type=1 OR conversations.conversation_type=5 OR conversations.conversation_type=0)" + " AND " + "conversations.flags & (1 << 0) = 0" + " AND " + "conversations.flags & 32768<>0" + " AND " + "(conversations.conversation_type <> 0 OR participants_info.participant_info_flags & 2 = 0)" + " AND " + "participants_info.participant_type<>0" + " GROUP BY " + "conversations._id" + " ORDER BY " + "messages.order_key DESC, messages.msg_date DESC";
  private static final String k = 1550 + "SELECT " + a.d(g) + " FROM " + i + " WHERE " + "conversations.flags & (1 << 0) = 0" + " AND " + "conversations.flags & 32768=0" + " AND " + "conversations.conversation_type=4" + " AND " + " (%s) " + " GROUP BY " + "conversations._id";
  private static final String l = 1550 + "SELECT " + a.d(g) + " FROM " + i + " WHERE " + " %s " + " AND " + "conversations.deleted=0" + " AND " + "(conversations.flags & (1 << 0) = 0 OR conversations.flags & 8192 != 0)" + " AND " + "conversations.conversation_type=0 AND messages._id>0" + " AND " + "participants_info.participant_info_flags & 2 = 0" + " AND " + "participants_info.participant_type=1" + " AND (" + "messages._id>0" + " OR " + "conversations._id IN(%s)" + ") AND (" + "(participants_info.display_name IS NOT NULL AND participants_info.display_name LIKE ?)" + " OR " + "participants_info.number LIKE ?" + ") GROUP BY " + "conversations._id" + " ORDER BY " + "participants_info.display_name" + " COLLATE LOCALIZED ASC, " + "participants_info.number" + " COLLATE LOCALIZED ASC";
  private static final String m = 3555 + "SELECT " + a.d(g) + "," + " MAX(messages.order_key)" + "," + " (messages.msg_date)  AS message_date" + " FROM messages" + " LEFT OUTER JOIN conversations ON (messages.conversation_id=conversations._id)" + " LEFT OUTER JOIN participants ON (messages.participant_id=participants._id)" + " LEFT OUTER JOIN participants_info ON ((CASE WHEN (conversations.conversation_type=0) THEN conversations.participant_id_1 ELSE participants.participant_info_id END)=participants_info._id)" + " LEFT OUTER JOIN public_accounts ON (public_accounts.group_id=conversations.group_id)" + " WHERE " + "conversations.deleted=0 AND (conversations.conversation_type=1 OR conversations.conversation_type=5 OR (conversations.conversation_type=0 AND messages._id>0) OR conversations.conversation_type=4)" + " AND " + "conversations.flags & (1 << 0) = 0" + " AND " + "conversations.flags & 32768=0" + " AND " + "conversations.conversation_type<>2" + " AND " + ab.h + " AND " + "(messages.flag&131072=0 OR send_type=0)" + " AND " + c + " AND " + "(conversations.conversation_type <> 0 OR participants_info.participant_info_flags & 2 = 0)" + " GROUP BY " + "messages.conversation_id" + " ORDER BY " + "messages.order_key DESC, messages.msg_date DESC";

  private static final String a(y paramy)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramy.d())
      localArrayList.add("conversations.conversation_type=5");
    if (paramy.e())
      localArrayList.add("conversations.conversation_type=1");
    return 1550 + "SELECT " + a.d(RegularConversationLoaderEntity.PROJECTIONS) + " FROM " + i + " WHERE " + "conversations.deleted=0" + " AND " + "conversations.flags & (1 << 0) = 0" + " AND " + "conversations.flags & 32768=0" + " AND (" + a.f(localArrayList) + ") AND " + " (%s) " + " GROUP BY " + "conversations._id";
  }

  private String a(String paramString1, String paramString2)
  {
    return paramString1.replace("conversations.name", String.format("(CASE WHEN conversations.name IS NULL OR conversations.name='' THEN '%s' ELSE conversations.name END)", new Object[] { paramString2 }));
  }

  private Collection<ConversationLoaderEntity> a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, ConversationLoaderEntity.a parama)
  {
    Object[] arrayOfObject = new Object[1];
    String str1;
    if (paramBoolean)
      str1 = "conversations.name LIKE ? OR conversations.name = ''";
    while (true)
    {
      arrayOfObject[0] = str1;
      String str2 = a(String.format(paramString1, arrayOfObject), paramString4);
      String str3 = " ORDER BY " + String.format("(CASE WHEN conversations.name IS NULL OR conversations.name='' THEN '%s' ELSE conversations.name END)", new Object[] { paramString4 }) + " COLLATE LOCALIZED ASC";
      String str4 = str2 + str3;
      String[] arrayOfString = { paramString3 };
      ArrayList localArrayList = new ArrayList();
      b localb = f();
      Cursor localCursor = null;
      try
      {
        localCursor = localb.a(str4, arrayOfString);
        label151: RegularConversationLoaderEntity localRegularConversationLoaderEntity;
        ConversationLoaderEntity localConversationLoaderEntity;
        if ((localCursor != null) && (localCursor.moveToFirst()))
        {
          localRegularConversationLoaderEntity = new RegularConversationLoaderEntity(localCursor, true);
          int n = localArrayList.size();
          if (n == 0)
            localRegularConversationLoaderEntity.setSearchSection(parama);
          if (n <= 0)
            break label279;
          localConversationLoaderEntity = (ConversationLoaderEntity)localArrayList.get(-1 + localArrayList.size());
          label204: if ((localConversationLoaderEntity == null) || (localConversationLoaderEntity.getId() != localRegularConversationLoaderEntity.getId()))
            break label285;
          localRegularConversationLoaderEntity.setSearchSection(localConversationLoaderEntity.getSearchSection());
          localArrayList.set(localArrayList.indexOf(localConversationLoaderEntity), localRegularConversationLoaderEntity);
        }
        while (true)
        {
          boolean bool = localCursor.moveToNext();
          if (bool)
            break label151;
          return localArrayList;
          str1 = "conversations.name LIKE ?";
          break;
          label279: localConversationLoaderEntity = null;
          break label204;
          label285: if ((localRegularConversationLoaderEntity.getParticipantName().toLowerCase().contains(paramString2.toLowerCase())) || (!TextUtils.isEmpty(localRegularConversationLoaderEntity.getGroupName())) || (paramBoolean))
            localArrayList.add(localRegularConversationLoaderEntity);
        }
      }
      finally
      {
        a(localCursor);
      }
    }
  }

  private Collection<ConversationLoaderEntity> a(String paramString, String[] paramArrayOfString, ConversationLoaderEntity.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = null;
    try
    {
      localCursor = f().a(paramString, paramArrayOfString);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          RegularConversationLoaderEntity localRegularConversationLoaderEntity = new RegularConversationLoaderEntity(localCursor, true);
          if (localArrayList.size() == 0)
            localRegularConversationLoaderEntity.setSearchSection(parama);
          localArrayList.add(localRegularConversationLoaderEntity);
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localArrayList;
    }
    finally
    {
      a(localCursor);
    }
  }

  public static String[] a(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[1 + paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[41] = "IFNULL((SELECT SUM ([messages].[unread]) FROM messages WHERE messages.conversation_id = conversations._id AND messages.unread>0 AND messages.extra_mime <> 1007 AND [messages].[extra_flags] & 4194304 = 0 AND messages.extra_mime <> 1008 AND messages.extra_mime <> 1002 AND messages.deleted=0 ), 0)";
    arrayOfString[42] = "conversations._id";
    arrayOfString[43] = "conversations._id";
    arrayOfString[44] = "conversations._id";
    arrayOfString[45] = "conversations._id";
    arrayOfString[46] = "conversations._id";
    arrayOfString[47] = "conversations._id";
    arrayOfString[49] = "conversations._id";
    arrayOfString[50] = "conversations._id";
    arrayOfString[51] = "messages.description";
    return arrayOfString;
  }

  public ArrayList<ConversationLoaderEntity> a(y paramy, af.a parama)
  {
    if ((paramy == null) || (TextUtils.isEmpty(paramy.a())))
      return new ArrayList(0);
    String str1 = paramy.a().trim();
    String str2 = '%' + str1.replace("=", "==").replace("%", "=%") + '%';
    ArrayList localArrayList = new ArrayList();
    int n;
    String str6;
    label151: int i1;
    if (af.a.c == parama)
    {
      n = 1;
      if (paramy.g())
      {
        if (n != 0)
          localArrayList.addAll(a(j, null, ConversationLoaderEntity.a.b));
        String str5 = l;
        Object[] arrayOfObject = new Object[2];
        if ((af.a.a != parama) && (n == 0))
          break label364;
        str6 = "conversations.flags & 294912=0";
        arrayOfObject[0] = str6;
        arrayOfObject[1] = paramy.l();
        localArrayList.addAll(a(String.format(str5, arrayOfObject), new String[] { str2, str2 }, ConversationLoaderEntity.a.c));
      }
      if ((n != 0) || (!paramy.p()))
        break label386;
      Collection localCollection = a(k, str1, str2, paramy.j(), paramy.q(), ConversationLoaderEntity.a.d);
      if (localCollection.isEmpty())
        break label372;
      i1 = 1;
      label247: localArrayList.addAll(localCollection);
    }
    while (true)
    {
      String str3;
      boolean bool;
      String str4;
      if ((paramy.d()) || (paramy.e()))
      {
        str3 = a(paramy);
        bool = paramy.i();
        str4 = paramy.k();
        if (i1 == 0)
          break label378;
      }
      label364: label372: label378: for (ConversationLoaderEntity.a locala = ConversationLoaderEntity.a.a; ; locala = ConversationLoaderEntity.a.e)
      {
        localArrayList.addAll(a(str3, str1, str2, bool, str4, locala));
        if (paramy.b())
          localArrayList.addAll(a(m, new String[] { str2, str2 }, ConversationLoaderEntity.a.f));
        return localArrayList;
        n = 0;
        break;
        str6 = "1";
        break label151;
        i1 = 0;
        break label247;
      }
      label386: i1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.ag
 * JD-Core Version:    0.6.2
 */