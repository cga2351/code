package com.viber.backup.a;

import android.app.backup.BackupManager;
import android.app.backup.RestoreObserver;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.s;
import com.viber.voip.util.f.a;

public class g
{
  private static final Logger a = ViberEnv.getLogger();
  private final BackupManager b;
  private final RestoreObserver c = new RestoreObserver()
  {
    public void onUpdate(int paramAnonymousInt, String paramAnonymousString)
    {
    }

    public void restoreFinished(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 0)
        s.a(s.c);
    }

    public void restoreStarting(int paramAnonymousInt)
    {
    }
  };

  public g(BackupManager paramBackupManager)
  {
    this.b = paramBackupManager;
  }

  public void a()
  {
    try
    {
      if (!a.a())
        this.b.requestRestore(this.c);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void b()
  {
    this.b.dataChanged();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.a.g
 * JD-Core Version:    0.6.2
 */