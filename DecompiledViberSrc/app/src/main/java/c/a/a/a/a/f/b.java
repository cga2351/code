package c.a.a.a.a.f;

import android.content.Context;
import c.a.a.a.c;
import c.a.a.a.i;
import c.a.a.a.l;
import java.io.File;

public class b
  implements a
{
  private final Context a;
  private final String b;
  private final String c;

  public b(i parami)
  {
    if (parami.r() == null)
      throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    this.a = parami.r();
    this.b = parami.t();
    this.c = ("Android/" + this.a.getPackageName());
  }

  public File a()
  {
    return a(this.a.getFilesDir());
  }

  File a(File paramFile)
  {
    if (paramFile != null)
    {
      if ((paramFile.exists()) || (paramFile.mkdirs()))
        return paramFile;
      c.g().d("Fabric", "Couldn't create file");
    }
    while (true)
    {
      return null;
      c.g().a("Fabric", "Null File");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.f.b
 * JD-Core Version:    0.6.2
 */