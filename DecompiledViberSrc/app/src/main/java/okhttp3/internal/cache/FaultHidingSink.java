package okhttp3.internal.cache;

import f.c;
import f.g;
import f.s;
import java.io.IOException;

class FaultHidingSink extends g
{
  private boolean hasErrors;

  FaultHidingSink(s params)
  {
    super(params);
  }

  public void close()
    throws IOException
  {
    if (this.hasErrors)
      return;
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }

  public void flush()
    throws IOException
  {
    if (this.hasErrors)
      return;
    try
    {
      super.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }

  protected void onException(IOException paramIOException)
  {
  }

  public void write(c paramc, long paramLong)
    throws IOException
  {
    if (this.hasErrors)
    {
      paramc.i(paramLong);
      return;
    }
    try
    {
      super.write(paramc, paramLong);
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      onException(localIOException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.cache.FaultHidingSink
 * JD-Core Version:    0.6.2
 */