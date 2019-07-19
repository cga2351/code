package com.viber.voip.backup.a;

import java.util.Arrays;

public class a<COMMON_DATA>
{
  private final COMMON_DATA a;
  private a[] b;

  public a(COMMON_DATA paramCOMMON_DATA, a[] paramArrayOfa)
  {
    this.a = paramCOMMON_DATA;
    this.b = paramArrayOfa;
  }

  public COMMON_DATA a()
  {
    return this.a;
  }

  public a[] b()
  {
    return this.b;
  }

  public String toString()
  {
    return "BackupAccountData{mCommonData=" + this.a + ", mBackupAccounts=" + Arrays.toString(this.b) + '}';
  }

  public static class a
  {
    private final String a;

    public a(String paramString)
    {
      this.a = paramString;
    }

    public String a()
    {
      return this.a;
    }

    public String toString()
    {
      return "BackupAccount{accountName='" + this.a + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.a.a
 * JD-Core Version:    0.6.2
 */