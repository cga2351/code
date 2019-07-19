package com.viber.voip.backup.d;

import android.database.Cursor;
import com.viber.jni.backup.MessageBackupEntity;
import com.viber.voip.backup.c.d;
import com.viber.voip.backup.o;
import com.viber.voip.model.entity.u;

class g extends h<MessageBackupEntity>
{
  private static final String[] f = { "(CASE WHEN participants_info.number='unknown_number' THEN '' ELSE participants_info.number END) as participant_number" };
  private static final int g = u.a.length;

  public g(o paramo)
  {
    super(MessageBackupEntity.class, paramo);
  }

  protected void a(e parame, MessageBackupEntity[] paramArrayOfMessageBackupEntity)
    throws d
  {
    parame.a(paramArrayOfMessageBackupEntity);
  }

  protected MessageBackupEntity b(Cursor paramCursor)
  {
    this.e.a(paramCursor);
    MessageBackupEntity localMessageBackupEntity = new MessageBackupEntity();
    a(this.e, localMessageBackupEntity);
    if (!this.e.d())
      localMessageBackupEntity.setPhoneNumber(paramCursor.getString(g));
    return localMessageBackupEntity;
  }

  protected void b(e parame)
    throws d
  {
    parame.b();
  }

  protected String[] d()
  {
    return f;
  }

  protected StringBuilder e()
  {
    StringBuilder localStringBuilder = super.e();
    localStringBuilder.append(" AND messages.user_id NOT LIKE 'em:%'");
    return localStringBuilder;
  }

  protected int g()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.g
 * JD-Core Version:    0.6.2
 */