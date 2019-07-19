package twitter4j.internal.async;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

public final class DispatcherFactory
{
  private Configuration conf;
  private String dispatcherImpl;

  public DispatcherFactory()
  {
    this(ConfigurationContext.getInstance());
  }

  public DispatcherFactory(Configuration paramConfiguration)
  {
    this.dispatcherImpl = paramConfiguration.getDispatcherImpl();
    this.conf = paramConfiguration;
  }

  public Dispatcher getInstance()
  {
    try
    {
      Constructor localConstructor = Class.forName(this.dispatcherImpl).getConstructor(new Class[] { Configuration.class });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.conf;
      Dispatcher localDispatcher = (Dispatcher)localConstructor.newInstance(arrayOfObject);
      return localDispatcher;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new AssertionError(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new AssertionError(localClassNotFoundException);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new AssertionError(localClassCastException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new AssertionError(localNoSuchMethodException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new AssertionError(localInvocationTargetException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.async.DispatcherFactory
 * JD-Core Version:    0.6.2
 */