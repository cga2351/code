package org.simpleframework.xml.stream;

import java.io.IOException;
import java.io.Writer;

class OutputBuffer
{
  private StringBuilder text = new StringBuilder();

  public void append(char paramChar)
  {
    this.text.append(paramChar);
  }

  public void append(String paramString)
  {
    this.text.append(paramString);
  }

  public void append(String paramString, int paramInt1, int paramInt2)
  {
    this.text.append(paramString, paramInt1, paramInt2);
  }

  public void append(char[] paramArrayOfChar)
  {
    this.text.append(paramArrayOfChar, 0, paramArrayOfChar.length);
  }

  public void append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.text.append(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void clear()
  {
    this.text.setLength(0);
  }

  public void write(Writer paramWriter)
    throws IOException
  {
    paramWriter.append(this.text);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.OutputBuffer
 * JD-Core Version:    0.6.2
 */