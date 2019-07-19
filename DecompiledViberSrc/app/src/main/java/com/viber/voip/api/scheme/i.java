package com.viber.voip.api.scheme;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.SecureActivationController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.apps.model.AuthInfo;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.util.dk;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import com.viber.voip.util.z;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class i
{
  private static final Logger a = ViberEnv.getLogger();

  @SafeVarargs
  public static Uri a(g paramg, Pair<String, String>[] paramArrayOfPair)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("viber");
    localBuilder.authority(paramg.a());
    if (!TextUtils.isEmpty(paramg.b()))
      localBuilder.path(paramg.b());
    int i = paramArrayOfPair.length;
    for (int j = 0; j < i; j++)
    {
      Pair<String, String> localPair = paramArrayOfPair[j];
      if (localPair != null)
        localBuilder.appendQueryParameter((String)localPair.first, (String)localPair.second);
    }
    return localBuilder.build();
  }

  public static ActivationController a()
  {
    return ViberApplication.getInstance().getActivationController();
  }

  public static String a(String paramString)
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = Pair.create("chat", paramString);
    return a(e.c, arrayOfPair).toString();
  }

  public static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "1"; ; str = "0")
    {
      a locala = a.f;
      Pair[] arrayOfPair = new Pair[3];
      arrayOfPair[0] = Pair.create("u", paramString1);
      arrayOfPair[1] = Pair.create("k", paramString2);
      arrayOfPair[2] = Pair.create("r", str);
      return a(locala, arrayOfPair).toString();
    }
  }

  public static Set<String> a(Uri paramUri)
  {
    if (paramUri.isOpaque())
      throw new UnsupportedOperationException("This isn't a hierarchical URI.");
    String str = paramUri.getEncodedQuery();
    if (str == null)
      return Collections.emptySet();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int i = 0;
    do
    {
      int j = str.indexOf('&', i);
      if (j == -1)
        j = str.length();
      int k = str.indexOf('=', i);
      if ((k > j) || (k == -1))
        k = j;
      localLinkedHashSet.add(Uri.decode(str.substring(i, k)));
      i = j + 1;
    }
    while (i < str.length());
    return Collections.unmodifiableSet(localLinkedHashSet);
  }

  public static void a(Uri paramUri, String paramString)
  {
    if (!a.h.a(paramUri, a.f))
      return;
    String str1 = paramUri.getQueryParameter("u");
    String str2 = paramUri.getQueryParameter("k");
    boolean bool = "1".equals(paramUri.getQueryParameter("r"));
    try
    {
      int j = Integer.parseInt(paramUri.getQueryParameter("v"));
      i = j;
      ViberApplication.getInstance().getEngine(true).getSecureActivationController().handleSecondaryQRPhotographed(z.b(str1), str2, bool, i);
      d().post(new j(paramString));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        int i = 0;
    }
  }

  private static void a(final c paramc)
  {
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    final ConnectionListener localConnectionListener = localEngine.getDelegatesManager().getConnectionListener();
    a local2 = new a()
    {
      public void onConnect()
      {
      }

      public void onConnectionStateChange(int paramAnonymousInt)
      {
        if (this.a.getPhoneController().isConnected())
        {
          i.c().removeCallbacks(this);
          localConnectionListener.removeDelegate(this);
          paramc.a(this.a);
        }
      }

      public void run()
      {
        localConnectionListener.removeDelegate(this);
        paramc.a();
      }
    };
    if (localEngine.getPhoneController().isConnected())
    {
      paramc.a(localEngine);
      return;
    }
    d().postDelayed(local2, 3000L);
    localConnectionListener.registerDelegate(new ConnectionDelegate[] { local2 });
  }

  public static void a(String paramString, final b paramb)
  {
    a(new c()
    {
      public void a()
      {
        paramb.a();
      }

      public void a(Engine paramAnonymousEngine)
      {
        dr.a(this.a, new dr.a()
        {
          public void onCheckStatus(boolean paramAnonymous2Boolean, int paramAnonymous2Int, ParticipantSelector.Participant paramAnonymous2Participant, com.viber.voip.model.entity.g paramAnonymous2g)
          {
            i.1.this.b.a(paramAnonymous2Int, paramAnonymous2Participant.getNumber(), paramAnonymous2g);
          }
        });
      }
    });
  }

  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
      return true;
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
      return false;
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      return false;
    String str1 = Uri.parse(paramString1).getSchemeSpecificPart();
    int i = str1.length();
    if (str1.charAt(i - 1) == '/')
      str1 = str1.substring(0, i - 1);
    String str2 = Uri.parse(paramString2).getSchemeSpecificPart();
    int j = str2.length();
    if (str2.charAt(j - 1) == '/')
      str2 = str2.substring(0, j - 1);
    return str1.equalsIgnoreCase(str2);
  }

  public static String b()
  {
    return a(o.a, new Pair[0]).toString();
  }

  public static String b(String paramString)
  {
    Pair[] arrayOfPair = new Pair[3];
    arrayOfPair[0] = Pair.create("uri", paramString);
    arrayOfPair[1] = Pair.create("from-invite", Boolean.FALSE.toString());
    return a(e.e, arrayOfPair).toString();
  }

  public static boolean b(Uri paramUri)
  {
    if (!a.h.a(paramUri, a.f));
    String str1;
    String str2;
    do
    {
      return false;
      str1 = paramUri.getQueryParameter("k");
      str2 = paramUri.getQueryParameter("u");
    }
    while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (str2.length() % 2 != 0));
    return true;
  }

  public static String c(String paramString)
  {
    Pair[] arrayOfPair = new Pair[3];
    arrayOfPair[0] = Pair.create("lastchat", "1");
    arrayOfPair[1] = Pair.create("silent", "1");
    if (!TextUtils.isEmpty(paramString));
    for (Pair localPair = Pair.create("service", paramString); ; localPair = null)
    {
      arrayOfPair[2] = localPair;
      return a(e.q, arrayOfPair).toString();
    }
  }

  public static boolean c(Uri paramUri)
  {
    return (a.h.a(paramUri, a.f)) && (h(paramUri));
  }

  private static Handler d()
  {
    return av.a(av.e.f);
  }

  public static String d(String paramString)
  {
    c localc = c.a;
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = Pair.create("number", paramString);
    return a(localc, arrayOfPair).toString();
  }

  public static boolean d(Uri paramUri)
  {
    return (a.h.a(paramUri, a.g)) && (h(paramUri));
  }

  public static AuthInfo e(Uri paramUri)
  {
    int i = 1;
    String str1 = paramUri.getAuthority();
    String str2 = paramUri.getQueryParameter("scope");
    String str3 = paramUri.getQueryParameter("app-id");
    String str4 = paramUri.getQueryParameter("identifier");
    boolean bool = paramUri.getBooleanQueryParameter("confirm", i);
    AuthInfo localAuthInfo = new AuthInfo();
    if (a.g.a().equals(str1));
    while (true)
    {
      localAuthInfo.setAuthType(i);
      localAuthInfo.setScope(Integer.parseInt(str2));
      localAuthInfo.setAppId(Integer.parseInt(str3));
      localAuthInfo.setIdentifier(str4);
      localAuthInfo.setNeedConfirmation(bool);
      return localAuthInfo;
      int j = 0;
    }
  }

  public static String f(Uri paramUri)
  {
    if (dk.g(paramUri))
      return paramUri.getQueryParameter("number");
    return null;
  }

  public static int g(Uri paramUri)
  {
    if (!dk.g(paramUri));
    String str;
    do
    {
      return -1;
      str = paramUri.getQueryParameter("orientation");
    }
    while (TextUtils.isEmpty(str));
    label56: int i;
    switch (str.hashCode())
    {
    default:
      i = -1;
    case 729267099:
    case 1430647483:
    }
    while (true)
      switch (i)
      {
      default:
        return -1;
      case 0:
        return 1;
        if (!str.equals("portrait"))
          break label56;
        i = 0;
        continue;
        if (!str.equals("landscape"))
          break label56;
        i = 1;
      case 1:
      }
    return 0;
  }

  private static boolean h(Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("app-id");
    String str2 = paramUri.getQueryParameter("scope");
    String str3 = paramUri.getQueryParameter("identifier");
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (str2.matches("[0-7]")) && (str1.matches("\\d+"));
  }

  private static abstract interface a extends ConnectionDelegate, Runnable
  {
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(int paramInt, String paramString, com.viber.voip.model.entity.g paramg);
  }

  private static abstract interface c
  {
    public abstract void a();

    public abstract void a(Engine paramEngine);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.i
 * JD-Core Version:    0.6.2
 */