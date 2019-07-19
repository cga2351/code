package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import java.util.List;

final class i
{
  private final n a = new n("com.firebase.jobdispatcher.", false);

  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0;
    case 2:
    }
    return 1;
  }

  private static void a(Bundle paramBundle)
  {
    paramBundle.putInt("trigger_type", 2);
    paramBundle.putLong("window_start", 0L);
    paramBundle.putLong("window_end", 30L);
  }

  private static void a(Bundle paramBundle, r.a parama)
  {
    paramBundle.putInt("trigger_type", 3);
    int i = parama.a().size();
    int[] arrayOfInt = new int[i];
    Uri[] arrayOfUri = new Uri[i];
    for (int j = 0; j < i; j++)
    {
      t localt = (t)parama.a().get(j);
      arrayOfInt[j] = localt.b();
      arrayOfUri[j] = localt.a();
    }
    paramBundle.putIntArray("content_uri_flags_array", arrayOfInt);
    paramBundle.putParcelableArray("content_uri_array", arrayOfUri);
  }

  private static void a(p paramp, Bundle paramBundle, r.b paramb)
  {
    paramBundle.putInt("trigger_type", 1);
    if (paramp.h())
    {
      paramBundle.putLong("period", paramb.b());
      paramBundle.putLong("period_flex", paramb.b() - paramb.a());
      return;
    }
    paramBundle.putLong("window_start", paramb.a());
    paramBundle.putLong("window_end", paramb.b());
  }

  private static int b(int paramInt)
  {
    int i = 2;
    if ((paramInt & 0x2) == i)
      i = 0;
    if ((paramInt & 0x1) == 1)
      return 1;
    return i;
  }

  private static void b(p paramp, Bundle paramBundle)
  {
    u localu = paramp.c();
    Bundle localBundle = new Bundle();
    localBundle.putInt("retry_policy", a(localu.a()));
    localBundle.putInt("initial_backoff_seconds", localu.b());
    localBundle.putInt("maximum_backoff_seconds", localu.c());
    paramBundle.putBundle("retryStrategy", localBundle);
  }

  private static void c(p paramp, Bundle paramBundle)
  {
    r localr = paramp.f();
    if (localr == v.a)
    {
      a(paramBundle);
      return;
    }
    if ((localr instanceof r.b))
    {
      a(paramp, paramBundle, (r.b)localr);
      return;
    }
    if ((localr instanceof r.a))
    {
      a(paramBundle, (r.a)localr);
      return;
    }
    throw new IllegalArgumentException("Unknown trigger: " + localr.getClass());
  }

  private static void d(p paramp, Bundle paramBundle)
  {
    boolean bool1 = true;
    int i = a.a(paramp.a());
    boolean bool2;
    if ((i & 0x4) == 4)
    {
      bool2 = bool1;
      paramBundle.putBoolean("requiresCharging", bool2);
      if ((i & 0x8) != 8)
        break label63;
    }
    while (true)
    {
      paramBundle.putBoolean("requiresIdle", bool1);
      paramBundle.putInt("requiredNetwork", b(i));
      return;
      bool2 = false;
      break;
      label63: bool1 = false;
    }
  }

  public Bundle a(p paramp, Bundle paramBundle)
  {
    paramBundle.putString("tag", paramp.e());
    paramBundle.putBoolean("update_current", paramp.d());
    if (paramp.g() == 2);
    for (boolean bool = true; ; bool = false)
    {
      paramBundle.putBoolean("persisted", bool);
      paramBundle.putString("service", GooglePlayReceiver.class.getName());
      c(paramp, paramBundle);
      d(paramp, paramBundle);
      b(paramp, paramBundle);
      Bundle localBundle = paramp.b();
      if (localBundle == null)
        localBundle = new Bundle();
      paramBundle.putBundle("extras", this.a.a(paramp, localBundle));
      return paramBundle;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.i
 * JD-Core Version:    0.6.2
 */