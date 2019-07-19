package com.viber.provider.messages.b;

import com.viber.voip.util.av;

public class a
{
  public static class a
  {
    public static final String a = "business_inbox_grouping_insert_trigger AFTER INSERT ON conversations WHEN new.business_inbox_flags <> 0 BEGIN " + c + " END;";
    public static final String b = "business_inbox_grouping_update_trigger AFTER UPDATE OF business_inbox_flags ON conversations BEGIN " + c + " END;";
    private static final String c = "UPDATE conversations SET grouping_key = (CASE WHEN business_inbox_flags & " + av.a(0, 0) + " <> 0 THEN '" + "business_inbox" + "' ELSE NULL END) WHERE " + "_id" + " = new." + "_id" + ";";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.messages.b.a
 * JD-Core Version:    0.6.2
 */