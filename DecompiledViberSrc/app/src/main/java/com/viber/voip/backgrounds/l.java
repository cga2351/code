package com.viber.voip.backgrounds;

import com.viber.voip.util.av;
import java.util.ArrayList;

public class l
{
  public final int a;
  private ArrayList<p> b;
  private int c;

  public l(int paramInt)
  {
    this.a = paramInt;
    this.b = new ArrayList();
  }

  public ArrayList<p> a()
  {
    return this.b;
  }

  public void a(ArrayList<p> paramArrayList)
  {
    this.b = paramArrayList;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c = av.a(this.c, 2);
      return;
    }
    this.c = av.b(this.c, 2);
  }

  public boolean b()
  {
    return av.c(this.c, 1);
  }

  public boolean c()
  {
    return av.c(this.c, 2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.l
 * JD-Core Version:    0.6.2
 */