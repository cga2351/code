package com.viber.backup.a;

import android.accounts.Account;
import android.content.Context;
import com.viber.backup.drive.KeychainBackupInfo;
import com.viber.backup.drive.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.a.c.a;
import com.viber.voip.backup.b.h;
import com.viber.voip.backup.l;
import com.viber.voip.util.ax;
import com.viber.voip.util.da;
import com.viber.voip.util.w;
import java.io.IOException;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final e c;
  private final com.viber.common.permission.c d;
  private final com.viber.voip.backup.b.b e;
  private final d f;

  public a(Context paramContext, e parame, com.viber.common.permission.c paramc, com.viber.voip.backup.b.b paramb, d paramd)
  {
    this.b = paramContext;
    this.c = parame;
    this.d = paramc;
    this.e = paramb;
    this.f = paramd;
  }

  private com.viber.backup.drive.f a(String paramString)
  {
    return new com.viber.backup.drive.f(paramString, this.e.b());
  }

  private void a(String paramString, int paramInt)
  {
  }

  private boolean a(f paramf, String paramString)
  {
    try
    {
      a(paramf.a).a(paramString, paramf.c, new b(this));
      return true;
    }
    catch (com.viber.voip.k.b localb)
    {
      this.e.a(null);
      return false;
    }
    catch (SecurityException localSecurityException)
    {
      break label28;
    }
    catch (IOException localIOException)
    {
      label28: label36: break label36;
    }
  }

  private boolean a(com.viber.voip.backup.b.b paramb)
  {
    if (paramb.d());
    do
    {
      return true;
      if (!c())
        return false;
      paramb.a();
    }
    while (paramb.d());
    Account[] arrayOfAccount = ax.c(this.b);
    if ((com.viber.voip.util.n.a(arrayOfAccount)) || (arrayOfAccount.length > 1))
    {
      this.f.d(true);
      return false;
    }
    paramb.a(arrayOfAccount[0].name);
    return true;
  }

  private boolean b()
  {
    return (this.e.d()) && (c());
  }

  private boolean c()
  {
    return this.d.a(com.viber.voip.permissions.n.j);
  }

  private KeychainBackupInfo d()
  {
    a locala = new a(null);
    this.c.a(locala);
    this.c.a();
    return (KeychainBackupInfo)locala.getSafe();
  }

  private boolean d(f paramf)
  {
    try
    {
      com.viber.backup.drive.f localf = a(paramf.a);
      com.google.a.b.a.a.a locala = l.a(localf.a());
      if (locala != null);
      for (String str = locala.e(); ; str = null)
      {
        localf.a(str, paramf.b, paramf.c, new c(this), new h());
        return true;
      }
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (com.viber.voip.k.b localb)
    {
      this.f.e(true);
      return false;
    }
    catch (SecurityException localSecurityException)
    {
      label76: break label76;
    }
  }

  private boolean e(f paramf)
  {
    try
    {
      com.viber.backup.drive.f localf = a(paramf.a);
      com.google.a.b.a.a.a locala = l.a(localf.a());
      if (locala != null)
        localf.a(locala.e());
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (com.viber.voip.k.b localb)
    {
      this.f.e(true);
      return false;
    }
    catch (SecurityException localSecurityException)
    {
      label42: break label42;
    }
  }

  public void a()
  {
    this.f.a(true);
  }

  public boolean a(f paramf)
  {
    boolean bool1 = a(this.e);
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = d(paramf);
      bool2 = false;
      if (bool3)
      {
        this.f.a(false);
        bool2 = true;
      }
    }
    return bool2;
  }

  public boolean a(f paramf, boolean paramBoolean)
  {
    if (!c());
    do
      while (true)
      {
        return false;
        KeychainBackupInfo localKeychainBackupInfo = d();
        if ((localKeychainBackupInfo == null) || (!localKeychainBackupInfo.isBackupExists()))
          break;
        this.e.a(localKeychainBackupInfo.getAccount());
        if ((!paramBoolean) || (localKeychainBackupInfo.getKeychainUpdatedTimeMillis() > paramf.b));
        for (int i = 1; i != 0; i = 0)
          return a(paramf, localKeychainBackupInfo.getDriveFileId());
      }
    while (!a(this.e));
    return false;
  }

  public boolean a(String paramString, f paramf)
  {
    String str = this.e.b().c();
    if (!c())
      return false;
    int i;
    if (this.e.d())
      if (!e(paramf))
      {
        i = 0;
        this.f.h();
      }
    while (true)
    {
      this.e.a(paramString);
      if (this.e.d())
      {
        if (!d(paramf))
        {
          if ((i != 0) || (da.a(str)))
          {
            this.f.a(true);
            this.f.c(false);
            return false;
          }
          this.e.a(str);
          this.f.c(true);
          return false;
        }
        this.f.c(false);
        return true;
      }
      this.f.c(false);
      return false;
      i = 1;
      break;
      i = 1;
    }
  }

  public boolean b(f paramf)
  {
    if (!b());
    while ((!a(this.e)) || (!e(paramf)))
      return false;
    this.f.b(false);
    return true;
  }

  public void c(f paramf)
  {
    b(paramf);
    this.e.a(null);
    this.f.c();
  }

  private static class a extends w<KeychainBackupInfo>
    implements c.a<KeychainBackupInfo>
  {
    private static final Logger a = ViberEnv.getLogger();

    public void a(KeychainBackupInfo paramKeychainBackupInfo)
    {
      setResult(paramKeychainBackupInfo);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.a.a
 * JD-Core Version:    0.6.2
 */