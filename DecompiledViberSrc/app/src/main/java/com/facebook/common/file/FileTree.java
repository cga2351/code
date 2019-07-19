package com.facebook.common.file;

import java.io.File;

public class FileTree
{
  public static boolean deleteContents(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    boolean bool1 = true;
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      int j = 0;
      while (j < i)
      {
        boolean bool2 = bool1 & deleteRecursively(arrayOfFile[j]);
        j++;
        bool1 = bool2;
      }
    }
    return bool1;
  }

  public static boolean deleteRecursively(File paramFile)
  {
    if (paramFile.isDirectory())
      deleteContents(paramFile);
    return paramFile.delete();
  }

  public static void walkFileTree(File paramFile, FileTreeVisitor paramFileTreeVisitor)
  {
    paramFileTreeVisitor.preVisitDirectory(paramFile);
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      int j = 0;
      if (j < i)
      {
        File localFile = arrayOfFile[j];
        if (localFile.isDirectory())
          walkFileTree(localFile, paramFileTreeVisitor);
        while (true)
        {
          j++;
          break;
          paramFileTreeVisitor.visitFile(localFile);
        }
      }
    }
    paramFileTreeVisitor.postVisitDirectory(paramFile);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.file.FileTree
 * JD-Core Version:    0.6.2
 */