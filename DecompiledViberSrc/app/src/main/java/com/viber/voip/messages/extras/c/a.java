package com.viber.voip.messages.extras.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.o;
import com.viber.voip.registration.af;
import com.viber.voip.user.SocialUserDetails;
import com.viber.voip.user.UserManager;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;
import com.vk.sdk.VKServiceActivity.VKServiceType;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKRequest.VKRequestListener;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.methods.VKApiUsers;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final List<String> b = Arrays.asList(new String[] { "RU", "UA", "BY", "AM", "MD", "KZ" });
  private static final String[] c = { "friends", "email" };
  private WeakReference<a> d;
  private VKResponse e;
  private long f;
  private final Engine g = ViberApplication.getInstance().getEngine(false);
  private final com.viber.voip.analytics.story.g.a h;

  public a(g paramg)
  {
    this.h = paramg.c().c();
  }

  public static boolean d()
  {
    return b.contains(e());
  }

  private static String e()
  {
    return UserManager.from(ViberApplication.getApplication()).getRegistrationValues().e();
  }

  public void a()
  {
    VKSdk.logout();
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == VKServiceActivity.VKServiceType.Authorization.getOuterCode()) && (paramInt2 == -1))
      if (this.d != null)
        break label92;
    label92: for (a locala = null; ; locala = (a)this.d.get())
    {
      if (locala != null)
      {
        locala.onAuthComplete();
        if ((this.g.isInitialized()) && (VKAccessToken.currentToken() != null))
        {
          this.g.getCdrController().handleReportFacebookStatistics(VKAccessToken.currentToken().userId, VKAccessToken.currentToken().accessToken, 1);
          this.h.a("VK", true);
        }
      }
      return;
    }
  }

  public void a(Activity paramActivity, a parama)
  {
    long l = System.currentTimeMillis() - this.f;
    if ((l < 0L) || (l > 1000L))
    {
      this.f = System.currentTimeMillis();
      this.d = new WeakReference(parama);
      if (VKAccessToken.currentToken() != null)
        break label56;
      VKSdk.login(paramActivity, c);
    }
    label56: 
    while (this.d.get() == null)
      return;
    ((a)this.d.get()).onAuthComplete();
  }

  public void a(Context paramContext)
  {
    VKSdk.initialize(paramContext);
  }

  public void b()
  {
    VKParameters localVKParameters = new VKParameters();
    localVKParameters.put("fields", "photo_max");
    VKApi.users().get(localVKParameters).executeWithListener(new VKRequest.VKRequestListener()
    {
      public void onComplete(VKResponse paramAnonymousVKResponse)
      {
        if (a.a(a.this) == null);
        for (a.a locala = null; ; locala = (a.a)a.a(a.this).get())
        {
          super.onComplete(paramAnonymousVKResponse);
          a.a(a.this, paramAnonymousVKResponse);
          if (locala != null)
            locala.onUserDetailsReady(paramAnonymousVKResponse);
          return;
        }
      }
    });
  }

  public VKResponse c()
  {
    return this.e;
  }

  public static abstract interface a
  {
    public abstract void onAuthComplete();

    public abstract void onAuthError();

    public abstract void onGetUserDetails(SocialUserDetails paramSocialUserDetails);

    public abstract void onUserDetailsReady(VKResponse paramVKResponse);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.c.a
 * JD-Core Version:    0.6.2
 */