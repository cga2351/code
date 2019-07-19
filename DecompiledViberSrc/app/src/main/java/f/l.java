package f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class l
{
  static final Logger a = Logger.getLogger(l.class.getName());

  public static d a(s params)
  {
    return new n(params);
  }

  public static e a(t paramt)
  {
    return new o(paramt);
  }

  public static s a()
  {
    return new s()
    {
      public void close()
        throws IOException
      {
      }

      public void flush()
        throws IOException
      {
      }

      public u timeout()
      {
        return u.NONE;
      }

      public void write(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        paramAnonymousc.i(paramAnonymousLong);
      }
    };
  }

  public static s a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, new u());
  }

  private static s a(final OutputStream paramOutputStream, u paramu)
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("out == null");
    if (paramu == null)
      throw new IllegalArgumentException("timeout == null");
    return new s()
    {
      public void close()
        throws IOException
      {
        paramOutputStream.close();
      }

      public void flush()
        throws IOException
      {
        paramOutputStream.flush();
      }

      public u timeout()
      {
        return l.this;
      }

      public String toString()
      {
        return "sink(" + paramOutputStream + ")";
      }

      public void write(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        v.a(paramAnonymousc.b, 0L, paramAnonymousLong);
        while (paramAnonymousLong > 0L)
        {
          l.this.throwIfReached();
          p localp = paramAnonymousc.a;
          int i = (int)Math.min(paramAnonymousLong, localp.c - localp.b);
          paramOutputStream.write(localp.a, localp.b, i);
          localp.b = (i + localp.b);
          paramAnonymousLong -= i;
          paramAnonymousc.b -= i;
          if (localp.b == localp.c)
          {
            paramAnonymousc.a = localp.c();
            q.a(localp);
          }
        }
      }
    };
  }

  public static s a(Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null)
      throw new IllegalArgumentException("socket == null");
    if (paramSocket.getOutputStream() == null)
      throw new IOException("socket's output stream == null");
    a locala = c(paramSocket);
    return locala.sink(a(paramSocket.getOutputStream(), locala));
  }

  public static t a(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null)
      throw new IllegalArgumentException("file == null");
    return a(new FileInputStream(paramFile));
  }

  public static t a(InputStream paramInputStream)
  {
    return a(paramInputStream, new u());
  }

  private static t a(final InputStream paramInputStream, u paramu)
  {
    if (paramInputStream == null)
      throw new IllegalArgumentException("in == null");
    if (paramu == null)
      throw new IllegalArgumentException("timeout == null");
    return new t()
    {
      public void close()
        throws IOException
      {
        paramInputStream.close();
      }

      public long read(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        if (paramAnonymousLong < 0L)
          throw new IllegalArgumentException("byteCount < 0: " + paramAnonymousLong);
        if (paramAnonymousLong == 0L)
          return 0L;
        try
        {
          l.this.throwIfReached();
          p localp = paramAnonymousc.e(1);
          int i = (int)Math.min(paramAnonymousLong, 8192 - localp.c);
          int j = paramInputStream.read(localp.a, localp.c, i);
          if (j == -1)
            return -1L;
          localp.c = (j + localp.c);
          paramAnonymousc.b += j;
          return j;
        }
        catch (AssertionError localAssertionError)
        {
          if (l.a(localAssertionError))
            throw new IOException(localAssertionError);
          throw localAssertionError;
        }
      }

      public u timeout()
      {
        return l.this;
      }

      public String toString()
      {
        return "source(" + paramInputStream + ")";
      }
    };
  }

  static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }

  public static s b(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null)
      throw new IllegalArgumentException("file == null");
    return a(new FileOutputStream(paramFile));
  }

  public static t b(Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null)
      throw new IllegalArgumentException("socket == null");
    if (paramSocket.getInputStream() == null)
      throw new IOException("socket's input stream == null");
    a locala = c(paramSocket);
    return locala.source(a(paramSocket.getInputStream(), locala));
  }

  private static a c(Socket paramSocket)
  {
    return new a()
    {
      protected IOException newTimeoutException(@Nullable IOException paramAnonymousIOException)
      {
        SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
        if (paramAnonymousIOException != null)
          localSocketTimeoutException.initCause(paramAnonymousIOException);
        return localSocketTimeoutException;
      }

      protected void timedOut()
      {
        try
        {
          l.this.close();
          return;
        }
        catch (Exception localException)
        {
          l.a.log(Level.WARNING, "Failed to close timed out socket " + l.this, localException);
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if (l.a(localAssertionError))
          {
            l.a.log(Level.WARNING, "Failed to close timed out socket " + l.this, localAssertionError);
            return;
          }
          throw localAssertionError;
        }
      }
    };
  }

  public static s c(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null)
      throw new IllegalArgumentException("file == null");
    return a(new FileOutputStream(paramFile, true));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.l
 * JD-Core Version:    0.6.2
 */