package com.viber.voip.backup.d;

import android.database.Cursor;
import com.viber.jni.backup.GroupMessageBackupEntity;
import com.viber.voip.backup.c.d;
import com.viber.voip.backup.o;
import com.viber.voip.model.entity.u;

class f extends h<GroupMessageBackupEntity>
{
  private static final String[] f = { "conversations.name", "participants_info.number" };
  private static final int g = u.a.length;
  private static final int h = 1 + g;

  public f(o paramo)
  {
    super(GroupMessageBackupEntity.class, paramo);
  }

  protected void a(e parame, GroupMessageBackupEntity[] paramArrayOfGroupMessageBackupEntity)
    throws d
  {
    parame.a(paramArrayOfGroupMessageBackupEntity);
  }

  protected GroupMessageBackupEntity b(Cursor paramCursor)
  {
    this.e.a(paramCursor);
    GroupMessageBackupEntity localGroupMessageBackupEntity = new GroupMessageBackupEntity();
    a(this.e, localGroupMessageBackupEntity);
    localGroupMessageBackupEntity.setGroupId(this.e.s);
    localGroupMessageBackupEntity.setGroupName(paramCursor.getString(g));
    if (!this.e.d())
      localGroupMessageBackupEntity.setPhoneNumber(paramCursor.getString(h));
    return localGroupMessageBackupEntity;
  }

  protected void b(e parame)
    throws d
  {
    parame.c();
  }

  protected String[] d()
  {
    return f;
  }

  protected int g()
  {
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.f
 * JD-Core Version:    0.6.2
 */