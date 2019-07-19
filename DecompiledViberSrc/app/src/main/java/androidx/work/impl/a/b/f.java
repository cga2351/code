package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.i;

public class f extends c<Boolean>
{
  private static final String b = i.a("StorageNotLowTracker");

  public f(Context paramContext)
  {
    super(paramContext);
  }

  public Boolean a()
  {
    Intent localIntent = this.a.registerReceiver(null, b());
    if ((localIntent == null) || (localIntent.getAction() == null))
      return Boolean.valueOf(true);
    String str = localIntent.getAction();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -730838620:
    case -1181163412:
    }
    while (true)
      switch (i)
      {
      default:
        return null;
      case 0:
        return Boolean.valueOf(true);
        if (str.equals("android.intent.action.DEVICE_STORAGE_OK"))
        {
          i = 0;
          continue;
          if (str.equals("android.intent.action.DEVICE_STORAGE_LOW"))
            i = 1;
        }
        break;
      case 1:
      }
    return Boolean.valueOf(false);
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null)
      return;
    i locali = i.a();
    String str1 = b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramIntent.getAction();
    locali.b(str1, String.format("Received %s", arrayOfObject), new Throwable[0]);
    String str2 = paramIntent.getAction();
    int i = -1;
    switch (str2.hashCode())
    {
    default:
    case -730838620:
    case -1181163412:
    }
    while (true)
      switch (i)
      {
      default:
        return;
      case 0:
        a(Boolean.valueOf(true));
        return;
        if (str2.equals("android.intent.action.DEVICE_STORAGE_OK"))
        {
          i = 0;
          continue;
          if (str2.equals("android.intent.action.DEVICE_STORAGE_LOW"))
            i = 1;
        }
        break;
      case 1:
      }
    a(Boolean.valueOf(false));
  }

  public IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
    localIntentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
    return localIntentFilter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.b.f
 * JD-Core Version:    0.6.2
 */