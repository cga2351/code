package com.viber.voip.schedule;

import android.app.Application;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.viber.backup.a.d;
import com.viber.backup.a.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;

public class q
  implements f
{
  private static final Logger a = ViberEnv.getLogger();

  private void a()
    throws DeadObjectException
  {
    Application localApplication = ViberApplication.getApplication();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    boolean bool = ViberApplication.isActivated();
    d locald = d.a(localApplication);
    if (!bool);
    e locale;
    do
    {
      return;
      locale = localViberApplication.getBackupManager();
      if (locald.d())
      {
        locale.c();
        return;
      }
      if (locald.e())
      {
        locale.a(com.viber.voip.backup.f.b().a());
        return;
      }
    }
    while (!locald.f());
    locale.d();
  }

  public int a(Bundle paramBundle)
  {
    try
    {
      a();
      return 0;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      while (true)
        a.a(localDeadObjectException, "Upload to fallback storage is failed");
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
        a.a(localRuntimeException, "Upload to fallback storage is failed");
    }
    catch (NullPointerException localNullPointerException)
    {
      break label7;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label7;
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      label7: break label7;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.q
 * JD-Core Version:    0.6.2
 */