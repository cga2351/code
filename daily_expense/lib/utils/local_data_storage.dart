
import 'dart:convert';
import 'dart:io';

import 'package:dailyexpense/constants.dart';
import 'package:dailyexpense/data_provider/cached_local_data.dart';
import 'package:dailyexpense/model/expense_item.dart';
import 'package:dailyexpense/utils/file_utils.dart';
import 'package:flutter/foundation.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sprintf/sprintf.dart';

class LocalDataStorage {
  String _localDataStorageDir = "";
  String _expensesRecordBackupDir = "";
  String _expenseTypeFileFullPath = "";
  // String _expensesRecordFileDir = "";
  String _expensesRecordFileFullPath = "";
  String _expensesRecordBackupFileFullPath = "";
  // String _expensesRecordFileFullName = Constants.expensesRecordFileName;

  LocalDataStorage._internal();
  static final LocalDataStorage _instance = LocalDataStorage._internal();
  static LocalDataStorage get instance => _instance;

  int _maxItemsPerRecordFile = 10;
  List<ExpenseItem> cachedExpenseRecord = [];

  String get localDataStorageDir => _localDataStorageDir;
  String get expensesRecordBackupDir => _expensesRecordBackupDir;

  List<String> presetTypes = [
    Constants.SpecialExpenseType_NoExpense,
    "早饭",
    "午饭",
    "晚饭",
    "日常消费",
    "零食、水果",
    "日常用品",
    "医药费用",
    "娱乐消费",
    "买衣服",
    "油费",
    "停车费",
    "过路费",
    "车保养",
    "水",
    "电",
    "气",
    "上网",
    "房租",
    "房贷",
    "车贷",
    "装修",
    "其他",
  ];

  Future<void> init() async {
    print("LocalDataStorage.init(), entry");
    await initLocalDataStorageDir();
  }

  Future<void> initLocalDataStorageDir() async {
    Directory? directory;
    if (Platform.isAndroid) {
      _localDataStorageDir = Constants.localDataStorageDir;
      _expensesRecordBackupDir = Constants.expensesRecordBackupDir;
    } else if (Platform.isIOS) {
      directory = await getExternalStorageDirectory();
      if (null != directory) {
        _localDataStorageDir = directory.absolute.path + "/";
        _expensesRecordBackupDir = directory.absolute.path + "/dailyExpenseBackup/";
      } else {
        print("initLocalDataStorageDir(), getExternalStorageDirectory return null");
      }
    }

    _expenseTypeFileFullPath = _localDataStorageDir + Constants.expenseTypeFileName;
    _expensesRecordFileFullPath = _localDataStorageDir +  Constants.expensesRecordFileName;
    _expensesRecordBackupFileFullPath = _expensesRecordBackupDir +  Constants.expensesRecordBackupFileName;
  }

  void addPresetExpenseTypes() {
    LocalDataStorage.instance.clearExpenseType();
    for (int i = 0; i < presetTypes.length; i++) {
      LocalDataStorage.instance.addExpenseType(presetTypes[i]);
    }
  }

  void checkLocalFileExistAsync() {
    File(_expenseTypeFileFullPath).exists().then((exist) {
      if (!exist) {
        File(_expenseTypeFileFullPath).create(recursive: true);
      }
    });

    File(_expensesRecordFileFullPath).exists().then((exist) {
      if (!exist) {
        File(_expensesRecordFileFullPath).create(recursive: true);
      }
    });
  }

  void checkLocalFileExistSync() {
    print("checkLocalFileExistSync(), _expenseTypeFilePath=$_expenseTypeFileFullPath");
    // expense type file
    if (!File(_expenseTypeFileFullPath).existsSync()) {
      File(_expenseTypeFileFullPath).createSync(recursive: true);
    }

    // expense record file
    if (!File(_expensesRecordFileFullPath).existsSync()) {
      File(_expensesRecordFileFullPath).createSync(recursive: true);
    }

    // expense record backup file dir
    if (!Directory(Constants.expensesRecordBackupDir).existsSync()) {
      Directory(Constants.expensesRecordBackupDir).createSync(recursive : true);
    }
  }

  String addExpenseType(String newExpenseType) {
    // print("addExpenseType(), entry, newExpenseType=$newExpenseType");
    List<String> expenseTypes = readExpenseType();
    // print("addExpenseType(), exist expense type=${expenseTypes}");
    if (!expenseTypes.contains(newExpenseType)) {
      // File expenseTypeFile = LocalFileUtils.openFile(_expenseTypeFilePath);
      // print("addExpenseType(), append expense type, newExpenseType=$newExpenseType");
      FileUtils.appendString(_expenseTypeFileFullPath, newExpenseType + ",");

      // update cached expense type
      CachedLocalData.instance.updateExpenseType(
          LocalDataStorage.instance.readExpenseType());

      return Constants.RES_SUCCESS;
    } else {
      print("addExpenseType(), expense type exists, newExpenseType=$newExpenseType");
      return "type already exists";
    }
  }

  void clearExpenseType() {
    print("clearExpenseType(), entry");
    // File expenseTypeFile = LocalFileUtils.openFile(_expenseTypeFilePath);
    FileUtils.writeString(_expenseTypeFileFullPath, "");

    // update cached expense type
    CachedLocalData.instance.updateExpenseType([]);
  }

  String delExpenseType(String expenseType) {
    print("delExpenseType(), entry, expenseType=$expenseType");
    List<String> expenseTypes = readExpenseType();
    print("delExpenseType(), exist expense type=${expenseTypes}");
    if (expenseTypes.contains(expenseType)) {
      expenseTypes.remove(expenseType);
      // File expenseTypeFile = LocalFileUtils.openFile(_expenseTypeFilePath);
      print("delExpenseType(), after del expense type, expenseTypes=${expenseTypes}");

      // clear old expense type, add remaining types
      FileUtils.writeString(_expenseTypeFileFullPath, "");
      expenseTypes.forEach((element) {
        FileUtils.appendString(_expenseTypeFileFullPath, element + ",");
      });

      // update cached expense type
      CachedLocalData.instance.updateExpenseType(expenseTypes);

      return Constants.RES_SUCCESS;
    } else {
      print("delExpenseType(), expenseType of $expenseType not found");
      return "expenseType of $expenseType not found";
    }
  }

  List<String> readExpenseType()  {
    // File expenseTypeFile = LocalFileUtils.openFile(_expenseTypeFilePath);
    String expenseTypeString = FileUtils.readString(_expenseTypeFileFullPath);
    return expenseTypeString.split(",")
        .where((element) => element.isNotEmpty).toList();
  }

  // int readCurRecordFileExpenseItemCount() {
  //   RandomAccessFile expenseRecordFile = File(_expensesRecordFilePath)
  //       .openSync(mode: FileMode.read);
  //
  //   int expenseCount = 0;
  //   if (expenseRecordFile.lengthSync() > 8) {
  //     List<int> expenseCountByte = expenseRecordFile.readSync(8);
  //     expenseCount = int.parse(Utf8Decoder().convert(expenseCountByte));
  //   }
  //   expenseRecordFile.closeSync();
  //
  //   print("current record file of $_expensesRecordFilePath record count=$expenseCount");
  //   return expenseCount;
  // }

  void addExpenseItem(ExpenseItem expenseItem) {
    print("addExpenseItem(), entry, expenseItem=$expenseItem");

    // add new item to cached item record list
    cachedExpenseRecord.add(expenseItem);

    // sort item by date decrease
    cachedExpenseRecord.sort(ExpenseItem.comparatorDateDecrease);

    // write to record file
    writeCachedRecordToFile();
  }

  void updateExpenseItem(ExpenseItem newExpenseItem) {
    print("updateExpenseItem(), entry, newExpenseItem=$newExpenseItem");

    // update cached record item
    ExpenseItem existingItem = cachedExpenseRecord.firstWhere((element) {
      return element.id == newExpenseItem.id;
    });
    if (null == existingItem) {
      print("edit item failed, can't find the item, newExpenseItem to save:$newExpenseItem");
    } else {
      existingItem.dateTimestamp = newExpenseItem.dateTimestamp;
      existingItem.date = newExpenseItem.date;
      existingItem.type = newExpenseItem.type;
      existingItem.amount = newExpenseItem.amount;
      existingItem.comment = newExpenseItem.comment;
    }

    // sort item by date decrease
    cachedExpenseRecord.sort(ExpenseItem.comparatorDateDecrease);

    // write to record file
    writeCachedRecordToFile();
  }

  void delExpenseItem(ExpenseItem expenseItem) {
    print("delExpenseItem(), entry, expenseItem=$expenseItem");

    // update cached record
    cachedExpenseRecord.remove(expenseItem);

    // write to record file
    writeCachedRecordToFile();
  }

  void delExpenseItemById(int id) {
    print("delExpenseItemById(), entry, id=$id");

    // update cached record
    cachedExpenseRecord.removeWhere((element) {
      return id == element.id;
    });

    // write to record file
    writeCachedRecordToFile();
  }

  void writeCachedRecordToFile() {
    // write to record file
    RandomAccessFile expenseRecordFile = File(_expensesRecordFileFullPath).openSync(mode: FileMode.write);
    expenseRecordFile.writeStringSync(ExpenseItem.toJsonArrayString(cachedExpenseRecord) + "\n");
    expenseRecordFile.closeSync();
  }

  List<ExpenseItem> getAllExpenseRecord() {
    // deep copy
    return cachedExpenseRecord.map((e) => ExpenseItem.deepCopy(e)).toList();
  }

  void readAllExpenseRecordToCache() {
    print("readAllExpenseRecordToCache(), entry");

    cachedExpenseRecord.clear();
    String allExpenseItems = FileUtils.readString(_expensesRecordFileFullPath);
    cachedExpenseRecord = ExpenseItem.fromJsonArrayString(allExpenseItems);
  }

  void backupExpenseRecord() {
    print("backupExpenseRecord(), entry");

    // expense record backup file dir firstly
    if (!Directory(Constants.expensesRecordBackupDir).existsSync()) {
      Directory(Constants.expensesRecordBackupDir).createSync(recursive : true);
    }

    String srcFilePath = _expensesRecordFileFullPath;
    String dstFilePath = _expensesRecordBackupFileFullPath;
    Process.run("cp", [srcFilePath, dstFilePath]).then((value) {
      if (value.stderr.toString().isNotEmpty) {
        print("backupExpenseRecord(), backup file failed, info:${value.stderr}");
      } else {
        String info = value.stdout.toString().isNotEmpty ? "info:${value.stdout.toString()}" : "";
        print("backupExpenseRecord(), backup file success, $info");
      }
    });
  }

  void checkBackupRecordFile() {
    int lastBackupTimestamp = 0;

    File backupFile = File(_expensesRecordBackupFileFullPath);
    if (backupFile.existsSync()) {
      lastBackupTimestamp = backupFile.lastModifiedSync().millisecondsSinceEpoch;
    }
    DateTime now = DateTime.now();

    // backup every week
    int backupInterval = 1000 * 60 * 60 * 24 * 7;
    if (now.millisecondsSinceEpoch - lastBackupTimestamp > backupInterval) {
      backupExpenseRecord();
    }
  }
}