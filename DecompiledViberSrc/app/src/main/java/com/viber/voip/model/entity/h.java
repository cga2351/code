package com.viber.voip.model.entity;

import android.content.ContentValues;
import android.net.Uri;
import com.viber.voip.messages.m;
import com.viber.voip.messages.orm.entity.impl.ConversationEntityHelper;
import com.viber.voip.util.av;

public class h extends b
{
  private long A;
  private long B;
  private String C;
  private int D;
  private String E;
  private String F;
  private int a;
  private long b;
  private int c;
  private int d;
  private String e;
  private String f;
  private long g;
  private int h;
  private String i;
  private int j;
  private Uri k;
  private String l;
  private String m;
  private int n;
  private int o;
  private long p;
  private int q;
  private long r;
  private long s;
  private long t;
  private int u;
  private int v;
  private String w;
  private long x;
  private long y;
  private long z;

  public static int a(long paramLong, int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
      if (paramLong == 0L)
        return 0;
      break;
    case 1:
      return 2;
    case 3:
      return 5;
    }
    return 1;
  }

  public static int a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
      return 0;
    if (paramInt == 0)
      return 1;
    return 2;
  }

  public static void a(h paramh, Uri paramUri, String paramString, int paramInt)
  {
    if ((paramInt & 0x2) != 0)
      paramh.a(paramUri);
    if ((paramInt & 0x1) != 0)
      paramh.b(paramString);
  }

  public static int o(int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    default:
      return 0;
    case 2:
    case 3:
      return 1;
    case 5:
    }
    return 3;
  }

  public long A()
  {
    return this.s;
  }

  public String B()
  {
    return this.e;
  }

  public String C()
  {
    return this.f;
  }

  public boolean D()
  {
    return av.c(this.r, 0);
  }

  public boolean E()
  {
    return av.c(this.r, 4);
  }

  public boolean F()
  {
    return av.c(this.r, 13);
  }

  public boolean G()
  {
    return av.c(this.r, 19);
  }

  public boolean H()
  {
    return av.c(this.r, 26);
  }

  public boolean I()
  {
    return av.c(this.r, 15);
  }

  public boolean J()
  {
    return av.c(this.r, 18);
  }

  public boolean K()
  {
    return av.c(this.r, 6);
  }

  public boolean L()
  {
    return !av.c(this.r, 8);
  }

  public boolean M()
  {
    return av.c(this.r, 10);
  }

  public boolean N()
  {
    return av.c(this.r, 12);
  }

  public boolean O()
  {
    return av.c(this.r, 14);
  }

  public boolean P()
  {
    return av.c(this.r, 21);
  }

  public boolean Q()
  {
    return av.c(this.r, 25);
  }

  public boolean R()
  {
    return av.c(this.r, 24);
  }

  public boolean S()
  {
    return av.c(this.r, 16);
  }

  public boolean T()
  {
    return av.c(this.r, 33);
  }

  public boolean U()
  {
    return (i(7)) || (i(5));
  }

  public long V()
  {
    return this.x;
  }

  public long W()
  {
    return this.y;
  }

  public long X()
  {
    return this.z;
  }

  public long Y()
  {
    return this.A;
  }

  public long Z()
  {
    return this.B;
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    this.r = av.a(this.r, paramInt, paramBoolean);
  }

  public void a(long paramLong)
  {
    this.b = paramLong;
  }

  public void a(Uri paramUri)
  {
    this.k = paramUri;
  }

  public void a(String paramString)
  {
    this.w = paramString;
  }

  public boolean a()
  {
    return this.a == 0;
  }

  public long aa()
  {
    return this.t;
  }

  public int ab()
  {
    return this.h;
  }

  public boolean ac()
  {
    return this.o == 1;
  }

  public int ad()
  {
    return this.u;
  }

  public boolean ae()
  {
    return this.v == 1;
  }

  public int af()
  {
    return this.v;
  }

  public String ag()
  {
    return this.C;
  }

  public int ah()
  {
    if (R())
      return 1;
    if (ao())
      return 2;
    return 0;
  }

  public int ai()
  {
    return this.D;
  }

  public boolean aj()
  {
    return av.c(this.D, 0);
  }

  public boolean ak()
  {
    return av.c(this.D, 2);
  }

  public boolean al()
  {
    return av.c(this.D, 1);
  }

  public boolean am()
  {
    return av.c(this.D, 3);
  }

  public String an()
  {
    return this.E;
  }

  public boolean ao()
  {
    return av.c(this.r, 34);
  }

  public String ap()
  {
    return this.F;
  }

  public boolean aq()
  {
    return this.h == 1;
  }

  public boolean ar()
  {
    return av.c(this.r, 36);
  }

  public boolean as()
  {
    return av.c(this.r, 38);
  }

  public void b(int paramInt)
  {
    this.c = paramInt;
  }

  public void b(long paramLong)
  {
    this.g = paramLong;
  }

  public void b(String paramString)
  {
    this.i = paramString;
  }

  public boolean b()
  {
    return this.a != 0;
  }

  public void c(int paramInt)
  {
    this.j = paramInt;
  }

  public void c(long paramLong)
  {
    this.p = paramLong;
  }

  public void c(String paramString)
  {
    this.l = paramString;
  }

  public boolean c()
  {
    return this.a == 1;
  }

  public void d(int paramInt)
  {
    this.n = paramInt;
  }

  public void d(long paramLong)
  {
    this.r = paramLong;
  }

  public void d(String paramString)
  {
    this.m = paramString;
  }

  public boolean d()
  {
    return m.a(this.a);
  }

  public void e(int paramInt)
  {
    this.o = paramInt;
  }

  public void e(long paramLong)
  {
    this.s = paramLong;
  }

  public void e(String paramString)
  {
    this.e = paramString;
  }

  public boolean e()
  {
    return (d()) || (g());
  }

  public void f(int paramInt)
  {
    this.q = paramInt;
  }

  public void f(long paramLong)
  {
    this.x = paramLong;
  }

  public void f(String paramString)
  {
    this.f = paramString;
  }

  public boolean f()
  {
    return this.a == 3;
  }

  public void g(int paramInt)
  {
    this.r = av.a(this.r, paramInt);
  }

  public void g(long paramLong)
  {
    this.y = paramLong;
  }

  public void g(String paramString)
  {
    this.C = paramString;
  }

  public boolean g()
  {
    return m.b(this.a);
  }

  public ContentValues getContentValues()
  {
    return ConversationEntityHelper.getContentValues(this);
  }

  public String getTable()
  {
    return "conversations";
  }

  public void h(int paramInt)
  {
    this.r = av.b(this.r, paramInt);
  }

  public void h(long paramLong)
  {
    this.z = paramLong;
  }

  public void h(String paramString)
  {
    this.E = paramString;
  }

  public boolean h()
  {
    return this.a == 4;
  }

  public int i()
  {
    return this.d;
  }

  public void i(long paramLong)
  {
    this.A = paramLong;
  }

  public void i(String paramString)
  {
    this.F = paramString;
  }

  public boolean i(int paramInt)
  {
    return av.c(this.r, paramInt);
  }

  public int j()
  {
    return this.a;
  }

  public void j(int paramInt)
  {
    this.d = paramInt;
  }

  public void j(long paramLong)
  {
    this.B = paramLong;
  }

  public long k()
  {
    return this.b;
  }

  public void k(int paramInt)
  {
    this.h = paramInt;
  }

  public void k(long paramLong)
  {
    this.t = paramLong;
  }

  public int l()
  {
    return this.c;
  }

  public void l(int paramInt)
  {
    this.u = paramInt;
  }

  public String m()
  {
    return this.w;
  }

  public void m(int paramInt)
  {
    this.v = paramInt;
  }

  public long n()
  {
    return this.g;
  }

  public void n(int paramInt)
  {
    this.D = paramInt;
  }

  public String o()
  {
    if (this.i == null)
      return "";
    return this.i;
  }

  public int p()
  {
    return this.j;
  }

  public Uri q()
  {
    return this.k;
  }

  public Uri r()
  {
    return m.a(this.a, this.k);
  }

  public String s()
  {
    return this.l;
  }

  public String t()
  {
    return this.m;
  }

  public String toString()
  {
    return "ConversationEntity [id=" + getId() + ", conversationType=" + this.a + ", groupId=" + this.b + ", shareLocation=" + this.d + ", messageDraft=" + this.e + ", deletedToken=" + this.g + ", deleted=" + this.h + ", groupName=" + this.i + ", groupRole=" + this.j + ", iconUri='" + this.k + '\'' + ", backgroundLandscape=" + this.l + ", backgroundPortrait=" + this.m + ", backgroundTextColor=" + this.n + ", smartNotifications=" + this.o + ", smartEventDate=" + this.p + ", muteNotifications=" + this.q + ", flags=" + this.r + ", date=" + this.s + ", appId=" + this.c + ", businessInboxFlags=" + this.D + ", toNumber=" + this.E + ", groupingKey=" + this.F + ", botReply=" + this.w + ", timebombTime=" + this.u + ", messageDraftSpans=" + this.f + ", readNotificationToken=" + this.t + ", participantInfoId1=" + this.x + ", participantInfoId2=" + this.y + ", participantInfoId3=" + this.z + ", participantInfoId4=" + this.A + ", creatorParticipantInfoId=" + this.B + "]";
  }

  public int u()
  {
    return this.n;
  }

  public int v()
  {
    return this.o;
  }

  public long w()
  {
    return this.p;
  }

  public int x()
  {
    return this.q;
  }

  public boolean y()
  {
    return this.q == 1;
  }

  public long z()
  {
    return this.r;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.h
 * JD-Core Version:    0.6.2
 */