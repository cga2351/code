package com.crashlytics.android.ndk;

import android.content.Context;
import c.a.a.a.c;
import c.a.a.a.l;
import com.crashlytics.android.c.p;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

class a
  implements f
{
  private final Context a;
  private final d b;
  private final b c;

  a(Context paramContext, d paramd, b paramb)
  {
    this.a = paramContext;
    this.b = paramd;
    this.c = paramb;
  }

  public boolean a()
  {
    File localFile = this.c.a();
    boolean bool1 = false;
    if (localFile != null);
    try
    {
      String str = localFile.getCanonicalPath();
      boolean bool2 = this.b.a(str, this.a.getAssets());
      bool1 = bool2;
      return bool1;
    }
    catch (IOException localIOException)
    {
      c.g().e("CrashlyticsNdk", "Error initializing CrashlyticsNdk", localIOException);
    }
    return false;
  }

  public p b()
    throws IOException
  {
    TreeSet localTreeSet = this.c.b();
    if (!localTreeSet.isEmpty())
      localTreeSet.pollFirst();
    return new p(localTreeSet);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.ndk.a
 * JD-Core Version:    0.6.2
 */