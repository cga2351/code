package com.esotericsoftware.kryo;

public class KryoException extends RuntimeException
{
  private StringBuffer trace;

  public KryoException()
  {
  }

  public KryoException(String paramString)
  {
    super(paramString);
  }

  public KryoException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }

  public KryoException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }

  public void addTrace(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("info cannot be null.");
    if (this.trace == null)
      this.trace = new StringBuffer(512);
    this.trace.append('\n');
    this.trace.append(paramString);
  }

  public String getMessage()
  {
    if (this.trace == null)
      return super.getMessage();
    StringBuffer localStringBuffer = new StringBuffer(512);
    localStringBuffer.append(super.getMessage());
    if (localStringBuffer.length() > 0)
      localStringBuffer.append('\n');
    localStringBuffer.append("Serialization trace:");
    localStringBuffer.append(this.trace);
    return localStringBuffer.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.kryo.KryoException
 * JD-Core Version:    0.6.2
 */