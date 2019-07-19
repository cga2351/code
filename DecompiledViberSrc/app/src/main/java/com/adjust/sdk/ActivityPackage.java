package com.adjust.sdk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class ActivityPackage
  implements Serializable
{
  private static final ObjectStreamField[] serialPersistentFields = arrayOfObjectStreamField;
  private static final long serialVersionUID = -35935556512024097L;
  private ActivityKind activityKind = ActivityKind.UNKNOWN;
  private Map<String, String> callbackParameters;
  private long clickTimeInMilliseconds;
  private long clickTimeInSeconds;
  private String clientSdk;
  private transient int hashCode;
  private long installBeginTimeInSeconds;
  private Map<String, String> parameters;
  private Map<String, String> partnerParameters;
  private String path;
  private int retries;
  private String suffix;

  static
  {
    ObjectStreamField[] arrayOfObjectStreamField = new ObjectStreamField[7];
    arrayOfObjectStreamField[0] = new ObjectStreamField("path", String.class);
    arrayOfObjectStreamField[1] = new ObjectStreamField("clientSdk", String.class);
    arrayOfObjectStreamField[2] = new ObjectStreamField("parameters", Map.class);
    arrayOfObjectStreamField[3] = new ObjectStreamField("activityKind", ActivityKind.class);
    arrayOfObjectStreamField[4] = new ObjectStreamField("suffix", String.class);
    arrayOfObjectStreamField[5] = new ObjectStreamField("callbackParameters", Map.class);
    arrayOfObjectStreamField[6] = new ObjectStreamField("partnerParameters", Map.class);
  }

  public ActivityPackage(ActivityKind paramActivityKind)
  {
    this.activityKind = paramActivityKind;
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
    throws ClassNotFoundException, IOException
  {
    ObjectInputStream.GetField localGetField = paramObjectInputStream.readFields();
    this.path = Util.readStringField(localGetField, "path", null);
    this.clientSdk = Util.readStringField(localGetField, "clientSdk", null);
    this.parameters = ((Map)Util.readObjectField(localGetField, "parameters", null));
    this.activityKind = ((ActivityKind)Util.readObjectField(localGetField, "activityKind", ActivityKind.UNKNOWN));
    this.suffix = Util.readStringField(localGetField, "suffix", null);
    this.callbackParameters = ((Map)Util.readObjectField(localGetField, "callbackParameters", null));
    this.partnerParameters = ((Map)Util.readObjectField(localGetField, "partnerParameters", null));
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    ActivityPackage localActivityPackage;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localActivityPackage = (ActivityPackage)paramObject;
      if (!Util.equalString(this.path, localActivityPackage.path))
        return false;
      if (!Util.equalString(this.clientSdk, localActivityPackage.clientSdk))
        return false;
      if (!Util.equalObject(this.parameters, localActivityPackage.parameters))
        return false;
      if (!Util.equalEnum(this.activityKind, localActivityPackage.activityKind))
        return false;
      if (!Util.equalString(this.suffix, localActivityPackage.suffix))
        return false;
      if (!Util.equalObject(this.callbackParameters, localActivityPackage.callbackParameters))
        return false;
    }
    while (Util.equalObject(this.partnerParameters, localActivityPackage.partnerParameters));
    return false;
  }

  public ActivityKind getActivityKind()
  {
    return this.activityKind;
  }

  public Map<String, String> getCallbackParameters()
  {
    return this.callbackParameters;
  }

  public long getClickTimeInMilliseconds()
  {
    return this.clickTimeInMilliseconds;
  }

  public long getClickTimeInSeconds()
  {
    return this.clickTimeInSeconds;
  }

  public String getClientSdk()
  {
    return this.clientSdk;
  }

  public String getExtendedString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.path;
    localStringBuilder.append(Util.formatString("Path:      %s\n", arrayOfObject1));
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = this.clientSdk;
    localStringBuilder.append(Util.formatString("ClientSdk: %s\n", arrayOfObject2));
    if (this.parameters != null)
    {
      localStringBuilder.append("Parameters:");
      TreeMap localTreeMap = new TreeMap(this.parameters);
      List localList = Arrays.asList(new String[] { "app_secret", "secret_id", "event_callback_id" });
      Iterator localIterator = localTreeMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        if (!localList.contains(str))
        {
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = str;
          arrayOfObject3[1] = localEntry.getValue();
          localStringBuilder.append(Util.formatString("\n\t%-16s %s", arrayOfObject3));
        }
      }
    }
    return localStringBuilder.toString();
  }

  protected String getFailureMessage()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.activityKind.toString();
    arrayOfObject[1] = this.suffix;
    return Util.formatString("Failed to track %s%s", arrayOfObject);
  }

  public long getInstallBeginTimeInSeconds()
  {
    return this.installBeginTimeInSeconds;
  }

  public Map<String, String> getParameters()
  {
    return this.parameters;
  }

  public Map<String, String> getPartnerParameters()
  {
    return this.partnerParameters;
  }

  public String getPath()
  {
    return this.path;
  }

  public int getRetries()
  {
    return this.retries;
  }

  public String getSuffix()
  {
    return this.suffix;
  }

  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      this.hashCode = (37 * this.hashCode + Util.hashString(this.path));
      this.hashCode = (37 * this.hashCode + Util.hashString(this.clientSdk));
      this.hashCode = (37 * this.hashCode + Util.hashObject(this.parameters));
      this.hashCode = (37 * this.hashCode + Util.hashEnum(this.activityKind));
      this.hashCode = (37 * this.hashCode + Util.hashString(this.suffix));
      this.hashCode = (37 * this.hashCode + Util.hashObject(this.callbackParameters));
      this.hashCode = (37 * this.hashCode + Util.hashObject(this.partnerParameters));
    }
    return this.hashCode;
  }

  public int increaseRetries()
  {
    this.retries = (1 + this.retries);
    return this.retries;
  }

  public void setCallbackParameters(Map<String, String> paramMap)
  {
    this.callbackParameters = paramMap;
  }

  public void setClickTimeInMilliseconds(long paramLong)
  {
    this.clickTimeInMilliseconds = paramLong;
  }

  public void setClickTimeInSeconds(long paramLong)
  {
    this.clickTimeInSeconds = paramLong;
  }

  public void setClientSdk(String paramString)
  {
    this.clientSdk = paramString;
  }

  public void setInstallBeginTimeInSeconds(long paramLong)
  {
    this.installBeginTimeInSeconds = paramLong;
  }

  public void setParameters(Map<String, String> paramMap)
  {
    this.parameters = paramMap;
  }

  public void setPartnerParameters(Map<String, String> paramMap)
  {
    this.partnerParameters = paramMap;
  }

  public void setPath(String paramString)
  {
    this.path = paramString;
  }

  public void setSuffix(String paramString)
  {
    this.suffix = paramString;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.activityKind.toString();
    arrayOfObject[1] = this.suffix;
    return Util.formatString("%s%s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityPackage
 * JD-Core Version:    0.6.2
 */