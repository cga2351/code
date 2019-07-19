package twitter4j.conf;

public abstract interface ConfigurationFactory
{
  public abstract void dispose();

  public abstract Configuration getInstance();

  public abstract Configuration getInstance(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.conf.ConfigurationFactory
 * JD-Core Version:    0.6.2
 */