package com.viber.voip.user.actions;

import com.viber.voip.util.cj;

public class ConnectionAwareAction<Param>
  implements Action<Param>
{
  private final ConnectionStateAction<Param> mOperation;

  public ConnectionAwareAction(final Action<Param> paramAction, final ConnectionAwareView paramConnectionAwareView, cj paramcj)
  {
    this.mOperation = new ConnectionStateAction(new ConnectionStateAction.Callbacks()
    {
      public void onConnected(Param paramAnonymousParam)
      {
        paramAction.execute(paramAnonymousParam);
      }

      public void onNoConnection()
      {
        paramConnectionAwareView.showNoConnectionError();
      }
    }
    , paramcj);
  }

  public void execute(Param paramParam)
  {
    this.mOperation.execute(paramParam);
  }

  public static abstract interface ConnectionAwareView
  {
    public abstract void showNoConnectionError();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.actions.ConnectionAwareAction
 * JD-Core Version:    0.6.2
 */