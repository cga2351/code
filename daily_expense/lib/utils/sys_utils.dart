import 'dart:io';

import 'package:device_info/device_info.dart';
import 'package:flutter/services.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:mobile_number/mobile_number.dart';
import 'package:permission_handler/permission_handler.dart';

class SysUtils {
  static Map<String, dynamic> deviceInfo = <String, dynamic>{};

  static void init() {
    _initPlatformInfo();
    _initMobileNumberInfo();
  }

  static Future<void> _initPlatformInfo() async {
    final DeviceInfoPlugin deviceInfoPlugin = DeviceInfoPlugin();
    try {
      if (Platform.isAndroid) {
        deviceInfo = _readAndroidBuildData(await deviceInfoPlugin.androidInfo);
      } else if (Platform.isIOS) {
        deviceInfo = _readIosDeviceInfo(await deviceInfoPlugin.iosInfo);
      }
    } on PlatformException {
      deviceInfo = <String, dynamic>{
        'Error:': 'Failed to get platform version.'
      };
    }
  }

  static Map<String, dynamic> _readAndroidBuildData(AndroidDeviceInfo build) {
    return <String, dynamic>{
      'version.securityPatch': build.version.securityPatch,
      'version.sdkInt': build.version.sdkInt,
      'version.release': build.version.release,
      'version.previewSdkInt': build.version.previewSdkInt,
      'version.incremental': build.version.incremental,
      'version.codename': build.version.codename,
      'version.baseOS': build.version.baseOS,
      'board': build.board,
      'bootloader': build.bootloader,
      'brand': build.brand,
      'device': build.device,
      'display': build.display,
      'fingerprint': build.fingerprint,
      'hardware': build.hardware,
      'host': build.host,
      'id': build.id,
      'manufacturer': build.manufacturer,
      'model': build.model,
      'product': build.product,
      'supported32BitAbis': build.supported32BitAbis,
      'supported64BitAbis': build.supported64BitAbis,
      'supportedAbis': build.supportedAbis,
      'tags': build.tags,
      'type': build.type,
      'isPhysicalDevice': build.isPhysicalDevice,
      'androidId': build.androidId,
      'systemFeatures': build.systemFeatures,
    };
  }

  static Map<String, dynamic> _readIosDeviceInfo(IosDeviceInfo data) {
    return <String, dynamic>{
      'name': data.name,
      'systemName': data.systemName,
      'systemVersion': data.systemVersion,
      'model': data.model,
      'localizedModel': data.localizedModel,
      'identifierForVendor': data.identifierForVendor,
      'isPhysicalDevice': data.isPhysicalDevice,
      'utsname.sysname:': data.utsname.sysname,
      'utsname.nodename:': data.utsname.nodename,
      'utsname.release:': data.utsname.release,
      'utsname.version:': data.utsname.version,
      'utsname.machine:': data.utsname.machine,
    };
  }

  static List<SimCard> _simCard = <SimCard>[];
  static String mobileNumber = "";

  // Platform messages are asynchronous, so we initialize in an async method.
  static Future<void> _initMobileNumberInfo() async {
    print("SysUtils._initMobileNumberInfo(), entry");
    PermissionStatus permissionStatus = await Permission.phone.status;
    if (permissionStatus == PermissionStatus.denied) {
      Fluttertoast.showToast(msg: "SysUtils._initMobileNumberInfo(), no phone permission", toastLength: Toast.LENGTH_LONG);
    } else {
      _getPhoneNumber();
    }
  }
  static void _getPhoneNumber() async {
    if (!await MobileNumber.hasPhonePermission) {
      print("SysUtils._getPhoneNumber(), no phone permission");
      await MobileNumber.requestPhonePermission;
      return;
    }
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      mobileNumber = (await MobileNumber.mobileNumber)!;
      _simCard = (await MobileNumber.getSimCards)!;
    } on PlatformException catch (e) {
      print("SysUtils._getPhoneNumber(), Failed to get mobile number because of '${e.message}'");
    }

    // final String? carrierName;
    // final String? displayName;
    // final int? slotIndex;
    // final String? number;
    // final String? countryIso;
    // final String? countryPhonePrefix;

    _simCard.forEach((element) {
      print("SysUtils._getPhoneNumber()"
          + ", carrierName=${element.carrierName}"
          + ", displayName=${element.displayName}"
          + ", slotIndex=${element.slotIndex}"
          + ", number=${element.number}"
          + ", countryIso=${element.countryIso}"
          + ", countryPhonePrefix=${element.countryPhonePrefix}"
      );
    });
  }

  static bool isPhysicalDevice() {
    // android / ios property name are both "isPhysicalDevice"
    return deviceInfo["isPhysicalDevice"];
  }

  static String getPhoneModel() {
    // android / ios property name are both "model"
    return deviceInfo["model"];
  }

  static String getPhoneNumber() {
    return mobileNumber;
  }
}