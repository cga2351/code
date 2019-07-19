package com.viber.voip.messages.controller.manager;

import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.e.c;
import com.viber.voip.apps.b.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.memberid.d;
import com.viber.voip.messages.k;
import com.viber.voip.messages.orm.entity.impl.ParticipantEntityHelper;
import com.viber.voip.messages.orm.entity.impl.ParticipantInfoEntityHelper;
import com.viber.voip.model.entity.l;
import com.viber.voip.model.j;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.ce;
import com.viber.voip.util.dd;
import com.viber.voip.util.dk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.sqlite.database.sqlite.SQLiteStatement;

public class ak extends aa
{
  private static final Logger g = ViberEnv.getLogger();
  private static final String h = "SELECT " + com.viber.voip.s.a.a("participants_info", ParticipantInfoEntityHelper.PROJECTIONS) + ", " + "conversations._id" + " FROM " + "conversations" + " LEFT OUTER JOIN " + "participants_info" + " ON (" + "conversations.participant_id_1" + "=" + "participants_info._id" + ") WHERE " + "conversations._id" + " IN(%s)";
  private static final String i = "SELECT " + com.viber.voip.s.a.a("participants_info", ParticipantInfoEntityHelper.PROJECTIONS) + " FROM " + "participants" + " LEFT OUTER JOIN " + "participants_info" + " ON (" + "participants.participant_info_id" + "=" + "participants_info._id" + ") WHERE " + "participants.conversation_id" + " = ?";
  private static final String j = "SELECT " + com.viber.voip.s.a.a("participants_info", ParticipantInfoEntityHelper.PROJECTIONS) + ", " + com.viber.voip.s.a.a("participants", ParticipantEntityHelper.PROJECTIONS) + " FROM " + "participants" + " LEFT OUTER JOIN " + "participants_info" + " ON (" + "participants.participant_info_id" + "=" + "participants_info._id" + ") WHERE " + "participants.conversation_id" + "= %s AND " + "participants_info.participant_type" + " <> " + 0;
  private static final String k = "SELECT " + com.viber.voip.s.a.a("participants_info", ParticipantInfoEntityHelper.PROJECTIONS) + ", " + "participants" + "." + "_id" + " FROM " + "participants" + " LEFT OUTER JOIN " + "participants_info" + " ON (" + "participants.participant_info_id" + "=" + "participants_info._id" + ") WHERE " + "participants.conversation_id" + "= ? AND " + "participants" + "." + "active" + " = " + 2;
  private static volatile ak l;
  private o m;
  private UserManager n;
  private SQLiteStatement o;
  private SQLiteStatement p;

  private ak()
  {
    dd.b();
    this.n = UserManager.from(ViberApplication.getApplication());
    this.m = o.a();
  }

  public static ak a()
  {
    if (l == null);
    try
    {
      if (l == null)
        l = new ak();
      return l;
    }
    finally
    {
    }
  }

  private com.viber.voip.model.entity.m a(List<com.viber.voip.model.entity.m> paramList, Member paramMember, int paramInt, boolean paramBoolean, g.a parama)
  {
    int i1 = 1;
    if (paramList.size() > i1);
    for (com.viber.voip.model.entity.m localm = ViberApplication.getInstance().getMessagesManager().B().a(paramList, paramMember, paramInt, parama); localm.a() == null; localm = (com.viber.voip.model.entity.m)paramList.get(0))
    {
      String str = "outers " + paramList + " valid " + localm;
      g.a(new IllegalArgumentException("NPE: no member id"), str);
      return localm;
    }
    if ((!paramMember.getId().equals(paramMember.getPhoneNumber())) && (localm.getNumber() != null) && (localm.getNumber().equals(paramMember.getPhoneNumber())) && (!localm.a().equals(paramMember.getId())) && (!paramBoolean))
      localm.d(paramMember.getId());
    for (int i2 = i1; ; i2 = 0)
    {
      if ((localm.a() != null) && (!localm.a().equals(paramMember.getId())) && ((localm.a().equals(paramMember.getEncryptedPhoneNumber())) || (localm.a().equals(paramMember.getEncryptedMemberId()))) && (!paramBoolean))
      {
        if ((localm.g() == i1) && (localm.a().equals(paramMember.getEncryptedMemberId())))
          com.viber.voip.analytics.g.a().c().g().c();
        localm.d(paramMember.getId());
        i2 = i1;
      }
      if ((paramMember.getPhoneNumber() != null) && (!paramMember.getPhoneNumber().equals(localm.getNumber())) && (ce.l.matcher(paramMember.getPhoneNumber()).matches()) && (!paramBoolean))
      {
        localm.c(paramMember.getPhoneNumber());
        i2 = i1;
      }
      if ((!paramBoolean) && (localm.g() == i1) && (cd.c(paramMember.getEncryptedMemberId())) && (!paramMember.getEncryptedMemberId().equals(localm.b())))
      {
        localm.a(paramMember.getEncryptedMemberId());
        i2 = i1;
      }
      if (localm.k())
        localm.b(av.b(localm.m(), i1));
      while (i1 != 0)
      {
        b(localm);
        this.m.a(Collections.singletonList(localm), false);
        return localm;
        i1 = i2;
      }
      break;
    }
  }

  private List<com.viber.voip.model.entity.m> a(Set<String> paramSet, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(32 * (1 + paramSet.size()));
    localStringBuilder.append(paramString);
    com.viber.voip.s.a.a(localStringBuilder, paramSet);
    localStringBuilder.append(')');
    return g(localStringBuilder.toString(), null, null);
  }

  private Map<Long, com.viber.voip.model.entity.m> a(String paramString)
  {
    Cursor localCursor = null;
    HashMap localHashMap = new HashMap();
    try
    {
      localCursor = f().a(String.format(h, new Object[] { paramString }), null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          com.viber.voip.model.entity.m localm = new com.viber.voip.model.entity.m();
          ParticipantInfoEntityHelper.createEntity(localm, localCursor, 0);
          localHashMap.put(Long.valueOf(localCursor.getInt(ParticipantInfoEntityHelper.PROJECTIONS.length)), localm);
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localHashMap;
    }
    finally
    {
      a(localCursor);
    }
  }

  private SQLiteStatement i()
  {
    if (this.p == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(512);
      localStringBuilder.append("SELECT COALESCE((SELECT ").append("_id").append(" FROM ").append("participants_info").append(" WHERE ").append("(member_id=? OR encrypted_number =? OR encrypted_member_id =? OR number=?) AND participant_type=?").append(" LIMIT 1),-1) AS ").append("_id");
      this.p = f().b(localStringBuilder.toString());
    }
    return this.p;
  }

  private SQLiteStatement j()
  {
    if (this.o == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(512);
      localStringBuilder.append("INSERT INTO ").append("participants_info").append("(");
      com.viber.voip.s.a.b(localStringBuilder, ParticipantInfoEntityHelper.PROJECTIONS);
      localStringBuilder.append(") VALUES (?");
      for (int i1 = 1; i1 < ParticipantInfoEntityHelper.PROJECTIONS.length; i1++)
        localStringBuilder.append(",?");
      localStringBuilder.append(')');
      this.o = f().b(localStringBuilder.toString());
    }
    return this.o;
  }

  public com.viber.voip.model.entity.m a(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    return i("_id IN (SELECT participant_info_id FROM participants WHERE _id=?)", arrayOfString);
  }

  public com.viber.voip.model.entity.m a(Member paramMember, int paramInt)
  {
    return a(paramMember, 0, null, false, paramInt, false, null);
  }

  public com.viber.voip.model.entity.m a(Member paramMember, int paramInt1, PublicAccount paramPublicAccount, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, g.a parama)
  {
    com.viber.provider.b localb = f();
    if ((!localb.d()) && (!localb.e()))
      localb.a();
    for (int i1 = 1; ; i1 = 0)
      try
      {
        List localList = d(paramMember, paramInt2);
        Object localObject2;
        if (localList.size() == 0)
          if (paramBoolean1)
            localObject2 = a(paramMember.getId(), paramPublicAccount);
        while (true)
        {
          if (i1 != 0)
            localb.c();
          return localObject2;
          if (com.viber.voip.messages.m.i(paramInt1))
          {
            com.viber.voip.apps.b localb1 = this.n.getAppsController().a(paramInt1);
            localObject2 = a(paramMember.getId(), localb1);
          }
          else
          {
            localObject2 = b(paramMember, paramInt2);
            continue;
            com.viber.voip.model.entity.m localm = a(localList, paramMember, paramInt2, paramBoolean2, parama);
            localObject2 = localm;
          }
        }
      }
      finally
      {
        if (i1 != 0)
          localb.b();
      }
  }

  public com.viber.voip.model.entity.m a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[1] = String.valueOf(paramInt);
    return i("viber_image=? AND participants_info.participant_type=?", arrayOfString);
  }

  public com.viber.voip.model.entity.m a(String paramString, com.viber.voip.apps.b paramb)
  {
    String str;
    if (paramb != null)
    {
      str = paramb.c();
      if (paramb == null)
        break label48;
    }
    label48: for (Uri localUri = paramb.a(b.a.b); ; localUri = dk.a(R.drawable.icon_viber_message, ViberApplication.getApplication()))
    {
      return b(new Member(paramString, paramString, localUri, str, null), 1);
      str = "viber";
      break;
    }
  }

  public com.viber.voip.model.entity.m a(String paramString, PublicAccount paramPublicAccount)
  {
    if (paramPublicAccount != null);
    for (Member localMember = new Member(paramString, paramString, paramPublicAccount.getIcon(), paramPublicAccount.getName(), null); ; localMember = new Member(paramString, paramString, null, paramString, null))
      return b(localMember, 1);
  }

  public List<com.viber.voip.model.entity.m> a(int paramInt, Set<String> paramSet)
  {
    return a(paramSet, "participant_type=" + paramInt + " AND " + "number IN (");
  }

  protected List<com.viber.voip.model.entity.m> a(Cursor paramCursor, List<com.viber.voip.model.entity.m> paramList)
  {
    if ((paramCursor != null) && (paramCursor.moveToFirst()))
      do
        paramList.add(ParticipantInfoEntityHelper.createEntity(new com.viber.voip.model.entity.m(), paramCursor, 0));
      while (paramCursor.moveToNext());
    return paramList;
  }

  public List<com.viber.voip.model.entity.m> a(Set<String> paramSet)
  {
    return a(paramSet, "number IN (");
  }

  public List<com.viber.voip.model.entity.m> a(Set<String> paramSet1, Set<String> paramSet2)
  {
    StringBuilder localStringBuilder = new StringBuilder(32 * (1 + (paramSet1.size() + paramSet2.size())));
    localStringBuilder.append("member_id IN (");
    com.viber.voip.s.a.a(localStringBuilder, paramSet1);
    localStringBuilder.append(") OR ");
    localStringBuilder.append("encrypted_member_id IN (");
    com.viber.voip.s.a.a(localStringBuilder, paramSet2);
    localStringBuilder.append(')');
    return g(localStringBuilder.toString(), null, null);
  }

  public Map<Long, com.viber.voip.model.entity.m> a(com.viber.voip.model.entity.h[] paramArrayOfh)
  {
    return a(com.viber.voip.s.a.a(paramArrayOfh));
  }

  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    a("participants_info", "participant_info_flags", paramLong, paramInt, paramBoolean);
  }

  public void a(long paramLong, String paramString)
  {
    a("participants_info", paramLong, "number", paramString);
  }

  public void a(Set<Long> paramSet, int paramInt, boolean paramBoolean)
  {
    a("participants_info", "participant_info_flags", paramSet, paramInt, paramBoolean);
  }

  public boolean a(long paramLong, com.viber.voip.registration.af paramaf, Long[] paramArrayOfLong)
  {
    com.viber.voip.model.entity.m localm = b(paramLong);
    boolean bool1 = false;
    if (localm != null)
    {
      boolean bool2 = com.viber.voip.messages.m.a(paramaf, localm.a());
      bool1 = false;
      if (!bool2)
      {
        boolean bool3 = localm.i() < 0L;
        bool1 = false;
        if (!bool3)
        {
          Set localSet = d(paramLong);
          if ((localSet.size() > 0) && (paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
            localSet.removeAll(Arrays.asList(paramArrayOfLong));
          int i1 = localSet.size();
          bool1 = false;
          if (i1 > 0)
            bool1 = true;
        }
      }
    }
    return bool1;
  }

  public boolean a(com.viber.voip.model.entity.m paramm)
  {
    SQLiteStatement localSQLiteStatement1 = j();
    synchronized (this.o)
    {
      long l1 = ParticipantInfoEntityHelper.bindInsertStatmentValues(localSQLiteStatement1, paramm).executeInsert();
      if (l1 > 0L)
      {
        paramm.setId(l1);
        return true;
      }
    }
    return false;
  }

  public com.viber.voip.model.entity.m b()
  {
    com.viber.voip.model.entity.m localm = e();
    if (localm == null)
    {
      localm = new com.viber.voip.model.entity.m();
      com.viber.voip.registration.af localaf = this.n.getRegistrationValues();
      localm.d(localaf.l());
      localm.b(localaf.m());
      localm.c(localaf.h());
      localm.e(localaf.j());
      localm.a(localaf.k());
      localm.a(0);
      a(localm);
      this.m.a(Collections.singletonList(localm), false);
    }
    return localm;
  }

  public com.viber.voip.model.entity.m b(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    return i("_id=?", arrayOfString);
  }

  public com.viber.voip.model.entity.m b(Member paramMember, int paramInt)
  {
    com.viber.voip.registration.af localaf = this.n.getRegistrationValues();
    if ((com.viber.voip.messages.m.a(localaf, paramMember.getId())) || (com.viber.voip.messages.m.a(localaf, paramMember.getEncryptedPhoneNumber())) || (com.viber.voip.messages.m.a(localaf, paramMember.getEncryptedMemberId())))
      return b();
    String str1 = paramMember.getId();
    String str2 = paramMember.getPhoneNumber();
    if ((d.a(str1)) && (TextUtils.isEmpty(str2)))
      str2 = str1;
    Uri localUri1 = paramMember.getPhotoUri();
    com.viber.voip.model.entity.m localm = new com.viber.voip.model.entity.m();
    localm.a(paramInt);
    localm.f(paramMember.getViberName());
    localm.a(localUri1);
    localm.d(paramMember.getId());
    localm.c(str2);
    if (paramInt != 2)
      localm.e(paramMember.getEncryptedPhoneNumber());
    localm.a(paramMember.getEncryptedMemberId());
    localm.c(System.currentTimeMillis());
    com.viber.voip.contacts.c.d.m localm1 = ViberApplication.getInstance().getContactManager().c();
    int i1;
    Object localObject;
    label208: com.viber.voip.model.a locala;
    if ((2 == paramInt) || (cd.c(paramMember.getId())))
    {
      i1 = 1;
      if (i1 == 0)
        break label421;
      localObject = localm1.b(paramMember);
      if (((Collection)localObject).size() != 0)
        break label434;
      locala = null;
    }
    label421: label434: 
    while (true)
      label221: if (locala != null)
      {
        Uri localUri2 = locala.g();
        localm.a(locala.getId());
        localm.h(locala.k());
        localm.b(locala.e());
        Iterator localIterator = locala.s().iterator();
        while (true)
          if (localIterator.hasNext())
          {
            j localj = (j)localIterator.next();
            if ((localj.a().equals(str1)) || (localj.c().equals(str1)) || (str1.equals(localj.b())))
            {
              localm.d(localj.a());
              localm.c(localj.c());
              localm.b(localj.f());
              String str4 = localj.b();
              if (!TextUtils.isEmpty(str4))
              {
                localm.a(str4);
                continue;
                i1 = 0;
                break;
                localObject = localm1.a(paramMember);
                break label208;
                locala = (com.viber.voip.model.a)((Collection)localObject).iterator().next();
                break label221;
              }
            }
          }
        if (TextUtils.isEmpty(localm.getNumber()))
        {
          localm.a(0L);
          localm.h(null);
          localm.b(0L);
        }
        if (localUri2 != null)
          localm.g(localUri2.toString());
      }
    String str3 = localm.a();
    if ((TextUtils.isEmpty(localm.b())) && (cd.c(str3)))
      localm.a(str3);
    if ((TextUtils.isEmpty(localm.getNumber())) && (cd.c(str3)))
      localm.c(str3);
    a(localm);
    this.m.a(Collections.singletonList(localm), false);
    return localm;
  }

  public com.viber.voip.model.entity.m b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[1] = String.valueOf(paramInt);
    return i("number=? AND participants_info.participant_type=?", arrayOfString);
  }

  public List<com.viber.voip.model.entity.m> b(int paramInt, Set<String> paramSet)
  {
    return a(paramSet, "participant_type=" + paramInt + " AND " + "member_id IN (");
  }

  public List<com.viber.voip.model.entity.m> b(Collection<String> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder(32 * (1 + paramCollection.size()));
    localStringBuilder.append("_id IN (");
    com.viber.voip.s.a.a(localStringBuilder, paramCollection);
    localStringBuilder.append(')');
    return g(localStringBuilder.toString(), null, null);
  }

  public List<com.viber.voip.model.entity.m> b(Set<String> paramSet)
  {
    return a(paramSet, "member_id IN (");
  }

  public void b(long paramLong, String paramString)
  {
    a("participants_info", paramLong, "encrypted_member_id", paramString);
  }

  public void b(com.viber.voip.model.entity.m paramm)
  {
    if (d.a(paramm.a()))
      paramm.d("unknown_number");
    if (paramm.i() > 0L);
    for (String str = paramm.getNumber(); ; str = null)
    {
      paramm.c("unknown_number");
      paramm.a(0L);
      paramm.b(0L);
      paramm.b(0);
      paramm.h(null);
      paramm.b(null);
      if (TextUtils.isEmpty(paramm.getViberName()))
        paramm.f(str);
      return;
    }
  }

  public com.viber.voip.model.entity.m c(Member paramMember, int paramInt)
  {
    List localList = d(paramMember, paramInt);
    int i1 = localList.size();
    if (i1 > 1)
    {
      ViberApplication.getInstance().getMessagesManager().B().a(localList, paramMember);
      return (com.viber.voip.model.entity.m)localList.get(0);
    }
    if (i1 == 1)
      return (com.viber.voip.model.entity.m)localList.get(0);
    return null;
  }

  public List<com.viber.voip.model.entity.m> c()
  {
    return g(null, null, null);
  }

  public List<com.viber.voip.model.entity.m> c(int paramInt, Set<String> paramSet)
  {
    return a(paramSet, "participant_type=" + paramInt + " AND " + "encrypted_member_id IN (");
  }

  public List<com.viber.voip.model.entity.m> c(Collection<Long> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder(32 * (1 + paramCollection.size()));
    localStringBuilder.append("_id IN (");
    com.viber.voip.s.a.a(paramCollection, localStringBuilder);
    localStringBuilder.append(')');
    return g(localStringBuilder.toString(), null, null);
  }

  public Map<String, a> c(long paramLong)
  {
    Cursor localCursor = null;
    HashMap localHashMap = new HashMap();
    try
    {
      com.viber.provider.b localb = f();
      String str = k;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(paramLong);
      localCursor = localb.a(str, arrayOfString);
      if (com.viber.voip.util.af.c(localCursor))
      {
        boolean bool;
        do
        {
          com.viber.voip.model.entity.m localm = new com.viber.voip.model.entity.m();
          ParticipantInfoEntityHelper.createEntity(localm, localCursor, 0);
          localHashMap.put(localm.b(), new a(localm, localCursor.getLong(ParticipantInfoEntityHelper.PROJECTIONS.length)));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localHashMap;
    }
    finally
    {
      a(localCursor);
    }
  }

  public Set<String> c(Set<String> paramSet)
  {
    Cursor localCursor = null;
    HashSet localHashSet = new HashSet(paramSet.size(), 1.0F);
    try
    {
      com.viber.provider.b localb = f();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = com.viber.voip.s.a.b(paramSet);
      localCursor = localb.a(String.format("SELECT DISTINCT participants_info.number FROM participants_info WHERE participants_info.number IN (%s)", arrayOfObject), null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          localHashSet.add(localCursor.getString(0));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localHashSet;
    }
    finally
    {
      a(localCursor);
    }
  }

  public List<com.viber.voip.model.entity.m> d()
  {
    return g("participant_type=1", null, null);
  }

  public List<com.viber.voip.model.entity.m> d(Member paramMember, int paramInt)
  {
    if (TextUtils.isEmpty(paramMember.getId()))
      return a(paramInt, Collections.singleton(paramMember.getPhoneNumber()));
    String str1 = paramMember.getId();
    String str2;
    String str3;
    if (TextUtils.isEmpty(paramMember.getEncryptedPhoneNumber()))
    {
      str2 = str1;
      if (!TextUtils.isEmpty(paramMember.getEncryptedMemberId()))
        break label124;
      str3 = str1;
      label54: if (!TextUtils.isEmpty(paramMember.getPhoneNumber()))
        break label133;
    }
    label133: for (String str4 = str1; ; str4 = paramMember.getPhoneNumber())
    {
      String[] arrayOfString = new String[5];
      arrayOfString[0] = str1;
      arrayOfString[1] = str2;
      arrayOfString[2] = str3;
      arrayOfString[3] = str4;
      arrayOfString[4] = String.valueOf(paramInt);
      return g("(member_id=? OR encrypted_number =? OR encrypted_member_id =? OR number=?) AND participant_type=?", arrayOfString, null);
      str2 = paramMember.getEncryptedPhoneNumber();
      break;
      label124: str3 = paramMember.getEncryptedMemberId();
      break label54;
    }
  }

  public Set<Long> d(long paramLong)
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(Long.valueOf(paramLong));
    return f(localHashSet);
  }

  public Set<String> d(Set<Long> paramSet)
  {
    Cursor localCursor = null;
    HashSet localHashSet = new HashSet(paramSet.size(), 1.0F);
    try
    {
      com.viber.provider.b localb = f();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = com.viber.voip.s.a.e(paramSet);
      localCursor = localb.a(String.format("SELECT DISTINCT participants_info.number FROM participants_info WHERE participants_info.contact_id IN (%s)", arrayOfObject), null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          localHashSet.add(localCursor.getString(0));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localHashSet;
    }
    finally
    {
      a(localCursor);
    }
  }

  public com.viber.voip.model.entity.m e()
  {
    return i("participant_type=0", null);
  }

  public Long e(Member paramMember, int paramInt)
  {
    SQLiteStatement localSQLiteStatement1 = i();
    long l1;
    while (true)
    {
      synchronized (this.p)
      {
        localSQLiteStatement1.bindString(1, paramMember.getId());
        if (TextUtils.isEmpty(paramMember.getEncryptedPhoneNumber()))
        {
          localSQLiteStatement1.bindString(2, paramMember.getId());
          if (TextUtils.isEmpty(paramMember.getEncryptedMemberId()))
          {
            localSQLiteStatement1.bindString(3, paramMember.getId());
            if (!TextUtils.isEmpty(paramMember.getPhoneNumber()))
              break label137;
            localSQLiteStatement1.bindString(4, paramMember.getId());
            localSQLiteStatement1.bindLong(5, paramInt);
            l1 = localSQLiteStatement1.simpleQueryForLong();
            if (l1 >= 0L)
              break;
            return null;
          }
        }
        else
        {
          localSQLiteStatement1.bindString(2, paramMember.getEncryptedPhoneNumber());
        }
      }
      localSQLiteStatement1.bindString(3, paramMember.getEncryptedMemberId());
      continue;
      label137: localSQLiteStatement1.bindString(4, paramMember.getPhoneNumber());
    }
    Long localLong = Long.valueOf(l1);
    return localLong;
  }

  public Map<com.viber.voip.model.entity.m, l> e(long paramLong)
  {
    Cursor localCursor = null;
    HashMap localHashMap = new HashMap();
    try
    {
      com.viber.provider.b localb = f();
      String str = j;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramLong);
      localCursor = localb.a(String.format(str, arrayOfObject), null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          com.viber.voip.model.entity.m localm = new com.viber.voip.model.entity.m();
          ParticipantInfoEntityHelper.createEntity(localm, localCursor, 0);
          l locall = new l();
          ParticipantEntityHelper.createEntity(locall, localCursor, ParticipantInfoEntityHelper.PROJECTIONS.length);
          localHashMap.put(localm, locall);
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localHashMap;
    }
    finally
    {
      a(localCursor);
    }
  }

  public Set<Long> e(Set<Long> paramSet)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = com.viber.voip.s.a.e(paramSet);
    return a(0, String.format("SELECT DISTINCT participants.conversation_id FROM participants WHERE participants.participant_info_id IN (%s)", arrayOfObject));
  }

  public Set<Long> f(Set<Long> paramSet)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = com.viber.voip.s.a.e(paramSet);
    return a(0, String.format("SELECT conversations._id FROM conversations WHERE conversations._id IN(SELECT DISTINCT participants.conversation_id FROM participants WHERE participants.participant_info_id IN (%s)) AND conversations.deleted=0 AND conversations.conversation_type IN ('1', '0') AND ((flags & 128 <> 0 ) OR (flags & 32 <> 0 ))", arrayOfObject));
  }

  // ERROR //
  protected List<com.viber.voip.model.entity.m> g(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    // Byte code:
    //   0: new 788	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 789	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: invokestatic 324	com/viber/voip/messages/controller/manager/ak:f	()Lcom/viber/provider/b;
    //   12: ldc 43
    //   14: getstatic 49	com/viber/voip/messages/orm/entity/impl/ParticipantInfoEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   17: aload_1
    //   18: aload_2
    //   19: aconst_null
    //   20: aconst_null
    //   21: aload_3
    //   22: aconst_null
    //   23: invokeinterface 792 9 0
    //   28: astore 7
    //   30: aload 7
    //   32: astore 6
    //   34: aload_0
    //   35: aload 6
    //   37: aload 4
    //   39: invokevirtual 794	com/viber/voip/messages/controller/manager/ak:a	(Landroid/database/Cursor;Ljava/util/List;)Ljava/util/List;
    //   42: astore 8
    //   44: aload_0
    //   45: aload 6
    //   47: invokevirtual 365	com/viber/voip/messages/controller/manager/ak:a	(Landroid/database/Cursor;)V
    //   50: aload 8
    //   52: areturn
    //   53: astore 5
    //   55: aconst_null
    //   56: astore 6
    //   58: aload_0
    //   59: aload 6
    //   61: invokevirtual 365	com/viber/voip/messages/controller/manager/ak:a	(Landroid/database/Cursor;)V
    //   64: aload 5
    //   66: athrow
    //   67: astore 5
    //   69: goto -11 -> 58
    //
    // Exception table:
    //   from	to	target	type
    //   9	30	53	finally
    //   34	44	67	finally
  }

  // ERROR //
  public com.viber.voip.model.entity.m h(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 324	com/viber/voip/messages/controller/manager/ak:f	()Lcom/viber/provider/b;
    //   6: ldc 43
    //   8: getstatic 49	com/viber/voip/messages/orm/entity/impl/ParticipantInfoEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   11: aload_1
    //   12: aload_2
    //   13: aconst_null
    //   14: aconst_null
    //   15: aload_3
    //   16: ldc_w 797
    //   19: invokeinterface 792 9 0
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +41 -> 69
    //   31: aload 6
    //   33: invokeinterface 340 1 0
    //   38: ifeq +31 -> 69
    //   41: new 178	com/viber/voip/model/entity/m
    //   44: dup
    //   45: invokespecial 341	com/viber/voip/model/entity/m:<init>	()V
    //   48: aload 6
    //   50: iconst_0
    //   51: invokestatic 345	com/viber/voip/messages/orm/entity/impl/ParticipantInfoEntityHelper:createEntity	(Lcom/viber/voip/model/entity/m;Landroid/database/Cursor;I)Lcom/viber/voip/model/entity/m;
    //   54: astore 8
    //   56: aload 8
    //   58: astore 7
    //   60: aload_0
    //   61: aload 6
    //   63: invokevirtual 365	com/viber/voip/messages/controller/manager/ak:a	(Landroid/database/Cursor;)V
    //   66: aload 7
    //   68: areturn
    //   69: aconst_null
    //   70: astore 7
    //   72: goto -12 -> 60
    //   75: astore 5
    //   77: aload_0
    //   78: aload 4
    //   80: invokevirtual 365	com/viber/voip/messages/controller/manager/ak:a	(Landroid/database/Cursor;)V
    //   83: aload 5
    //   85: athrow
    //   86: astore 5
    //   88: aload 6
    //   90: astore 4
    //   92: goto -15 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   3	26	75	finally
    //   31	56	86	finally
  }

  public Set<String> h()
  {
    Cursor localCursor = null;
    HashSet localHashSet = new HashSet(256);
    try
    {
      localCursor = f().a("SELECT DISTINCT participants_info.number FROM participants_info WHERE participants_info.participant_type<>0", null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        boolean bool;
        do
        {
          localHashSet.add(localCursor.getString(0));
          bool = localCursor.moveToNext();
        }
        while (bool);
      }
      return localHashSet;
    }
    finally
    {
      a(localCursor);
    }
  }

  public com.viber.voip.model.entity.m i(String paramString, String[] paramArrayOfString)
  {
    return h(paramString, paramArrayOfString, null);
  }

  public static class a
  {
    private final com.viber.voip.model.entity.m a;
    private final long b;

    public a(com.viber.voip.model.entity.m paramm, long paramLong)
    {
      this.a = paramm;
      this.b = paramLong;
    }

    public com.viber.voip.model.entity.m a()
    {
      return this.a;
    }

    public long b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.ak
 * JD-Core Version:    0.6.2
 */