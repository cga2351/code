package com.viber.voip.util;

import android.os.Handler;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.g.g;
import com.viber.voip.contacts.c.f.b.c;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.k;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.m;
import com.viber.voip.user.UserManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dr
{
  private static final Logger a = ViberEnv.getLogger();
  private static Handler b = av.a(av.e.a);

  public static String a(ViberApplication paramViberApplication, CharSequence paramCharSequence, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (a(paramViberApplication, paramCharSequence, localStringBuilder))
      paramString = localStringBuilder.toString();
    return paramString;
  }

  public static String a(ViberApplication paramViberApplication, String paramString)
  {
    return a(paramViberApplication, paramString, paramString);
  }

  public static String a(String paramString)
  {
    if (paramString != null)
    {
      String str = paramString.replaceFirst("[-.]*", "");
      if (PhoneNumberUtils.isGlobalPhoneNumber(str))
        return a(ViberApplication.getInstance(), str, str);
    }
    return null;
  }

  private static void a(com.viber.voip.contacts.c.d.g paramg, ParticipantSelector.Participant paramParticipant, a parama)
  {
    if (!TextUtils.isEmpty(paramParticipant.getMemberId()))
    {
      b(paramg, paramParticipant, parama);
      return;
    }
    c(paramg, paramParticipant, parama);
  }

  private static void a(com.viber.voip.contacts.c.d.g paramg, final ParticipantSelector.Participant paramParticipant, final a parama, final int paramInt)
  {
    av.e.f.a().post(new Runnable()
    {
      public void run()
      {
        com.viber.voip.model.entity.g localg = this.a.c().a(paramParticipant.getNumber());
        if (localg != null)
        {
          parama.onCheckStatus(true, paramInt, paramParticipant, localg);
          return;
        }
        parama.onCheckStatus(false, paramInt, paramParticipant, null);
      }
    });
  }

  public static void a(ParticipantSelector.Participant paramParticipant, a parama)
  {
    a(paramParticipant, parama, null);
  }

  public static void a(ParticipantSelector.Participant paramParticipant, a parama, Handler paramHandler)
  {
    String str1 = paramParticipant.getNumber();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    String str2;
    ParticipantSelector.Participant localParticipant;
    if (str1 != null)
    {
      str2 = a(localViberApplication, str1, str1);
      Engine localEngine = localViberApplication.getEngine(true);
      localParticipant = ParticipantSelector.Participant.create(paramParticipant.getMemberId(), str2);
      ServiceStateDelegate.ServiceState localServiceState = localEngine.getServiceState();
      switch (4.a[localServiceState.ordinal()])
      {
      default:
        if (!cj.b(ViberApplication.getApplication()))
          break;
      case 1:
      case 2:
      }
    }
    for (int i = 2; ; i = 4)
    {
      if (paramHandler != null)
        break label187;
      parama.onCheckStatus(false, i, localParticipant, null);
      return;
      str2 = null;
      break;
      if (paramHandler == null)
      {
        parama.onCheckStatus(false, 4, localParticipant, null);
        return;
      }
      paramHandler.post(new ds(parama, localParticipant));
      return;
      if (paramHandler == null)
      {
        a(localViberApplication.getContactManager(), localParticipant, parama);
        return;
      }
      paramHandler.post(new dt(localViberApplication, localParticipant, parama));
      return;
    }
    label187: paramHandler.post(new du(parama, i, localParticipant));
  }

  public static void a(String paramString, a parama)
  {
    a(ParticipantSelector.Participant.createUnknown(paramString), parama);
  }

  public static boolean a(ViberApplication paramViberApplication, CharSequence paramCharSequence, StringBuilder paramStringBuilder)
  {
    String str1 = null;
    if (paramCharSequence != null)
    {
      int i = paramCharSequence.length();
      str1 = null;
      if (i >= 7)
      {
        boolean bool = ce.l.matcher(paramCharSequence).matches();
        str1 = null;
        if (bool)
          str1 = paramViberApplication.getEngine(true).getPhoneController().canonizePhoneNumber(PhoneNumberUtils.stripSeparators(paramCharSequence.toString()));
      }
    }
    if (str1 != null)
    {
      String str2 = PhoneNumberUtils.stringFromStringAndTOA(str1, 145);
      paramStringBuilder.setLength(0);
      paramStringBuilder.append(str2);
      return true;
    }
    return false;
  }

  public static int b(ViberApplication paramViberApplication, String paramString)
  {
    if ((paramString != null) && (paramString.length() >= 7))
    {
      String str = cg.b(paramString);
      return paramViberApplication.getEngine(true).getPhoneController().getCountryCode(str);
    }
    return -1;
  }

  private static void b(com.viber.voip.contacts.c.d.g paramg, ParticipantSelector.Participant paramParticipant, a parama)
  {
    if (paramParticipant.getMemberId() == null)
    {
      parama.onCheckStatus(false, -1, paramParticipant, null);
      return;
    }
    d(paramg, paramParticipant, parama);
  }

  public static int c(ViberApplication paramViberApplication, String paramString)
  {
    if ((paramString != null) && (paramString.length() >= 7))
    {
      String str = cg.b(paramString);
      return paramViberApplication.getEngine(true).getPhoneController().getBICC(str);
    }
    return -1;
  }

  private static void c(com.viber.voip.contacts.c.d.g paramg, ParticipantSelector.Participant paramParticipant, a parama)
  {
    String str = paramParticipant.getNumber();
    if (str == null)
    {
      parama.onCheckStatus(false, -1, paramParticipant, null);
      return;
    }
    if (ce.n.matcher(str).matches())
    {
      parama.onCheckStatus(false, 5, paramParticipant, null);
      return;
    }
    if ((ce.r.matcher(str).matches()) && (ViberApplication.getInstance().getUserManager().getRegistrationValues().s()))
    {
      a(paramg, paramParticipant, parama, 7);
      return;
    }
    if (ce.o.matcher(str).matches())
    {
      parama.onCheckStatus(false, 6, paramParticipant, null);
      return;
    }
    if (ce.l.matcher(str).matches())
    {
      d(paramg, paramParticipant, parama);
      return;
    }
    parama.onCheckStatus(false, -1, paramParticipant, null);
  }

  private static void d(final com.viber.voip.contacts.c.d.g paramg, ParticipantSelector.Participant paramParticipant, a parama)
  {
    final a local1 = new a()
    {
      public void onCheckStatus(final boolean paramAnonymousBoolean, final int paramAnonymousInt, final ParticipantSelector.Participant paramAnonymousParticipant, final com.viber.voip.model.entity.g paramAnonymousg)
      {
        dr.a().post(new Runnable()
        {
          public void run()
          {
            dr.1.this.a.onCheckStatus(paramAnonymousBoolean, paramAnonymousInt, paramAnonymousParticipant, paramAnonymousg);
          }
        });
      }
    };
    av.e.f.a().post(new Runnable()
    {
      public void run()
      {
        int i;
        final com.viber.voip.model.entity.g localg;
        label55: g.g localg1;
        label88: g.g localg2;
        boolean bool;
        label119: dr.a locala;
        int j;
        if (!TextUtils.isEmpty(this.a.getMemberId()))
        {
          i = 1;
          if (i == 0)
            break label169;
          localg = paramg.c().c(new Member(this.a.getMemberId(), this.a.getNumber()));
          localg1 = g.g.c;
          if (localg != null)
          {
            if ((!localg.p()) && (localg.a(this.a.getNumber()) == null))
              break label194;
            localg1 = g.g.a;
          }
          if ((g.g.a != localg1) || ((localg.p()) && (!d.m.s.d())))
            break label201;
          localg2 = g.g.c;
          bool = true;
          if (localg2 == g.g.c)
            break label216;
          locala = local1;
          g.g localg3 = g.g.a;
          j = 0;
          if (localg3 != localg2)
            break label210;
        }
        while (true)
        {
          locala.onCheckStatus(true, j, this.a, localg);
          return;
          i = 0;
          break;
          label169: localg = paramg.c().a(this.a.getNumber());
          break label55;
          label194: localg1 = g.g.c;
          break label88;
          label201: localg2 = localg1;
          bool = false;
          break label119;
          label210: j = 1;
        }
        label216: ci.a local1 = new ci.a()
        {
          public void onGetUserDetail(com.viber.voip.model.entity.m[] paramAnonymous2ArrayOfm)
          {
            com.viber.voip.model.entity.m localm = paramAnonymous2ArrayOfm[0];
            com.viber.voip.model.entity.g localg = x.a(localm);
            if (localm.i() > 0L)
              localg.setId(localm.i());
            if ((localg != null) && (!localg.p()))
            {
              dr.b().a(new IllegalStateException("Contact is not recognized as Viber id=" + localm.d()), "Issue ANDROID-22117");
              dr.2.this.b.d().a(localg);
            }
            dr.2.this.c.onCheckStatus(false, 0, dr.2.this.a, localg);
          }

          public void onGetUserError()
          {
            dr.2.this.c.onCheckStatus(false, 1, dr.2.this.a, null);
          }
        };
        ci localci = ViberApplication.getInstance().getMessagesManager().e();
        if (i != 0)
        {
          localci.a(this.a.getMemberId(), local1, bool);
          return;
        }
        localci.b(this.a.getNumber(), local1, bool);
      }
    });
  }

  public static abstract interface a
  {
    public abstract void onCheckStatus(boolean paramBoolean, int paramInt, ParticipantSelector.Participant paramParticipant, com.viber.voip.model.entity.g paramg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dr
 * JD-Core Version:    0.6.2
 */