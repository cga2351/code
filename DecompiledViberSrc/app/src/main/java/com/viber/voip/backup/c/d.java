package com.viber.voip.backup.c;

import com.viber.jni.backup.BackupResult.ErrorCode;

public class d extends Exception
{
  private BackupResult.ErrorCode a;

  public d()
  {
  }

  public d(String paramString)
  {
    super(paramString);
  }

  public d(String paramString, BackupResult.ErrorCode paramErrorCode)
  {
    super(paramString);
    this.a = paramErrorCode;
  }

  public d(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }

  public d(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.c.d
 * JD-Core Version:    0.6.2
 */