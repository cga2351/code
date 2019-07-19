package org.objenesis;

public class ObjenesisException extends RuntimeException
{
  private static final long serialVersionUID = -2677230016262426968L;

  public ObjenesisException(String paramString)
  {
    super(paramString);
  }

  public ObjenesisException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }

  public ObjenesisException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.ObjenesisException
 * JD-Core Version:    0.6.2
 */