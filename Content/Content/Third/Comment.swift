//
//  Comment.swift
//  Content
//
//  Created by fcn on 2018/10/10.
//  Copyright © 2018年 fcn. All rights reserved.
//

import UIKit
import RealmSwift


class Comment: Object {
    
    //类型名
     @objc dynamic var id = ""
    
    @objc dynamic var username = ""
    @objc dynamic var comment = ""
    @objc dynamic var userid = ""
    @objc dynamic var newsid = ""
    @objc dynamic var datetime = ""
    
    
    override static func primaryKey() -> String? {
        return "id"
    }
    
    
    

}
