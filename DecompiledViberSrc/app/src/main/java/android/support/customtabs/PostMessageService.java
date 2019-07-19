package android.support.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public class PostMessageService extends Service
{
  private g.a a = new g.a()
  {
    public void a(e paramAnonymouse, Bundle paramAnonymousBundle)
      throws RemoteException
    {
      paramAnonymouse.a(paramAnonymousBundle);
    }

    public void a(e paramAnonymouse, String paramAnonymousString, Bundle paramAnonymousBundle)
      throws RemoteException
    {
      paramAnonymouse.b(paramAnonymousString, paramAnonymousBundle);
    }
  };

  public IBinder onBind(Intent paramIntent)
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.customtabs.PostMessageService
 * JD-Core Version:    0.6.2
 */