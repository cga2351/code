package com.viber.voip.model.entity;

import android.content.ContentValues;
import com.viber.jni.LocationInfo;
import com.viber.voip.messages.orm.entity.impl.PublicAccountEntityHelper;
import com.viber.voip.publicaccount.entity.CrmItem;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.Background;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo;
import com.viber.voip.util.av;
import com.viber.voip.util.da;
import com.viber.voip.util.upload.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class r extends b
{
  private String A;
  private int B;
  private String C;
  private String D;
  private int E;
  private String F;
  private String G;
  private String H;
  private String I;
  private int J;
  private String K;
  private long L;
  private String M;
  private String N;
  private String O;
  private long a;
  private String b;
  private int c;
  private String d;
  private String e;
  private String f;
  private int g;
  private int h;
  private int i;
  private int j;
  private long k;
  private int l;
  private String m;
  private String n;
  private int o;
  private int p;
  private int q;
  private String r;
  private long s;
  private int t;
  private String u;
  private String v;
  private String w;
  private String x;
  private int y;
  private int z;

  public static List<q> a(r paramr, PublicAccount paramPublicAccount, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i3;
    label144: boolean bool3;
    label179: boolean bool2;
    label276: String str1;
    label432: int i1;
    label451: int i2;
    label464: long l1;
    String str2;
    String str3;
    if ((paramInt & 0x4) != 0)
    {
      if (paramPublicAccount.getBackground().getObjectId() != null)
        paramr.c(paramPublicAccount.getBackground().getObjectId().toDecString());
    }
    else
    {
      if ((paramInt & 0x40) != 0)
        paramr.d(paramPublicAccount.getCountryCode());
      if ((paramInt & 0x20) != 0)
      {
        paramr.c(paramPublicAccount.getLocation().getNativeLatitude());
        paramr.d(paramPublicAccount.getLocation().getNativeLongitude());
        paramr.j(paramPublicAccount.getAdressString());
      }
      if ((paramInt & 0x8) != 0)
        paramr.i(paramPublicAccount.getTagLines());
      if ((paramInt & 0x10) != 0)
        paramr.a(paramPublicAccount.getTags());
      if ((paramInt & 0x80) != 0)
      {
        if (av.d(paramPublicAccount.getFlags(), 16384))
          break label539;
        i3 = 1;
        if (paramr.S() != i3)
        {
          long l2 = paramr.getId();
          String str6 = paramr.d();
          String str7 = paramPublicAccount.getName();
          if (i3 != 0)
            break label545;
          bool3 = true;
          localArrayList.add(new q(l2, str6, str7, 2, bool3));
        }
        paramr.k(paramPublicAccount.getFlags());
      }
      if ((paramInt & 0x100) != 0)
        paramr.b(paramPublicAccount.getGroupUri());
      if ((paramInt & 0x200) != 0)
      {
        paramr.s(paramPublicAccount.getCategoryId());
        paramr.t(paramPublicAccount.getSubCategoryId());
      }
      if ((paramInt & 0x400) != 0)
      {
        paramr.a(paramPublicAccount.isWebhookExists());
        if (paramPublicAccount.isWebhookExists())
          break label551;
        bool2 = true;
        if (!bool2)
          break label557;
        paramr.e(null);
        localArrayList.add(new q(paramr.getId(), paramr.d(), paramPublicAccount.getName(), 3, bool2));
      }
      if ((paramInt & 0x800) != 0)
      {
        CrmItem localCrmItem1 = paramPublicAccount.getCrm();
        String str4 = null;
        if (localCrmItem1 != null)
          str4 = localCrmItem1.getName();
        paramr.e(str4);
      }
      if ((paramInt & 0x1000) != 0)
        paramr.q(paramPublicAccount.getWebsite());
      if ((paramInt & 0x2000) != 0)
        paramr.r(paramPublicAccount.getEmail());
      if ((0x8000 & paramInt) != 0)
        paramr.f(paramPublicAccount.getAuthToken());
      if ((paramInt & 0x4000) != 0)
      {
        PublicAccount.ExtraInfo localExtraInfo1 = paramPublicAccount.getExtraInfo();
        PublicAccount.ExtraInfo localExtraInfo2 = PublicAccount.ExtraInfo.fromExtraInfoJson(paramr.R());
        if (localExtraInfo1 == null)
          break label590;
        str1 = localExtraInfo1.toJson();
        paramr.u(str1);
        if (localExtraInfo2 == null)
          break label597;
        i1 = localExtraInfo2.getJokerButtons().length;
        if (localExtraInfo1 == null)
          break label603;
        i2 = localExtraInfo1.getJokerButtons().length;
        l1 = paramr.getId();
        str2 = paramr.d();
        str3 = paramPublicAccount.getName();
        if (i2 >= i1)
          break label609;
      }
    }
    label539: label545: label551: label557: label590: label597: label603: label609: for (boolean bool1 = true; ; bool1 = false)
    {
      localArrayList.add(new q(l1, str2, str3, 1, bool1));
      paramr.b(paramPublicAccount.getRevision());
      return localArrayList;
      paramr.c(paramPublicAccount.getBackground().getId());
      break;
      i3 = 0;
      break label144;
      bool3 = false;
      break label179;
      bool2 = false;
      break label276;
      CrmItem localCrmItem2 = paramPublicAccount.getCrm();
      if (localCrmItem2 != null);
      for (String str5 = localCrmItem2.getName(); ; str5 = null)
      {
        paramr.e(str5);
        break;
      }
      str1 = "";
      break label432;
      i1 = 0;
      break label451;
      i2 = 0;
      break label464;
    }
  }

  public static String b(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = paramArrayOfString.length;
    for (int i2 = 0; i2 < i1; i2++)
      localStringBuilder.append(paramArrayOfString[i2]).append(" ");
    if (localStringBuilder.length() > 0)
      localStringBuilder.setLength(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  public static String[] h(String paramString)
  {
    if (da.a(paramString))
      return new String[0];
    return paramString.split(" ");
  }

  public int A()
  {
    return this.z;
  }

  public boolean B()
  {
    return av.c(this.z, 0);
  }

  public boolean C()
  {
    return av.c(this.z, 1);
  }

  public String D()
  {
    return this.r;
  }

  public long E()
  {
    return this.s;
  }

  public String F()
  {
    return this.u;
  }

  public String G()
  {
    return this.v;
  }

  public String H()
  {
    return this.w;
  }

  public String I()
  {
    return this.x;
  }

  public int J()
  {
    return this.t;
  }

  public int K()
  {
    return this.y;
  }

  public int L()
  {
    return this.B;
  }

  public String M()
  {
    return this.C;
  }

  public String N()
  {
    return this.D;
  }

  public int O()
  {
    return this.J;
  }

  public String P()
  {
    return this.G;
  }

  public String Q()
  {
    return this.H;
  }

  public String R()
  {
    return this.K;
  }

  public boolean S()
  {
    return !av.d(x(), 16384);
  }

  public long T()
  {
    return this.L;
  }

  public String U()
  {
    return this.M;
  }

  public String V()
  {
    return this.N;
  }

  public String W()
  {
    return this.O;
  }

  public long a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.B = paramInt;
  }

  public void a(long paramLong)
  {
    this.a = paramLong;
  }

  public void a(String paramString)
  {
    this.A = paramString;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i1 = 1; ; i1 = 0)
    {
      this.B = i1;
      return;
    }
  }

  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
      g(b(paramArrayOfString));
  }

  public String b()
  {
    return this.A;
  }

  public void b(int paramInt)
  {
    this.c = paramInt;
  }

  public void b(long paramLong)
  {
    this.k = paramLong;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public void b(boolean paramBoolean)
  {
    this.z = av.a(this.z, 0, paramBoolean);
  }

  public void c(int paramInt)
  {
    this.g = paramInt;
  }

  public void c(long paramLong)
  {
    this.s = paramLong;
  }

  public void c(String paramString)
  {
    this.d = paramString;
  }

  public void c(boolean paramBoolean)
  {
    this.z = av.a(this.z, 1, paramBoolean);
  }

  public boolean c()
  {
    return this.B == 1;
  }

  public String d()
  {
    return this.b;
  }

  public void d(int paramInt)
  {
    this.h = paramInt;
  }

  public void d(long paramLong)
  {
    this.L = paramLong;
  }

  public void d(String paramString)
  {
    this.e = paramString;
  }

  public int e()
  {
    return this.c;
  }

  public void e(int paramInt)
  {
    this.i = paramInt;
  }

  public void e(String paramString)
  {
    this.I = paramString;
  }

  public String f()
  {
    return this.d;
  }

  public void f(int paramInt)
  {
    this.j = paramInt;
  }

  public void f(String paramString)
  {
    this.F = paramString;
  }

  public String g()
  {
    return this.e;
  }

  public void g(int paramInt)
  {
    this.l = paramInt;
  }

  public void g(String paramString)
  {
    this.m = paramString;
  }

  public ContentValues getContentValues()
  {
    return PublicAccountEntityHelper.getContentValues(this);
  }

  public String getTable()
  {
    return "public_accounts";
  }

  public int h()
  {
    return this.g;
  }

  public void h(int paramInt)
  {
    this.p = paramInt;
  }

  public int i()
  {
    return this.h;
  }

  public void i(int paramInt)
  {
    this.E = paramInt;
  }

  public void i(String paramString)
  {
    this.n = paramString;
  }

  public int j()
  {
    return this.i;
  }

  public void j(int paramInt)
  {
    this.o = paramInt;
  }

  public void j(String paramString)
  {
    this.f = paramString;
  }

  public int k()
  {
    return this.j;
  }

  public void k(int paramInt)
  {
    this.q = paramInt;
  }

  public void k(String paramString)
  {
    this.r = paramString;
  }

  public long l()
  {
    return this.k;
  }

  public void l(int paramInt)
  {
    this.z = paramInt;
  }

  public void l(String paramString)
  {
    this.u = paramString;
  }

  public int m()
  {
    return this.l;
  }

  public void m(int paramInt)
  {
    this.t = paramInt;
  }

  public void m(String paramString)
  {
    this.v = paramString;
  }

  public int n()
  {
    return this.p;
  }

  public void n(int paramInt)
  {
    this.y = paramInt;
  }

  public void n(String paramString)
  {
    this.w = paramString;
  }

  public String o()
  {
    return this.F;
  }

  public void o(int paramInt)
  {
    this.J = paramInt;
  }

  public void o(String paramString)
  {
    this.x = paramString;
  }

  public String p()
  {
    return this.I;
  }

  public void p(String paramString)
  {
    try
    {
      this.t = Integer.valueOf(paramString).intValue();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      this.t = 0;
    }
  }

  public int q()
  {
    return this.E;
  }

  public void q(String paramString)
  {
    this.C = paramString;
  }

  public void r(String paramString)
  {
    this.D = paramString;
  }

  public boolean r()
  {
    return this.E == 1;
  }

  public String s()
  {
    return this.m;
  }

  public void s(String paramString)
  {
    this.G = paramString;
  }

  public void t(String paramString)
  {
    this.H = paramString;
  }

  public String[] t()
  {
    return h(this.m);
  }

  public String toString()
  {
    return "PublicAccountEntity{groupId=" + this.a + ", groupUri='" + this.b + '\'' + ", publicAccountId='" + this.A + '\'' + ", revision=" + this.c + ", backgroundId='" + this.d + '\'' + ", country='" + this.e + '\'' + ", addressString='" + this.f + '\'' + ", locationLat=" + this.g + ", locationLng=" + this.h + ", watchersCount=" + this.i + ", watchersCountRef=" + this.j + ", watchersCountRefDate=" + this.k + ", groupEnterCount=" + this.l + ", tags='" + this.m + '\'' + ", tagLine='" + this.n + '\'' + ", lastLocalMessageId=" + this.o + ", lastServerMessageId=" + this.p + ", lastReadMessageId=" + this.y + ", flags=" + this.q + ", inviter='" + this.r + '\'' + ", invitationToken='" + this.s + '\'' + ", lastMediaType=" + this.t + ", lastMessageText='" + this.u + '\'' + ", senderPhone='" + this.v + '\'' + ", senderName='" + this.w + '\'' + ", senderPhotoId='" + this.x + '\'' + ", extraFlags=" + this.z + ", webhookExists=" + this.B + ", subscriptionStatus=" + this.E + ", website='" + this.C + '\'' + ", email='" + this.D + '\'' + ", authToken='" + this.F + '\'' + ", categoryId='" + this.G + '\'' + ", subCategoryId='" + this.H + '\'' + ", crm='" + this.I + '\'' + ", subscribersCount=" + this.J + ", extraInfo='" + this.K + '\'' + ", communityPrivileges='" + this.L + '\'' + ", chatBackground='" + this.M + '\'' + ", customChatBackground='" + this.N + '\'' + ", mySettings='" + this.O + '\'' + '}';
  }

  public String u()
  {
    return this.n;
  }

  public void u(String paramString)
  {
    this.K = paramString;
  }

  public int v()
  {
    return this.o;
  }

  public void v(String paramString)
  {
    this.M = paramString;
  }

  public String w()
  {
    return this.f;
  }

  public void w(String paramString)
  {
    this.N = paramString;
  }

  public int x()
  {
    return this.q;
  }

  public void x(String paramString)
  {
    this.O = paramString;
  }

  public boolean y()
  {
    return (0x1 & this.q) != 0;
  }

  public boolean z()
  {
    return (0x20 & this.q) != 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.r
 * JD-Core Version:    0.6.2
 */