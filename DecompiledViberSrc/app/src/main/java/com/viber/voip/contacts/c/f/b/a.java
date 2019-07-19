package com.viber.voip.contacts.c.f.b;

import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.im2.CAddressBookDeltaUpdateAckMsg;
import com.viber.jni.im2.CAddressBookDeltaUpdateV2Msg;
import com.viber.jni.im2.CAddressBookDeltaUpdateV2Msg.Receiver;
import com.viber.jni.im2.CAddressBookEntryV2;
import com.viber.jni.im2.CAddressBookForSecondaryAckMsg;
import com.viber.jni.im2.CAddressBookForSecondaryV2Msg;
import com.viber.jni.im2.CAddressBookForSecondaryV2Msg.Receiver;
import com.viber.jni.im2.CMoreUserInfo;
import com.viber.jni.im2.CRegisteredContactInfo;
import com.viber.jni.im2.CRegisteredContactsMsg;
import com.viber.jni.im2.CRegisteredContactsMsg.Receiver;
import com.viber.jni.im2.CRegisteredNumbersAckMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.memberid.d;
import com.viber.voip.util.dx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a extends PhoneControllerDelegateAdapter
  implements CAddressBookDeltaUpdateV2Msg.Receiver, CAddressBookForSecondaryV2Msg.Receiver, CRegisteredContactsMsg.Receiver
{
  private static final Logger e = ViberEnv.getLogger();
  protected final Context a;
  protected final ViberApplication b;
  protected final Engine c;
  protected final Handler d;
  private d f;
  private b g;

  a(Context paramContext, ViberApplication paramViberApplication, Handler paramHandler)
  {
    this.a = paramContext;
    this.b = paramViberApplication;
    this.d = paramHandler;
    this.c = paramViberApplication.getEngine(false);
    this.c.getExchanger().registerDelegate(this, paramHandler);
  }

  private void b(d paramd)
  {
    a(paramd);
    Iterator localIterator = paramd.h().iterator();
    while (localIterator.hasNext())
    {
      a.d.a locala = (a.d.a)localIterator.next();
      if (locala.d != 0L)
        this.c.getExchanger().handleCRegisteredNumbersAckMsg(new CRegisteredNumbersAckMsg(locala.d));
    }
  }

  private void c(d paramd)
  {
    Iterator localIterator = paramd.h().iterator();
    while (localIterator.hasNext())
    {
      a.d.a locala = (a.d.a)localIterator.next();
      this.c.getExchanger().handleCAddressBookForSecondaryAckMsg(new CAddressBookForSecondaryAckMsg((short)locala.c, locala.e, locala.b));
    }
  }

  public abstract void a(b paramb, int paramInt);

  public abstract void a(b paramb, String[] paramArrayOfString, int paramInt);

  public abstract void a(d paramd);

  public void onCAddressBookDeltaUpdateV2Msg(CAddressBookDeltaUpdateV2Msg paramCAddressBookDeltaUpdateV2Msg)
  {
    b localb = new b(true);
    localb.a(paramCAddressBookDeltaUpdateV2Msg.revision, 0, 0, false, false, 0, paramCAddressBookDeltaUpdateV2Msg.newPhones);
    localb.a(paramCAddressBookDeltaUpdateV2Msg.revision, 0, 0, false, true, 0, paramCAddressBookDeltaUpdateV2Msg.changedPhones);
    a(localb, paramCAddressBookDeltaUpdateV2Msg.deletedPhones, paramCAddressBookDeltaUpdateV2Msg.revision);
    this.c.getExchanger().handleCAddressBookDeltaUpdateAckMsg(new CAddressBookDeltaUpdateAckMsg(paramCAddressBookDeltaUpdateV2Msg.messageToken, paramCAddressBookDeltaUpdateV2Msg.revision));
  }

  public void onCAddressBookForSecondaryV2Msg(CAddressBookForSecondaryV2Msg paramCAddressBookForSecondaryV2Msg)
  {
    if ((this.g == null) || (paramCAddressBookForSecondaryV2Msg.clearAll));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        this.g = new b(false);
      this.g.a(paramCAddressBookForSecondaryV2Msg.genNum, 0, paramCAddressBookForSecondaryV2Msg.seq, paramCAddressBookForSecondaryV2Msg.clearAll, paramCAddressBookForSecondaryV2Msg.lastMsg, 0, paramCAddressBookForSecondaryV2Msg.addressBookList);
      if (paramCAddressBookForSecondaryV2Msg.lastMsg)
      {
        a(this.g, paramCAddressBookForSecondaryV2Msg.genNum);
        c(this.g);
        this.g = null;
      }
      return;
    }
  }

  public void onCRegisteredContactsMsg(CRegisteredContactsMsg paramCRegisteredContactsMsg)
  {
    if ((this.f == null) || (paramCRegisteredContactsMsg.clearAll));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        this.f = new d();
      if ((this.f.g()) && (!paramCRegisteredContactsMsg.clearAll))
      {
        this.f.e();
        b(this.f);
        this.f = new d();
      }
      this.f.a(0, paramCRegisteredContactsMsg.seq, 0, paramCRegisteredContactsMsg.clearAll, paramCRegisteredContactsMsg.lastMsg, paramCRegisteredContactsMsg.token, paramCRegisteredContactsMsg.registeredContacts);
      if (paramCRegisteredContactsMsg.lastMsg)
      {
        b(this.f);
        this.f = null;
      }
      return;
    }
  }

  public static class a
  {
    private String a;
    private a b;

    protected a(CAddressBookEntryV2 paramCAddressBookEntryV2)
    {
      this.a = paramCAddressBookEntryV2.clientName;
      this.b = new a(paramCAddressBookEntryV2.phoneNumber, paramCAddressBookEntryV2.phoneNumber, null);
    }

    public String a()
    {
      return this.a;
    }

    public a b()
    {
      return this.b;
    }

    public String toString()
    {
      return "Client [mClientName=" + this.a + ", mPhoneNumber=" + this.b + "]";
    }

    public class a
    {
      public final String a;
      public final String b;

      private a(String paramString1, String arg3)
      {
        Object localObject;
        this.b = localObject;
        this.a = paramString1;
      }

      public String toString()
      {
        return "PhoneNumber [clientOriginalPhone=" + this.a + ", clientCanonizedPhone=" + this.b + "]";
      }
    }
  }

  public static class b extends a.d
  {
    private boolean a;
    private Map<String, a.a> b = new HashMap();
    private Map<String, String> c = new HashMap();
    private Set<String> d = new HashSet();

    protected b(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    public Map<String, String> a()
    {
      return this.c;
    }

    protected void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CAddressBookEntryV2[] paramArrayOfCAddressBookEntryV2)
    {
      super.a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4, null);
      int i = paramArrayOfCAddressBookEntryV2.length;
      for (int j = 0; j < i; j++)
      {
        CAddressBookEntryV2 localCAddressBookEntryV2 = paramArrayOfCAddressBookEntryV2[j];
        this.b.put(localCAddressBookEntryV2.phoneNumber, new a.a(localCAddressBookEntryV2));
        this.d.add(localCAddressBookEntryV2.clientName);
        this.c.put(localCAddressBookEntryV2.clientName, localCAddressBookEntryV2.clientSortName);
        if (1 == localCAddressBookEntryV2.flags)
          a(localCAddressBookEntryV2);
      }
    }

    public Map<String, a.a> b()
    {
      return this.b;
    }

    public Set<String> c()
    {
      return this.b.keySet();
    }

    public Set<String> d()
    {
      return this.d;
    }
  }

  public static class c
  {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;

    c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
    {
      if (d.c());
      while (true)
      {
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramString3;
        this.d = paramString4;
        this.f = paramInt;
        this.e = paramString5;
        return;
        paramString1 = paramString2;
      }
    }

    public static c a(CAddressBookEntryV2 paramCAddressBookEntryV2)
    {
      return new c(paramCAddressBookEntryV2.mid, paramCAddressBookEntryV2.phoneNumber, paramCAddressBookEntryV2.downloadID, paramCAddressBookEntryV2.vid, 0, a(paramCAddressBookEntryV2.moreInfo));
    }

    public static c a(CRegisteredContactInfo paramCRegisteredContactInfo)
    {
      return new c(paramCRegisteredContactInfo.mid, paramCRegisteredContactInfo.phoneNumber, paramCRegisteredContactInfo.downloadID, paramCRegisteredContactInfo.vid, paramCRegisteredContactInfo.flags, a(paramCRegisteredContactInfo.moreInfo));
    }

    private static String a(CMoreUserInfo paramCMoreUserInfo)
    {
      String str = (String)paramCMoreUserInfo.data.get(Integer.valueOf(2));
      if (str == null)
        str = "";
      return str;
    }

    public Member a(String paramString)
    {
      return new Member(this.a, this.b, dx.a(this.c), paramString, this.d, null, this.e);
    }

    public String toString()
    {
      return "ViberEntry{memberId='" + this.a + '\'' + ", phoneNumber='" + this.b + '\'' + ", downloadID='" + this.c + '\'' + ", viberId='" + this.d + '\'' + ", flags=" + this.f + ", encryptedMemberId=" + this.e + '}';
    }
  }

  public static class d
  {
    private int a;
    private boolean b;
    private boolean c;
    private final HashMap<String, a.c> d = new HashMap();
    private final List<a> e = new ArrayList();

    protected void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, long paramLong, CRegisteredContactInfo[] paramArrayOfCRegisteredContactInfo)
    {
      this.a = paramInt2;
      this.e.add(new a(paramInt1, paramInt3, paramBoolean1, paramBoolean2, paramLong));
      if (paramArrayOfCRegisteredContactInfo != null)
      {
        int i = paramArrayOfCRegisteredContactInfo.length;
        for (int j = 0; j < i; j++)
        {
          a.c localc = a.c.a(paramArrayOfCRegisteredContactInfo[j]);
          this.d.put(localc.a, localc);
        }
      }
      if (paramBoolean1)
        this.b = paramBoolean1;
      if (paramBoolean2)
        this.c = paramBoolean2;
    }

    protected void a(CAddressBookEntryV2 paramCAddressBookEntryV2)
    {
      a.c localc = a.c.a(paramCAddressBookEntryV2);
      this.d.put(localc.a, localc);
    }

    protected void e()
    {
      this.c = true;
    }

    public final Map<String, a.c> f()
    {
      return this.d;
    }

    public final boolean g()
    {
      return this.b;
    }

    public final List<a> h()
    {
      return this.e;
    }

    public long i()
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.e)
          return locala.d;
      }
      return 0L;
    }

    public final boolean j()
    {
      return this.c;
    }

    public String toString()
    {
      return "ViberNumbersPack [mClearAll=" + this.b + ", mLastPortion=" + this.c + ", mRegisteredMembers=" + this.d + ", mPackHeaders=" + this.e + "]";
    }

    public static class a
    {
      public final boolean a;
      public final int b;
      public final int c;
      public final long d;
      public final boolean e;

      protected a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
      {
        this.a = paramBoolean1;
        this.b = paramInt2;
        this.c = paramInt1;
        this.d = paramLong;
        this.e = paramBoolean2;
      }

      public String toString()
      {
        return "PackHeader [clearAll=" + this.a + ", portionSeq=" + this.b + ", genNum=" + this.c + ", token=" + this.d + ", lastPortion=" + this.e + "]";
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.b.a
 * JD-Core Version:    0.6.2
 */