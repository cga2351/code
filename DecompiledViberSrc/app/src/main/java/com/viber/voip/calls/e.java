package com.viber.voip.calls;

import android.content.Context;
import android.os.Handler;
import android.telephony.PhoneNumberUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.CountryNameInfo;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.l.h;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.j;
import com.viber.voip.contacts.c.d.j.d;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.model.Call;
import com.viber.voip.model.entity.CallEntity;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.av;
import com.viber.voip.util.da;
import com.viber.voip.util.dr;
import com.viber.voip.util.p;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.sqlite.database.sqlite.SQLiteStatement;

public class e
  implements d, f.a
{
  private static final Logger a = ViberEnv.getLogger();
  private static e b;
  private ViberApplication c;
  private f d;
  private a e;
  private j f;
  private com.viber.voip.messages.k g;
  private af h;
  private Set<d.c> i = new HashSet();

  private e(Context paramContext, ViberApplication paramViberApplication)
  {
    this.c = paramViberApplication;
    this.d = new f(paramContext, this);
    this.f = new j(paramContext);
    this.e = new a(paramContext);
    this.g = this.c.getMessagesManager();
    this.h = UserManager.from(paramContext).getRegistrationValues();
  }

  @Deprecated
  public static d a(ViberApplication paramViberApplication)
  {
    if ((b == null) && (com.viber.voip.o.a.a == com.viber.voip.o.a.a()));
    try
    {
      if (b == null)
        b = new e(ViberApplication.getApplication(), paramViberApplication);
      return b;
    }
    finally
    {
    }
  }

  private void a(final long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, String paramString3, String paramString4, final int paramInt1, boolean paramBoolean1, final int paramInt2, final boolean paramBoolean2, final int paramInt3, final int paramInt4, final long paramLong4, final long paramLong5, final int paramInt5, final boolean paramBoolean3, final ConferenceInfo paramConferenceInfo, final String paramString5, d.a parama)
  {
    final String str1;
    if (!"private_number".equals(paramString3))
      str1 = PhoneNumberUtils.stripSeparators(paramString3);
    for (final String str2 = dr.a(this.c, str1, str1); ; str2 = paramString3)
    {
      this.f.a(str1, str2, new j.d()
      {
        public void a(Collection<com.viber.voip.model.entity.k> paramAnonymousCollection)
        {
          if (paramAnonymousCollection.size() > 0)
            ((com.viber.voip.model.entity.k)paramAnonymousCollection.iterator().next());
          ConferenceInfo localConferenceInfo = paramConferenceInfo;
          String str1 = null;
          if (localConferenceInfo != null)
            str1 = com.viber.voip.flatbuffers.b.e.c().b().a(paramConferenceInfo);
          String str2 = str2;
          long l1 = paramLong1;
          boolean bool1 = paramInt2;
          int i1 = paramInt1;
          boolean bool2;
          CallEntity localCallEntity;
          final String str3;
          if (paramInt3 != 3)
          {
            bool2 = true;
            localCallEntity = new CallEntity(str2, l1, bool1, i1, bool2, paramInt4, str1, paramLong4, paramLong5, paramBoolean2, paramInt3, str1);
            localCallEntity.setMemberId(paramBoolean3);
            if (localCallEntity.hasConferenceInfo())
              localCallEntity.setAggregatedHash(p.a(paramConferenceInfo, p.a(localCallEntity)));
            if (!localCallEntity.isTypeViberOut())
              break label326;
            CountryNameInfo localCountryNameInfo = ViberApplication.getInstance().getEngine(true).getPhoneController().getCountryName(str2);
            if (localCountryNameInfo == null)
              break label320;
            str3 = localCountryNameInfo.countryShortName;
            label208: if (str1 == 3)
              g.a().a(h.a(str3, paramBoolean2));
            label231: if (!paramInt5)
            {
              e.b(e.this).a(localCallEntity, paramString5);
              if (localCallEntity.isTypeViberOut())
                av.e.g.a().post(new Runnable()
                {
                  public void run()
                  {
                    com.viber.voip.analytics.story.k.c(str3);
                  }
                });
              if (localCallEntity.isOutgoing())
                com.viber.voip.analytics.story.k.b(str2);
            }
            if ((!localCallEntity.hasConferenceInfo()) || (!localCallEntity.isOutgoing()))
              break label332;
          }
          label320: label326: label332: String str4;
          boolean bool3;
          do
          {
            return;
            bool2 = false;
            break;
            str3 = null;
            break label208;
            str3 = null;
            break label231;
            str4 = e.c(e.this).h();
            bool3 = ViberApplication.isTablet(null);
          }
          while (((bool3) && (localCallEntity.isTypeVln())) || (str4 == null) || (paramLong1 <= 0L) || ((!localCallEntity.isViberCall()) && (!localCallEntity.isTypeVln())) || (da.a(paramBoolean3)) || (str4.equals(localCallEntity.getCanonizedNumber())) || ((!bool3) && (!this.o) && (!localCallEntity.isTypeVln())));
          long l2;
          if (paramInt5)
          {
            l2 = av.a(0, 27);
            if (!localCallEntity.isTypeVln())
              break label505;
          }
          label505: for (int i2 = av.e(this.p, 4194304); ; i2 = this.p)
          {
            e.d(e.this).c().a(localCallEntity, i2, l2, this.q);
            return;
            l2 = 0L;
            break;
          }
        }
      });
      return;
      str1 = paramString3;
    }
  }

  private void b()
  {
    try
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
        ((d.c)localIterator.next()).a();
    }
    finally
    {
    }
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    b();
  }

  public void a(long paramLong, d.b paramb)
  {
    this.e.a(paramLong, paramb);
  }

  public void a(long paramLong1, String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4, long paramLong2, long paramLong3, int paramInt5, boolean paramBoolean3, ConferenceInfo paramConferenceInfo, String paramString3, d.a parama)
  {
    a(paramLong1, -1L, null, -1L, null, paramString1, paramString2, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramInt3, paramInt4, paramLong2, paramLong3, paramInt5, paramBoolean3, paramConferenceInfo, paramString3, parama);
  }

  public void a(final d.b paramb)
  {
    this.e.a(new d.b()
    {
      public void a(long paramAnonymousLong, Collection<Call> paramAnonymousCollection)
      {
        if (paramb != null)
          paramb.a(paramAnonymousLong, paramAnonymousCollection);
      }
    });
  }

  public void a(d.c paramc)
  {
    try
    {
      this.i.add(paramc);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(final d.d paramd)
  {
    this.e.a(new a.a()
    {
      public void a()
      {
        if (paramd != null)
          paramd.a();
      }
    });
  }

  public void a(Collection<AggregatedCall> paramCollection, final d.d paramd)
  {
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      arrayOfLong = new Long[paramCollection.size()];
      localIterator = paramCollection.iterator();
      for (j = 0; localIterator.hasNext(); j = k)
      {
        localAggregatedCall = (AggregatedCall)localIterator.next();
        k = j + 1;
        arrayOfLong[j] = Long.valueOf(localAggregatedCall.getAggregatedHash());
      }
      this.e.a(new a.a()
      {
        public void a()
        {
          e.a(e.this);
          if (paramd != null)
            paramd.a();
        }
      }
      , arrayOfLong);
    }
    while (paramd == null)
    {
      Long[] arrayOfLong;
      Iterator localIterator;
      int j;
      AggregatedCall localAggregatedCall;
      int k;
      return;
    }
    paramd.a();
  }

  public boolean a(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = com.viber.provider.contacts.a.a.b(ViberApplication.getApplication()).b("SELECT COUNT() FROM calls WHERE token=?");
    localSQLiteStatement.bindLong(1, paramLong);
    return localSQLiteStatement.simpleQueryForLong() > 0L;
  }

  public void b(final d.b paramb)
  {
    this.e.a(new d.b()
    {
      public void a(long paramAnonymousLong, Collection<Call> paramAnonymousCollection)
      {
        if (paramb != null)
          paramb.a(paramAnonymousLong, paramAnonymousCollection);
      }
    }
    , null);
  }

  public void b(d.c paramc)
  {
    try
    {
      this.i.remove(paramc);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(Collection<Call> paramCollection, final d.d paramd)
  {
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      localHashSet1 = new HashSet();
      localHashSet2 = new HashSet();
      localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        localCall = (Call)localIterator.next();
        localHashSet1.add(Long.valueOf(localCall.getId()));
        localHashSet2.add(Long.valueOf(localCall.getNativeCallId()));
      }
      this.e.b(new a.a()
      {
        public void a()
        {
          e.a(e.this);
          if (paramd != null)
            paramd.a();
        }
      }
      , (Long[])localHashSet2.toArray(new Long[0]));
    }
    while (paramd == null)
    {
      HashSet localHashSet1;
      HashSet localHashSet2;
      Iterator localIterator;
      Call localCall;
      return;
    }
    paramd.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.e
 * JD-Core Version:    0.6.2
 */