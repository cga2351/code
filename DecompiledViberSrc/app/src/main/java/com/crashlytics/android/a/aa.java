package com.crashlytics.android.a;

import c.a.a.a.a.b.a;
import c.a.a.a.a.b.v;
import c.a.a.a.a.d.f;
import c.a.a.a.a.e.d;
import c.a.a.a.a.e.e;
import c.a.a.a.i;
import c.a.a.a.l;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class aa extends a
  implements f
{
  private final String b;

  public aa(i parami, String paramString1, String paramString2, e parame, String paramString3)
  {
    super(parami, paramString1, paramString2, parame, c.a.a.a.a.e.c.b);
    this.b = paramString3;
  }

  public boolean a(List<File> paramList)
  {
    d locald = b().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", this.b);
    Iterator localIterator = paramList.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      File localFile = (File)localIterator.next();
      locald.a("session_analytics_file_" + i, localFile.getName(), "application/vnd.crashlytics.android.events", localFile);
    }
    c.a.a.a.c.g().a("Answers", "Sending " + paramList.size() + " analytics files to " + a());
    int j = locald.b();
    c.a.a.a.c.g().a("Answers", "Response code for analytics file send is " + j);
    int k = v.a(j);
    boolean bool = false;
    if (k == 0)
      bool = true;
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.aa
 * JD-Core Version:    0.6.2
 */