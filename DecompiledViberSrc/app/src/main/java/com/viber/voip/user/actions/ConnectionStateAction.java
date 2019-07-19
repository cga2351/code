package com.viber.voip.user.actions;

import com.viber.voip.util.cj;

public class ConnectionStateAction<Param>
  implements Action<Param>
{
  private final Callbacks<Param> mCallbacks;
  private final cj mReachability;

  public ConnectionStateAction(Callbacks<Param> paramCallbacks, cj paramcj)
  {
    this.mCallbacks = paramCallbacks;
    this.mReachability = paramcj;
  }

  public void execute(Param paramParam)
  {
    if (this.mReachability.a() != -1)
    {
      this.mCallbacks.onConnected(paramParam);
      return;
    }
    this.mCallbacks.onNoConnection();
  }

  static abstract interface Callbacks<Param>
  {
    public abstract void onConnected(Param paramParam);

    public abstract void onNoConnection();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.actions.ConnectionStateAction
 * JD-Core Version:    0.6.2
 */