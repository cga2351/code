package com.adjust.sdk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;

public class ActivityState
  implements Serializable, Cloneable
{
  private static final int ORDER_ID_MAXCOUNT = 10;
  private static final ObjectStreamField[] serialPersistentFields = arrayOfObjectStreamField;
  private static final long serialVersionUID = 9039439291143138148L;
  protected String adid = null;
  protected boolean askingAttribution = false;
  protected long clickTime = 0L;
  protected boolean enabled = true;
  protected int eventCount = 0;
  protected long installBegin = 0L;
  protected String installReferrer = null;
  protected boolean isGdprForgotten = false;
  protected long lastActivity = -1L;
  protected long lastInterval = -1L;
  private transient ILogger logger = AdjustFactory.getLogger();
  protected LinkedList<String> orderIds = null;
  protected String pushToken = null;
  protected int sessionCount = 0;
  protected long sessionLength = -1L;
  protected int subsessionCount = -1;
  protected long timeSpent = -1L;
  protected boolean updatePackages = false;
  protected String uuid = Util.createUuid();

  static
  {
    ObjectStreamField[] arrayOfObjectStreamField = new ObjectStreamField[18];
    arrayOfObjectStreamField[0] = new ObjectStreamField("uuid", String.class);
    arrayOfObjectStreamField[1] = new ObjectStreamField("enabled", Boolean.TYPE);
    arrayOfObjectStreamField[2] = new ObjectStreamField("isGdprForgotten", Boolean.TYPE);
    arrayOfObjectStreamField[3] = new ObjectStreamField("askingAttribution", Boolean.TYPE);
    arrayOfObjectStreamField[4] = new ObjectStreamField("eventCount", Integer.TYPE);
    arrayOfObjectStreamField[5] = new ObjectStreamField("sessionCount", Integer.TYPE);
    arrayOfObjectStreamField[6] = new ObjectStreamField("subsessionCount", Integer.TYPE);
    arrayOfObjectStreamField[7] = new ObjectStreamField("sessionLength", Long.TYPE);
    arrayOfObjectStreamField[8] = new ObjectStreamField("timeSpent", Long.TYPE);
    arrayOfObjectStreamField[9] = new ObjectStreamField("lastActivity", Long.TYPE);
    arrayOfObjectStreamField[10] = new ObjectStreamField("lastInterval", Long.TYPE);
    arrayOfObjectStreamField[11] = new ObjectStreamField("updatePackages", Boolean.TYPE);
    arrayOfObjectStreamField[12] = new ObjectStreamField("orderIds", LinkedList.class);
    arrayOfObjectStreamField[13] = new ObjectStreamField("pushToken", String.class);
    arrayOfObjectStreamField[14] = new ObjectStreamField("adid", String.class);
    arrayOfObjectStreamField[15] = new ObjectStreamField("clickTime", Long.TYPE);
    arrayOfObjectStreamField[16] = new ObjectStreamField("installBegin", Long.TYPE);
    arrayOfObjectStreamField[17] = new ObjectStreamField("installReferrer", String.class);
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    ObjectInputStream.GetField localGetField = paramObjectInputStream.readFields();
    this.eventCount = Util.readIntField(localGetField, "eventCount", 0);
    this.sessionCount = Util.readIntField(localGetField, "sessionCount", 0);
    this.subsessionCount = Util.readIntField(localGetField, "subsessionCount", -1);
    this.sessionLength = Util.readLongField(localGetField, "sessionLength", -1L);
    this.timeSpent = Util.readLongField(localGetField, "timeSpent", -1L);
    this.lastActivity = Util.readLongField(localGetField, "lastActivity", -1L);
    this.lastInterval = Util.readLongField(localGetField, "lastInterval", -1L);
    this.uuid = Util.readStringField(localGetField, "uuid", null);
    this.enabled = Util.readBooleanField(localGetField, "enabled", true);
    this.isGdprForgotten = Util.readBooleanField(localGetField, "isGdprForgotten", false);
    this.askingAttribution = Util.readBooleanField(localGetField, "askingAttribution", false);
    this.updatePackages = Util.readBooleanField(localGetField, "updatePackages", false);
    this.orderIds = ((LinkedList)Util.readObjectField(localGetField, "orderIds", null));
    this.pushToken = Util.readStringField(localGetField, "pushToken", null);
    this.adid = Util.readStringField(localGetField, "adid", null);
    this.clickTime = Util.readLongField(localGetField, "clickTime", -1L);
    this.installBegin = Util.readLongField(localGetField, "installBegin", -1L);
    this.installReferrer = Util.readStringField(localGetField, "installReferrer", null);
    if (this.uuid == null)
      this.uuid = Util.createUuid();
  }

  private static String stamp(long paramLong)
  {
    Calendar.getInstance().setTimeInMillis(paramLong);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(11);
    arrayOfObject[1] = Integer.valueOf(12);
    arrayOfObject[2] = Integer.valueOf(13);
    return Util.formatString("%02d:%02d:%02d", arrayOfObject);
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
  }

  protected void addOrderId(String paramString)
  {
    if (this.orderIds == null)
      this.orderIds = new LinkedList();
    if (this.orderIds.size() >= 10)
      this.orderIds.removeLast();
    this.orderIds.addFirst(paramString);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    ActivityState localActivityState;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localActivityState = (ActivityState)paramObject;
      if (!Util.equalString(this.uuid, localActivityState.uuid))
        return false;
      if (!Util.equalBoolean(Boolean.valueOf(this.enabled), Boolean.valueOf(localActivityState.enabled)))
        return false;
      if (!Util.equalBoolean(Boolean.valueOf(this.isGdprForgotten), Boolean.valueOf(localActivityState.isGdprForgotten)))
        return false;
      if (!Util.equalBoolean(Boolean.valueOf(this.askingAttribution), Boolean.valueOf(localActivityState.askingAttribution)))
        return false;
      if (!Util.equalInt(Integer.valueOf(this.eventCount), Integer.valueOf(localActivityState.eventCount)))
        return false;
      if (!Util.equalInt(Integer.valueOf(this.sessionCount), Integer.valueOf(localActivityState.sessionCount)))
        return false;
      if (!Util.equalInt(Integer.valueOf(this.subsessionCount), Integer.valueOf(localActivityState.subsessionCount)))
        return false;
      if (!Util.equalLong(Long.valueOf(this.sessionLength), Long.valueOf(localActivityState.sessionLength)))
        return false;
      if (!Util.equalLong(Long.valueOf(this.timeSpent), Long.valueOf(localActivityState.timeSpent)))
        return false;
      if (!Util.equalLong(Long.valueOf(this.lastInterval), Long.valueOf(localActivityState.lastInterval)))
        return false;
      if (!Util.equalBoolean(Boolean.valueOf(this.updatePackages), Boolean.valueOf(localActivityState.updatePackages)))
        return false;
      if (!Util.equalObject(this.orderIds, localActivityState.orderIds))
        return false;
      if (!Util.equalString(this.pushToken, localActivityState.pushToken))
        return false;
      if (!Util.equalString(this.adid, localActivityState.adid))
        return false;
      if (!Util.equalLong(Long.valueOf(this.clickTime), Long.valueOf(localActivityState.clickTime)))
        return false;
      if (!Util.equalLong(Long.valueOf(this.installBegin), Long.valueOf(localActivityState.installBegin)))
        return false;
    }
    while (Util.equalString(this.installReferrer, localActivityState.installReferrer));
    return false;
  }

  protected boolean findOrderId(String paramString)
  {
    if (this.orderIds == null)
      return false;
    return this.orderIds.contains(paramString);
  }

  public int hashCode()
  {
    return 37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (629 + Util.hashString(this.uuid)) + Util.hashBoolean(Boolean.valueOf(this.enabled))) + Util.hashBoolean(Boolean.valueOf(this.isGdprForgotten))) + Util.hashBoolean(Boolean.valueOf(this.askingAttribution))) + this.eventCount) + this.sessionCount) + this.subsessionCount) + Util.hashLong(Long.valueOf(this.sessionLength))) + Util.hashLong(Long.valueOf(this.timeSpent))) + Util.hashLong(Long.valueOf(this.lastInterval))) + Util.hashBoolean(Boolean.valueOf(this.updatePackages))) + Util.hashObject(this.orderIds)) + Util.hashString(this.pushToken)) + Util.hashString(this.adid)) + Util.hashLong(Long.valueOf(this.clickTime))) + Util.hashLong(Long.valueOf(this.installBegin))) + Util.hashString(this.installReferrer);
  }

  protected void resetSessionAttributes(long paramLong)
  {
    this.subsessionCount = 1;
    this.sessionLength = 0L;
    this.timeSpent = 0L;
    this.lastActivity = paramLong;
    this.lastInterval = -1L;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.eventCount);
    arrayOfObject[1] = Integer.valueOf(this.sessionCount);
    arrayOfObject[2] = Integer.valueOf(this.subsessionCount);
    arrayOfObject[3] = Double.valueOf(this.sessionLength / 1000.0D);
    arrayOfObject[4] = Double.valueOf(this.timeSpent / 1000.0D);
    arrayOfObject[5] = stamp(this.lastActivity);
    arrayOfObject[6] = this.uuid;
    return Util.formatString("ec:%d sc:%d ssc:%d sl:%.1f ts:%.1f la:%s uuid:%s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityState
 * JD-Core Version:    0.6.2
 */