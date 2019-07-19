package twitter4j;

public abstract interface ConnectionLifeCycleListener
{
  public abstract void onCleanUp();

  public abstract void onConnect();

  public abstract void onDisconnect();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.ConnectionLifeCycleListener
 * JD-Core Version:    0.6.2
 */