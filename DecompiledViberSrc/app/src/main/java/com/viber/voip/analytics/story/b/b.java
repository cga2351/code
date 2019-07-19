package com.viber.voip.analytics.story.b;

import com.viber.voip.analytics.b.a;
import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.e;
import com.viber.voip.analytics.story.f.a;
import java.util.List;

class b
{
  static e a()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("View Calls Screen").a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(int paramInt)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "# of Calls Cleared" }).a();
    return new e("Clear Call Log").a("# of Calls Cleared", Integer.valueOf(paramInt)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(int paramInt, String paramString1, List<String> paramList, long paramLong1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, long paramLong2, long paramLong3, boolean paramBoolean4, long paramLong4)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "# of Participants", "Initiating Call Country Name", "Destination Call Country Name", "Call Duration", "Call Method", "Viber Call?", "VLN Call?", "Viber In Call?", "End Reason", "Incoming Video Duration", "Outgoing Video Duration", "Video Enabled?", "Duration (Establish Connection)" }).a();
    return new e("End Call").a("# of Participants", Integer.valueOf(paramInt)).a("Initiating Call Country Name", paramString1).a("Destination Call Country Name", paramList).a("Call Duration", Long.valueOf(paramLong1)).a("Call Method", paramString2).a("Viber Call?", Boolean.valueOf(paramBoolean1)).a("VLN Call?", Boolean.valueOf(paramBoolean2)).a("Viber In Call?", Boolean.valueOf(paramBoolean3)).a("End Reason", paramString3).a("Incoming Video Duration", Long.valueOf(paramLong2)).a("Outgoing Video Duration", Long.valueOf(paramLong3)).a("Video Enabled?", Boolean.valueOf(paramBoolean4)).a("Duration (Establish Connection)", Long.valueOf(paramLong4)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(int paramInt, String paramString1, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "# of Participants", "Initiating Call Country Name", "Destination Call Country Name", "Entry Point", "Call Method", "Viber Call?" }).a();
    return new e("Start Call").a("# of Participants", Integer.valueOf(paramInt)).a("Initiating Call Country Name", paramString1).a("Destination Call Country Name", paramList).a("Entry Point", paramString2).a("Call Method", paramString3).a("Viber Call?", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point" }).a();
    return new e("View All Call Log Screen").a("Entry Point", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, String paramString4, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, long paramLong)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Initiating Call Country Name", "Destination Call Country Name", "Caller Photo", "Caller Name", "Call Method", "Action Type", "Viber Call?", "VLN Call?", "Viber In Call?", "Act On Duration" }).a();
    return new e("Act on Incoming Call").a("Initiating Call Country Name", paramString1).a("Destination Call Country Name", paramString2).a("Caller Photo", Boolean.valueOf(paramBoolean1)).a("Caller Name", Boolean.valueOf(paramBoolean2)).a("Call Method", paramString3).a("Action Type", paramString4).a("Viber Call?", Boolean.valueOf(paramBoolean3)).a("VLN Call?", Boolean.valueOf(paramBoolean4)).a("Viber In Call?", Boolean.valueOf(paramBoolean5)).a("Act On Duration", Long.valueOf(paramLong)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("View Group Call Screen").a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b(int paramInt)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Number of participants" }).a();
    return new e("Group Call - Add Participant").a("Number of participants", Integer.valueOf(paramInt)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Button Clicked" }).a();
    return new e("Act on Group Call Screen").a("Button Clicked", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e c()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("free calls made").a(a.class, locala);
  }

  static e c(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Origin" }).a();
    return new e("Group Call - Join Group Call").a("Origin", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e d()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("free calls international made").a(a.class, locala);
  }

  static e e()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("free calls received").a(a.class, locala);
  }

  static e f()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("free calls international received").a(a.class, locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.b
 * JD-Core Version:    0.6.2
 */