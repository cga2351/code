package com.viber.jni;

public class PGRole
{
  int mGroupRole;
  int mUserSubscribeState;

  PGRole(int paramInt1, int paramInt2)
  {
    this.mGroupRole = paramInt1;
    this.mUserSubscribeState = paramInt2;
  }

  public int getGroupRole()
  {
    return this.mGroupRole;
  }

  public int getUserSubscribeState()
  {
    return this.mUserSubscribeState;
  }

  public String toString()
  {
    return "PGRole{mGroupRole=" + this.mGroupRole + ", mUserSubscribeState=" + this.mUserSubscribeState + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.PGRole
 * JD-Core Version:    0.6.2
 */