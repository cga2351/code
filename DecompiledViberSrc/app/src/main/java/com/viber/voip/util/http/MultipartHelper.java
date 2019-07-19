package com.viber.voip.util.http;

import com.viber.voip.b.b.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultipartHelper
{
  private static final int BUF_SIZE = 4096;
  private ArrayList<Block> blocks = new ArrayList();
  private String charset;
  private InlineBlock curInlineBlock;

  public MultipartHelper(String paramString)
  {
    this.charset = paramString;
  }

  private void closeCurInlineBlock()
  {
    if (this.curInlineBlock != null)
    {
      this.blocks.add(this.curInlineBlock);
      this.curInlineBlock = null;
    }
  }

  public MultipartHelper append(InputStream paramInputStream, UploadProgressListener paramUploadProgressListener)
    throws IOException
  {
    closeCurInlineBlock();
    this.blocks.add(new InputStreamBlock(paramInputStream, paramUploadProgressListener));
    return this;
  }

  public MultipartHelper append(String paramString)
    throws IOException
  {
    if (this.curInlineBlock == null)
      this.curInlineBlock = new InlineBlock(this.charset);
    this.curInlineBlock.append(paramString);
    return this;
  }

  public long finish()
  {
    closeCurInlineBlock();
    Iterator localIterator = this.blocks.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((Block)localIterator.next()).finish());
    return l;
  }

  public void writeBody(OutputStream paramOutputStream)
    throws IOException
  {
    Iterator localIterator = this.blocks.iterator();
    while (localIterator.hasNext())
      ((Block)localIterator.next()).writeBody(paramOutputStream);
  }

  private static abstract interface Block
  {
    public abstract long finish();

    public abstract void writeBody(OutputStream paramOutputStream)
      throws IOException;
  }

  private static class InlineBlock
    implements MultipartHelper.Block
  {
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private byte[] bytes;
    private String charset;

    public InlineBlock(String paramString)
    {
      this.charset = paramString;
    }

    public void append(String paramString)
      throws IOException
    {
      this.buffer.write(paramString.getBytes(this.charset));
    }

    public long finish()
    {
      if (this.buffer != null)
      {
        this.bytes = this.buffer.toByteArray();
        this.buffer = null;
      }
      return this.bytes.length;
    }

    public void writeBody(OutputStream paramOutputStream)
      throws IOException
    {
      paramOutputStream.write(this.bytes);
    }
  }

  private static class InputStreamBlock
    implements MultipartHelper.Block
  {
    private InputStream input;
    private long length;
    private UploadProgressListener listener;

    public InputStreamBlock(InputStream paramInputStream, UploadProgressListener paramUploadProgressListener)
      throws IOException
    {
      this.input = paramInputStream;
      this.listener = paramUploadProgressListener;
      this.length = paramInputStream.available();
    }

    public long finish()
    {
      return this.length;
    }

    public void writeBody(OutputStream paramOutputStream)
      throws IOException
    {
      if (this.listener != null)
        this.listener.onUploadProgress(0);
      long l = 0L;
      int i = 10;
      byte[] arrayOfByte = a.a(4096);
      try
      {
        while (true)
        {
          int j = this.input.read(arrayOfByte);
          if (j <= 0)
          {
            this.input.close();
            a.a(arrayOfByte);
            if (this.listener != null)
              this.listener.onUploadProgress(100);
            return;
          }
          paramOutputStream.write(arrayOfByte, 0, j);
          l += j;
          if ((this.listener != null) && ((float)l / ((float)this.length / 100.0F) > i))
          {
            this.listener.onUploadProgress(i);
            i += 10;
          }
        }
      }
      finally
      {
        this.input.close();
        a.a(arrayOfByte);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.http.MultipartHelper
 * JD-Core Version:    0.6.2
 */