package com.viber.jni;

public class PGLatestParamsWithRole
{
  final PGLatestParams mPGLatestParams;
  final PGRole mPGRole;

  PGLatestParamsWithRole(PGLatestParams paramPGLatestParams, PGRole paramPGRole)
  {
    this.mPGLatestParams = paramPGLatestParams;
    this.mPGRole = paramPGRole;
  }

  public PGLatestParams getPGLatestParams()
  {
    return this.mPGLatestParams;
  }

  public PGRole getPGRole()
  {
    return this.mPGRole;
  }

  public String toString()
  {
    return "PGLatestParamsWithRole{mPGLatestParams=" + this.mPGLatestParams + ", mPGRole=" + this.mPGRole + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PGLatestParamsWithRole
 * JD-Core Version:    0.6.2
 */