package com.viber.voip.analytics.story.e;

import com.viber.voip.analytics.b.a;
import com.viber.voip.analytics.story.StoryConstants.n;
import com.viber.voip.analytics.story.b.a;
import com.viber.voip.analytics.story.e;
import com.viber.voip.analytics.story.f.a;

class b
{
  static e a()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("View Chat Screen").a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(int paramInt1, int paramInt2, String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Sticker ID", "Sticker Pack ID", "Sticker Type" }).a();
    return new e("Long Tap on Sticker").a("Sticker ID", Integer.valueOf(paramInt1)).a("Sticker Pack ID", Integer.valueOf(paramInt2)).a("Sticker Type", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, String paramString6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString8, boolean paramBoolean7, boolean paramBoolean8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean9, String paramString13, String paramString14, String paramString15, int paramInt2, float paramFloat, boolean paramBoolean10, @StoryConstants.n String paramString16, int paramInt3, boolean paramBoolean11, String paramString17, int paramInt4, String paramString18, int paramInt5, int paramInt6, boolean paramBoolean12, String paramString19)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "# of People in Chat", "Chat ID", "Chat Name", "Sticker Pack ID", "Sticker ID", "Sticker Send Origin", "Sticker Clicker?", "Sticker Type", "Image Gallery Origin", "Caption Included?", "Media Included?", "GIF Included?", "URL Included?", "Emoticon Included?", "Emoticon IDs", "Doodle Included?", "Contact Included?", "Chat Extension URI", "Chat Extension Service", "Chat Extension Service Origin", "Chat Extension Content Origin", "Location Attached?", "Message Origin", "Chat Type", "Message Type", "Content Length (s)", "Content Size (mb)", "First Message in Chat?", "Action Type", "Message Character Length", "Time Bomb Limit", "Time Bomb Included?", "# of Videos Included", "Keyboard Language", "# of Images Included", "# of Questions in Poll", "Referral added?", "Chat Role" }).a();
    return new e("Send Message").a("# of People in Chat", Integer.valueOf(paramInt1)).a("Chat ID", paramString1).a("Chat Name", paramString2).a("Sticker Pack ID", paramString3).a("Sticker ID", paramString4).a("Sticker Send Origin", paramString5).a("Sticker Clicker?", Boolean.valueOf(paramBoolean1)).a("Sticker Type", paramString6).a("Image Gallery Origin", paramString7).a("Caption Included?", Boolean.valueOf(paramBoolean2)).a("Media Included?", Boolean.valueOf(paramBoolean3)).a("GIF Included?", Boolean.valueOf(paramBoolean4)).a("URL Included?", Boolean.valueOf(paramBoolean5)).a("Emoticon Included?", Boolean.valueOf(paramBoolean6)).a("Emoticon IDs", paramString8).a("Doodle Included?", Boolean.valueOf(paramBoolean7)).a("Contact Included?", Boolean.valueOf(paramBoolean8)).a("Chat Extension URI", paramString9).a("Chat Extension Service", paramString10).a("Chat Extension Service Origin", paramString11).a("Chat Extension Content Origin", paramString12).a("Location Attached?", Boolean.valueOf(paramBoolean9)).a("Message Origin", paramString13).a("Chat Type", paramString14).a("Message Type", paramString15).a("Content Length (s)", Integer.valueOf(paramInt2)).a("Content Size (mb)", Float.valueOf(paramFloat)).a("First Message in Chat?", Boolean.valueOf(paramBoolean10)).a("Action Type", paramString16).a("Message Character Length", Integer.valueOf(paramInt3)).a("Time Bomb Limit", paramString17).a("Time Bomb Included?", Boolean.valueOf(paramBoolean11)).a("# of Videos Included", Integer.valueOf(paramInt4)).a("Keyboard Language", paramString18).a("# of Images Included", Integer.valueOf(paramInt5)).a("# of Questions in Poll", Integer.valueOf(paramInt6)).a("Referral added?", Boolean.valueOf(paramBoolean12)).a("Chat Role", paramString19).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Number of Chats", "Chat Type", "Entry Point", "Native Share?" }).a();
    return new e("Share Community Link").a("Number of Chats", Integer.valueOf(paramInt)).a("Chat Type", paramString2).a("Entry Point", paramString1).a("Native Share?", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(int paramInt1, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString3, String paramString4, boolean paramBoolean8, String paramString5, String paramString6, String paramString7, boolean paramBoolean9, int paramInt2, String paramString8)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "# of People in Chat", "Formatted Message?", "Chat ID", "Chat Name", "First Message Received?", "Sticker Included?", "Caption Included?", "Media Included?", "GIF Included?", "URL Included?", "Contact Included?", "Chat Extension Value", "Chat Extension Service", "Location Attached?", "Message Type", "Chat Type", "Keyboard Language", "First Message in Chat?", "# of Questions in Poll", "Chat Role" }).a();
    return new e("Receive Message").a("# of People in Chat", Integer.valueOf(paramInt1)).a("Formatted Message?", Boolean.valueOf(paramBoolean1)).a("Chat ID", paramString1).a("Chat Name", paramString2).a("First Message Received?", "").a("Sticker Included?", Boolean.valueOf(paramBoolean2)).a("Caption Included?", Boolean.valueOf(paramBoolean3)).a("Media Included?", Boolean.valueOf(paramBoolean4)).a("GIF Included?", Boolean.valueOf(paramBoolean5)).a("URL Included?", Boolean.valueOf(paramBoolean6)).a("Contact Included?", Boolean.valueOf(paramBoolean7)).a("Chat Extension Value", paramString3).a("Chat Extension Service", paramString4).a("Location Attached?", Boolean.valueOf(paramBoolean8)).a("Message Type", paramString5).a("Chat Type", paramString6).a("Keyboard Language", paramString7).a("First Message in Chat?", Boolean.valueOf(paramBoolean9)).a("# of Questions in Poll", Integer.valueOf(paramInt2)).a("Chat Role", paramString8).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Button Clicked" }).a();
    return new e("View Translation Dialog Screen").a("Button Clicked", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString, int paramInt)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point", "# of People in Chat" }).a();
    return new e("Join Community").a("Entry Point", paramString).a("# of People in Chat", Integer.valueOf(paramInt)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry point", "Chat type" }).a();
    return new e("Search In Chat").a("Entry point", paramString1).a("Chat type", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, String paramString3, int paramInt2, String paramString4)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Chat ID", "Chat Name", "# of People in Chat", "Group Chat?", "Chat Role", "# of Unread Messages", "Chat Type" }).a();
    return new e("View Chat").a("Chat ID", paramString1).a("Chat Name", paramString2).a("# of People in Chat", Integer.valueOf(paramInt1)).a("Group Chat?", Boolean.valueOf(paramBoolean)).a("Chat Role", paramString3).a("# of Unread Messages", Integer.valueOf(paramInt2)).a("Chat Type", paramString4).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Chat ID", "Chat Name", "Chat Type" }).a();
    return new e("Enable Smart Notifications").a("Chat ID", paramString2).a("Chat Name", paramString1).a("Chat Type", paramString3).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Chat ID", "Chat Name", "Chat Type", "# of People Invited", "Chat Creation Origin", "M2M Chat Role" }).a();
    return new e("Create Chat").a("Chat ID", paramString1).a("Chat Name", paramString2).a("Chat Type", paramString3).a("# of People Invited", Integer.valueOf(paramInt)).a("Chat Creation Origin", paramString4).a("M2M Chat Role", paramString5).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2, String paramString3, Integer paramInteger)
  {
    b.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Button Clicked", "Origin", "Chat Type" });
    if (paramInteger != null)
      locala.a(new String[] { "# of People in Chat" });
    return new e("Act on Leave and Delete Dialog").a("Button Clicked", paramString1).a("Origin", paramString2).a("Chat Type", paramString3).a("# of People in Chat", paramInteger).a(com.viber.voip.analytics.e.b.class, locala.a());
  }

  static e a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Chat ID", "Chat Name", "Chat Type", "Origin" }).a();
    return new e("Snooze Chat").a("Chat ID", paramString1).a("Chat Name", paramString2).a("Chat Type", paramString3).a("Origin", paramString4).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Chat ID", "Chat Name", "Entry Point", "Chat Type", "Number of Participants" }).a();
    return new e("Add Participants to Chat").a("Chat ID", paramString1).a("Chat Name", paramString2).a("Entry Point", paramString3).a("Chat Type", paramString4).a("Number of Participants", Integer.valueOf(paramInt)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Message Type", "Chat ID", "Chat Name", "Action Type", "Chat Type" }).a();
    return new e("Act on Message").a("Message Type", paramString1).a("Chat ID", paramString2).a("Chat Name", paramString3).a("Action Type", paramString4).a("Chat Type", paramString5).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Browser", "Origin", "Chat Type", "First Time?" }).a();
    return new e("Click Link").a("Browser", paramString1).a("Origin", paramString2).a("Chat Type", paramString3).a("First Time?", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Browser", "Domain", "Origin", "First Time?", "Chat Type", "Tooltip Appeared?" }).a();
    return new e("Save Link to Favorites").a("Domain", paramString1).a("Origin", paramString2).a("First Time?", Boolean.valueOf(paramBoolean1)).a("Chat Type", paramString3).a("Tooltip Appeared?", Boolean.valueOf(paramBoolean2)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e a(boolean paramBoolean)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Status" }).a();
    return new e("Change M2M Status").a("Status", Boolean.valueOf(paramBoolean)).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("View Say Hi Banner").a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b(String paramString)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Chat Type" }).a();
    return new e("Delete Conversation").a("Chat Type", paramString).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b(String paramString1, String paramString2)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Source Language", "Target Language" }).a();
    return new e("Translate Message").a("Source Language", paramString1).a("Target Language", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point", "Chat ID", "Chat Name" }).a();
    return new e("Search Sticker").a("Entry Point", paramString1).a("Chat ID", paramString2).a("Chat Name", paramString3).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Chat ID", "Chat Name", "Chat Type", "Origin" }).a();
    return new e("Unsnooze Chat").a("Chat ID", paramString1).a("Chat Name", paramString2).a("Chat Type", paramString3).a("Origin", paramString4).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e c()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("Communities - Show Message").a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e c(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point", "Chat ID", "Chat Name" }).a();
    return new e("View Chat Information").a("Entry Point", paramString3).a("Chat ID", paramString1).a("Chat Name", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e d()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("Convert M2M Chat to 1-on-1").a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e d(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Image Change Type", "Chat ID", "Chat Name" }).a();
    return new e("Change Chat Background").a("Image Change Type", paramString3).a("Chat ID", paramString1).a("Chat Name", paramString2).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e e()
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[0]).a();
    return new e("Create a poll").a(a.class, locala);
  }

  static e e(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Chat ID", "Chat Name", "Chat Type" }).a();
    return new e("Mute Chat").a("Chat ID", paramString1).a("Chat Name", paramString2).a("Chat Type", paramString3).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e f(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Chat ID", "Chat Name", "Chat Type" }).a();
    return new e("Unmute Chat").a("Chat ID", paramString1).a("Chat Name", paramString2).a("Chat Type", paramString3).a(com.viber.voip.analytics.e.b.class, locala);
  }

  static e g(String paramString1, String paramString2, String paramString3)
  {
    f.a locala = com.viber.voip.analytics.story.b.a(new String[] { "Entry Point", "Selected action", "Member Role" }).a();
    return new e("Act on Member").a("Entry Point", paramString1).a("Selected action", paramString2).a("Member Role", paramString3).a(com.viber.voip.analytics.e.b.class, locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.e.b
 * JD-Core Version:    0.6.2
 */