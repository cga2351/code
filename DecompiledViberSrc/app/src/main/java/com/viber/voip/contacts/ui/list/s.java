package com.viber.voip.contacts.ui.list;

import android.support.v4.util.SparseArrayCompat;
import com.viber.voip.R.id;

public class s
{
  private SparseArrayCompat<a> a = new SparseArrayCompat();

  public s()
  {
    this.a.put(R.id.participant_item, null);
    this.a.put(R.id.menu_message, null);
    this.a.put(R.id.menu_call, null);
    this.a.put(R.id.menu_view, null);
    this.a.put(R.id.menu_start_secret_chat, null);
    this.a.put(R.id.menu_start_anonymous_chat, null);
    this.a.put(R.id.admin_assign_role_action, null);
    this.a.put(R.id.admin_add_group_members_action, null);
    this.a.put(R.id.remove_from_chat, null);
    this.a.put(R.id.menu_ban, null);
    this.a.put(R.id.menu_unban, null);
  }

  public SparseArrayCompat<a> a()
  {
    return this.a;
  }

  public void a(int paramInt, a parama)
  {
    this.a.put(paramInt, parama);
  }

  public static class a
  {
    String a;

    public a(String paramString)
    {
      this.a = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.s
 * JD-Core Version:    0.6.2
 */