package androidx.work;

import android.content.Context;
import androidx.work.impl.h;
import com.google.b.a.a.a;
import java.util.Collections;
import java.util.List;

public abstract class p
{
  public static p a()
  {
    h localh = h.b();
    if (localh == null)
      throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
    return localh;
  }

  public static void a(Context paramContext, b paramb)
  {
    h.b(paramContext, paramb);
  }

  public abstract l a(String paramString);

  public abstract l a(String paramString, f paramf, m paramm);

  public l a(String paramString, g paramg, k paramk)
  {
    return a(paramString, paramg, Collections.singletonList(paramk));
  }

  public abstract l a(String paramString, g paramg, List<k> paramList);

  public abstract a<List<o>> b(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.p
 * JD-Core Version:    0.6.2
 */