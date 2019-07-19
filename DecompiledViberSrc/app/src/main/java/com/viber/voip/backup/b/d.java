package com.viber.voip.backup.b;

import android.content.res.Resources;
import com.google.a.a.c.f;
import com.google.a.a.c.m;
import com.google.a.a.c.p;
import com.google.a.a.c.s;
import com.google.a.a.c.w;
import com.google.a.a.f.k;
import com.google.a.b.a.a.a;
import com.google.a.b.a.a.b;
import com.google.a.b.a.a.b.c;
import com.google.a.b.a.a.b.d;
import com.google.a.b.a.a.b.e;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.l;
import com.viber.voip.util.ax;
import com.viber.voip.util.da;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private static final int b = (int)TimeUnit.SECONDS.toMillis(40L);
  private com.google.a.b.a.a c;
  private String d;
  private String e;
  private com.google.a.a.b.a.a.b.a.a f;

  public d(com.google.a.a.b.a.a.b.a.a parama, String paramString1, String paramString2)
  {
    w localw = com.google.a.a.a.a.a.a.a();
    com.google.a.a.d.a.a locala = com.google.a.a.d.a.a.a();
    this.f = parama;
    this.c = new a.a(localw, locala, new com.google.a.a.c.r()
    {
      public void a(p paramAnonymousp)
        throws IOException
      {
        d.a(d.this).a(paramAnonymousp);
        paramAnonymousp.a(d.b());
        paramAnonymousp.b(d.b());
      }
    }).k(ViberApplication.getLocalizedResources().getString(R.string.app_name)).a();
    this.d = paramString1;
    this.e = paramString2;
  }

  private com.google.a.b.a.a.a a(String paramString1, String paramString2)
  {
    com.google.a.b.a.a.a locala = new com.google.a.b.a.a.a();
    locala.a(paramString1);
    HashMap localHashMap = new HashMap(5);
    localHashMap.put("viberMemberId", this.d);
    localHashMap.put("viberNumber", this.e);
    localHashMap.put("backupVersion", "2");
    localHashMap.put("backupMetadataVersion", String.valueOf(1));
    localHashMap.put("backupUploadTime", paramString2);
    locala.a(localHashMap);
    return locala;
  }

  public com.google.a.b.a.a.a a(com.google.a.b.a.a.a parama)
    throws IOException, com.viber.voip.k.b
  {
    ax.a(this.f);
    com.google.a.b.a.a.a locala = a(parama.g(), l.c(parama).toString());
    if (l.b(locala, "backupVersion") != null)
    {
      String str = l.c(parama, "backupVersion");
      if (!da.a(str))
        locala.a().put("backupVersion", str);
    }
    this.c.j().a(parama.e(), locala).c("appDataFolder").i();
    parama.a(locala.a());
    return parama;
  }

  public com.google.a.b.a.a.a a(String paramString, File paramFile, com.viber.voip.backup.r paramr, e parame)
    throws IOException, com.viber.voip.k.b
  {
    ax.a(this.f);
    com.google.a.b.a.a.a locala1 = a(paramFile.getName(), null);
    g localg = new g(new f("application/zip", paramFile), paramr, parame);
    Object localObject;
    if (paramString == null)
    {
      locala1.a(Collections.singletonList("appDataFolder"));
      localObject = this.c.j().a(locala1, localg);
    }
    com.google.a.b.a.a.a locala2;
    while (true)
    {
      ((com.google.a.b.a.b)localObject).b("id, name, modifiedTime, size, appProperties");
      ((com.google.a.b.a.b)localObject).d().a(true);
      locala2 = (com.google.a.b.a.a.a)((com.google.a.b.a.b)localObject).i();
      if (paramr != null)
        paramr.a(100);
      try
      {
        k localk = locala2.f();
        locala2.a().put("backupUploadTime", localk.toString());
        com.google.a.b.a.a.a locala3 = a(locala2);
        return locala3;
        localObject = this.c.j().a(paramString, locala1, localg).c("appDataFolder");
      }
      catch (Exception localException)
      {
      }
    }
    return locala2;
  }

  public com.google.a.b.a.a.b a()
    throws IOException, com.viber.voip.k.b
  {
    ax.a(this.f);
    a.b.d locald = this.c.j().a();
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = da.h(this.d);
    arrayOfObject[1] = da.h(this.e);
    return (com.google.a.b.a.a.b)locald.c(String.format(localLocale, "(appProperties has { key='viberMemberId' and value='%s'} or appProperties has { key='viberNumber' and value='%s'}) and (appProperties has { key='backupVersion' and value='1'} or appProperties has { key='backupVersion' and value='2'})", arrayOfObject)).d("appDataFolder").a("nextPageToken, files(id, name, modifiedTime, size, appProperties)").a(Integer.valueOf(1)).i();
  }

  public void a(String paramString, File paramFile, com.viber.voip.backup.r paramr)
    throws IOException, com.viber.voip.k.b
  {
    ax.a(this.f);
    s locals = this.c.j().b(paramString).h();
    Long localLong = locals.b().b();
    if ((localLong != null) && (localLong.longValue() > 0L))
      locals.a(new com.viber.voip.util.h.b(new FileOutputStream(paramFile), new a(localLong.longValue(), paramr)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.b.d
 * JD-Core Version:    0.6.2
 */