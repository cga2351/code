package com.facebook.common.file;

import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils
{
  public static void mkdirs(File paramFile)
    throws FileUtils.CreateDirectoryException
  {
    if (paramFile.exists())
      if (!paramFile.isDirectory());
    while ((paramFile.mkdirs()) || (paramFile.isDirectory()))
    {
      return;
      if (!paramFile.delete())
        throw new CreateDirectoryException(paramFile.getAbsolutePath(), new FileDeleteException(paramFile.getAbsolutePath()));
    }
    throw new CreateDirectoryException(paramFile.getAbsolutePath());
  }

  public static void rename(File paramFile1, File paramFile2)
    throws FileUtils.RenameException
  {
    Preconditions.checkNotNull(paramFile1);
    Preconditions.checkNotNull(paramFile2);
    paramFile2.delete();
    if (paramFile1.renameTo(paramFile2))
      return;
    Object localObject;
    if (paramFile2.exists())
      localObject = new FileDeleteException(paramFile2.getAbsolutePath());
    while (true)
    {
      throw new RenameException("Unknown error renaming " + paramFile1.getAbsolutePath() + " to " + paramFile2.getAbsolutePath(), (Throwable)localObject);
      if (!paramFile1.getParentFile().exists())
      {
        localObject = new ParentDirNotFoundException(paramFile1.getAbsolutePath());
      }
      else
      {
        boolean bool = paramFile1.exists();
        localObject = null;
        if (!bool)
          localObject = new FileNotFoundException(paramFile1.getAbsolutePath());
      }
    }
  }

  public static class CreateDirectoryException extends IOException
  {
    public CreateDirectoryException(String paramString)
    {
      super();
    }

    public CreateDirectoryException(String paramString, Throwable paramThrowable)
    {
      super();
      initCause(paramThrowable);
    }
  }

  public static class FileDeleteException extends IOException
  {
    public FileDeleteException(String paramString)
    {
      super();
    }
  }

  public static class ParentDirNotFoundException extends FileNotFoundException
  {
    public ParentDirNotFoundException(String paramString)
    {
      super();
    }
  }

  public static class RenameException extends IOException
  {
    public RenameException(String paramString)
    {
      super();
    }

    public RenameException(String paramString, Throwable paramThrowable)
    {
      super();
      initCause(paramThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.file.FileUtils
 * JD-Core Version:    0.6.2
 */