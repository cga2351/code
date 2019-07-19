package com.viber.backup.a;

import com.viber.voip.util.da;
import java.io.File;

class f
{
  public final String a;
  public final long b;
  public final File c;

  public f(String paramString, long paramLong, File paramFile)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramFile;
  }

  public boolean a()
  {
    return (!da.a(this.a)) && ((!this.c.exists()) || (this.c.isFile()));
  }

  public String toString()
  {
    return "KeychainMetadata{phoneNumber='" + this.a + '\'' + ", updatedTimeMillis=" + this.b + ", localFile=" + this.c + ", localFile.exists=" + this.c.exists() + ", localFile.isFile=" + this.c.isFile() + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.a.f
 * JD-Core Version:    0.6.2
 */