package com.viber.voip.analytics.story.b;

import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallStats;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.util.n;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class f
{
  private boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private long i;
  private long j;
  private long k;
  private Set<String> l;
  private Set<String> m;

  public boolean a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.e;
  }

  public boolean f()
  {
    return this.f;
  }

  public boolean g()
  {
    return this.g;
  }

  public boolean h()
  {
    return this.h;
  }

  public long i()
  {
    return this.i;
  }

  public long j()
  {
    return this.j;
  }

  public long k()
  {
    return this.k;
  }

  public Set<String> l()
  {
    if (this.l != null)
      return this.l;
    return Collections.emptySet();
  }

  public Set<String> m()
  {
    if (this.m != null)
      return this.m;
    return Collections.emptySet();
  }

  public static class a
  {
    private f a = new f();

    public a a(long paramLong)
    {
      f.a(this.a, paramLong);
      return this;
    }

    public a a(boolean paramBoolean)
    {
      f.a(this.a, paramBoolean);
      return this;
    }

    public a a(String[] paramArrayOfString)
    {
      if (f.a(this.a) == null)
        f.a(this.a, new HashSet(paramArrayOfString.length));
      f.a(this.a).addAll(Arrays.asList(paramArrayOfString));
      return this;
    }

    public f a()
    {
      f localf = this.a;
      this.a = new f();
      return localf;
    }

    public a b(long paramLong)
    {
      f.b(this.a, paramLong);
      return this;
    }

    public a b(boolean paramBoolean)
    {
      f.b(this.a, paramBoolean);
      return this;
    }

    public a b(String[] paramArrayOfString)
    {
      if (f.b(this.a) == null)
        f.b(this.a, new HashSet(paramArrayOfString.length));
      f.b(this.a).addAll(Arrays.asList(paramArrayOfString));
      return this;
    }

    public a c(long paramLong)
    {
      f.c(this.a, paramLong);
      return this;
    }

    public a c(boolean paramBoolean)
    {
      f.b(this.a, paramBoolean);
      return this;
    }

    public a d(boolean paramBoolean)
    {
      f.c(this.a, paramBoolean);
      return this;
    }

    public a e(boolean paramBoolean)
    {
      f.d(this.a, paramBoolean);
      return this;
    }

    public a f(boolean paramBoolean)
    {
      f.e(this.a, paramBoolean);
      return this;
    }

    public a g(boolean paramBoolean)
    {
      f.f(this.a, paramBoolean);
      return this;
    }

    public a h(boolean paramBoolean)
    {
      f.g(this.a, paramBoolean);
      return this;
    }
  }

  public static class b
  {
    public static f a(ConferenceInfo paramConferenceInfo)
    {
      return new f.a().a(true).f(true).b(b(paramConferenceInfo)).a();
    }

    public static f a(CallInfo paramCallInfo)
    {
      CallStats localCallStats = paramCallInfo.getInCallState().getCallStats();
      f.a locala1 = new f.a().a(paramCallInfo.isConference()).b(paramCallInfo.isViberIn()).c(paramCallInfo.isViberOut()).e(paramCallInfo.isPureViberIn()).f(paramCallInfo.isPureViberCall()).d(paramCallInfo.isVln()).g(paramCallInfo.isIncomingVideoCall()).h(paramCallInfo.isOutgoingVideoCall()).a(localCallStats.getRemoteVideoDuration()).b(localCallStats.getLocalVideoDuration()).c(localCallStats.getCallDuration());
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramCallInfo.getCallerInfo().getPhoneNumber();
      f.a locala2 = locala1.a(arrayOfString);
      if (paramCallInfo.isConference())
      {
        ConferenceInfo localConferenceInfo = paramCallInfo.getCallerInfo().getConferenceInfo();
        if (localConferenceInfo != null)
          locala2.b(b(localConferenceInfo));
      }
      return locala2.a();
    }

    private static String[] b(ConferenceInfo paramConferenceInfo)
    {
      return (String[])n.a(String.class, paramConferenceInfo.getParticipants(), g.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.f
 * JD-Core Version:    0.6.2
 */