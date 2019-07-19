package com.crashlytics.android.ndk;

import c.a.a.a.a.b.w;
import c.a.a.a.a.f.a;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

class e
  implements b
{
  private static final FileFilter a = new FileFilter()
  {
    public boolean accept(File paramAnonymousFile)
    {
      return paramAnonymousFile.isDirectory();
    }
  };
  private final a b;

  public e(a parama)
  {
    this.b = parama;
  }

  private static TreeSet<File> a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.isDirectory()))
      return new TreeSet();
    File[] arrayOfFile = paramFile.listFiles(a);
    TreeSet localTreeSet = new TreeSet(new Comparator()
    {
      public int a(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        return paramAnonymousFile2.getName().compareTo(paramAnonymousFile1.getName());
      }
    });
    localTreeSet.addAll(Arrays.asList(arrayOfFile));
    return localTreeSet;
  }

  private File c()
  {
    return new File(this.b.a(), "native");
  }

  public File a()
  {
    File localFile1 = c();
    if ((!localFile1.isDirectory()) && (!localFile1.mkdir()))
      return null;
    File localFile2 = new File(localFile1, Long.toString(new w().a()));
    if (localFile2.mkdir());
    while (true)
    {
      return localFile2;
      localFile2 = null;
    }
  }

  public TreeSet<File> b()
  {
    return a(c());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.ndk.e
 * JD-Core Version:    0.6.2
 */