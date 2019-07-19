package com.viber.voip.backup.a;

import android.content.Context;
import android.os.Handler;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.f;
import com.viber.voip.backup.l;
import com.viber.voip.util.da;
import java.io.IOException;

public class i extends e<g, BackupInfo>
{
  private final f g;
  private final com.viber.backup.a.d h;
  private final com.viber.voip.backup.b.b i;

  public i(Context paramContext, d<g> paramd, f paramf, com.viber.backup.a.d paramd1, com.viber.voip.backup.b.b paramb, Handler paramHandler)
  {
    super(paramContext, paramd, paramHandler);
    this.g = paramf;
    this.h = paramd1;
    this.i = paramb;
  }

  protected com.google.a.b.a.a.b a(com.viber.voip.backup.b.b paramb, a<g> parama)
    throws IOException, com.viber.voip.k.b
  {
    return new com.viber.voip.backup.b.d(paramb.b(), ((g)parama.a()).a(), ((g)parama.a()).b()).a();
  }

  protected void a(BackupInfo paramBackupInfo)
  {
    this.g.a(paramBackupInfo);
    if (this.i.d())
    {
      if (!da.a(this.i.b().c(), paramBackupInfo.getAccount()))
      {
        this.h.c(true);
        this.h.h();
      }
      return;
    }
    this.i.a(paramBackupInfo.getAccount());
    this.h.a(true);
    this.h.h();
  }

  protected BackupInfo b(String paramString, com.google.a.b.a.a.a parama)
  {
    return l.a(paramString, parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.a.i
 * JD-Core Version:    0.6.2
 */