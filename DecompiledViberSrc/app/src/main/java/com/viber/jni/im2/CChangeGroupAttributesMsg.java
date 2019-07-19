package com.viber.jni.im2;

public class CChangeGroupAttributesMsg
{
  public final String categoryId;
  public final int changedFlags;
  public final int curRevision;
  public final String email;
  public final CGroupAttributes groupAttributes;
  public final long groupID;
  public final Byte isChangePa;
  public final int seq;
  public final String subCategoryId;
  public final String website;

  public CChangeGroupAttributesMsg(long paramLong, int paramInt1, int paramInt2, int paramInt3, CGroupAttributes paramCGroupAttributes)
  {
    this.groupID = paramLong;
    this.seq = paramInt1;
    this.curRevision = paramInt2;
    this.changedFlags = paramInt3;
    this.groupAttributes = ((CGroupAttributes)Im2Utils.checkStructValue(paramCGroupAttributes));
    this.isChangePa = null;
    this.categoryId = null;
    this.subCategoryId = null;
    this.website = null;
    this.email = null;
    init();
  }

  public CChangeGroupAttributesMsg(long paramLong, int paramInt1, int paramInt2, int paramInt3, CGroupAttributes paramCGroupAttributes, byte paramByte)
  {
    this.groupID = paramLong;
    this.seq = paramInt1;
    this.curRevision = paramInt2;
    this.changedFlags = paramInt3;
    this.groupAttributes = ((CGroupAttributes)Im2Utils.checkStructValue(paramCGroupAttributes));
    this.isChangePa = Byte.valueOf(paramByte);
    this.categoryId = null;
    this.subCategoryId = null;
    this.website = null;
    this.email = null;
    init();
  }

  public CChangeGroupAttributesMsg(long paramLong, int paramInt1, int paramInt2, int paramInt3, CGroupAttributes paramCGroupAttributes, byte paramByte, String paramString)
  {
    this.groupID = paramLong;
    this.seq = paramInt1;
    this.curRevision = paramInt2;
    this.changedFlags = paramInt3;
    this.groupAttributes = ((CGroupAttributes)Im2Utils.checkStructValue(paramCGroupAttributes));
    this.isChangePa = Byte.valueOf(paramByte);
    this.categoryId = Im2Utils.checkStringValue(paramString);
    this.subCategoryId = null;
    this.website = null;
    this.email = null;
    init();
  }

  public CChangeGroupAttributesMsg(long paramLong, int paramInt1, int paramInt2, int paramInt3, CGroupAttributes paramCGroupAttributes, byte paramByte, String paramString1, String paramString2)
  {
    this.groupID = paramLong;
    this.seq = paramInt1;
    this.curRevision = paramInt2;
    this.changedFlags = paramInt3;
    this.groupAttributes = ((CGroupAttributes)Im2Utils.checkStructValue(paramCGroupAttributes));
    this.isChangePa = Byte.valueOf(paramByte);
    this.categoryId = Im2Utils.checkStringValue(paramString1);
    this.subCategoryId = Im2Utils.checkStringValue(paramString2);
    this.website = null;
    this.email = null;
    init();
  }

  public CChangeGroupAttributesMsg(long paramLong, int paramInt1, int paramInt2, int paramInt3, CGroupAttributes paramCGroupAttributes, byte paramByte, String paramString1, String paramString2, String paramString3)
  {
    this.groupID = paramLong;
    this.seq = paramInt1;
    this.curRevision = paramInt2;
    this.changedFlags = paramInt3;
    this.groupAttributes = ((CGroupAttributes)Im2Utils.checkStructValue(paramCGroupAttributes));
    this.isChangePa = Byte.valueOf(paramByte);
    this.categoryId = Im2Utils.checkStringValue(paramString1);
    this.subCategoryId = Im2Utils.checkStringValue(paramString2);
    this.website = Im2Utils.checkStringValue(paramString3);
    this.email = null;
    init();
  }

  public CChangeGroupAttributesMsg(long paramLong, int paramInt1, int paramInt2, int paramInt3, CGroupAttributes paramCGroupAttributes, byte paramByte, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.groupID = paramLong;
    this.seq = paramInt1;
    this.curRevision = paramInt2;
    this.changedFlags = paramInt3;
    this.groupAttributes = ((CGroupAttributes)Im2Utils.checkStructValue(paramCGroupAttributes));
    this.isChangePa = Byte.valueOf(paramByte);
    this.categoryId = Im2Utils.checkStringValue(paramString1);
    this.subCategoryId = Im2Utils.checkStringValue(paramString2);
    this.website = Im2Utils.checkStringValue(paramString3);
    this.email = Im2Utils.checkStringValue(paramString4);
    init();
  }

  private void init()
  {
  }

  public static abstract interface Sender
  {
    public abstract void handleCChangeGroupAttributesMsg(CChangeGroupAttributesMsg paramCChangeGroupAttributesMsg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.im2.CChangeGroupAttributesMsg
 * JD-Core Version:    0.6.2
 */