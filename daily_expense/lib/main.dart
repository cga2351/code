import 'package:dailyexpense/bloc/expense_list_bloc.dart';
import 'package:dailyexpense/bloc/home_bloc.dart';
import 'package:dailyexpense/page/home_page.dart';
import 'package:dailyexpense/utils/id_utils.dart';
import 'package:dailyexpense/utils/local_data_storage.dart';
import 'package:dailyexpense/utils/sys_utils.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:get/get.dart';
import 'package:permission_handler/permission_handler.dart';

/*
早饭 午饭 晚饭	 水 电 气	油费 停车费 过路费  车保养	   日常用品	  日常消费	   零食、水果	 娱乐消费	 上网  医药费用  买衣服		 房租	房贷	车贷	装修	其他
									                         支出 备注	 支出 备注	  支出 备注	 支出 备注	   支出 备注	      支出 备注	支出 备注					                支出 备注

 */
void main() => runApp(MainApp());

void init() {

  // init local data save file path first
  LocalDataStorage.instance.init().then((_) {
    print("LocalDataStorage.instance.init(), complete");

    // create local save files
    LocalDataStorage.instance.checkLocalFileExistSync();

    // add preset expense types
    LocalDataStorage.instance.addPresetExpenseTypes();

    // init local id file
    IDUtils.init();

    // check if need to backup record file
    LocalDataStorage.instance.checkBackupRecordFile();

    // init system info class instance
    SysUtils.init();

  });
}

final GlobalKey<NavigatorState> globalNavigatorKey = new GlobalKey<NavigatorState>();

class MainApp extends StatefulWidget {

  @override
  State createState() {
    return MainAppState();
  }
}

class MainAppState extends State<MainApp> {
  bool grantAllPermissions = false;

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // return GetMaterialApp(
      navigatorKey: globalNavigatorKey,
      title: 'Daily Expense of MainApp',
      theme: ThemeData(
          primarySwatch: Colors.lightBlue,
          dialogBackgroundColor: Colors.white
      ),

      // home: MyHomePage(title: 'Daily Expense'),

      // home: BlocProvider<HomeBloc>(
      //   create: (context) => HomeBloc(),
      //   child: HomePage(title: 'Daily Expense'),
      // ),

      home: MultiBlocProvider(
        providers: [
          BlocProvider(create: (_) => HomeBloc(HomeStateNormal(0, 0)),),
          BlocProvider(create: (_) => ExpenseListBloc(ExpenseListStateInit()),),
        ],
        child: _buildHomeView(),
      ),
    );
  }

  Widget _buildHomeView() {
    if (grantAllPermissions) {
      init();
      return HomePage(title: 'Daily Expense');
    } else {
      requestPermissions();
      return Scaffold(
        appBar: AppBar(title: Text("Daily Expense")),
        body: Center(
          child: Text("no permission"),
        ),
      );
    }
  }

  List<Permission> permissions = [
    Permission.storage,
    Permission.phone,
  ];

  void requestPermissions() async {
    print("requestPermissions(), entry");

    bool checkAllGranted = await checkPermissions();
    if (!checkAllGranted) {
      permissions.request().then((value) {
        Map<Permission, PermissionStatus> result = value;
        bool allGranted = true;
        result.forEach((permission, status) {
          if (status == PermissionStatus.denied) {
            print("requestPermissions(), permission of $permission denied");
            allGranted = false;
          }
        });
        print("requestPermissions(), allGranted=$allGranted");
        if (allGranted) {
          // update ui
          setState(() {
            grantAllPermissions = true;
          });
        }
      });
    } else {
      // update ui
      setState(() {
        grantAllPermissions = true;
      });
    }
  }

  Future<bool> checkPermissions() async {
    bool checkAllGranted = true;

    for (int i = 0; i < permissions.length; i++) {
      PermissionStatus permissionStatus = await permissions[i].status;
      print("checkPermissions(), permissionStatus=$permissionStatus");
      if (permissionStatus == PermissionStatus.denied) {
        checkAllGranted = false;
        print("checkPermissions(), not all permissions granted");
      }
    }
    return checkAllGranted;
  }

  // List<PermissionGroup> permissions = [
  //   PermissionGroup.storage,
  // ];
  //
  // void requestPermissionsOld() async {
  //   print("requestPermissions(), entry");
  //   bool checkAllGranted = await checkPermissions();
  //   if (!checkAllGranted) {
  //     PermissionHandler().requestPermissions(permissions).then((value) {
  //       Map<PermissionGroup, PermissionStatus> result = value;
  //       bool allGranted = true;
  //       result.forEach((permission, status) {
  //         if (status == PermissionStatus.denied) {
  //           print("requestPermissions(), permission of $permission denied");
  //           allGranted = false;
  //         }
  //       });
  //       print("requestPermissions(), allGranted=$allGranted");
  //       if (allGranted) {
  //         // update ui
  //         setState(() {
  //           grantAllPermissions = true;
  //         });
  //       }
  //     });
  //   } else {
  //     // update ui
  //     setState(() {
  //       grantAllPermissions = true;
  //     });
  //   }
  // }

  // Future<bool> checkPermissions() async {
  //   bool checkAllGranted = true;
  //
  //   for (int i = 0; i < permissions.length; i++) {
  //     PermissionStatus permissionStatus = await PermissionHandler()
  //         .checkPermissionStatus(permissions[i]);
  //     print("checkPermissions(), permissionStatus=${permissionStatus.value}");
  //     if (permissionStatus == PermissionStatus.denied) {
  //       checkAllGranted = false;
  //       print("checkPermissions(), not all permissions granted");
  //     }
  //   }
  //   return checkAllGranted;
  // }
}




