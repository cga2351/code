package com.vk.sdk;

import java.util.ArrayList;

public class VKScope
{
  public static final String ADS = "ads";
  public static final String AUDIO = "audio";
  public static final String DIRECT = "direct";
  public static final String DOCS = "docs";
  public static final String EMAIL = "email";
  public static final String FRIENDS = "friends";
  public static final String GROUPS = "groups";
  public static final String MESSAGES = "messages";
  public static final String NOHTTPS = "nohttps";
  public static final String NOTES = "notes";
  public static final String NOTIFICATIONS = "notifications";
  public static final String NOTIFY = "notify";
  public static final String OFFLINE = "offline";
  public static final String PAGES = "pages";
  public static final String PHOTOS = "photos";
  public static final String STATS = "stats";
  public static final String STATUS = "status";
  public static final String VIDEO = "video";
  public static final String WALL = "wall";

  public static ArrayList<String> parseVkPermissionsFromInteger(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt & 0x1) > 0)
      localArrayList.add("notify");
    if ((paramInt & 0x2) > 0)
      localArrayList.add("friends");
    if ((paramInt & 0x4) > 0)
      localArrayList.add("photos");
    if ((paramInt & 0x8) > 0)
      localArrayList.add("audio");
    if ((paramInt & 0x10) > 0)
      localArrayList.add("video");
    if ((paramInt & 0x80) > 0)
      localArrayList.add("pages");
    if ((paramInt & 0x400) > 0)
      localArrayList.add("status");
    if ((paramInt & 0x800) > 0)
      localArrayList.add("notes");
    if ((paramInt & 0x1000) > 0)
      localArrayList.add("messages");
    if ((paramInt & 0x2000) > 0)
      localArrayList.add("wall");
    if ((0x8000 & paramInt) > 0)
      localArrayList.add("ads");
    if ((0x10000 & paramInt) > 0)
      localArrayList.add("offline");
    if ((0x20000 & paramInt) > 0)
      localArrayList.add("docs");
    if ((0x40000 & paramInt) > 0)
      localArrayList.add("groups");
    if ((0x80000 & paramInt) > 0)
      localArrayList.add("notifications");
    if ((0x100000 & paramInt) > 0)
      localArrayList.add("stats");
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.VKScope
 * JD-Core Version:    0.6.2
 */