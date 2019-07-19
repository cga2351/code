package com.viber.voip.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.google.d.p;
import com.viber.dexshared.Logger;
import com.viber.jni.ConferenceMembers;
import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.e.m;
import com.viber.voip.pixie.PixieControllerNativeImpl;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.p;
import com.viber.voip.util.ViberActionRunner.as;
import com.viber.voip.util.ca;
import com.viber.voip.util.da;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class a
{
  public static boolean a = false;
  private static final Logger b = ViberEnv.getLogger();
  private com.viber.voip.g.b.b<bs> c = new com.viber.voip.g.b.b()
  {
    protected bs a()
    {
      return new bs(ViberApplication.getApplication());
    }
  };
  private com.viber.voip.g.b.b<ab> d = new com.viber.voip.g.b.b()
  {
    protected ab a()
    {
      return ab.b();
    }
  };
  private com.viber.voip.g.b.b<com.google.d.f> e = new com.viber.voip.g.b.b()
  {
    protected com.google.d.f a()
    {
      return new com.google.d.f();
    }
  };
  private final Engine f;
  private final af g;
  private final m h;
  private final g i;
  private final com.viber.voip.calls.d j;
  private final com.viber.voip.util.d k;
  private final a l = new a();

  public a(Engine paramEngine, af paramaf, m paramm, g paramg, com.viber.voip.calls.d paramd, com.viber.voip.util.d paramd1)
  {
    this.f = paramEngine;
    this.g = paramaf;
    this.h = paramm;
    this.i = paramg;
    this.j = paramd;
    this.k = paramd1;
  }

  private f a(String paramString)
  {
    if (com.viber.voip.flatbuffers.b.c.a(paramString))
      return null;
    try
    {
      f localf = (f)((com.google.d.f)this.e.get()).a(paramString, f.class);
      return localf;
    }
    catch (p localp)
    {
    }
    return null;
  }

  private void a(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, long paramLong3, int paramInt1, int paramInt2, int paramInt3, String paramString5, long paramLong4, String paramString6, ConferenceMembers paramConferenceMembers, String paramString7)
  {
    this.l.a(paramLong1, paramString1, paramString2, paramString3, paramLong2, paramString4, paramLong3, paramInt1, paramInt2, paramInt3, paramString5, paramLong4, paramString6, paramConferenceMembers, paramString7);
    long l1 = this.f.getServerDeltaTime();
    if (l1 != 9223372036854775807L)
    {
      a.a(this.l, l1);
      return;
    }
    this.f.registerDelegate(this.l);
  }

  public static boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(System.currentTimeMillis() - paramLong2 - paramLong1) < 20000L;
  }

  public void a(Context paramContext, Map<String, String> paramMap)
  {
    ((String)paramMap.get("message"));
    int m = -1;
    while (true)
    {
      String str14;
      String str12;
      String str9;
      try
      {
        int i9 = Integer.parseInt((String)paramMap.get("op"));
        m = i9;
        String str1 = (String)paramMap.get("dest_udid");
        String str2;
        if (ViberApplication.isActivated())
        {
          str2 = this.g.a().a();
          if ((str2 != null) && (str2.equals(str1)));
        }
        else
        {
          str2 = "";
          continue;
        }
        bool1 = com.viber.voip.memberid.d.c();
        switch (m)
        {
        default:
          return;
        case 1:
        case 4:
        case 3:
        case 5:
        case 20:
        case 15:
        case 31:
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        try
        {
          boolean bool1;
          long l8 = Long.parseLong((String)paramMap.get("ct"));
          str14 = (String)paramMap.get("fn");
          String str15 = (String)paramMap.get("vlnPhnNum");
          if (bool1)
          {
            str16 = (String)paramMap.get("srcMid");
            String str17 = (String)paramMap.get("hs");
            long l9 = 1000L * Long.parseLong((String)paramMap.get("time"));
            String str18 = da.h((String)paramMap.get("clientName"));
            int i6 = Integer.parseInt((String)paramMap.get("cid"));
            long l10 = Long.parseLong((String)paramMap.get("transferToken"));
            int i7 = Integer.parseInt((String)paramMap.get("transferContext"));
            String str19 = (String)paramMap.get("sdp");
            if (paramMap.containsKey("flags"))
            {
              i8 = Integer.valueOf((String)paramMap.get("flags")).intValue();
              f localf = a((String)paramMap.get("confInfo"));
              if (localf == null)
                break label1367;
              l11 = localf.a();
              if (localf == null)
                break label1373;
              str20 = localf.b();
              if (localf == null)
                break label1380;
              localConferenceMembers = localf.c();
              if (a(l9, this.f.getServerDeltaTime()))
                ViberActionRunner.as.a(paramContext);
              a(l8, str16, str14, str17, l9, str18, l10, i7, i8, i6, str19, l11, str20, localConferenceMembers, str15);
              return;
            }
            boolean bool4 = TextUtils.isEmpty(str15);
            int i8 = 0;
            if (bool4)
              continue;
            i8 = 1;
            continue;
            long l5 = Long.parseLong(ca.a((String)paramMap.get("ct"), "0"));
            long l6 = Long.parseLong(ca.a((String)paramMap.get("groupId"), "0"));
            boolean bool3 = a;
            if (this.k.b())
              bool3 = false;
            if ((bool3) && (((ab)this.d.get()).a(l5)))
              bool3 = false;
            if ((bool3) && (l6 > 0L))
            {
              h localh = ((ab)this.d.get()).b(l6);
              if ((localh != null) && (localh.y()))
              {
                i5 = 0;
                if (i5 == 0)
                  continue;
                long l7 = 1000L * Long.parseLong(ca.a((String)paramMap.get("time"), "0"));
                this.h.b(l7);
                this.i.a(l5);
                return;
                long l4 = Long.parseLong((String)paramMap.get("ct"));
                str12 = (String)paramMap.get("OriginPhoneNumber");
                if (!bool1)
                  break label1386;
                str13 = (String)paramMap.get("srcMid");
                int i2 = Integer.parseInt((String)paramMap.get("numMissed"));
                int i3 = Integer.parseInt((String)paramMap.get("numMissedOther"));
                if (!paramMap.containsKey("flags"))
                  break label1393;
                i4 = Integer.valueOf((String)paramMap.get("flags")).intValue();
                this.f.addInitializedListener(new b(l4, str13, i2, i3, str12, i4));
                if ((!a) || (this.k.b()) || (this.j.a(l4)) || (((ab)this.d.get()).a(l4)))
                  continue;
                this.h.b(System.currentTimeMillis());
                this.i.a(l4);
                return;
                str9 = (String)paramMap.get("phone_number");
                if (!bool1)
                  break label1399;
                str10 = (String)paramMap.get("srcMid");
                String str11 = (String)paramMap.get("device");
                boolean bool2 = Boolean.parseBoolean((String)paramMap.get("rejoin"));
                if ((!d.p.b.d()) || (this.g.h().equals(str9)))
                  continue;
                ViberApplication.getInstance().getContactManager().d().a(new Member(str10, str9), "", str11, bool2);
                return;
                Bundle localBundle = new Bundle();
                Iterator localIterator = paramMap.keySet().iterator();
                if (localIterator.hasNext())
                {
                  String str8 = (String)localIterator.next();
                  localBundle.putString(str8, (String)paramMap.get(str8));
                  continue;
                }
                this.h.a(localBundle);
                long l3 = Long.parseLong((String)paramMap.get("mt"));
                int i1 = Integer.parseInt((String)paramMap.get("blast"));
                String str7 = this.g.e();
                this.f.addInitializedListener(new c(l3, i1, str7));
                return;
                if (!com.viber.voip.util.av.d(Integer.parseInt((String)paramMap.get("g2Flags")), 1))
                  continue;
                long l1 = Long.parseLong(ca.a((String)paramMap.get("groupId"), "0"));
                long l2 = Long.parseLong(ca.a((String)paramMap.get("mt"), "0"));
                int n = Integer.parseInt(ca.a((String)paramMap.get("msgId"), "0"));
                String str4 = (String)paramMap.get("msgInfo");
                String str5 = (String)paramMap.get("srcMid");
                String str6 = (String)paramMap.get("sender");
                if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str5)))
                  continue;
                com.viber.voip.av.a(av.e.d).post(new d(this, l1, n, l2, str4, str5, str6));
                return;
                String str3 = (String)paramMap.get("payload");
                PixieControllerNativeImpl.getInstance().setPushConfig(str3);
                return;
                localNumberFormatException = localNumberFormatException;
                continue;
              }
            }
            int i5 = bool3;
            continue;
          }
        }
        catch (Exception localException)
        {
          return;
        }
      }
      String str16 = str14;
      continue;
      label1367: long l11 = 0L;
      continue;
      label1373: String str20 = "";
      continue;
      label1380: ConferenceMembers localConferenceMembers = null;
      continue;
      label1386: String str13 = str12;
      continue;
      label1393: int i4 = 0;
      continue;
      label1399: String str10 = str9;
    }
  }

  final class a extends PhoneControllerDelegateAdapter
  {
    long a;
    String b;
    String c;
    String d;
    long e;
    String f;
    private long h;
    private int i;
    private int j;
    private int k;
    private String l;
    private long m = 0L;
    private String n = "";
    private ConferenceMembers o;
    private String p;

    a()
    {
    }

    private void a(long paramLong)
    {
      if (a.a(this.e, paramLong))
      {
        a.b(a.this).addInitializedListener(new e(this));
        return;
      }
      long l1 = Math.abs(System.currentTimeMillis() - paramLong - this.e);
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.a(l1 / 1000L, paramLong / 1000L));
    }

    public void a(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, long paramLong3, int paramInt1, int paramInt2, int paramInt3, String paramString5, long paramLong4, String paramString6, ConferenceMembers paramConferenceMembers, String paramString7)
    {
      this.a = paramLong1;
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramString3;
      this.e = paramLong2;
      this.f = paramString4;
      this.h = paramLong3;
      this.i = paramInt1;
      this.j = paramInt2;
      this.k = paramInt3;
      this.l = paramString5;
      this.m = paramLong4;
      this.n = paramString6;
      this.o = paramConferenceMembers;
      this.p = paramString7;
    }

    public void onLBServerTime(long paramLong)
    {
      long l1 = System.currentTimeMillis() - paramLong;
      a.b(a.this).removeDelegate(a.a(a.this));
      if (!a.b(a.this).isGSMCallActive())
        a(l1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.c.a
 * JD-Core Version:    0.6.2
 */