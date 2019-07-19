package com.viber.voip.storage.repository;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.at;
import java.io.File;

class m
{
  private static final Logger a = ViberEnv.getLogger();
  private final MediaFileType b;
  private final File c;

  m(MediaFileType paramMediaFileType, File paramFile)
  {
    this.b = paramMediaFileType;
    this.c = paramFile;
  }

  private boolean d()
    throws SecurityException
  {
    return this.c.delete();
  }

  private boolean e()
  {
    return (this.c.exists()) && (this.c.isFile());
  }

  public MediaFileType a()
  {
    return this.b;
  }

  public long b()
  {
    if (e())
      try
      {
        long l = this.c.length();
        return l;
      }
      catch (SecurityException localSecurityException)
      {
      }
    return 0L;
  }

  public boolean c()
  {
    if (e())
      try
      {
        boolean bool = d();
        return bool;
      }
      catch (SecurityException localSecurityException)
      {
        return false;
      }
    return true;
  }

  public String toString()
  {
    return "MediaFile{mMediaType=" + this.b + ", fileSize=" + at.a(b()) + ", mFile='" + this.c + "'" + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.m
 * JD-Core Version:    0.6.2
 */