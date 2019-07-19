package com.viber.voip.vln;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.react.ReactContextManager;
import com.viber.voip.react.ReactContextManager.Params;
import com.viber.voip.react.ReactContextManager.a;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import dagger.a;

public class e
{
  private static final Logger a = ViberEnv.getLogger();
  private final ViberApplication b;
  private final a<ReactContextManager> c;
  private final UserManager d;

  public e(ViberApplication paramViberApplication, a<ReactContextManager> parama, UserManager paramUserManager)
  {
    this.b = paramViberApplication;
    this.c = parama;
    this.d = paramUserManager;
  }

  public void a()
  {
    a(false);
  }

  public void a(boolean paramBoolean)
  {
    this.b.logToCrashlytics("REACT NATIVE||VLN||Startup performance improvement - init context");
    ReactContextManager.Params localParams = ReactContextManager.a("ReactVLN", true).a(this.d.getRegistrationValues().l()).b(this.d.getRegistrationValues().g()).b(paramBoolean).a();
    ((ReactContextManager)this.c.get()).a(localParams);
  }

  public void b()
  {
    b(false);
  }

  public void b(boolean paramBoolean)
  {
    this.b.logToCrashlytics("REACT NATIVE||VLN||Startup performance improvement - destroy context");
    ReactContextManager.Params localParams = ReactContextManager.a("ReactVLN", false).a(paramBoolean).a();
    ((ReactContextManager)this.c.get()).a(localParams);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.e
 * JD-Core Version:    0.6.2
 */