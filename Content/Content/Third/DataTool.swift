//
//  DataTool.swift
//  ReTest
//
//  Created by fcn on 2018/6/22.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import RealmSwift


class DataTool: NSObject {
    
    
    
    class func getUUID() -> String {
        return String(Date().timeIntervalSince1970)
    }
    
    class func getCurrentTime() -> String {
        
        let formatter = DateFormatter()
        formatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
        let dateTime = formatter.string(from: Date())
        return dateTime
    }

    class func addValue(values: Object) {
        do {
            let realm = try Realm()
            try realm.write {
                realm.add(values, update: true)
            }
        } catch let error as NSError {
            // 错误处理
            print(error)
        }
    }
    
    
    
    class func searchValue<Element: Object>(type: Element.Type, condition: String) -> Results<Element>?{
        do {
            let realm = try Realm()
            return realm.objects(type).filter(condition)
        } catch let error as NSError {
            // 错误处理
            print(error)
            return nil
        }
    }
    
    
    class func searchValueByBlock<Element: Object>(type: Element.Type, condition: String, completionHandler: @escaping (Results<Element>?) -> Void){
        
        var result: Results<Element>?
            do {
                let realm = try Realm()
                result = realm.objects(type).filter(condition)
                completionHandler(result)
            } catch let error as NSError {
                print(error)
            }

    }
    

}









