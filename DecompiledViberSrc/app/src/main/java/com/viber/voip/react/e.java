package com.viber.voip.react;

import com.facebook.react.ReactInstanceManager;

public class e
{
  private final ReactInstanceManager a;

  public e(ReactInstanceManager paramReactInstanceManager)
  {
    this.a = paramReactInstanceManager;
  }

  public final ReactInstanceManager a()
  {
    return this.a;
  }

  public final boolean b()
  {
    return this.a.hasStartedCreatingInitialContext();
  }

  public void c()
  {
    this.a.createReactContextInBackground();
  }

  public void d()
  {
    this.a.destroy();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.react.e
 * JD-Core Version:    0.6.2
 */