package com.viber.voip.apps;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.apps.AppsController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.action.r;
import com.viber.voip.api.scheme.action.r.a;
import com.viber.voip.apps.model.AuthInfo;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.h;
import com.viber.voip.publicaccount.entity.PublicAccount;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;

public class c
{
  public static final Logger a = ViberEnv.getLogger();
  private static final Pattern b = Pattern.compile("\\d+");
  private f c = g.a();
  private f.a d;
  private f.a e = new d(this);
  private AuthInfo f;
  private WeakReference<Context> g;

  public static String a(int paramInt1, int paramInt2, String paramString)
  {
    return new Uri.Builder().scheme("vb" + paramInt1).path("//auth-result").appendQueryParameter("authorized", String.valueOf(paramInt2)).appendQueryParameter("token", paramString).build().toString();
  }

  private void a(String paramString1, final int paramInt1, final int paramInt2, final String paramString2, Context paramContext)
  {
    new r(null, paramString1, new r.a()
    {
      public void a()
      {
        c.a(c.this, paramInt1, paramInt2, paramString2);
      }

      public void a(boolean paramAnonymousBoolean, PublicAccount paramAnonymousPublicAccount)
      {
        if (paramAnonymousPublicAccount == null)
        {
          a();
          return;
        }
        bs localbs = new bs(ViberApplication.getApplication());
        String str = paramAnonymousPublicAccount.getPublicAccountId();
        h localh = localbs.a(0, new Member(str, str), 0L, paramAnonymousPublicAccount, 0, true, false, 0);
        if (localh != null)
        {
          ViberApplication.getInstance().getMessagesManager().h().a(1, localh.getId(), "", str);
          c.a(c.this, paramInt1, paramInt2, paramString2);
          return;
        }
        a();
      }
    }).a(paramContext, new e(this, paramInt1, paramInt2, paramString2));
  }

  private void d(int paramInt1, int paramInt2, String paramString)
  {
    if (this.d != null)
      this.d.a(paramInt1, paramInt2, paramString);
  }

  public AuthInfo a()
  {
    return this.f;
  }

  public void a(f.a parama)
  {
    this.c.b(this.e);
    if (parama != null)
    {
      this.d = parama;
      this.c.a(this.e);
    }
  }

  public void a(AuthInfo paramAuthInfo)
  {
    this.f = paramAuthInfo;
  }

  public void a(AuthInfo paramAuthInfo, Context paramContext)
  {
    int i = 1;
    this.g = new WeakReference(paramContext);
    this.f = paramAuthInfo;
    if (this.f == null)
      return;
    Engine localEngine = ViberApplication.getInstance().getEngine(i);
    if (paramAuthInfo.getAuthType() == i);
    while (true)
    {
      localEngine.getAppsController().handleAuthenticateApp(this.f.getAppId(), this.f.getIdentifier(), this.f.getScope(), localEngine.getPhoneController().generateSequence(), i);
      return;
      int j = 0;
    }
  }

  public void b(AuthInfo paramAuthInfo)
  {
    a(paramAuthInfo, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.apps.c
 * JD-Core Version:    0.6.2
 */