package com.viber.voip.publicaccount.entity;

import java.util.ArrayList;

public class b
{
  private String a;
  private String b;
  private ArrayList<d> c;

  public b(String paramString1, String paramString2, ArrayList<d> paramArrayList)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.a;
  }

  public ArrayList<d> c()
  {
    return this.c;
  }

  public String toString()
  {
    return "PublicAccountCategory{mId='" + this.a + '\'' + ", mName='" + this.b + '\'' + ", mSubcategories=" + this.c + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.entity.b
 * JD-Core Version:    0.6.2
 */