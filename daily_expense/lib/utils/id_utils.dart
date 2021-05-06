import 'dart:ffi';
import 'dart:io';

import 'package:dailyexpense/constants.dart';
import 'package:dailyexpense/utils/file_utils.dart';
import 'package:dailyexpense/utils/local_data_storage.dart';
import 'package:uuid/uuid.dart';
import 'package:uuid/uuid_util.dart';

class IDUtils {
  static String _localIntIdFilePath = "";

  static void init() {
    // read local int id value
    _localIntIdFilePath = LocalDataStorage.instance.localDataStorageDir + Constants.LocalIntIdFileName;
    File localIdFile = File(_localIntIdFilePath);
    if (!localIdFile.existsSync()) {
      localIdFile.createSync(recursive : true);
    }

    String localIntId = FileUtils.readString(_localIntIdFilePath);
    try {
      _curIntID = int.parse(localIntId);
    } on Exception catch (e) {
      print("IDUtils.init(), parse id exception, localIntId=$localIntId");
      _curIntID = 0;
    }
    print("IDUtils.init(), _curIntID=$_curIntID");
  }

  // global uuid
  static Uuid _uuid = Uuid();
  static String genUUID() {
    return _uuid.v4();
  }

  // local int id
  static int _curIntID = 0;
  static int genLocalIntID() {
    // multi thread synchronize?
    _curIntID++;
    // max 32bit int
    if (_curIntID > 0xFFFFFFFF) {
      _curIntID = 0;
    }
    FileUtils.writeString(_localIntIdFilePath, _curIntID.toString());
    return _curIntID;
  }
}