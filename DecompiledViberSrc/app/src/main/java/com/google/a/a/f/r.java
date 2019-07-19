package com.google.a.a.f;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class r extends ByteArrayOutputStream
{
  private int a;
  private final int b;
  private boolean c;
  private final Level d;
  private final Logger e;

  public r(Logger paramLogger, Level paramLevel, int paramInt)
  {
    this.e = ((Logger)z.a(paramLogger));
    this.d = ((Level)z.a(paramLevel));
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      z.a(bool);
      this.b = paramInt;
      return;
    }
  }

  private static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt == 1)
    {
      paramStringBuilder.append("1 byte");
      return;
    }
    paramStringBuilder.append(NumberFormat.getInstance().format(paramInt)).append(" bytes");
  }

  public void close()
    throws IOException
  {
    try
    {
      if (!this.c)
      {
        if (this.a != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("Total: ");
          a(localStringBuilder, this.a);
          if ((this.count != 0) && (this.count < this.a))
          {
            localStringBuilder.append(" (logging first ");
            a(localStringBuilder, this.count);
            localStringBuilder.append(")");
          }
          this.e.config(localStringBuilder.toString());
          if (this.count != 0)
            this.e.log(this.d, toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
        }
        this.c = true;
      }
      return;
    }
    finally
    {
    }
  }

  public void write(int paramInt)
  {
    try
    {
      if (!this.c);
      for (boolean bool = true; ; bool = false)
      {
        z.a(bool);
        this.a = (1 + this.a);
        if (this.count < this.b)
          super.write(paramInt);
        return;
      }
    }
    finally
    {
    }
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (!this.c);
      for (boolean bool = true; ; bool = false)
      {
        z.a(bool);
        this.a = (paramInt2 + this.a);
        if (this.count < this.b)
        {
          int i = paramInt2 + this.count;
          if (i > this.b)
            paramInt2 += this.b - i;
          super.write(paramArrayOfByte, paramInt1, paramInt2);
        }
        return;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.r
 * JD-Core Version:    0.6.2
 */