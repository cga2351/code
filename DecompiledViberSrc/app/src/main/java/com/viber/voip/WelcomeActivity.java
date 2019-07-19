package com.viber.voip;

import android.content.Intent;
import android.os.Bundle;
import com.viber.common.app.a;
import com.viber.dexshared.Logger;
import com.viber.voip.contacts.ui.ContactDetailsActivity;
import com.viber.voip.e.a.c;
import com.viber.voip.e.a.e;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.settings.b.b;
import com.viber.voip.settings.b.e.a;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.bb;
import java.util.Set;

public class WelcomeActivity extends ViberAppCompatActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private boolean b;

  private void a()
  {
    e.b().a("APP START", "checkRegistration");
    if (c())
    {
      b();
      return;
    }
    e.b().b("APP START", "checkRegistration");
  }

  private boolean a(Intent paramIntent)
  {
    Set localSet = paramIntent.getCategories();
    return ("android.intent.action.MAIN".equals(paramIntent.getAction())) && (localSet != null) && (localSet.contains("android.intent.category.LAUNCHER"));
  }

  private void b()
  {
    Intent localIntent = getIntent();
    int i = localIntent.getFlags();
    localIntent.setFlags(i & 0x3);
    if (("android.intent.action.VIEW".equals(localIntent.getAction())) && ("tel".equals(localIntent.getScheme())))
    {
      localIntent.putExtra("EXTRA_RETURN_TO_HOME", true);
      localIntent.setClass(this, ContactDetailsActivity.class);
      bb.a(this, localIntent, true);
      return;
    }
    if ((!isTaskRoot()) && (a(localIntent)))
    {
      finish();
      return;
    }
    localIntent.setClass(this, ViberActionRunner.ab.a(ViberApplication.isTablet(this)));
    localIntent.putExtra("EXTRA_FROM_LAUNCH_ACTIVITY", true);
    if ((i & 0x100000) != 0)
      localIntent.removeExtra("extra_community_follower_data");
    e.b().b("APP START", "checkRegistration");
    a.a(this, localIntent);
    finish();
  }

  private boolean c()
  {
    ActivationController localActivationController = ViberApplication.getInstance().getActivationController();
    if ((ViberApplication.isActivated()) && ((localActivationController.isActivationCompleted()) || (localActivationController.isSecureActivation())))
      return true;
    localActivationController.restoreLastRegisteredCodeNumber();
    localActivationController.resumeActivation();
    return false;
  }

  protected void onCreate(Bundle paramBundle)
  {
    e.b().a("APP START", "total", "WelcomeActivity onCreate");
    super.onCreate(paramBundle);
    if (!e.a.s.d())
      e.a.s.a(true);
    a();
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onNewIntent(Intent paramIntent)
  {
    this.b = false;
    setIntent(paramIntent);
    a();
  }

  protected void onResume()
  {
    if (this.b)
    {
      this.b = false;
      finish();
    }
    while (true)
    {
      super.onResume();
      return;
      this.b = true;
    }
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(new bs(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new bq(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    a.a(new br(this, paramIntent, paramInt), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.WelcomeActivity
 * JD-Core Version:    0.6.2
 */