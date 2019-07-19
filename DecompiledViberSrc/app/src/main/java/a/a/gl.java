package a.a;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.appboy.f.c;

public final class gl
  implements gp
{
  private static final String a = c.a(gl.class);
  private gv b = gv.a;
  private boolean c = false;
  private boolean d = false;

  public gv a()
  {
    return this.b;
  }

  public void a(Intent paramIntent, ConnectivityManager paramConnectivityManager)
  {
    String str = paramIntent.getAction();
    if (str.equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      NetworkInfo localNetworkInfo;
      try
      {
        localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
        boolean bool = paramIntent.getBooleanExtra("noConnectivity", false);
        if ((localNetworkInfo == null) || (bool))
        {
          this.b = gv.b;
          this.d = false;
          this.c = false;
          return;
        }
      }
      catch (SecurityException localSecurityException)
      {
        c.d(a, "Failed to get active network information. Ensure the permission android.permission.ACCESS_NETWORK_STATE is defined in your AndroidManifest.xml", localSecurityException);
        return;
      }
      this.d = localNetworkInfo.isConnectedOrConnecting();
      this.c = localNetworkInfo.isRoaming();
      switch (localNetworkInfo.getType())
      {
      default:
        this.b = gv.a;
        return;
      case 7:
        this.b = gv.a;
        return;
      case 8:
        this.b = gv.a;
        return;
      case 9:
        this.b = gv.a;
        return;
      case 4:
        this.b = gv.a;
        return;
      case 5:
        this.b = gv.a;
        return;
      case 2:
        this.b = gv.a;
        return;
      case 3:
        this.b = gv.a;
        return;
      case 0:
        switch (localNetworkInfo.getSubtype())
        {
        default:
          this.b = gv.c;
          return;
        case 3:
          this.b = gv.d;
          return;
        case 13:
        }
        this.b = gv.e;
        return;
      case 1:
        this.b = gv.f;
        return;
      case 6:
      }
      this.b = gv.f;
      return;
    }
    c.d(a, "Unexpected system broadcast received [" + str + "]");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gl
 * JD-Core Version:    0.6.2
 */