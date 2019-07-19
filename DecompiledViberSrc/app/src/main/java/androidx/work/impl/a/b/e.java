package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.support.v4.net.ConnectivityManagerCompat;
import androidx.work.i;
import androidx.work.impl.a.b;

public class e extends d<b>
{
  static final String b = i.a("NetworkStateTracker");
  private final ConnectivityManager c = (ConnectivityManager)this.a.getSystemService("connectivity");
  private b d;
  private a e;

  public e(Context paramContext)
  {
    super(paramContext);
    if (f())
    {
      this.d = new b();
      return;
    }
    this.e = new a();
  }

  private static boolean f()
  {
    return Build.VERSION.SDK_INT >= 24;
  }

  private boolean g()
  {
    if (Build.VERSION.SDK_INT < 23);
    NetworkCapabilities localNetworkCapabilities;
    do
    {
      return false;
      Network localNetwork = this.c.getActiveNetwork();
      localNetworkCapabilities = this.c.getNetworkCapabilities(localNetwork);
    }
    while ((localNetworkCapabilities == null) || (!localNetworkCapabilities.hasCapability(16)));
    return true;
  }

  public b a()
  {
    return b();
  }

  b b()
  {
    boolean bool1 = true;
    NetworkInfo localNetworkInfo = this.c.getActiveNetworkInfo();
    boolean bool2;
    boolean bool3;
    boolean bool4;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      bool2 = bool1;
      bool3 = g();
      bool4 = ConnectivityManagerCompat.isActiveNetworkMetered(this.c);
      if ((localNetworkInfo == null) || (localNetworkInfo.isRoaming()))
        break label68;
    }
    while (true)
    {
      return new b(bool2, bool3, bool4, bool1);
      bool2 = false;
      break;
      label68: bool1 = false;
    }
  }

  public void d()
  {
    if (f())
    {
      i.a().b(b, "Registering network callback", new Throwable[0]);
      this.c.registerDefaultNetworkCallback(this.d);
      return;
    }
    i.a().b(b, "Registering broadcast receiver", new Throwable[0]);
    this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }

  public void e()
  {
    if (f())
      try
      {
        i.a().b(b, "Unregistering network callback", new Throwable[0]);
        this.c.unregisterNetworkCallback(this.d);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        i.a().e(b, "Received exception while unregistering network callback", new Throwable[] { localIllegalArgumentException });
        return;
      }
    i.a().b(b, "Unregistering broadcast receiver", new Throwable[0]);
    this.a.unregisterReceiver(this.e);
  }

  private class a extends BroadcastReceiver
  {
    a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent == null) || (paramIntent.getAction() == null));
      while (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        return;
      i.a().b(e.b, "Network broadcast received", new Throwable[0]);
      e.this.a(e.this.b());
    }
  }

  private class b extends ConnectivityManager.NetworkCallback
  {
    b()
    {
    }

    public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
    {
      i.a().b(e.b, String.format("Network capabilities changed: %s", new Object[] { paramNetworkCapabilities }), new Throwable[0]);
      e.this.a(e.this.b());
    }

    public void onLost(Network paramNetwork)
    {
      i.a().b(e.b, "Network connection lost", new Throwable[0]);
      e.this.a(e.this.b());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.b.e
 * JD-Core Version:    0.6.2
 */