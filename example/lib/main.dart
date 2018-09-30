import 'package:flutter/material.dart';
import 'package:flutter_android_permissions/flutter_android_permissions.dart';

void main() => runApp(new MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => new _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String get = '';

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Plugin example app'),
        ),
        body: Center(
          child: new Column(
            children: <Widget>[
              RaisedButton(onPressed: getPermissionStatus, child: new Text("Get permission status")),
              RaisedButton(onPressed: requestPermissions, child: new Text("Request permissions")),
              RaisedButton(onPressed: requestPermission, child: new Text("Request single permission")),
              RaisedButton(onPressed: FlutterAndroidPermissions.openSettings, child: new Text("Open settings")),
              Text(get),
            ],
          ),
        ),
      ),
    );
  }

  getPermissionStatus() async {
    get = '';
    List<Permission> permissions = await FlutterAndroidPermissions.getPermissionStatus([PermissionName.READ_PHONE_STATE]);
    permissions.forEach((permission) {
      get += '${permission.permissionName}: ${permission.permissionStatus}\n';
    });
    setState(() {
      get;
    });
  }

  requestPermissions() async {
    final res = await FlutterAndroidPermissions.requestPermissions([PermissionName.READ_PHONE_STATE]);
    res.forEach((permission) {});
  }

  requestPermission() async {
    final res = await FlutterAndroidPermissions.requestSinglePermission(PermissionName.READ_PHONE_STATE);
    print(res);
  }
}
