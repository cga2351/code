package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.i;

public abstract class c<T> extends d<T>
{
  private static final String b = i.a("BrdcstRcvrCnstrntTrckr");
  private final BroadcastReceiver c = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent != null)
        c.this.a(paramAnonymousContext, paramAnonymousIntent);
    }
  };

  public c(Context paramContext)
  {
    super(paramContext);
  }

  public abstract void a(Context paramContext, Intent paramIntent);

  public abstract IntentFilter b();

  public void d()
  {
    i locali = i.a();
    String str = b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getClass().getSimpleName();
    locali.b(str, String.format("%s: registering receiver", arrayOfObject), new Throwable[0]);
    this.a.registerReceiver(this.c, b());
  }

  public void e()
  {
    i locali = i.a();
    String str = b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getClass().getSimpleName();
    locali.b(str, String.format("%s: unregistering receiver", arrayOfObject), new Throwable[0]);
    this.a.unregisterReceiver(this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.b.c
 * JD-Core Version:    0.6.2
 */