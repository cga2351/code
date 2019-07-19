package com.crashlytics.android.c;

import c.a.a.a.a.b.a;
import c.a.a.a.a.b.v;
import c.a.a.a.a.e.d;
import c.a.a.a.a.e.e;
import c.a.a.a.i;
import c.a.a.a.l;
import java.io.File;

class ag extends a
  implements u
{
  public ag(i parami, String paramString1, String paramString2, e parame)
  {
    super(parami, paramString1, paramString2, parame, c.a.a.a.a.e.c.b);
  }

  private d a(d paramd, ap paramap)
  {
    paramd.e("report_id", paramap.b());
    File[] arrayOfFile = paramap.d();
    int i = arrayOfFile.length;
    int j = 0;
    if (j < i)
    {
      File localFile = arrayOfFile[j];
      if (localFile.getName().equals("minidump"))
        paramd.a("minidump_file", localFile.getName(), "application/octet-stream", localFile);
      while (true)
      {
        j++;
        break;
        if (localFile.getName().equals("metadata"))
          paramd.a("crash_meta_file", localFile.getName(), "application/octet-stream", localFile);
        else if (localFile.getName().equals("binaryImages"))
          paramd.a("binary_images_file", localFile.getName(), "application/octet-stream", localFile);
        else if (localFile.getName().equals("session"))
          paramd.a("session_meta_file", localFile.getName(), "application/octet-stream", localFile);
        else if (localFile.getName().equals("app"))
          paramd.a("app_meta_file", localFile.getName(), "application/octet-stream", localFile);
        else if (localFile.getName().equals("device"))
          paramd.a("device_meta_file", localFile.getName(), "application/octet-stream", localFile);
        else if (localFile.getName().equals("os"))
          paramd.a("os_meta_file", localFile.getName(), "application/octet-stream", localFile);
        else if (localFile.getName().equals("user"))
          paramd.a("user_meta_file", localFile.getName(), "application/octet-stream", localFile);
        else if (localFile.getName().equals("logs"))
          paramd.a("logs_file", localFile.getName(), "application/octet-stream", localFile);
        else if (localFile.getName().equals("keys"))
          paramd.a("keys_file", localFile.getName(), "application/octet-stream", localFile);
      }
    }
    return paramd;
  }

  private d a(d paramd, String paramString)
  {
    paramd.a("User-Agent", "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", paramString);
    return paramd;
  }

  public boolean a(t paramt)
  {
    d locald = a(a(b(), paramt.a), paramt.b);
    c.a.a.a.c.g().a("CrashlyticsCore", "Sending report to: " + a());
    int i = locald.b();
    c.a.a.a.c.g().a("CrashlyticsCore", "Result was: " + i);
    return v.a(i) == 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ag
 * JD-Core Version:    0.6.2
 */