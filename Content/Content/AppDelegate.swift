//
//  AppDelegate.swift
//  Content
//
//  Created by fcn on 2018/10/8.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import RealmSwift



let BACKURL = "http://192.168.0.104:8080/api/user/"



@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?


    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        
        
        
        
        
        /* Realm 数据库配置，用于数据库的迭代更新 */
        let schemaVersion: UInt64 = 2
        let config = Realm.Configuration(schemaVersion: schemaVersion, migrationBlock: { migration, oldSchemaVersion in
            /* 什么都不要做！Realm 会自行检测新增和需要移除的属性，然后自动更新硬盘上的数据库架构 */
            if (oldSchemaVersion < schemaVersion) {}
        })
        Realm.Configuration.defaultConfiguration = config
        Realm.asyncOpen { (realm, error) in
            /* Realm 成功打开，迁移已在后台线程中完成 */
            if let _ = realm {
                print("Realm 数据库配置成功")
            }
                /* 处理打开 Realm 时所发生的错误 */
            else if let error = error {
                print("Realm 数据库配置失败：\(error.localizedDescription)")
            }
        }
        /* Realm 数据库配置，用于数据库的迭代更新 */
        
        
        
        
        UMConfigure.initWithAppkey("5bbeae43b465f5f0d6000052", channel: "app store")
        setupUSharePlatforms()
        
        
        
        return true
    }
    
    
    func setupUSharePlatforms()  {
        UMSocialManager.default().setPlaform(.wechatSession, appKey: "wxdc1e388c3822c80b", appSecret: "3baf1193c85774b3fd9d18447d76cab0", redirectURL: nil)
//        UMSocialManager.default().setPlaform(.wechatTimeLine, appKey: "wxdc1e388c3822c80b", appSecret: "3baf1193c85774b3fd9d18447d76cab0", redirectURL: nil)
    }
    
    func setupUShareSettings()  {
    }

    func applicationWillResignActive(_ application: UIApplication) {
        // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
        // Use this method to pause ongoing tasks, disable timers, and invalidate graphics rendering callbacks. Games should use this method to pause the game.
    }

    func applicationDidEnterBackground(_ application: UIApplication) {
        // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
        // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
    }

    func applicationWillEnterForeground(_ application: UIApplication) {
        // Called as part of the transition from the background to the active state; here you can undo many of the changes made on entering the background.
    }

    func applicationDidBecomeActive(_ application: UIApplication) {
        // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
    }

    func applicationWillTerminate(_ application: UIApplication) {
        // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
    }


}

