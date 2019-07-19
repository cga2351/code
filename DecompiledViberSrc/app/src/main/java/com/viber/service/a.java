package com.viber.service;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import com.viber.common.b.e;
import com.viber.common.jni.NativeLibraryLoader;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.ad;
import com.viber.voip.util.d;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public class a
  implements d.b
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;
  private Engine c;
  private Runnable d = new Runnable()
  {
    public void run()
    {
      try
      {
        long l1 = d.ad.M.d();
        long l2 = d.ad.N.d();
        long l3 = System.currentTimeMillis();
        if (l3 - l1 < 86400000L)
          return;
        String str = a.a(a.this).getApplicationInfo().nativeLibraryDir + "/" + "libVoipEngineNative.so";
        long l4 = a.a(a.this, str, new Adler32());
        if ((l4 != NativeLibraryLoader.getDefChecksum("libVoipEngineNative.so")) && (l4 != l2))
        {
          a.b(a.this).getCdrController().handleReportVersionChecksumChanged("" + l4);
          d.ad.N.a(l4);
        }
        d.ad.M.a(l3);
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }
  };

  public a(Context paramContext, Engine paramEngine)
  {
    this.b = paramContext;
    this.c = paramEngine;
  }

  private long a(String paramString, Checksum paramChecksum)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(new File(paramString));
    CheckedInputStream localCheckedInputStream = new CheckedInputStream(localFileInputStream, paramChecksum);
    byte[] arrayOfByte = new byte[4096];
    while (localCheckedInputStream.read(arrayOfByte) >= 0);
    localFileInputStream.close();
    return paramChecksum.getValue();
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    d.d(this);
    av.e.g.a().post(this.d);
  }

  public void onForeground()
  {
    i.b(this);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.a
 * JD-Core Version:    0.6.2
 */