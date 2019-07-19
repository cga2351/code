package com.viber.voip.util;

import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.jni.Engine;
import com.viber.jni.GetMD5CryptedFileResult;
import com.viber.jni.secure.SecureMessagesController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.l.d;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class cr
{
  private static final Logger a = ViberEnv.getLogger();

  public static GetMD5CryptedFileResult a(File paramFile)
    throws IOException
  {
    if (paramFile == null)
      throw new IOException("file is null");
    if (!paramFile.exists())
      throw new IOException("file does not exist: " + paramFile.getAbsolutePath());
    GetMD5CryptedFileResult localGetMD5CryptedFileResult = ViberApplication.getInstance().getEngine(true).getSecureMessagesController().handleGetMD5CryptedFile(paramFile.getAbsolutePath());
    if (localGetMD5CryptedFileResult == null)
      throw new IOException("handleInitEncryptionData failed for " + paramFile.getAbsolutePath());
    return localGetMD5CryptedFileResult;
  }

  public static c a(InputStream paramInputStream)
    throws IOException
  {
    return new c(paramInputStream);
  }

  public static c a(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    return new c(paramInputStream, paramArrayOfByte);
  }

  public static InputStream a(InputStream paramInputStream, EncryptionParams paramEncryptionParams)
  {
    if (EncryptionParams.contentIsEncrypted(paramEncryptionParams))
      paramInputStream = new b(paramInputStream, paramEncryptionParams);
    return paramInputStream;
  }

  private static abstract class a extends FilterInputStream
  {
    protected int a;
    protected SecureMessagesController b = ViberApplication.getInstance().getEngine(true).getSecureMessagesController();
    private byte[] c;

    a(InputStream paramInputStream)
    {
      super();
    }

    protected abstract void a()
      throws IOException;

    protected abstract void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
      throws IOException;

    public int read()
      throws IOException
    {
      throw new RuntimeException("unimplemented");
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        if ((this.c == null) || (this.c.length != paramArrayOfByte.length))
          this.c = new byte[paramArrayOfByte.length];
        int i = this.in.read(this.c, paramInt1, paramInt2);
        if (i > 0)
          a(this.c, paramArrayOfByte, paramInt1, i);
        while (true)
        {
          return i;
          if (i == -1)
            a();
        }
      }
      finally
      {
      }
    }
  }

  private static class b extends cr.a
  {
    EncryptionParams c;

    b(InputStream paramInputStream, EncryptionParams paramEncryptionParams)
    {
      super();
      this.c = paramEncryptionParams;
      this.a = this.b.handleInitDecryptionContext(paramEncryptionParams.getKey());
    }

    protected void a()
      throws IOException
    {
      boolean bool = this.b.handleCryptBufferFinish(this.a, this.c);
      this.a = 0;
      if (!bool)
        g.a().a(d.c("InputEof"));
    }

    protected void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
      throws IOException
    {
      if (!this.b.handleCryptBufferUpdate(this.a, paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2))
        throw new IOException("handleCryptBufferUpdate returned false during decryption");
    }

    public void close()
      throws IOException
    {
      try
      {
        super.close();
        label4: if (this.a != 0)
        {
          this.b.handleCryptBufferFinish(this.a, this.c);
          this.a = 0;
        }
        return;
      }
      catch (IOException localIOException)
      {
        break label4;
      }
    }
  }

  public static class c extends cr.a
  {
    private EncryptionParams c;

    c(InputStream paramInputStream)
      throws IOException
    {
      super();
      this.a = this.b.handleInitEncryptionContext();
      if (this.a == 0)
        throw new IOException("handleInitEncryptionContext failed");
    }

    c(InputStream paramInputStream, byte[] paramArrayOfByte)
      throws IOException
    {
      super();
      this.a = this.b.handleSetEncryptionContext(paramArrayOfByte);
      if (this.a == 0)
        throw new IOException("handleSetncryptionContext failed");
    }

    protected void a()
    {
    }

    protected void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
      throws IOException
    {
      if (!this.b.handleCryptBufferUpdate(this.a, paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2))
        throw new IOException("handleCryptBufferUpdate returned false during encryption");
    }

    public EncryptionParams b()
    {
      return this.c;
    }

    public void close()
      throws IOException
    {
      super.close();
      if (this.c == null)
      {
        this.c = new EncryptionParams();
        boolean bool = this.b.handleCryptBufferFinish(this.a, this.c);
        if (this.b.isNullEncryptionParams(this.c))
          this.c = null;
        if (!bool)
        {
          this.c = null;
          throw new IOException("handleCryptBufferFinish returned false during encryption");
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cr
 * JD-Core Version:    0.6.2
 */