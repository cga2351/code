package com.viber.voip.messages.controller;

import com.google.d.a.c;
import java.util.List;

public class x
{

  @c(a="result")
  private int a;

  @c(a="group")
  private a b;

  public int a()
  {
    return this.a;
  }

  public a b()
  {
    return this.b;
  }

  public String toString()
  {
    return "GetG2BannedUsersResponse{mResult=" + this.a + ", mGroup=" + this.b + '}';
  }

  public static class a
  {

    @c(a="id")
    private String a;

    @c(a="revision")
    private int b;

    @c(a="bannedUsers")
    private List<a> c;

    public List<a> a()
    {
      return this.c;
    }

    public String toString()
    {
      return "Group{mId='" + this.a + '\'' + ", mRevision=" + this.b + ", mBannedUsers=" + this.c + '}';
    }

    public static class a
    {

      @c(a="name")
      private String a;

      @c(a="id")
      private String b;

      public String a()
      {
        return this.a;
      }

      public String b()
      {
        return this.b;
      }

      public String toString()
      {
        return "BannedUser{mName='" + this.a + '\'' + ", mId='" + this.b + '\'' + '}';
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.x
 * JD-Core Version:    0.6.2
 */