package com.viber.service.contacts.sync.c;

import android.content.ContentValues;
import android.content.Context;
import com.viber.voip.R.string;

public class a
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;

  public a(Context paramContext)
  {
    this.a = paramContext.getString(R.string.app_name);
    this.b = paramContext.getString(R.string.contacts_book_viber_free_call_btn_descr);
    this.c = paramContext.getString(R.string.contacts_book_viber_free_message_btn_desc);
    this.d = paramContext.getString(R.string.contacts_book_viber_out_call_btn_descr);
  }

  public ContentValues a(ContentValues paramContentValues, String paramString)
  {
    paramContentValues.put("data1", paramString);
    paramContentValues.put("data2", this.a);
    paramContentValues.put("data3", String.format(this.b, new Object[] { paramString }));
    paramContentValues.put("mimetype", "vnd.android.cursor.item/vnd.com.viber.voip.viber_number_call");
    return paramContentValues;
  }

  public ContentValues b(ContentValues paramContentValues, String paramString)
  {
    paramContentValues.put("data1", paramString);
    paramContentValues.put("data2", this.a);
    paramContentValues.put("data3", String.format(this.c, new Object[] { paramString }));
    paramContentValues.put("mimetype", "vnd.android.cursor.item/vnd.com.viber.voip.viber_number_message");
    return paramContentValues;
  }

  public ContentValues c(ContentValues paramContentValues, String paramString)
  {
    paramContentValues.put("data1", paramString);
    paramContentValues.put("data2", this.a);
    paramContentValues.put("data3", String.format(this.d, new Object[] { paramString }));
    paramContentValues.put("mimetype", "vnd.android.cursor.item/vnd.com.viber.voip.viber_out_call_viber");
    return paramContentValues;
  }

  public ContentValues d(ContentValues paramContentValues, String paramString)
  {
    paramContentValues.put("data1", paramString);
    paramContentValues.put("data2", this.a);
    paramContentValues.put("data3", String.format(this.d, new Object[] { paramString }));
    paramContentValues.put("mimetype", "vnd.android.cursor.item/vnd.com.viber.voip.viber_out_call_none_viber");
    return paramContentValues;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.sync.c.a
 * JD-Core Version:    0.6.2
 */