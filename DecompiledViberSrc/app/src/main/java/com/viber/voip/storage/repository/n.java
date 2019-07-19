package com.viber.voip.storage.repository;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class n
  implements Iterable<m>
{
  private static final Logger a = ViberEnv.getLogger();
  private ArrayList<m> b = new ArrayList();

  private ArrayList<m> b()
  {
    ArrayList localArrayList = this.b;
    this.b = new ArrayList();
    return localArrayList;
  }

  public void a()
  {
    this.b.clear();
  }

  public void a(MediaFileType paramMediaFileType, File paramFile)
  {
    try
    {
      boolean bool1 = paramFile.exists();
      i = 0;
      if (bool1)
      {
        boolean bool2 = paramFile.isFile();
        i = 0;
        if (bool2)
          i = 1;
      }
      if (i != 0)
        this.b.add(new m(paramMediaFileType, paramFile));
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        int i = 0;
    }
  }

  public void a(MediaFileType paramMediaFileType, File[] paramArrayOfFile)
  {
    int i = paramArrayOfFile.length;
    for (int j = 0; j < i; j++)
      a(paramMediaFileType, paramArrayOfFile[j]);
  }

  void a(n paramn)
  {
    this.b.addAll(paramn.b());
  }

  public Iterator<m> iterator()
  {
    return this.b.iterator();
  }

  public String toString()
  {
    return "MediaFilesContainer{ " + this.b + " }";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.n
 * JD-Core Version:    0.6.2
 */