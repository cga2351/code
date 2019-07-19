package twitter4j;

import java.io.Serializable;
import twitter4j.internal.json.z_T4JInternalParseUtil;
import twitter4j.internal.org.json.JSONObject;

class StatusDeletionNoticeImpl
  implements Serializable, StatusDeletionNotice
{
  private static final long serialVersionUID = 1723338404242596062L;
  private long statusId;
  private long userId;

  StatusDeletionNoticeImpl(JSONObject paramJSONObject)
  {
    this.statusId = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
    this.userId = z_T4JInternalParseUtil.getLong("user_id", paramJSONObject);
  }

  public int compareTo(StatusDeletionNotice paramStatusDeletionNotice)
  {
    long l = this.statusId - paramStatusDeletionNotice.getStatusId();
    if (l < -2147483648L)
      return -2147483648;
    if (l > 2147483647L)
      return 2147483647;
    return (int)l;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    StatusDeletionNoticeImpl localStatusDeletionNoticeImpl;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localStatusDeletionNoticeImpl = (StatusDeletionNoticeImpl)paramObject;
      if (this.statusId != localStatusDeletionNoticeImpl.statusId)
        return false;
    }
    while (this.userId == localStatusDeletionNoticeImpl.userId);
    return false;
  }

  public long getStatusId()
  {
    return this.statusId;
  }

  public long getUserId()
  {
    return this.userId;
  }

  public int hashCode()
  {
    return 31 * (int)(this.statusId ^ this.statusId >>> 32) + (int)(this.userId ^ this.userId >>> 32);
  }

  public String toString()
  {
    return "StatusDeletionNoticeImpl{statusId=" + this.statusId + ", userId=" + this.userId + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     twitter4j.StatusDeletionNoticeImpl
 * JD-Core Version:    0.6.2
 */