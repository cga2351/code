package twitter4j.conf;

class PropertyConfigurationFactory
  implements ConfigurationFactory
{
  private static final PropertyConfiguration ROOT_CONFIGURATION = new PropertyConfiguration();

  public void dispose()
  {
  }

  public Configuration getInstance()
  {
    return ROOT_CONFIGURATION;
  }

  public Configuration getInstance(String paramString)
  {
    PropertyConfiguration localPropertyConfiguration = new PropertyConfiguration(paramString);
    localPropertyConfiguration.dumpConfiguration();
    return localPropertyConfiguration;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.conf.PropertyConfigurationFactory
 * JD-Core Version:    0.6.2
 */