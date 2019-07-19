package com.viber.backup.drive;

import android.content.Context;
import android.os.Handler;
import com.google.a.a.f.k;
import com.viber.voip.backup.a.d;
import com.viber.voip.backup.l;
import java.io.IOException;

public class e extends com.viber.voip.backup.a.e<b, KeychainBackupInfo>
{
  public e(Context paramContext, d<b> paramd, Handler paramHandler)
  {
    super(paramContext, paramd, paramHandler);
  }

  protected com.google.a.b.a.a.b a(com.viber.voip.backup.b.b paramb, com.viber.voip.backup.a.a<b> parama)
    throws IOException, com.viber.voip.k.b
  {
    return new f(((b)parama.a()).a(), paramb.b()).a();
  }

  protected KeychainBackupInfo a(String paramString, com.google.a.b.a.a.a parama)
  {
    if (l.a(parama))
    {
      k localk = l.a(parama, "updatedTime");
      if (localk != null);
      for (long l = localk.a(); ; l = 0L)
        return new KeychainBackupInfo(paramString, parama.e(), l.c(parama).a(), l, parama.h().longValue(), l.b(parama));
    }
    return new KeychainBackupInfo(paramString, null, 0L, 0L, 0L, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.drive.e
 * JD-Core Version:    0.6.2
 */