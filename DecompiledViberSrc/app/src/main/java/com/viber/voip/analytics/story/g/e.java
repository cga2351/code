package com.viber.voip.analytics.story.g;

import com.viber.voip.analytics.b.a;
import com.viber.voip.analytics.story.StoryConstants.l;
import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.f.a;
import com.viber.voip.analytics.story.k.e.a;

class e
{
  static com.viber.voip.analytics.story.e a()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new com.viber.voip.analytics.story.e("Ban User").a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "# of People Invited", "Chat ID", "Group Name", "Group Image?", "Change Type", "Image Change Type" }).a();
    return new com.viber.voip.analytics.story.e("Edit Chat Details").a("# of People Invited", Integer.valueOf(paramInt)).a("Chat ID", paramString1).a("Group Name", paramString2).a("Group Image?", Boolean.valueOf(paramBoolean)).a("Change Type", paramString3).a("Image Change Type", paramString4).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(long paramLong)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Session Duration" }).a();
    return new com.viber.voip.analytics.story.e("App Close").a("Session Duration", Long.valueOf(paramLong)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point" }).a();
    return new com.viber.voip.analytics.story.e("Invite Friend").a("Entry Point", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(String paramString, int paramInt, boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Type", "# of Messages Backed Up", "Google Drive Connected?" }).a();
    return new com.viber.voip.analytics.story.e("Start Backup Data").a("Type", paramString).a("# of Messages Backed Up", Integer.valueOf(paramInt)).a("Google Drive Connected?", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(String paramString1, long paramLong, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Placement", "Latency", "Network Type" }).a();
    return new com.viber.voip.analytics.story.e("Ad Loaded").a("Placement", paramString1).a("Latency", Long.valueOf(paramLong)).a("Network Type", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(String paramString1, long paramLong, String paramString2, String paramString3, boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Placement", "Latency", "Network Type", "Provider", "Is Cached Ad?" }).a();
    return new com.viber.voip.analytics.story.e("Ad Impression").a("Placement", paramString1).a("Latency", Long.valueOf(paramLong)).a("Network Type", paramString2).a("Provider", paramString3).a("Is Cached Ad?", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(String paramString1, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Frequency", "Entry Point" }).a();
    return new com.viber.voip.analytics.story.e("Change Backup Frequency").a("Frequency", paramString1).a("Entry Point", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Change Category", "Change Setting Name", "Old Value", "New Value" }).a();
    return new com.viber.voip.analytics.story.e("Change Settings").a("Change Category", paramString1).a("Change Setting Name", paramString2).a("Old Value", paramObject1).a("New Value", paramObject2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Share Action Type", "Screenshot Type", "Chat Type" }).a();
    return new com.viber.voip.analytics.story.e("Share Screenshot").a("Share Action Type", paramString1).a("Screenshot Type", paramString2).a("Chat Type", paramString3).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(String paramString1, boolean paramBoolean, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Community Name", "Community Image?", "Community Description" }).a();
    return new com.viber.voip.analytics.story.e("Create Community").a("Community Name", paramString1).a("Community Image?", Boolean.valueOf(paramBoolean)).a("Community Description", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e a(boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Ad Displayed" }).a();
    return new com.viber.voip.analytics.story.e("View Public Screen").a("Ad Displayed", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e b()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new com.viber.voip.analytics.story.e("Unban User").a(com.viber.voip.analytics.e.b.class, locala);
  }

  public static com.viber.voip.analytics.story.e b(long paramLong)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Session Duration" }).a();
    return new com.viber.voip.analytics.story.e("Close News").a("Session Duration", Long.valueOf(paramLong)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e b(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Account Type" }).a();
    return new com.viber.voip.analytics.story.e("Connect Account").a("Account Type", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e b(String paramString, int paramInt, boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Type", "# of Messages Backed Up", "Google Drive Connected?" }).a();
    return new com.viber.voip.analytics.story.e("Complete Backup Data").a("Type", paramString).a("# of Messages Backed Up", Integer.valueOf(paramInt)).a("Google Drive Connected?", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e b(String paramString1, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Source Language", "Target Language" }).a();
    return new com.viber.voip.analytics.story.e("Change Translation Language").a("Source Language", paramString1).a("Target Language", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e b(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Source Language", "Target Language", "Entry Point" }).a();
    return new com.viber.voip.analytics.story.e("Change Viber Language").a("Source Language", paramString1).a("Target Language", paramString2).a("Entry Point", paramString3).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e c()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Dialog" }).a();
    return new com.viber.voip.analytics.story.e("View Dialog").a("Dialog", "465 - Clear Data Dialog").a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e c(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Button Clicked" }).a();
    return new com.viber.voip.analytics.story.e("View Deactivate Screen").a("Button Clicked", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  public static com.viber.voip.analytics.story.e c(String paramString1, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point", "Provider" }).a();
    return new com.viber.voip.analytics.story.e("Open News").a("Entry Point", paramString1).a("Provider", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  public static com.viber.voip.analytics.story.e c(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Origin", "Chat Type", "Provider" }).a();
    return new com.viber.voip.analytics.story.e("Share Article from News").a("Origin", paramString1).a("Chat Type", paramString3).a("Provider", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e d()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Type" }).a();
    return new com.viber.voip.analytics.story.e("Clear Media and Storage").a("Type", "Clear Data").a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e d(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Button Clicked" }).a();
    return new com.viber.voip.analytics.story.e("View Phone Number Screen").a("Button Clicked", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  public static com.viber.voip.analytics.story.e e()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new com.viber.voip.analytics.story.e("viewed news").a(new com.viber.voip.analytics.story.k.e(e.a.c, "viewed news", "")).a(a.class, locala);
  }

  static com.viber.voip.analytics.story.e e(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point" }).a();
    return new com.viber.voip.analytics.story.e("Change Phone Number").a("Entry Point", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  public static com.viber.voip.analytics.story.e f()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new com.viber.voip.analytics.story.e("share article from news").a(a.class, locala);
  }

  static com.viber.voip.analytics.story.e f(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Value" }).a();
    return new com.viber.voip.analytics.story.e("Mark Chat").a("Value", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e g(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Banner Type" }).a();
    return new com.viber.voip.analytics.story.e("View Banner").a("Banner Type", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e h(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Element Clicked" }).a();
    return new com.viber.voip.analytics.story.e("Act On Banner").a("Element Clicked", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e i(@StoryConstants.l String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point" }).a();
    return new com.viber.voip.analytics.story.e("View Media and Storage Screen").a("Entry Point", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e j(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Dark Mode ON/OFF" }).a();
    return new com.viber.voip.analytics.story.e("Dark Mode Toggle Selected").a("Dark Mode ON/OFF", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static com.viber.voip.analytics.story.e k(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Viber lang" }).a();
    return new com.viber.voip.analytics.story.e("changed viber lang").a("Viber lang", paramString).a(a.class, locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.g.e
 * JD-Core Version:    0.6.2
 */