package com.crashlytics.android.c;

import c.a.a.a.a.b.a;
import c.a.a.a.a.b.v;
import c.a.a.a.a.e.d;
import c.a.a.a.a.e.e;
import c.a.a.a.i;
import c.a.a.a.l;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class w extends a
  implements u
{
  public w(i parami, String paramString1, String paramString2, e parame)
  {
    super(parami, paramString1, paramString2, parame, c.a.a.a.a.e.c.b);
  }

  private d a(d paramd, ap paramap)
  {
    int i = 0;
    paramd.e("report[identifier]", paramap.b());
    if (paramap.d().length == 1)
    {
      c.a.a.a.c.g().a("CrashlyticsCore", "Adding single file " + paramap.a() + " to report " + paramap.b());
      paramd = paramd.a("report[file]", paramap.a(), "application/octet-stream", paramap.c());
    }
    while (true)
    {
      return paramd;
      File[] arrayOfFile = paramap.d();
      int j = arrayOfFile.length;
      int k = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        c.a.a.a.c.g().a("CrashlyticsCore", "Adding file " + localFile.getName() + " to report " + paramap.b());
        paramd.a("report[file" + k + "]", localFile.getName(), "application/octet-stream", localFile);
        k++;
        i++;
      }
    }
  }

  private d a(d paramd, t paramt)
  {
    d locald1 = paramd.a("X-CRASHLYTICS-API-KEY", paramt.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
    Iterator localIterator = paramt.b.e().entrySet().iterator();
    for (d locald2 = locald1; localIterator.hasNext(); locald2 = locald2.a((Map.Entry)localIterator.next()));
    return locald2;
  }

  public boolean a(t paramt)
  {
    d locald = a(a(b(), paramt), paramt.b);
    c.a.a.a.c.g().a("CrashlyticsCore", "Sending report to: " + a());
    int i = locald.b();
    c.a.a.a.c.g().a("CrashlyticsCore", "Create report request ID: " + locald.b("X-REQUEST-ID"));
    c.a.a.a.c.g().a("CrashlyticsCore", "Result was: " + i);
    return v.a(i) == 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.w
 * JD-Core Version:    0.6.2
 */