package com.yandex.metrica.impl.ob;

class hl
{
  private hp a;
  private final fm b;
  private final fl c;

  public hl(hp paramhp, fm paramfm, fl paramfl)
  {
    this.a = paramhp;
    this.b = paramfm;
    this.c = paramfl;
  }

  public void a()
  {
    int i = 1;
    int j;
    hp localhp2;
    if (this.a != null)
    {
      hp localhp1 = this.a;
      if (this.b.a() <= localhp1.j)
        break label99;
      j = i;
      if (j != 0)
        this.b.c((int)(0.1F * localhp1.j));
      localhp2 = this.a;
      if (this.c.a() <= localhp2.j)
        break label104;
    }
    while (true)
    {
      if (i != 0)
        this.c.c((int)(0.1F * localhp2.j));
      return;
      label99: j = 0;
      break;
      label104: i = 0;
    }
  }

  public void a(hp paramhp)
  {
    this.a = paramhp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hl
 * JD-Core Version:    0.6.2
 */