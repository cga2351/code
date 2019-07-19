package com.viber.voip.messages.d;

import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.ChatUserInfo;
import com.viber.jni.PublicAccountInfo;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.d.d;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.l;
import com.viber.voip.model.entity.r;
import com.viber.voip.notif.g;
import com.viber.voip.registration.af;
import com.viber.voip.util.av;
import com.viber.voip.util.cd;
import com.viber.voip.util.ce;
import com.viber.voip.util.dx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

public class j
{
  private static final Logger i = ViberEnv.getLogger();
  protected o a;
  protected dagger.a<bs> b;
  protected ab c;
  protected ak d;
  protected al e;
  protected b f;
  protected af g;
  protected EventBus h;

  public j(o paramo, dagger.a<bs> parama, ab paramab, af paramaf)
  {
    this.a = paramo;
    this.b = parama;
    this.c = paramab;
    this.d = ak.a();
    this.e = al.a();
    this.f = c.c();
    this.g = paramaf;
    this.h = com.viber.voip.h.a.b();
  }

  private void a(long paramLong, int paramInt, boolean paramBoolean, a[] paramArrayOfa)
  {
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfa.length;
    for (int k = 0; k < j; k++)
    {
      a locala = paramArrayOfa[k];
      if (locala != null)
      {
        Member localMember = locala.a;
        int m = locala.b;
        com.viber.voip.model.entity.m localm2 = this.d.a(localMember, cd.j(paramInt));
        this.e.a(paramLong, 0, m, localm2.getId());
        this.f.a(localm2, localMember);
        localHashSet.add(Long.valueOf(localm2.getId()));
        if (localm2.s())
          localArrayList.add(localMember.getId());
      }
    }
    com.viber.voip.model.entity.m localm1 = this.d.e();
    Iterator localIterator = this.e.c(paramLong).iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if ((localm1 != null) && (localm1.getId() != locall.a()) && (!localHashSet.contains(Long.valueOf(locall.a()))))
        this.c.a("participants", locall.getId(), "active", Integer.valueOf(1));
    }
    this.c.f(paramLong, paramInt);
    this.a.c(Collections.singleton(Long.valueOf(paramLong)), false);
    if ((!paramBoolean) && (com.viber.voip.memberid.d.c()))
      this.f.a(true, localArrayList);
  }

  private void a(h paramh)
  {
    paramh.h(33);
    MessageEntity localMessageEntity = this.c.s(paramh.getId());
    if ((localMessageEntity != null) && (((bs)this.b.get()).a(paramh.getId(), paramh.j(), localMessageEntity.getMessageToken(), localMessageEntity.getMessageGlobalId(), paramh.k())))
    {
      g.a(ViberApplication.getApplication()).a(paramh.getId());
      this.a.a(Collections.singleton(Long.valueOf(paramh.getId())), paramh.j(), true);
    }
  }

  private void a(ChatUserInfo[] paramArrayOfChatUserInfo, int paramInt)
  {
    com.viber.provider.b localb = com.viber.provider.messages.b.d.a(ViberApplication.getApplication());
    HashSet localHashSet1 = new HashSet(paramArrayOfChatUserInfo.length);
    HashSet localHashSet2 = new HashSet(paramArrayOfChatUserInfo.length);
    int j = paramArrayOfChatUserInfo.length;
    int k = 0;
    ChatUserInfo localChatUserInfo;
    List localList;
    com.viber.voip.model.entity.m localm1;
    com.viber.voip.model.entity.m localm2;
    if (k < j)
    {
      localChatUserInfo = paramArrayOfChatUserInfo[k];
      if (localChatUserInfo == null);
      while (TextUtils.isEmpty(localChatUserInfo.getMID()))
      {
        k++;
        break;
      }
      localHashSet1.add(localChatUserInfo.getMID());
      HashSet localHashSet3 = new HashSet();
      localHashSet3.add(localChatUserInfo.getMID());
      localHashSet3.add(localChatUserInfo.getEncryptedPhoneNumber());
      localList = this.d.b(paramInt, localHashSet3);
      if (localList.size() > 1)
      {
        localm1 = (com.viber.voip.model.entity.m)localList.get(0);
        Iterator localIterator1 = localList.iterator();
        do
        {
          if (!localIterator1.hasNext())
            break;
          localm2 = (com.viber.voip.model.entity.m)localIterator1.next();
        }
        while (!localm2.a().equals(localChatUserInfo.getMID()));
      }
    }
    while (true)
    {
      ContentValues localContentValues2 = new ContentValues(2);
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
      {
        com.viber.voip.model.entity.m localm3 = (com.viber.voip.model.entity.m)localIterator2.next();
        if (localm3.a().equals(localChatUserInfo.getEncryptedPhoneNumber()))
        {
          this.c.c(localm3);
          this.a.a(localm3);
          localContentValues2.put("active", Integer.valueOf(1));
          localContentValues2.put("participant_info_id", Long.valueOf(localm2.getId()));
          String[] arrayOfString2 = new String[1];
          arrayOfString2[0] = String.valueOf(localm3.getId());
          localb.a("participants", localContentValues2, "participant_info_id=?", arrayOfString2);
        }
      }
      ContentValues localContentValues1 = new ContentValues(3);
      if (paramInt == 2)
      {
        localContentValues1.put("encrypted_member_id", localChatUserInfo.getEncryptedPhoneNumber());
        label368: localContentValues1.put("member_id", localChatUserInfo.getMID());
        if (!com.viber.voip.memberid.d.c())
          localContentValues1.put("number", localChatUserInfo.getMID());
        if (paramInt != 2)
          break label531;
      }
      label531: for (String str1 = "encrypted_member_id"; ; str1 = "encrypted_number")
      {
        String str2 = "(member_id=? OR " + str1 + "=?) AND " + "participant_type" + "=?";
        String[] arrayOfString1 = new String[3];
        arrayOfString1[0] = localChatUserInfo.getMID();
        arrayOfString1[1] = localChatUserInfo.getEncryptedPhoneNumber();
        arrayOfString1[2] = String.valueOf(paramInt);
        if (localb.a("participants_info", localContentValues1, str2, arrayOfString1) <= 0)
          break;
        localHashSet2.add(localChatUserInfo.getMID());
        break;
        localContentValues1.put("encrypted_number", localChatUserInfo.getEncryptedPhoneNumber());
        break label368;
      }
      if (!localHashSet2.isEmpty())
        this.a.a(this.d.b(localHashSet2), false);
      this.f.a(localHashSet1);
      return;
      localm2 = localm1;
    }
  }

  private boolean a(ChatUserInfo[] paramArrayOfChatUserInfo)
  {
    int j = paramArrayOfChatUserInfo.length;
    for (int k = 0; k < j; k++)
    {
      ChatUserInfo localChatUserInfo = paramArrayOfChatUserInfo[k];
      if ((localChatUserInfo != null) && (TextUtils.isEmpty(localChatUserInfo.getEncryptedPhoneNumber())))
        return false;
    }
    return true;
  }

  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (com.viber.voip.messages.m.b(paramInt1));
    for (l locall = this.e.a(paramLong, paramInt2, ((bs)this.b.get()).a()); ; locall = this.e.a(paramLong))
    {
      if ((locall != null) && (locall.e() != paramInt2))
      {
        locall.a(paramInt2, paramInt2);
        this.c.b(locall);
      }
      return;
    }
  }

  public void a(long paramLong, int paramInt1, int paramInt2, ChatUserInfo[] paramArrayOfChatUserInfo)
    throws com.viber.voip.publicaccount.c.a
  {
    boolean bool;
    a[] arrayOfa;
    if (((com.viber.voip.messages.m.a(paramInt1)) && (cd.f(paramInt2))) || ((com.viber.voip.messages.m.b(paramInt1)) && (!cd.c(paramInt2))))
    {
      bool = true;
      if ((!bool) && (a(paramArrayOfChatUserInfo)))
        a(paramArrayOfChatUserInfo, cd.j(paramInt1));
      arrayOfa = new a[paramArrayOfChatUserInfo.length];
    }
    label131: label263: label273: for (int j = 0; ; j++)
    {
      if (j >= paramArrayOfChatUserInfo.length)
        break label279;
      ChatUserInfo localChatUserInfo = paramArrayOfChatUserInfo[j];
      if (localChatUserInfo != null)
      {
        String str1 = localChatUserInfo.getClientName();
        String str2;
        label103: Uri localUri;
        String str3;
        String str4;
        label146: String str5;
        if (bool)
        {
          str2 = null;
          localUri = dx.a(localChatUserInfo.getDownloadID());
          if (!TextUtils.isEmpty(localChatUserInfo.getEncryptedPhoneNumber()))
            break label243;
          str3 = localChatUserInfo.getPhoneNumber();
          if (!TextUtils.isEmpty(localChatUserInfo.getMID()))
            break label253;
          str4 = str3;
          if (!com.viber.voip.messages.m.b(paramInt1))
            break label263;
          str5 = null;
        }
        for (String str6 = str3; ; str6 = null)
        {
          arrayOfa[j] = new a(new Member(str4, str2, localUri, str1, null, str5, str6), localChatUserInfo.getGroupRole());
          if ((bool) || (ce.l.matcher(str2).matches()))
            break label273;
          throw new com.viber.voip.publicaccount.c.a("Invalid phone numbers format. Phone numbers are encrypted but role is not watcher");
          bool = false;
          break;
          str2 = localChatUserInfo.getPhoneNumber();
          break label103;
          label243: str3 = localChatUserInfo.getEncryptedPhoneNumber();
          break label131;
          label253: str4 = localChatUserInfo.getMID();
          break label146;
          str5 = str3;
        }
      }
    }
    label279: a(paramLong, paramInt1, paramInt2);
    a(paramLong, paramInt1, bool, arrayOfa);
  }

  public void a(long paramLong, int paramInt1, int paramInt2, a[] paramArrayOfa)
  {
    a(paramLong, paramInt1, paramInt2);
    a(paramLong, paramInt1, false, paramArrayOfa);
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    this.c.a(paramLong1, paramInt);
    this.a.d(paramLong2, paramInt);
  }

  public void a(long paramLong, a[] paramArrayOfa)
  {
    a(paramLong, 4, false, paramArrayOfa);
  }

  public void a(PublicAccountInfo paramPublicAccountInfo)
  {
    Uri localUri = dx.g(paramPublicAccountInfo.getIconDownloadID());
    String str = paramPublicAccountInfo.getPublicAccountID();
    Member localMember = new Member(str, str, localUri, paramPublicAccountInfo.getGroupName(), null);
    this.f.a(localMember);
  }

  public boolean a(h paramh, int paramInt, Member paramMember, boolean paramBoolean)
  {
    if (paramh == null)
      return false;
    boolean bool1 = com.viber.voip.messages.m.a(this.g, paramMember.getId());
    Set localSet = Collections.singleton(Long.valueOf(paramh.getId()));
    if ((av.d(paramInt, 16)) && (bool1))
    {
      this.c.g(paramh.getId());
      this.c.h(localSet);
      this.c.d(paramh.j());
      this.h.post(new d.d(paramh.j()));
      this.a.b(localSet, paramh.j(), false);
      return false;
    }
    int j;
    l locall;
    label202: label235: boolean bool2;
    if (paramBoolean)
    {
      j = 2;
      if (!bool1)
        break label376;
      locall = this.e.a(paramh.getId());
      paramh.c(3);
      paramh.f(0);
      if (com.viber.voip.messages.m.b(paramh.j()))
      {
        com.viber.voip.messages.m.a(paramh, -1, 3);
        a(paramh);
      }
      paramh.g(6);
      this.c.b(paramh);
      if (!paramh.c())
        break label324;
      this.c.M(paramh.getId());
      this.h.post(new d.d(paramh.j()));
      this.a.a(localSet, paramh.j(), false, false);
      if ((!paramBoolean) || (locall != null))
        break label396;
      com.viber.voip.model.entity.m localm = this.d.a(paramMember, cd.j(paramh.j()));
      this.e.a(paramh.getId(), j, 3, localm.getId());
      bool2 = true;
    }
    while (true)
    {
      if (bool2)
      {
        this.c.f(paramh.getId(), paramh.j());
        this.a.c(localSet, false);
      }
      return bool2;
      j = 1;
      break;
      label324: if (!paramh.d())
        break label202;
      r localr = this.c.d(paramh.k());
      if ((localr == null) || (!localr.B()))
        break label202;
      localr.b(false);
      this.c.b(localr);
      break label202;
      label376: locall = this.e.a(paramh.getId(), paramMember.getId());
      break label235;
      label396: if ((locall != null) && (locall.d() != j))
      {
        locall.a(3, 3);
        if ((!bool1) || (paramh.e()))
          locall.a(j);
        bool2 = this.c.b(locall);
      }
      else
      {
        bool2 = false;
      }
    }
  }

  public boolean a(h paramh, int paramInt, String paramString)
  {
    return a(paramh, paramInt, new Member(paramString), false);
  }

  public static class a
  {
    final Member a;
    final int b;

    public a(Member paramMember, int paramInt)
    {
      this.a = paramMember;
      this.b = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.d.j
 * JD-Core Version:    0.6.2
 */