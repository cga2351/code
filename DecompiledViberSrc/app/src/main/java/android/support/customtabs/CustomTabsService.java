package android.support.customtabs;

import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service
{
  private final Map<IBinder, IBinder.DeathRecipient> a = new ArrayMap();
  private f.a b = new f.a()
  {
    public int a(e paramAnonymouse, String paramAnonymousString, Bundle paramAnonymousBundle)
    {
      return CustomTabsService.this.a(new d(paramAnonymouse), paramAnonymousString, paramAnonymousBundle);
    }

    public Bundle a(String paramAnonymousString, Bundle paramAnonymousBundle)
    {
      return CustomTabsService.this.a(paramAnonymousString, paramAnonymousBundle);
    }

    public boolean a(long paramAnonymousLong)
    {
      return CustomTabsService.this.a(paramAnonymousLong);
    }

    public boolean a(e paramAnonymouse)
    {
      final d locald = new d(paramAnonymouse);
      try
      {
        IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
        {
          public void binderDied()
          {
            CustomTabsService.this.a(locald);
          }
        };
        synchronized (CustomTabsService.a(CustomTabsService.this))
        {
          paramAnonymouse.asBinder().linkToDeath(local1, 0);
          CustomTabsService.a(CustomTabsService.this).put(paramAnonymouse.asBinder(), local1);
          boolean bool = CustomTabsService.this.b(locald);
          return bool;
        }
      }
      catch (RemoteException localRemoteException)
      {
      }
      return false;
    }

    public boolean a(e paramAnonymouse, Uri paramAnonymousUri)
    {
      return CustomTabsService.this.a(new d(paramAnonymouse), paramAnonymousUri);
    }

    public boolean a(e paramAnonymouse, Uri paramAnonymousUri, Bundle paramAnonymousBundle, List<Bundle> paramAnonymousList)
    {
      return CustomTabsService.this.a(new d(paramAnonymouse), paramAnonymousUri, paramAnonymousBundle, paramAnonymousList);
    }

    public boolean a(e paramAnonymouse, Bundle paramAnonymousBundle)
    {
      return CustomTabsService.this.a(new d(paramAnonymouse), paramAnonymousBundle);
    }
  };

  protected abstract int a(d paramd, String paramString, Bundle paramBundle);

  protected abstract Bundle a(String paramString, Bundle paramBundle);

  protected abstract boolean a(long paramLong);

  protected boolean a(d paramd)
  {
    try
    {
      synchronized (this.a)
      {
        IBinder localIBinder = paramd.a();
        localIBinder.unlinkToDeath((IBinder.DeathRecipient)this.a.get(localIBinder), 0);
        this.a.remove(localIBinder);
        return true;
      }
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
    }
    return false;
  }

  protected abstract boolean a(d paramd, Uri paramUri);

  protected abstract boolean a(d paramd, Uri paramUri, Bundle paramBundle, List<Bundle> paramList);

  protected abstract boolean a(d paramd, Bundle paramBundle);

  protected abstract boolean b(d paramd);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.customtabs.CustomTabsService
 * JD-Core Version:    0.6.2
 */