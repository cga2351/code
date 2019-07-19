package twitter4j.conf;

public class TwitterConfigurationFactory
{
  public static Configuration getConfiguration()
  {
    Configuration localConfiguration = ConfigurationContext.getInstance();
    if ((localConfiguration instanceof PropertyConfiguration))
      ((PropertyConfiguration)localConfiguration).setMediaProvider("twitter");
    return localConfiguration;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.conf.TwitterConfigurationFactory
 * JD-Core Version:    0.6.2
 */