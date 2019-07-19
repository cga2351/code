package com.viber.voip.backup.g;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.c.d;
import com.viber.voip.util.at;
import java.io.File;
import java.io.IOException;

class c
{
  private static final Logger a = ViberEnv.getLogger();
  private final File b;
  private final String c;

  public c(Context paramContext, String paramString1, String paramString2)
    throws d
  {
    this.c = paramString2;
    this.b = new File(a(paramContext), paramString1);
    b(this.b);
  }

  private File a(Context paramContext)
  {
    return paramContext.getCacheDir();
  }

  private void b(File paramFile)
    throws d
  {
    if ((!paramFile.exists()) || (paramFile.isFile()))
    {
      if (!c(paramFile))
        break label63;
      if (!at.i(paramFile.getAbsolutePath()));
    }
    else
    {
      return;
    }
    throw new d("Couldn't create dir for backups on " + paramFile.getAbsolutePath());
    label63: throw new d("Couldn't delete default backup dir " + paramFile.getAbsolutePath());
  }

  private boolean c(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (paramFile.isFile())
        return paramFile.delete();
      return at.h(paramFile);
    }
    return true;
  }

  private File e()
  {
    return new File(this.b, this.c);
  }

  public File a()
  {
    File localFile = e();
    if ((localFile.exists()) && (localFile.isFile()))
      return localFile;
    if ((localFile.exists()) && (!c(localFile)));
    return null;
  }

  public boolean a(File paramFile)
  {
    return c(paramFile);
  }

  public File b()
    throws d
  {
    File localFile = e();
    if ((localFile.exists()) && (!c(localFile)))
      throw new d("Couldn't delete already existed backup file " + localFile.getAbsolutePath());
    try
    {
      boolean bool = localFile.createNewFile();
      if (!bool);
      return localFile;
    }
    catch (IOException localIOException)
    {
      throw new d("Couldn't create a new backup file on " + localFile.getAbsolutePath(), localIOException);
    }
  }

  public boolean c()
  {
    return a(e());
  }

  public boolean d()
  {
    return at.a(this.b, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.g.c
 * JD-Core Version:    0.6.2
 */