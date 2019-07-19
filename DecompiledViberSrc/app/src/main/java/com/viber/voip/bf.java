package com.viber.voip;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.viber.voip.e.a.c;
import com.viber.voip.registration.ao;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class bf
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();
  private Context b;

  @Inject
  public bf(Context paramContext)
  {
    this.b = paramContext;
  }

  private void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, false);
  }

  private void d(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      a("com.viber.voip.publicaccount.ui.screen.info.PublicAccountInfoActivity", bool);
      a("com.viber.voip.publicaccount.ui.screen.info.tablet.PublicAccountInfoTabletActivity", paramBoolean);
      return;
    }
  }

  private void e(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      a("com.viber.voip.messages.conversation.publicaccount.PublicChatsActivity", bool);
      a("com.viber.voip.TabletPublicChatsActivity", paramBoolean);
      return;
    }
  }

  private void f(boolean paramBoolean)
  {
    boolean bool1 = true;
    a("com.viber.voip.HomeConversationActivity", paramBoolean);
    boolean bool2;
    if (!paramBoolean)
    {
      bool2 = bool1;
      a("com.viber.voip.messages.ui.ConversationActivity", bool2);
      if (paramBoolean)
        break label39;
    }
    while (true)
    {
      a("com.viber.voip.messages.ui.PublicAccountConversationActivity", bool1);
      return;
      bool2 = false;
      break;
      label39: bool1 = false;
    }
  }

  private void g(boolean paramBoolean)
  {
    a("com.viber.voip.HomeContactDetailsActivity", paramBoolean);
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      a("com.viber.voip.contacts.ui.ContactDetailsActivity", bool);
      return;
    }
  }

  private void h(boolean paramBoolean)
  {
    a("com.viber.voip.HomeMoreActivity", paramBoolean);
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      a("com.viber.voip.user.more.MoreActivity", bool);
      return;
    }
  }

  private void i(boolean paramBoolean)
  {
    a("com.viber.voip.settings.ui.SettingsTabletActivity", paramBoolean);
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      a("com.viber.voip.settings.ui.SettingsHeadersActivity", bool);
      return;
    }
  }

  public void a()
  {
    a("com.viber.voip.TabletHomeActivity", true);
    a("com.viber.voip.HomeActivity", true);
  }

  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    PackageManager localPackageManager = this.b.getPackageManager();
    ComponentName localComponentName = new ComponentName(this.b, paramString);
    int j;
    if (paramBoolean1)
      j = i;
    while (true)
    {
      if (paramBoolean2)
        i = 0;
      try
      {
        localPackageManager.setComponentEnabledSetting(localComponentName, j, i);
        return;
        j = 2;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
      }
    }
  }

  public void a(boolean paramBoolean)
  {
    com.viber.voip.e.a.e.b().a("APP START", "initiateComponents");
    f(paramBoolean);
    g(paramBoolean);
    h(paramBoolean);
    i(paramBoolean);
    c(paramBoolean);
    b(ao.g());
    e(paramBoolean);
    d(paramBoolean);
    a("com.viber.deviceinfo.WidgetProvider", false);
    a("com.viber.voip.registration.DebugAuthSecondaryActivity", false);
    com.viber.voip.e.a.e.b().b("APP START", "initiateComponents");
  }

  public void b(boolean paramBoolean)
  {
    a("com.viber.service.contacts.sync.ContactsSyncAccountService", paramBoolean);
    a("com.viber.service.contacts.authentication.AccountAuthenticatorService", paramBoolean);
    a("com.viber.service.contacts.contactbook.AccountContactbookService", paramBoolean);
  }

  public void c(boolean paramBoolean)
  {
    a("com.viber.voip.TabletHomeActivity", paramBoolean);
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      a("com.viber.voip.HomeActivity", bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bf
 * JD-Core Version:    0.6.2
 */