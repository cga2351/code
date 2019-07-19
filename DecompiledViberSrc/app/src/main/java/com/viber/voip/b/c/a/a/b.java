package com.viber.voip.b.c.a.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class b
  implements c
{
  private static final Logger c = ViberEnv.getLogger();
  protected boolean a;
  protected Set<String> b;

  public List<File> a(List<File> paramList, File paramFile, int paramInt, boolean paramBoolean)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null);
    int j;
    label33: File localFile;
    do
    {
      return paramList;
      if (paramList == null)
        paramList = new ArrayList();
      int i = arrayOfFile.length;
      j = 0;
      if (j >= i)
        break;
      localFile = arrayOfFile[j];
    }
    while (this.a);
    if (a(localFile));
    while (true)
    {
      j++;
      break label33;
      break;
      if (localFile.isDirectory())
      {
        if ((!b(localFile)) && (paramBoolean) && (paramInt < 20))
          a(paramList, localFile, paramInt + 1, true);
      }
      else if (!b(localFile))
        paramList.add(localFile);
    }
  }

  public void a()
  {
    this.a = true;
  }

  public void a(Set<String> paramSet)
  {
    this.b = paramSet;
  }

  protected abstract boolean a(File paramFile);

  protected boolean b(File paramFile)
  {
    return (this.b != null) && (this.b.size() > 0) && ((this.b.contains(paramFile.getAbsolutePath())) || (this.b.contains(paramFile.getAbsolutePath() + "/")));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.a.b
 * JD-Core Version:    0.6.2
 */