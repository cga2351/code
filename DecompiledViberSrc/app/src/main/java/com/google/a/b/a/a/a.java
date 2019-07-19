package com.google.a.b.a.a;

import com.google.a.a.d.b;
import com.google.a.a.d.h;
import com.google.a.a.f.k;
import com.google.a.a.f.q;
import java.util.List;
import java.util.Map;

public final class a extends b
{

  @q
  private Map<String, String> appProperties;

  @q
  private a capabilities;

  @q
  private b contentHints;

  @q
  private k createdTime;

  @q
  private String description;

  @q
  private Boolean explicitlyTrashed;

  @q
  private String fileExtension;

  @q
  private String folderColorRgb;

  @q
  private String fullFileExtension;

  @q
  private Boolean hasAugmentedPermissions;

  @q
  private Boolean hasThumbnail;

  @q
  private String headRevisionId;

  @q
  private String iconLink;

  @q
  private String id;

  @q
  private c imageMediaMetadata;

  @q
  private Boolean isAppAuthorized;

  @q
  private String kind;

  @q
  private c lastModifyingUser;

  @q
  private String md5Checksum;

  @q
  private String mimeType;

  @q
  private Boolean modifiedByMe;

  @q
  private k modifiedByMeTime;

  @q
  private k modifiedTime;

  @q
  private String name;

  @q
  private String originalFilename;

  @q
  private Boolean ownedByMe;

  @q
  private List<c> owners;

  @q
  private List<String> parents;

  @q
  private List<String> permissionIds;

  @q
  private List<Object> permissions;

  @q
  private Map<String, String> properties;

  @h
  @q
  private Long quotaBytesUsed;

  @q
  private Boolean shared;

  @q
  private k sharedWithMeTime;

  @q
  private c sharingUser;

  @h
  @q
  private Long size;

  @q
  private List<String> spaces;

  @q
  private Boolean starred;

  @q
  private String teamDriveId;

  @q
  private String thumbnailLink;

  @h
  @q
  private Long thumbnailVersion;

  @q
  private Boolean trashed;

  @q
  private k trashedTime;

  @q
  private c trashingUser;

  @h
  @q
  private Long version;

  @q
  private d videoMediaMetadata;

  @q
  private Boolean viewedByMe;

  @q
  private k viewedByMeTime;

  @q
  private Boolean viewersCanCopyContent;

  @q
  private String webContentLink;

  @q
  private String webViewLink;

  @q
  private Boolean writersCanShare;

  public a a(String paramString)
  {
    this.name = paramString;
    return this;
  }

  public a a(String paramString, Object paramObject)
  {
    return (a)super.b(paramString, paramObject);
  }

  public a a(List<String> paramList)
  {
    this.parents = paramList;
    return this;
  }

  public a a(Map<String, String> paramMap)
  {
    this.appProperties = paramMap;
    return this;
  }

  public Map<String, String> a()
  {
    return this.appProperties;
  }

  public String e()
  {
    return this.id;
  }

  public k f()
  {
    return this.modifiedTime;
  }

  public String g()
  {
    return this.name;
  }

  public Long h()
  {
    return this.size;
  }

  public a i()
  {
    return (a)super.b();
  }

  public static final class a extends b
  {

    @q
    private Boolean canAddChildren;

    @q
    private Boolean canChangeViewersCanCopyContent;

    @q
    private Boolean canComment;

    @q
    private Boolean canCopy;

    @q
    private Boolean canDelete;

    @q
    private Boolean canDownload;

    @q
    private Boolean canEdit;

    @q
    private Boolean canListChildren;

    @q
    private Boolean canMoveItemIntoTeamDrive;

    @q
    private Boolean canMoveTeamDriveItem;

    @q
    private Boolean canReadRevisions;

    @q
    private Boolean canReadTeamDrive;

    @q
    private Boolean canRemoveChildren;

    @q
    private Boolean canRename;

    @q
    private Boolean canShare;

    @q
    private Boolean canTrash;

    @q
    private Boolean canUntrash;

    public a a()
    {
      return (a)super.b();
    }

    public a a(String paramString, Object paramObject)
    {
      return (a)super.b(paramString, paramObject);
    }
  }

  public static final class b extends b
  {

    @q
    private String indexableText;

    @q
    private a thumbnail;

    public b a()
    {
      return (b)super.b();
    }

    public b a(String paramString, Object paramObject)
    {
      return (b)super.b(paramString, paramObject);
    }

    public static final class a extends b
    {

      @q
      private String image;

      @q
      private String mimeType;

      public a a()
      {
        return (a)super.b();
      }

      public a a(String paramString, Object paramObject)
      {
        return (a)super.b(paramString, paramObject);
      }
    }
  }

  public static final class c extends b
  {

    @q
    private Float aperture;

    @q
    private String cameraMake;

    @q
    private String cameraModel;

    @q
    private String colorSpace;

    @q
    private Float exposureBias;

    @q
    private String exposureMode;

    @q
    private Float exposureTime;

    @q
    private Boolean flashUsed;

    @q
    private Float focalLength;

    @q
    private Integer height;

    @q
    private Integer isoSpeed;

    @q
    private String lens;

    @q
    private a location;

    @q
    private Float maxApertureValue;

    @q
    private String meteringMode;

    @q
    private Integer rotation;

    @q
    private String sensor;

    @q
    private Integer subjectDistance;

    @q
    private String time;

    @q
    private String whiteBalance;

    @q
    private Integer width;

    public c a()
    {
      return (c)super.b();
    }

    public c a(String paramString, Object paramObject)
    {
      return (c)super.b(paramString, paramObject);
    }

    public static final class a extends b
    {

      @q
      private Double altitude;

      @q
      private Double latitude;

      @q
      private Double longitude;

      public a a()
      {
        return (a)super.b();
      }

      public a a(String paramString, Object paramObject)
      {
        return (a)super.b(paramString, paramObject);
      }
    }
  }

  public static final class d extends b
  {

    @h
    @q
    private Long durationMillis;

    @q
    private Integer height;

    @q
    private Integer width;

    public d a()
    {
      return (d)super.b();
    }

    public d a(String paramString, Object paramObject)
    {
      return (d)super.b(paramString, paramObject);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.b.a.a.a
 * JD-Core Version:    0.6.2
 */