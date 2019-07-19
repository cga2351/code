package twitter4j.management;

import java.util.Iterator;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import javax.management.openmbean.OpenMBeanInfoSupport;
import javax.management.openmbean.OpenMBeanOperationInfoSupport;
import javax.management.openmbean.OpenMBeanParameterInfoSupport;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

public class APIStatisticsOpenMBean
  implements DynamicMBean
{
  private static final String[] ITEM_DESCRIPTIONS = { "The method name", "The number of times this method has been called", "The number of calls that failed", "The total amount of time spent invoking this method in milliseconds", "The average amount of time spent invoking this method in milliseconds" };
  private static final String[] ITEM_NAMES = { "methodName", "callCount", "errorCount", "totalTime", "avgTime" };
  private static final OpenType[] ITEM_TYPES;
  private final APIStatisticsMBean API_STATISTICS;
  private final TabularType API_STATISTICS_TYPE;
  private final CompositeType METHOD_STATS_TYPE;

  static
  {
    OpenType[] arrayOfOpenType = new OpenType[5];
    arrayOfOpenType[0] = SimpleType.STRING;
    arrayOfOpenType[1] = SimpleType.LONG;
    arrayOfOpenType[2] = SimpleType.LONG;
    arrayOfOpenType[3] = SimpleType.LONG;
    arrayOfOpenType[4] = SimpleType.LONG;
    ITEM_TYPES = arrayOfOpenType;
  }

  public APIStatisticsOpenMBean(APIStatistics paramAPIStatistics)
  {
    this.API_STATISTICS = paramAPIStatistics;
    try
    {
      this.METHOD_STATS_TYPE = new CompositeType("method statistics", "method statistics", ITEM_NAMES, ITEM_DESCRIPTIONS, ITEM_TYPES);
      String[] arrayOfString = { "methodName" };
      this.API_STATISTICS_TYPE = new TabularType("API statistics", "list of methods", this.METHOD_STATS_TYPE, arrayOfString);
      return;
    }
    catch (OpenDataException localOpenDataException)
    {
      throw new RuntimeException(localOpenDataException);
    }
  }

  public Object getAttribute(String paramString)
    throws AttributeNotFoundException, MBeanException, ReflectionException
  {
    if (paramString.equals("statisticsTable"))
      return getStatistics();
    if (paramString.equals("callCount"))
      return Long.valueOf(this.API_STATISTICS.getCallCount());
    if (paramString.equals("errorCount"))
      return Long.valueOf(this.API_STATISTICS.getErrorCount());
    if (paramString.equals("totalTime"))
      return Long.valueOf(this.API_STATISTICS.getTotalTime());
    if (paramString.equals("averageTime"))
      return Long.valueOf(this.API_STATISTICS.getAverageTime());
    throw new AttributeNotFoundException("Cannot find " + paramString + " attribute ");
  }

  public AttributeList getAttributes(String[] paramArrayOfString)
  {
    AttributeList localAttributeList = new AttributeList();
    if (paramArrayOfString.length == 0)
      return localAttributeList;
    int i = 0;
    while (true)
      if (i < paramArrayOfString.length)
        try
        {
          Object localObject = getAttribute(paramArrayOfString[i]);
          localAttributeList.add(new Attribute(paramArrayOfString[i], localObject));
          i++;
        }
        catch (Exception localException)
        {
          while (true)
            localException.printStackTrace();
        }
    return localAttributeList;
  }

  public MBeanInfo getMBeanInfo()
  {
    OpenMBeanAttributeInfoSupport[] arrayOfOpenMBeanAttributeInfoSupport = new OpenMBeanAttributeInfoSupport[5];
    OpenMBeanConstructorInfoSupport[] arrayOfOpenMBeanConstructorInfoSupport = new OpenMBeanConstructorInfoSupport[1];
    OpenMBeanOperationInfoSupport[] arrayOfOpenMBeanOperationInfoSupport = new OpenMBeanOperationInfoSupport[1];
    MBeanNotificationInfo[] arrayOfMBeanNotificationInfo = new MBeanNotificationInfo[0];
    arrayOfOpenMBeanAttributeInfoSupport[0] = new OpenMBeanAttributeInfoSupport("callCount", "Total number of API calls", SimpleType.LONG, true, false, false);
    arrayOfOpenMBeanAttributeInfoSupport[1] = new OpenMBeanAttributeInfoSupport("errorCount", "The number of failed API calls", SimpleType.LONG, true, false, false);
    arrayOfOpenMBeanAttributeInfoSupport[2] = new OpenMBeanAttributeInfoSupport("averageTime", "Average time spent invoking any API method", SimpleType.LONG, true, false, false);
    arrayOfOpenMBeanAttributeInfoSupport[3] = new OpenMBeanAttributeInfoSupport("totalTime", "Average time spent invoking any API method", SimpleType.LONG, true, false, false);
    arrayOfOpenMBeanAttributeInfoSupport[4] = new OpenMBeanAttributeInfoSupport("statisticsTable", "Table of statisics for all API methods", this.API_STATISTICS_TYPE, true, false, false);
    arrayOfOpenMBeanConstructorInfoSupport[0] = new OpenMBeanConstructorInfoSupport("APIStatisticsOpenMBean", "Constructs an APIStatisticsOpenMBean instance", new OpenMBeanParameterInfoSupport[0]);
    arrayOfOpenMBeanOperationInfoSupport[0] = new OpenMBeanOperationInfoSupport("reset", "reset the statistics", new OpenMBeanParameterInfoSupport[0], SimpleType.VOID, 0);
    return new OpenMBeanInfoSupport(getClass().getName(), "API Statistics Open MBean", arrayOfOpenMBeanAttributeInfoSupport, arrayOfOpenMBeanConstructorInfoSupport, arrayOfOpenMBeanOperationInfoSupport, arrayOfMBeanNotificationInfo);
  }

  public TabularDataSupport getStatistics()
  {
    TabularDataSupport localTabularDataSupport;
    try
    {
      localTabularDataSupport = new TabularDataSupport(this.API_STATISTICS_TYPE);
      Iterator localIterator = this.API_STATISTICS.getInvocationStatistics().iterator();
      while (true)
        if (localIterator.hasNext())
        {
          InvocationStatistics localInvocationStatistics = (InvocationStatistics)localIterator.next();
          Object[] arrayOfObject = new Object[5];
          arrayOfObject[0] = localInvocationStatistics.getName();
          arrayOfObject[1] = Long.valueOf(localInvocationStatistics.getCallCount());
          arrayOfObject[2] = Long.valueOf(localInvocationStatistics.getErrorCount());
          arrayOfObject[3] = Long.valueOf(localInvocationStatistics.getTotalTime());
          arrayOfObject[4] = Long.valueOf(localInvocationStatistics.getAverageTime());
          try
          {
            localTabularDataSupport.put(new CompositeDataSupport(this.METHOD_STATS_TYPE, ITEM_NAMES, arrayOfObject));
          }
          catch (OpenDataException localOpenDataException)
          {
            throw new RuntimeException(localOpenDataException);
          }
        }
    }
    finally
    {
    }
    return localTabularDataSupport;
  }

  public Object invoke(String paramString, Object[] paramArrayOfObject, String[] paramArrayOfString)
    throws MBeanException, ReflectionException
  {
    if (paramString.equals("reset"))
    {
      reset();
      return "Statistics reset";
    }
    throw new ReflectionException(new NoSuchMethodException(paramString), "Cannot find the operation " + paramString);
  }

  public void reset()
  {
    this.API_STATISTICS.reset();
  }

  public void setAttribute(Attribute paramAttribute)
    throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException
  {
    throw new AttributeNotFoundException("No attributes can be set in this MBean");
  }

  public AttributeList setAttributes(AttributeList paramAttributeList)
  {
    return new AttributeList();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.management.APIStatisticsOpenMBean
 * JD-Core Version:    0.6.2
 */