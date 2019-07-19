package android.support.customtabs;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.BundleCompat;
import java.util.ArrayList;

public final class b
{
  public final Intent a;
  public final Bundle b;

  private b(Intent paramIntent, Bundle paramBundle)
  {
    this.a = paramIntent;
    this.b = paramBundle;
  }

  public static final class a
  {
    private final Intent a = new Intent("android.intent.action.VIEW");
    private ArrayList<Bundle> b = null;
    private Bundle c = null;
    private ArrayList<Bundle> d = null;
    private boolean e = true;

    public a()
    {
      this(null);
    }

    public a(c paramc)
    {
      if (paramc != null)
        this.a.setPackage(paramc.b().getPackageName());
      Bundle localBundle = new Bundle();
      IBinder localIBinder = null;
      if (paramc == null);
      while (true)
      {
        BundleCompat.putBinder(localBundle, "android.support.customtabs.extra.SESSION", localIBinder);
        this.a.putExtras(localBundle);
        return;
        localIBinder = paramc.a();
      }
    }

    public b a()
    {
      if (this.b != null)
        this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.b);
      if (this.d != null)
        this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.d);
      this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
      return new b(this.a, this.c, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.customtabs.b
 * JD-Core Version:    0.6.2
 */