package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import com.yandex.metrica.CounterConfiguration;

public class t
{
  private final u a;
  private final CounterConfiguration b;

  public t(Bundle paramBundle)
  {
    this.a = u.a(paramBundle);
    this.b = CounterConfiguration.c(paramBundle);
  }

  public u a()
  {
    return this.a;
  }

  public CounterConfiguration b()
  {
    return this.b;
  }

  public String toString()
  {
    return "ClientConfiguration{mProcessConfiguration=" + this.a + ", mCounterConfiguration=" + this.b + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.t
 * JD-Core Version:    0.6.2
 */