package com.viber.voip.messages.controller.manager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.contacts.d.d;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.ConversationLoaderEntity.a;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.util.d.f;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ad extends aa
  implements af
{
  private final c g;
  private final d h;
  private final b i;
  private final a j;
  private final com.viber.voip.contacts.d.a k;
  private final ContentResolver l;

  protected ad(c paramc, d paramd, b paramb, a parama, com.viber.voip.contacts.d.a parama1, ContentResolver paramContentResolver)
  {
    this.g = paramc;
    this.h = paramd;
    this.i = paramb;
    this.j = parama;
    this.k = parama1;
    this.l = paramContentResolver;
  }

  private int a(ConversationLoaderEntity paramConversationLoaderEntity, String paramString)
  {
    int m;
    int n;
    String str;
    if (!paramConversationLoaderEntity.isPublicGroupType())
    {
      m = 10;
      n = m * (1 + paramConversationLoaderEntity.getConversationType());
      if (paramConversationLoaderEntity.isGroupBehavior())
        break label70;
      str = paramConversationLoaderEntity.getContactName();
      label33: if ((str == null) || (!str.toLowerCase().contains(paramString)))
        break label79;
    }
    label70: label79: for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
        break label85;
      return m * 10;
      m = 1000;
      break;
      str = paramConversationLoaderEntity.getGroupName();
      break label33;
    }
    label85: return n;
  }

  public static ad a(ContentResolver paramContentResolver)
  {
    return new ad(new c(), new d(), new b(), new f(null), new d(), paramContentResolver);
  }

  private String a(List<ConversationLoaderEntity> paramList)
  {
    int m = paramList.size();
    if (m == 0)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    for (int n = 0; n < m; n++)
    {
      ConversationLoaderEntity localConversationLoaderEntity = (ConversationLoaderEntity)paramList.get(n);
      long l1 = localConversationLoaderEntity.getContactId();
      if (!localConversationLoaderEntity.isGroupBehavior())
        localStringBuilder.append(l1).append(',');
    }
    if (localStringBuilder.length() == 0)
      return null;
    localStringBuilder.setLength(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  private static String a(boolean paramBoolean)
  {
    if (paramBoolean)
      return "(conversations.name LIKE ? OR conversations.name = '')";
    return "conversations.name LIKE ?";
  }

  private Collection<ConversationLoaderEntity> a(String paramString1, String paramString2)
  {
    HashSet localHashSet = new HashSet();
    String[] arrayOfString = this.k.a(paramString1, paramString1);
    String str1 = this.k.b();
    String str2 = str1 + " AND phonebookcontact.viber = true";
    String str3 = str2 + " AND vibernumbers.member_id<> ''";
    if (!da.a(paramString2))
      str3 = str3 + " AND " + String.format("phonebookcontact._id NOT IN (%s) ", new Object[] { paramString2 });
    Cursor localCursor = this.l.query(this.k.a(), new String[] { "display_name", "member_id", "photo" }, str3, arrayOfString, "low_display_name ASC");
    if (com.viber.voip.util.af.c(localCursor))
    {
      do
      {
        RegularConversationLoaderEntity localRegularConversationLoaderEntity = new RegularConversationLoaderEntity(localCursor.getString(0), localCursor.getString(1), Uri.parse(da.h(localCursor.getString(2))));
        localRegularConversationLoaderEntity.setSearchSection(ConversationLoaderEntity.a.h);
        localHashSet.add(localRegularConversationLoaderEntity);
      }
      while (localCursor.moveToNext());
      com.viber.voip.util.af.a(localCursor);
    }
    return localHashSet;
  }

  private void a(String paramString, String[] paramArrayOfString, Set<Long> paramSet, List<ConversationLoaderEntity> paramList)
  {
    Cursor localCursor = null;
    try
    {
      localCursor = f().a(paramString, paramArrayOfString);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          ConversationLoaderEntity localConversationLoaderEntity = (ConversationLoaderEntity)this.j.apply(localCursor);
          paramList.add(localConversationLoaderEntity);
          paramSet.add(Long.valueOf(localConversationLoaderEntity.getId()));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return;
    }
    finally
    {
      a(localCursor);
    }
  }

  public ArrayList<ConversationLoaderEntity> a(y paramy, af.a parama)
  {
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList1 = new ArrayList();
    if ((paramy == null) || (da.a(paramy.a())))
      return localArrayList1;
    String str1 = paramy.a().trim();
    String str2 = str1.toLowerCase();
    String str3 = '%' + str1 + '%';
    int m;
    StringBuilder localStringBuilder;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    if (af.a.c == parama)
    {
      m = 1;
      if (m == 0)
      {
        if (paramy.b())
        {
          String str4 = (String)this.g.e();
          if (!paramy.h())
            str4 = str4 + " AND conversations.flags & (1 << 0) = 0";
          if (!paramy.n())
            str4 = str4 + " AND conversations.flags & (1 << 19)=0 ";
          if (!paramy.o())
            str4 = str4 + " AND conversations.flags & (1 << 24)=0";
          if (paramy.c())
            str4 = str4 + " AND conversations.conversation_type<>0";
          if (paramy.u())
            str4 = str4 + " AND (conversations.conversation_type <> 0 OR participants_info.member_id NOT LIKE 'em:%')";
          a(str4 + " GROUP BY messages.conversation_id", new String[] { str3 }, localHashSet, localArrayList1);
        }
        if (paramy.g())
        {
          g localg = new g(this.h, paramy.a(), com.viber.voip.s.a.e(localHashSet), paramy.n(), paramy.o(), paramy.u());
          a(localg.a(), localg.b(), localHashSet, localArrayList1);
        }
      }
      localStringBuilder = new StringBuilder(1300);
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localStringBuilder.append((String)this.i.e());
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = com.viber.voip.s.a.e(localHashSet);
      localStringBuilder.append(String.format(" AND conversations._id NOT IN (%s)", arrayOfObject));
      if (m == 0)
        break label638;
      localStringBuilder.append(" AND conversations.flags & 32768<>0");
      if (paramy.g())
      {
        if (paramy.u())
          localStringBuilder.append(" AND (conversations.conversation_type <> 0 OR participants_info.member_id NOT LIKE 'em:%')");
        localArrayList2.add("conversations.conversation_type = 0");
      }
      if (paramy.d())
        localArrayList2.add("conversations.conversation_type = 1");
    }
    label638: 
    do
    {
      if (!paramy.o())
        localStringBuilder.append(" AND conversations.flags & (1 << 24)=0");
      if (!localArrayList2.isEmpty())
      {
        localStringBuilder.append(" AND (" + com.viber.voip.s.a.f(localArrayList2) + ")");
        localStringBuilder.append(" GROUP BY conversations._id");
        a(localStringBuilder.toString(), (String[])localArrayList3.toArray(new String[localArrayList3.size()]), localHashSet, localArrayList1);
      }
      if (paramy.t())
        localArrayList1.addAll(a(str1, a(localArrayList1)));
      Collections.sort(localArrayList1, new ae(this, str2));
      return localArrayList1;
      m = 0;
      break;
      localStringBuilder.append(" AND conversations.flags & 294912=0");
      if (paramy.p())
      {
        localArrayList2.add("conversations.conversation_type=4 AND (SELECT COUNT(*) from [participants] where [participants].[conversation_id] = conversations._id and [participants].[active] = 0) > 1 AND " + a(paramy.j()));
        localArrayList3.add(str3);
      }
      if (paramy.d())
      {
        localArrayList2.add("conversations.conversation_type = 1 AND " + a(paramy.i()));
        localArrayList3.add(str3);
      }
      if (paramy.e())
      {
        if (!paramy.s())
          break label846;
        localArrayList2.add("conversations.conversation_type = 5 AND  conversations.group_role <> 4 AND EXISTS (SELECT public_accounts.verified AS pa_flags, public_accounts.community_privileges AS privileges FROM public_accounts WHERE conversations.group_id = public_accounts.group_id AND pa_flags & 134217728 = 0 AND (conversations.group_role IN (2,1) OR (conversations.group_role = 3 AND privileges & 9223372036854775807 <> 0)) LIMIT 1) AND " + a(false));
        localArrayList3.add(str3);
      }
    }
    while (!paramy.f());
    label784: if (paramy.s())
      localArrayList2.add("conversations.conversation_type = 2 AND  conversations.group_role IN (2,1) AND " + a(false));
    while (true)
    {
      localArrayList3.add(str3);
      break;
      label846: localArrayList2.add("conversations.conversation_type = 5 AND " + a(false));
      break label784;
      localArrayList2.add("conversations.conversation_type = 2 AND " + a(false));
    }
  }

  protected static abstract interface a extends com.viber.voip.util.d.b<Cursor, ConversationLoaderEntity>
  {
  }

  protected static class b extends ad.e
  {
    protected b()
    {
      super();
    }

    protected String[] a()
    {
      return RegularConversationLoaderEntity.PROJECTIONS;
    }

    protected String b()
    {
      return " LEFT OUTER JOIN messages ON (messages._id = (SELECT messages._id FROM messages WHERE messages.conversation_id=conversations._id AND messages.deleted=0 AND messages.extra_mime<>1007 AND messages.status<>12 AND messages.extra_flags&4194304=0 AND (messages.flag&131072=0 OR send_type=0) ORDER BY messages.order_key DESC, messages.msg_date DESC LIMIT 1)) LEFT OUTER JOIN participants_info ON (conversations.participant_id_1=participants_info._id)  LEFT OUTER JOIN public_accounts ON (public_accounts.group_id=conversations.group_id)";
    }

    protected String c()
    {
      return "SELECT " + com.viber.voip.s.a.d(a()) + " FROM " + "conversations" + b() + " WHERE " + "conversations.deleted=0" + " AND (" + "conversations.conversation_type <> 0 OR participants_info.participant_info_flags & 2 = 0" + ")";
    }
  }

  protected static class c extends ad.e
  {
    protected c()
    {
      super();
    }

    protected String[] a()
    {
      return RegularConversationLoaderEntity.PROJECTIONS;
    }

    protected String b()
    {
      return " LEFT OUTER JOIN conversations ON (messages.conversation_id=conversations._id) LEFT OUTER JOIN participants ON (messages.participant_id=participants._id) LEFT OUTER JOIN participants_info ON ((CASE WHEN (conversations.conversation_type=0) THEN conversations.participant_id_1 ELSE participants.participant_info_id END)=participants_info._id) LEFT OUTER JOIN public_accounts ON (public_accounts.group_id=conversations.group_id)";
    }

    protected String c()
    {
      String[] arrayOfString = ag.a(a());
      return "SELECT " + com.viber.voip.s.a.d(arrayOfString) + ", MAX(" + "messages.msg_date" + ") AS " + "message_date" + " FROM " + "messages" + b() + " WHERE " + "conversations.deleted=0" + " AND " + "conversations.flags & 294912=0" + " AND " + "conversations.conversation_type" + " IN ('" + 1 + "','" + 0 + "') AND (" + "conversations.conversation_type <> 0 OR participants_info.participant_info_flags & 2 = 0" + ") AND " + "messages.extra_mime" + "=" + 0 + " AND " + "messages.body" + " LIKE ?";
    }
  }

  protected static class d extends ad.e
  {
    protected d()
    {
      super();
    }

    protected String[] a()
    {
      return RegularConversationLoaderEntity.PROJECTIONS;
    }

    protected String b()
    {
      return " LEFT OUTER JOIN conversations ON (participants.conversation_id=conversations._id) LEFT OUTER JOIN messages ON ((SELECT messages._id FROM messages WHERE participants.conversation_id=messages.conversation_id ORDER BY messages.order_key DESC, messages.msg_date DESC LIMIT 1)=messages._id) LEFT OUTER JOIN participants_info ON (participants.participant_info_id=participants_info._id) LEFT OUTER JOIN public_accounts ON (public_accounts.group_id=conversations.group_id)";
    }

    protected String c()
    {
      String[] arrayOfString = ag.a(a());
      return "SELECT " + com.viber.voip.s.a.d(arrayOfString) + " FROM " + "participants" + b() + " WHERE " + "conversations.deleted=0" + " AND " + "conversations.flags & (1 << 0) = 0" + " AND " + "conversations.flags & 32768=0";
    }
  }

  private static abstract class e extends f<String>
  {
    protected abstract String[] a();

    protected abstract String b();
  }

  private static class f
    implements ad.a
  {
    public ConversationLoaderEntity a(Cursor paramCursor)
    {
      return new RegularConversationLoaderEntity(paramCursor, true);
    }
  }

  private class g
  {
    ArrayList<String> a = new ArrayList();
    StringBuilder b = new StringBuilder(1550);

    g(ad.d paramString1, String paramString2, String paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean arg7)
    {
      this.b.append((String)paramString1.e()).append(" AND participants.conversation_id NOT IN (").append(paramBoolean1).append(')');
      if (!paramBoolean2)
        this.b.append(" AND conversations.flags & (1 << 19)=0 ");
      if (!paramBoolean3)
        this.b.append(" AND conversations.flags & (1 << 24)=0");
      String str = '%' + paramString2.trim() + '%';
      this.b.append(" AND (conversations.conversation_type <> 0 OR participants_info.participant_info_flags & 2 = 0)");
      int i;
      if (i != 0)
        this.b.append(" AND (conversations.conversation_type <> 0 OR participants_info.member_id NOT LIKE 'em:%')");
      this.b.append(" AND ((conversations.conversation_type = 0) AND ((").append("(participants_info.participant_type<>0 AND participants_info.display_name LIKE ?)").append(")  OR ((participants_info.display_name='' OR participants_info.display_name IS NULL)  AND (participants_info.contact_name='' OR participants_info.contact_name IS NULL)  AND participants_info.participant_type<>0 AND participants_info.number LIKE ?))) ");
      this.a.add(str);
      this.a.add(str);
      this.b.append(" GROUP BY conversations._id");
    }

    String a()
    {
      return this.b.toString();
    }

    String[] b()
    {
      return (String[])this.a.toArray(new String[this.a.size()]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.ad
 * JD-Core Version:    0.6.2
 */