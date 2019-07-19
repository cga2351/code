package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGetUserDetailsV2;
import com.viber.jni.im2.CGetUsersDetailsV2Msg;
import com.viber.jni.im2.CGetUsersDetailsV2ReplyMsg;
import com.viber.jni.im2.CGetUsersDetailsV2ReplyMsg.Receiver;
import com.viber.jni.im2.CLoginReplyMsg;
import com.viber.jni.im2.CLoginReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.model.a.d.a;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.bh;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ar;
import com.viber.voip.util.cd;
import com.viber.voip.util.ce;
import com.viber.voip.util.dx;
import com.viber.voip.util.n;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.util.upload.q;
import com.viber.voip.util.upload.r;
import com.viber.voip.util.upload.t;
import com.viber.voip.util.upload.t.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ak extends l
  implements CGetUsersDetailsV2ReplyMsg.Receiver, CLoginReplyMsg.Receiver, ci
{
  private static final Logger d = ViberEnv.getLogger();
  private final UserData e;
  private Map<Integer, ci.a> f = Collections.synchronizedMap(new HashMap());
  private com.viber.voip.messages.controller.manager.ak g;
  private ar<String, com.viber.voip.model.entity.m> h;
  private final Set<String> i = new HashSet();

  public ak(Context paramContext)
  {
    super(paramContext, UserManager.from(paramContext).getRegistrationValues());
    this.e = UserManager.from(paramContext).getUserData();
    this.g = com.viber.voip.messages.controller.manager.ak.a();
    this.h = new ar(30000L);
  }

  private Set<com.viber.voip.model.entity.m> a(Set<CGetUserDetailsV2> paramSet, Set<String> paramSet1)
  {
    HashMap localHashMap = new HashMap(paramSet.size());
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      CGetUserDetailsV2 localCGetUserDetailsV2 = (CGetUserDetailsV2)localIterator.next();
      Member localMember1 = Member.from(localCGetUserDetailsV2);
      boolean bool = cd.c(localCGetUserDetailsV2.mid);
      Member localMember2;
      com.viber.voip.model.entity.m localm1;
      if (bool)
      {
        com.viber.voip.model.entity.m localm2 = this.g.a(localMember1, 2);
        localHashMap.put(localm2, new Member(localm2.a(), localm2.getNumber(), localMember1.getPhotoUri(), localMember1.getViberName(), localm2.c(), localm2.d(), localm2.b()));
        if (paramSet1.contains(localCGetUserDetailsV2.mid))
        {
          com.viber.voip.model.entity.m localm3 = this.g.a(localMember1, 1);
          localMember2 = new Member(localm3.a(), localm3.getNumber(), localMember1.getPhotoUri(), localMember1.getViberName(), localm3.c(), localm3.d(), localm3.b());
          localm1 = localm3;
        }
      }
      else
      {
        while (true)
        {
          localHashMap.put(localm1, localMember2);
          if ((!bool) && (!TextUtils.isEmpty(localm1.getNumber())))
            this.h.put(localm1.getNumber(), localm1);
          String str = localm1.a();
          if ((bool) || (TextUtils.isEmpty(str)))
            break;
          this.h.put(str, localm1);
          break;
          localm1 = this.g.a(localMember1, 1);
          localMember2 = localMember1;
        }
      }
    }
    return com.viber.voip.messages.d.c.c().a(localHashMap);
  }

  private Set<com.viber.voip.model.entity.m> a(CGetUserDetailsV2[] paramArrayOfCGetUserDetailsV2, ci.a parama)
  {
    HashSet localHashSet1 = new HashSet(paramArrayOfCGetUserDetailsV2.length);
    HashSet localHashSet2 = new HashSet(paramArrayOfCGetUserDetailsV2.length);
    HashSet localHashSet3 = new HashSet(paramArrayOfCGetUserDetailsV2.length);
    HashSet localHashSet4 = new HashSet(paramArrayOfCGetUserDetailsV2.length);
    HashSet localHashSet5 = new HashSet(paramArrayOfCGetUserDetailsV2.length);
    HashSet localHashSet6 = new HashSet(paramArrayOfCGetUserDetailsV2.length);
    int j = paramArrayOfCGetUserDetailsV2.length;
    int k = 0;
    Set localSet1 = null;
    Set localSet2 = null;
    if (k < j)
    {
      CGetUserDetailsV2 localCGetUserDetailsV2 = paramArrayOfCGetUserDetailsV2[k];
      boolean bool1 = cd.c(localCGetUserDetailsV2.mid);
      label168: Uri localUri;
      label208: String str1;
      if (bool1)
      {
        if (localSet2 == null)
        {
          localSet2 = com.viber.voip.model.e.a("user_details_by_encrypted_memberid_for_anonymous");
          localSet1 = com.viber.voip.model.e.a("user_details_by_encrypted_memberid_for_community");
        }
        if ((localSet2.contains(localCGetUserDetailsV2.mid)) || (this.i.contains(localCGetUserDetailsV2.mid)))
        {
          localHashSet5.add(localCGetUserDetailsV2.mid);
          int i3 = localCGetUserDetailsV2.status;
          localUri = null;
          switch (i3)
          {
          case 2:
          default:
            str1 = localCGetUserDetailsV2.downloadID;
            if (!bool1)
              break;
          case 1:
          case 3:
          }
        }
      }
      for (String str2 = localCGetUserDetailsV2.mid; ; str2 = null)
      {
        cd.a(str1, str2, "UserDataDelegate [onGetUsersDetailStatusOk] status=" + localCGetUserDetailsV2.status, localUri);
        k++;
        break;
        if (!localSet1.contains(localCGetUserDetailsV2.mid))
          break label168;
        localHashSet6.add(localCGetUserDetailsV2.mid);
        break label168;
        localHashSet3.add(localCGetUserDetailsV2.mid);
        localHashSet4.add(localCGetUserDetailsV2.phoneNumber);
        break label168;
        localHashSet1.add(localCGetUserDetailsV2);
        boolean bool2 = localCGetUserDetailsV2.mid.equals(this.c.l());
        localUri = null;
        if (!bool2)
          break label208;
        localUri = dx.a(localCGetUserDetailsV2.downloadID);
        this.e.setUserData(localCGetUserDetailsV2.name, localUri);
        break label208;
        localUri = null;
        if (bool1)
          break label208;
        a(localCGetUserDetailsV2, localHashSet2);
        localUri = null;
        break label208;
      }
    }
    Set localSet3 = a(localHashSet1, localHashSet5);
    if (localHashSet2.size() > 0)
      b(localHashSet2, parama, false);
    int m = localHashSet3.size();
    int n = localHashSet4.size();
    int i1 = localHashSet5.size();
    int i2 = localHashSet6.size();
    if (((m > 0) && (n > 0)) || (i1 > 0) || (i2 > 0))
      a((String[])localHashSet3.toArray(new String[m]), (String[])localHashSet4.toArray(new String[n]), (String[])localHashSet5.toArray(new String[i1]), (String[])localHashSet6.toArray(new String[i2]));
    return localSet3;
  }

  private void a()
  {
    Set localSet1 = com.viber.voip.model.e.a("user_details_by_memberid");
    Iterator localIterator = localSet1.iterator();
    while (localIterator.hasNext())
      if (cd.c((String)localIterator.next()))
        localIterator.remove();
    if (localSet1.size() > 0)
      a(localSet1, null, false);
    Set localSet2 = com.viber.voip.model.e.a("user_details_by_phone");
    if (localSet2.size() > 0)
      b(localSet2, null, false);
    Set localSet3 = com.viber.voip.model.e.a("user_details_by_encrypted_memberid_for_community");
    if (localSet3.size() > 0)
      a(localSet3, null, false, true, false);
    Set localSet4 = com.viber.voip.model.e.a("user_details_by_encrypted_memberid_for_anonymous");
    if (localSet4.size() > 0)
      a(localSet4, null, true, true, false);
  }

  private void a(final Uri paramUri, final b paramb)
  {
    Uri localUri = com.viber.voip.messages.extras.image.c.a(this.a, paramUri);
    if (localUri == null)
    {
      paramb.a(null);
      return;
    }
    t.a(localUri, paramUri, new q()
    {
      public void a(Uri paramAnonymousUri, r paramAnonymousr)
      {
        paramb.a(paramAnonymousr.a, paramUri);
      }

      public void a(Uri paramAnonymousUri, t.c paramAnonymousc)
      {
        paramb.a(null);
      }
    });
  }

  private void a(Engine paramEngine, a parama, String[] paramArrayOfString, ci.a parama1)
  {
    if (paramArrayOfString.length < 150)
      b(paramEngine, parama, paramArrayOfString, parama1);
    while (true)
    {
      return;
      String[][] arrayOfString = a(paramArrayOfString, 149);
      int j = arrayOfString.length;
      for (int k = 0; k < j; k++)
        b(paramEngine, parama, arrayOfString[k], parama1);
    }
  }

  private void a(CGetUserDetailsV2 paramCGetUserDetailsV2, Set<String> paramSet)
  {
    Member localMember;
    com.viber.voip.model.entity.m localm;
    if (!TextUtils.isEmpty(paramCGetUserDetailsV2.mid))
    {
      localMember = Member.from(paramCGetUserDetailsV2);
      localm = this.g.c(localMember, 1);
      if (localm != null)
        break label32;
    }
    label32: 
    do
    {
      return;
      if (ce.l.matcher(paramCGetUserDetailsV2.mid).matches())
      {
        if (localm.s())
        {
          localm.c(localMember.getId());
          this.g.b(localm);
        }
        paramSet.add(localm.getNumber());
        return;
      }
    }
    while (!localm.s());
    this.g.b(localm);
    this.g.b(localm);
  }

  private void a(String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
    int j = paramArrayOfString.length;
    for (int k = 0; k < j; k++)
      localArrayList.add(d.a.a(paramString, paramArrayOfString[k], ""));
    com.viber.voip.model.e.a(localArrayList);
  }

  private void a(Set<String> paramSet, ci.a parama, boolean paramBoolean, a parama1)
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    paramSet.remove(null);
    paramSet.remove("");
    Iterator localIterator1 = paramSet.iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      if ((com.viber.voip.messages.m.a(str)) || (cd.b(str)) || (com.viber.voip.messages.m.b(str)) || ("Viber".equals(str)))
        localIterator1.remove();
    }
    if (paramSet.size() == 0)
      if (parama != null)
        parama.onGetUserError();
    do
    {
      List localList;
      do
      {
        do
          return;
        while (a(paramSet, parama));
        if (!paramBoolean)
          break label327;
        HashSet localHashSet = new HashSet(paramSet);
        localList = parama1.a(localHashSet);
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
        {
          com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)localIterator2.next();
          if (!localm.s())
          {
            localHashSet.remove(localm.a());
            localHashSet.remove(localm.getNumber());
            localHashSet.remove(localm.b());
          }
        }
        if (localHashSet.size() > 0)
        {
          a(localEngine, parama1, (String[])paramSet.toArray(new String[paramSet.size()]), parama);
          return;
        }
        if (localList.size() <= 0)
          break;
      }
      while (parama == null);
      parama.onGetUserDetail((com.viber.voip.model.entity.m[])localList.toArray(new com.viber.voip.model.entity.m[localList.size()]));
      return;
    }
    while (parama == null);
    parama.onGetUserError();
    return;
    label327: a(localEngine, parama1, (String[])paramSet.toArray(new String[paramSet.size()]), parama);
  }

  private void a(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    if (!n.a(paramArrayOfString1))
      com.viber.voip.model.e.a("user_details_by_memberid", paramArrayOfString1);
    if (!n.a(paramArrayOfString2))
      com.viber.voip.model.e.a("user_details_by_phone", paramArrayOfString2);
    if (!n.a(paramArrayOfString3))
    {
      com.viber.voip.model.e.a("user_details_by_encrypted_memberid_for_anonymous", paramArrayOfString3);
      this.i.removeAll(Arrays.asList(paramArrayOfString3));
    }
    if (!n.a(paramArrayOfString4))
      com.viber.voip.model.e.a("user_details_by_encrypted_memberid_for_community", paramArrayOfString4);
  }

  private boolean a(Set<String> paramSet, ci.a parama)
  {
    ArrayList localArrayList = null;
    Iterator localIterator = paramSet.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        break label121;
      String str = (String)localIterator.next();
      com.viber.voip.model.entity.m localm = (com.viber.voip.model.entity.m)this.h.get(str);
      if (localm == null)
        break;
      if (localArrayList == null)
        localArrayList = new ArrayList(paramSet.size());
      localArrayList.add(localm);
    }
    label121: for (int j = 0; ; j = 1)
    {
      if ((j != 0) && (parama != null))
      {
        parama.onGetUserDetail((com.viber.voip.model.entity.m[])localArrayList.toArray(new com.viber.voip.model.entity.m[localArrayList.size()]));
        return true;
      }
      return false;
    }
  }

  private static String[][] a(String[] paramArrayOfString, int paramInt)
  {
    int j = (int)Math.ceil(paramArrayOfString.length / paramInt);
    String[][] arrayOfString; = new String[j][];
    for (int k = 0; k < j; k++)
    {
      int m = k * paramInt;
      int n = Math.min(paramArrayOfString.length - m, paramInt);
      String[] arrayOfString = new String[n];
      System.arraycopy(paramArrayOfString, m, arrayOfString, 0, n);
      arrayOfString;[k] = arrayOfString;
    }
    return arrayOfString;;
  }

  private void b(Engine paramEngine, a parama, String[] paramArrayOfString, ci.a parama1)
  {
    int j = paramEngine.getPhoneController().generateSequence();
    this.f.put(Integer.valueOf(j), parama1);
    String str = parama.a();
    if (!TextUtils.isEmpty(str))
      a(str, paramArrayOfString);
    parama.a(j, paramEngine.getExchanger(), paramArrayOfString);
  }

  public void a(Uri paramUri)
  {
    Uri localUri = this.e.getImage();
    this.e.setPhotoUploadedToServer(false);
    this.e.setImage(paramUri);
    this.e.notifyOwnerChange();
    com.viber.voip.util.e.e.a(ViberApplication.getApplication()).b(localUri);
    if (paramUri != null)
      a(paramUri, new b()
      {
        public void a(Uri paramAnonymousUri)
        {
        }

        public void a(ObjectId paramAnonymousObjectId, Uri paramAnonymousUri)
        {
          ak.this.b.getPhoneController().handleUpdateUserPhoto(paramAnonymousObjectId.toLong());
        }
      });
    while (paramUri != null)
      return;
    this.b.getPhoneController().handleUpdateUserPhoto(0L);
  }

  public void a(Engine paramEngine)
  {
    super.a(paramEngine);
    Handler localHandler = av.a(av.e.d);
    paramEngine.getExchanger().registerDelegate(this, localHandler);
  }

  public void a(String paramString)
  {
    this.e.setName(paramString);
    this.e.notifyOwnerChange();
    this.e.setNameUploadedToServer(false);
    this.b.getPhoneController().handleUpdateUserName(paramString);
  }

  public void a(String paramString, ci.a parama, boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(paramString);
    a(localHashSet, parama, paramBoolean);
  }

  public void a(Set<String> paramSet, ci.a parama, boolean paramBoolean)
  {
    a(paramSet, parama, paramBoolean, new a()
    {
      public String a()
      {
        return "user_details_by_memberid";
      }

      public List<com.viber.voip.model.entity.m> a(Set<String> paramAnonymousSet)
      {
        return ak.a(ak.this).b(paramAnonymousSet);
      }

      public void a(int paramAnonymousInt, Im2Exchanger paramAnonymousIm2Exchanger, String[] paramAnonymousArrayOfString)
      {
        paramAnonymousIm2Exchanger.handleCGetUsersDetailsV2Msg(new CGetUsersDetailsV2Msg(paramAnonymousArrayOfString, 1, paramAnonymousInt));
      }
    });
  }

  public void a(Set<String> paramSet, ci.a parama, final boolean paramBoolean1, final boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramSet, parama, paramBoolean3, new a()
    {
      public String a()
      {
        if (paramBoolean2)
        {
          if (paramBoolean1)
            return "user_details_by_encrypted_memberid_for_anonymous";
          return "user_details_by_encrypted_memberid_for_community";
        }
        return null;
      }

      public List<com.viber.voip.model.entity.m> a(Set<String> paramAnonymousSet)
      {
        com.viber.voip.messages.controller.manager.ak localak = ak.a(ak.this);
        if (paramBoolean1);
        for (int i = 1; ; i = 2)
          return localak.c(i, paramAnonymousSet);
      }

      public void a(int paramAnonymousInt, Im2Exchanger paramAnonymousIm2Exchanger, String[] paramAnonymousArrayOfString)
      {
        if ((!paramBoolean2) && (paramBoolean1))
          ak.b(ak.this).addAll(Arrays.asList(paramAnonymousArrayOfString));
        paramAnonymousIm2Exchanger.handleCGetUsersDetailsV2Msg(new CGetUsersDetailsV2Msg(paramAnonymousArrayOfString, 1, paramAnonymousInt));
      }
    });
  }

  public void b(String paramString, ci.a parama, boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(paramString);
    b(localHashSet, parama, paramBoolean);
  }

  public void b(Set<String> paramSet, ci.a parama, boolean paramBoolean)
  {
    a(paramSet, parama, paramBoolean, new a()
    {
      public String a()
      {
        return "user_details_by_phone";
      }

      public List<com.viber.voip.model.entity.m> a(Set<String> paramAnonymousSet)
      {
        return ak.a(ak.this).a(paramAnonymousSet);
      }

      public void a(int paramAnonymousInt, Im2Exchanger paramAnonymousIm2Exchanger, String[] paramAnonymousArrayOfString)
      {
        paramAnonymousIm2Exchanger.handleCGetUsersDetailsV2Msg(new CGetUsersDetailsV2Msg(paramAnonymousArrayOfString, 0, paramAnonymousInt));
      }
    });
  }

  public void onCGetUsersDetailsV2ReplyMsg(CGetUsersDetailsV2ReplyMsg paramCGetUsersDetailsV2ReplyMsg)
  {
    ci.a locala = (ci.a)this.f.remove(Integer.valueOf(paramCGetUsersDetailsV2ReplyMsg.seq));
    int j = paramCGetUsersDetailsV2ReplyMsg.status;
    Set localSet = null;
    switch (j)
    {
    default:
    case 0:
    }
    while (true)
    {
      com.viber.provider.b localb;
      if (locala == null)
      {
        return;
        localb = com.viber.voip.messages.controller.manager.ak.f();
        localb.a();
      }
      try
      {
        localSet = a(paramCGetUsersDetailsV2ReplyMsg.usersDetails, locala);
        localb.c();
        localb.b();
      }
      finally
      {
        localb.b();
      }
    }
    if (localSet.size() > 0)
    {
      locala.onGetUserDetail((com.viber.voip.model.entity.m[])localSet.toArray(new com.viber.voip.model.entity.m[localSet.size()]));
      return;
    }
    locala.onGetUserError();
  }

  public void onCLoginReplyMsg(CLoginReplyMsg paramCLoginReplyMsg)
  {
    if (paramCLoginReplyMsg.loginStatus != 0);
    com.viber.voip.model.entity.m localm;
    do
    {
      return;
      this.c.a(paramCLoginReplyMsg.memberId);
      this.c.b(paramCLoginReplyMsg.pGEncryptedPhoneNumber);
      this.c.d(paramCLoginReplyMsg.encryptedPhoneNumber);
      this.c.c(paramCLoginReplyMsg.encryptedMemberID);
      d.bh.b.a(paramCLoginReplyMsg.vlnSubscription.booleanValue());
      localm = this.g.b();
    }
    while ((TextUtils.equals(paramCLoginReplyMsg.memberId, localm.a())) && (TextUtils.equals(paramCLoginReplyMsg.pGEncryptedPhoneNumber, localm.d())) && (TextUtils.equals(paramCLoginReplyMsg.encryptedMemberID, localm.b())));
    localm.d(paramCLoginReplyMsg.memberId);
    localm.e(paramCLoginReplyMsg.pGEncryptedPhoneNumber);
    localm.a(paramCLoginReplyMsg.encryptedMemberID);
    this.g.b(localm);
    o.a().a(Collections.singletonList(localm), false);
  }

  public void onServiceStateChanged(int paramInt)
  {
    if (paramInt == ServiceStateDelegate.ServiceState.SERVICE_CONNECTED.ordinal())
    {
      a();
      if (!this.e.isUserPhotoUploadedToServer())
        a(this.e.getImage());
      if (!this.e.isUserNameUploadedToServer())
        a(this.e.getViberName());
    }
  }

  public boolean onUpdateUnsavedContactDetails(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    com.viber.voip.model.entity.m localm = this.g.c(new Member(paramString1), 1);
    int j;
    int k;
    label43: int m;
    label53: String str1;
    label68: Uri localUri;
    if (localm != null)
    {
      if ((paramInt & 0x1) == 0)
        break label175;
      j = 1;
      if ((paramInt & 0x2) == 0)
        break label181;
      k = 1;
      if ((paramInt & 0x4) == 0)
        break label187;
      m = 1;
      if (m == 0)
        break label193;
      str1 = PhoneNumberUtils.stringFromStringAndTOA(paramString4, 145);
      if (j == 0)
        break label203;
      localUri = dx.a(paramString3);
      label80: if (k == 0)
        break label213;
    }
    label175: label181: label187: label193: label203: label213: for (String str2 = paramString2; ; str2 = localm.getViberName())
    {
      Member localMember = new Member(paramString1, str1, localUri, str2, localm.c(), localm.d(), localm.b());
      com.viber.voip.messages.d.c.c().a(Collections.singletonMap(localm, localMember));
      if (j != 0)
        cd.a(paramString3, localMember.getEncryptedMemberId(), "UserDataDelegate [onUpdateUnsavedContactDetails]", localMember.getPhotoUri());
      this.b.getPhoneController().handleSendUpdateUnsavedContactDetailsAck(paramLong);
      return false;
      j = 0;
      break;
      k = 0;
      break label43;
      m = 0;
      break label53;
      str1 = localm.getNumber();
      break label68;
      localUri = localm.f();
      break label80;
    }
  }

  public void onUpdateUserName(int paramInt)
  {
    if (paramInt == 1)
      this.e.setNameUploadedToServer(true);
  }

  public void onUpdateUserPhoto(int paramInt)
  {
    if (paramInt == 1)
      this.e.setPhotoUploadedToServer(true);
  }

  private static abstract interface a
  {
    public abstract String a();

    public abstract List<com.viber.voip.model.entity.m> a(Set<String> paramSet);

    public abstract void a(int paramInt, Im2Exchanger paramIm2Exchanger, String[] paramArrayOfString);
  }

  public static abstract interface b
  {
    public abstract void a(Uri paramUri);

    public abstract void a(ObjectId paramObjectId, Uri paramUri);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.ak
 * JD-Core Version:    0.6.2
 */