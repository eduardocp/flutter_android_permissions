package br.com.ecp.flutterandroidpermissions;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;


public class FlutterAndroidPermissionsPlugin implements MethodCallHandler, PluginRegistry.RequestPermissionsResultListener {

//    private SparseArray map = new SparseArray();
    private Registrar registrar;
    private Result result;

    private FlutterAndroidPermissionsPlugin(Registrar registrar) {
        this.registrar = registrar;

//        map.put(28, "ACCEPT_HANDOVER");
//        map.put(1, "ACCESS_CHECKIN_PROPERTIES");
//        map.put(1, "ACCESS_COARSE_LOCATION");
//        map.put(1, "ACCESS_FINE_LOCATION");
//        map.put(1, "ACCESS_LOCATION_EXTRA_COMMANDS");
//        map.put(1, "ACCESS_NETWORK_STATE");
//        map.put(23, "ACCESS_NOTIFICATION_POLICY");
//        map.put(1, "ACCESS_WIFI_STATE");
//        map.put(5, "ACCOUNT_MANAGER");
//        map.put(14, "ADD_VOICEMAIL");
//        map.put(26, "ANSWER_PHONE_CALLS");
//        map.put(1, "BATTERY_STATS");
//        map.put(16, "BIND_ACCESSIBILITY_SERVICE");
//        map.put(3, "BIND_APPWIDGET");
//        map.put(26, "BIND_AUTOFILL_SERVICE");
//        map.put(22, "BIND_CARRIER_MESSAGING_SERVICE");
//        map.put(23, "BIND_CARRIER_SERVICES");
//        map.put(23, "BIND_CHOOSER_TARGET_SERVICE");
//        map.put(24, "BIND_CONDITION_PROVIDER_SERVICE");
//        map.put(8, "BIND_DEVICE_ADMIN");
//        map.put(21, "BIND_DREAM_SERVICE");
//        map.put(23, "BIND_INCALL_SERVICE");
//        map.put(3, "BIND_INPUT_METHOD");
//        map.put(23, "BIND_MIDI_DEVICE_SERVICE");
//        map.put(19, "BIND_NFC_SERVICE");
//        map.put(18, "BIND_NOTIFICATION_LISTENER_SERVICE");
//        map.put(19, "BIND_PRINT_SERVICE");
//        map.put(24, "BIND_QUICK_SETTINGS_TILE");
//        map.put(11, "BIND_REMOTEVIEWS");
//        map.put(24, "BIND_SCREENING_SERVICE");
//        map.put(23, "BIND_TELECOM_CONNECTION_SERVICE");
//        map.put(14, "BIND_TEXT_SERVICE");
//        map.put(21, "BIND_TV_INPUT");
//        map.put(26, "BIND_VISUAL_VOICEMAIL_SERVICE");
//        map.put(21, "BIND_VOICE_INTERACTION");
//        map.put(14, "BIND_VPN_SERVICE");
//        map.put(24, "BIND_VR_LISTENER_SERVICE");
//        map.put(8, "BIND_WALLPAPER");
//        map.put(1, "BLUETOOTH");
//        map.put(1, "BLUETOOTH_ADMIN");
//        map.put(19, "BLUETOOTH_PRIVILEGED");
//        map.put(20, "BODY_SENSORS");
//        map.put(1, "BROADCAST_PACKAGE_REMOVED");
//        map.put(2, "BROADCAST_SMS");
//        map.put(1, "BROADCAST_STICKY");
//        map.put(2, "BROADCAST_WAP_PUSH");
//        map.put(1, "CALL_PHONE");
//        map.put(1, "CALL_PRIVILEGED");
//        map.put(1, "CAMERA");
//        map.put(19, "CAPTURE_AUDIO_OUTPUT");
//        map.put(19, "CAPTURE_SECURE_VIDEO_OUTPUT");
//        map.put(19, "CAPTURE_VIDEO_OUTPUT");
//        map.put(1, "CHANGE_COMPONENT_ENABLED_STATE");
//        map.put(1, "CHANGE_CONFIGURATION");
//        map.put(1, "CHANGE_NETWORK_STATE");
//        map.put(4, "CHANGE_WIFI_MULTICAST_STATE");
//        map.put(1, "CHANGE_WIFI_STATE");
//        map.put(1, "CLEAR_APP_CACHE");
//        map.put(1, "CONTROL_LOCATION_UPDATES");
//        map.put(1, "DELETE_CACHE_FILES");
//        map.put(1, "DELETE_PACKAGES");
//        map.put(1, "DIAGNOSTIC");
//        map.put(1, "DISABLE_KEYGUARD");
//        map.put(1, "DUMP");
//        map.put(1, "EXPAND_STATUS_BAR");
//        map.put(1, "FACTORY_TEST");
//        map.put(28, "FOREGROUND_SERVICE");
//        map.put(1, "GET_ACCOUNTS");
//        map.put(23, "GET_ACCOUNTS_PRIVILEGED");
//        map.put(1, "GET_PACKAGE_SIZE");
//        map.put(1, "GET_TASKS");
//        map.put(4, "GLOBAL_SEARCH");
//        map.put(4, "INSTALL_LOCATION_PROVIDER");
//        map.put(1, "INSTALL_PACKAGES");
//        map.put(19, "INSTALL_SHORTCUT");
//        map.put(26, "INSTANT_APP_FOREGROUND_SERVICE");
//        map.put(1, "INTERNET");
//        map.put(8, "KILL_BACKGROUND_PROCESSES");
//        map.put(18, "LOCATION_HARDWARE");
//        map.put(19, "MANAGE_DOCUMENTS");
//        map.put(26, "MANAGE_OWN_CALLS");
//        map.put(1, "MASTER_CLEAR");
//        map.put(19, "MEDIA_CONTENT_CONTROL");
//        map.put(1, "MODIFY_AUDIO_SETTINGS");
//        map.put(1, "MODIFY_PHONE_STATE");
//        map.put(3, "MOUNT_FORMAT_FILESYSTEMS");
//        map.put(1, "MOUNT_UNMOUNT_FILESYSTEMS");
//        map.put(9, "NFC");
//        map.put(28, "NFC_TRANSACTION_EVENT");
//        map.put(23, "PACKAGE_USAGE_STATS");
//        map.put(1, "PERSISTENT_ACTIVITY");
//        map.put(1, "PROCESS_OUTGOING_CALLS");
//        map.put(1, "READ_CALENDAR");
//        map.put(16, "READ_CALL_LOG");
//        map.put(1, "READ_CONTACTS");
//        map.put(16, "READ_EXTERNAL_STORAGE");
//        map.put(1, "READ_FRAME_BUFFER");
//        map.put(1, "READ_INPUT_STATE");
//        map.put(1, "READ_LOGS");
//        map.put(26, "READ_PHONE_NUMBERS");
//        map.put(1, "READ_PHONE_STATE");
//        map.put(1, "READ_SMS");
//        map.put(1, "READ_SYNC_SETTINGS");
//        map.put(1, "READ_SYNC_STATS");
//        map.put(21, "READ_VOICEMAIL");
//        map.put(1, "REBOOT");
//        map.put(1, "RECEIVE_BOOT_COMPLETED");
//        map.put(1, "RECEIVE_MMS");
//        map.put(1, "RECEIVE_SMS");
//        map.put(1, "RECEIVE_WAP_PUSH");
//        map.put(1, "RECORD_AUDIO");
//        map.put(1, "REORDER_TASKS");
//        map.put(26, "REQUEST_COMPANION_RUN_IN_BACKGROUND");
//        map.put(26, "REQUEST_COMPANION_USE_DATA_IN_BACKGROUND");
//        map.put(26, "REQUEST_DELETE_PACKAGES");
//        map.put(23, "REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
//        map.put(23, "REQUEST_INSTALL_PACKAGES");
//        map.put(1, "RESTART_PACKAGES");
//        map.put(18, "SEND_RESPOND_VIA_MESSAGE");
//        map.put(1, "SEND_SMS");
//        map.put(9, "SET_ALARM");
//        map.put(1, "SET_ALWAYS_FINISH");
//        map.put(1, "SET_ANIMATION_SCALE");
//        map.put(1, "SET_DEBUG_APP");
//        map.put(1, "SET_PREFERRED_APPLICATIONS");
//        map.put(1, "SET_PROCESS_LIMIT");
//        map.put(8, "SET_TIME");
//        map.put(1, "SET_TIME_ZONE");
//        map.put(1, "SET_WALLPAPER");
//        map.put(1, "SET_WALLPAPER_HINTS");
//        map.put(1, "SIGNAL_PERSISTENT_PROCESSES");
//        map.put(1, "STATUS_BAR");
//        map.put(1, "SYSTEM_ALERT_WINDOW");
//        map.put(19, "TRANSMIT_IR");
//        map.put(19, "UNINSTALL_SHORTCUT");
//        map.put(3, "UPDATE_DEVICE_STATS");
//        map.put(28, "USE_BIOMETRIC");
//        map.put(23, "USE_FINGERPRINT");
//        map.put(9, "USE_SIP");
//        map.put(1, "VIBRATE");
//        map.put(1, "WAKE_LOCK");
//        map.put(1, "WRITE_APN_SETTINGS");
    }

    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_android_permissions");
        FlutterAndroidPermissionsPlugin plugin = new FlutterAndroidPermissionsPlugin(registrar);
        channel.setMethodCallHandler(plugin);
        registrar.addRequestPermissionsResultListener(plugin);
    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {
        List<String> permissions;
        switch (call.method) {
            case "getPermissionStatus":
                permissions = call.argument("permissions");
                result.success(get(permissions));
                break;
            case "requestPermissions":
                permissions = call.argument("permissions");
                this.result = result;
                requests(permissions);
                break;
            case "openSettings":
                openSettings();
                result.success(true);
                break;
            default:
                result.notImplemented();
                break;
        }
    }

    @Override
    public boolean onRequestPermissionsResult(int requestCode, String[] strings, int[] ints) {
        if (requestCode == 0 && ints.length > 0) {
            List<Integer> intList = new ArrayList<>();
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == PackageManager.PERMISSION_DENIED) {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(registrar.activity(), strings[i])) {
                        intList.add(-1);
                    } else {
                        intList.add(0);
                    }
                } else {
                    intList.add(1);
                }
            }
            result.success(intList);
            return true;
        }
        return true;
    }

    private List<Integer> get(List<String> permissions) {
        List<Integer> intList = new ArrayList<>();
        Activity activity = registrar.activity();
        for (String permission : permissions) {
            permission = "android.permission." + permission;
            if (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_DENIED) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                    intList.add(-1);
                } else {
                    intList.add(0);
                }
            } else {
                intList.add(1);
            }
        }
        return intList;
    }

    private void requests(List<String> permissionList) {
        Activity activity = registrar.activity();
        String[] permissions = new String[permissionList.size()];
        for (int i = 0; i < permissionList.size(); i++) {
            permissions[i] = "android.permission." + permissionList.get(i);
        }
        ActivityCompat.requestPermissions(activity, permissions, 0);
    }

    private void openSettings() {
        Activity activity = registrar.activity();
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + activity.getPackageName()));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
}
