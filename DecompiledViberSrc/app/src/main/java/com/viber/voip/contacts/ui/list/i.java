package com.viber.voip.contacts.ui.list;

import com.google.d.a.c;
import java.util.List;

public class i
{

  @c(a="result")
  public int a;

  @c(a="group")
  public a b;

  public String toString()
  {
    return "GetG2MembersResponse{result=" + this.a + ", group=" + this.b + '}';
  }

  public static class a
  {

    @c(a="size")
    public int a;

    @c(a="last")
    public boolean b;

    @c(a="sindex")
    public int c;

    @c(a="members")
    public List<a> d;

    @c(a="id")
    public String e;

    public String toString()
    {
      return "Group{size=" + this.a + ", last=" + this.b + ", sindex=" + this.c + ", members=" + this.d + ", id='" + this.e + '\'' + '}';
    }

    public static class a
    {

      @c(a="foto")
      public String a;

      @c(a="name")
      public String b;

      @c(a="id")
      public String c;

      public String toString()
      {
        return "Member{foto='" + this.a + '\'' + ", name='" + this.b + '\'' + ", id='" + this.c + '\'' + '}';
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.i
 * JD-Core Version:    0.6.2
 */