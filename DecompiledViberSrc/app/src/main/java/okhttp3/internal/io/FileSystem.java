package okhttp3.internal.io;

import f.l;
import f.s;
import f.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract interface FileSystem
{
  public static final FileSystem SYSTEM = new FileSystem()
  {
    public s appendingSink(File paramAnonymousFile)
      throws FileNotFoundException
    {
      try
      {
        s locals = l.c(paramAnonymousFile);
        return locals;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramAnonymousFile.getParentFile().mkdirs();
      }
      return l.c(paramAnonymousFile);
    }

    public void delete(File paramAnonymousFile)
      throws IOException
    {
      if ((!paramAnonymousFile.delete()) && (paramAnonymousFile.exists()))
        throw new IOException("failed to delete " + paramAnonymousFile);
    }

    public void deleteContents(File paramAnonymousFile)
      throws IOException
    {
      File[] arrayOfFile = paramAnonymousFile.listFiles();
      if (arrayOfFile == null)
        throw new IOException("not a readable directory: " + paramAnonymousFile);
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        File localFile = arrayOfFile[j];
        if (localFile.isDirectory())
          deleteContents(localFile);
        if (!localFile.delete())
          throw new IOException("failed to delete " + localFile);
      }
    }

    public boolean exists(File paramAnonymousFile)
    {
      return paramAnonymousFile.exists();
    }

    public void rename(File paramAnonymousFile1, File paramAnonymousFile2)
      throws IOException
    {
      delete(paramAnonymousFile2);
      if (!paramAnonymousFile1.renameTo(paramAnonymousFile2))
        throw new IOException("failed to rename " + paramAnonymousFile1 + " to " + paramAnonymousFile2);
    }

    public s sink(File paramAnonymousFile)
      throws FileNotFoundException
    {
      try
      {
        s locals = l.b(paramAnonymousFile);
        return locals;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramAnonymousFile.getParentFile().mkdirs();
      }
      return l.b(paramAnonymousFile);
    }

    public long size(File paramAnonymousFile)
    {
      return paramAnonymousFile.length();
    }

    public t source(File paramAnonymousFile)
      throws FileNotFoundException
    {
      return l.a(paramAnonymousFile);
    }
  };

  public abstract s appendingSink(File paramFile)
    throws FileNotFoundException;

  public abstract void delete(File paramFile)
    throws IOException;

  public abstract void deleteContents(File paramFile)
    throws IOException;

  public abstract boolean exists(File paramFile);

  public abstract void rename(File paramFile1, File paramFile2)
    throws IOException;

  public abstract s sink(File paramFile)
    throws FileNotFoundException;

  public abstract long size(File paramFile);

  public abstract t source(File paramFile)
    throws FileNotFoundException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.io.FileSystem
 * JD-Core Version:    0.6.2
 */