package com.viber.voip.util;

import android.net.Uri;
import android.text.TextUtils;
import com.crashlytics.android.a;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.d.b;
import com.viber.voip.settings.d.p;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;

public class cd
{
  public static Uri a(com.viber.voip.model.entity.m paramm)
  {
    return a(paramm.isOwner(), paramm.e(), paramm.l(), paramm.i(), paramm.r());
  }

  public static Uri a(boolean paramBoolean1, String paramString, long paramLong1, long paramLong2, boolean paramBoolean2)
  {
    if (paramBoolean1)
      return UserManager.from(ViberApplication.getApplication()).getUserData().getImage();
    if (paramBoolean2)
      return Uri.parse("android.resource://com.viber.voip/drawable/icon_viber_message");
    if (!da.a(paramString))
      return Uri.parse(paramString);
    if (paramLong1 > 0L)
      return x.a(paramLong2);
    return null;
  }

  public static Member a(Member paramMember)
  {
    String str = d(paramMember.getId());
    if (str != null)
      return new Member(str);
    return null;
  }

  public static void a(String paramString1, String paramString2, String paramString3, Uri paramUri)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (e(paramString1)) && ((paramUri == null) || (ViberApplication.getInstance().getDownloadValve().c(paramUri.toString()))))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Wrong format Download ID");
      if (c.a.a.a.c.i())
      {
        if (!TextUtils.isEmpty(paramString2))
          a.a("User Id", paramString2);
        a.a("Avatar Id", paramString1);
      }
      ViberEnv.getLogger().a(localIllegalArgumentException, paramString3);
    }
  }

  public static boolean a()
  {
    int i = d.p.t.d();
    return (i == 3) || (i == 4);
  }

  public static boolean a(int paramInt)
  {
    return (d(paramInt)) || (e(paramInt));
  }

  public static boolean a(int paramInt1, int paramInt2)
  {
    if (com.viber.voip.messages.m.e(paramInt1))
      return g(paramInt2);
    return true;
  }

  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (com.viber.voip.messages.m.b(paramInt3)) && (((c(paramInt1)) && (!c(paramInt2))) || ((a(paramInt1)) && (f(paramInt2))));
  }

  public static boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return (com.viber.voip.messages.m.b(paramInt2)) && (!paramBoolean) && ((c(paramInt1)) || ((d(paramInt1)) && (f(paramInt3))));
  }

  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return (a(paramInt1, paramInt2)) || ((com.viber.voip.messages.m.b(paramInt1)) && (f(paramInt2)) && (paramBoolean));
  }

  public static boolean a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return (c(paramInt1)) || ((d(paramInt1)) && ((paramBoolean) || (f(paramInt2)))) || ((f(paramInt1)) && (paramBoolean));
  }

  public static boolean a(long paramLong, int paramInt)
  {
    boolean bool1 = paramLong < 0L;
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = av.c(paramInt, 0);
      bool2 = false;
      if (!bool3)
        bool2 = true;
    }
    return bool2;
  }

  public static boolean a(String paramString)
  {
    return (!da.a(paramString)) && (paramString.length() == 12) && (paramString.endsWith("="));
  }

  public static boolean b(int paramInt)
  {
    return (a(paramInt)) || (c(paramInt));
  }

  public static boolean b(int paramInt1, int paramInt2)
  {
    return (com.viber.voip.messages.m.b(paramInt2)) && (b(paramInt1));
  }

  public static boolean b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return (!paramBoolean) && (com.viber.voip.messages.m.b(paramInt2)) && (c(paramInt1)) && (!ViberApplication.isTablet(ViberApplication.getApplication()));
  }

  public static boolean b(String paramString)
  {
    return (!da.a(paramString)) && (paramString.length() == 28) && (paramString.endsWith("="));
  }

  public static boolean c(int paramInt)
  {
    return paramInt == 2;
  }

  public static boolean c(int paramInt1, int paramInt2)
  {
    return ((com.viber.voip.messages.m.f(paramInt2)) || (com.viber.voip.messages.m.b(paramInt2))) && (c(paramInt1));
  }

  public static boolean c(String paramString)
  {
    return (!da.a(paramString)) && (paramString.startsWith("em:"));
  }

  public static String d(String paramString)
  {
    com.viber.voip.model.entity.m localm = com.viber.voip.messages.d.c.c().c(paramString, 1);
    if (localm != null)
    {
      if (c(paramString));
      for (String str = localm.a(); (!da.a(str)) && (!str.equals(paramString)); str = localm.b())
        return str;
    }
    return null;
  }

  public static boolean d(int paramInt)
  {
    return paramInt == 1;
  }

  public static boolean d(int paramInt1, int paramInt2)
  {
    if (com.viber.voip.messages.m.c(paramInt2))
      return false;
    return c(paramInt1);
  }

  public static boolean e(int paramInt)
  {
    return paramInt == 4;
  }

  public static boolean e(int paramInt1, int paramInt2)
  {
    return (com.viber.voip.messages.m.b(paramInt2)) && (c(paramInt1));
  }

  public static boolean e(String paramString)
  {
    return paramString.startsWith("0.");
  }

  public static boolean f(int paramInt)
  {
    return paramInt == 3;
  }

  public static boolean f(int paramInt1, int paramInt2)
  {
    if (com.viber.voip.messages.m.c(paramInt2))
      return false;
    if (com.viber.voip.messages.m.b(paramInt2))
      return c(paramInt1);
    return b(paramInt1);
  }

  public static boolean g(int paramInt)
  {
    return (c(paramInt)) || (d(paramInt)) || (paramInt == 0);
  }

  public static boolean g(int paramInt1, int paramInt2)
  {
    if (com.viber.voip.messages.m.a(paramInt2))
      return c(paramInt1);
    if (com.viber.voip.messages.m.b(paramInt2))
      return (c(paramInt1)) || (d(paramInt1));
    return b(paramInt1);
  }

  public static boolean h(int paramInt)
  {
    return paramInt == 2;
  }

  public static boolean h(int paramInt1, int paramInt2)
  {
    return (com.viber.voip.messages.m.b(paramInt2)) && (f(paramInt1));
  }

  public static boolean i(int paramInt)
  {
    return av.c(paramInt, 1);
  }

  public static boolean i(int paramInt1, int paramInt2)
  {
    return (com.viber.voip.messages.m.b(paramInt2)) && (b(paramInt1));
  }

  public static int j(int paramInt)
  {
    if (com.viber.voip.messages.m.b(paramInt))
      return 2;
    return 1;
  }

  public static boolean j(int paramInt1, int paramInt2)
  {
    boolean bool = com.viber.voip.messages.m.c(paramInt1);
    if ((bool) && (paramInt2 <= 50));
    while ((!bool) && (paramInt2 < 250))
      return true;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cd
 * JD-Core Version:    0.6.2
 */