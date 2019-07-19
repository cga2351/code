package com.viber.backup.drive;

import android.content.res.Resources;
import com.google.a.a.c.m;
import com.google.a.a.c.s;
import com.google.a.a.f.k;
import com.google.a.b.a.a.a;
import com.google.a.b.a.a.b;
import com.google.a.b.a.a.b.b;
import com.google.a.b.a.a.b.c;
import com.google.a.b.a.a.b.d;
import com.google.a.b.a.a.b.e;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.backup.b.e;
import com.viber.voip.backup.r;
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

public class f
{
  private static final int a = (int)TimeUnit.SECONDS.toMillis(40L);
  private final String b;
  private final com.google.a.a.b.a.a.b.a.a c;
  private final com.google.a.b.a.a d;

  public f(String paramString, com.google.a.a.b.a.a.b.a.a parama)
  {
    this.b = paramString;
    this.c = parama;
    this.d = new a.a(com.google.a.a.a.a.a.a.a(), com.google.a.a.d.a.a.a(), new g(this)).k(ViberApplication.getLocalizedResources().getString(R.string.app_name)).a();
  }

  private com.google.a.b.a.a.a a(String paramString, long paramLong)
  {
    com.google.a.b.a.a.a locala = new com.google.a.b.a.a.a();
    locala.a(paramString);
    HashMap localHashMap = new HashMap(5);
    localHashMap.put("viberNumber", this.b);
    localHashMap.put("metadataVersion", String.valueOf(1));
    if (paramLong != 0L)
      localHashMap.put("updatedTime", new k(paramLong).toString());
    locala.a(localHashMap);
    return locala;
  }

  public com.google.a.b.a.a.a a(String paramString, long paramLong, File paramFile, r paramr, e parame)
    throws IOException, com.viber.voip.k.b
  {
    ax.a(this.c);
    com.google.a.b.a.a.a locala1 = a("device.kc", paramLong);
    com.viber.voip.backup.b.g localg = new com.viber.voip.backup.b.g(new com.google.a.a.c.f("text/plain", paramFile), paramr, parame);
    if (paramString == null)
      locala1.a(Collections.singletonList("appDataFolder"));
    for (Object localObject = this.d.j().a(locala1, localg); ; localObject = this.d.j().a(paramString, locala1, localg).c("appDataFolder"))
    {
      ((com.google.a.b.a.b)localObject).b("id, name, modifiedTime, size, appProperties");
      ((com.google.a.b.a.b)localObject).d().a(true);
      com.google.a.b.a.a.a locala2 = (com.google.a.b.a.a.a)((com.google.a.b.a.b)localObject).i();
      if (paramr != null)
        paramr.a(100);
      return locala2;
    }
  }

  public com.google.a.b.a.a.b a()
    throws IOException, com.viber.voip.k.b
  {
    ax.a(this.c);
    a.b.d locald = this.d.j().a();
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = da.h(this.b);
    return (com.google.a.b.a.a.b)locald.c(String.format(localLocale, "(name = 'device.kc' and appProperties has { key='viberNumber' and value='%s'})", arrayOfObject)).d("appDataFolder").a("nextPageToken, files(id, name, modifiedTime, size, appProperties)").a(Integer.valueOf(1)).i();
  }

  public void a(String paramString)
    throws IOException
  {
    this.d.j().a(paramString).i();
  }

  public void a(String paramString, File paramFile, r paramr)
    throws IOException, com.viber.voip.k.b
  {
    ax.a(this.c);
    s locals = this.d.j().b(paramString).h();
    Long localLong = locals.b().b();
    if ((localLong != null) && (localLong.longValue() > 0L))
      locals.a(new com.viber.voip.util.h.b(new FileOutputStream(paramFile), new com.viber.voip.backup.b.a(localLong.longValue(), paramr)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.drive.f
 * JD-Core Version:    0.6.2
 */