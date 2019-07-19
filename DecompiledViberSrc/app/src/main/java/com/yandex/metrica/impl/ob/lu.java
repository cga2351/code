package com.yandex.metrica.impl.ob;

public class lu extends lv
{
  private lt b;

  public lu(int paramInt, String paramString)
  {
    super(paramInt, paramString);
    this.b = new lt(paramInt);
  }

  void a()
  {
    try
    {
      Thread.sleep(this.b.a());
      label11: super.a();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label11;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lu
 * JD-Core Version:    0.6.2
 */